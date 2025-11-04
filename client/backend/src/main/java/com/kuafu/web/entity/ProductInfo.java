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
public class ProductInfo  {
    @TableId(value = "product_info_id", type = IdType.AUTO)
    @JsonProperty("product_info_id")
    
    
    
    private Integer productInfoId;
    @JsonProperty("product_name")
    @IsNotNullField(description = "商品名称")
    
    
    @TableField("product_name")
    private String productName;
    @JsonProperty("price")
    @IsNotNullField(description = "价格")
    
    
    @TableField("price")
    private Double price;
    @JsonProperty("coupon_amount")
    
    
    @TableField("coupon_amount")
    private Double couponAmount;
    @JsonProperty("mini_program_path")
    
    
    @TableField("mini_program_path")
    private String miniProgramPath;



@TableField(exist = false)
@JsonProperty("image")
private List<StaticResource> image;



}
