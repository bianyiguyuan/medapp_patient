package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.UserInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> user_info Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface UserInfoStatisticsMapper extends BaseMapper<UserInfo> {

                        List<Object> user_info_statistic_b8e54625_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> user_info_statistic_d3ee33f0_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> user_info_statistic_d0fbf2c7_count(@Param("ew") Wrapper queryWrapper);

}
