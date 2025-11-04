<template>
  <base-layout>
    <view class="p-4 bg-gray-50 min-h-screen">
      <!-- 会员信息展示 -->
      <view class="bg-white rounded-xl shadow p-4 mb-4">
        <view class="flex flex-col items-start">
          <view class="flex items-center mb-2">
            <base-icon type="vip" size="24" color="#ffd700" />
            <text class="ml-2 text-xl font-semibold text-text-primary-900 flex-shrink truncate">
              {{ memberLevelName || '普通会员' }}
            </text>
            <base-icon
              v-if="isMember"
              type="medal"
              size="20"
              color="#ffd700"
              class="ml-1"
            />
          </view>
          <view class="mb-2 w-full">
            <text class="text-text-secondary-700">检测次数：</text>
            <text class="font-semibold text-text-primary-900">{{ detectionCount }}</text>
          </view>
          <view class="mb-4 w-full">
            <text class="text-text-secondary-700">有效期：</text>
            <text class="font-semibold text-text-primary-900">{{ membershipValidPeriod || '无' }}</text>
          </view>
          <button
            class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform"
            @click="handleRenewMembership"
          >
            续费优惠
          </button>
        </view>
      </view>

      <!-- 功能区网格 -->
      <view class="bg-white rounded-xl shadow p-4">
        <view class="flex flex-col">
          <!-- 未开通会员提示 -->
          <view v-if="!isMember" class="mb-4 p-4 bg-success-100 rounded text-success-700 text-center font-semibold">
            您还不是会员，开通会员享更多特权！
          </view>

          <view class="grid grid-cols-2 gap-4">
            <!-- 订单 -->
            <button
              class="flex flex-col items-center justify-center bg-white rounded-lg shadow-md p-4 active:scale-95 transition-transform"
              @click="goToOrderList"
            >
              <base-icon type="cart" size="36" color="#c71585" />
              <text class="mt-2 text-primary-600 font-semibold">订单</text>
            </button>

            <!-- 分销中心 -->
            <button
              class="flex flex-col items-center justify-center bg-white rounded-lg shadow-md p-4 active:scale-95 transition-transform"
              @click="goToDistribution"
            >
              <base-icon type="gift" size="36" color="#ff7f50" />
              <text class="mt-2 text-secondary-600 font-semibold">分销中心</text>
            </button>

            <!-- 优惠券 -->
            <button
              class="flex flex-col items-center justify-center rounded-lg p-4 active:scale-95 transition-transform"
              :style="couponButtonStyle"
              @click="goToCouponList"
            >
              <base-icon type="wallet" size="36" color="#2bad5f" />
              <text class="mt-2 font-semibold text-white">优惠券</text>
            </button>

            <!-- 会员权益 -->
            <button
              class="flex flex-col items-center justify-center bg-white rounded-lg shadow-md p-4 active:scale-95 transition-transform"
              @click="goToMembership"
            >
              <base-icon type="vip" size="36" color="#ffd700" />
              <text class="mt-2 text-accent-600 font-semibold">会员权益</text>
            </button>
          </view>
        </view>
      </view>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const memberLevelName = ref('');
const detectionCount = ref(0);
const membershipValidPeriod = ref('');
const isMember = ref(false);

// 优惠券按钮渐变背景样式
const couponButtonStyle = `
  background: linear-gradient(135deg, #54c47f 0%, #2bad5f 100%);
  box-shadow: 0 4px 6px rgba(43, 173, 95, 0.4);
  color: white;
  border-radius: 0.5rem;
  padding: 1rem 0;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;

// 格式化日期
function formatDate(dateStr) {
  if (!dateStr) return '';
  const date = new Date(dateStr);
  const y = date.getFullYear();
  const m = ('0' + (date.getMonth() + 1)).slice(-2);
  const d = ('0' + date.getDate()).slice(-2);
  return `${y}-${m}-${d}`;
}

async function fetchUserInfo() {
  const res = await proxy.$cf.login.getLoginUser();
  if (res.success && res.data) {
    const user = res.data;
    memberLevelName.value = user.level_name || '普通会员';
    detectionCount.value = user.detection_count || 0;
    membershipValidPeriod.value = user.membership_valid_period
      ? formatDate(user.membership_valid_period)
      : '无';
    isMember.value = !!user.member_level_id && user.member_level_id > 1;
  }
}

function handleRenewMembership() {
  proxy.$cf.toast({ message: '续费功能即将为您实现', level: 'none' });
}

function goToOrderList() {
  proxy.$cf.navigate.to({ url: '/pages/orderlist/index', type: 'page' });
}

function goToDistribution() {
  proxy.$cf.navigate.to({ url: '/pages/distribution/index', type: 'page' });
}

function goToCouponList() {
  proxy.$cf.navigate.to({ url: '/pages/couponlist/index', type: 'page' });
}

function goToMembership() {
  proxy.$cf.navigate.to({ url: '/pages/membership/index', type: 'page' });
}

onLoad(() => {
  fetchUserInfo();
});
</script>

<style>
/* 会员等级文字和皇冠图标间距 */
.text-primary-900 {
  color: #333333;
}

.text-text-secondary-700 {
  color: #666666;
}

.text-primary-600 {
  color: #df358f;
}

.text-accent-600 {
  color: #ffd700;
}

.text-success-700 {
  color: #2bad5f;
}

.bg-success-100 {
  background-color: #d8f0e1;
}

button:active {
  background-color: #a00c5d !important;
  border-color: #a00c5d !important;
}

/* 解决按钮悬浮和点击颜色 */
button:hover {
  background-color: #b30e6e !important;
  border-color: #b30e6e !important;
}
</style>