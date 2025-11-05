<template>
  <base-layout>
    <view class="chat-wrapper relative">
      <scroll-view
        scroll-y
        class="chat-scroll card-bg"
        :scroll-into-view="lastMsgAnchor"
        refresher-enabled
      >
        <view class="chat-container">

          <!-- 🌸 固定AI头像 + 毛玻璃层 -->
          <view class="ai-header-fixed">
            <view class="ai-header-blur"></view>

            <view class="ai-avatar-fixed animate-avatar-bounce">
              <view class="ai-avatar-frame">
                <view class="ai-avatar-flash"></view> 
                <image
                  src="https://www.codeflying.net/preview/ai-girl3.jpg"
                  class="ai-avatar-img ai-eyeblink"
                  mode="aspectFill"
                />
              </view>
              <text class="ai-title">求美小天才</text>
            </view>
          </view>



          <!-- 🌸 欢迎示例 -->
          <view v-if="showWelcomeExamples" class="welcome-block">
            <text
              v-for="(ex, idx) in exampleQuestions"
              :key="idx"
              class="welcome-item animate-fadein"
              @click="clickExample(ex)"
            >
              {{ ex }}
            </text>
          </view>

          <!-- 💬 聊天区 -->
          <view v-if="messages.length" class="flex flex-col gap-3 min-h-[60vh] pb-10">
            <view v-for="(msg, idx) in messages" :key="idx">
              <template v-if="msg.role === 'user'">
                <view class="msg-user animate-bubblein">
                  <view class="bubble-user">{{ msg.text }}</view>
                </view>
              </template>
              <template v-else>
                <view class="msg-ai animate-bubblein">
                  <view class="bubble-ai">
                    <base-icon type="vip-filled" size="18" color="#fff" class="mr-2 animate-vip-shake"/>
                    <span>{{ msg.text }}</span>
                  </view>
                </view>
              </template>
            </view>
            <view :id="lastMsgAnchor"></view>
          </view>
        </view>
      </scroll-view>

      <view class="chat-input-bar">
  <view class="chat-input-inline">


    <!-- ✏️ 文本输入 -->
    <textarea
      v-model="inputText"
      :placeholder="inputPlaceholder"
      auto-height
      class="chat-textarea"
      @confirm="handleSend"
    />

    <!-- 🚀 动态显示：发送键 or 功能图标 -->
    <template v-if="inputText.trim().length > 0">
      <!-- 当有输入内容时：显示发送按钮 -->
      <button class="send-btn" :disabled="loading" @click="handleSend">
        <base-icon v-if="!loading" type="arrow-up" size="18" color="#fff" />
        <view v-else class="animate-spin">
          <base-icon type="spinner-cycle" size="16" color="#fff" />
        </view>
      </button>
    </template>
    <template v-else>
      <!-- 否则：显示功能 icon tabs -->
      <view class="quick-icons">
        <view
          v-for="(item, idx) in quickTabs"
          :key="idx"
          class="icon-btn"
          @click="clickQuickTab(item)"
        >
          <base-icon :type="item.icon" size="20" color="#A88BFF" />
        </view>
      </view>
    </template>
  </view>
</view>

    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance()
const inputText = ref('')
const inputPlaceholder = ref('输入您的美容问题…')
const loading = ref(false)
const lastMsgAnchor = ref('end-anchor')
const messages = ref([])
const showWelcomeExamples = ref(true)

const STORAGE_KEY = 'chat_messages_v1'   // 缓存 key

// 🌸 欢迎示例
const exampleQuestions = [
  '我想去皱，有推荐吗？',
  '最近皮肤暗沉怎么办？',
  '我想预约美容服务',
  '我想领取优惠券'
]

const quickTabs = ref([
  { text: '预约', icon: 'calendar', action: '/pagesA/appointment/index' },
  { text: '检测', icon: 'scan', action: '/pagesA/facedetect/index' },
  { text: '我的', icon: 'user', action: '/pagesA/profile/index' },
])

function clickQuickTab(item) {
  proxy.$cf.navigate.to({ url: item.action, type: 'page' })
}




// ========== 恢复历史记录 ==========
onLoad(() => {
  const cached = uni.getStorageSync(STORAGE_KEY)
  if (cached) {
    try {
      messages.value = JSON.parse(cached)
    } catch {
      messages.value = []
    }
  }
  showWelcomeExamples.value = messages.value.length === 0
  setTimeout(() => scrollToBottom(), 200)
})

// ========== 自动保存聊天记录 ==========
function saveMessages() {
  // 限制最多保留 50 条
  if (messages.value.length > 50)
    messages.value = messages.value.slice(-50)

  uni.setStorageSync(STORAGE_KEY, JSON.stringify(messages.value))
}

// ========== 点击示例 ==========
function clickExample(txt) {
  inputText.value = txt
  showWelcomeExamples.value = false
  setTimeout(() => handleSend(txt), 100)
}

// ========== 模拟语音输入 ==========
function onVoiceInput() {
  if (loading.value) return
  const randomDemo = exampleQuestions[Math.floor(Math.random() * exampleQuestions.length)]
  inputText.value = randomDemo
  setTimeout(() => handleSend(randomDemo), 150)
}


// ========== 主发送逻辑 ==========
async function handleSend() {
  if (loading.value || !inputText.value.trim()) return;
  const q = inputText.value.trim();

  messages.value.push({ role: 'user', text: q });
  saveMessages();

  inputText.value = ''; // ✅ 清空输入框 → 自动切回tab
  loading.value = true;

  setTimeout(async () => {
    const reply = generateSmartReply(q);
    await showTypewriterEffect(reply);
    loading.value = false;
    scrollToBottom();
  }, 500);
}


// ========== 智能AI回复 ==========
function generateSmartReply(q) {
  if (q.includes('检测') || q.includes('暗沉')) {
    return '我来帮您打开皮肤检测页面，看看肤质状况吧～'
  } else if (q.includes('预约') || q.includes('医生')) {
    return '我来为您连接专业医生，帮您安排预约～'
  } else if (q.includes('去皱') || q.includes('项目')) {
    return '我来推荐几个热门除皱项目给您～'
  } else if (q.includes('优惠') || q.includes('券')) {
    return '好主意～我来带您看看本月优惠活动！'
  } else {
    return '我在听，请告诉我您的美容需求～'
  }
}

// ========== 智能跳转 ==========
function handleIntentNavigation(text) {
  const lower = text.toLowerCase()
  setTimeout(() => {
    if (lower.includes('检测') || lower.includes('暗沉')) {
      proxy.$cf.navigate.to({ url: '/pagesA/facedetect/index', type: 'page' })
    } else if (lower.includes('预约') || lower.includes('医生')) {
      proxy.$cf.navigate.to({ url: '/pagesA/doctor_list/index', type: 'page' })
    } else if (lower.includes('去皱') || lower.includes('项目')) {
      proxy.$cf.navigate.to({ url: '/pagesA/project_recommend/index', type: 'page' })
    } else if (lower.includes('优惠') || lower.includes('券')) {
      proxy.$cf.navigate.to({ url: '/pagesA/coupon_center/index', type: 'page' })
    }
  }, 1800)
}

// ========== 打字机效果 ==========
async function showTypewriterEffect(fullText) {
  let msg = { role: 'ai', text: '' }
  messages.value.push(msg)
  saveMessages() // 💾保存AI消息
  let idx = 0
  function tick() {
    if (idx <= fullText.length) {
      msg.text = fullText.slice(0, idx)
      idx++
      setTimeout(tick, 18 + Math.random() * 25)
    } else {
      saveMessages() // 💾打完后再保存一次
    }
  }
  tick()
}

// ========== 滚动到底 ==========
function scrollToBottom() {
  lastMsgAnchor.value = 'end-anchor'
  setTimeout(() => {
    try {
      uni.createSelectorQuery().select('#end-anchor').node().exec((res) => {
        if (res?.[0]?.node) res[0].node.scrollIntoView({ behavior: 'smooth' })
      })
    } catch {}
  }, 100)
}

function handleInputFocus() { try { uni.hideTabBar() } catch {} }
function handleInputBlur() { try { uni.showTabBar() } catch {} }
</script>


<style scoped>

/* === 固定头像顶栏 === */
.ai-header-fixed {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  height: 140rpx;       /* ✅ 关键：撑出玻璃高度 */
  display: flex;
  justify-content: center;
  align-items: flex-end;
  z-index: 99;
}

/* 毛玻璃背景 */
.ai-header-blur {
  position: absolute;   /* ✅ 让它覆盖固定区 */
  inset: 0;
  background: rgba(255,255,255,0.3);  /* ✅ 可见但透亮 */
  backdrop-filter: blur(7rpx) saturate(110%) brightness(0.97);
  -webkit-backdrop-filter: blur(300rpx) saturate(180%) brightness(3);
  box-shadow:
    inset 0 0 20rpx rgba(255,255,255,0.5),
    0 6rpx 18rpx rgba(255,182,193,0.8);
  border-bottom: 1rpx solid rgba(255,255,255,0.7);
  z-index: 1;
}




/* 缩小头像 + 居中悬浮 */
.ai-avatar-fixed {
  position: relative;
  z-index: 2;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: flex-end;
  transform: translateY(10rpx);
}

/* === 缩小版头像框 === */
.ai-avatar-frame {
  width: 90rpx;
  height: 90rpx;
  border-radius: 50%;
  background: linear-gradient(135deg, #FFB7C5 0%, #9B6BDF 100%);
  display: flex;
  align-items: center;
  justify-content: center;
  box-shadow: 0 0 18rpx rgba(255, 182, 193, 0.6),
              0 0 28rpx rgba(155, 107, 223, 0.3);
}

.ai-avatar-img {
  width: 70rpx;
  height: 70rpx;
  border-radius: 50%;
  object-fit: cover;
}

/* === 头像文字缩小 === */
.ai-title {
  margin-top: 6rpx;
  color: #9B6BDF;
  font-weight: 600;
  font-size: 24rpx;
  font-family: 'PingFang SC', sans-serif;
  letter-spacing: 2rpx;
}

/* === 动画：轻浮上下 === */
@keyframes avatar-bounce {
  0%, 100% { transform: translateY(0); }
  50% { transform: translateY(-rpx); }
}
.animate-avatar-bounce {
  animation: avatar-bounce 3.8s ease-in-out infinite;
}


/* === 核心视觉动画 & 光效 === */
.logo-title { letter-spacing:2px; font-family:'PingFang SC','Microsoft YaHei',sans-serif; }
.animate-vip-shake { animation: shake-vip 1.5s infinite ease-in-out; }
@keyframes shake-vip { 0%{ transform:rotate(0); } 20%{ transform:rotate(12deg); } 35%{ transform:rotate(-10deg);} 50%{transform:rotate(8deg);} 70%{transform:rotate(0);} 100%{transform:rotate(0);} }
.ai-avatar-flash{box-shadow:0 0 25px 4px #e39ad8d9,0 0 42px 17px #ffd6eba5,inset 0 0 12px 5px #ffc5e1d3;}
.animate-avatar-bounce{animation: avatar-bounce 3.6s infinite;}
@keyframes avatar-bounce {0%,100%{transform:translateY(0);} 50%{transform:translateY(-8px);}}
.animate-bubblein{ animation: bubblein .54s cubic-bezier(.58,1.45,.6,.93) both; }
@keyframes bubblein{0%{opacity:0;transform:translateY(18px);}100%{opacity:1;transform:translateY(0);}}
.animate-fadein{ animation: fadein .52s both; }
@keyframes fadein{0%{opacity:0;}100%{opacity:1;}}
.card-bg{ background:linear-gradient(165deg,#fff 80%,#fff7fe 100%); }
::-webkit-scrollbar{display:none;}
.input-bar { z-index: 5500 !important; }

/* === 头像柔光圈闪烁 === */
.ai-avatar-flash {
  position: absolute;
  inset: 0; /* 让它完全覆盖头像外框 */
  border-radius: 50%;
  box-shadow:
    0 0 25px 4px #e39ad8d9,   /* 粉紫柔光边 */
    0 0 42px 17px #ffd6eba5,  /* 大范围淡粉辉光 */
    inset 0 0 12px 5px #ffc5e1d3; /* 内层高光 */
  animation: flash-pulse 6s ease-in-out infinite;
  z-index: 1;
}

/* 柔光闪烁动画（呼吸感） */
@keyframes flash-pulse {
  0%, 100% { opacity: 0.8; transform: scale(1); }
  50% { opacity: 1; transform: scale(1.05); }
}

/* 确保图片层级在光晕之上 */
.ai-avatar-frame {
  position: relative;
  z-index: 2;
}
.ai-avatar-img {
  position: relative;
  z-index: 3;
}


/* ========== 聊天主体 ========== */
.chat-scroll {
  margin-top: 0rpx; /* 保留就行 */
  background: transparent;
  height: calc(100vh);  /* 视口高度 - 头像区(150rpx) - 输入区(70rpx左右) */
  overflow-y: scroll;
}

.chat-wrapper {
  position: relative;
  min-height: 100vh;
  background: radial-gradient(circle at top, #ffffff 0%, #f3e6ff 50%, #fff 100%);
  overflow: hidden;
}


.chat-container {
  padding: 0 36rpx;
  padding-top: 30rpx;
  padding-bottom: 120rpx;
  box-sizing: border-box;
}

/* ========== 欢迎示例 ========== */
.welcome-block {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 60rpx 0;
  gap: 18rpx;
}
.welcome-item {
  color: #888;
  background: #fdfdfd;
  border-radius: 9999rpx;
  padding: 12rpx 40rpx;
  font-size: 26rpx;
  transition: all .25s ease;
}
.welcome-item:hover { background: #ffe8f1; color: #FF5C8A; }

/* ========== 气泡 ========== */
.msg-user, .msg-ai { width: 100%; display: flex; align-items: flex-end; }
.msg-user { justify-content: flex-end; }
.msg-ai { justify-content: flex-start; }

.bubble-user {
  background: #f5f5f5;
  color: #333;
  padding: 18rpx 26rpx;
  border-radius: 22rpx;
  box-shadow: 0 4rpx 10rpx rgba(0,0,0,0.05);
  max-width: 70vw;
  word-break: break-word;
}
.bubble-ai {
  background: linear-gradient(135deg, #FF6FA0, #A88BFF);
  color: #fff;
  padding: 18rpx 26rpx;
  border-radius: 22rpx;
  box-shadow: 0 4rpx 14rpx rgba(155,107,223,0.25);
  max-width: 70vw;
  display: inline-flex;
  align-items: flex-start;
}

/* ========== 输入区 ========== */
.chat-input-bar {
  position: fixed;
  left: 0; right: 0; bottom: 60px;
  z-index: 9999;
  display: flex;
  justify-content: center;
  background: transparent;
  padding-bottom: env(safe-area-inset-bottom);
}

.chat-input-inline {
  width: 92%;
  display: flex;
  align-items: center;
  background: rgba(255,255,255,0.3);
  border-radius: 50rpx;
  padding: 10rpx 20rpx;
  backdrop-filter: blur(16rpx);
  box-shadow: 0 4rpx 20rpx rgba(255,182,193,0.3);
  gap: 14rpx;
}

/* 图标组整体 */
.quick-icons {
  display: flex;
  align-items: center;
  gap: 14rpx;
}

/* 单个图标按钮 */
.icon-btn {
  width: 60rpx;
  height: 60rpx;
  border-radius: 50%;
  
  justify-content: center;
  align-items: center;
  box-shadow: 0 3rpx 8rpx rgba(168,139,255,0.2);
  transition: all 0.25s ease;
}
.icon-btn:active {
  transform: scale(0.9);
  background: linear-gradient(135deg, #e9d7ff, #ffe6f3);
}

.chat-textarea {
  flex: 1;
  font-size: 28rpx;
  min-height: 60rpx;
  max-height: 180rpx;
  background: transparent;
  border: none;
  outline: none;
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


.chat-textarea {
  flex: 1;
  font-size: 28rpx;
  min-height: 60rpx;
  max-height: 180rpx;
  background: transparent;
  border: none;
  outline: none;
  color: #333;
  line-height: 1.5;
  font-family: 'PingFang SC', sans-serif;
}
</style>
