package com.kuafu.web.service.impl;

import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kuafu.web.mapper.DelayedTasksStatisticsMapper;
import com.kuafu.web.entity.DelayedTasks;
import com.kuafu.web.service.IDelayedTasksStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> delayed_tasks 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("DelayedTasksStatistics")
public class DelayedTasksStatisticsServiceImpl extends ServiceImpl<DelayedTasksStatisticsMapper, DelayedTasks> implements IDelayedTasksStatisticsService {
    @Resource
    private DelayedTasksStatisticsMapper delayedTasksStaticMapper;

                        @Override
                        public List<Object> delayed_tasks_status_status_statistic_25c6486d_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_status_status_statistic_25c6486d_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_status_status_statistic_b664fbca_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_status_status_statistic_b664fbca_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_status_status_statistic_f7af67be_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_status_status_statistic_f7af67be_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_execute_time_datetime_statistic_15cc1805_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_execute_time_datetime_statistic_15cc1805_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_execute_time_datetime_statistic_5293da89_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_execute_time_datetime_statistic_5293da89_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_execute_time_datetime_statistic_470e98fd_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_execute_time_datetime_statistic_470e98fd_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_create_time_datetime_statistic_92d59b0a_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_create_time_datetime_statistic_92d59b0a_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_create_time_datetime_statistic_ea989616_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_create_time_datetime_statistic_ea989616_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_create_time_datetime_statistic_357d2036_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_create_time_datetime_statistic_357d2036_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_update_time_datetime_statistic_db4e931a_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_update_time_datetime_statistic_db4e931a_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_update_time_datetime_statistic_dd6b066c_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_update_time_datetime_statistic_dd6b066c_count(queryWrapper);
                                }


                        @Override
                        public List<Object> delayed_tasks_update_time_datetime_statistic_ec1bf144_count(LambdaQueryWrapper queryWrapper) {
                                return delayedTasksStaticMapper.delayed_tasks_update_time_datetime_statistic_ec1bf144_count(queryWrapper);
                                }


}
