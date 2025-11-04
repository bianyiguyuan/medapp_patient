package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.kuafu.common.entity.StaticResource;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.kuafu.common.deserializer.MultiDateDeserializer;
import com.kuafu.common.entity.BaseEntity;
/**
 * <p>人脸检测信息</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceDetectionInfoVO  extends BaseEntity {

    @JsonProperty("faceDetectionInfoId")
    private Integer faceDetectionInfoId;
    @JsonProperty("userInfoUserInfoId2")
    private Integer userInfoUserInfoId2;
    @JsonProperty("impressionAge")
    private Integer impressionAge;
    @JsonProperty("agingParts")
    private String agingParts;
    @JsonProperty("deepAnalysisUnlocked")
    private Boolean deepAnalysisUnlocked;
    @JsonProperty("customPlanUnlocked")
    private Boolean customPlanUnlocked;


    private List<StaticResource> uploadImage;


}
