package com.kuafu.web.controller;

import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.kuafu.common.resource.service.IStaticResourceService;
import com.kuafu.common.event.EventVo;
import com.kuafu.common.event.MyEventService;
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
import org.springframework.transaction.support.TransactionTemplate;
import com.kuafu.common.sensitive.SensitiveFilter;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.AppointmentInfo;
import com.kuafu.web.service.IAppointmentInfoService;
import com.kuafu.web.vo.AppointmentInfoPageVO;
import com.kuafu.web.vo.AppointmentInfoVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 预约信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("AppointmentInfoControllerService")
@RequiredArgsConstructor
public class AppointmentInfoControllerService  {

    private final IAppointmentInfoService appointmentInfoService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( AppointmentInfoPageVO pageVO){
        IPage<AppointmentInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<AppointmentInfo> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(AppointmentInfo::getAppointmentInfoId);

            if(pageVO.getAppointmentInfoId() != null){
                queryWrapper.eq(AppointmentInfo::getAppointmentInfoId, pageVO.getAppointmentInfoId());
            }


            if(pageVO.getUserInfoUserInfoId1() != null){
                queryWrapper.eq(AppointmentInfo::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
            }


        if(StringUtils.isNotEmpty(pageVO.getDoctorName())) {
//                        queryWrapper.like(AppointmentInfo::getDoctorName, pageVO.getDoctorName());
                        String s_string = pageVO.getDoctorName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AppointmentInfo::getDoctorName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }


            if(pageVO.getAppointmentDate() != null){
                queryWrapper.eq(AppointmentInfo::getAppointmentDate, pageVO.getAppointmentDate());
            }


        if(StringUtils.isNotEmpty(pageVO.getAppointmentTime())) {
                queryWrapper.eq(AppointmentInfo::getAppointmentTime, pageVO.getAppointmentTime());
            }


            if(pageVO.getStatusEnumId() != null){
                queryWrapper.eq(AppointmentInfo::getStatusEnumId, pageVO.getStatusEnumId());
            }


            if(pageVO.getDepositPaid() != null){
                queryWrapper.eq(AppointmentInfo::getDepositPaid, pageVO.getDepositPaid());
            }


            if(pageVO.getDepositAmount() != null){
                queryWrapper.eq(AppointmentInfo::getDepositAmount, pageVO.getDepositAmount());
            }


            if(pageVO.getCouponReceived() != null){
                queryWrapper.eq(AppointmentInfo::getCouponReceived, pageVO.getCouponReceived());
            }


        if(StringUtils.isNotEmpty(pageVO.getAppointmentCode())) {
                queryWrapper.eq(AppointmentInfo::getAppointmentCode, pageVO.getAppointmentCode());
            }

            return ResultUtils.success(appointmentInfoService.page(page, queryWrapper));
        }


        public BaseResponse list(  AppointmentInfoVO vo){
            LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
                    queryWrapper.eq(AppointmentInfo::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
                }
            if(StringUtils.isNotEmpty(vo.getDoctorName())) {
                            queryWrapper.like(AppointmentInfo::getDoctorName, vo.getDoctorName());
                }
                if(vo.getAppointmentDate() != null){
                    queryWrapper.eq(AppointmentInfo::getAppointmentDate, vo.getAppointmentDate());
                }
            if(StringUtils.isNotEmpty(vo.getAppointmentTime())) {
                    queryWrapper.eq(AppointmentInfo::getAppointmentTime, vo.getAppointmentTime());
                }
                if(vo.getStatusEnumId() != null){
                    queryWrapper.eq(AppointmentInfo::getStatusEnumId, vo.getStatusEnumId());
                }
                if(vo.getDepositPaid() != null){
                    queryWrapper.eq(AppointmentInfo::getDepositPaid, vo.getDepositPaid());
                }
                if(vo.getDepositAmount() != null){
                    queryWrapper.eq(AppointmentInfo::getDepositAmount, vo.getDepositAmount());
                }
                if(vo.getCouponReceived() != null){
                    queryWrapper.eq(AppointmentInfo::getCouponReceived, vo.getCouponReceived());
                }
            if(StringUtils.isNotEmpty(vo.getAppointmentCode())) {
                    queryWrapper.eq(AppointmentInfo::getAppointmentCode, vo.getAppointmentCode());
                }
                return ResultUtils.success(appointmentInfoService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  AppointmentInfoVO vo) {
                AppointmentInfo entity =  AppointmentInfo.builder()
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .doctorName(vo.getDoctorName())
                    .appointmentDate(vo.getAppointmentDate())
                    .appointmentTime(vo.getAppointmentTime())
                    .statusEnumId(vo.getStatusEnumId())
                    .depositPaid(vo.getDepositPaid())
                    .depositAmount(vo.getDepositAmount())
                    .couponReceived(vo.getCouponReceived())
                    .appointmentCode(vo.getAppointmentCode())
                .build();








                boolean flag =this.appointmentInfoService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("appointment_info").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getAppointmentInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( AppointmentInfoVO vo) {
                AppointmentInfo entity =  AppointmentInfo.builder()
                    .appointmentInfoId(vo.getAppointmentInfoId())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .doctorName(vo.getDoctorName())
                    .appointmentDate(vo.getAppointmentDate())
                    .appointmentTime(vo.getAppointmentTime())
                    .statusEnumId(vo.getStatusEnumId())
                    .depositPaid(vo.getDepositPaid())
                    .depositAmount(vo.getDepositAmount())
                    .couponReceived(vo.getCouponReceived())
                    .appointmentCode(vo.getAppointmentCode())
                .build();



                        boolean flag = this.appointmentInfoService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getAppointmentInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( AppointmentInfoVO vo ) {
                AppointmentInfo entity = this.appointmentInfoService.getById(vo.getAppointmentInfoId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( AppointmentInfoVO vo) {
                boolean flag = this.appointmentInfoService.removeById(vo.getAppointmentInfoId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
