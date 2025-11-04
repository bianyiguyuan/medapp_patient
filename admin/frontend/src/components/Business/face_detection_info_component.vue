<template>
    <base-wrapper
>
<base-header>
<search-operation
@batchDeleteEvent="handleBatchDelete"
@downloadEvent="downloadTemplate"
@exportEvent="handleExport"
firstSearchComment="显老部位"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
uploadExcelAPI="face_detection_info.import"
table_name="face_detection_info"
firstSearchData="agingParts"
>
<template #collapse>
    <el-form-item v-show="!props.params.userInfoUserInfoId2"  label="用户ID" prop="userInfoUserInfoId2">
        <base-select clearable v-model="listQuery.userInfoUserInfoId2" api="face_detection_info_all.get_user_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="印象年龄" prop="impressionAge">
        <el-input clearable placeholder="请输入印象年龄" v-model="listQuery.impressionAge" />
    </el-form-item>

    <el-form-item  label="显老部位" prop="agingParts">
        <el-input clearable placeholder="请输入显老部位" v-model="listQuery.agingParts" />
    </el-form-item>

    <el-form-item  label="深度分析是否解锁" prop="deepAnalysisUnlocked">
        <el-select v-model="listQuery.deepAnalysisUnlocked" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

    <el-form-item  label="定制方案是否解锁" prop="customPlanUnlocked">
        <el-select v-model="listQuery.customPlanUnlocked" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
@selection-change="handleSelectionChange"
ref="baseTableRef"
:params="listQuery"
api="face_detection_info_all.page"
>
<el-table-column
width="55"
type="selection"
align="center"
>

</el-table-column>
<el-table-column
prop="faceDetectionInfoId"
label="主键"
align="center"
>

</el-table-column>
<el-table-column
prop="uploadImageResourceKey"
label="上传人脸图片"
align="center"
>
<template #default="scope">
<image-preview
:height="50"
:src="scope.row.uploadImage.map(item => item.url).join(',')"
:width="50"
/>
</template>
</el-table-column>
<el-table-column
prop="impressionAge"
label="印象年龄"
align="center"
>

</el-table-column>
<el-table-column
prop="agingParts"
label="显老部位"
align="center"
>

</el-table-column>
<el-table-column
prop="deepAnalysisUnlocked"
label="深度分析是否解锁"
align="center"
>
<template #default="scope">
{{  scope.row.deepAnalysisUnlocked? '是':'否' }}
</template>
</el-table-column>
<el-table-column
prop="customPlanUnlocked"
label="定制方案是否解锁"
align="center"
>
<template #default="scope">
{{  scope.row.customPlanUnlocked? '是':'否' }}
</template>
</el-table-column>
<el-table-column
prop="phoneNumber"
label="用户ID"
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
path="/face_detection_info/detail"
:query="{faceDetectionInfoId: scope.row.faceDetectionInfoId}"
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
:rules='{"userInfoUserInfoId2":[{"trigger":"blur","message":"用户ID不能为空","required":true}]}'
label-width='100px'
>
    <el-form-item v-show="!props.params.userInfoUserInfoId2"  label="用户ID" prop="userInfoUserInfoId2">
        <base-select clearable v-model="form.userInfoUserInfoId2" api="face_detection_info_all.get_user_info_list" show_name=""></base-select>
    </el-form-item>

    <el-form-item  label="上传人脸图片" prop="uploadImageResourceKey">
        <image-upload :limit="5" v-model="form.uploadImage" :type="true" />
    </el-form-item>

    <el-form-item  label="印象年龄" prop="impressionAge">
        <el-input clearable placeholder="请输入印象年龄" v-model="form.impressionAge" />
    </el-form-item>

    <el-form-item  label="显老部位" prop="agingParts">
        <el-input clearable placeholder="请输入显老部位" v-model="form.agingParts" />
    </el-form-item>

    <el-form-item  label="深度分析是否解锁" prop="deepAnalysisUnlocked">
        <el-select v-model="form.deepAnalysisUnlocked" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

    <el-form-item  label="定制方案是否解锁" prop="customPlanUnlocked">
        <el-select v-model="form.customPlanUnlocked" placeholder="请选择">
            <el-option label="是" :value="true"></el-option>
            <el-option label="否" :value="false"></el-option>
        </el-select>
    </el-form-item>

</el-form>
<base-cell
v-else
label-width="100px"
>
<base-cell-item
label="主键"
>
{{ form.faceDetectionInfoId }}
</base-cell-item>
<base-cell-item
label="用户ID"
>
{{ form.userInfoUserInfoId2 }}
</base-cell-item>
<base-cell-item
label="上传人脸图片"
>
{{ form.uploadImageResourceKey }}
</base-cell-item>
<base-cell-item
label="印象年龄"
>
{{ form.impressionAge }}
</base-cell-item>
<base-cell-item
label="显老部位"
>
{{ form.agingParts }}
</base-cell-item>
<base-cell-item
label="深度分析是否解锁"
>
{{ form.deepAnalysisUnlocked }}
</base-cell-item>
<base-cell-item
label="定制方案是否解锁"
>
{{ form.customPlanUnlocked }}
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
    multipleSelection.value = selection.map(item => item.face_detection_info_id);
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
        table_name: 'face_detection_info',
        param: {
            faceDetectionInfoId: row.faceDetectionInfoId
        }
    });
    proxy.$modal.msgSuccess(res.message);
  }
  else{
    let res = await proxy.$api.face_detection_info.delete(row.faceDetectionInfoId);
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
        table_name: 'face_detection_info',
        param: {
        ids: ids
        }
    });
    } else {
        res = await proxy.$api.face_detection_info.deleteBatch(ids);
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
    await proxy.$api.face_detection_info_all.downloadExcel({
      ...listQuery.value
    }, `${new Date().getTime()}.xlsx`, "export", "post")
  }catch (error) {
    console.error("导出失败", error)
  }
}
async function downloadTemplate() {
  try {
    await proxy.$api.face_detection_info.downloadExcel({
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
                table_name: 'face_detection_info',
                param: form.value
            });
            proxy.$modal.msgSuccess(res.message);
          }
          else{
            let res = await proxy.$api.face_detection_info[dialogStatus.value](form.value);
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