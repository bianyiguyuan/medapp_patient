<template>
    <base-wrapper
>
<base-header>
<search-operation
@batchDeleteEvent="handleBatchDelete"
@downloadEvent="downloadTemplate"
@exportEvent="handleExport"
firstSearchComment="支付订单号"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
uploadExcelAPI="order_info.import"
table_name="order_info"
firstSearchData="paymentOrderNo"
>
<template #collapse>
    <el-form-item v-show="!props.params.userInfoUserInfoId5"  label="用户ID" prop="userInfoUserInfoId5">
        <base-select clearable v-model="listQuery.userInfoUserInfoId5" api="order_info_all.get_user_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.productInfoProductInfoId"  label="商品ID" prop="productInfoProductInfoId">
        <base-select clearable v-model="listQuery.productInfoProductInfoId" api="order_info_all.get_product_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="购买数量" prop="quantity">
        <el-input clearable placeholder="请输入购买数量" v-model="listQuery.quantity" />
    </el-form-item>

    <el-form-item  label="总价" prop="totalPrice">
        <el-input clearable placeholder="请输入总价" v-model="listQuery.totalPrice" />
    </el-form-item>

    <el-form-item v-show="!props.params.orderStatusEnumId"  label="订单状态" prop="orderStatusEnumId">
        <base-select clearable v-model="listQuery.orderStatusEnumId" api="order_info_all.get_order_status_enum_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.paymentOrderNo"  label="支付订单号" prop="paymentOrderNo">
        <base-select clearable v-model="listQuery.paymentOrderNo" api="order_info_all.get_general_orders_list" show_name=""></base-select>
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
@selection-change="handleSelectionChange"
ref="baseTableRef"
:params="listQuery"
api="order_info_all.page"
>
<el-table-column
width="55"
type="selection"
align="center"
>

</el-table-column>
<el-table-column
prop="orderInfoId"
label="主键"
align="center"
>

</el-table-column>
<el-table-column
prop="quantity"
label="购买数量"
align="center"
>

</el-table-column>
<el-table-column
prop="totalPrice"
label="总价"
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
prop="productName"
label="商品ID"
align="center"
>

</el-table-column>
<el-table-column
prop="statusName"
label="订单状态"
align="center"
>

</el-table-column>
<el-table-column
prop="paymentOrderId"
label="支付订单号"
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
path="/order_info/detail"
:query="{orderInfoId: scope.row.orderInfoId}"
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
:rules='{"userInfoUserInfoId5":[{"trigger":"blur","message":"用户ID不能为空","required":true}],"quantity":[{"trigger":"blur","message":"购买数量不能为空","required":true}],"productInfoProductInfoId":[{"trigger":"blur","message":"商品ID不能为空","required":true}],"totalPrice":[{"trigger":"blur","message":"总价不能为空","required":true}],"orderStatusEnumId":[{"trigger":"blur","message":"订单状态不能为空","required":true}]}'
label-width='100px'
>
    <el-form-item v-show="!props.params.userInfoUserInfoId5"  label="用户ID" prop="userInfoUserInfoId5">
        <base-select clearable v-model="form.userInfoUserInfoId5" api="order_info_all.get_user_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.productInfoProductInfoId"  label="商品ID" prop="productInfoProductInfoId">
        <base-select clearable v-model="form.productInfoProductInfoId" api="order_info_all.get_product_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="购买数量" prop="quantity">
        <el-input clearable placeholder="请输入购买数量" v-model="form.quantity" />
    </el-form-item>

    <el-form-item  label="总价" prop="totalPrice">
        <el-input clearable placeholder="请输入总价" v-model="form.totalPrice" />
    </el-form-item>

    <el-form-item v-show="!props.params.orderStatusEnumId"  label="订单状态" prop="orderStatusEnumId">
        <base-select clearable v-model="form.orderStatusEnumId" api="order_info_all.get_order_status_enum_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item v-show="!props.params.paymentOrderNo"  label="支付订单号" prop="paymentOrderNo">
        <base-select clearable v-model="form.paymentOrderNo" api="order_info_all.get_general_orders_list" show_name=""></base-select>
    </el-form-item>

</el-form>
<base-cell
v-else
label-width="100px"
>
<base-cell-item
label="主键"
>
{{ form.orderInfoId }}
</base-cell-item>
<base-cell-item
label="用户ID"
>
{{ form.userInfoUserInfoId5 }}
</base-cell-item>
<base-cell-item
label="商品ID"
>
{{ form.productInfoProductInfoId }}
</base-cell-item>
<base-cell-item
label="购买数量"
>
{{ form.quantity }}
</base-cell-item>
<base-cell-item
label="总价"
>
{{ form.totalPrice }}
</base-cell-item>
<base-cell-item
label="订单状态"
>
{{ form.orderStatusEnumId }}
</base-cell-item>
<base-cell-item
label="支付订单号"
>
{{ form.paymentOrderNo }}
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
    multipleSelection.value = selection.map(item => item.order_info_id);
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
        table_name: 'order_info',
        param: {
            orderInfoId: row.orderInfoId
        }
    });
    proxy.$modal.msgSuccess(res.message);
  }
  else{
    let res = await proxy.$api.order_info.delete(row.orderInfoId);
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
        table_name: 'order_info',
        param: {
        ids: ids
        }
    });
    } else {
        res = await proxy.$api.order_info.deleteBatch(ids);
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
    await proxy.$api.order_info_all.downloadExcel({
      ...listQuery.value
    }, `${new Date().getTime()}.xlsx`, "export", "post")
  }catch (error) {
    console.error("导出失败", error)
  }
}
async function downloadTemplate() {
  try {
    await proxy.$api.order_info.downloadExcel({
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
                table_name: 'order_info',
                param: form.value
            });
            proxy.$modal.msgSuccess(res.message);
          }
          else{
            let res = await proxy.$api.order_info[dialogStatus.value](form.value);
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