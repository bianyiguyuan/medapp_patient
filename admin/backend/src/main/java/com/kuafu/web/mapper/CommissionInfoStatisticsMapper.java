package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.CommissionInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> commission_info Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface CommissionInfoStatisticsMapper extends BaseMapper<CommissionInfo> {

                        List<Object> commission_info_statistic_2eb6e6e9_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> commission_info_statistic_715fc2a4_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> commission_info_statistic_12ffaa16_count(@Param("ew") Wrapper queryWrapper);

}
