package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.DelayedTasks;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> delayed_tasks Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface DelayedTasksStatisticsMapper extends BaseMapper<DelayedTasks> {

                        List<Object> delayed_tasks_status_status_statistic_25c6486d_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_status_status_statistic_b664fbca_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_status_status_statistic_f7af67be_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_execute_time_datetime_statistic_15cc1805_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_execute_time_datetime_statistic_5293da89_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_execute_time_datetime_statistic_470e98fd_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_create_time_datetime_statistic_92d59b0a_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_create_time_datetime_statistic_ea989616_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_create_time_datetime_statistic_357d2036_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_update_time_datetime_statistic_db4e931a_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_update_time_datetime_statistic_dd6b066c_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> delayed_tasks_update_time_datetime_statistic_ec1bf144_count(@Param("ew") Wrapper queryWrapper);

}
