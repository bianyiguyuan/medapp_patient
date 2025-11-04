package com.kuafu.web.vo;

import com.kuafu.common.domin.PageRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Date;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class FaceDetectionInfoAllPageVO extends PageRequest {

    @JsonProperty(value = "userInfoUserInfoId2")
    private Integer userInfoUserInfoId2;
    @JsonProperty(value = "deepAnalysisUnlocked")
    private Boolean deepAnalysisUnlocked;
    @JsonProperty(value = "agingParts")
    private String agingParts;
    @JsonProperty(value = "impressionAge")
    private Integer impressionAge;
    @JsonProperty(value = "faceDetectionInfoId")
    private Integer faceDetectionInfoId;
    @JsonProperty(value = "uploadImageResourceKey")
    private String uploadImageResourceKey;
    @JsonProperty(value = "phoneNumber")
    private String phoneNumber;
    @JsonProperty(value = "memberLevelId")
    private Integer memberLevelId;
    @JsonProperty(value = "avatarResourceKey")
    private String avatarResourceKey;
    @JsonProperty(value = "customPlanUnlocked")
    private Boolean customPlanUnlocked;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "email")
    private String email;
    @JsonProperty(value = "username")
    private String username;

}
