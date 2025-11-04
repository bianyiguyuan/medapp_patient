package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>订单信息-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderInfoPageVO extends PageRequest {

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
