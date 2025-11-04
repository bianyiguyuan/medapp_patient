package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import com.kuafu.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;

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
public class AppointmentInfoAllPageVO extends BaseEntity {

@JsonProperty("depositAmount")
    private Double depositAmount;
@JsonProperty("appointmentTime")
    private String appointmentTime;
@JsonProperty("appointmentInfoId")
    private Integer appointmentInfoId;
@JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
@JsonProperty("memberLevelId")
    private Integer memberLevelId;
@JsonProperty("statusName")
    private String statusName;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("appointmentDate")
    private Date appointmentDate;
@JsonProperty("appointmentCode")
    private String appointmentCode;
@JsonProperty("depositPaid")
    private Boolean depositPaid;
@JsonProperty("statusEnumId")
    private Integer statusEnumId;
@JsonProperty("couponReceived")
    private Boolean couponReceived;
@JsonProperty("password")
    private String password;
@JsonProperty("phoneNumber")
    private String phoneNumber;
@JsonProperty("doctorName")
    private String doctorName;
@JsonProperty("email")
    private String email;
@JsonProperty("username")
    private String username;

}
