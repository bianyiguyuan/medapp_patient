package com.kuafu.web.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.*;
import com.kuafu.common.entity.StaticResource;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kuafu.web.annotation.IsNotNullField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.kuafu.common.annotation.*;
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
@TableName("order_info")
public class OrderInfo  {
    @TableId(value = "order_info_id", type = IdType.AUTO)
    @JsonProperty("order_info_id")
    
    
    
    private Integer orderInfoId;
    @JsonProperty("user_info_user_info_id_5")
    @IsNotNullField(description = "用户ID")
    
    
    @TableField("user_info_user_info_id_5")
    private Integer userInfoUserInfoId5;
    @JsonProperty("product_info_product_info_id")
    @IsNotNullField(description = "商品ID")
    
    
    @TableField("product_info_product_info_id")
    private Integer productInfoProductInfoId;
    @JsonProperty("quantity")
    @IsNotNullField(description = "购买数量")
    
    
    @TableField("quantity")
    private Integer quantity;
    @JsonProperty("total_price")
    @IsNotNullField(description = "总价")
    
    
    @TableField("total_price")
    private Double totalPrice;
    @JsonProperty("order_status_enum_id")
    @IsNotNullField(description = "订单状态")
    
    
    @TableField("order_status_enum_id")
    private Integer orderStatusEnumId;
    @JsonProperty("payment_order_no")
    
    
    @TableField("payment_order_no")
    private String paymentOrderNo;





}
