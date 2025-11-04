package com.kuafu.web.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.kuafu.common.entity.BaseEntity;
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
public class OrderInfoPageVO extends BaseEntity {

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
