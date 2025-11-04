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
import com.kuafu.web.entity.AppointmentStatusEnum;
import com.kuafu.web.service.IAppointmentStatusEnumService;
import com.kuafu.web.vo.AppointmentStatusEnumPageVO;
import com.kuafu.web.vo.AppointmentStatusEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 预约状态 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("AppointmentStatusEnumControllerService")
@RequiredArgsConstructor
public class AppointmentStatusEnumControllerService  {

    private final IAppointmentStatusEnumService appointmentStatusEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( AppointmentStatusEnumPageVO pageVO){
        IPage<AppointmentStatusEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<AppointmentStatusEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(AppointmentStatusEnum::getAppointmentStatusEnumId);

            if(pageVO.getAppointmentStatusEnumId() != null){
                queryWrapper.eq(AppointmentStatusEnum::getAppointmentStatusEnumId, pageVO.getAppointmentStatusEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {
//                        queryWrapper.like(AppointmentStatusEnum::getStatusName, pageVO.getStatusName());
                        String s_string = pageVO.getStatusName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(AppointmentStatusEnum::getStatusName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

            return ResultUtils.success(appointmentStatusEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  AppointmentStatusEnumVO vo){
            LambdaQueryWrapper<AppointmentStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getStatusName())) {
                            queryWrapper.like(AppointmentStatusEnum::getStatusName, vo.getStatusName());
                }
                return ResultUtils.success(appointmentStatusEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  AppointmentStatusEnumVO vo) {
                AppointmentStatusEnum entity =  AppointmentStatusEnum.builder()
                    .statusName(vo.getStatusName())
                .build();








                boolean flag =this.appointmentStatusEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("appointment_status_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getAppointmentStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( AppointmentStatusEnumVO vo) {
                AppointmentStatusEnum entity =  AppointmentStatusEnum.builder()
                    .appointmentStatusEnumId(vo.getAppointmentStatusEnumId())
                    .statusName(vo.getStatusName())
                .build();



                        boolean flag = this.appointmentStatusEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getAppointmentStatusEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( AppointmentStatusEnumVO vo ) {
                AppointmentStatusEnum entity = this.appointmentStatusEnumService.getById(vo.getAppointmentStatusEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( AppointmentStatusEnumVO vo) {
                boolean flag = this.appointmentStatusEnumService.removeById(vo.getAppointmentStatusEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
