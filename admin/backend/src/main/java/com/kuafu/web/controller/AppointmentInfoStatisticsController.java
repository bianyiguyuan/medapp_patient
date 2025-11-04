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
import com.kuafu.web.entity.AppointmentInfo;
import com.kuafu.web.service.IAppointmentInfoStatisticsService;
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
@RequestMapping("/appointmentInfoStatistics")

public class AppointmentInfoStatisticsController  {

    private final IAppointmentInfoStatisticsService appointmentInfoStatisticsService;


    @PostMapping("appointment_info_statistic_79c41f2d_count")
    public BaseResponse appointment_info_statistic_79c41f2d_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_statistic_79c41f2d_count(queryWrapper));
    }
    @PostMapping("appointment_info_statistic_68bf9dc9_count")
    public BaseResponse appointment_info_statistic_68bf9dc9_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_statistic_68bf9dc9_count(queryWrapper));
    }
    @PostMapping("appointment_info_statistic_2295eb27_count")
    public BaseResponse appointment_info_statistic_2295eb27_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_statistic_2295eb27_count(queryWrapper));
    }
    @PostMapping("appointment_info_statistic_ea7f3f64_count")
    public BaseResponse appointment_info_statistic_ea7f3f64_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_statistic_ea7f3f64_count(queryWrapper));
    }
    @PostMapping("appointment_info_statistic_bd73227b_count")
    public BaseResponse appointment_info_statistic_bd73227b_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_statistic_bd73227b_count(queryWrapper));
    }
    @PostMapping("appointment_info_statistic_a642f352_count")
    public BaseResponse appointment_info_statistic_a642f352_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_statistic_a642f352_count(queryWrapper));
    }
    @PostMapping("appointment_info_appointment_date_datetime_statistic_51bb93f2_count")
    public BaseResponse appointment_info_appointment_date_datetime_statistic_51bb93f2_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_appointment_date_datetime_statistic_51bb93f2_count(queryWrapper));
    }
    @PostMapping("appointment_info_appointment_date_datetime_statistic_2552826b_count")
    public BaseResponse appointment_info_appointment_date_datetime_statistic_2552826b_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_appointment_date_datetime_statistic_2552826b_count(queryWrapper));
    }
    @PostMapping("appointment_info_appointment_date_datetime_statistic_9af84525_count")
    public BaseResponse appointment_info_appointment_date_datetime_statistic_9af84525_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_appointment_date_datetime_statistic_9af84525_count(queryWrapper));
    }
    @PostMapping("appointment_info_status_enum_id_status_statistic_b808bb00_count")
    public BaseResponse appointment_info_status_enum_id_status_statistic_b808bb00_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_status_enum_id_status_statistic_b808bb00_count(queryWrapper));
    }
    @PostMapping("appointment_info_status_enum_id_status_statistic_6a735f1e_count")
    public BaseResponse appointment_info_status_enum_id_status_statistic_6a735f1e_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_status_enum_id_status_statistic_6a735f1e_count(queryWrapper));
    }
    @PostMapping("appointment_info_status_enum_id_status_statistic_1bfef9e7_count")
    public BaseResponse appointment_info_status_enum_id_status_statistic_1bfef9e7_count(@RequestBody AppointmentInfo statisticVo) {
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( appointmentInfoStatisticsService.appointment_info_status_enum_id_status_statistic_1bfef9e7_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<AppointmentInfo> queryWrapper, AppointmentInfo statisticVo){
            if(statisticVo.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(AppointmentInfo::getUserInfoUserInfoId1, statisticVo.getUserInfoUserInfoId1());
            }
        if(StringUtils.isNotEmpty(statisticVo.getDoctorName())) {
                        queryWrapper.like(AppointmentInfo::getDoctorName, statisticVo.getDoctorName());
            }
            if(statisticVo.getAppointmentDate() != null){
                queryWrapper.eq(AppointmentInfo::getAppointmentDate, statisticVo.getAppointmentDate());
            }
        if(StringUtils.isNotEmpty(statisticVo.getAppointmentTime())) {
                queryWrapper.eq(AppointmentInfo::getAppointmentTime, statisticVo.getAppointmentTime());
            }
            if(statisticVo.getStatusEnumId() != null){
                queryWrapper.eq(AppointmentInfo::getStatusEnumId, statisticVo.getStatusEnumId());
            }
            if(statisticVo.getDepositPaid() != null){
                queryWrapper.eq(AppointmentInfo::getDepositPaid, statisticVo.getDepositPaid());
            }
            if(statisticVo.getDepositAmount() != null){
                queryWrapper.eq(AppointmentInfo::getDepositAmount, statisticVo.getDepositAmount());
            }
            if(statisticVo.getCouponReceived() != null){
                queryWrapper.eq(AppointmentInfo::getCouponReceived, statisticVo.getCouponReceived());
            }
        if(StringUtils.isNotEmpty(statisticVo.getAppointmentCode())) {
                queryWrapper.eq(AppointmentInfo::getAppointmentCode, statisticVo.getAppointmentCode());
            }
    }



}
