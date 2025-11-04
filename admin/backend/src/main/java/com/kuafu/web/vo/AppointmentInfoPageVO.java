package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class AppointmentInfoPageVO extends PageRequest {

    @JsonProperty(value = "appointmentInfoId")
    private Integer appointmentInfoId;
    @JsonProperty(value = "userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
    @JsonProperty(value = "doctorName")
    private String doctorName;
    @JsonProperty(value = "appointmentDate")
    private Date appointmentDate;
    @JsonProperty(value = "appointmentTime")
    private String appointmentTime;
    @JsonProperty(value = "statusEnumId")
    private Integer statusEnumId;
    @JsonProperty(value = "depositPaid")
    private Boolean depositPaid;
    @JsonProperty(value = "depositAmount")
    private Double depositAmount;
    @JsonProperty(value = "couponReceived")
    private Boolean couponReceived;
    @JsonProperty(value = "appointmentCode")
    private String appointmentCode;

}
