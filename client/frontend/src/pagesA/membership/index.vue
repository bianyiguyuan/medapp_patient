<template>
  <base-layout>
    <view class="p-4 min-h-screen bg-gray-100">
      <text class="text-2xl font-extrabold text-primary-700 mb-4">会员权益</text>

      <view v-if="loading" class="flex justify-center items-center mt-10">
        <text class="text-text-secondary">加载中...</text>
      </view>

      <view v-else>
        <view
          v-for="level in memberLevels"
          :key="level.member_level_enum_id"
          class="bg-white bg-opacity-75 rounded-xl shadow p-4 mb-4"
          style="box-shadow: 0 4px 6px rgba(0,0,0,0.1);"
        >
          <view class="flex flex-col mb-2">
            <text class="text-xl font-semibold text-primary-600 mb-1 flex items-center">
              <base-icon
                v-if="level.level_name == '黄金会员' || level.level_name == '钻石会员'"
                type="medal"
                size="20"
                color="#FFD700"
                class="mr-2"
              />
              {{ level.level_name }}
              <base-icon
                v-if="level.level_name == '黄金会员' || level.level_name == '钻石会员'"
                type="medal"
                size="20"
                color="#FFD700"
                class="ml-2"
              />
            </text>
            <text class="text-text-secondary whitespace-pre-line">{{ level.description }}</text>
          </view>
          <button
            class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform"
            @click="handleRenew(level)"
            aria-label="续费会员"
          >
            续费优惠
          </button>
        </view>

        <view v-if="memberLevels.length == 0" class="text-center text-text-secondary mt-10">
          暂无会员等级信息
        </view>
      </view>

      <!-- 续费提示弹窗 -->
      <uni-popup ref="renewPopup" type="center" class="p-4 w-80 rounded-xl">
        <view class="bg-white p-6 rounded-xl shadow-lg">
          <text class="text-lg font-bold text-primary-700 mb-4">续费会员服务</text>
          <text class="mb-6 text-text-primary">
            续费功能正在开发中，敬请期待！
          </text>
          <button
            class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform w-full"
            @click="closeRenewPopup"
          >
            知道了
          </button>
        </view>
      </uni-popup>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance()

const memberLevels = ref([])
const loading = ref(false)
const renewPopup = ref(null)

onLoad(async () => {
  loading.value = true
  try {
    const res = await proxy.$cf.table.list({
      table_name: 'member_level_enum',
      param: {}
    })
    if (res.success) {
      memberLevels.value = res.data || []
    } else {
      await proxy.$cf.toast({ message: '加载会员等级失败', level: 'error' })
    }
  } catch (e) {
    await proxy.$cf.toast({ message: '网络异常，加载失败', level: 'error' })
  } finally {
    loading.value = false
  }
})

function handleRenew(level) {
  // 由于无跳转权限，使用弹窗代替续费入口
  renewPopup.value.open()
}

function closeRenewPopup() {
  renewPopup.value.close()
}
</script>

<style>
/* 额外样式，可根据需要调整 */
</style>