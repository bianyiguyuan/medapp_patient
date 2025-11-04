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
 * <p>  用户信息 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoAll {
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="mle.level_name")
    @JsonProperty("level_name")
    private String levelName;
    @TableField(value="ui.member_level_id")
    @JsonProperty("member_level_id")
    private Integer memberLevelId;
    @TableField(value="mle.description")
    @JsonProperty("description")
    private String description;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="ui.user_info_id")
    @JsonProperty("user_info_id")
    private Integer userInfoId;
    @TableField(value="ui.email")
    @JsonProperty("email")
    private String email;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;


@TableField(value="avatar")
@JsonProperty("avatar")
private List<StaticResource> avatar;








}
