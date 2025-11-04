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
import com.kuafu.web.entity.CommissionInfoAll;
import com.kuafu.web.service.ICommissionInfoAllService;
import com.kuafu.web.vo.CommissionInfoAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 佣金信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("CommissionInfoAllControllerService")
public class CommissionInfoAllControllerService implements IControllerService<CommissionInfoAll> {


@Autowired
    private  ICommissionInfoAllService commissionInfoAllService;




@Autowired
@Lazy
    private  UserInfoAllControllerService UserInfoAllControllerService;




    public BaseResponse page( CommissionInfoAllPageVO pageVO){
        IPage<CommissionInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<CommissionInfoAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("ci.commission_info_id");
        LambdaQueryWrapper<CommissionInfoAll> queryWrapper = objectQueryWrapper.lambda();


        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(CommissionInfoAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getCommissionInfoId() != null){
                queryWrapper.eq(CommissionInfoAll::getCommissionInfoId, pageVO.getCommissionInfoId());
            }
            if(pageVO.getTotalEarnings() != null){
                queryWrapper.eq(CommissionInfoAll::getTotalEarnings, pageVO.getTotalEarnings());
            }
            if(pageVO.getMemberLevelId() != null){
                queryWrapper.eq(CommissionInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
            }
            if(pageVO.getCommissionRatio() != null){
                queryWrapper.eq(CommissionInfoAll::getCommissionRatio, pageVO.getCommissionRatio());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(CommissionInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
            if(pageVO.getUserInfoUserInfoId3() != null){
                queryWrapper.eq(CommissionInfoAll::getUserInfoUserInfoId3, pageVO.getUserInfoUserInfoId3());
            }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
                queryWrapper.like(CommissionInfoAll::getEmail, pageVO.getEmail());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(CommissionInfoAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    commissionInfoAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
                        if(item.getUserInfoUserInfoId3() != null){
                            item.setAvatar(UserInfoAllControllerService.getById(item.getUserInfoUserInfoId3()).getAvatar());
                        }
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(CommissionInfoAllPageVO vo){
            LambdaQueryWrapper<CommissionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(CommissionInfoAll::getPassword, vo.getPassword());
                }
                if(vo.getTotalEarnings() != null){
                    queryWrapper.eq(CommissionInfoAll::getTotalEarnings, vo.getTotalEarnings());
                }
                if(vo.getMemberLevelId() != null){
                    queryWrapper.eq(CommissionInfoAll::getMemberLevelId, vo.getMemberLevelId());
                }
                if(vo.getCommissionRatio() != null){
                    queryWrapper.eq(CommissionInfoAll::getCommissionRatio, vo.getCommissionRatio());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(CommissionInfoAll::getPhoneNumber, vo.getPhoneNumber());
                }
                if(vo.getUserInfoUserInfoId3() != null){
                    queryWrapper.eq(CommissionInfoAll::getUserInfoUserInfoId3, vo.getUserInfoUserInfoId3());
                }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
                    queryWrapper.eq(CommissionInfoAll::getEmail, vo.getEmail());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(CommissionInfoAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(commissionInfoAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(CommissionInfoAllPageVO vo) {


                LambdaQueryWrapper<CommissionInfoAll> queryWrapper = new LambdaQueryWrapper<>();


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(CommissionInfoAll::getPassword, vo.getPassword());
                                }


                                if(vo.getCommissionInfoId() != null){
                                    queryWrapper.eq(CommissionInfoAll::getCommissionInfoId, vo.getCommissionInfoId());
                                }


                                if(vo.getTotalEarnings() != null){
                                    queryWrapper.eq(CommissionInfoAll::getTotalEarnings, vo.getTotalEarnings());
                                }


                                if(vo.getMemberLevelId() != null){
                                    queryWrapper.eq(CommissionInfoAll::getMemberLevelId, vo.getMemberLevelId());
                                }


                                if(vo.getCommissionRatio() != null){
                                    queryWrapper.eq(CommissionInfoAll::getCommissionRatio, vo.getCommissionRatio());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(CommissionInfoAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                                if(vo.getUserInfoUserInfoId3() != null){
                                    queryWrapper.eq(CommissionInfoAll::getUserInfoUserInfoId3, vo.getUserInfoUserInfoId3());
                                }


                            if(StringUtils.isNotEmpty(vo.getEmail())) {
                                    queryWrapper.eq(CommissionInfoAll::getEmail, vo.getEmail());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(CommissionInfoAll::getUsername, vo.getUsername());
                                }

                // CommissionInfoAll entity = this.commissionInfoAllService.getById(commissionInfoId);
                    final Page<CommissionInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    commissionInfoAllService.pageNew(page, vo, queryWrapper);
                    final List<CommissionInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public CommissionInfoAll getById(Serializable commissionInfoId) {

                    LambdaQueryWrapper<CommissionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(CommissionInfoAll::getCommissionInfoId, commissionInfoId);

                    final Page<CommissionInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    commissionInfoAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<CommissionInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
