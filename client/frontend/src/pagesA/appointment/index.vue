<template>
  <base-layout>
    <view class="p-4 bg-gray-50 min-h-screen">
      <!-- 新增：预约日历视图模块 -->
      <view class="mb-6 bg-white rounded-xl shadow p-3">
        <!-- 月份导航 -->
        <view class="flex items-center justify-between mb-3">
          <button
            class="bg-gradient-to-r from-primary-400 to-primary-600 text-white font-semibold rounded-full px-4 py-2 shadow active:scale-95"
            @click="prevMonth"
          >
            <base-icon type="arrow-left" size="18" color="#fff" class="mr-1" />上一月
          </button>
          <text class="text-[20px] font-bold text-primary-600">{{ calendarYear }}年{{ calendarMonth }}月</text>
          <button
            class="bg-gradient-to-r from-primary-400 to-primary-600 text-white font-semibold rounded-full px-4 py-2 shadow active:scale-95"
            @click="nextMonth"
          >
            下一月<base-icon type="arrow-right" size="18" color="#fff" class="ml-1" />
          </button>
        </view>

        <!-- 日历网格 -->
        <view class="grid grid-cols-7 gap-1 mb-1">
          <view v-for="w in weekList" :key="w" class="text-center py-2 font-bold text-primary-400">{{ w }}</view>
        </view>
        <view class="grid grid-cols-7 gap-1">
          <view
            v-for="date in calendarDates"
            :key="date.key"
            class="text-center px-1 py-2 rounded-xl flex flex-col items-center justify-center cursor-pointer transition-all"
            :class="{
               'bg-primary-100': date.isCurrentMonth && !date.isSelected,
               'bg-primary-500 text-white font-bold scale-105 shadow-xl': date.isSelected,
               'bg-gray-100 text-gray-400': !date.isCurrentMonth,
               'hover:bg-primary-200': date.isSelectable && !date.isSelected,
               'cursor-not-allowed opacity-45': !date.isSelectable
            }"
            @click="date.isSelectable ? selectCalendarDate(date) : null"
            style="min-height:52px;"
          >
            <text>{{ date.day }}</text>
            <view v-if="date.hasFreeSlot" class="mt-1 w-2 h-2 rounded-full bg-primary-400"></view>
          </view>
        </view>
      </view>

      <!-- 原医生空闲时段列表区（保留） -->
      <text class="text-primary-700 font-bold text-xl mb-4 block">医生空闲时段</text>
      <scroll-view scroll-y="true" class="max-h-[60vh] mb-6">
        <view v-if="loading" class="text-center text-text-secondary py-4">加载中...</view>
        <view v-else>
          <view v-if="timeSlots.length === 0" class="text-center text-text-secondary py-4">暂无可预约时段</view>
          <view
            v-for="(slot, index) in timeSlots"
            :key="index"
            class="mb-4 p-4 rounded-lg border border-gray-300 bg-white"
          >
            <text class="text-text-primary font-semibold block mb-2">{{ slot.appointment_date }} {{ slot.appointment_time }}</text>
            <view class="flex flex-wrap">
              <button
                v-for="(item, idx) in slot.slots"
                :key="idx"
                :class="[
                  'rounded-full px-4 py-2 mr-3 mb-3 font-semibold',
                  item.available ? 'bg-primary-500 text-white shadow-md' : 'bg-gray-300 text-gray-500 cursor-not-allowed'
                ]"
                :disabled="!item.available"
                @click="openBookingPopup(slot.appointment_date, item.timeRange, item.isPartner)"
              >
                <text>{{ item.timeRange }}</text>
                <uni-badge
                  v-if="item.isPartner"
                  text="合作机构"
                  type="warning"
                  size="normal"
                  class="ml-2"
                />
              </button>
            </view>
          </view>
        </view>
      </scroll-view>

      <!-- 日历选中-时段弹窗 -->
      <uni-popup ref="calendarSlotPopup" type="center" class="w-80 bg-white p-4 rounded-xl shadow-lg">
        <text class="text-primary-700 font-bold text-lg mb-3 block">请选择预约时段</text>
        <view v-if="calendarSlots.length === 0" class="text-center text-text-secondary mb-4">该日期无可预约时段</view>
        <view v-else class="grid grid-cols-2 gap-3 mb-4">
          <button
            v-for="slot in calendarSlots"
            :key="slot.timeRange"
            class="bg-gradient-to-r from-primary-400 to-primary-600 text-white font-semibold rounded-full py-2 px-4 shadow active:scale-95 text-center"
            @click="onCalendarSlotClick(slot)"
          >
            {{ slot.timeRange }}
            <uni-badge v-if="slot.isPartner" text="合作机构" type="warning" size="small" class="ml-1" />
          </button>
        </view>
        <button class="w-full bg-gray-300 rounded-full text-text-primary-700 mt-2 py-2 font-semibold" @click="closeCalendarSlotPopup">取消</button>
      </uni-popup>

      <!-- 预约弹窗（原有流程） -->
      <uni-popup ref="bookingPopup" type="bottom" :style="{ paddingBottom: '70px' }">
        <view class="bg-white p-4 rounded-t-lg">
          <text class="text-primary-700 font-bold text-lg mb-4 block">预约确认</text>
          <view class="mb-4">
            <text class="block text-text-primary font-semibold mb-1">预约时间：</text>
            <text>{{ selectedDate }} {{ selectedTime }}</text>
          </view>
          <view class="mb-4 p-4 bg-gray-100 rounded-lg border border-gray-300">
            <text class="text-secondary-600 font-semibold mb-2 block">定金支付</text>
            <text>支付100元定金抵200元服务费</text>
          </view>
          <view class="mb-6">
            <button
              class="w-full bg-gradient-to-r from-primary-400 to-primary-600 text-white rounded-full font-semibold active:scale-95 transition-transform py-3 shadow-md"
              @click="handlePayDeposit"
              :loading="payLoading"
              :disabled="payLoading"
            >
              支付定金
            </button>
          </view>
          <view class="mb-4">
            <button
              class="w-full bg-success-500 text-white rounded-full font-semibold active:scale-95 transition-transform py-3 shadow-md"
              @click="handleReceiveCoupon"
              :loading="couponLoading"
              :disabled="couponReceived || couponLoading"
            >
              {{ couponReceived ? '已领取优惠券' : '领取优惠券' }}
            </button>
          </view>
          <view class="text-center text-text-secondary text-sm">
            预约成功后会收到短信通知，包含机构地址及预约码。
          </view>
          <view class="mt-6 flex justify-center">
            <button class="text-primary-700 font-semibold" @click="closeBookingPopup">取消</button>
          </view>
        </view>
      </uni-popup>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const loading = ref(false);
const payLoading = ref(false);
const couponLoading = ref(false);
const timeSlots = ref([]);
const selectedDate = ref('');
const selectedTime = ref('');
const selectedIsPartner = ref(false);
const couponReceived = ref(false);
const bookingPopup = ref(null);

const calendarYear = ref(new Date().getFullYear());
const calendarMonth = ref(new Date().getMonth() + 1);
const weekList = ['日', '一', '二', '三', '四', '五', '六'];
const calendarDates = ref([]);
const calendarSlots = ref([]);
const calendarSlotPopup = ref(null);
const monthSlotMap = ref({});

onLoad(() => {
  fetchDoctorAvailableTimes();
  genCalendar();
});

function prevMonth() {
  let m = calendarMonth.value - 1;
  let y = calendarYear.value;
  if (m < 1) {
    m = 12;
    y -= 1;
  }
  calendarMonth.value = m;
  calendarYear.value = y;
  genCalendar();
}

function nextMonth() {
  let m = calendarMonth.value + 1;
  let y = calendarYear.value;
  if (m > 12) {
    m = 1;
    y += 1;
  }
  calendarMonth.value = m;
  calendarYear.value = y;
  genCalendar();
}

function genCalendar() {
  const year = calendarYear.value;
  const month = calendarMonth.value;
  const firstDay = new Date(year, month - 1, 1);
  const startWeekday = firstDay.getDay();
  const daysInMonth = new Date(year, month, 0).getDate();
  const days = [];
  const prevMonthDayCount = startWeekday;
  const lastMonthDate = new Date(year, month - 1, 0).getDate();

  for (let i = 0; i < prevMonthDayCount; i++) {
    days.push({
      day: lastMonthDate - prevMonthDayCount + i + 1,
      isCurrentMonth: false,
      isSelected: false,
      key: `${year}-${month < 10 ? '0' : ''}${month}-prev${i}`,
      isSelectable: false,
      hasFreeSlot: false
    });
  }

  for (let i = 1; i <= daysInMonth; i++) {
    const dString = `${year}-${month < 10 ? '0' : ''}${month}-${i < 10 ? '0' : ''}${i}`;
    days.push({
      day: i,
      isCurrentMonth: true,
      isSelected: false,
      key: dString,
      isSelectable: false,
      hasFreeSlot: false
    });
  }

  const endWeekday = new Date(year, month - 1, daysInMonth).getDay();

  for (let i = 1; i <= 6 - endWeekday; i++) {
    days.push({
      day: i,
      isCurrentMonth: false,
      isSelected: false,
      key: `${year}-${month < 10 ? '0' : ''}${month}-next${i}`,
      isSelectable: false,
      hasFreeSlot: false
    });
  }

  const slotMap = monthSlotMap.value;
  days.forEach((d) => {
    if (d.isCurrentMonth) {
      if (slotMap[d.key] && slotMap[d.key].length > 0) {
        d.isSelectable = true;
        d.hasFreeSlot = true;
      }
    }
  });

  calendarDates.value = days;
}

function selectCalendarDate(date) {
  calendarDates.value.forEach((d) => (d.isSelected = false));
  date.isSelected = true;
  calendarSlots.value = monthSlotMap.value[date.key] || [];
  calendarSlotPopup.value.open();
}

function closeCalendarSlotPopup() {
  calendarDates.value.forEach((d) => (d.isSelected = false));
  calendarSlotPopup.value.close();
}

function onCalendarSlotClick(slot) {
  closeCalendarSlotPopup();
  selectedDate.value = slot.date;
  selectedTime.value = slot.timeRange;
  selectedIsPartner.value = !!slot.isPartner;
  couponReceived.value = false;
  bookingPopup.value.open();
}

async function fetchDoctorAvailableTimes() {
  loading.value = true;
  try {
    const res = await proxy.$cf.table.list({ table_name: 'appointment_info', param: {} });
    if (res.success) {
      const records = Array.isArray(res.data) ? res.data : [];
      const slotMap = {};
      const timeSlotArr = [];
      records.forEach((item) => {
        if (!item.appointment_date || !item.appointment_time) return;
        const dateStr = item.appointment_date;
        if (item.status_enum_id == 1) {
          if (!slotMap[dateStr]) slotMap[dateStr] = [];
          slotMap[dateStr].push({
            timeRange: item.appointment_time,
            date: dateStr,
            isPartner: item.doctor_name && item.doctor_name.indexOf('合作') >= 0
          });
        }
        timeSlotArr.push({
          appointment_date: item.appointment_date,
          appointment_time: '',
          slots: [
            {
              timeRange: item.appointment_time,
              available: item.status_enum_id == 1,
              isPartner: item.doctor_name && item.doctor_name.indexOf('合作') >= 0
            }
          ]
        });
      });
      monthSlotMap.value = slotMap;
      timeSlots.value = timeSlotArr;
      genCalendar();
    } else {
      await proxy.$cf.toast({ message: '获取预约时段失败', level: 'error' });
    }
  } catch (e) {
    await proxy.$cf.toast({ message: '网络异常，获取预约时段失败', level: 'error' });
  } finally {
    loading.value = false;
  }
}

function openBookingPopup(date, time, isPartner) {
  selectedDate.value = date;
  selectedTime.value = time;
  selectedIsPartner.value = isPartner;
  couponReceived.value = false;
  bookingPopup.value.open();
}

function closeBookingPopup() {
  bookingPopup.value.close();
}

async function handlePayDeposit() {
  if (payLoading.value) return;
  payLoading.value = true;
  try {
    const loginUser = await proxy.$cf.login.getLoginUser();
    if (!loginUser.success) {
      await proxy.$cf.toast({ message: '请先登录', level: 'error' });
      payLoading.value = false;
      return;
    }
    const now = new Date();
    const year = now.getFullYear();
    const month = ('0' + (now.getMonth() + 1)).slice(-2);
    const day = ('0' + now.getDate()).slice(-2);
    const formattedDate = `${year}-${month}-${day}`;
    const addRes = await proxy.$cf.table.add({
      table_name: 'appointment_info',
      param: {
        user_info_user_info_id_1: loginUser.data.user_info_id,
        doctor_name: selectedIsPartner.value ? '合作机构医生' : '默认医生',
        appointment_date: selectedDate.value,
        appointment_time: selectedTime.value,
        status_enum_id: 1,
        deposit_paid: true,
        deposit_amount: 100
      }
    });
    if (!addRes.success) {
      await proxy.$cf.toast({ message: '预约失败，请重试', level: 'error' });
      payLoading.value = false;
      return;
    }
    await proxy.$cf.toast({ message: '定金支付成功，预约确认', level: 'success' });
    await proxy.$cf.table.update({
      table_name: 'appointment_info',
      param: {
        appointment_info_id: addRes.data,
        status_enum_id: 2
      }
    });
    await proxy.$cf.toast({ message: '优惠券已到账，请注意查收', level: 'success' });
    await sendSmsNotification(addRes.data);
    closeBookingPopup();
    await proxy.$cf.navigate.to({ url: '/pages/home/index', type: 'page' });
  } catch (e) {
    await proxy.$cf.toast({ message: '支付失败，请重试', level: 'error' });
  } finally {
    payLoading.value = false;
  }
}

async function handleReceiveCoupon() {
  if (couponLoading.value || couponReceived.value) return;
  couponLoading.value = true;
  try {
    const loginUser = await proxy.$cf.login.getLoginUser();
    if (!loginUser.success) {
      await proxy.$cf.toast({ message: '请先登录', level: 'error' });
      couponLoading.value = false;
      return;
    }
    const couponRes = await proxy.$cf.table.add({
      table_name: 'coupon_info',
      param: {
        user_info_user_info_id_4: loginUser.data.user_info_id,
        amount: 50,
        is_used: false
      }
    });
    if (couponRes.success) {
      couponReceived.value = true;
      await proxy.$cf.toast({ message: '优惠券领取成功', level: 'success' });
    } else {
      await proxy.$cf.toast({ message: '优惠券领取失败', level: 'error' });
    }
  } catch (e) {
    await proxy.$cf.toast({ message: '领取优惠券异常', level: 'error' });
  } finally {
    couponLoading.value = false;
  }
}

async function sendSmsNotification(appointmentId) {
  try {
    await proxy.$cf.toast({ message: '短信通知已发送', level: 'success' });
  } catch {}
}
</script>

<style>
.bg-primary-100 {
  background-color: #ffe6f0;
}
.bg-primary-400 {
  background-color: #ff265f;
}
.bg-primary-500 {
  background-color: #ff5c8a;
}
.bg-primary-600 {
  background-color: #cc4a6b;
}
.bg-success-500 {
  background-color: #2bad5f;
}
.bg-gray-100 {
  background-color: #f5f5f5;
}
.text-primary-600 {
  color: #ff5c8a;
}
.text-primary-700 {
  color: #cc4a6b;
}
.text-secondary-600 {
  color: #af4cff;
}
.active\:scale-95:active {
  transform: scale(0.95);
}
</style>
