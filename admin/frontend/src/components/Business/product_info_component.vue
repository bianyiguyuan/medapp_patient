<template>
    <base-wrapper
>
<base-header>
<search-operation
@batchDeleteEvent="handleBatchDelete"
@downloadEvent="downloadTemplate"
@exportEvent="handleExport"
firstSearchComment="商品名称"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
uploadExcelAPI="product_info.import"
table_name="product_info"
firstSearchData="productName"
>
<template #collapse>
    <el-form-item  label="商品名称" prop="productName">
        <el-input clearable placeholder="请输入商品名称" v-model="listQuery.productName" />
    </el-form-item>

    <el-form-item  label="价格" prop="price">
        <el-input clearable placeholder="请输入价格" v-model="listQuery.price" />
    </el-form-item>

    <el-form-item  label="优惠券金额" prop="couponAmount">
        <el-input clearable placeholder="请输入优惠券金额" v-model="listQuery.couponAmount" />
    </el-form-item>

    <el-form-item  label="品牌小程序路径" prop="miniProgramPath">
        <el-input clearable placeholder="请输入品牌小程序路径" v-model="listQuery.miniProgramPath" />
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
@selection-change="handleSelectionChange"
ref="baseTableRef"
:params="listQuery"
api="product_info.page"
>
<el-table-column
width="55"
type="selection"
align="center"
>

</el-table-column>
<el-table-column
prop="productInfoId"
label="主键"
align="center"
>

</el-table-column>
<el-table-column
prop="productName"
label="商品名称"
align="center"
>

</el-table-column>
<el-table-column
prop="price"
label="价格"
align="center"
>

</el-table-column>
<el-table-column
prop="imageResourceKey"
label="商品图片"
align="center"
>
<template #default="scope">
<image-preview
:height="50"
:src="scope.row.image.map(item => item.url).join(',')"
:width="50"
/>
</template>
</el-table-column>
<el-table-column
prop="couponAmount"
label="优惠券金额"
align="center"
>

</el-table-column>
<el-table-column
prop="miniProgramPath"
label="品牌小程序路径"
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
path="/product_info/detail"
:query="{productInfoId: scope.row.productInfoId}"
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
:rules='{"price":[{"trigger":"blur","message":"价格不能为空","required":true}],"productName":[{"trigger":"blur","message":"商品名称不能为空","required":true}]}'
label-width='100px'
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
<base-cell
v-else
label-width="100px"
>
<base-cell-item
label="主键"
>
{{ form.productInfoId }}
</base-cell-item>
<base-cell-item
label="商品名称"
>
{{ form.productName }}
</base-cell-item>
<base-cell-item
label="价格"
>
{{ form.price }}
</base-cell-item>
<base-cell-item
label="商品图片"
>
{{ form.imageResourceKey }}
</base-cell-item>
<base-cell-item
label="优惠券金额"
>
{{ form.couponAmount }}
</base-cell-item>
<base-cell-item
label="品牌小程序路径"
>
{{ form.miniProgramPath }}
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
    multipleSelection.value = selection.map(item => item.product_info_id);
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
        table_name: 'product_info',
        param: {
            productInfoId: row.productInfoId
        }
    });
    proxy.$modal.msgSuccess(res.message);
  }
  else{
    let res = await proxy.$api.product_info.delete(row.productInfoId);
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
        table_name: 'product_info',
        param: {
        ids: ids
        }
    });
    } else {
        res = await proxy.$api.product_info.deleteBatch(ids);
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
    await proxy.$api.product_info.downloadExcel({
      ...listQuery.value
    }, `${new Date().getTime()}.xlsx`, "export", "post")
  }catch (error) {
    console.error("导出失败", error)
  }
}
async function downloadTemplate() {
  try {
    await proxy.$api.product_info.downloadExcel({
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
                table_name: 'product_info',
                param: form.value
            });
            proxy.$modal.msgSuccess(res.message);
          }
          else{
            let res = await proxy.$api.product_info[dialogStatus.value](form.value);
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