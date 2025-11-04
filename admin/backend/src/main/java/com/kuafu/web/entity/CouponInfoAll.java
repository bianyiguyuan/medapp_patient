package com.kuafu.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuafu.common.annotation.Excel;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kuafu.common.annotation.Excel.*;

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
public class CouponInfoAll  {
    @TableField(value="ci.user_info_user_info_id_4")
    @JsonProperty(value = "userInfoUserInfoId4")
    @Excel(name = "用户ID")
    private Integer userInfoUserInfoId4;
    @TableField(value="ci.amount")
    @JsonProperty(value = "amount")
    @Excel(name = "优惠金额")
    private Double amount;
    @TableField(value="ui.password")
    @JsonProperty(value = "password")
    @Excel(name = "密码")
    private String password;
    @TableField(value="ci.coupon_info_id")
    @JsonProperty(value = "couponInfoId")
    @Excel(name = "主键")
    private Integer couponInfoId;
    @TableField(value="ui.phone_number")
    @JsonProperty(value = "phoneNumber")
    @Excel(name = "手机号")
    private String phoneNumber;
    @TableField(value="ui.member_level_id")
    @JsonProperty(value = "memberLevelId")
    @Excel(name = "会员等级")
    private Integer memberLevelId;
    @TableField(value="ui.avatar_resource_key")
    @JsonProperty(value = "avatarResourceKey")
    @Excel(name = "头像")
    private String avatarResourceKey;
    @TableField(value="ui.email")
    @JsonProperty(value = "email")
    @Excel(name = "邮箱")
    private String email;
    @TableField(value="ci.is_used")
    @JsonProperty(value = "isUsed")
    @Excel(name = "是否已使用")
    private Boolean isUsed;
    @TableField(value="ui.username")
    @JsonProperty(value = "username")
    @Excel(name = "用户名")
    private String username;

}
