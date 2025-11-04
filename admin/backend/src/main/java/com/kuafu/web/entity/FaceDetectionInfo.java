package com.kuafu.web.entity;

import java.util.Date;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kuafu.common.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;
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
@TableName("face_detection_info")
public class FaceDetectionInfo    {
    @TableId(value = "face_detection_info_id", type = IdType.AUTO)
    @JsonProperty(value = "faceDetectionInfoId")
    @Excel(name = "主键")

    private Integer faceDetectionInfoId;
    @JsonProperty(value = "userInfoUserInfoId2")
    @Excel(name = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_info_user_info_id_2")

    private Integer userInfoUserInfoId2;
    @JsonProperty(value = "uploadImageResourceKey")
    @Excel(cellType = ColumnType.IMAGE, name = "上传人脸图片")
    @ExcelProperty(value = "上传人脸图片")
    @TableField(value = "upload_image_resource_key")

    private String uploadImageResourceKey;
    @JsonProperty(value = "impressionAge")
    @Excel(name = "印象年龄")
    @ExcelProperty(value = "印象年龄")
    @TableField(value = "impression_age")

    private Integer impressionAge;
    @JsonProperty(value = "agingParts")
    @Excel(name = "显老部位")
    @ExcelProperty(value = "显老部位")
    @TableField(value = "aging_parts")

    private String agingParts;
    @JsonProperty(value = "deepAnalysisUnlocked")
    @Excel(name = "深度分析是否解锁")
    @ExcelProperty(value = "深度分析是否解锁")
    @TableField(value = "deep_analysis_unlocked")

    private Boolean deepAnalysisUnlocked;
    @JsonProperty(value = "customPlanUnlocked")
    @Excel(name = "定制方案是否解锁")
    @ExcelProperty(value = "定制方案是否解锁")
    @TableField(value = "custom_plan_unlocked")

    private Boolean customPlanUnlocked;

    @TableField(exist = false)
    private List<StaticResource> uploadImage;

}
