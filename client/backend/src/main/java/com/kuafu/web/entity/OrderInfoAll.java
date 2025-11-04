package com.kuafu.web.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



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
public class OrderInfoAll {
    @TableField(value="pi.mini_program_path")
    @JsonProperty("mini_program_path")
    private String miniProgramPath;
    @TableField(value="go.discount_amount")
    @JsonProperty("discount_amount")
    private Double discountAmount;
    @TableField(value="go.payment_time")
    @JsonProperty("payment_time")
    private Date paymentTime;
    @TableField(value="go.refund_no")
    @JsonProperty("refund_no")
    private String refundNo;
    @TableField(value="go.actual_amount")
    @JsonProperty("actual_amount")
    private Double actualAmount;
    @TableField(value="go.table_name")
    @JsonProperty("table_name")
    private String tableName;
    @TableField(value="go.order_status")
    @JsonProperty("order_status")
    private String orderStatus;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="go.complete_time")
    @JsonProperty("complete_time")
    private Date completeTime;
    @TableField(value="pi.price")
    @JsonProperty("price")
    private Double price;
    @TableField(value="go.shipping_method")
    @JsonProperty("shipping_method")
    private String shippingMethod;
    @TableField(value="go.tel")
    @JsonProperty("tel")
    private String tel;
    @TableField(value="go.order_type")
    @JsonProperty("order_type")
    private String orderType;
    @TableField(value="go.cancel_time")
    @JsonProperty("cancel_time")
    private Date cancelTime;
    @TableField(value="go.refund_type")
    @JsonProperty("refund_type")
    private String refundType;
    @TableField(value="go.refund_status")
    @JsonProperty("refund_status")
    private String refundStatus;
    @TableField(value="go.shipping_company")
    @JsonProperty("shipping_company")
    private String shippingCompany;
    @TableField(value="go.create_time")
    @JsonProperty("create_time")
    private Date createTime;
    @TableField(value="go.payment_amount")
    @JsonProperty("payment_amount")
    private Double paymentAmount;
    @TableField(value="pi.product_name")
    @JsonProperty("product_name")
    private String productName;
    @TableField(value="go.refund_id")
    @JsonProperty("refund_id")
    private String refundId;
    @TableField(value="go.quality")
    @JsonProperty("quality")
    private Integer quality;
    @TableField(value="go.shipping_fee")
    @JsonProperty("shipping_fee")
    private Double shippingFee;
    @TableField(value="go.user_id")
    @JsonProperty("user_id")
    private Integer userId;
    @TableField(value="go.total_amount")
    @JsonProperty("total_amount")
    private Double totalAmount;
    @TableField(value="go.payment_channel")
    @JsonProperty("payment_channel")
    private String paymentChannel;
    @TableField(value="oi.order_status_enum_id")
    @JsonProperty("order_status_enum_id")
    private Integer orderStatusEnumId;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="oi.payment_order_no")
    @JsonProperty("payment_order_no")
    private String paymentOrderNo;
    @TableField(value="go.order_no")
    @JsonProperty("order_no")
    private String orderNo;
    @TableField(value="ui.member_level_id")
    @JsonProperty("member_level_id")
    private Integer memberLevelId;
    @TableField(value="go.remark")
    @JsonProperty("remark")
    private String remark;
    @TableField(value="go.pay_status")
    @JsonProperty("pay_status")
    private String payStatus;
    @TableField(value="go.update_time")
    @JsonProperty("update_time")
    private Date updateTime;
    @TableField(value="go.is_deleted")
    @JsonProperty("is_deleted")
    private Integer isDeleted;
    @TableField(value="go.tracking_number")
    @JsonProperty("tracking_number")
    private String trackingNumber;
    @TableField(value="go.refund_amount")
    @JsonProperty("refund_amount")
    private Double refundAmount;
    @TableField(value="go.refund_reason")
    @JsonProperty("refund_reason")
    private String refundReason;
    @TableField(value="go.shipping_address")
    @JsonProperty("shipping_address")
    private String shippingAddress;
    @TableField(value="ui.email")
    @JsonProperty("email")
    private String email;
    @TableField(value="pi.coupon_amount")
    @JsonProperty("coupon_amount")
    private Double couponAmount;
    @TableField(value="go.deliver_time")
    @JsonProperty("deliver_time")
    private Date deliverTime;
    @TableField(value="oi.order_info_id")
    @JsonProperty("order_info_id")
    private Integer orderInfoId;
    @TableField(value="oi.quantity")
    @JsonProperty("quantity")
    private Integer quantity;
    @TableField(value="oi.total_price")
    @JsonProperty("total_price")
    private Double totalPrice;
    @TableField(value="ose.status_name")
    @JsonProperty("status_name")
    private String statusName;
    @TableField(value="go.op_id")
    @JsonProperty("op_id")
    private String opId;
    @TableField(value="go.payment_order_id")
    @JsonProperty("payment_order_id")
    private String paymentOrderId;
    @TableField(value="oi.user_info_user_info_id_5")
    @JsonProperty("user_info_user_info_id_5")
    private Integer userInfoUserInfoId5;
    @TableField(value="go.field_name")
    @JsonProperty("field_name")
    private String fieldName;
    @TableField(value="go.products_id")
    @JsonProperty("products_id")
    private Integer productsId;
    @TableField(value="oi.product_info_product_info_id")
    @JsonProperty("product_info_product_info_id")
    private Integer productInfoProductInfoId;
    @TableField(value="go.recipient")
    @JsonProperty("recipient")
    private String recipient;
    @TableField(value="go.delivery_status")
    @JsonProperty("delivery_status")
    private String deliveryStatus;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










@TableField(exist = false)
private List<StaticResource> avatar;

@TableField(exist = false)
private List<StaticResource> image;

}
