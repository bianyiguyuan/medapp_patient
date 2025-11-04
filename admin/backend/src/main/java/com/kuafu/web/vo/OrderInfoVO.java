package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

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
public class OrderInfoVO  {

     @JsonProperty(value = "orderInfoId")
    private Integer orderInfoId;
     @JsonProperty(value = "userInfoUserInfoId5")
    private Integer userInfoUserInfoId5;
     @JsonProperty(value = "productInfoProductInfoId")
    private Integer productInfoProductInfoId;
     @JsonProperty(value = "quantity")
    private Integer quantity;
     @JsonProperty(value = "totalPrice")
    private Double totalPrice;
     @JsonProperty(value = "orderStatusEnumId")
    private Integer orderStatusEnumId;
     @JsonProperty(value = "paymentOrderNo")
    private String paymentOrderNo;


}
