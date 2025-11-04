<template>
    <base-wrapper
>
<base-header>
<search-operation
@batchDeleteEvent="handleBatchDelete"
@downloadEvent="downloadTemplate"
@exportEvent="handleExport"
firstSearchComment="医生姓名"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
uploadExcelAPI="appointment_info.import"
table_name="appointment_info"
firstSearchData="doctorName"
>
<template #collapse>
    <el-form-item v-show="!props.params.userInfoUserInfoId1"  label="用户ID" prop="userInfoUserInfoId1">
        <base-select clearable v-model="listQuery.userInfoUserInfoId1" api="appointment_info_all.get_user_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="医生姓名" prop="doctorName">
        <el-input clearable placeholder="请输入医生姓名" v-model="listQuery.doctorName" />
    </el-form-item>

    <el-form-item   label="预约日期" prop="appointmentDate">
        <el-date-picker placeholder="请输入预约日期" v-model="listQuery.appointmentDate" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item  label="预约时间段" prop="appointmentTime">
        <el-input clearable placeholder="请输入预约时间段" v-model="listQuery.appointmentTime" />
    </el-form-item>

    <el-form-item v-show="!props.params.statusEnumId"  label="预约状态" prop="statusEnumId">
        <base-select clearable v-model="listQuery.statusEnumId" api="appointment_info_all.get_appointment_status_enum_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="是否支付定金" prop="depositPaid">
        <el-select v-model="listQuery.depositPaid" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

    <el-form-item  label="定金金额" prop="depositAmount">
        <el-input clearable placeholder="请输入定金金额" v-model="listQuery.depositAmount" />
    </el-form-item>

    <el-form-item  label="是否领取优惠券" prop="couponReceived">
        <el-select v-model="listQuery.couponReceived" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

    <el-form-item  label="预约码" prop="appointmentCode">
        <el-input clearable placeholder="请输入预约码" v-model="listQuery.appointmentCode" />
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
@selection-change="handleSelectionChange"
ref="baseTableRef"
:params="listQuery"
api="appointment_info_all.page"
>
<el-table-column
width="55"
type="selection"
align="center"
>

</el-table-column>
<el-table-column
prop="appointmentInfoId"
label="主键"
align="center"
>

</el-table-column>
<el-table-column
prop="doctorName"
label="医生姓名"
align="center"
>

</el-table-column>
<el-table-column
prop="appointmentDate"
label="预约日期"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.appointmentDate,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
prop="appointmentTime"
label="预约时间段"
align="center"
>

</el-table-column>
<el-table-column
prop="depositPaid"
label="是否支付定金"
align="center"
>
<template #default="scope">
{{  scope.row.depositPaid? '是':'否' }}
</template>
</el-table-column>
<el-table-column
prop="depositAmount"
label="定金金额"
align="center"
>

</el-table-column>
<el-table-column
prop="couponReceived"
label="是否领取优惠券"
align="center"
>
<template #default="scope">
{{  scope.row.couponReceived? '是':'否' }}
</template>
</el-table-column>
<el-table-column
prop="appointmentCode"
label="预约码"
align="center"
>

</el-table-column>
<el-table-column
prop="phoneNumber"
label="用户ID"
align="center"
>

</el-table-column>
<el-table-column
prop="statusName"
label="预约状态"
align="center"
>

</el-table-column>
<el-table-column
width="220"
fixed="right"
label="操作"
align="center"
>
<template #default="scope">
<base-info-btn
path="/appointment_info/detail"
:query="{appointmentInfoId: scope.row.appointmentInfoId}"
text="详情"
>
</base-info-btn>
<base-edit-btn
@ok="handleUpdate(scope.row)"
>
</base-edit-btn>
<base-delete-btn
@ok="handleDelete(scope.row)"
></base-delete-btn>
</template>
</el-table-column>
</base-table-p>
<base-dialog
v-if="dialogVisible"
:title="dialogTitleObj[dialogStatus]"
width="50%"
style="max-width: 600px;"
v-model="dialogVisible"
>
<el-form
ref='dataFormRef'
v-if='dialogStatus !== "detail"'
:model='form'
label-position='top'
:rules='{"doctorName":[{"trigger":"blur","message":"医生姓名不能为空","required":true}],"statusEnumId":[{"trigger":"blur","message":"预约状态不能为空","required":true}],"appointmentTime":[{"trigger":"blur","message":"预约时间段不能为空","required":true}],"userInfoUserInfoId1":[{"trigger":"blur","message":"用户ID不能为空","required":true}],"appointmentDate":[{"trigger":"blur","message":"预约日期不能为空","required":true}]}'
label-width='100px'
>
    <el-form-item v-show="!props.params.userInfoUserInfoId1"  label="用户ID" prop="userInfoUserInfoId1">
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

    <el-form-item v-show="!props.params.statusEnumId"  label="预约状态" prop="statusEnumId">
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
v-else
label-width="100px"
>
<base-cell-item
label="主键"
>
{{ form.appointmentInfoId }}
</base-cell-item>
<base-cell-item
label="用户ID"
>
{{ form.userInfoUserInfoId1 }}
</base-cell-item>
<base-cell-item
label="医生姓名"
>
{{ form.doctorName }}
</base-cell-item>
<base-cell-item
label="预约日期"
>
{{ form.appointmentDate }}
</base-cell-item>
<base-cell-item
label="预约时间段"
>
{{ form.appointmentTime }}
</base-cell-item>
<base-cell-item
label="预约状态"
>
{{ form.statusEnumId }}
</base-cell-item>
<base-cell-item
label="是否支付定金"
>
{{ form.depositPaid }}
</base-cell-item>
<base-cell-item
label="定金金额"
>
{{ form.depositAmount }}
</base-cell-item>
<base-cell-item
label="是否领取优惠券"
>
{{ form.couponReceived }}
</base-cell-item>
<base-cell-item
label="预约码"
>
{{ form.appointmentCode }}
</base-cell-item>
</base-cell>
<template #footer>
<el-button
@click="dialogVisible = false"
round
>取 消</el-button>
<el-button
@click="submitForm"
round
color="#5D5FEF"
type="primary"
>确 定</el-button>
</template>
</base-dialog>
</base-wrapper>
</template>

<script setup>
import {ElMessageBox} from "element-plus";

const { proxy } = getCurrentInstance();

const props = defineProps({
    params: { type: Object, default: () => ({}) },
})
let multipleSelection = ref([])
function handleSelectionChange(selection) {
    multipleSelection.value = selection.map(item => item.appointment_info_id);
}

// 计算属性，用于判断 params 的长度
const paramsLength = computed(() =>  Object.keys(props.params).length)

// 计算属性，判断 params 是否为空
const isParamsEmpty = computed(() => paramsLength.value === 0)

let listQuery = ref({});
let form = ref({});
let dialogVisible = ref(false);
let dialogStatus = ref('');
let dialogTitleObj = ref({ update: '编辑', add: '添加', detail: '详情'});
let rules = ref({});
if(isParamsEmpty.value){
  let routerQuery = proxy.$route.query;
  Object.assign(listQuery.value, routerQuery);
}
else{
  Object.assign(listQuery.value, props.params);
}


function refreshTableData() {
  proxy.$refs.baseTableRef.refresh();
}
function handleDetail(row) {
  form.value = Object.assign({}, row);
  dialogStatus.value = 'detail';
  dialogVisible.value = true;
}
function handleAdd() {
  form.value = { ...props.params };
  dialogStatus.value = 'add';
  dialogVisible.value = true;
}
function handleUpdate(row) {
  form.value = Object.assign({}, row);
  dialogStatus.value = 'update';
  dialogVisible.value = true;
}
async function handleDelete(row) {
  if(import.meta.env.VITE_APP_MODEL === 'PREVIEW'){
    let res = await proxy.$api.table.delete({
        table_name: 'appointment_info',
        param: {
            appointmentInfoId: row.appointmentInfoId
        }
    });
    proxy.$modal.msgSuccess(res.message);
  }
  else{
    let res = await proxy.$api.appointment_info.delete(row.appointmentInfoId);
    proxy.$modal.msgSuccess(res.message);
  }
  refreshTableData();
}

// 批量删除
async function handleBatchDelete() {
    if (multipleSelection.value.length === 0) return;

    try {
    await ElMessageBox.confirm(
        `确定要删除选中的 ${multipleSelection.value.length} 条数据吗？`,
        '提示',
        {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
        }
    );
    const ids = multipleSelection.value
    let res;

    if (import.meta.env.VITE_APP_MODEL === 'PREVIEW') {
    res = await proxy.$api.table.deleteBatch({
        table_name: 'appointment_info',
        param: {
        ids: ids
        }
    });
    } else {
        res = await proxy.$api.appointment_info.deleteBatch(ids);
    }

    proxy.$modal.msgSuccess(res.message || "批量删除成功");
    refreshTableData();
    multipleSelection.value = [];
    } catch (error) {
        console.error("批量删除失败", error);
    }
}
async function handleExport() {
  try {
    await proxy.$api.appointment_info_all.downloadExcel({
      ...listQuery.value
    }, `${new Date().getTime()}.xlsx`, "export", "post")
  }catch (error) {
    console.error("导出失败", error)
  }
}
async function downloadTemplate() {
  try {
    await proxy.$api.appointment_info.downloadExcel({
      ...listQuery.value
    }, `${new Date().getTime()}.xlsx`, "downloadTemplate", "get")
  }catch (error) {
    console.error("导出失败", error)
  }
}
function submitForm() {
  if(dialogStatus.value == 'detail'){
      dialogVisible.value = false;
  }
  else {
      proxy.$refs.dataFormRef.validate(async (valid) => {
        if (valid) {
          if(import.meta.env.VITE_APP_MODEL === 'PREVIEW'){
            let res = await proxy.$api.table[dialogStatus.value]({
                table_name: 'appointment_info',
                param: form.value
            });
            proxy.$modal.msgSuccess(res.message);
          }
          else{
            let res = await proxy.$api.appointment_info[dialogStatus.value](form.value);
            proxy.$modal.msgSuccess(res.message);
          }
          refreshTableData();
          dialogVisible.value = false;
        }
      });
  }
}

function choose(item){
    form.value = Object.assign({}, item);
    dialogVisible.value = true;
    dialogStatus.value = 'update';
}
</script>

<style lang="scss" scoped>
</style>