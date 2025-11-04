<template>
  <base-layout>
    <view class="min-h-screen flex flex-col p-4 bg-gray-50">
      <!-- 标题 -->
      <view class="mb-4">
        <text class="text-2xl font-extrabold text-primary-600">智能问答</text>
      </view>

      <!-- 输入区 -->
      <view class="mb-4">
        <uni-easyinput
          v-model="inputText"
          type="text"
          placeholder="请输入您的问题..."
          clearable
          :disabled="loading"
          @confirm="handleSend"
          class="box-border w-full border border-gray-300 rounded-md px-3 py-2 text-text-primary-700"
        />
      </view>

      <!-- 发送按钮 -->
      <view class="mb-4">
        <button
          @click="handleSend"
          :disabled="loading || !inputText.trim()"
          class="w-full bg-primary-500 text-white font-semibold rounded-full"
          :class="{'opacity-50 cursor-not-allowed': loading || !inputText.trim()}"
        >
          {{ loading ? '回复中...' : '发送' }}
        </button>
      </view>

      <!-- 回复区域 -->
      <scroll-view
        scroll-y
        class="flex-1 mb-4"
        :scroll-into-view="lastMsgAnchor"
        style="max-height: 40vh;"
      >
        <view v-for="(msg, idx) in chatList" :key="idx" class="mb-4">
          <view
            :class="msg.role == 'user' ? 'text-right' : 'text-left'"
            class="break-words"
          >
            <view
              class="inline-block rounded-xl p-3"
              :class="msg.role == 'user' ? 'bg-primary-100 text-primary-800' : 'bg-gray-100 text-text-primary-800'"
              style="max-width: 80vw;"
            >
              <text>{{ msg.text }}</text>
            </view>
          </view>
        </view>
        <view :id="lastMsgAnchor"></view>
      </scroll-view>

      <!-- 品牌推荐和优惠券入口 -->
      <view v-if="brandRecommendation" class="mb-4 p-4 bg-white rounded-lg shadow-md border border-gray-200">
        <text class="text-lg font-semibold text-primary-700 mb-2">品牌推荐</text>
        <view class="mb-2">
          <text class="text-text-primary-800">{{ brandRecommendation }}</text>
        </view>
        <button
          @click="onCouponClick"
          class="bg-success-500 text-white font-semibold rounded-full px-4"
        >
          领取优惠券
        </button>
      </view>

      <!-- 合作机构列表 -->
      <view class="mb-4">
        <text class="text-lg font-semibold text-primary-700 mb-2">合作机构</text>
        <scroll-view scroll-y style="max-height: 30vh;">
          <view v-for="(org, index) in partnerList" :key="index" class="mb-4 p-3 bg-white rounded-lg shadow-sm border border-gray-200">
            <view class="mb-1">
              <text class="font-semibold text-text-primary-900">{{ org.name }}</text>
              <view v-if="org.isMemberOnly" class="inline-block ml-2 px-2 py-0.5 rounded text-accent-500 font-bold text-xs border border-accent-500">
                会员专属
              </view>
            </view>
            <view class="mb-1 text-text-secondary-700">
              <text>评分: {{ org.rating }} </text>
              <text>距离: {{ org.distance }}km </text>
              <text>优惠: {{ org.discount }}</text>
            </view>
          </view>
        </scroll-view>
      </view>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const inputText = ref('');
const loading = ref(false);
const chatList = ref([
  {
    role: 'assistant',
    text: '您好！我是您的智能问答助手，请输入您的问题。',
  },
]);
const lastMsgAnchor = ref('last-msg');

const brandRecommendation = ref('');
const partnerList = ref([
  {
    name: '合作机构A',
    rating: 4.8,
    distance: 1.2,
    discount: '满100减20',
    isMemberOnly: true,
  },
  {
    name: '合作机构B',
    rating: 4.5,
    distance: 3.5,
    discount: '满200减50',
    isMemberOnly: false,
  },
  {
    name: '合作机构C',
    rating: 4.7,
    distance: 5.1,
    discount: '无门槛优惠券',
    isMemberOnly: true,
  },
]);

async function handleSend() {
  if (loading.value) return;
  const question = inputText.value.trim();
  if (!question) return;

  // 添加用户消息
  chatList.value.push({
    role: 'user',
    text: question,
  });

  inputText.value = '';
  loading.value = true;
  lastMsgAnchor.value = 'last-msg';

  try {
    // 调用智能问答接口
    const prompt =
      '角色：你是一个智能问答助手。任务：回答用户的问题，包含品牌推荐和优惠券入口。输出：直接回答，简洁明了。';
    const res = await proxy.$cf.ai.text2text({
      prompt,
      text: question,
      conversation_id: '',
    });

    if (res.success && res.data && res.data.answer) {
      chatList.value.push({
        role: 'assistant',
        text: res.data.answer,
      });

      // 模拟品牌推荐和优惠券展示逻辑
      brandRecommendation.value =
        '推荐品牌：美丽肌肤护肤套装，立减20元优惠券，限时领取！';
    } else {
      chatList.value.push({
        role: 'assistant',
        text: '抱歉，未能获取到有效回复，请稍后再试。',
      });
    }
  } catch (error) {
    chatList.value.push({
      role: 'assistant',
      text: '抱歉，网络异常，请检查您的网络连接。',
    });
  } finally {
    loading.value = false;
    lastMsgAnchor.value = 'last-msg';
  }
}

function onCouponClick() {
  proxy.$cf.toast({
    message: '优惠券已发送到您的账户，请前往“我的优惠券”查看。',
    level: 'success',
  });
}
</script>

<style scoped>
/* 文字颜色变量 */
.text-primary-600 {
  color: #df358f;
}
.text-primary-500 {
  color: #df358f;
}
.text-primary-800 {
  color: #b5276f;
}
.text-success-500 {
  color: #2bad5f;
}
.text-accent-500 {
  color: #ffd700;
}
.text-text-primary-700 {
  color: #333333;
}
.text-text-primary-800 {
  color: #333333;
}
.text-text-secondary-700 {
  color: #666666;
}
.text-text-primary-900 {
  color: #222226;
}

/* 按钮样式 */
button {
  padding-top: 0.5rem;
  padding-bottom: 0.5rem;
  padding-left: 1rem;
  padding-right: 1rem;
}
button:disabled {
  opacity: 0.5;
  cursor: not-allowed;
}
</style>