<template>
  <base-layout>
    <view class="p-4 bg-gray-100 min-h-screen flex flex-col items-center justify-center">
      <view class="mb-6 text-center">
        <text class="text-2xl font-bold text-primary-500">品牌小程序跳转</text>
      </view>

      <view class="mb-6 px-4 w-full max-w-md bg-white rounded-xl shadow-md p-6">
        <text class="block mb-2 text-text-primary font-semibold">即将跳转到品牌小程序</text>
        <text class="break-all text-text-secondary">{{ miniProgramPath || '无跳转路径参数' }}</text>
      </view>

      <button
        class="bg-primary-500 text-white rounded-full px-8 font-semibold active:scale-95 transition-transform mb-4"
        @click="jumpToMiniProgram"
      >
        跳转品牌小程序
      </button>

      <button
        class="bg-success-500 text-white rounded-full px-8 font-semibold active:scale-95 transition-transform"
        @click="goBack"
      >
        返回上一页
      </button>

      <!-- 弹窗提示 -->
      <uni-popup ref="tipPopup" type="center" :style="{ paddingBottom: '60px' }">
        <view class="bg-white p-6 rounded-xl w-80 flex flex-col items-center">
          <text class="text-lg font-semibold text-primary-600 mb-4">{{ tipMessage }}</text>
          <button
            class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform w-full"
            @click="closeTipPopup"
          >
            确认
          </button>
        </view>
      </uni-popup>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const miniProgramPath = ref('');
const tipPopup = ref(null);
const tipMessage = ref('');

// 接收页面参数
onLoad((option) => {
  if (option.mini_program_path) {
    miniProgramPath.value = option.mini_program_path;
  } else {
    miniProgramPath.value = '';
  }
});

// 跳转品牌小程序
async function jumpToMiniProgram() {
  if (!miniProgramPath.value) {
    tipMessage.value = '跳转路径为空，无法跳转';
    tipPopup.value.open();
    return;
  }

  try {
    // 这里假设有一个小程序跳转API，实际环境中需要替换为对应小程序跳转方法
    // 目前只能使用外部跳转方式模拟
    const res = await proxy.$cf.navigate.to({
      url: miniProgramPath.value,
      type: 'external'
    });
    if (res.success) {
      tipMessage.value = '跳转成功';
    } else {
      tipMessage.value = '跳转失败';
    }
  } catch (error) {
    tipMessage.value = '跳转异常，请稍后重试';
  }
  tipPopup.value.open();
}

// 关闭弹窗
function closeTipPopup() {
  tipPopup.value.close();
}

// 返回上一页
function goBack() {
  proxy.$cf.navigate.back();
}
</script>