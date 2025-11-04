package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.MemberLevelEnum;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> member_level_enum Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface MemberLevelEnumStatisticsMapper extends BaseMapper<MemberLevelEnum> {

                        List<Object> member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> member_level_enum_member_level_enum_id_status_statistic_72e02317_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count(@Param("ew") Wrapper queryWrapper);

}
