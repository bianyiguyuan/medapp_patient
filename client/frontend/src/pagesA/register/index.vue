<template>
  <base-layout class="h-full flex flex-col justify-center min-h-screen bg-background px-6">
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
    <view class="relative flex flex-col items-center justify-center flex-1 z-10 min-h-screen max-w-md mx-auto w-full">
      <!-- 顶部logo与欢迎语 -->
      <view class="flex flex-col items-center mb-6">
        <image
          src="https://www.codeflying.net/preview/ai-girl5.jpg"
          class="w-20 h-20 rounded-full shadow-xl mb-3 border-4 border-white ring-4 ring-primary-200 animate-bounce-slow"
          mode="aspectFill"
          alt="logo"
        />
        <text class="text-3xl font-extrabold text-primary-500 mb-1 drop-shadow-lg tracking-wide font-sans">欢迎注册</text>
        <text class="text-base text-text-secondary font-light tracking-wide opacity-90 text-center max-w-xs">请输入手机号或邮箱，完成注册</text>
      </view>

      <!-- 注册表单卡片 -->
      <uni-forms
        :modelValue="formData"
        label-position="top"
        label-width="100%"
        class="bg-white bg-opacity-95 rounded-3xl shadow-2xl py-6 px-6 w-full max-w-md backdrop-blur-lg border border-primary-100"
        ref="registerForm"
      >
        <uni-forms-item required label="手机号" name="phone_number" class="mb-4">
          <uni-easyinput
            type="text"
            placeholder="请输入手机号"
            v-model="formData.phone_number"
            clearable
            maxlength="11"
            @input="onPhoneInput"
          />
        </uni-forms-item>

        <uni-forms-item label="邮箱" name="email" class="mb-4">
          <uni-easyinput
            type="text"
            placeholder="请输入邮箱"
            v-model="formData.email"
            clearable
            @input="onEmailInput"
          />
        </uni-forms-item>

        <uni-forms-item label="用户名" name="username" class="mb-4">
          <uni-easyinput
            type="text"
            placeholder="请输入用户名"
            v-model="formData.username"
            clearable
            @input="onUsernameInput"
          />
        </uni-forms-item>

        <uni-forms-item required label="密码" name="password" class="mb-6">
          <uni-easyinput
            type="password"
            placeholder="请输入密码（至少6位）"
            v-model="formData.password"
            clearable
            @input="onPasswordInput"
          />
        </uni-forms-item>

        <button
          class="w-full bg-primary-500 text-white rounded-full font-semibold shadow hover:bg-primary-600 active:bg-primary-700 transition-colors duration-150"
          @click="submitRegister"
          :disabled="loading"
          :class="{ 'opacity-50 cursor-not-allowed': loading }"
          aria-label="注册按钮"
          type="button"
        >
          {{ loading ? '注册中...' : '注册' }}
        </button>
      </uni-forms>

      <!-- 返回登录入口 -->
      <view class="mt-6 flex flex-col items-center cursor-pointer select-none" @click="goLogin">
        <text class="text-text-secondary mb-1">已有账号？</text>
        <view class="flex items-center justify-center rounded-full px-6 bg-primary-100 hover:bg-primary-200 active:bg-primary-300 transition-colors duration-150">
          <base-icon type="person" size="20" color="#c71585" class="mr-2" />
          <text class="text-primary-600 font-semibold">去登录</text>
        </view>
      </view>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const loading = ref(false);

const formData = ref({
  phone_number: '',
  email: '',
  username: '',
  password: ''
});

function onPhoneInput(value) {
  formData.value.phone_number = value.trim();
}

function onEmailInput(value) {
  formData.value.email = value.trim();
}

function onUsernameInput(value) {
  formData.value.username = value.trim();
}

function onPasswordInput(value) {
  formData.value.password = value;
}

// 简单手机号校验（11位数字）
function validatePhone(phone) {
  return /^1\d{10}$/.test(phone);
}

// 简单邮箱校验
function validateEmail(email) {
  if (!email) return true; // 邮箱非必填，空值通过
  const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return re.test(email);
}

// 密码强度校验，至少6位
function validatePassword(pwd) {
  return pwd && pwd.length >= 6;
}

async function submitRegister() {
  if (loading.value) return;

  // 校验手机号或邮箱必须填写一个
  if (!formData.value.phone_number && !formData.value.email) {
    await proxy.$cf.toast({ message: '手机号或邮箱至少填写一项', level: 'error' });
    return;
  }

  if (formData.value.phone_number && !validatePhone(formData.value.phone_number)) {
    await proxy.$cf.toast({ message: '请输入有效的手机号', level: 'error' });
    return;
  }

  if (!validateEmail(formData.value.email)) {
    await proxy.$cf.toast({ message: '请输入有效的邮箱地址', level: 'error' });
    return;
  }

  if (!validatePassword(formData.value.password)) {
    await proxy.$cf.toast({ message: '密码长度至少6位', level: 'error' });
    return;
  }

  loading.value = true;

  try {
    // 添加用户记录，必填手机号或邮箱，密码，用户名可选
    const param = {
      password: formData.value.password,
    };
    if (formData.value.phone_number) param.phone_number = formData.value.phone_number;
    if (formData.value.email) param.email = formData.value.email;
    if (formData.value.username) param.username = formData.value.username;

    const res = await proxy.$cf.table.add({
      table_name: 'user_info',
      param: param
    });

    if (res.success) {
      await proxy.$cf.toast({ message: '注册成功，请登录', level: 'success' });
      // 跳转登录页
      await proxy.$cf.navigate.to({
        url: '/pages/login/index',
        type: 'page'
      });
    } else {
      await proxy.$cf.toast({ message: res.message || '注册失败', level: 'error' });
    }
  } catch (error) {
    await proxy.$cf.toast({ message: '注册异常，请稍后重试', level: 'error' });
  } finally {
    loading.value = false;
  }
}

function goLogin() {
  proxy.$cf.navigate.to({
    url: '/pages/login/index',
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
</style>