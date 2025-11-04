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
import com.kuafu.web.entity.CouponInfoAll;
import com.kuafu.web.service.ICouponInfoAllService;
import com.kuafu.web.vo.CouponInfoAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 优惠券信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("CouponInfoAllControllerService")
public class CouponInfoAllControllerService implements IControllerService<CouponInfoAll> {


@Autowired
    private  ICouponInfoAllService couponInfoAllService;




@Autowired
@Lazy
    private  UserInfoAllControllerService UserInfoAllControllerService;




    public BaseResponse page( CouponInfoAllPageVO pageVO){
        IPage<CouponInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<CouponInfoAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("ci.coupon_info_id");
        LambdaQueryWrapper<CouponInfoAll> queryWrapper = objectQueryWrapper.lambda();


            if(pageVO.getAmount() != null){
                queryWrapper.eq(CouponInfoAll::getAmount, pageVO.getAmount());
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(CouponInfoAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getCouponInfoId() != null){
                queryWrapper.eq(CouponInfoAll::getCouponInfoId, pageVO.getCouponInfoId());
            }
            if(pageVO.getMemberLevelId() != null){
                queryWrapper.eq(CouponInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(CouponInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
            if(pageVO.getUserInfoUserInfoId4() != null){
                queryWrapper.eq(CouponInfoAll::getUserInfoUserInfoId4, pageVO.getUserInfoUserInfoId4());
            }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
                queryWrapper.like(CouponInfoAll::getEmail, pageVO.getEmail());
            }
            if(pageVO.getIsUsed() != null){
                queryWrapper.eq(CouponInfoAll::getIsUsed, pageVO.getIsUsed());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(CouponInfoAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    couponInfoAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
                        if(item.getUserInfoUserInfoId4() != null){
                            item.setAvatar(UserInfoAllControllerService.getById(item.getUserInfoUserInfoId4()).getAvatar());
                        }
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(CouponInfoAllPageVO vo){
            LambdaQueryWrapper<CouponInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getAmount() != null){
                    queryWrapper.eq(CouponInfoAll::getAmount, vo.getAmount());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(CouponInfoAll::getPassword, vo.getPassword());
                }
                if(vo.getMemberLevelId() != null){
                    queryWrapper.eq(CouponInfoAll::getMemberLevelId, vo.getMemberLevelId());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(CouponInfoAll::getPhoneNumber, vo.getPhoneNumber());
                }
                if(vo.getUserInfoUserInfoId4() != null){
                    queryWrapper.eq(CouponInfoAll::getUserInfoUserInfoId4, vo.getUserInfoUserInfoId4());
                }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
                    queryWrapper.eq(CouponInfoAll::getEmail, vo.getEmail());
                }
                if(vo.getIsUsed() != null){
                    queryWrapper.eq(CouponInfoAll::getIsUsed, vo.getIsUsed());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(CouponInfoAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(couponInfoAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(CouponInfoAllPageVO vo) {


                LambdaQueryWrapper<CouponInfoAll> queryWrapper = new LambdaQueryWrapper<>();


                                if(vo.getAmount() != null){
                                    queryWrapper.eq(CouponInfoAll::getAmount, vo.getAmount());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(CouponInfoAll::getPassword, vo.getPassword());
                                }


                                if(vo.getCouponInfoId() != null){
                                    queryWrapper.eq(CouponInfoAll::getCouponInfoId, vo.getCouponInfoId());
                                }


                                if(vo.getMemberLevelId() != null){
                                    queryWrapper.eq(CouponInfoAll::getMemberLevelId, vo.getMemberLevelId());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(CouponInfoAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                                if(vo.getUserInfoUserInfoId4() != null){
                                    queryWrapper.eq(CouponInfoAll::getUserInfoUserInfoId4, vo.getUserInfoUserInfoId4());
                                }


                            if(StringUtils.isNotEmpty(vo.getEmail())) {
                                    queryWrapper.eq(CouponInfoAll::getEmail, vo.getEmail());
                                }


                                if(vo.getIsUsed() != null){
                                    queryWrapper.eq(CouponInfoAll::getIsUsed, vo.getIsUsed());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(CouponInfoAll::getUsername, vo.getUsername());
                                }

                // CouponInfoAll entity = this.couponInfoAllService.getById(couponInfoId);
                    final Page<CouponInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    couponInfoAllService.pageNew(page, vo, queryWrapper);
                    final List<CouponInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public CouponInfoAll getById(Serializable couponInfoId) {

                    LambdaQueryWrapper<CouponInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(CouponInfoAll::getCouponInfoId, couponInfoId);

                    final Page<CouponInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    couponInfoAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<CouponInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
