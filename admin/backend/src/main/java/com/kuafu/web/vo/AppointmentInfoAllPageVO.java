package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * <p>预约信息-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AppointmentInfoAllPageVO extends PageRequest {

    @JsonProperty(value = "userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
    @JsonProperty(value = "appointmentInfoId")
    private Integer appointmentInfoId;
    @JsonProperty(value = "depositAmount")
    private Double depositAmount;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "memberLevelId")
    private Integer memberLevelId;
    @JsonProperty(value = "statusName")
    private String statusName;
    @JsonProperty(value = "appointmentTime")
    private String appointmentTime;
    @JsonProperty(value = "avatarResourceKey")
    private String avatarResourceKey;
    @JsonProperty(value = "doctorName")
    private String doctorName;
    @JsonProperty(value = "appointmentDate")
    private Date appointmentDate;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "appointmentCode")
    private String appointmentCode;
    @JsonProperty(value = "statusEnumId")
    private Integer statusEnumId;
    @JsonProperty(value = "depositPaid")
    private Boolean depositPaid;
    @JsonProperty(value = "couponReceived")
    private Boolean couponReceived;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "username")
    private String username;

}
