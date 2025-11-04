<template>
  <base-layout class="h-full flex flex-col justify-center min-h-screen bg-white">
    <!-- 背景层 -->
    <view class="absolute inset-0 w-full h-full z-0">
      <image
        src="https://www.codeflying.net/preview/ai-girl5.jpg"
        class="w-full h-full object-cover absolute inset-0 opacity-70"
        mode="aspectFill"
      />
      <view class="absolute inset-0 bg-gradient-to-br from-primary-100 via-secondary-100 to-primary-200 opacity-90 backdrop-blur-xl"></view>
      <view class="absolute top-0 left-0 w-1/2 h-1/3 bg-white opacity-20 rounded-br-3xl blur-2xl shadow-2xl"></view>
      <view class="absolute bottom-0 right-0 w-2/3 h-1/3 bg-primary-100 opacity-20 rounded-tl-3xl blur-2xl shadow-2xl"></view>
    </view>

    <!-- 内容容器 -->
    <view class="relative flex flex-col items-center justify-center flex-1 px-6 z-10 min-h-screen">
      <!-- 顶部logo与欢迎语 -->
      <view class="flex flex-col items-center mb-6">
        <image
          src="https://www.codeflying.net/preview/ai-girl5.jpg"
          class="w-20 h-20 rounded-full shadow-xl mb-3 border-4 border-white ring-4 ring-primary-200 animate-bounce-slow"
          mode="aspectFill"
        />
        <text class="text-3xl font-extrabold text-primary-500 mb-1 drop-shadow-lg tracking-wide font-sans">欢迎登录</text>
        <text class="text-base text-text-secondary font-light tracking-wide opacity-90">请输入手机号或用户名及密码</text>
      </view>

      <!-- 登录表单卡片 -->
      <view class="w-full max-w-md box-border bg-white bg-opacity-95 rounded-3xl shadow-2xl py-6 px-6 mb-4 backdrop-blur-lg border border-primary-100 animate-fade-in">
        <base-login
          login_type="passwd"
          show_title=""
          relevanceTable="user_info"
          @loginSuccess="onLoginSuccess"
          @loginFail="onLoginFail"
        >
          <!-- 自定义登录按钮 -->
          <template #loginButton>
            <button
              class="w-full box-border bg-primary-500 hover:bg-primary-600 text-white font-semibold rounded-full flex items-center justify-center gap-2 shadow transition-all duration-150"
            >
              <base-icon type="locked" size="20" color="#fff" />
              登录
            </button>
          </template>
        </base-login>
      </view>

      <!-- 注册入口 -->
      <view class="w-full flex flex-col items-center mt-2 mb-4">
        <text class="text-sm text-text-secondary mb-2">还没有账号？</text>
        <view
          class="flex flex-col items-center justify-center cursor-pointer select-none py-2"
          style="min-width: 120px;"
          @click="goRegister"
        >
          <base-icon type="personadd" size="32" color="#e26a8d" class="mb-1" />
          <text class="text-base text-primary-500 font-semibold tracking-wide">注册新账号</text>
        </view>
      </view>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

function onLoginSuccess() {
  proxy.$cf.navigate.to({
    url: '/pages/home/index',
    type: 'page'
  });
}

function onLoginFail() {
  proxy.$cf.toast({
    message: '登录失败，请检查账号和密码',
    level: 'error',
    duration: 3000
  });
}

function goRegister() {
  proxy.$cf.navigate.to({
    url: '/pages/register/index',
    type: 'page'
  });
}
</script>

<style scoped>
@keyframes bounce-slow {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-8px); }
}
.animate-bounce-slow {
  animation: bounce-slow 2.8s infinite;
}
@keyframes fade-in {
  from { opacity: 0; transform: translateY(40px); }
  to { opacity: 1; transform: translateY(0); }
}
.animate-fade-in {
  animation: fade-in 0.8s cubic-bezier(.4,0,.2,1) both;
}
::v-deep .uni-easyinput__content.input-focus {
  border-color: #e26a8d !important;
  box-shadow: 0 0 0 2px rgba(226,106,141,0.13);
  background: #f9cbd5 !important;
  transition: border-color 0.2s, box-shadow 0.2s, background 0.2s;
}
</style>