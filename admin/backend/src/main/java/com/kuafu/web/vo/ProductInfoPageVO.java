package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>品牌商品信息-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductInfoPageVO extends PageRequest {

    @JsonProperty(value = "productInfoId")
    private Integer productInfoId;
    @JsonProperty(value = "productName")
    private String productName;
    @JsonProperty(value = "price")
    private Double price;
    @JsonProperty(value = "imageResourceKey")
    private String imageResourceKey;
    @JsonProperty(value = "couponAmount")
    private Double couponAmount;
    @JsonProperty(value = "miniProgramPath")
    private String miniProgramPath;

}
