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
public class AppointmentInfoAll  {
    @TableField(value="ai.user_info_user_info_id_1")
    @JsonProperty(value = "userInfoUserInfoId1")
    @Excel(name = "用户ID")
    private Integer userInfoUserInfoId1;
    @TableField(value="ai.appointment_info_id")
    @JsonProperty(value = "appointmentInfoId")
    @Excel(name = "主键")
    private Integer appointmentInfoId;
    @TableField(value="ai.deposit_amount")
    @JsonProperty(value = "depositAmount")
    @Excel(name = "定金金额")
    private Double depositAmount;
    @TableField(value="ui.phone_number")
    @JsonProperty(value = "phoneNumber")
    @Excel(name = "手机号")
    private String phoneNumber;
    @TableField(value="ui.member_level_id")
    @JsonProperty(value = "memberLevelId")
    @Excel(name = "会员等级")
    private Integer memberLevelId;
    @TableField(value="ase.status_name")
    @JsonProperty(value = "statusName")
    @Excel(name = "状态名称")
    private String statusName;
    @TableField(value="ai.appointment_time")
    @JsonProperty(value = "appointmentTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "预约时间段")
    private String appointmentTime;
    @TableField(value="ui.avatar_resource_key")
    @JsonProperty(value = "avatarResourceKey")
    @Excel(name = "头像")
    private String avatarResourceKey;
    @TableField(value="ai.doctor_name")
    @JsonProperty(value = "doctorName")
    @Excel(name = "医生姓名")
    private String doctorName;
    @TableField(value="ai.appointment_date")
    @JsonProperty(value = "appointmentDate")
    @Excel(name = "预约日期")
    private Date appointmentDate;
    @TableField(value="ui.password")
    @JsonProperty(value = "password")
    @Excel(name = "密码")
    private String password;
    @TableField(value="ai.appointment_code")
    @JsonProperty(value = "appointmentCode")
    @Excel(name = "预约码")
    private String appointmentCode;
    @TableField(value="ai.status_enum_id")
    @JsonProperty(value = "statusEnumId")
    @Excel(name = "预约状态")
    private Integer statusEnumId;
    @TableField(value="ai.deposit_paid")
    @JsonProperty(value = "depositPaid")
    @Excel(name = "是否支付定金")
    private Boolean depositPaid;
    @TableField(value="ai.coupon_received")
    @JsonProperty(value = "couponReceived")
    @Excel(name = "是否领取优惠券")
    private Boolean couponReceived;
    @TableField(value="ui.email")
    @JsonProperty(value = "email")
    @Excel(name = "邮箱")
    private String email;
    @TableField(value="ui.username")
    @JsonProperty(value = "username")
    @Excel(name = "用户名")
    private String username;

}
