package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>优惠券信息-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CouponInfoPageVO extends PageRequest {

    @JsonProperty(value = "couponInfoId")
    private Integer couponInfoId;
    @JsonProperty(value = "userInfoUserInfoId4")
    private Integer userInfoUserInfoId4;
    @JsonProperty(value = "amount")
    private Double amount;
    @JsonProperty(value = "isUsed")
    private Boolean isUsed;

}
