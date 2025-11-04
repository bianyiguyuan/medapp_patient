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
 * <p>  会员等级 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("member_level_enum")
public class MemberLevelEnum  {
    @TableId(value = "member_level_enum_id", type = IdType.AUTO)
    @JsonProperty("member_level_enum_id")
    
    
    
    private Integer memberLevelEnumId;
    @JsonProperty("level_name")
    @IsNotNullField(description = "等级名称")
    
    
    @TableField("level_name")
    private String levelName;
    @JsonProperty("description")
    
    
    @TableField("description")
    private String description;





}
