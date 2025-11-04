<template>
    <base-wrapper
>
<base-header>
<search-operation
@batchDeleteEvent="handleBatchDelete"
@downloadEvent="downloadTemplate"
@exportEvent="handleExport"
firstSearchComment="任务类型"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
uploadExcelAPI="delayed_tasks.import"
table_name="delayed_tasks"
firstSearchData="taskType"
>
<template #collapse>
    <el-form-item  label="任务类型" prop="taskType">
        <el-input clearable placeholder="请输入任务类型" v-model="listQuery.taskType" />
    </el-form-item>

    <el-form-item  label="任务数据" prop="taskData">
        <el-input clearable placeholder="请输入任务数据" v-model="listQuery.taskData" />
    </el-form-item>

    <el-form-item  label="任务状态" prop="status">
        <el-input clearable placeholder="请输入任务状态" v-model="listQuery.status" />
    </el-form-item>

    <el-form-item   label="执行时间" prop="executeTime">
        <el-date-picker placeholder="请输入执行时间" v-model="listQuery.executeTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="创建时间" prop="createTime">
        <el-date-picker placeholder="请输入创建时间" v-model="listQuery.createTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="更新时间" prop="updateTime">
        <el-date-picker placeholder="请输入更新时间" v-model="listQuery.updateTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
@selection-change="handleSelectionChange"
ref="baseTableRef"
:params="listQuery"
api="delayed_tasks.page"
>
<el-table-column
width="55"
type="selection"
align="center"
>

</el-table-column>
<el-table-column
prop="id"
label="主键"
align="center"
>

</el-table-column>
<el-table-column
prop="taskType"
label="任务类型"
align="center"
>

</el-table-column>
<el-table-column
prop="taskData"
label="任务数据"
align="center"
>

</el-table-column>
<el-table-column
prop="status"
label="任务状态"
align="center"
>

</el-table-column>
<el-table-column
prop="executeTime"
label="执行时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.executeTime,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
prop="createTime"
label="创建时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.createTime,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
prop="updateTime"
label="更新时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.updateTime,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
width="220"
fixed="right"
label="操作"
align="center"
>
<template #default="scope">
<base-info-btn
path="/delayed_tasks/detail"
:query="{id: scope.row.id}"
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
:rules='{"taskType":[{"trigger":"blur","message":"任务类型不能为空","required":true}],"createTime":[{"trigger":"blur","message":"创建时间不能为空","required":true}],"taskData":[{"trigger":"blur","message":"任务数据不能为空","required":true}],"updateTime":[{"trigger":"blur","message":"更新时间不能为空","required":true}],"status":[{"trigger":"blur","message":"任务状态不能为空","required":true}],"executeTime":[{"trigger":"blur","message":"执行时间不能为空","required":true}]}'
label-width='100px'
>
    <el-form-item  label="任务类型" prop="taskType">
        <el-input clearable placeholder="请输入任务类型" v-model="form.taskType" />
    </el-form-item>

    <el-form-item  label="任务数据" prop="taskData">
        <el-input clearable placeholder="请输入任务数据" v-model="form.taskData" />
    </el-form-item>

    <el-form-item  label="任务状态" prop="status">
        <el-input clearable placeholder="请输入任务状态" v-model="form.status" />
    </el-form-item>

    <el-form-item   label="执行时间" prop="executeTime">
        <el-date-picker placeholder="请输入执行时间" v-model="form.executeTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

</el-form>
<base-cell
v-else
label-width="100px"
>
<base-cell-item
label="主键"
>
{{ form.id }}
</base-cell-item>
<base-cell-item
label="任务类型"
>
{{ form.taskType }}
</base-cell-item>
<base-cell-item
label="任务数据"
>
{{ form.taskData }}
</base-cell-item>
<base-cell-item
label="任务状态"
>
{{ form.status }}
</base-cell-item>
<base-cell-item
label="执行时间"
>
{{ form.executeTime }}
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
    multipleSelection.value = selection.map(item => item.id);
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
        table_name: 'delayed_tasks',
        param: {
            id: row.id
        }
    });
    proxy.$modal.msgSuccess(res.message);
  }
  else{
    let res = await proxy.$api.delayed_tasks.delete(row.id);
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
        table_name: 'delayed_tasks',
        param: {
        ids: ids
        }
    });
    } else {
        res = await proxy.$api.delayed_tasks.deleteBatch(ids);
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
    await proxy.$api.delayed_tasks.downloadExcel({
      ...listQuery.value
    }, `${new Date().getTime()}.xlsx`, "export", "post")
  }catch (error) {
    console.error("导出失败", error)
  }
}
async function downloadTemplate() {
  try {
    await proxy.$api.delayed_tasks.downloadExcel({
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
                table_name: 'delayed_tasks',
                param: form.value
            });
            proxy.$modal.msgSuccess(res.message);
          }
          else{
            let res = await proxy.$api.delayed_tasks[dialogStatus.value](form.value);
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