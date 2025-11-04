<template>
  <base-layout>
    <view class="p-4 min-h-screen bg-white">
      <!-- 标题 -->
      <view class="mb-4">
        <text class="text-2xl font-bold text-primary-700">我的订单</text>
      </view>

      <!-- 订单状态筛选 -->
      <view class="mb-4 bg-white rounded-xl shadow p-3 flex flex-col">
        <text class="mb-2 text-text-primary-700 font-semibold">筛选订单状态</text>
        <uni-data-select
          v-model="selectedStatus"
          :localdata="statusOptions"
          clear
          placement="bottom"
          placeholder="请选择订单状态"
          @change="onStatusChange"
          class="w-full"
        />
      </view>

      <!-- 订单列表 -->
      <view v-if="orders.length > 0" class="flex flex-col">
        <view
          v-for="order in orders"
          :key="order.order_info_id"
          class="mb-4 bg-white rounded-xl shadow p-4 cursor-pointer"
          @click="goToOrderDetail(order.order_info_id)"
        >
          <view class="flex flex-col mb-2">
            <text class="text-lg font-semibold text-text-primary-700 truncate">{{ order.product_name || '未知商品' }}</text>
            <text class="text-sm text-text-secondary-600 mt-1">数量: {{ order.quantity }}</text>
            <text class="text-sm text-text-secondary-600 mt-1">总价: ¥{{ order.total_price.toFixed(2) }}</text>
          </view>

          <view class="flex flex-col mb-2">
            <text class="text-sm text-text-secondary-700 mb-1">订单状态:</text>
            <uni-tag
              :text="order.status_name"
              size="normal"
              :type="getStatusTagType(order.status_name)"
              circle
              class="w-max"
            />
          </view>

          <view class="flex flex-col">
            <text class="text-sm text-text-secondary-600">购买时间: {{ formatDateTime(order.create_time) }}</text>
          </view>
        </view>

        <!-- 加载更多按钮 -->
        <view v-if="hasMore" class="flex justify-center mb-6">
          <button
            class="bg-primary-500 text-white rounded-full px-8 font-semibold active:scale-95 transition-transform"
            :disabled="loading"
            @click="loadMore"
          >
            <text v-if="loading">加载中...</text>
            <text v-else>加载更多</text>
          </button>
        </view>
      </view>

      <!-- 空状态 -->
      <view v-else class="flex flex-col items-center justify-center py-24">
        <base-icon type="cart" size="60" color="#ccc" />
        <text class="text-text-secondary-500 mt-4 text-base font-semibold">暂无订单数据</text>
      </view>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const orders = ref([]);
const statusOptions = ref([{ value: '', text: '全部状态' }]);
const selectedStatus = ref('');
const page = ref(1);
const pageSize = 10;
const hasMore = ref(true);
const loading = ref(false);
const loginUser = ref(null);

// 页面初始化
onLoad(async () => {
  await fetchLoginUser();
  await fetchStatusOptions();
  await fetchOrders(true);
});

// 获取当前登录用户信息
async function fetchLoginUser() {
  const res = await proxy.$cf.login.getLoginUser();
  if (res.success && res.data) {
    loginUser.value = res.data;
  }
}

// 获取订单状态选项
async function fetchStatusOptions() {
  const res = await proxy.$cf.table.list({
    table_name: 'order_status_enum',
    param: {}
  });
  if (res.success) {
    statusOptions.value = [{ value: '', text: '全部状态' }, ...res.data.map(item => ({
      value: item.order_status_enum_id,
      text: item.status_name
    }))];
  }
}

// 获取订单列表
async function fetchOrders(reset = false) {
  if (loading.value) return;
  if (!loginUser.value) return;

  loading.value = true;

  if (reset) {
    page.value = 1;
    orders.value = [];
    hasMore.value = true;
  }

  const param = {
    current: page.value,
    pageSize: pageSize,
    user_info_user_info_id_5: loginUser.value.user_info_id,
  };

  if (selectedStatus.value) {
    param.order_status_enum_id = selectedStatus.value;
  }

  // 按创建时间降序排序
  param.order_by = { create_time: 'desc' };

  const res = await proxy.$cf.table.page({
    table_name: 'order_info',
    param
  });

  if (res.success) {
    if (reset) {
      orders.value = res.data.records;
    } else {
      orders.value = orders.value.concat(res.data.records);
    }
    hasMore.value = orders.value.length < res.data.total;
  } else {
    proxy.$cf.toast({ message: res.message || '获取订单失败', level: 'error' });
  }

  loading.value = false;
}

// 订单状态标签类型映射
function getStatusTagType(statusName) {
  if (!statusName) return 'default';
  if (statusName == '待支付') return 'warning';
  if (statusName == '已支付') return 'success';
  if (statusName == '已取消') return 'error';
  return 'default';
}

// 订单状态筛选变化
function onStatusChange() {
  fetchOrders(true);
}

// 加载更多
function loadMore() {
  if (hasMore.value && !loading.value) {
    page.value += 1;
    fetchOrders(false);
  }
}

// 跳转订单详情页面
function goToOrderDetail(orderId) {
  proxy.$cf.navigate.to({
    url: `/pages/order_detail/index?order_info_id=${orderId}`,
    type: 'page'
  });
}

// 格式化时间 YYYY-MM-DD HH:mm:ss
function formatDateTime(dt) {
  if (!dt) return '--';
  const d = new Date(dt.replace(/-/g, '/'));
  const y = d.getFullYear();
  const m = ('0' + (d.getMonth() + 1)).slice(-2);
  const day = ('0' + d.getDate()).slice(-2);
  const h = ('0' + d.getHours()).slice(-2);
  const min = ('0' + d.getMinutes()).slice(-2);
  const s = ('0' + d.getSeconds()).slice(-2);
  return `${y}-${m}-${day} ${h}:${min}:${s}`;
}
</script>

<style>
/* 自定义样式，避免space-y-4，使用margin-bottom替代 */
</style>