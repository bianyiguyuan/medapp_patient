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
public class ProductInfoAll {
    @TableField(value="pi.coupon_amount")
    @JsonProperty("coupon_amount")
    private Double couponAmount;
    @TableField(value="pi.mini_program_path")
    @JsonProperty("mini_program_path")
    private String miniProgramPath;
    @TableField(value="pi.product_info_id")
    @JsonProperty("product_info_id")
    private Integer productInfoId;
    @TableField(value="pi.price")
    @JsonProperty("price")
    private Double price;
    @TableField(value="pi.product_name")
    @JsonProperty("product_name")
    private String productName;


@TableField(value="image")
@JsonProperty("image")
private List<StaticResource> image;








}
