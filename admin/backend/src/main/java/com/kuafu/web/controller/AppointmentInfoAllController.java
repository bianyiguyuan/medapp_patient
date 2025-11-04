package com.kuafu.web.controller;

import com.kuafu.common.util.poi.ExcelUtil;
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
import javax.servlet.http.HttpServletResponse;


import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.SelectVO;
import com.kuafu.web.entity.AppointmentInfoAll;
import com.kuafu.web.service.IAppointmentInfoAllService;
import com.kuafu.web.vo.AppointmentInfoAllPageVO;

import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.service.IAppointmentStatusEnumService;
import com.kuafu.web.entity.AppointmentStatusEnum;


/**
 * <p> 预约信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointmentInfoAll")
@Api(tags = {"预约信息"})
public class AppointmentInfoAllController  {

    private final IAppointmentInfoAllService appointmentInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody AppointmentInfoAllPageVO pageVO){
        IPage<AppointmentInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<AppointmentInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getUserInfoUserInfoId1() != null){
            queryWrapper.eq(AppointmentInfoAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
        }
            if(pageVO.getDepositAmount() != null){
            queryWrapper.eq(AppointmentInfoAll::getDepositAmount, pageVO.getDepositAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(AppointmentInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
            if(pageVO.getMemberLevelId() != null){
            queryWrapper.eq(AppointmentInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
        }
        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {
            queryWrapper.like(AppointmentInfoAll::getStatusName, pageVO.getStatusName());
        }
        if(StringUtils.isNotEmpty(pageVO.getAppointmentTime())) {
            queryWrapper.eq(AppointmentInfoAll::getAppointmentTime, pageVO.getAppointmentTime());
        }
        if(StringUtils.isNotEmpty(pageVO.getAvatarResourceKey())) {
            queryWrapper.eq(AppointmentInfoAll::getAvatarResourceKey, pageVO.getAvatarResourceKey());
        }
        if(StringUtils.isNotEmpty(pageVO.getDoctorName())) {
            queryWrapper.like(AppointmentInfoAll::getDoctorName, pageVO.getDoctorName());
        }
            if(pageVO.getAppointmentDate() != null){
            queryWrapper.eq(AppointmentInfoAll::getAppointmentDate, pageVO.getAppointmentDate());
        }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
            queryWrapper.eq(AppointmentInfoAll::getPassword, pageVO.getPassword());
        }
        if(StringUtils.isNotEmpty(pageVO.getAppointmentCode())) {
            queryWrapper.eq(AppointmentInfoAll::getAppointmentCode, pageVO.getAppointmentCode());
        }
            if(pageVO.getStatusEnumId() != null){
            queryWrapper.eq(AppointmentInfoAll::getStatusEnumId, pageVO.getStatusEnumId());
        }
            if(pageVO.getDepositPaid() != null){
            queryWrapper.eq(AppointmentInfoAll::getDepositPaid, pageVO.getDepositPaid());
        }
            if(pageVO.getCouponReceived() != null){
            queryWrapper.eq(AppointmentInfoAll::getCouponReceived, pageVO.getCouponReceived());
        }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
            queryWrapper.eq(AppointmentInfoAll::getEmail, pageVO.getEmail());
        }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {
            queryWrapper.like(AppointmentInfoAll::getUsername, pageVO.getUsername());
        }
        return ResultUtils.success(appointmentInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody AppointmentInfoAllPageVO vo){
        LambdaQueryWrapper<AppointmentInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
            queryWrapper.eq(AppointmentInfoAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
        }
                if(vo.getDepositAmount() != null){
            queryWrapper.eq(AppointmentInfoAll::getDepositAmount, vo.getDepositAmount());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(AppointmentInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
                if(vo.getMemberLevelId() != null){
            queryWrapper.eq(AppointmentInfoAll::getMemberLevelId, vo.getMemberLevelId());
        }
            if(StringUtils.isNotEmpty(vo.getStatusName())) {
            queryWrapper.like(AppointmentInfoAll::getStatusName, vo.getStatusName());
        }
            if(StringUtils.isNotEmpty(vo.getAppointmentTime())) {
            queryWrapper.eq(AppointmentInfoAll::getAppointmentTime, vo.getAppointmentTime());
        }
            if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
            queryWrapper.eq(AppointmentInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
        }
            if(StringUtils.isNotEmpty(vo.getDoctorName())) {
            queryWrapper.like(AppointmentInfoAll::getDoctorName, vo.getDoctorName());
        }
                if(vo.getAppointmentDate() != null){
            queryWrapper.eq(AppointmentInfoAll::getAppointmentDate, vo.getAppointmentDate());
        }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
            queryWrapper.eq(AppointmentInfoAll::getPassword, vo.getPassword());
        }
            if(StringUtils.isNotEmpty(vo.getAppointmentCode())) {
            queryWrapper.eq(AppointmentInfoAll::getAppointmentCode, vo.getAppointmentCode());
        }
                if(vo.getStatusEnumId() != null){
            queryWrapper.eq(AppointmentInfoAll::getStatusEnumId, vo.getStatusEnumId());
        }
                if(vo.getDepositPaid() != null){
            queryWrapper.eq(AppointmentInfoAll::getDepositPaid, vo.getDepositPaid());
        }
                if(vo.getCouponReceived() != null){
            queryWrapper.eq(AppointmentInfoAll::getCouponReceived, vo.getCouponReceived());
        }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
            queryWrapper.eq(AppointmentInfoAll::getEmail, vo.getEmail());
        }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
            queryWrapper.like(AppointmentInfoAll::getUsername, vo.getUsername());
        }
        return ResultUtils.success(appointmentInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer appointmentInfoId) {
        AppointmentInfoAll entity = this.appointmentInfoAllService.getById(appointmentInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


        private final IUserInfoService userInfoService;

        @GetMapping("get/user_info_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_user_info_list() {
            List<UserInfo> list = this.userInfoService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getUserInfoId(), p.getPhoneNumber().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }
        private final IAppointmentStatusEnumService appointmentStatusEnumService;

        @GetMapping("get/appointment_status_enum_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_appointment_status_enum_list() {
            List<AppointmentStatusEnum> list = this.appointmentStatusEnumService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getAppointmentStatusEnumId(), p.getStatusName().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }


        /**
         * 导出excel
         */
        @PostMapping("/export")
        public void export(HttpServletResponse response, @RequestBody AppointmentInfoAllPageVO vo) {

            LambdaQueryWrapper<AppointmentInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                    if(vo.getUserInfoUserInfoId1() != null){
                        queryWrapper.eq(AppointmentInfoAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                    }
                    if(vo.getDepositAmount() != null){
                        queryWrapper.eq(AppointmentInfoAll::getDepositAmount, vo.getDepositAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                        queryWrapper.eq(AppointmentInfoAll::getPhoneNumber, vo.getPhoneNumber());
                    }
                    if(vo.getMemberLevelId() != null){
                        queryWrapper.eq(AppointmentInfoAll::getMemberLevelId, vo.getMemberLevelId());
                    }
                if(StringUtils.isNotEmpty(vo.getStatusName())) {
                                queryWrapper.like(AppointmentInfoAll::getStatusName, vo.getStatusName());
                    }
                if(StringUtils.isNotEmpty(vo.getAppointmentTime())) {
                        queryWrapper.eq(AppointmentInfoAll::getAppointmentTime, vo.getAppointmentTime());
                    }
                if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
                        queryWrapper.eq(AppointmentInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
                    }
                if(StringUtils.isNotEmpty(vo.getDoctorName())) {
                                queryWrapper.like(AppointmentInfoAll::getDoctorName, vo.getDoctorName());
                    }
                    if(vo.getAppointmentDate() != null){
                        queryWrapper.eq(AppointmentInfoAll::getAppointmentDate, vo.getAppointmentDate());
                    }
                if(StringUtils.isNotEmpty(vo.getPassword())) {
                        queryWrapper.eq(AppointmentInfoAll::getPassword, vo.getPassword());
                    }
                if(StringUtils.isNotEmpty(vo.getAppointmentCode())) {
                        queryWrapper.eq(AppointmentInfoAll::getAppointmentCode, vo.getAppointmentCode());
                    }
                    if(vo.getStatusEnumId() != null){
                        queryWrapper.eq(AppointmentInfoAll::getStatusEnumId, vo.getStatusEnumId());
                    }
                    if(vo.getDepositPaid() != null){
                        queryWrapper.eq(AppointmentInfoAll::getDepositPaid, vo.getDepositPaid());
                    }
                    if(vo.getCouponReceived() != null){
                        queryWrapper.eq(AppointmentInfoAll::getCouponReceived, vo.getCouponReceived());
                    }
                if(StringUtils.isNotEmpty(vo.getEmail())) {
                        queryWrapper.eq(AppointmentInfoAll::getEmail, vo.getEmail());
                    }
                if(StringUtils.isNotEmpty(vo.getUsername())) {
                                queryWrapper.like(AppointmentInfoAll::getUsername, vo.getUsername());
                    }
            List<AppointmentInfoAll> list = appointmentInfoAllService.list(queryWrapper);
            ExcelUtil<AppointmentInfoAll> util = new ExcelUtil<>(AppointmentInfoAll.class);
            util.exportExcel(response, list, "数据");
        }


}
