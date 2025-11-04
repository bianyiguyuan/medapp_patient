<template>
     
  <base-wrapper
>
<div class="flex-between-start" style="background-color: #5D5FEF; height: 140px;">
    <div class="flex-c-center-start h-full">
      <div class="m-x-20">
          <span style="font-weight: bold; font-size: 20px; color: #FFFFFF;">预约信息</span>
      </div>
      <div class="m-x-20 m-t-4">
        <span style="font-size: 14px; color: #FFFFFF;">主键、用户ID、医生姓名、预约日期、预约时间段、预约状态、是否支付定金、定金金额、是否领取优惠券、预约码。</span>
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
:to="{ path: '/appointment_info' }"
>
预约信息管理
</el-breadcrumb-item>
<el-breadcrumb-item
>
预约信息详情
</el-breadcrumb-item>
</el-breadcrumb>
<base-wrapper
class="p-10"
>
<el-tabs
class="demo-tabs"
>
<el-tab-pane
label="预约信息详情"
>
<el-form
:model='form'
ref='dataFormRef'
label-position='top'
:rules='{"doctorName":[{"trigger":"blur","message":"医生姓名不能为空","required":true}],"statusEnumId":[{"trigger":"blur","message":"预约状态不能为空","required":true}],"appointmentTime":[{"trigger":"blur","message":"预约时间段不能为空","required":true}],"userInfoUserInfoId1":[{"trigger":"blur","message":"用户ID不能为空","required":true}],"appointmentDate":[{"trigger":"blur","message":"预约日期不能为空","required":true}]}'
label-width='150px'
>
    <el-form-item   label="用户ID" prop="userInfoUserInfoId1">
        <base-select clearable v-model="form.userInfoUserInfoId1" api="appointment_info_all.get_user_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="医生姓名" prop="doctorName">
        <el-input clearable placeholder="请输入医生姓名" v-model="form.doctorName" />
    </el-form-item>

    <el-form-item   label="预约日期" prop="appointmentDate">
        <el-date-picker placeholder="请输入预约日期" v-model="form.appointmentDate" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item  label="预约时间段" prop="appointmentTime">
        <el-input clearable placeholder="请输入预约时间段" v-model="form.appointmentTime" />
    </el-form-item>

    <el-form-item   label="预约状态" prop="statusEnumId">
        <base-select clearable v-model="form.statusEnumId" api="appointment_info_all.get_appointment_status_enum_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="是否支付定金" prop="depositPaid">
        <el-select v-model="form.depositPaid" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

    <el-form-item  label="定金金额" prop="depositAmount">
        <el-input clearable placeholder="请输入定金金额" v-model="form.depositAmount" />
    </el-form-item>

    <el-form-item  label="是否领取优惠券" prop="couponReceived">
        <el-select v-model="form.couponReceived" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

    <el-form-item  label="预约码" prop="appointmentCode">
        <el-input clearable placeholder="请输入预约码" v-model="form.appointmentCode" />
    </el-form-item>

</el-form>
<base-cell
header="所属用户信息"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="手机号"
>
{{ formAll.phoneNumber }}
</base-cell-item>
<base-cell-item
label="用户名"
>
{{ formAll.username }}
</base-cell-item>
<base-cell-item
label="密码"
>
{{ formAll.password }}
</base-cell-item>
<base-cell-item
label="邮箱"
>
{{ formAll.email }}
</base-cell-item>
<base-cell-item
label="会员等级"
>
{{ formAll.memberLevelId }}
</base-cell-item>
<base-cell-item
label="头像"
>
{{ formAll.avatarResourceKey }}
</base-cell-item>
</base-cell>
<base-cell
header="所属预约状态"
label-width="180px"
class="m-b-10"
>
<base-cell-item
label="状态名称"
>
{{ formAll.statusName }}
</base-cell-item>
</base-cell>
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
let detail = ref('all')

function submitForm() {
  proxy.$refs.dataFormRef.validate(async (valid) => {
    if (valid) {

      if(import.meta.env.VITE_APP_MODEL === 'PREVIEW'){
          let res = await proxy.$api.table['update']({
              table_name: 'appointment_info',
              param: form.value
          });

          proxy.$modal.msgSuccess(res.message);

          if(res.code == 0){
              refresh();
          }
      }
      else{
          let res = await proxy.$api.appointment_info['update'](form.value);
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
            table_name: 'appointment_info',
            param: {
                appointmentInfoId: id
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
        let res = await proxy.$api.appointment_info['get'](id);
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
            table_name: 'appointment_info',
            param: {
                appointmentInfoId: id
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
        let res = await proxy.$api.appointment_info_all['get'](id);
        if(res.code == 0){
            formAll.value = Object.assign({}, res.data);
        }
        else{
            proxy.$modal.msgError(res.message);
        }
    }
}

function refresh(){
    if(routerQuery.appointmentInfoId){
        getDetail(routerQuery.appointmentInfoId);
    }
    if(detail.value == 'all'){
        if(routerQuery.appointmentInfoId){
            getDetailAll(routerQuery.appointmentInfoId);
        }
    }
}

refresh();

</script>

<style lang="scss" scoped>
</style>