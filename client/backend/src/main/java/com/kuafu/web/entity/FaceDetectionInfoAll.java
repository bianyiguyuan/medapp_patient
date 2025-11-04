package com.kuafu.web.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * <p>  人脸检测信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FaceDetectionInfoAll {
    @TableField(value="fdi.aging_parts")
    @JsonProperty("aging_parts")
    private String agingParts;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="ui.member_level_id")
    @JsonProperty("member_level_id")
    private Integer memberLevelId;
    @TableField(value="fdi.deep_analysis_unlocked")
    @JsonProperty("deep_analysis_unlocked")
    private Boolean deepAnalysisUnlocked;
    @TableField(value="fdi.custom_plan_unlocked")
    @JsonProperty("custom_plan_unlocked")
    private Boolean customPlanUnlocked;
    @TableField(value="fdi.impression_age")
    @JsonProperty("impression_age")
    private Integer impressionAge;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="fdi.user_info_user_info_id_2")
    @JsonProperty("user_info_user_info_id_2")
    private Integer userInfoUserInfoId2;
    @TableField(value="fdi.face_detection_info_id")
    @JsonProperty("face_detection_info_id")
    private Integer faceDetectionInfoId;
    @TableField(value="ui.email")
    @JsonProperty("email")
    private String email;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;


@TableField(value="upload_image")
@JsonProperty("upload_image")
private List<StaticResource> uploadImage;








@TableField(exist = false)
private List<StaticResource> avatar;

}
