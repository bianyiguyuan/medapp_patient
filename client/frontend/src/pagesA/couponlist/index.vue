<template>
  <base-layout>
    <view class="p-4 min-h-screen bg-white">
      <text class="text-xl font-bold text-primary mb-4">我的优惠券</text>

      <!-- 未使用优惠券列表 -->
      <view v-if="unusedCoupons.length > 0" class="mb-6">
        <text class="text-lg font-semibold text-text-primary mb-2">未使用优惠券</text>
        <view
          v-for="coupon in unusedCoupons"
          :key="coupon.coupon_info_id"
          class="bg-white rounded-xl shadow p-4 mb-4 border-l-4 border-success"
        >
          <text class="text-primary font-semibold text-base block mb-1">优惠金额：¥{{ coupon.amount.toFixed(2) }}</text>
          <text class="text-text-secondary text-sm block">状态：未使用</text>
        </view>
      </view>

      <!-- 已使用优惠券列表 -->
      <view v-if="usedCoupons.length > 0" class="mb-6">
        <text class="text-lg font-semibold text-text-primary mb-2">已使用优惠券</text>
        <view
          v-for="coupon in usedCoupons"
          :key="coupon.coupon_info_id"
          class="bg-white rounded-xl shadow p-4 mb-4 border-l-4 border-neutral-400"
        >
          <text class="text-text-secondary font-semibold text-base block mb-1 line-through">优惠金额：¥{{ coupon.amount.toFixed(2) }}</text>
          <text class="text-text-secondary text-sm block">状态：已使用</text>
        </view>
      </view>

      <!-- 无优惠券提示 -->
      <view v-if="unusedCoupons.length == 0 && usedCoupons.length == 0" class="flex justify-center items-center h-40">
        <text class="text-text-secondary text-base">暂无优惠券</text>
      </view>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const unusedCoupons = ref([]);
const usedCoupons = ref([]);
const loading = ref(false);

// 获取当前登录用户优惠券
async function fetchCoupons() {
  if (loading.value) return;
  loading.value = true;
  try {
    // 获取当前登录用户信息
    const userRes = await proxy.$cf.login.getLoginUser();
    if (!userRes.success || !userRes.data) {
      unusedCoupons.value = [];
      usedCoupons.value = [];
      loading.value = false;
      return;
    }
    const userId = userRes.data.user_info_id;

    // 查询优惠券，区分已使用和未使用
    const res = await proxy.$cf.table.list({
      table_name: 'coupon_info',
      param: { user_info_user_info_id_4: userId }
    });

    if (res.success && Array.isArray(res.data)) {
      // 区分已用和未用
      unusedCoupons.value = res.data.filter(item => !item.is_used);
      usedCoupons.value = res.data.filter(item => item.is_used);
    } else {
      unusedCoupons.value = [];
      usedCoupons.value = [];
      await proxy.$cf.toast({ message: res.message || '获取优惠券失败', level: 'error' });
    }
  } catch (error) {
    unusedCoupons.value = [];
    usedCoupons.value = [];
    await proxy.$cf.toast({ message: '获取优惠券异常', level: 'error' });
  } finally {
    loading.value = false;
  }
}

// 页面加载时获取优惠券
onLoad(() => {
  fetchCoupons();
});
</script>

<style>
/* 不使用space-y-4，使用mb-4实现间距 */
</style>