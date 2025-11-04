package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.MemberLevelEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  member_level_enum 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IMemberLevelEnumStatisticsService extends IService<MemberLevelEnum> {
        List<Object> member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count(LambdaQueryWrapper queryWrapper);

        List<Object> member_level_enum_member_level_enum_id_status_statistic_72e02317_count(LambdaQueryWrapper queryWrapper);

        List<Object> member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count(LambdaQueryWrapper queryWrapper);

}
