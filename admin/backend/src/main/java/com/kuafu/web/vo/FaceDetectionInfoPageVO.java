package com.kuafu.web.vo;

import java.util.Date;

import com.kuafu.common.domin.PageRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
public class FaceDetectionInfoPageVO extends PageRequest {

    @JsonProperty(value = "faceDetectionInfoId")
    private Integer faceDetectionInfoId;
    @JsonProperty(value = "userInfoUserInfoId2")
    private Integer userInfoUserInfoId2;
    @JsonProperty(value = "uploadImageResourceKey")
    private String uploadImageResourceKey;
    @JsonProperty(value = "impressionAge")
    private Integer impressionAge;
    @JsonProperty(value = "agingParts")
    private String agingParts;
    @JsonProperty(value = "deepAnalysisUnlocked")
    private Boolean deepAnalysisUnlocked;
    @JsonProperty(value = "customPlanUnlocked")
    private Boolean customPlanUnlocked;

}
