<template>
  <view class="layout-container">
    <!-- 主内容 -->
    <view
      class="content-container"
      :style="{ paddingBottom: isTab && showTabbar ? '100rpx' : '0' }"
    >
      <slot></slot>
    </view>

    <!-- 条件渲染的 TabBar -->
    <base-tabBar
      v-if="isTab && showTabbar"
      :tabList="tabList"
      class="safe-tabbar"
    />
  </view>
</template>

<script setup>
import { ref, onMounted, computed } from "vue"
import { onLoad } from "@dcloudio/uni-app"
import { dynamicTabBars } from "../tabbar/tabbar"

const tabList = ref(dynamicTabBars)
const isTab = ref(false)

// ✅ 全局控制变量
const showTabbar = false
// const showTabbar = computed(() => getApp().$tabbarVisible?.value !== false)

const checkIsTab = () => {
  const pages = getCurrentPages()
  if (!pages.length) return
  const curPage = pages[pages.length - 1]
  const route = curPage.route
  isTab.value = tabList.value.some(item =>
    route.includes(item.url.replace(/^\//, "").replace("/index", ""))
  )
}

onLoad(checkIsTab)
onMounted(checkIsTab)
</script>

<style scoped>
.layout-container {
  width: 100%;
  height: 100%;
  overflow: hidden;
}

/* ✅ 可滚动但无滚动条 */
.content-container {
  overflow-y: auto;
  -webkit-overflow-scrolling: touch;
}
.content-container::-webkit-scrollbar {
  display: none !important;
  width: 0 !important;
  height: 0 !important;
}

/* ✅ Tabbar 层级在最上 */
::v-deep .tabbar {
  z-index: 9999999;
}
</style>
