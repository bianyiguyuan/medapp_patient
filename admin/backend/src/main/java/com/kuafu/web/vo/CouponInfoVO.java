package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

/**
 * <p>优惠券信息</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponInfoVO  {

     @JsonProperty(value = "couponInfoId")
    private Integer couponInfoId;
     @JsonProperty(value = "userInfoUserInfoId4")
    private Integer userInfoUserInfoId4;
     @JsonProperty(value = "amount")
    private Double amount;
     @JsonProperty(value = "isUsed")
    private Boolean isUsed;


}
