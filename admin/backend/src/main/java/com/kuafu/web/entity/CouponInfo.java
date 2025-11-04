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
 * <p>  优惠券信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("coupon_info")
public class CouponInfo    {
    @TableId(value = "coupon_info_id", type = IdType.AUTO)
    @JsonProperty(value = "couponInfoId")
    @Excel(name = "主键")

    private Integer couponInfoId;
    @JsonProperty(value = "userInfoUserInfoId4")
    @Excel(name = "用户ID")
    @ExcelProperty(value = "用户ID")
    @TableField(value = "user_info_user_info_id_4")

    private Integer userInfoUserInfoId4;
    @JsonProperty(value = "amount")
    @Excel(name = "优惠金额")
    @ExcelProperty(value = "优惠金额")
    @TableField(value = "amount")

    private Double amount;
    @JsonProperty(value = "isUsed")
    @Excel(name = "是否已使用")
    @ExcelProperty(value = "是否已使用")
    @TableField(value = "is_used")

    private Boolean isUsed;


}
