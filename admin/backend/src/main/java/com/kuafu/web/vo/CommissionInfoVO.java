package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

/**
 * <p>佣金信息</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommissionInfoVO  {

     @JsonProperty(value = "commissionInfoId")
    private Integer commissionInfoId;
     @JsonProperty(value = "userInfoUserInfoId3")
    private Integer userInfoUserInfoId3;
     @JsonProperty(value = "commissionRatio")
    private Double commissionRatio;
     @JsonProperty(value = "totalEarnings")
    private Double totalEarnings;


}
