package com.kuafu.web.controller;

import java.util.List;
import java.util.stream.Collectors;

import java.io.Serializable;
import com.kuafu.common.login.IControllerService;

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
import org.apache.commons.lang3.ObjectUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import com.kuafu.login.annotation.*;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.AppointmentInfoAll;
import com.kuafu.web.service.IAppointmentInfoAllService;
import com.kuafu.web.vo.AppointmentInfoAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.service.IAppointmentStatusEnumService;
import com.kuafu.web.entity.AppointmentStatusEnum;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 预约信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("AppointmentInfoAllControllerService")
public class AppointmentInfoAllControllerService implements IControllerService<AppointmentInfoAll> {


@Autowired
    private  IAppointmentInfoAllService appointmentInfoAllService;




@Autowired
@Lazy
    private  UserInfoAllControllerService UserInfoAllControllerService;




    public BaseResponse page( AppointmentInfoAllPageVO pageVO){
        IPage<AppointmentInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<AppointmentInfoAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("ai.appointment_info_id");
        LambdaQueryWrapper<AppointmentInfoAll> queryWrapper = objectQueryWrapper.lambda();


            if(pageVO.getDepositAmount() != null){
                queryWrapper.eq(AppointmentInfoAll::getDepositAmount, pageVO.getDepositAmount());
            }
        if(StringUtils.isNotEmpty(pageVO.getAppointmentTime())) {
                queryWrapper.like(AppointmentInfoAll::getAppointmentTime, pageVO.getAppointmentTime());
            }
            if(pageVO.getAppointmentInfoId() != null){
                queryWrapper.eq(AppointmentInfoAll::getAppointmentInfoId, pageVO.getAppointmentInfoId());
            }
            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(AppointmentInfoAll::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }
            if(pageVO.getMemberLevelId() != null){
                queryWrapper.eq(AppointmentInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
            }
        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {

                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AppointmentInfoAll::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
            if(pageVO.getAppointmentDate() != null){
                queryWrapper.eq(AppointmentInfoAll::getAppointmentDate, pageVO.getAppointmentDate());
            }
        if(StringUtils.isNotEmpty(pageVO.getAppointmentCode())) {
                queryWrapper.like(AppointmentInfoAll::getAppointmentCode, pageVO.getAppointmentCode());
            }
            if(pageVO.getDepositPaid() != null){
                queryWrapper.eq(AppointmentInfoAll::getDepositPaid, pageVO.getDepositPaid());
            }
            if(pageVO.getStatusEnumId() != null){
                queryWrapper.eq(AppointmentInfoAll::getStatusEnumId, pageVO.getStatusEnumId());
            }
            if(pageVO.getCouponReceived() != null){
                queryWrapper.eq(AppointmentInfoAll::getCouponReceived, pageVO.getCouponReceived());
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(AppointmentInfoAll::getPassword, pageVO.getPassword());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(AppointmentInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
        if(StringUtils.isNotEmpty(pageVO.getDoctorName())) {

                        String s_string = pageVO.getDoctorName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AppointmentInfoAll::getDoctorName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
                queryWrapper.like(AppointmentInfoAll::getEmail, pageVO.getEmail());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AppointmentInfoAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    appointmentInfoAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
                        if(item.getUserInfoUserInfoId1() != null){
                            item.setAvatar(UserInfoAllControllerService.getById(item.getUserInfoUserInfoId1()).getAvatar());
                        }
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(AppointmentInfoAllPageVO vo){
            LambdaQueryWrapper<AppointmentInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getDepositAmount() != null){
                    queryWrapper.eq(AppointmentInfoAll::getDepositAmount, vo.getDepositAmount());
                }
            if(StringUtils.isNotEmpty(vo.getAppointmentTime())) {
                    queryWrapper.eq(AppointmentInfoAll::getAppointmentTime, vo.getAppointmentTime());
                }
                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(AppointmentInfoAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
                if(vo.getMemberLevelId() != null){
                    queryWrapper.eq(AppointmentInfoAll::getMemberLevelId, vo.getMemberLevelId());
                }
            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(AppointmentInfoAll::getStatusName, vo.getStatusName());
                }
                if(vo.getAppointmentDate() != null){
                    queryWrapper.eq(AppointmentInfoAll::getAppointmentDate, vo.getAppointmentDate());
                }
            if(StringUtils.isNotEmpty(vo.getAppointmentCode())) {
                    queryWrapper.eq(AppointmentInfoAll::getAppointmentCode, vo.getAppointmentCode());
                }
                if(vo.getDepositPaid() != null){
                    queryWrapper.eq(AppointmentInfoAll::getDepositPaid, vo.getDepositPaid());
                }
                if(vo.getStatusEnumId() != null){
                    queryWrapper.eq(AppointmentInfoAll::getStatusEnumId, vo.getStatusEnumId());
                }
                if(vo.getCouponReceived() != null){
                    queryWrapper.eq(AppointmentInfoAll::getCouponReceived, vo.getCouponReceived());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(AppointmentInfoAll::getPassword, vo.getPassword());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(AppointmentInfoAll::getPhoneNumber, vo.getPhoneNumber());
                }
            if(StringUtils.isNotEmpty(vo.getDoctorName())) {
                            queryWrapper.like(AppointmentInfoAll::getDoctorName, vo.getDoctorName());
                }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
                    queryWrapper.eq(AppointmentInfoAll::getEmail, vo.getEmail());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(AppointmentInfoAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(appointmentInfoAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(AppointmentInfoAllPageVO vo) {


                LambdaQueryWrapper<AppointmentInfoAll> queryWrapper = new LambdaQueryWrapper<>();


                                if(vo.getDepositAmount() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getDepositAmount, vo.getDepositAmount());
                                }


                            if(StringUtils.isNotEmpty(vo.getAppointmentTime())) {
                                    queryWrapper.eq(AppointmentInfoAll::getAppointmentTime, vo.getAppointmentTime());
                                }


                                if(vo.getAppointmentInfoId() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getAppointmentInfoId, vo.getAppointmentInfoId());
                                }


                                if(vo.getUserInfoUserInfoId1() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                                }


                                if(vo.getMemberLevelId() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getMemberLevelId, vo.getMemberLevelId());
                                }


                            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                                            queryWrapper.like(AppointmentInfoAll::getStatusName, vo.getStatusName());
                                }


                                if(vo.getAppointmentDate() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getAppointmentDate, vo.getAppointmentDate());
                                }


                            if(StringUtils.isNotEmpty(vo.getAppointmentCode())) {
                                    queryWrapper.eq(AppointmentInfoAll::getAppointmentCode, vo.getAppointmentCode());
                                }


                                if(vo.getDepositPaid() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getDepositPaid, vo.getDepositPaid());
                                }


                                if(vo.getStatusEnumId() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getStatusEnumId, vo.getStatusEnumId());
                                }


                                if(vo.getCouponReceived() != null){
                                    queryWrapper.eq(AppointmentInfoAll::getCouponReceived, vo.getCouponReceived());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(AppointmentInfoAll::getPassword, vo.getPassword());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(AppointmentInfoAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                            if(StringUtils.isNotEmpty(vo.getDoctorName())) {
                                            queryWrapper.like(AppointmentInfoAll::getDoctorName, vo.getDoctorName());
                                }


                            if(StringUtils.isNotEmpty(vo.getEmail())) {
                                    queryWrapper.eq(AppointmentInfoAll::getEmail, vo.getEmail());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(AppointmentInfoAll::getUsername, vo.getUsername());
                                }

                // AppointmentInfoAll entity = this.appointmentInfoAllService.getById(appointmentInfoId);
                    final Page<AppointmentInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    appointmentInfoAllService.pageNew(page, vo, queryWrapper);
                    final List<AppointmentInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public AppointmentInfoAll getById(Serializable appointmentInfoId) {

                    LambdaQueryWrapper<AppointmentInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(AppointmentInfoAll::getAppointmentInfoId, appointmentInfoId);

                    final Page<AppointmentInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    appointmentInfoAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<AppointmentInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
