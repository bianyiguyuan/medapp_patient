package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class CommissionInfoPageVO extends PageRequest {

    @JsonProperty(value = "commissionInfoId")
    private Integer commissionInfoId;
    @JsonProperty(value = "userInfoUserInfoId3")
    private Integer userInfoUserInfoId3;
    @JsonProperty(value = "commissionRatio")
    private Double commissionRatio;
    @JsonProperty(value = "totalEarnings")
    private Double totalEarnings;

}
