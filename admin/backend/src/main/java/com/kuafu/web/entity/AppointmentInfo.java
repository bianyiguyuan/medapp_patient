package com.kuafu.web.entity;

import java.util.Date;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuafu.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;
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
@TableName("appointment_info")
public class AppointmentInfo    {
    @TableId(value = "appointment_info_id", type = IdType.AUTO)
    @JsonProperty(value = "appointmentInfoId")
    @Excel(name = "主键")

    private Integer appointmentInfoId;
    @JsonProperty(value = "userInfoUserInfoId1")
    @Excel(name = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_info_user_info_id_1")

    private Integer userInfoUserInfoId1;
    @JsonProperty(value = "doctorName")
    @Excel(name = "医生姓名")
    @ExcelProperty(value = "医生姓名")
    @TableField(value = "doctor_name")

    private String doctorName;
    @JsonProperty(value = "appointmentDate")
    @Excel(name = "预约日期")
    @ExcelProperty(value = "预约日期")
    @TableField(value = "appointment_date")

    private Date appointmentDate;
    @JsonProperty(value = "appointmentTime")
    @Excel(dateFormat = "yyyy-MM-dd HH:mm:ss", name = "预约时间段")
    @ExcelProperty(value = "预约时间段")
    @TableField(value = "appointment_time")

    private String appointmentTime;
    @JsonProperty(value = "statusEnumId")
    @Excel(name = "预约状态")
    @ExcelProperty(value = "预约状态")
    @TableField(value = "status_enum_id")

    private Integer statusEnumId;
    @JsonProperty(value = "depositPaid")
    @Excel(name = "是否支付定金")
    @ExcelProperty(value = "是否支付定金")
    @TableField(value = "deposit_paid")

    private Boolean depositPaid;
    @JsonProperty(value = "depositAmount")
    @Excel(name = "定金金额")
    @ExcelProperty(value = "定金金额")
    @TableField(value = "deposit_amount")

    private Double depositAmount;
    @JsonProperty(value = "couponReceived")
    @Excel(name = "是否领取优惠券")
    @ExcelProperty(value = "是否领取优惠券")
    @TableField(value = "coupon_received")

    private Boolean couponReceived;
    @JsonProperty(value = "appointmentCode")
    @Excel(name = "预约码")
    @ExcelProperty(value = "预约码")
    @TableField(value = "appointment_code")

    private String appointmentCode;


}
