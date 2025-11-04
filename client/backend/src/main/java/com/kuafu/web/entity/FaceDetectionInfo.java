package com.kuafu.web.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.*;
import com.kuafu.common.entity.StaticResource;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kuafu.web.annotation.IsNotNullField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.kuafu.common.annotation.*;
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
@TableName("face_detection_info")
public class FaceDetectionInfo  {
    @TableId(value = "face_detection_info_id", type = IdType.AUTO)
    @JsonProperty("face_detection_info_id")
    
    
    
    private Integer faceDetectionInfoId;
    @JsonProperty("user_info_user_info_id_2")
    @IsNotNullField(description = "用户ID")
    
    
    @TableField("user_info_user_info_id_2")
    private Integer userInfoUserInfoId2;
    @JsonProperty("impression_age")
    
    
    @TableField("impression_age")
    private Integer impressionAge;
    @JsonProperty("aging_parts")
    
    
    @TableField("aging_parts")
    private String agingParts;
    @JsonProperty("deep_analysis_unlocked")
    
    
    @TableField("deep_analysis_unlocked")
    private Boolean deepAnalysisUnlocked;
    @JsonProperty("custom_plan_unlocked")
    
    
    @TableField("custom_plan_unlocked")
    private Boolean customPlanUnlocked;



@TableField(exist = false)
@JsonProperty("upload_image")
private List<StaticResource> uploadImage;



}
