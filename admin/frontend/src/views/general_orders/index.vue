<template>
     
  <base-wrapper
>
<div class="flex-between-start" style="background-color: #5D5FEF; height: 140px;">
    <div class="flex-c-center-start h-full">
      <div class="m-x-20">
          <span style="font-weight: bold; font-size: 20px; color: #FFFFFF;">系统订单信息</span>
      </div>
      <div class="m-x-20 m-t-4">
        <span style="font-size: 14px; color: #FFFFFF;">主键、订单编号、用户ID、操作ID、订单类型、订单状态、支付状态、发货状态、商品ID、商品数量、订单总额、优惠金额、运费、实付金额、支付渠道、支付订单号、支付时间、支付金额、配送方式、配送地址、物流公司、运单号、收件人电话、收件人、创建时间、更新时间、取消时间、完成时间、发货时间、支付系统退款单号、业务系统、退款类型、退款金额、退款原因、退款状态、备注、是否删除、表名、字段名。</span>
      </div>
    </div>
    <div class="flex-start-end h-full m-r-10">
        <img src="@/assets/logo/document.png" height="130px" />
    </div>
</div>
<el-breadcrumb
separator="/"
class="m-20"
>
<el-breadcrumb-item
:to="{ path: '/' }"
>
首页
</el-breadcrumb-item>
<el-breadcrumb-item
:to="{ path: '/general_orders' }"
>
系统订单信息管理
</el-breadcrumb-item>
</el-breadcrumb>
<general_orders_component
 />
</base-wrapper>
   
</template>

<script setup>

</script>

<style lang="scss" scoped>
</style>