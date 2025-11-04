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
 * <p>  佣金信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("commission_info")
public class CommissionInfo  {
    @TableId(value = "commission_info_id", type = IdType.AUTO)
    @JsonProperty("commission_info_id")
    
    
    
    private Integer commissionInfoId;
    @JsonProperty("user_info_user_info_id_3")
    @IsNotNullField(description = "用户ID")
    
    
    @TableField("user_info_user_info_id_3")
    private Integer userInfoUserInfoId3;
    @JsonProperty("commission_ratio")
    @IsNotNullField(description = "佣金比例")
    
    
    @TableField("commission_ratio")
    private Double commissionRatio;
    @JsonProperty("total_earnings")
    @IsNotNullField(description = "累计收益")
    
    
    @TableField("total_earnings")
    private Double totalEarnings;





}
