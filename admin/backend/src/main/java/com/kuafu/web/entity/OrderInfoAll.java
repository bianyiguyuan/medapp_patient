package com.kuafu.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuafu.common.annotation.Excel;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kuafu.common.annotation.Excel.*;

/**
 * <p>  订单信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfoAll  {
    @TableField(value="go.products_id")
    @JsonProperty(value = "productsId")
    @Excel(name = "商品ID")
    private Integer productsId;
    @TableField(value="go.order_no")
    @JsonProperty(value = "orderNo")
    @Excel(name = "订单编号")
    private String orderNo;
    @TableField(value="go.order_status")
    @JsonProperty(value = "orderStatus")
    @Excel(name = "订单状态")
    private String orderStatus;
    @TableField(value="go.op_id")
    @JsonProperty(value = "opId")
    @Excel(name = "操作ID")
    private String opId;
    @TableField(value="ui.member_level_id")
    @JsonProperty(value = "memberLevelId")
    @Excel(name = "会员等级")
    private Integer memberLevelId;
    @TableField(value="ui.avatar_resource_key")
    @JsonProperty(value = "avatarResourceKey")
    @Excel(name = "头像")
    private String avatarResourceKey;
    @TableField(value="go.user_id")
    @JsonProperty(value = "userId")
    @Excel(name = "用户ID")
    private Integer userId;
    @TableField(value="go.deliver_time")
    @JsonProperty(value = "deliverTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "发货时间")
    private Date deliverTime;
    @TableField(value="go.is_deleted")
    @JsonProperty(value = "isDeleted")
    @Excel(name = "是否删除")
    private Integer isDeleted;
    @TableField(value="go.payment_amount")
    @JsonProperty(value = "paymentAmount")
    @Excel(name = "支付金额")
    private Double paymentAmount;
    @TableField(value="ui.password")
    @JsonProperty(value = "password")
    @Excel(name = "密码")
    private String password;
    @TableField(value="pi.price")
    @JsonProperty(value = "price")
    @Excel(name = "价格")
    private Double price;
    @TableField(value="go.complete_time")
    @JsonProperty(value = "completeTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "完成时间")
    private Date completeTime;
    @TableField(value="go.actual_amount")
    @JsonProperty(value = "actualAmount")
    @Excel(name = "实付金额")
    private Double actualAmount;
    @TableField(value="go.tel")
    @JsonProperty(value = "tel")
    @Excel(name = "收件人电话")
    private String tel;
    @TableField(value="go.refund_amount")
    @JsonProperty(value = "refundAmount")
    @Excel(name = "退款金额")
    private Double refundAmount;
    @TableField(value="go.refund_type")
    @JsonProperty(value = "refundType")
    @Excel(name = "退款类型")
    private String refundType;
    @TableField(value="pi.mini_program_path")
    @JsonProperty(value = "miniProgramPath")
    @Excel(name = "品牌小程序路径")
    private String miniProgramPath;
    @TableField(value="ose.status_name")
    @JsonProperty(value = "statusName")
    @Excel(name = "状态名称")
    private String statusName;
    @TableField(value="go.shipping_method")
    @JsonProperty(value = "shippingMethod")
    @Excel(name = "配送方式")
    private String shippingMethod;
    @TableField(value="go.quality")
    @JsonProperty(value = "quality")
    @Excel(name = "商品数量")
    private Integer quality;
    @TableField(value="oi.payment_order_no")
    @JsonProperty(value = "paymentOrderNo")
    @Excel(name = "支付订单号")
    private String paymentOrderNo;
    @TableField(value="go.total_amount")
    @JsonProperty(value = "totalAmount")
    @Excel(name = "订单总额")
    private Double totalAmount;
    @TableField(value="go.refund_status")
    @JsonProperty(value = "refundStatus")
    @Excel(name = "退款状态")
    private String refundStatus;
    @TableField(value="go.delivery_status")
    @JsonProperty(value = "deliveryStatus")
    @Excel(name = "发货状态")
    private String deliveryStatus;
    @TableField(value="oi.product_info_product_info_id")
    @JsonProperty(value = "productInfoProductInfoId")
    @Excel(name = "商品ID")
    private Integer productInfoProductInfoId;
    @TableField(value="go.order_type")
    @JsonProperty(value = "orderType")
    @Excel(name = "订单类型")
    private String orderType;
    @TableField(value="go.payment_channel")
    @JsonProperty(value = "paymentChannel")
    @Excel(name = "支付渠道")
    private String paymentChannel;
    @TableField(value="ui.phone_number")
    @JsonProperty(value = "phoneNumber")
    @Excel(name = "手机号")
    private String phoneNumber;
    @TableField(value="go.remark")
    @JsonProperty(value = "remark")
    @Excel(name = "备注")
    private String remark;
    @TableField(value="go.shipping_fee")
    @JsonProperty(value = "shippingFee")
    @Excel(name = "运费")
    private Double shippingFee;
    @TableField(value="go.discount_amount")
    @JsonProperty(value = "discountAmount")
    @Excel(name = "优惠金额")
    private Double discountAmount;
    @TableField(value="go.payment_order_id")
    @JsonProperty(value = "paymentOrderId")
    @Excel(name = "支付订单号")
    private String paymentOrderId;
    @TableField(value="go.tracking_number")
    @JsonProperty(value = "trackingNumber")
    @Excel(name = "运单号")
    private String trackingNumber;
    @TableField(value="pi.product_name")
    @JsonProperty(value = "productName")
    @Excel(name = "商品名称")
    private String productName;
    @TableField(value="pi.coupon_amount")
    @JsonProperty(value = "couponAmount")
    @Excel(name = "优惠券金额")
    private Double couponAmount;
    @TableField(value="go.table_name")
    @JsonProperty(value = "tableName")
    @Excel(name = "表名")
    private String tableName;
    @TableField(value="ui.email")
    @JsonProperty(value = "email")
    @Excel(name = "邮箱")
    private String email;
    @TableField(value="go.refund_id")
    @JsonProperty(value = "refundId")
    @Excel(name = "支付系统退款单号")
    private String refundId;
    @TableField(value="go.shipping_address")
    @JsonProperty(value = "shippingAddress")
    @Excel(name = "配送地址")
    private String shippingAddress;
    @TableField(value="go.create_time")
    @JsonProperty(value = "createTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "创建时间")
    private Date createTime;
    @TableField(value="oi.quantity")
    @JsonProperty(value = "quantity")
    @Excel(name = "购买数量")
    private Integer quantity;
    @TableField(value="oi.total_price")
    @JsonProperty(value = "totalPrice")
    @Excel(name = "总价")
    private Double totalPrice;
    @TableField(value="go.cancel_time")
    @JsonProperty(value = "cancelTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "取消时间")
    private Date cancelTime;
    @TableField(value="go.refund_reason")
    @JsonProperty(value = "refundReason")
    @Excel(name = "退款原因")
    private String refundReason;
    @TableField(value="oi.user_info_user_info_id_5")
    @JsonProperty(value = "userInfoUserInfoId5")
    @Excel(name = "用户ID")
    private Integer userInfoUserInfoId5;
    @TableField(value="go.payment_time")
    @JsonProperty(value = "paymentTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "支付时间")
    private Date paymentTime;
    @TableField(value="go.field_name")
    @JsonProperty(value = "fieldName")
    @Excel(name = "字段名")
    private String fieldName;
    @TableField(value="go.refund_no")
    @JsonProperty(value = "refundNo")
    @Excel(name = "业务系统")
    private String refundNo;
    @TableField(value="oi.order_info_id")
    @JsonProperty(value = "orderInfoId")
    @Excel(name = "主键")
    private Integer orderInfoId;
    @TableField(value="go.pay_status")
    @JsonProperty(value = "payStatus")
    @Excel(name = "支付状态")
    private String payStatus;
    @TableField(value="go.recipient")
    @JsonProperty(value = "recipient")
    @Excel(name = "收件人")
    private String recipient;
    @TableField(value="go.shipping_company")
    @JsonProperty(value = "shippingCompany")
    @Excel(name = "物流公司")
    private String shippingCompany;
    @TableField(value="pi.image_resource_key")
    @JsonProperty(value = "imageResourceKey")
    @Excel(cellType = ColumnType.IMAGE, name = "商品图片")
    private String imageResourceKey;
    @TableField(value="go.update_time")
    @JsonProperty(value = "updateTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "更新时间")
    private Date updateTime;
    @TableField(value="oi.order_status_enum_id")
    @JsonProperty(value = "orderStatusEnumId")
    @Excel(name = "订单状态")
    private Integer orderStatusEnumId;
    @TableField(value="ui.username")
    @JsonProperty(value = "username")
    @Excel(name = "用户名")
    private String username;

}
