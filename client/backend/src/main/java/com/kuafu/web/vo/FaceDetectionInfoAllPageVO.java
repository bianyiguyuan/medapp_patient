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
 * <p>人脸检测信息-分页列表-响应参数</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FaceDetectionInfoAllPageVO extends BaseEntity {

@JsonProperty("agingParts")
    private String agingParts;
@JsonProperty("password")
    private String password;
@JsonProperty("memberLevelId")
    private Integer memberLevelId;
@JsonProperty("deepAnalysisUnlocked")
    private Boolean deepAnalysisUnlocked;
@JsonProperty("customPlanUnlocked")
    private Boolean customPlanUnlocked;
@JsonProperty("impressionAge")
    private Integer impressionAge;
@JsonProperty("phoneNumber")
    private String phoneNumber;
@JsonProperty("userInfoUserInfoId2")
    private Integer userInfoUserInfoId2;
@JsonProperty("faceDetectionInfoId")
    private Integer faceDetectionInfoId;
@JsonProperty("email")
    private String email;
@JsonProperty("username")
    private String username;

}
