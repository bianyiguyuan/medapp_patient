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
 * <p>佣金信息-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CommissionInfoAllPageVO extends BaseEntity {

@JsonProperty("password")
    private String password;
@JsonProperty("commissionInfoId")
    private Integer commissionInfoId;
@JsonProperty("totalEarnings")
    private Double totalEarnings;
@JsonProperty("memberLevelId")
    private Integer memberLevelId;
@JsonProperty("commissionRatio")
    private Double commissionRatio;
@JsonProperty("phoneNumber")
    private String phoneNumber;
@JsonProperty("userInfoUserInfoId3")
    private Integer userInfoUserInfoId3;
@JsonProperty("email")
    private String email;
@JsonProperty("username")
    private String username;

}
