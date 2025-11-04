<template>
  <base-layout>
    <view class="p-4 min-h-screen">
      <!-- 佣金信息展示 -->
      <view class="bg-white rounded-xl shadow p-4 mb-4">
        <text class="text-primary-600 text-lg font-semibold mb-2 block">佣金信息</text>
        <view class="mb-4">
          <text class="text-text-primary font-medium">专属佣金比例：</text>
          <text class="text-primary-700 font-bold">{{ commissionRatio }}%</text>
        </view>
        <view>
          <text class="text-text-primary font-medium">累计收益：</text>
          <text class="text-success-600 font-bold">￥{{ totalEarnings.toFixed(2) }}</text>
        </view>
      </view>

      <!-- 分销二维码生成与复制 -->
      <view class="bg-white rounded-xl shadow p-4 mb-4">
        <text class="text-primary-600 text-lg font-semibold mb-4 block">专属分销二维码</text>
        <base-qr-code :text="qrCodeText" :size="180" class="mb-4"/>
        <button
          class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform mb-4"
          @click="copyQrCodeText"
          aria-label="复制分销链接"
        >
          复制分销链接
        </button>
      </view>

      <!-- 推广记录列表 -->
      <view class="bg-white rounded-xl shadow p-4">
        <text class="text-primary-600 text-lg font-semibold mb-4 block">推广记录</text>
        <view v-if="promotionRecords.length == 0" class="text-text-secondary text-center py-8">
          暂无推广记录
        </view>
        <view v-else>
          <view
            v-for="record in promotionRecords"
            :key="record.commission_info_id"
            class="mb-4 border-b border-gray-200 pb-2"
          >
            <text class="text-text-primary font-medium block mb-1">推广用户ID：{{ record.user_info_user_info_id_3 }}</text>
            <text class="text-text-secondary block">佣金比例：{{ record.commission_ratio }}%</text>
            <text class="text-text-secondary block">累计收益：￥{{ Number(record.total_earnings).toFixed(2) }}</text>
          </view>
          <view class="flex justify-center mt-2">
            <button
              class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform"
              :disabled="loading || !hasMore"
              @click="loadMore"
            >
              <text v-if="loading">加载中...</text>
              <text v-else-if="!hasMore">没有更多了</text>
              <text v-else>加载更多</text>
            </button>
          </view>
        </view>
      </view>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance()

const commissionRatio = ref(0)
const totalEarnings = ref(0)
const qrCodeText = ref('') // 分销链接文本

const promotionRecords = ref([])
const page = ref(1)
const pageSize = 10
const hasMore = ref(true)
const loading = ref(false)

onLoad(async () => {
  await loadCommissionInfo()
  await generateQrCodeText()
  await loadPromotionRecords(true)
})

// 加载佣金信息
async function loadCommissionInfo() {
  try {
    const res = await proxy.$cf.table.list({
      table_name: 'commission_info',
      param: {}
    })
    if (res.success && Array.isArray(res.data) && res.data.length > 0) {
      // 假设当前用户只有一条佣金信息，取第一条
      const info = res.data[0]
      commissionRatio.value = Number(info.commission_ratio) || 0
      totalEarnings.value = Number(info.total_earnings) || 0
    } else {
      commissionRatio.value = 0
      totalEarnings.value = 0
    }
  } catch (e) {
    commissionRatio.value = 0
    totalEarnings.value = 0
  }
}

// 生成分销二维码文本（链接），这里简单使用一个示例链接，实际可根据业务逻辑生成
async function generateQrCodeText() {
  // 这里模拟生成分销链接，实际可能需要用户ID或其他参数拼接
  qrCodeText.value = 'https://www.example.com/distribution?ref=123456'
}

// 复制分销链接到剪贴板
async function copyQrCodeText() {
  try {
    await proxy.$cf.shareApi({
      type: 'linkOrText',
      text: qrCodeText.value
    })
    await proxy.$cf.toast({ message: '复制成功', level: 'success' })
  } catch (e) {
    await proxy.$cf.toast({ message: '复制失败', level: 'error' })
  }
}

// 加载推广记录，分页加载
async function loadPromotionRecords(reset = false) {
  if (loading.value) return
  loading.value = true
  if (reset) {
    page.value = 1
    promotionRecords.value = []
    hasMore.value = true
  }
  try {
    const res = await proxy.$cf.table.page({
      table_name: 'commission_info',
      param: {
        current: page.value,
        pageSize: pageSize
      }
    })
    if (res.success && res.data && Array.isArray(res.data.records)) {
      if (reset) {
        promotionRecords.value = res.data.records
      } else {
        promotionRecords.value = promotionRecords.value.concat(res.data.records)
      }
      const total = res.data.total || 0
      if (promotionRecords.value.length >= total) {
        hasMore.value = false
      } else {
        page.value++
      }
    } else {
      hasMore.value = false
    }
  } catch (e) {
    hasMore.value = false
  }
  loading.value = false
}

// 加载更多按钮点击
function loadMore() {
  if (!loading.value && hasMore.value) {
    loadPromotionRecords(false)
  }
}
</script>

<style>
/* 适当增加间距，避免使用space-y-4 */
</style>