package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

/**
 * <p>会员等级</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberLevelEnumVO  {

     @JsonProperty(value = "memberLevelEnumId")
    private Integer memberLevelEnumId;
     @JsonProperty(value = "levelName")
    private String levelName;
     @JsonProperty(value = "description")
    private String description;


}
