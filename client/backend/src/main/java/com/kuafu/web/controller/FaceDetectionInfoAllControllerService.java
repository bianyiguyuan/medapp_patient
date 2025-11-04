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
import com.kuafu.web.entity.FaceDetectionInfoAll;
import com.kuafu.web.service.IFaceDetectionInfoAllService;
import com.kuafu.web.vo.FaceDetectionInfoAllPageVO;
import com.kuafu.web.entity.SelectVo;
import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.entity.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kuafu.common.util.QueryUtils;
import org.springframework.context.annotation.Lazy;





/**
 * <p> 人脸检测信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("FaceDetectionInfoAllControllerService")
public class FaceDetectionInfoAllControllerService implements IControllerService<FaceDetectionInfoAll> {


@Autowired
    private  IFaceDetectionInfoAllService faceDetectionInfoAllService;




@Autowired
@Lazy
    private  UserInfoAllControllerService UserInfoAllControllerService;




    public BaseResponse page( FaceDetectionInfoAllPageVO pageVO){
        IPage<FaceDetectionInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

        final QueryWrapper<FaceDetectionInfoAll> objectQueryWrapper = new QueryWrapper<>();
        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        objectQueryWrapper.orderByDesc("fdi.face_detection_info_id");
        LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper = objectQueryWrapper.lambda();


        if(StringUtils.isNotEmpty(pageVO.getAgingParts())) {
                queryWrapper.like(FaceDetectionInfoAll::getAgingParts, pageVO.getAgingParts());
            }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
                queryWrapper.like(FaceDetectionInfoAll::getPassword, pageVO.getPassword());
            }
            if(pageVO.getMemberLevelId() != null){
                queryWrapper.eq(FaceDetectionInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
            }
            if(pageVO.getDeepAnalysisUnlocked() != null){
                queryWrapper.eq(FaceDetectionInfoAll::getDeepAnalysisUnlocked, pageVO.getDeepAnalysisUnlocked());
            }
            if(pageVO.getCustomPlanUnlocked() != null){
                queryWrapper.eq(FaceDetectionInfoAll::getCustomPlanUnlocked, pageVO.getCustomPlanUnlocked());
            }
            if(pageVO.getImpressionAge() != null){
                queryWrapper.eq(FaceDetectionInfoAll::getImpressionAge, pageVO.getImpressionAge());
            }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
                queryWrapper.like(FaceDetectionInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
            }
            if(pageVO.getUserInfoUserInfoId2() != null){
                queryWrapper.eq(FaceDetectionInfoAll::getUserInfoUserInfoId2, pageVO.getUserInfoUserInfoId2());
            }
            if(pageVO.getFaceDetectionInfoId() != null){
                queryWrapper.eq(FaceDetectionInfoAll::getFaceDetectionInfoId, pageVO.getFaceDetectionInfoId());
            }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
                queryWrapper.like(FaceDetectionInfoAll::getEmail, pageVO.getEmail());
            }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {

                        String s_string = pageVO.getUsername();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(FaceDetectionInfoAll::getUsername, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }

                    faceDetectionInfoAllService.pageNew(page, pageVO, queryWrapper);
                    page.getRecords().forEach(item -> {
                    });

        page.getRecords().forEach(item -> {
                        if(item.getUserInfoUserInfoId2() != null){
                            item.setAvatar(UserInfoAllControllerService.getById(item.getUserInfoUserInfoId2()).getAvatar());
                        }
        });


            return ResultUtils.success(page);
        }

        public BaseResponse list(FaceDetectionInfoAllPageVO vo){
            LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getAgingParts())) {
                    queryWrapper.eq(FaceDetectionInfoAll::getAgingParts, vo.getAgingParts());
                }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
                    queryWrapper.eq(FaceDetectionInfoAll::getPassword, vo.getPassword());
                }
                if(vo.getMemberLevelId() != null){
                    queryWrapper.eq(FaceDetectionInfoAll::getMemberLevelId, vo.getMemberLevelId());
                }
                if(vo.getDeepAnalysisUnlocked() != null){
                    queryWrapper.eq(FaceDetectionInfoAll::getDeepAnalysisUnlocked, vo.getDeepAnalysisUnlocked());
                }
                if(vo.getCustomPlanUnlocked() != null){
                    queryWrapper.eq(FaceDetectionInfoAll::getCustomPlanUnlocked, vo.getCustomPlanUnlocked());
                }
                if(vo.getImpressionAge() != null){
                    queryWrapper.eq(FaceDetectionInfoAll::getImpressionAge, vo.getImpressionAge());
                }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                    queryWrapper.eq(FaceDetectionInfoAll::getPhoneNumber, vo.getPhoneNumber());
                }
                if(vo.getUserInfoUserInfoId2() != null){
                    queryWrapper.eq(FaceDetectionInfoAll::getUserInfoUserInfoId2, vo.getUserInfoUserInfoId2());
                }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
                    queryWrapper.eq(FaceDetectionInfoAll::getEmail, vo.getEmail());
                }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
                            queryWrapper.like(FaceDetectionInfoAll::getUsername, vo.getUsername());
                }
                return ResultUtils.success(faceDetectionInfoAllService.selectListNew(new PageRequest(),queryWrapper,false));
            }


            public BaseResponse get(FaceDetectionInfoAllPageVO vo) {


                LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper = new LambdaQueryWrapper<>();


                            if(StringUtils.isNotEmpty(vo.getAgingParts())) {
                                    queryWrapper.eq(FaceDetectionInfoAll::getAgingParts, vo.getAgingParts());
                                }


                            if(StringUtils.isNotEmpty(vo.getPassword())) {
                                    queryWrapper.eq(FaceDetectionInfoAll::getPassword, vo.getPassword());
                                }


                                if(vo.getMemberLevelId() != null){
                                    queryWrapper.eq(FaceDetectionInfoAll::getMemberLevelId, vo.getMemberLevelId());
                                }


                                if(vo.getDeepAnalysisUnlocked() != null){
                                    queryWrapper.eq(FaceDetectionInfoAll::getDeepAnalysisUnlocked, vo.getDeepAnalysisUnlocked());
                                }


                                if(vo.getCustomPlanUnlocked() != null){
                                    queryWrapper.eq(FaceDetectionInfoAll::getCustomPlanUnlocked, vo.getCustomPlanUnlocked());
                                }


                                if(vo.getImpressionAge() != null){
                                    queryWrapper.eq(FaceDetectionInfoAll::getImpressionAge, vo.getImpressionAge());
                                }


                            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                                    queryWrapper.eq(FaceDetectionInfoAll::getPhoneNumber, vo.getPhoneNumber());
                                }


                                if(vo.getUserInfoUserInfoId2() != null){
                                    queryWrapper.eq(FaceDetectionInfoAll::getUserInfoUserInfoId2, vo.getUserInfoUserInfoId2());
                                }


                                if(vo.getFaceDetectionInfoId() != null){
                                    queryWrapper.eq(FaceDetectionInfoAll::getFaceDetectionInfoId, vo.getFaceDetectionInfoId());
                                }


                            if(StringUtils.isNotEmpty(vo.getEmail())) {
                                    queryWrapper.eq(FaceDetectionInfoAll::getEmail, vo.getEmail());
                                }


                            if(StringUtils.isNotEmpty(vo.getUsername())) {
                                            queryWrapper.like(FaceDetectionInfoAll::getUsername, vo.getUsername());
                                }

                // FaceDetectionInfoAll entity = this.faceDetectionInfoAllService.getById(faceDetectionInfoId);
                    final Page<FaceDetectionInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    faceDetectionInfoAllService.pageNew(page, vo, queryWrapper);
                    final List<FaceDetectionInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? ResultUtils.success(records.get(0)) : ResultUtils.error(ErrorCode.OPERATION_ERROR);

                    // return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

            public FaceDetectionInfoAll getById(Serializable faceDetectionInfoId) {

                    LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                            queryWrapper.eq(FaceDetectionInfoAll::getFaceDetectionInfoId, faceDetectionInfoId);

                    final Page<FaceDetectionInfoAll> page = new Page<>();
                    page.setCurrent(1);
                    page.setSize(1);
                    faceDetectionInfoAllService.pageNew(page, new PageRequest() , queryWrapper);
                    final List<FaceDetectionInfoAll> records = page.getRecords();
                    return ObjectUtils.isNotEmpty(records) ? records.get(0) : null;

            }


        }
