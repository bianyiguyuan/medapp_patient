package com.kuafu.web.vo;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.kuafu.common.entity.BaseEntity;
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
public class AppointmentInfoPageVO extends BaseEntity {

@JsonProperty("appointmentInfoId")
    private Integer appointmentInfoId;
@JsonProperty("userInfoUserInfoId1")
    private Integer userInfoUserInfoId1;
@JsonProperty("doctorName")
    private String doctorName;
    @JsonDeserialize(using = MultiDateDeserializer.class)
@JsonProperty("appointmentDate")
    private Date appointmentDate;
@JsonProperty("appointmentTime")
    private String appointmentTime;
@JsonProperty("statusEnumId")
    private Integer statusEnumId;
@JsonProperty("depositPaid")
    private Boolean depositPaid;
@JsonProperty("depositAmount")
    private Double depositAmount;
@JsonProperty("couponReceived")
    private Boolean couponReceived;
@JsonProperty("appointmentCode")
    private String appointmentCode;


}
