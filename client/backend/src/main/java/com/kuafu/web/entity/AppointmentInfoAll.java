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
public class AppointmentInfoAll {
    @TableField(value="ai.deposit_amount")
    @JsonProperty("deposit_amount")
    private Double depositAmount;
    @TableField(value="ai.appointment_time")
    @JsonProperty("appointment_time")
    private String appointmentTime;
    @TableField(value="ai.appointment_info_id")
    @JsonProperty("appointment_info_id")
    private Integer appointmentInfoId;
    @TableField(value="ai.user_info_user_info_id_1")
    @JsonProperty("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;
    @TableField(value="ui.member_level_id")
    @JsonProperty("member_level_id")
    private Integer memberLevelId;
    @TableField(value="ase.status_name")
    @JsonProperty("status_name")
    private String statusName;
    @TableField(value="ai.appointment_date")
    @JsonProperty("appointment_date")
    private Date appointmentDate;
    @TableField(value="ai.appointment_code")
    @JsonProperty("appointment_code")
    private String appointmentCode;
    @TableField(value="ai.deposit_paid")
    @JsonProperty("deposit_paid")
    private Boolean depositPaid;
    @TableField(value="ai.status_enum_id")
    @JsonProperty("status_enum_id")
    private Integer statusEnumId;
    @TableField(value="ai.coupon_received")
    @JsonProperty("coupon_received")
    private Boolean couponReceived;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="ai.doctor_name")
    @JsonProperty("doctor_name")
    private String doctorName;
    @TableField(value="ui.email")
    @JsonProperty("email")
    private String email;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










@TableField(exist = false)
private List<StaticResource> avatar;

}
