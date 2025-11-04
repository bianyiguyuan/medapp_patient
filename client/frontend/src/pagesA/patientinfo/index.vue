<template>
  <base-layout>
    <scroll-view class="p-4 bg-gray-100 min-h-screen" refresher-enabled @refresherrefresh="onRefresh" :refresher-triggered="refreshing">
      <view class="bg-white rounded-xl shadow p-4 mb-4">
        <text class="text-lg font-bold text-text-primary mb-4">患者信息填写</text>
        <uni-forms ref="patientFormRef" :modelValue="formData" label-position="top" label-width="100%">
          <uni-forms-item required label="肤质" name="skin_type" class="mb-4">
            <uni-data-select
              v-model="formData.skin_type"
              :localdata="skinTypeOptions"
              clear
              placement="bottom"
              placeholder="请选择肤质"
            />
          </uni-forms-item>

          <uni-forms-item required label="年龄" name="age" class="mb-4">
            <uni-easyinput
              type="number"
              v-model="formData.age"
              placeholder="请输入年龄"
              clearable
            />
          </uni-forms-item>

          <uni-forms-item label="备注" name="remark" class="mb-4">
            <uni-easyinput
              type="textarea"
              v-model="formData.remark"
              placeholder="可填写其他信息"
              clearable
              rows="3"
            />
          </uni-forms-item>

          <button
            class="w-full bg-primary-500 text-white rounded-full font-semibold"
            @click="submitForm"
          >
            提交信息
          </button>
        </uni-forms>
      </view>

      <!-- 完成页 -->
      <uni-popup ref="completePopup" type="center" class="z-50 p-4" @close="onCompletePopupClose">
        <view class="bg-white rounded-xl p-4 max-w-md mx-auto">
          <text class="text-xl font-bold text-text-primary mb-4 block text-center">信息采集完成</text>
          <text class="text-text-secondary mb-4 block text-center">感谢您的填写，以下是为您推荐的品牌商品及优惠券金额：</text>

          <scroll-view scroll-x="true" class="mb-4 whitespace-nowrap">
            <view
              v-for="product in recommendedProducts"
              :key="product.product_info_id"
              class="inline-block bg-white bg-opacity-75 rounded-xl shadow p-3 mr-4 w-48"
            >
              <image
                :src="get_resource_url(product.image?.[0]?.url || '')"
                mode="aspectFill"
                class="w-full h-32 rounded-lg mb-2"
              />
              <text class="block text-text-primary font-semibold truncate mb-1" :title="product.product_name">{{ product.product_name }}</text>
              <text class="block text-primary-600 font-bold mb-1">￥{{ product.price.toFixed(2) }}</text>
              <text class="block text-danger font-bold mb-2" v-if="product.coupon_amount">优惠券金额：￥{{ product.coupon_amount.toFixed(2) }}</text>
              <button
                class="w-full bg-success-500 text-white rounded-full font-semibold"
                @click="goToBrandMiniProgram(product.mini_program_path)"
              >
                去购买
              </button>
            </view>
          </scroll-view>

          <button
            class="w-full bg-primary-500 text-white rounded-full font-semibold"
            @click="closeCompletePopup"
          >
            关闭
          </button>
        </view>
      </uni-popup>
    </scroll-view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const formData = ref({
  skin_type: '',
  age: '',
  remark: '',
});

const skinTypeOptions = [
  { value: '干性', text: '干性' },
  { value: '油性', text: '油性' },
  { value: '混合性', text: '混合性' },
  { value: '敏感性', text: '敏感性' },
  { value: '中性', text: '中性' },
];

const recommendedProducts = ref([]);

const patientFormRef = ref(null);
const completePopup = ref(null);

const refreshing = ref(false);

function get_resource_url(path) {
  return proxy.get_resource_url(path);
}

async function submitForm() {
  if (!formData.value.skin_type) {
    await proxy.$cf.toast({ message: '请选择肤质', level: 'error' });
    return;
  }
  if (!formData.value.age || isNaN(formData.value.age) || formData.value.age <= 0) {
    await proxy.$cf.toast({ message: '请输入有效年龄', level: 'error' });
    return;
  }

  // 模拟提交患者信息，实际应提交到患者信息表，这里仅示范提交到product_info表是不合理的，但因无其他表，暂不提交数据库
  // 这里直接调用完成页弹窗展示推荐商品

  await loadRecommendedProducts();

  completePopup.value.open();
}

async function loadRecommendedProducts() {
  // 调用接口获取品牌商品列表
  const res = await proxy.$cf.table.list({
    table_name: 'product_info',
    param: {},
  });
  if (res.success) {
    recommendedProducts.value = res.data;
  } else {
    recommendedProducts.value = [];
    await proxy.$cf.toast({ message: '加载推荐商品失败', level: 'error' });
  }
}

function closeCompletePopup() {
  completePopup.value.close();
  // 提交完成后可重置表单或跳转，需求未明确，暂不跳转
}

function goToBrandMiniProgram(miniProgramPath) {
  if (!miniProgramPath) {
    proxy.$cf.toast({ message: '品牌小程序路径无效', level: 'error' });
    return;
  }
  // 跳转品牌小程序，参数为路径
  proxy.$cf.navigate.to({
    url: `/pages/brandminiprogram/index?mini_program_path=${encodeURIComponent(miniProgramPath)}`,
    type: 'page',
  });
}

function onRefresh() {
  refreshing.value = true;
  loadRecommendedProducts().finally(() => {
    refreshing.value = false;
  });
}

function onCompletePopupClose() {
  // 关闭时清空推荐商品列表
  recommendedProducts.value = [];
}
</script>

<style>
.text-danger {
  color: #e6001b;
}
</style>