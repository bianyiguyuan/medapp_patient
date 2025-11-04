package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

/**
 * <p>预约信息</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentInfoVO  {

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
