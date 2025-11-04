package com.kuafu.web.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.*;
import com.kuafu.common.entity.StaticResource;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kuafu.web.annotation.IsNotNullField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.kuafu.common.annotation.*;
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
@TableName("coupon_info")
public class CouponInfo  {
    @TableId(value = "coupon_info_id", type = IdType.AUTO)
    @JsonProperty("coupon_info_id")
    
    
    
    private Integer couponInfoId;
    @JsonProperty("user_info_user_info_id_4")
    @IsNotNullField(description = "用户ID")
    
    
    @TableField("user_info_user_info_id_4")
    private Integer userInfoUserInfoId4;
    @JsonProperty("amount")
    @IsNotNullField(description = "优惠金额")
    
    
    @TableField("amount")
    private Double amount;
    @JsonProperty("is_used")
    
    
    @TableField("is_used")
    private Boolean isUsed;





}
