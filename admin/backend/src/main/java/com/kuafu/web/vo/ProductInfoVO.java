package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

/**
 * <p>品牌商品信息</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfoVO  {

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

    @JsonProperty("image")
    private List<StaticResource> image;

}
