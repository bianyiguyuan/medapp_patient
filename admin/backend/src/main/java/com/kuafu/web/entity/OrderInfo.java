package com.kuafu.web.entity;

import java.util.Date;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuafu.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;
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
@TableName("order_info")
public class OrderInfo    {
    @TableId(value = "order_info_id", type = IdType.AUTO)
    @JsonProperty(value = "orderInfoId")
    @Excel(name = "主键")

    private Integer orderInfoId;
    @JsonProperty(value = "userInfoUserInfoId5")
    @Excel(name = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_info_user_info_id_5")

    private Integer userInfoUserInfoId5;
    @JsonProperty(value = "productInfoProductInfoId")
    @Excel(name = "商品ID")
    @ExcelProperty(value = "商品ID")
    @TableField(value = "product_info_product_info_id")

    private Integer productInfoProductInfoId;
    @JsonProperty(value = "quantity")
    @Excel(name = "购买数量")
    @ExcelProperty(value = "购买数量")
    @TableField(value = "quantity")

    private Integer quantity;
    @JsonProperty(value = "totalPrice")
    @Excel(name = "总价")
    @ExcelProperty(value = "总价")
    @TableField(value = "total_price")

    private Double totalPrice;
    @JsonProperty(value = "orderStatusEnumId")
    @Excel(name = "订单状态")
    @ExcelProperty(value = "订单状态")
    @TableField(value = "order_status_enum_id")

    private Integer orderStatusEnumId;
    @JsonProperty(value = "paymentOrderNo")
    @Excel(name = "支付订单号")
    @ExcelProperty(value = "支付订单号")
    @TableField(value = "payment_order_no")

    private String paymentOrderNo;


}
