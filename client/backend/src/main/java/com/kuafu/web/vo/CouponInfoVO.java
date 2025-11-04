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
 * <p>优惠券信息</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CouponInfoVO  extends BaseEntity {

    @JsonProperty("couponInfoId")
    private Integer couponInfoId;
    @JsonProperty("userInfoUserInfoId4")
    private Integer userInfoUserInfoId4;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("isUsed")
    private Boolean isUsed;




}
