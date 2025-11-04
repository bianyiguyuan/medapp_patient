package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import com.kuafu.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;

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
public class OrderInfoAllPageVO extends BaseEntity {

@JsonProperty("miniProgramPath")
    private String miniProgramPath;
@JsonProperty("discountAmount")
    private Double discountAmount;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("paymentTime")
    private Date paymentTime;
@JsonProperty("refundNo")
    private String refundNo;
@JsonProperty("actualAmount")
    private Double actualAmount;
@JsonProperty("tableName")
    private String tableName;
@JsonProperty("orderStatus")
    private String orderStatus;
@JsonProperty("password")
    private String password;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("completeTime")
    private Date completeTime;
@JsonProperty("price")
    private Double price;
@JsonProperty("shippingMethod")
    private String shippingMethod;
@JsonProperty("tel")
    private String tel;
@JsonProperty("orderType")
    private String orderType;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("cancelTime")
    private Date cancelTime;
@JsonProperty("refundType")
    private String refundType;
@JsonProperty("refundStatus")
    private String refundStatus;
@JsonProperty("shippingCompany")
    private String shippingCompany;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("createTime")
    private Date createTime;
@JsonProperty("paymentAmount")
    private Double paymentAmount;
@JsonProperty("productName")
    private String productName;
@JsonProperty("refundId")
    private String refundId;
@JsonProperty("quality")
    private Integer quality;
@JsonProperty("shippingFee")
    private Double shippingFee;
@JsonProperty("userId")
    private Integer userId;
@JsonProperty("totalAmount")
    private Double totalAmount;
@JsonProperty("paymentChannel")
    private String paymentChannel;
@JsonProperty("orderStatusEnumId")
    private Integer orderStatusEnumId;
@JsonProperty("phoneNumber")
    private String phoneNumber;
@JsonProperty("paymentOrderNo")
    private String paymentOrderNo;
@JsonProperty("orderNo")
    private String orderNo;
@JsonProperty("memberLevelId")
    private Integer memberLevelId;
@JsonProperty("remark")
    private String remark;
@JsonProperty("payStatus")
    private String payStatus;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("updateTime")
    private Date updateTime;
@JsonProperty("isDeleted")
    private Integer isDeleted;
@JsonProperty("trackingNumber")
    private String trackingNumber;
@JsonProperty("refundAmount")
    private Double refundAmount;
@JsonProperty("refundReason")
    private String refundReason;
@JsonProperty("shippingAddress")
    private String shippingAddress;
@JsonProperty("email")
    private String email;
@JsonProperty("couponAmount")
    private Double couponAmount;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("deliverTime")
    private Date deliverTime;
@JsonProperty("orderInfoId")
    private Integer orderInfoId;
@JsonProperty("quantity")
    private Integer quantity;
@JsonProperty("totalPrice")
    private Double totalPrice;
@JsonProperty("statusName")
    private String statusName;
@JsonProperty("opId")
    private String opId;
@JsonProperty("paymentOrderId")
    private String paymentOrderId;
@JsonProperty("userInfoUserInfoId5")
    private Integer userInfoUserInfoId5;
@JsonProperty("fieldName")
    private String fieldName;
@JsonProperty("productsId")
    private Integer productsId;
@JsonProperty("productInfoProductInfoId")
    private Integer productInfoProductInfoId;
@JsonProperty("recipient")
    private String recipient;
@JsonProperty("deliveryStatus")
    private String deliveryStatus;
@JsonProperty("username")
    private String username;

}
