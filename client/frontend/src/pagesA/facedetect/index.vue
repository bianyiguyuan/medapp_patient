<template>
  <base-layout>
    <view class="p-4 bg-gray-50 min-h-screen flex flex-col">
      <!-- 标题 -->
      <view class="mb-4">
        <text class="text-2xl font-bold text-primary-700">人脸检测</text>
      </view>

      <!-- 上传人脸图片 -->
      <view class="mb-4">
        <text class="text-base font-semibold text-text-primary-700 mb-2 block">上传人脸图片进行免费检测</text>
        <base-upload
          :limit="1"
          mode="grid"
          :initialFiles="uploadImages"
          @success="handleUploadSuccess"
          @delete="handleUploadDelete"
        />
      </view>

      <!-- 检测结果展示 -->
      <view v-if="detectionResult" class="bg-white rounded-xl shadow p-4 mb-4">
        <view class="mb-2">
          <text class="text-lg font-semibold text-primary-800">检测结果</text>
        </view>
        <view class="mb-2">
          <text class="text-base text-text-primary-700">印象年龄: {{ detectionResult.impression_age || '未知' }}</text>
        </view>
        <view class="flex items-center mb-2">
          <text class="text-base text-text-primary-700">显老部位: {{ detectionResult.aging_parts || '未知' }}</text>
          <view
            class="ml-2 w-5 h-5 rounded-full bg-primary-500 flex items-center justify-center cursor-pointer"
            @click="showPayPrompt"
            title="点击查看付费提示"
          >
            <base-icon type="help" size="16" color="#fff" />
          </view>
        </view>
      </view>

      <!-- 付费解锁套餐 -->
      <view class="mb-6">
        <text class="text-lg font-semibold text-primary-700 mb-3 block">付费解锁深度分析和定制方案</text>
        <view class="flex flex-col gap-4">
          <button
            class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform"
            @click="openPackagePopup('deep_analysis')"
            type="button"
          >
            9.9元解锁深度分析
          </button>
          <button
            class="bg-primary-700 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform"
            @click="openPackagePopup('custom_plan')"
            type="button"
          >
            39.9元定制方案
          </button>
        </view>
      </view>

      <!-- 分享赚佣金按钮 -->
      <view
        class="mt-auto mb-4 bg-secondary-500 rounded-full px-6 py-3 flex items-center justify-center cursor-pointer"
        @click="goToMyPromotion"
      >
        <text class="text-white font-extrabold text-xl select-none">分享赚佣金</text>
      </view>

      <!-- 付费提示弹窗 -->
      <uni-popup ref="payPromptPopup" type="center" class="p-4 w-80">
        <view class="bg-white rounded-xl p-4">
          <text class="text-lg font-semibold text-primary-700 mb-4 block">付费提示</text>
          <text class="text-text-primary-700 mb-4 block">
            显老部位的深度成因分析和定制方案需要付费解锁，您可以选择相应套餐进行购买。
          </text>
          <button
            class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform w-full"
            @click="closePayPrompt"
            type="button"
          >
            知道了
          </button>
        </view>
      </uni-popup>

      <!-- 套餐选择弹窗 -->
      <uni-popup ref="packagePopup" type="center" class="p-4 w-80">
        <view class="bg-white rounded-xl p-4">
          <text class="text-lg font-semibold text-primary-700 mb-4 block">选择套餐</text>
          <view class="flex flex-col gap-4 mb-4">
            <button
              v-for="pkg in packages"
              :key="pkg.id"
              class="bg-primary-500 text-white rounded-full px-6 font-semibold active:scale-95 transition-transform"
              @click="handlePackagePay(pkg)"
              type="button"
            >
              {{ pkg.name }} - {{ pkg.price }}元
            </button>
          </view>
          <button
            class="bg-gray-300 text-text-primary-700 rounded-full px-6 font-semibold active:scale-95 transition-transform w-full"
            @click="closePackagePopup"
            type="button"
          >
            取消
          </button>
        </view>
      </uni-popup>
    </view>
  </base-layout>
</template>

<script setup>
const { proxy } = getCurrentInstance();

const uploadImages = ref([]);
const detectionResult = ref(null);

const payPromptPopup = ref(null);
const packagePopup = ref(null);

const selectedPackageType = ref('');

// 套餐列表
const packages = [
  { id: 'deep_analysis', name: '深度成因分析', price: 9.9 },
  { id: 'custom_plan', name: '定制方案', price: 39.9 }
];

// 上传成功处理
async function handleUploadSuccess(item) {
  if (item.success) {
    uploadImages.value = [{ url: item.data.url }];

    // 调用人脸识别接口，模拟调用，替换成真实接口调用
    proxy.$cf.loading.showLoading({ title: '检测中...' });
    try {
      // 模拟调用接口，实际应调用对应人脸识别接口，返回印象年龄和显老部位
      // 这里假设接口为 proxy.$cf.faceDetect.analyze({ imageUrl: item.data.url })
      // 由于未提供接口，使用模拟数据
      await new Promise(resolve => setTimeout(resolve, 1500)); // 模拟接口延迟
      detectionResult.value = {
        impression_age: 28,
        aging_parts: '眼角、额头'
      };
    } catch (e) {
      proxy.$cf.toast({ message: '检测失败，请重试', level: 'error' });
      detectionResult.value = null;
    } finally {
      proxy.$cf.loading.hideLoading();
    }
  }
}

// 删除图片时清空结果
function handleUploadDelete() {
  uploadImages.value = [];
  detectionResult.value = null;
}

// 显示付费提示弹窗
function showPayPrompt() {
  payPromptPopup.value.open();
}

// 关闭付费提示弹窗
function closePayPrompt() {
  payPromptPopup.value.close();
}

// 打开套餐选择弹窗
function openPackagePopup(type) {
  selectedPackageType.value = type;
  packagePopup.value.open();
}

// 关闭套餐选择弹窗
function closePackagePopup() {
  packagePopup.value.close();
  selectedPackageType.value = '';
}

// 处理套餐支付
async function handlePackagePay(pkg) {
  packagePopup.value.close();

  // 获取当前登录用户
  const loginRes = await proxy.$cf.login.getLoginUser();
  if (!loginRes.success || !loginRes.data) {
    proxy.$cf.toast({ message: '请先登录', level: 'error' });
    return;
  }
  const userId = loginRes.data.user_info_id;

  // 创建订单记录
  const now = new Date();
  const year = now.getFullYear();
  const month = ('0' + (now.getMonth() + 1)).slice(-2);
  const day = ('0' + now.getDate()).slice(-2);
  const hours = ('0' + now.getHours()).slice(-2);
  const minutes = ('0' + now.getMinutes()).slice(-2);
  const seconds = ('0' + now.getSeconds()).slice(-2);
  const formattedTime = `${year}-${month}-${day} ${hours}:${minutes}:${seconds}`;

  // 订单表字段示例，需根据实际表结构调整
  const orderParam = {
    user_info_user_info_id_5: userId,
    product_info_product_info_id: 0, // 无实际商品ID，或可根据套餐映射ID
    quantity: 1,
    total_price: pkg.price,
    order_status_enum_id: 1, // 待支付
    payment_order_no: null,
    created_at: formattedTime
  };

  // 添加订单
  const addOrderRes = await proxy.$cf.table.add({
    table_name: 'order_info',
    param: orderParam
  });

  if (!addOrderRes.success) {
    proxy.$cf.toast({ message: '创建订单失败，请重试', level: 'error' });
    return;
  }

  const orderId = addOrderRes.data;

  // 调用支付弹窗
  // 由于未提供支付组件，使用模拟支付弹窗实现
  proxy.$cf.model({
    title: '支付确认',
    message: `确认支付${pkg.price}元购买${pkg.name}？`,
    confirmText: '确认支付',
    cancelText: '取消'
  }).then(async (res) => {
    if (res.confirm) {
      proxy.$cf.loading.showLoading({ title: '支付中...' });
      // 模拟支付流程
      await new Promise(resolve => setTimeout(resolve, 1500));
      proxy.$cf.loading.hideLoading();

      // 支付成功，更新订单状态
      await proxy.$cf.table.update({
        table_name: 'order_info',
        param: {
          order_info_id: orderId,
          order_status_enum_id: 2 // 已支付
        }
      });

      proxy.$cf.toast({ message: '支付成功', level: 'success' });

      // 跳转我的页面
      proxy.$cf.navigate.to({ url: '/pages/mycenter/index', type: 'page' });
    }
  }).catch(() => {
    proxy.$cf.toast({ message: '支付取消', level: 'none' });
  });
}

// 跳转我的推广页面
function goToMyPromotion() {
  // mycenter页面存在，允许跳转
  proxy.$cf.navigate.to({ url: '/pages/mycenter/index', type: 'page' });
}
</script>

<style>
/* 按钮禁用text-sm等文字大小，避免样式变形 */
button {
  /* 默认按钮样式由tailwind控制，避免额外文字大小 */
}

/* 付费提示弹窗和套餐弹窗宽度固定 */
.uni-popup.w-80 {
  width: 320px !important;
}
</style>