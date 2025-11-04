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
<el-breadcrumb-item
>
系统订单信息详情
</el-breadcrumb-item>
</el-breadcrumb>
<base-wrapper
class="p-10"
>
<el-tabs
class="demo-tabs"
>
<el-tab-pane
label="系统订单信息详情"
>
<el-form
:model='form'
ref='dataFormRef'
label-position='top'
:rules='{"totalAmount":[{"trigger":"blur","message":"订单总额不能为空","required":true}],"productsId":[{"trigger":"blur","message":"商品ID不能为空","required":true}],"orderNo":[{"trigger":"blur","message":"订单编号不能为空","required":true}],"createTime":[{"trigger":"blur","message":"创建时间不能为空","required":true}],"actualAmount":[{"trigger":"blur","message":"实付金额不能为空","required":true}],"orderStatus":[{"trigger":"blur","message":"订单状态不能为空","required":true}],"updateTime":[{"trigger":"blur","message":"更新时间不能为空","required":true}],"userId":[{"trigger":"blur","message":"用户ID不能为空","required":true}],"payStatus":[{"trigger":"blur","message":"支付状态不能为空","required":true}],"quality":[{"trigger":"blur","message":"商品数量不能为空","required":true}]}'
label-width='150px'
>
    <el-form-item  label="订单编号" prop="orderNo">
        <el-input clearable placeholder="请输入订单编号" v-model="form.orderNo" />
    </el-form-item>

    <el-form-item  label="用户ID" prop="userId">
        <el-input clearable placeholder="请输入用户ID" v-model="form.userId" />
    </el-form-item>

    <el-form-item  label="操作ID" prop="opId">
        <el-input clearable placeholder="请输入操作ID" v-model="form.opId" />
    </el-form-item>

    <el-form-item  label="订单类型" prop="orderType">
        <el-input clearable placeholder="请输入订单类型" v-model="form.orderType" />
    </el-form-item>

    <el-form-item  label="订单状态" prop="orderStatus">
        <el-input clearable placeholder="请输入订单状态" v-model="form.orderStatus" />
    </el-form-item>

    <el-form-item  label="支付状态" prop="payStatus">
        <el-input clearable placeholder="请输入支付状态" v-model="form.payStatus" />
    </el-form-item>

    <el-form-item  label="发货状态" prop="deliveryStatus">
        <el-input clearable placeholder="请输入发货状态" v-model="form.deliveryStatus" />
    </el-form-item>

    <el-form-item  label="商品ID" prop="productsId">
        <el-input clearable placeholder="请输入商品ID" v-model="form.productsId" />
    </el-form-item>

    <el-form-item  label="商品数量" prop="quality">
        <el-input clearable placeholder="请输入商品数量" v-model="form.quality" />
    </el-form-item>

    <el-form-item  label="订单总额" prop="totalAmount">
        <el-input clearable placeholder="请输入订单总额" v-model="form.totalAmount" />
    </el-form-item>

    <el-form-item  label="优惠金额" prop="discountAmount">
        <el-input clearable placeholder="请输入优惠金额" v-model="form.discountAmount" />
    </el-form-item>

    <el-form-item  label="运费" prop="shippingFee">
        <el-input clearable placeholder="请输入运费" v-model="form.shippingFee" />
    </el-form-item>

    <el-form-item  label="实付金额" prop="actualAmount">
        <el-input clearable placeholder="请输入实付金额" v-model="form.actualAmount" />
    </el-form-item>

    <el-form-item  label="支付渠道" prop="paymentChannel">
        <el-input clearable placeholder="请输入支付渠道" v-model="form.paymentChannel" />
    </el-form-item>

    <el-form-item  label="支付订单号" prop="paymentOrderId">
        <el-input clearable placeholder="请输入支付订单号" v-model="form.paymentOrderId" />
    </el-form-item>

    <el-form-item   label="支付时间" prop="paymentTime">
        <el-date-picker placeholder="请输入支付时间" v-model="form.paymentTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item  label="支付金额" prop="paymentAmount">
        <el-input clearable placeholder="请输入支付金额" v-model="form.paymentAmount" />
    </el-form-item>

    <el-form-item  label="配送方式" prop="shippingMethod">
        <el-input clearable placeholder="请输入配送方式" v-model="form.shippingMethod" />
    </el-form-item>

    <el-form-item  label="配送地址" prop="shippingAddress">
        <el-input clearable placeholder="请输入配送地址" v-model="form.shippingAddress" />
    </el-form-item>

    <el-form-item  label="物流公司" prop="shippingCompany">
        <el-input clearable placeholder="请输入物流公司" v-model="form.shippingCompany" />
    </el-form-item>

    <el-form-item  label="运单号" prop="trackingNumber">
        <el-input clearable placeholder="请输入运单号" v-model="form.trackingNumber" />
    </el-form-item>

    <el-form-item  label="收件人电话" prop="tel">
        <el-input clearable placeholder="请输入收件人电话" v-model="form.tel" />
    </el-form-item>

    <el-form-item  label="收件人" prop="recipient">
        <el-input clearable placeholder="请输入收件人" v-model="form.recipient" />
    </el-form-item>

    <el-form-item   label="创建时间" prop="createTime">
        <el-date-picker placeholder="请输入创建时间" v-model="form.createTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="更新时间" prop="updateTime">
        <el-date-picker placeholder="请输入更新时间" v-model="form.updateTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="取消时间" prop="cancelTime">
        <el-date-picker placeholder="请输入取消时间" v-model="form.cancelTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="完成时间" prop="completeTime">
        <el-date-picker placeholder="请输入完成时间" v-model="form.completeTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="发货时间" prop="deliverTime">
        <el-date-picker placeholder="请输入发货时间" v-model="form.deliverTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item  label="支付系统退款单号" prop="refundId">
        <el-input clearable placeholder="请输入支付系统退款单号" v-model="form.refundId" />
    </el-form-item>

    <el-form-item  label="业务系统" prop="refundNo">
        <el-input clearable placeholder="请输入业务系统" v-model="form.refundNo" />
    </el-form-item>

    <el-form-item  label="退款类型" prop="refundType">
        <el-input clearable placeholder="请输入退款类型" v-model="form.refundType" />
    </el-form-item>

    <el-form-item  label="退款金额" prop="refundAmount">
        <el-input clearable placeholder="请输入退款金额" v-model="form.refundAmount" />
    </el-form-item>

    <el-form-item  label="退款原因" prop="refundReason">
        <el-input clearable placeholder="请输入退款原因" v-model="form.refundReason" />
    </el-form-item>

    <el-form-item  label="退款状态" prop="refundStatus">
        <el-input clearable placeholder="请输入退款状态" v-model="form.refundStatus" />
    </el-form-item>

    <el-form-item  label="备注" prop="remark">
        <el-input clearable placeholder="请输入备注" v-model="form.remark" />
    </el-form-item>

    <el-form-item  label="是否删除" prop="isDeleted">
        <el-input clearable placeholder="请输入是否删除" v-model="form.isDeleted" />
    </el-form-item>

    <el-form-item  label="表名" prop="tableName">
        <el-input clearable placeholder="请输入表名" v-model="form.tableName" />
    </el-form-item>

    <el-form-item  label="字段名" prop="fieldName">
        <el-input clearable placeholder="请输入字段名" v-model="form.fieldName" />
    </el-form-item>

</el-form>
<base-layout
style="text-align: center;"
w_full="true"
>
<el-button
@click="submitForm"
round
color="#5D5FEF"
style="width: 200px;"
type="primary"
>保 存</el-button>
</base-layout>
</el-tab-pane>
<el-tab-pane
label="查看订单信息"
>
<order_info_component
 :params="{paymentOrderNo:routerQuery.id}"
 />
</el-tab-pane>
</el-tabs>
</base-wrapper>
</base-wrapper>
   
</template>

<script setup>

const { proxy } = getCurrentInstance();
let form = ref({});
let formAll = ref({});
let rules = ref({});
let routerQuery = proxy.$route.query;
let detail = ref('normally')

function submitForm() {
  proxy.$refs.dataFormRef.validate(async (valid) => {
    if (valid) {

      if(import.meta.env.VITE_APP_MODEL === 'PREVIEW'){
          let res = await proxy.$api.table['update']({
              table_name: 'general_orders',
              param: form.value
          });

          proxy.$modal.msgSuccess(res.message);

          if(res.code == 0){
              refresh();
          }
      }
      else{
          let res = await proxy.$api.general_orders['update'](form.value);
          proxy.$modal.msgSuccess(res.message);
          if(res.code == 0){
            refresh();
          }
      }
    }
  });
}

async function getDetail(id) {
    if(import.meta.env.VITE_APP_MODEL === 'PREVIEW'){
        let res = await proxy.$api.table.get({
            table_name: 'general_orders',
            param: {
                id: id
            }
        });

        if(res.code == 0){
            form.value = Object.assign({}, res.data);
        }
        else{
            proxy.$modal.msgError(res.message);
        }
    }
    else{
        let res = await proxy.$api.general_orders['get'](id);
        if(res.code == 0){
            form.value = Object.assign({}, res.data);
        }
        else{
            proxy.$modal.msgError(res.message);
        }
    }
}

async function getDetailAll(id){
    if(import.meta.env.VITE_APP_MODEL === 'PREVIEW'){
        let res = await proxy.$api.table.get({
            table_name: 'general_orders',
            param: {
                id: id
            }
        });

        if(res.code == 0){
            formAll.value = Object.assign({}, res.data);
        }
        else{
            proxy.$modal.msgError(res.message);
        }
    }
    else{
        let res = await proxy.$api.general_orders['get'](id);
        if(res.code == 0){
            formAll.value = Object.assign({}, res.data);
        }
        else{
            proxy.$modal.msgError(res.message);
        }
    }
}

function refresh(){
    if(routerQuery.id){
        getDetail(routerQuery.id);
    }
    if(detail.value == 'all'){
        if(routerQuery.id){
            getDetailAll(routerQuery.id);
        }
    }
}

refresh();

</script>

<style lang="scss" scoped>
</style>