package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * <p>订单信息-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderInfoAllPageVO extends PageRequest {

    @JsonProperty(value = "productsId")
    private Integer productsId;
    @JsonProperty(value = "orderNo")
    private String orderNo;
    @JsonProperty(value = "orderStatus")
    private String orderStatus;
    @JsonProperty(value = "opId")
    private String opId;
    @JsonProperty(value = "memberLevelId")
    private Integer memberLevelId;
    @JsonProperty(value = "avatarResourceKey")
    private String avatarResourceKey;
    @JsonProperty(value = "userId")
    private Integer userId;
    @JsonProperty(value = "deliverTime")
    private Date deliverTime;
    @JsonProperty(value = "isDeleted")
    private Integer isDeleted;
    @JsonProperty(value = "paymentAmount")
    private Double paymentAmount;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "price")
    private Double price;
    @JsonProperty(value = "completeTime")
    private Date completeTime;
    @JsonProperty(value = "actualAmount")
    private Double actualAmount;
    @JsonProperty(value = "tel")
    private String tel;
    @JsonProperty(value = "refundAmount")
    private Double refundAmount;
    @JsonProperty(value = "refundType")
    private String refundType;
    @JsonProperty(value = "miniProgramPath")
    private String miniProgramPath;
    @JsonProperty(value = "statusName")
    private String statusName;
    @JsonProperty(value = "shippingMethod")
    private String shippingMethod;
    @JsonProperty(value = "quality")
    private Integer quality;
    @JsonProperty(value = "paymentOrderNo")
    private String paymentOrderNo;
    @JsonProperty(value = "totalAmount")
    private Double totalAmount;
    @JsonProperty(value = "refundStatus")
    private String refundStatus;
    @JsonProperty(value = "deliveryStatus")
    private String deliveryStatus;
    @JsonProperty(value = "productInfoProductInfoId")
    private Integer productInfoProductInfoId;
    @JsonProperty(value = "orderType")
    private String orderType;
    @JsonProperty(value = "paymentChannel")
    private String paymentChannel;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "remark")
    private String remark;
    @JsonProperty(value = "shippingFee")
    private Double shippingFee;
    @JsonProperty(value = "discountAmount")
    private Double discountAmount;
    @JsonProperty(value = "paymentOrderId")
    private String paymentOrderId;
    @JsonProperty(value = "trackingNumber")
    private String trackingNumber;
    @JsonProperty(value = "productName")
    private String productName;
    @JsonProperty(value = "couponAmount")
    private Double couponAmount;
    @JsonProperty(value = "tableName")
    private String tableName;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "refundId")
    private String refundId;
    @JsonProperty(value = "shippingAddress")
    private String shippingAddress;
    @JsonProperty(value = "createTime")
    private Date createTime;
    @JsonProperty(value = "quantity")
    private Integer quantity;
    @JsonProperty(value = "totalPrice")
    private Double totalPrice;
    @JsonProperty(value = "cancelTime")
    private Date cancelTime;
    @JsonProperty(value = "refundReason")
    private String refundReason;
    @JsonProperty(value = "userInfoUserInfoId5")
    private Integer userInfoUserInfoId5;
    @JsonProperty(value = "paymentTime")
    private Date paymentTime;
    @JsonProperty(value = "fieldName")
    private String fieldName;
    @JsonProperty(value = "refundNo")
    private String refundNo;
    @JsonProperty(value = "orderInfoId")
    private Integer orderInfoId;
    @JsonProperty(value = "payStatus")
    private String payStatus;
    @JsonProperty(value = "recipient")
    private String recipient;
    @JsonProperty(value = "shippingCompany")
    private String shippingCompany;
    @JsonProperty(value = "imageResourceKey")
    private String imageResourceKey;
    @JsonProperty(value = "updateTime")
    private Date updateTime;
    @JsonProperty(value = "orderStatusEnumId")
    private Integer orderStatusEnumId;
    @JsonProperty(value = "username")
    private String username;

}
