<template>
     
  <base-wrapper
>
<div class="flex-between-start" style="background-color: #5D5FEF; height: 140px;">
    <div class="flex-c-center-start h-full">
      <div class="m-x-20">
          <span style="font-weight: bold; font-size: 20px; color: #FFFFFF;">品牌商品信息</span>
      </div>
      <div class="m-x-20 m-t-4">
        <span style="font-size: 14px; color: #FFFFFF;">主键、商品名称、价格、商品图片、优惠券金额、品牌小程序路径。</span>
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
:to="{ path: '/product_info' }"
>
品牌商品信息管理
</el-breadcrumb-item>
<el-breadcrumb-item
>
品牌商品信息详情
</el-breadcrumb-item>
</el-breadcrumb>
<base-wrapper
class="p-10"
>
<el-tabs
class="demo-tabs"
>
<el-tab-pane
label="品牌商品信息详情"
>
<el-form
:model='form'
ref='dataFormRef'
label-position='top'
:rules='{"price":[{"trigger":"blur","message":"价格不能为空","required":true}],"productName":[{"trigger":"blur","message":"商品名称不能为空","required":true}]}'
label-width='150px'
>
    <el-form-item  label="商品名称" prop="productName">
        <el-input clearable placeholder="请输入商品名称" v-model="form.productName" />
    </el-form-item>

    <el-form-item  label="价格" prop="price">
        <el-input clearable placeholder="请输入价格" v-model="form.price" />
    </el-form-item>

    <el-form-item  label="商品图片" prop="imageResourceKey">
        <image-upload :limit="5" v-model="form.image" :type="true" />
    </el-form-item>

    <el-form-item  label="优惠券金额" prop="couponAmount">
        <el-input clearable placeholder="请输入优惠券金额" v-model="form.couponAmount" />
    </el-form-item>

    <el-form-item  label="品牌小程序路径" prop="miniProgramPath">
        <el-input clearable placeholder="请输入品牌小程序路径" v-model="form.miniProgramPath" />
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
 :params="{productInfoProductInfoId:routerQuery.productInfoId}"
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
              table_name: 'product_info',
              param: form.value
          });

          proxy.$modal.msgSuccess(res.message);

          if(res.code == 0){
              refresh();
          }
      }
      else{
          let res = await proxy.$api.product_info['update'](form.value);
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
            table_name: 'product_info',
            param: {
                productInfoId: id
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
        let res = await proxy.$api.product_info['get'](id);
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
            table_name: 'product_info',
            param: {
                productInfoId: id
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
        let res = await proxy.$api.product_info['get'](id);
        if(res.code == 0){
            formAll.value = Object.assign({}, res.data);
        }
        else{
            proxy.$modal.msgError(res.message);
        }
    }
}

function refresh(){
    if(routerQuery.productInfoId){
        getDetail(routerQuery.productInfoId);
    }
    if(detail.value == 'all'){
        if(routerQuery.productInfoId){
            getDetailAll(routerQuery.productInfoId);
        }
    }
}

refresh();

</script>

<style lang="scss" scoped>
</style>