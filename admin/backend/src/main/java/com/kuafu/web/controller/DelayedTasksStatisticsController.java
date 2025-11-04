package com.kuafu.web.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;


import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.DelayedTasks;
import com.kuafu.web.service.IDelayedTasksStatisticsService;
import com.kuafu.web.entity.SelectVO;

import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;





/**

 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/delayedTasksStatistics")

public class DelayedTasksStatisticsController  {

    private final IDelayedTasksStatisticsService delayedTasksStatisticsService;


    @PostMapping("delayed_tasks_status_status_statistic_25c6486d_count")
    public BaseResponse delayed_tasks_status_status_statistic_25c6486d_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_status_status_statistic_25c6486d_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_status_status_statistic_b664fbca_count")
    public BaseResponse delayed_tasks_status_status_statistic_b664fbca_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_status_status_statistic_b664fbca_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_status_status_statistic_f7af67be_count")
    public BaseResponse delayed_tasks_status_status_statistic_f7af67be_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_status_status_statistic_f7af67be_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_execute_time_datetime_statistic_15cc1805_count")
    public BaseResponse delayed_tasks_execute_time_datetime_statistic_15cc1805_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_execute_time_datetime_statistic_15cc1805_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_execute_time_datetime_statistic_5293da89_count")
    public BaseResponse delayed_tasks_execute_time_datetime_statistic_5293da89_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_execute_time_datetime_statistic_5293da89_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_execute_time_datetime_statistic_470e98fd_count")
    public BaseResponse delayed_tasks_execute_time_datetime_statistic_470e98fd_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_execute_time_datetime_statistic_470e98fd_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_create_time_datetime_statistic_92d59b0a_count")
    public BaseResponse delayed_tasks_create_time_datetime_statistic_92d59b0a_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_create_time_datetime_statistic_92d59b0a_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_create_time_datetime_statistic_ea989616_count")
    public BaseResponse delayed_tasks_create_time_datetime_statistic_ea989616_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_create_time_datetime_statistic_ea989616_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_create_time_datetime_statistic_357d2036_count")
    public BaseResponse delayed_tasks_create_time_datetime_statistic_357d2036_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_create_time_datetime_statistic_357d2036_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_update_time_datetime_statistic_db4e931a_count")
    public BaseResponse delayed_tasks_update_time_datetime_statistic_db4e931a_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_update_time_datetime_statistic_db4e931a_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_update_time_datetime_statistic_dd6b066c_count")
    public BaseResponse delayed_tasks_update_time_datetime_statistic_dd6b066c_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_update_time_datetime_statistic_dd6b066c_count(queryWrapper));
    }
    @PostMapping("delayed_tasks_update_time_datetime_statistic_ec1bf144_count")
    public BaseResponse delayed_tasks_update_time_datetime_statistic_ec1bf144_count(@RequestBody DelayedTasks statisticVo) {
        LambdaQueryWrapper<DelayedTasks> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( delayedTasksStatisticsService.delayed_tasks_update_time_datetime_statistic_ec1bf144_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<DelayedTasks> queryWrapper, DelayedTasks statisticVo){
        if(StringUtils.isNotEmpty(statisticVo.getTaskType())) {
                queryWrapper.eq(DelayedTasks::getTaskType, statisticVo.getTaskType());
            }
        if(StringUtils.isNotEmpty(statisticVo.getTaskData())) {
                queryWrapper.eq(DelayedTasks::getTaskData, statisticVo.getTaskData());
            }
        if(StringUtils.isNotEmpty(statisticVo.getStatus())) {
                queryWrapper.eq(DelayedTasks::getStatus, statisticVo.getStatus());
            }
            if(statisticVo.getExecuteTime() != null){
                queryWrapper.eq(DelayedTasks::getExecuteTime, statisticVo.getExecuteTime());
            }
            if(statisticVo.getCreateTime() != null){
                queryWrapper.eq(DelayedTasks::getCreateTime, statisticVo.getCreateTime());
            }
            if(statisticVo.getUpdateTime() != null){
                queryWrapper.eq(DelayedTasks::getUpdateTime, statisticVo.getUpdateTime());
            }
    }



}
