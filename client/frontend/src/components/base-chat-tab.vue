<template>
  <view class="chat-bar">

    <textarea
      v-model="inputText"
      :placeholder="placeholder"
      auto-height
      class="chat-textarea"
      @confirm="handleSend"
    />

    <!-- 🚀 动态显示：发送 or tab 功能 -->
    <template v-if="inputText.trim().length > 0">
      <button class="send-btn" :disabled="loading" @click="handleSend">
        <base-icon v-if="!loading" type="arrow-up" size="18" color="#fff" />
        <view v-else class="animate-spin">
          <base-icon type="spinner-cycle" size="16" color="#fff" />
        </view>
      </button>
    </template>

    <template v-else>
      <view class="quick-icons">
        <view
          v-for="(item, idx) in tabList"
          :key="idx"
          class="icon-btn"
          @click="clickTab(item)"
        >
          <base-icon :type="item.icon" size="20" color="#A88BFF" />
        </view>
      </view>
    </template>
  </view>
</template>

<script setup>
import { ref } from "vue";

const inputText = ref("");
const loading = ref(false);
const placeholder = ref("输入您的美容问题…");

// ✅ tab 功能定义
const tabList = [
  { text: "预约", icon: "calendar", path: "/pagesA/appointment/index" },
  { text: "检测", icon: "scan", path: "/pagesA/facedetect/index" },
  { text: "我的", icon: "user", path: "/pagesA/mycenter/index" },
];

// 点击功能 tab
function clickTab(item) {
  uni.navigateTo({ url: item.path });
}

// 模拟语音
function onVoiceInput() {
  console.log("语音输入");
}

// 模拟发送
function handleSend() {
  if (!inputText.value.trim()) return;
  console.log("发送消息:", inputText.value);
  inputText.value = "";
}
</script>

<style scoped>
.chat-bar {
  position: fixed;
  bottom: 60px;
  left: 0;
  right: 0;
  z-index: 99999;
  width: 92%;
  margin: 0 auto;
  display: flex;
  align-items: center;
  background: rgba(255, 255, 255, 0.9);
  border-radius: 50rpx;
  padding: 10rpx 20rpx;
  backdrop-filter: blur(16rpx);
  box-shadow: 0 4rpx 20rpx rgba(255, 182, 193, 0.3);
  gap: 14rpx;
}

.chat-textarea {
  flex: 1;
  font-size: 28rpx;
  background: transparent;
  border: none;
  color: #333;
}

.voice-btn, .send-btn {
  width: 68rpx;
  height: 68rpx;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  border: none;
}

.voice-btn {
  background: linear-gradient(135deg, #FFD6EC, #E5C8FF);
}
.send-btn {
  background: linear-gradient(135deg, #FF6FA0, #A88BFF);
  color: #fff;
}

/* tab图标区 */
.quick-icons {
  display: flex;
  align-items: center;
  gap: 14rpx;
}

.icon-btn {
  width: 60rpx;
  height: 60rpx;
  border-radius: 50%;
  background: linear-gradient(135deg, #f6ecff, #fff3fa);
  display: flex;
  justify-content: center;
  align-items: center;
  box-shadow: 0 3rpx 8rpx rgba(168, 139, 255, 0.2);
  transition: all 0.25s ease;
}
.icon-btn:active {
  transform: scale(0.9);
  background: linear-gradient(135deg, #e9d7ff, #ffe6f3);
}
</style>
