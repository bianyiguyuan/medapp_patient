<template>
    <base-wrapper
>
<base-header>
<search-operation
@batchDeleteEvent="handleBatchDelete"
@downloadEvent="downloadTemplate"
@exportEvent="handleExport"
firstSearchComment="订单编号"
:searchData="listQuery"
@refreshTableData="refreshTableData"
@addEvent="handleAdd"
uploadExcelAPI="general_orders.import"
table_name="general_orders"
firstSearchData="orderNo"
>
<template #collapse>
    <el-form-item  label="订单编号" prop="orderNo">
        <el-input clearable placeholder="请输入订单编号" v-model="listQuery.orderNo" />
    </el-form-item>

    <el-form-item  label="用户ID" prop="userId">
        <el-input clearable placeholder="请输入用户ID" v-model="listQuery.userId" />
    </el-form-item>

    <el-form-item  label="操作ID" prop="opId">
        <el-input clearable placeholder="请输入操作ID" v-model="listQuery.opId" />
    </el-form-item>

    <el-form-item  label="订单类型" prop="orderType">
        <el-input clearable placeholder="请输入订单类型" v-model="listQuery.orderType" />
    </el-form-item>

    <el-form-item  label="订单状态" prop="orderStatus">
        <el-input clearable placeholder="请输入订单状态" v-model="listQuery.orderStatus" />
    </el-form-item>

    <el-form-item  label="支付状态" prop="payStatus">
        <el-input clearable placeholder="请输入支付状态" v-model="listQuery.payStatus" />
    </el-form-item>

    <el-form-item  label="发货状态" prop="deliveryStatus">
        <el-input clearable placeholder="请输入发货状态" v-model="listQuery.deliveryStatus" />
    </el-form-item>

    <el-form-item  label="商品ID" prop="productsId">
        <el-input clearable placeholder="请输入商品ID" v-model="listQuery.productsId" />
    </el-form-item>

    <el-form-item  label="商品数量" prop="quality">
        <el-input clearable placeholder="请输入商品数量" v-model="listQuery.quality" />
    </el-form-item>

    <el-form-item  label="订单总额" prop="totalAmount">
        <el-input clearable placeholder="请输入订单总额" v-model="listQuery.totalAmount" />
    </el-form-item>

    <el-form-item  label="优惠金额" prop="discountAmount">
        <el-input clearable placeholder="请输入优惠金额" v-model="listQuery.discountAmount" />
    </el-form-item>

    <el-form-item  label="运费" prop="shippingFee">
        <el-input clearable placeholder="请输入运费" v-model="listQuery.shippingFee" />
    </el-form-item>

    <el-form-item  label="实付金额" prop="actualAmount">
        <el-input clearable placeholder="请输入实付金额" v-model="listQuery.actualAmount" />
    </el-form-item>

    <el-form-item  label="支付渠道" prop="paymentChannel">
        <el-input clearable placeholder="请输入支付渠道" v-model="listQuery.paymentChannel" />
    </el-form-item>

    <el-form-item  label="支付订单号" prop="paymentOrderId">
        <el-input clearable placeholder="请输入支付订单号" v-model="listQuery.paymentOrderId" />
    </el-form-item>

    <el-form-item   label="支付时间" prop="paymentTime">
        <el-date-picker placeholder="请输入支付时间" v-model="listQuery.paymentTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item  label="支付金额" prop="paymentAmount">
        <el-input clearable placeholder="请输入支付金额" v-model="listQuery.paymentAmount" />
    </el-form-item>

    <el-form-item  label="配送方式" prop="shippingMethod">
        <el-input clearable placeholder="请输入配送方式" v-model="listQuery.shippingMethod" />
    </el-form-item>

    <el-form-item  label="配送地址" prop="shippingAddress">
        <el-input clearable placeholder="请输入配送地址" v-model="listQuery.shippingAddress" />
    </el-form-item>

    <el-form-item  label="物流公司" prop="shippingCompany">
        <el-input clearable placeholder="请输入物流公司" v-model="listQuery.shippingCompany" />
    </el-form-item>

    <el-form-item  label="运单号" prop="trackingNumber">
        <el-input clearable placeholder="请输入运单号" v-model="listQuery.trackingNumber" />
    </el-form-item>

    <el-form-item  label="收件人电话" prop="tel">
        <el-input clearable placeholder="请输入收件人电话" v-model="listQuery.tel" />
    </el-form-item>

    <el-form-item  label="收件人" prop="recipient">
        <el-input clearable placeholder="请输入收件人" v-model="listQuery.recipient" />
    </el-form-item>

    <el-form-item   label="创建时间" prop="createTime">
        <el-date-picker placeholder="请输入创建时间" v-model="listQuery.createTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="更新时间" prop="updateTime">
        <el-date-picker placeholder="请输入更新时间" v-model="listQuery.updateTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="取消时间" prop="cancelTime">
        <el-date-picker placeholder="请输入取消时间" v-model="listQuery.cancelTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="完成时间" prop="completeTime">
        <el-date-picker placeholder="请输入完成时间" v-model="listQuery.completeTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item   label="发货时间" prop="deliverTime">
        <el-date-picker placeholder="请输入发货时间" v-model="listQuery.deliverTime" type="datetime"
         format="YYYY-MM-DD HH:mm:ss" value-format="YYYY-MM-DD HH:mm:ss" />
    </el-form-item>

    <el-form-item  label="支付系统退款单号" prop="refundId">
        <el-input clearable placeholder="请输入支付系统退款单号" v-model="listQuery.refundId" />
    </el-form-item>

    <el-form-item  label="业务系统" prop="refundNo">
        <el-input clearable placeholder="请输入业务系统" v-model="listQuery.refundNo" />
    </el-form-item>

    <el-form-item  label="退款类型" prop="refundType">
        <el-input clearable placeholder="请输入退款类型" v-model="listQuery.refundType" />
    </el-form-item>

    <el-form-item  label="退款金额" prop="refundAmount">
        <el-input clearable placeholder="请输入退款金额" v-model="listQuery.refundAmount" />
    </el-form-item>

    <el-form-item  label="退款原因" prop="refundReason">
        <el-input clearable placeholder="请输入退款原因" v-model="listQuery.refundReason" />
    </el-form-item>

    <el-form-item  label="退款状态" prop="refundStatus">
        <el-input clearable placeholder="请输入退款状态" v-model="listQuery.refundStatus" />
    </el-form-item>

    <el-form-item  label="备注" prop="remark">
        <el-input clearable placeholder="请输入备注" v-model="listQuery.remark" />
    </el-form-item>

    <el-form-item  label="是否删除" prop="isDeleted">
        <el-input clearable placeholder="请输入是否删除" v-model="listQuery.isDeleted" />
    </el-form-item>

    <el-form-item  label="表名" prop="tableName">
        <el-input clearable placeholder="请输入表名" v-model="listQuery.tableName" />
    </el-form-item>

    <el-form-item  label="字段名" prop="fieldName">
        <el-input clearable placeholder="请输入字段名" v-model="listQuery.fieldName" />
    </el-form-item>

</template>
</search-operation>
</base-header>
<base-table-p
@selection-change="handleSelectionChange"
ref="baseTableRef"
:params="listQuery"
api="general_orders.page"
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
prop="orderNo"
label="订单编号"
align="center"
>

</el-table-column>
<el-table-column
prop="userId"
label="用户ID"
align="center"
>

</el-table-column>
<el-table-column
prop="opId"
label="操作ID"
align="center"
>

</el-table-column>
<el-table-column
prop="orderType"
label="订单类型"
align="center"
>

</el-table-column>
<el-table-column
prop="orderStatus"
label="订单状态"
align="center"
>

</el-table-column>
<el-table-column
prop="payStatus"
label="支付状态"
align="center"
>

</el-table-column>
<el-table-column
prop="deliveryStatus"
label="发货状态"
align="center"
>

</el-table-column>
<el-table-column
prop="productsId"
label="商品ID"
align="center"
>

</el-table-column>
<el-table-column
prop="quality"
label="商品数量"
align="center"
>

</el-table-column>
<el-table-column
prop="totalAmount"
label="订单总额"
align="center"
>

</el-table-column>
<el-table-column
prop="discountAmount"
label="优惠金额"
align="center"
>

</el-table-column>
<el-table-column
prop="shippingFee"
label="运费"
align="center"
>

</el-table-column>
<el-table-column
prop="actualAmount"
label="实付金额"
align="center"
>

</el-table-column>
<el-table-column
prop="paymentChannel"
label="支付渠道"
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
prop="paymentTime"
label="支付时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.paymentTime,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
prop="paymentAmount"
label="支付金额"
align="center"
>

</el-table-column>
<el-table-column
prop="shippingMethod"
label="配送方式"
align="center"
>

</el-table-column>
<el-table-column
prop="shippingAddress"
label="配送地址"
align="center"
>

</el-table-column>
<el-table-column
prop="shippingCompany"
label="物流公司"
align="center"
>

</el-table-column>
<el-table-column
prop="trackingNumber"
label="运单号"
align="center"
>

</el-table-column>
<el-table-column
prop="tel"
label="收件人电话"
align="center"
>

</el-table-column>
<el-table-column
prop="recipient"
label="收件人"
align="center"
>

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
prop="cancelTime"
label="取消时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.cancelTime,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
prop="completeTime"
label="完成时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.completeTime,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
prop="deliverTime"
label="发货时间"
align="center"
>
<template #default="scope">
{{ parseTime(scope.row.deliverTime,'{y}-{m}-{d} {h}:{i}:{s}') }}
</template>
</el-table-column>
<el-table-column
prop="refundId"
label="支付系统退款单号"
align="center"
>

</el-table-column>
<el-table-column
prop="refundNo"
label="业务系统"
align="center"
>

</el-table-column>
<el-table-column
prop="refundType"
label="退款类型"
align="center"
>

</el-table-column>
<el-table-column
prop="refundAmount"
label="退款金额"
align="center"
>

</el-table-column>
<el-table-column
prop="refundReason"
label="退款原因"
align="center"
>

</el-table-column>
<el-table-column
prop="refundStatus"
label="退款状态"
align="center"
>

</el-table-column>
<el-table-column
prop="remark"
label="备注"
align="center"
>

</el-table-column>
<el-table-column
prop="isDeleted"
label="是否删除"
align="center"
>

</el-table-column>
<el-table-column
prop="tableName"
label="表名"
align="center"
>

</el-table-column>
<el-table-column
prop="fieldName"
label="字段名"
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
path="/general_orders/detail"
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
<base-orders-refund-btn
:general_orders_id="scope.row.id"
@ok="refreshTableData"
></base-orders-refund-btn>
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
:rules='{"totalAmount":[{"trigger":"blur","message":"订单总额不能为空","required":true}],"productsId":[{"trigger":"blur","message":"商品ID不能为空","required":true}],"orderNo":[{"trigger":"blur","message":"订单编号不能为空","required":true}],"createTime":[{"trigger":"blur","message":"创建时间不能为空","required":true}],"actualAmount":[{"trigger":"blur","message":"实付金额不能为空","required":true}],"orderStatus":[{"trigger":"blur","message":"订单状态不能为空","required":true}],"updateTime":[{"trigger":"blur","message":"更新时间不能为空","required":true}],"userId":[{"trigger":"blur","message":"用户ID不能为空","required":true}],"payStatus":[{"trigger":"blur","message":"支付状态不能为空","required":true}],"quality":[{"trigger":"blur","message":"商品数量不能为空","required":true}]}'
label-width='100px'
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
label="订单编号"
>
{{ form.orderNo }}
</base-cell-item>
<base-cell-item
label="用户ID"
>
{{ form.userId }}
</base-cell-item>
<base-cell-item
label="操作ID"
>
{{ form.opId }}
</base-cell-item>
<base-cell-item
label="订单类型"
>
{{ form.orderType }}
</base-cell-item>
<base-cell-item
label="订单状态"
>
{{ form.orderStatus }}
</base-cell-item>
<base-cell-item
label="支付状态"
>
{{ form.payStatus }}
</base-cell-item>
<base-cell-item
label="发货状态"
>
{{ form.deliveryStatus }}
</base-cell-item>
<base-cell-item
label="商品ID"
>
{{ form.productsId }}
</base-cell-item>
<base-cell-item
label="商品数量"
>
{{ form.quality }}
</base-cell-item>
<base-cell-item
label="订单总额"
>
{{ form.totalAmount }}
</base-cell-item>
<base-cell-item
label="优惠金额"
>
{{ form.discountAmount }}
</base-cell-item>
<base-cell-item
label="运费"
>
{{ form.shippingFee }}
</base-cell-item>
<base-cell-item
label="实付金额"
>
{{ form.actualAmount }}
</base-cell-item>
<base-cell-item
label="支付渠道"
>
{{ form.paymentChannel }}
</base-cell-item>
<base-cell-item
label="支付订单号"
>
{{ form.paymentOrderId }}
</base-cell-item>
<base-cell-item
label="支付时间"
>
{{ form.paymentTime }}
</base-cell-item>
<base-cell-item
label="支付金额"
>
{{ form.paymentAmount }}
</base-cell-item>
<base-cell-item
label="配送方式"
>
{{ form.shippingMethod }}
</base-cell-item>
<base-cell-item
label="配送地址"
>
{{ form.shippingAddress }}
</base-cell-item>
<base-cell-item
label="物流公司"
>
{{ form.shippingCompany }}
</base-cell-item>
<base-cell-item
label="运单号"
>
{{ form.trackingNumber }}
</base-cell-item>
<base-cell-item
label="收件人电话"
>
{{ form.tel }}
</base-cell-item>
<base-cell-item
label="收件人"
>
{{ form.recipient }}
</base-cell-item>
<base-cell-item
label="取消时间"
>
{{ form.cancelTime }}
</base-cell-item>
<base-cell-item
label="完成时间"
>
{{ form.completeTime }}
</base-cell-item>
<base-cell-item
label="发货时间"
>
{{ form.deliverTime }}
</base-cell-item>
<base-cell-item
label="支付系统退款单号"
>
{{ form.refundId }}
</base-cell-item>
<base-cell-item
label="业务系统"
>
{{ form.refundNo }}
</base-cell-item>
<base-cell-item
label="退款类型"
>
{{ form.refundType }}
</base-cell-item>
<base-cell-item
label="退款金额"
>
{{ form.refundAmount }}
</base-cell-item>
<base-cell-item
label="退款原因"
>
{{ form.refundReason }}
</base-cell-item>
<base-cell-item
label="退款状态"
>
{{ form.refundStatus }}
</base-cell-item>
<base-cell-item
label="备注"
>
{{ form.remark }}
</base-cell-item>
<base-cell-item
label="是否删除"
>
{{ form.isDeleted }}
</base-cell-item>
<base-cell-item
label="表名"
>
{{ form.tableName }}
</base-cell-item>
<base-cell-item
label="字段名"
>
{{ form.fieldName }}
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
        table_name: 'general_orders',
        param: {
            id: row.id
        }
    });
    proxy.$modal.msgSuccess(res.message);
  }
  else{
    let res = await proxy.$api.general_orders.delete(row.id);
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
        table_name: 'general_orders',
        param: {
        ids: ids
        }
    });
    } else {
        res = await proxy.$api.general_orders.deleteBatch(ids);
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
    await proxy.$api.general_orders.downloadExcel({
      ...listQuery.value
    }, `${new Date().getTime()}.xlsx`, "export", "post")
  }catch (error) {
    console.error("导出失败", error)
  }
}
async function downloadTemplate() {
  try {
    await proxy.$api.general_orders.downloadExcel({
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
                table_name: 'general_orders',
                param: form.value
            });
            proxy.$modal.msgSuccess(res.message);
          }
          else{
            let res = await proxy.$api.general_orders[dialogStatus.value](form.value);
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