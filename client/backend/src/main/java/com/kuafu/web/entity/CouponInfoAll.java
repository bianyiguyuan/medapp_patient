package com.kuafu.web.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * <p>  优惠券信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CouponInfoAll {
    @TableField(value="ci.amount")
    @JsonProperty("amount")
    private Double amount;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="ci.coupon_info_id")
    @JsonProperty("coupon_info_id")
    private Integer couponInfoId;
    @TableField(value="ui.member_level_id")
    @JsonProperty("member_level_id")
    private Integer memberLevelId;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="ci.user_info_user_info_id_4")
    @JsonProperty("user_info_user_info_id_4")
    private Integer userInfoUserInfoId4;
    @TableField(value="ui.email")
    @JsonProperty("email")
    private String email;
    @TableField(value="ci.is_used")
    @JsonProperty("is_used")
    private Boolean isUsed;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










@TableField(exist = false)
private List<StaticResource> avatar;

}
