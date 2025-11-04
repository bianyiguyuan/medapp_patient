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
 * <p>  预约信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("appointment_info")
public class AppointmentInfo  {
    @TableId(value = "appointment_info_id", type = IdType.AUTO)
    @JsonProperty("appointment_info_id")
    
    
    
    private Integer appointmentInfoId;
    @JsonProperty("user_info_user_info_id_1")
    @IsNotNullField(description = "用户ID")
    
    
    @TableField("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;
    @JsonProperty("doctor_name")
    @IsNotNullField(description = "医生姓名")
    
    
    @TableField("doctor_name")
    private String doctorName;
    @JsonProperty("appointment_date")
    @IsNotNullField(description = "预约日期")
    
    
    @TableField("appointment_date")
    private Date appointmentDate;
    @JsonProperty("appointment_time")
    @IsNotNullField(description = "预约时间段")
    
    
    @TableField("appointment_time")
    private String appointmentTime;
    @JsonProperty("status_enum_id")
    @IsNotNullField(description = "预约状态")
    
    
    @TableField("status_enum_id")
    private Integer statusEnumId;
    @JsonProperty("deposit_paid")
    
    
    @TableField("deposit_paid")
    private Boolean depositPaid;
    @JsonProperty("deposit_amount")
    
    
    @TableField("deposit_amount")
    private Double depositAmount;
    @JsonProperty("coupon_received")
    
    
    @TableField("coupon_received")
    private Boolean couponReceived;
    @JsonProperty("appointment_code")
    
    
    @TableField("appointment_code")
    private String appointmentCode;





}
