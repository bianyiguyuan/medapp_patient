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
public class MemberLevelEnum    {
    @TableId(value = "member_level_enum_id", type = IdType.AUTO)
    @JsonProperty(value = "memberLevelEnumId")
    @Excel(name = "主键")

    private Integer memberLevelEnumId;
    @JsonProperty(value = "levelName")
    @Excel(name = "等级名称")
    @ExcelProperty(value = "等级名称")
    @TableField(value = "level_name")

    private String levelName;
    @JsonProperty(value = "description")
    @Excel(name = "描述")
    @ExcelProperty(value = "描述")
    @TableField(value = "description")

    private String description;


}
