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
 * <p>订单信息</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfoVO  extends BaseEntity {

    @JsonProperty("orderInfoId")
    private Integer orderInfoId;
    @JsonProperty("userInfoUserInfoId5")
    private Integer userInfoUserInfoId5;
    @JsonProperty("productInfoProductInfoId")
    private Integer productInfoProductInfoId;
    @JsonProperty("quantity")
    private Integer quantity;
    @JsonProperty("totalPrice")
    private Double totalPrice;
    @JsonProperty("orderStatusEnumId")
    private Integer orderStatusEnumId;
    @JsonProperty("paymentOrderNo")
    private String paymentOrderNo;




}
