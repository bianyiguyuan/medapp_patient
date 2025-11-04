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
 * <p>  佣金信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("commission_info")
public class CommissionInfo    {
    @TableId(value = "commission_info_id", type = IdType.AUTO)
    @JsonProperty(value = "commissionInfoId")
    @Excel(name = "主键")

    private Integer commissionInfoId;
    @JsonProperty(value = "userInfoUserInfoId3")
    @Excel(name = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_info_user_info_id_3")

    private Integer userInfoUserInfoId3;
    @JsonProperty(value = "commissionRatio")
    @Excel(name = "佣金比例")
    @ExcelProperty(value = "佣金比例")
    @TableField(value = "commission_ratio")

    private Double commissionRatio;
    @JsonProperty(value = "totalEarnings")
    @Excel(name = "累计收益")
    @ExcelProperty(value = "累计收益")
    @TableField(value = "total_earnings")

    private Double totalEarnings;


}
