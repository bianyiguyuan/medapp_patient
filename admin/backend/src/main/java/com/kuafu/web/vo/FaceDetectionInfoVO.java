package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

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
public class FaceDetectionInfoVO  {

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

    @JsonProperty("uploadImage")
    private List<StaticResource> uploadImage;

}
