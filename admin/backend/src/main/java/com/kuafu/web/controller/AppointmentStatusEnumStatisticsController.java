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
import com.kuafu.web.entity.AppointmentStatusEnum;
import com.kuafu.web.service.IAppointmentStatusEnumStatisticsService;
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
@RequestMapping("/appointmentStatusEnumStatistics")

public class AppointmentStatusEnumStatisticsController  {

    private final IAppointmentStatusEnumStatisticsService appointmentStatusEnumStatisticsService;


    @PostMapping("appointment_status_enum_appointment_status_enum_id_status_statistic_c8bb39e7_count")
    public BaseResponse appointment_status_enum_appointment_status_enum_id_status_statistic_c8bb39e7_count(@RequestBody AppointmentStatusEnum statisticVo) {
        LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentStatusEnumStatisticsService.appointment_status_enum_appointment_status_enum_id_status_statistic_c8bb39e7_count(queryWrapper));
    }
    @PostMapping("appointment_status_enum_appointment_status_enum_id_status_statistic_f5b4188e_count")
    public BaseResponse appointment_status_enum_appointment_status_enum_id_status_statistic_f5b4188e_count(@RequestBody AppointmentStatusEnum statisticVo) {
        LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentStatusEnumStatisticsService.appointment_status_enum_appointment_status_enum_id_status_statistic_f5b4188e_count(queryWrapper));
    }
    @PostMapping("appointment_status_enum_appointment_status_enum_id_status_statistic_d95ed513_count")
    public BaseResponse appointment_status_enum_appointment_status_enum_id_status_statistic_d95ed513_count(@RequestBody AppointmentStatusEnum statisticVo) {
        LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentStatusEnumStatisticsService.appointment_status_enum_appointment_status_enum_id_status_statistic_d95ed513_count(queryWrapper));
    }
    @PostMapping("appointment_status_enum_status_name_status_statistic_249d4459_count")
    public BaseResponse appointment_status_enum_status_name_status_statistic_249d4459_count(@RequestBody AppointmentStatusEnum statisticVo) {
        LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentStatusEnumStatisticsService.appointment_status_enum_status_name_status_statistic_249d4459_count(queryWrapper));
    }
    @PostMapping("appointment_status_enum_status_name_status_statistic_3b4314ee_count")
    public BaseResponse appointment_status_enum_status_name_status_statistic_3b4314ee_count(@RequestBody AppointmentStatusEnum statisticVo) {
        LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentStatusEnumStatisticsService.appointment_status_enum_status_name_status_statistic_3b4314ee_count(queryWrapper));
    }
    @PostMapping("appointment_status_enum_status_name_status_statistic_335ff694_count")
    public BaseResponse appointment_status_enum_status_name_status_statistic_335ff694_count(@RequestBody AppointmentStatusEnum statisticVo) {
        LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentStatusEnumStatisticsService.appointment_status_enum_status_name_status_statistic_335ff694_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper, AppointmentStatusEnum statisticVo){
        if(StringUtils.isNotEmpty(statisticVo.getStatusName())) {
                        queryWrapper.like(AppointmentStatusEnum::getStatusName, statisticVo.getStatusName());
            }
    }



}
