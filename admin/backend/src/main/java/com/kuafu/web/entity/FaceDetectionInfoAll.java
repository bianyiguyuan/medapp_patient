package com.kuafu.web.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuafu.common.annotation.Excel;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kuafu.common.annotation.Excel.*;

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
public class FaceDetectionInfoAll  {
    @TableField(value="fdi.user_info_user_info_id_2")
    @JsonProperty(value = "userInfoUserInfoId2")
    @Excel(name = "用户ID")
    private Integer userInfoUserInfoId2;
    @TableField(value="fdi.deep_analysis_unlocked")
    @JsonProperty(value = "deepAnalysisUnlocked")
    @Excel(name = "深度分析是否解锁")
    private Boolean deepAnalysisUnlocked;
    @TableField(value="fdi.aging_parts")
    @JsonProperty(value = "agingParts")
    @Excel(name = "显老部位")
    private String agingParts;
    @TableField(value="fdi.impression_age")
    @JsonProperty(value = "impressionAge")
    @Excel(name = "印象年龄")
    private Integer impressionAge;
    @TableField(value="fdi.face_detection_info_id")
    @JsonProperty(value = "faceDetectionInfoId")
    @Excel(name = "主键")
    private Integer faceDetectionInfoId;
    @TableField(value="fdi.upload_image_resource_key")
    @JsonProperty(value = "uploadImageResourceKey")
    @Excel(cellType = ColumnType.IMAGE, name = "上传人脸图片")
    private String uploadImageResourceKey;
    @TableField(value="ui.phone_number")
    @JsonProperty(value = "phoneNumber")
    @Excel(name = "手机号")
    private String phoneNumber;
    @TableField(value="ui.member_level_id")
    @JsonProperty(value = "memberLevelId")
    @Excel(name = "会员等级")
    private Integer memberLevelId;
    @TableField(value="ui.avatar_resource_key")
    @JsonProperty(value = "avatarResourceKey")
    @Excel(name = "头像")
    private String avatarResourceKey;
    @TableField(value="fdi.custom_plan_unlocked")
    @JsonProperty(value = "customPlanUnlocked")
    @Excel(name = "定制方案是否解锁")
    private Boolean customPlanUnlocked;
    @TableField(value="ui.password")
    @JsonProperty(value = "password")
    @Excel(name = "密码")
    private String password;
    @TableField(value="ui.email")
    @JsonProperty(value = "email")
    @Excel(name = "邮箱")
    private String email;
    @TableField(value="ui.username")
    @JsonProperty(value = "username")
    @Excel(name = "用户名")
    private String username;

    @TableField(value="upload_image")
    @JsonProperty("uploadImage")
    private List<StaticResource> uploadImage;
}
