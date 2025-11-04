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
 * <p>  品牌商品信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("product_info")
public class ProductInfo    {
    @TableId(value = "product_info_id", type = IdType.AUTO)
    @JsonProperty(value = "productInfoId")
    @Excel(name = "主键")

    private Integer productInfoId;
    @JsonProperty(value = "productName")
    @Excel(name = "商品名称")
    @ExcelProperty(value = "商品名称")
    @TableField(value = "product_name")

    private String productName;
    @JsonProperty(value = "price")
    @Excel(name = "价格")
    @ExcelProperty(value = "价格")
    @TableField(value = "price")

    private Double price;
    @JsonProperty(value = "imageResourceKey")
    @Excel(cellType = ColumnType.IMAGE, name = "商品图片")
    @ExcelProperty(value = "商品图片")
    @TableField(value = "image_resource_key")

    private String imageResourceKey;
    @JsonProperty(value = "couponAmount")
    @Excel(name = "优惠券金额")
    @ExcelProperty(value = "优惠券金额")
    @TableField(value = "coupon_amount")

    private Double couponAmount;
    @JsonProperty(value = "miniProgramPath")
    @Excel(name = "品牌小程序路径")
    @ExcelProperty(value = "品牌小程序路径")
    @TableField(value = "mini_program_path")

    private String miniProgramPath;

    @TableField(exist = false)
    private List<StaticResource> image;

}
