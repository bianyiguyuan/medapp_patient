<template>
  <base-layout>
    <!-- 顶部导航栏 -->
    <view class="fixed z-50 left-0 right-0 top-0 bg-white bg-opacity-95 flex items-center justify-between px-3 py-2 shadow-md" style="height:56px;">
      <view class="flex items-center">
        <image src="https://www.codeflying.net/preview/ai-girl3.jpg" class="w-8 h-8 mr-2 rounded-full bg-gradient-to-br from-pink-200 to-purple-200 shadow" mode="aspectFill" style="border:2.5px solid #FF5C8A;" />
        <text class="text-[18px] font-bold text-[#FF5C8A] tracking-widest font-sans logo-title">求美小天才</text>
      </view>
      <button class="rounded-full flex items-center py-1 px-3 bg-gradient-to-r from-pink-400 to-purple-400 shadow-xl active:scale-95 transition-transform" style="height:36px" @click="goToMemberCenter" aria-label="会员中心">
        <base-icon type="vip" size="22" color="#ffd700" class="mr-1 animate-vip-shake"/>
        <text class="text-xs font-medium text-[#FFD700]">会员中心</text>
      </button>
    </view>

    <!-- 主对话区 -->
    <scroll-view
      scroll-y
      class="flex-1 mb-2 px-1 card-bg pb-2"
      :style="{ height: 'calc(100vh - 100px)', paddingBottom: '100px' }"
      :scroll-into-view="lastMsgAnchor"
      refresher-enabled
    >
      <!-- AI头像区 -->
      <view class="flex flex-col items-center mt-0 mb-2 ai-avatar-area" style="margin-top:2px;">
        <view class="relative flex flex-col items-center animate-avatar-bounce">
          <view class="w-20 h-20 rounded-full bg-gradient-to-br from-[#FFB7C5] via-[#FFCEE3] to-[#9B6BDF] shadow-2xl flex items-center justify-center ai-avatar-flash">
            <image src="https://www.codeflying.net/preview/ai-girl3.jpg" class="w-16 h-16 rounded-full ai-eyeblink" mode="aspectFill"/>
          </view>
          <text class="mt-2 text-[#9B6BDF] font-bold text-lg tracking-wider ai-title">求美小天才</text>
        </view>
      </view>
      <!-- 欢迎示例问题 -->
      <view v-if="showWelcomeExamples" class="my-6 flex flex-col gap-4 items-center justify-center">
        <text v-for="(ex, idx) in exampleQuestions" :key="idx" class="text-sm text-gray-400 text-center py-2 px-4 rounded-full bg-gray-50 font-thin cursor-pointer hover:bg-pink-50 transition-colors animate-fadein"
          @click="clickExample(ex)">{{ ex }}</text>
      </view>
      <!-- 对话内容气泡（无头像，仅文本） -->
      <view v-if="messages.length" class="flex flex-col gap-3 min-h-[60vh] pb-8">
        <view v-for="(msg, idx) in messages" :key="idx">
          <!-- 对话气泡普通文本 -->
          <template v-if="msg.type === 'bubble'">
            <!-- 用户气泡：右圆左方，灰色背景，最大宽度70vw -->
            <view v-if="msg.role==='user'" class="flex flex-row-reverse items-end w-full mb-1 animate-bubblein">
              <view class="bg-[#f1f1f1] text-gray-800 rounded-tr-2xl rounded-br-2xl rounded-l-none px-4 py-2 shadow-sm max-w-[70vw] text-[15px] text-right" style="font-family: 'PingFang SC', sans-serif; margin-left:auto;">
                {{ msg.text }}
              </view>
            </view>
            <!-- AI气泡：左圆右方，粉色渐变，最大宽度70vw，白色文字 -->
            <view v-else class="flex items-end w-full mb-1 animate-bubblein">
              <view class="flex-1">
                <view class="bg-gradient-to-tr from-[#FF5C8A] to-[#9B6BDF] text-white rounded-tl-2xl rounded-bl-2xl rounded-r-none px-4 py-2 shadow max-w-[70vw] flex items-center text-[15px] font-medium font-sans">
                  <base-icon type="vip-filled" size="16" color="#fff" class="mr-2"/>
                  <span class="ai-msg-typewriter">{{ msg.text }}</span>
                </view>
              </view>
            </view>
          </template>
          <!-- 其余自定义卡片类内容（如医生/项目等），不变 -->
          <template v-else-if="msg.type==='doctor_card'">
            <view class="bg-white rounded-xl shadow-xl p-4 flex items-center gap-3 mt-2 border-l-4 border-pink-400 animate-cardfadein">
              <image :src="msg.avatar" class="w-12 h-12 rounded-full object-cover border-2 border-purple-300" />
              <view class="flex-1 min-w-0">
                <view class="flex items-center mb-1">
                  <text class="text-base font-bold text-[#FF5C8A] mr-2">{{ msg.name }}</text>
                  <uni-tag text="认证医生" type="royal" size="small" circle class="ml-1" />
                  <uni-tag text="合作机构" type="default" size="small" circle class="ml-1" />
                </view>
                <view class="flex items-center text-sm text-gray-600 mb-1">
                  <base-icon type="star-filled" size="15" color="#FFB000" class="mr-1"/><text>{{ msg.rating }}</text>
                  <base-icon type="location-filled" size="15" color="#6A6AFF" class="mx-2"/><text>{{ msg.distance }}km</text>
                </view>
                <button @click="onCardCoupon(msg)" class="rounded-full bg-gradient-to-r from-pink-400 to-orange-400 text-white px-5 py-1 font-bold shadow-md mt-1 text-xs active:scale-95 transition-transform">
                  领取¥{{ msg.coupon }}优惠券
                </button>
              </view>
            </view>
          </template>
          <template v-else-if="msg.type==='project_card'">
            <view class="bg-gradient-to-r from-[#FFB7C5] to-[#FFEEED] rounded-xl shadow-xl p-4 flex items-center gap-3 mt-2 min-w-0 animate-cardfadein">
              <image :src="msg.cover || 'https://www.codeflying.net/preview/growth-chart.jpg'" class="w-12 h-12 rounded-lg object-cover border-2 border-pink-300" />
              <view class="flex-1 min-w-0">
                <view class="font-bold text-[#FF5C8A] mb-1 text-base">{{ msg.name }}</view>
                <view class="flex items-center mb-3">
                  <text class="text-sm text-gray-600 flex items-center"><base-icon type="wallet" size="14" color="#E26A8D"/> ￥{{ msg.price }}</text>
                  <uni-tag v-if="msg.tag" :text="msg.tag" type="warning" size="small" circle class="ml-2" />
                </view>
                <button @click="onCardBook(msg)" class="rounded-full bg-gradient-to-r from-pink-400 to-orange-400 text-white px-6 py-1 font-bold shadow-md text-xs active:scale-95 transition-transform">
                  立即预约
                </button>
              </view>
            </view>
          </template>
          <template v-else-if="msg.type==='skincare_card'">
            <view class="bg-white rounded-xl shadow p-4 flex gap-4 mt-2 animate-cardfadein">
              <view class="flex-1 flex flex-col items-center">
                <base-icon type="color" size="26" color="#FF5C8A" class="mb-1"/>
                <text class="font-bold text-md text-[#FF5C8A]">护肤</text>
                <text class="text-xs text-gray-600 mt-1">{{ msg.tips1 }}</text>
              </view>
              <view class="flex-1 flex flex-col items-center">
                <base-icon type="vip" size="26" color="#9B6BDF" class="mb-1"/>
                <text class="font-bold text-md text-[#9B6BDF]">医美</text>
                <text class="text-xs text-gray-600 mt-1">{{ msg.tips2 }}</text>
              </view>
              <view class="flex-1 flex flex-col items-center">
                <base-icon type="calendar" size="26" color="#E26A8D" class="mb-1"/>
                <text class="font-bold text-md text-[#E26A8D]">作息</text>
                <text class="text-xs text-gray-600 mt-1">{{ msg.tips3 }}</text>
              </view>
            </view>
          </template>
          <template v-else-if="msg.type==='detection_card'">
            <view class="bg-gradient-to-r from-[#FFD6EC] via-[#FFB7C5] to-[#FAE2FF] rounded-xl shadow-xl p-5 mt-2 flex items-center justify-between animate-cardfadein">
              <view class="flex items-center gap-2">
                <base-icon type="auth-filled" size="24" color="#7C3AED"/>
                <text class="font-bold text-[#9B6BDF] text-base">颜龄检测</text>
              </view>
              <button @click="gotoDetection" class="rounded-full bg-gradient-to-r from-pink-400 to-orange-400 text-white px-6 py-1 font-bold shadow-md text-xs active:scale-95 transition-transform">
                立即检测
              </button>
            </view>
          </template>
        </view>
        <view :id="lastMsgAnchor"></view>
      </view>
    </scroll-view>

    <!-- 输入框固定在页面底部（适配TabBar 60px） -->
    <view class="fixed left-0 right-0 w-full px-4 py-3 bg-white z-40 input-bar" :style="{ bottom: '60px' }">
      <view class="mx-auto max-w-xl flex items-end gap-2">
        <view class="flex-1 relative">
          <view class="absolute left-3 top-0 bottom-0 flex items-center">
            <button class="rounded-full px-2 py-1 h-8 w-8 flex items-center justify-center bg-gradient-to-br from-pink-200 to-purple-200 border-none mr-1 shadow-sm" title="语音输入" @click="onVoiceInput">
              <base-icon type="mic" size="18" color="#FF5C8A"/>
            </button>
          </view>
          <!-- 输入框 -->
          <input v-model="inputText"
            :placeholder="inputPlaceholder"
            class="pl-12 pr-12 py-2 rounded-full bg-white shadow-lg w-full text-base outline-none border border-gray-100 transition-shadow duration-100 ease-in hover:shadow-xl focus:shadow-2xl animate-inputzoom"
            :disabled="loading"
            @keydown.enter="handleSend"
            @focus="handleInputFocus"
            @blur="handleInputBlur"/>
          <view class="absolute right-3 top-0 bottom-0 flex items-center">
            <!-- 发送按钮尺寸缩小 px-4 py-2 -->
            <button @click="handleSend" :disabled="loading||!inputText.trim()" class="rounded-full px-4 py-2 shadow-lg bg-gradient-to-r from-[#FF5C8A] to-[#FFB478] text-white font-bold text-base transition-all active:scale-95 flex items-center justify-center send-btn" :class="{'send-loading':loading}" style="min-width:44px;min-height:34px;max-width:100px;">
              <base-icon type="arrow-up" size="18" color="#fff" v-if="!loading"/>
              <view v-else class="animate-spin"><base-icon type="spinner-cycle" size="16" color="#fff"/></view>
            </button>
          </view>
        </view>
      </view>
    </view>
  </base-layout>
</template>
<script setup>
const { proxy } = getCurrentInstance();
const inputText = ref('');
const inputPlaceholder = ref('输入您的美容问题…');
const loading = ref(false);
const lastMsgAnchor = ref('end-anchor');
const messages = ref([]);
const showWelcomeExamples = ref(true);
const exampleQuestions = [
  '我想去皱，有推荐吗？',
  '最近皮肤暗沉怎么办？',
  '我想预约美容服务'
];
function goToMemberCenter() {
  proxy.$cf.navigate.to({ url: '/pages/mycenter/index', type: 'page' });
}
function clickExample(txt) {
  inputText.value = txt;
  showWelcomeExamples.value = false;
  setTimeout(()=>{handleSend()},80);
}
function onVoiceInput() {
  if (loading.value) return;
  const randomDemo = exampleQuestions[parseInt(Math.random()*exampleQuestions.length)];
  inputText.value = randomDemo;
  setTimeout(() => {
    handleSend();
  },150);
}
let typewriterTimer = null;
let aiReplyTextBuffer = '';
async function handleSend() {
  if (loading.value) return;
  const q = inputText.value.trim();
  if (!q) return;
  messages.value.push({ role:'user', text: q, type:'bubble' });
  inputText.value = '';
  showWelcomeExamples.value = false;
  loading.value = true;
  const prompt = '角色：你是美业AI顾问。任务：理解用户意图，智能输出结构化响应（如检测推荐卡、医生推荐卡、项目卡、护肤卡、分销卡），否则普通文本回复。输出：如有结构化请直接明文输出JSON对象，禁止代码块嵌套。';
  setTimeout(async ()=>{
    let aiResp = '';
    try {
      const res = await proxy.$cf.ai.text2text({
        prompt, text: q, conversation_id:''
      });
      if(res.success && res.data){
        aiReplyTextBuffer = '';
        let parsed = null;
        try {
          parsed = JSON.parse(res.data.answer);
        } catch{
          parsed = null;
        }
        if(parsed && parsed.type){
          if(parsed.type == 'doctor_card'){
            messages.value.push({ ...parsed, type:'doctor_card', role:'ai' });
          } else if(parsed.type=='project_card'){
            messages.value.push({ ...parsed, type:'project_card', role:'ai' });
          } else if(parsed.type=='skincare_card'){
            messages.value.push({ ...parsed, type:'skincare_card', role:'ai' });
          } else if(parsed.type=='detection_card'){
            messages.value.push({ ...parsed, type:'detection_card', role:'ai' });
          } else {
            await showTypewriterEffect(res.data.answer||'');
          }
        } else {
          await showTypewriterEffect(res.data.answer||'');
        }
      } else {
        await showTypewriterEffect('AI暂无回答，请稍后再试。');
      }
    } catch(e) {
      await showTypewriterEffect('抱歉，当前网络或AI服务异常');
    }
    loading.value = false;
    scrollToBottom();
  },700);
}
async function showTypewriterEffect(fullText) {
  aiReplyTextBuffer = '';
  let idx = 0;
  let msg = { role:'ai', text:'', type:'bubble' };
  messages.value.push(msg);
  function tick(){
    if(idx<=fullText.length){
      msg.text = fullText.slice(0,idx);
      idx++;
      typewriterTimer = setTimeout(tick, 18+Math.random()*28);
    }
  }
  tick();
  return new Promise(resolve => {
    setTimeout(()=>{
      clearTimeout(typewriterTimer);
      msg.text = fullText;
      resolve();
      scrollToBottom();
    }, Math.max(fullText.length*35, 800));
  });
}
function onCardCoupon(card){
  proxy.$cf.toast({ message: `已为您发放${card.coupon}元优惠券！`, level: 'success' });
}
function onCardBook(card){
  proxy.$cf.toast({ message: '预约成功，相关工作人员会与您联系~', level: 'success' });
}
function gotoDetection(){
  proxy.$cf.navigate.to({ url:'/pages/facedetect/index', type:'page' });
}
function handleInputFocus(){
  try {
    uni.hideTabBar();
  } catch(e) { /* 容错处理 */ }
}
function handleInputBlur(){
  try {
    uni.showTabBar();
  } catch(e) { /* 容错处理 */ }
}
function scrollToBottom(){
  lastMsgAnchor.value = 'end-anchor';
  /* #ifdef H5 */
  setTimeout(() => {
    try {
      uni.createSelectorQuery().select('#end-anchor').node().exec(function(res){
        if (res && res[0] && res[0].node) {
          res[0].node.scrollIntoView({behavior:'smooth'});
        }
      });
    } catch(e) {
    }
  }, 120);
  /* #endif */
}
onLoad(() => {
  setTimeout(()=>{ showWelcomeExamples.value = true; }, 200);
  scrollToBottom();
});
</script>
<style scoped>
.logo-title { letter-spacing:2px; font-family:'PingFang SC','Microsoft YaHei',sans-serif; }
.animate-vip-shake { animation: shake-vip 1.5s infinite ease-in-out; }
@keyframes shake-vip {
  0%{ transform:rotate(0); } 20%{ transform:rotate(12deg); } 35%{ transform:rotate(-10deg);} 50%{transform:rotate(8deg);} 70%{transform:rotate(0);} 100%{transform:rotate(0);}
}
.ai-avatar-flash{box-shadow:0 0 25px 4px #e39ad8d9,0 0 42px 17px #ffd6eba5,inset 0 0 12px 5px #ffc5e1d3;}
.ai-eyeblink{animation: ai-eyeblink 4s infinite;}
@keyframes ai-eyeblink {
  0%,97%{filter:none;} 98%{filter:brightness(0.6) blur(2px);} 99%{filter:none;} 100%{filter:none;}
}
.animate-avatar-bounce{animation: avatar-bounce 3.6s infinite;}
@keyframes avatar-bounce {0%,100%{transform:translateY(0);} 50%{transform:translateY(-8px);}}
.animate-bubblein{ animation: bubblein .54s cubic-bezier(.58,1.45,.6,.93) both; }
@keyframes bubblein{0%{opacity:0;transform:translateY(18px);}100%{opacity:1;transform:translateY(0);}}
.animate-fadein{ animation: fadein .52s both; }
@keyframes fadein{0%{opacity:0;}100%{opacity:1;}}
.animate-cardfadein{animation:cardfadein .65s both;}
@keyframes cardfadein{0%{opacity:0;transform:scale(.95);}100%{opacity:1;transform:scale(1);}}
.ai-avatar-area{ margin-bottom:.25rem;margin-top:.125rem;}
.ai-title{ font-family:'PingFang SC',sans-serif;font-weight:600; }
.send-btn{ transition:box-shadow background .18s; box-shadow:0 2px 12px 0 #ffb7c5ba; }
.send-btn:active { box-shadow:0 0 0 0 #fff; transform:scale(.94);}
.send-loading .base-icon{ display:none; }
.send-loading .animate-spin{ display:inline-block;}
@keyframes spin {100%{transform:rotate(360deg);}}
.animate-spin{animation:spin 0.8s linear infinite;}
.send-btn:disabled { opacity:.4; filter:grayscale(.7); }
.bg-gradient-to-r{ background-image:linear-gradient(90deg,#ff5c8a,#fcb075); }
.bg-gradient-to-br{background-image:linear-gradient(135deg,#FFB7C5 0%,#9B6BDF 100%);}
.bg-gradient-to-tr{background-image:linear-gradient(45deg,#ff5c8a 0,#9b6bdf 100%);}
.button.shadow-xl{box-shadow:0 8px 36px 0 #ffd6eb42;}
.card-bg{ background:linear-gradient(165deg,#fff 80%,#fff7fe 100%); }
input.animate-inputzoom:focus{ transform:scale(1.03); box-shadow:0 6px 30px #ffc0e1a6!important;border:1.5px solid #FF5C8A;}
.uni-tag { vertical-align: middle; }
::-webkit-scrollbar{display:none;}
.input-bar { z-index: 5500 !important; }
</style>