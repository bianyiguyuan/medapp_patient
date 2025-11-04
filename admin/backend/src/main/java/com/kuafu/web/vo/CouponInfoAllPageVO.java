package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class CouponInfoAllPageVO extends PageRequest {

    @JsonProperty(value = "userInfoUserInfoId4")
    private Integer userInfoUserInfoId4;
    @JsonProperty(value = "amount")
    private Double amount;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "couponInfoId")
    private Integer couponInfoId;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "memberLevelId")
    private Integer memberLevelId;
    @JsonProperty(value = "avatarResourceKey")
    private String avatarResourceKey;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "isUsed")
    private Boolean isUsed;
    @JsonProperty(value = "username")
    private String username;

}
