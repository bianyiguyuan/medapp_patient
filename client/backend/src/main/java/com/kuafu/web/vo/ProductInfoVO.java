package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.kuafu.common.entity.StaticResource;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.entity.BaseEntity;
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
public class ProductInfoVO  extends BaseEntity {

    @JsonProperty("productInfoId")
    private Integer productInfoId;
    @JsonProperty("productName")
    private String productName;
    @JsonProperty("price")
    private Double price;
    @JsonProperty("couponAmount")
    private Double couponAmount;
    @JsonProperty("miniProgramPath")
    private String miniProgramPath;


    private List<StaticResource> image;


}
