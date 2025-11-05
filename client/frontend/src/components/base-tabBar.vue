<template>
  <view class="tabbar" v-if="tabLists.length">
    <view
      v-for="(item, index) in tabLists"
      :key="index"
      :class="['tab_box', currentRoute === item.url ? 'on' : '']"
      :style="{ width: 100 / tabLists.length + '%' }"
      @click="tabFn(item.url)"
    >
      <view class="tab_inner">
        <image
          class="tab_icon"
          :class="{ active: currentRoute === item.url }"
          :src="currentRoute === item.url ? item.onicon : item.icon"
        />
        <text class="tab_bot">{{ item.title || item.text }}</text>
      </view>
    </view>
  </view>
</template>

<script setup>
import { ref, getCurrentInstance } from 'vue'

const { proxy } = getCurrentInstance()
const props = defineProps({
  tabList: {
    type: Array,
    default: () => [],
  },
})

const tabLists = ref(props.tabList)
const currentRoute = ref('')

const getCurrentRoute = () => {
  const pages = getCurrentPages()
  if (pages.length) {
    const currentPage = pages[pages.length - 1]
    currentRoute.value = `/${currentPage.route}`
  }
}
getCurrentRoute()

function tabFn(url) {
  proxy.$cf.navigate.to({
    url,
    type: 'page',
    mode: 'redirect',
  })
}
</script>

<style scoped>
.tabbar {
  width: 90%;
  height: 110rpx;
  background: rgba(255, 255, 255, 0.85);
  border-radius: 60rpx;
  position: fixed;
  bottom: 30rpx;
  left: 5%;
  display: flex;
  justify-content: space-around;
  align-items: center;
  box-shadow: 0 10rpx 25rpx rgba(0, 0, 0, 0.1);
  backdrop-filter: blur(20rpx);
  z-index: 999;
}

.tab_box {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  transition: all 0.25s ease;
}

.tab_box.on .tab_bot {
  background: linear-gradient(135deg, #6a8bff, #527ff4);
  -webkit-background-clip: text;
  color: transparent;
  font-weight: 600;
}

.tab_inner {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.tab_icon {
  width: 50rpx;
  height: 50rpx;
  transition: transform 0.3s cubic-bezier(0.34, 1.56, 0.64, 1), filter 0.3s ease;
}

.tab_icon.active {
  animation: bounceScale 0.4s ease-out;
  filter: drop-shadow(0 0 10rpx rgba(82, 127, 244, 0.8));
}

@keyframes bounceScale {
  0%   { transform: scale(1); }
  60%  { transform: scale(1.45); }
  100% { transform: scale(1.3); }
}



.tab_bot {
  font-size: 24rpx;
  margin-top: 6rpx;
  color: #7a7a7a;
  transition: color 0.3s ease;
}

.tab_box:active .tab_icon {
  transform: scale(0.9);
}

@keyframes ripple {
  0% { transform: scale(0.8); opacity: 0.5; }
  100% { transform: scale(2.5); opacity: 0; }
}
.tab_box:active::after {
  content: '';
  position: absolute;
  width: 80rpx;
  height: 80rpx;
  border-radius: 50%;
  background: rgba(82,127,244,0.2);
  animation: ripple 0.5s ease-out;
}
</style>
