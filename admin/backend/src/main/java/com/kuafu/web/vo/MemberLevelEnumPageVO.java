package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>会员等级-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MemberLevelEnumPageVO extends PageRequest {

    @JsonProperty(value = "memberLevelEnumId")
    private Integer memberLevelEnumId;
    @JsonProperty(value = "levelName")
    private String levelName;
    @JsonProperty(value = "description")
    private String description;

}
