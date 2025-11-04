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
import com.kuafu.web.entity.FaceDetectionInfoAll;
import com.kuafu.web.service.IFaceDetectionInfoAllService;
import com.kuafu.web.vo.FaceDetectionInfoAllPageVO;

import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;


/**
 * <p> 人脸检测信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/faceDetectionInfoAll")
@Api(tags = {"人脸检测信息"})
public class FaceDetectionInfoAllController  {

    private final IFaceDetectionInfoAllService faceDetectionInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody FaceDetectionInfoAllPageVO pageVO){
        IPage<FaceDetectionInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getUserInfoUserInfoId2() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getUserInfoUserInfoId2, pageVO.getUserInfoUserInfoId2());
        }
            if(pageVO.getDeepAnalysisUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getDeepAnalysisUnlocked, pageVO.getDeepAnalysisUnlocked());
        }
        if(StringUtils.isNotEmpty(pageVO.getAgingParts())) {
            queryWrapper.eq(FaceDetectionInfoAll::getAgingParts, pageVO.getAgingParts());
        }
            if(pageVO.getImpressionAge() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getImpressionAge, pageVO.getImpressionAge());
        }
        if(StringUtils.isNotEmpty(pageVO.getUploadImageResourceKey())) {
            queryWrapper.eq(FaceDetectionInfoAll::getUploadImageResourceKey, pageVO.getUploadImageResourceKey());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(FaceDetectionInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
            if(pageVO.getMemberLevelId() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
        }
        if(StringUtils.isNotEmpty(pageVO.getAvatarResourceKey())) {
            queryWrapper.eq(FaceDetectionInfoAll::getAvatarResourceKey, pageVO.getAvatarResourceKey());
        }
            if(pageVO.getCustomPlanUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getCustomPlanUnlocked, pageVO.getCustomPlanUnlocked());
        }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
            queryWrapper.eq(FaceDetectionInfoAll::getPassword, pageVO.getPassword());
        }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
            queryWrapper.eq(FaceDetectionInfoAll::getEmail, pageVO.getEmail());
        }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {
            queryWrapper.like(FaceDetectionInfoAll::getUsername, pageVO.getUsername());
        }
        return ResultUtils.success(faceDetectionInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody FaceDetectionInfoAllPageVO vo){
        LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId2() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getUserInfoUserInfoId2, vo.getUserInfoUserInfoId2());
        }
                if(vo.getDeepAnalysisUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getDeepAnalysisUnlocked, vo.getDeepAnalysisUnlocked());
        }
            if(StringUtils.isNotEmpty(vo.getAgingParts())) {
            queryWrapper.eq(FaceDetectionInfoAll::getAgingParts, vo.getAgingParts());
        }
                if(vo.getImpressionAge() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getImpressionAge, vo.getImpressionAge());
        }
            if(StringUtils.isNotEmpty(vo.getUploadImageResourceKey())) {
            queryWrapper.eq(FaceDetectionInfoAll::getUploadImageResourceKey, vo.getUploadImageResourceKey());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(FaceDetectionInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
                if(vo.getMemberLevelId() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getMemberLevelId, vo.getMemberLevelId());
        }
            if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
            queryWrapper.eq(FaceDetectionInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
        }
                if(vo.getCustomPlanUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfoAll::getCustomPlanUnlocked, vo.getCustomPlanUnlocked());
        }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
            queryWrapper.eq(FaceDetectionInfoAll::getPassword, vo.getPassword());
        }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
            queryWrapper.eq(FaceDetectionInfoAll::getEmail, vo.getEmail());
        }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
            queryWrapper.like(FaceDetectionInfoAll::getUsername, vo.getUsername());
        }
        return ResultUtils.success(faceDetectionInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer faceDetectionInfoId) {
        FaceDetectionInfoAll entity = this.faceDetectionInfoAllService.getById(faceDetectionInfoId);
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


        /**
         * 导出excel
         */
        @PostMapping("/export")
        public void export(HttpServletResponse response, @RequestBody FaceDetectionInfoAllPageVO vo) {

            LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                    if(vo.getUserInfoUserInfoId2() != null){
                        queryWrapper.eq(FaceDetectionInfoAll::getUserInfoUserInfoId2, vo.getUserInfoUserInfoId2());
                    }
                    if(vo.getDeepAnalysisUnlocked() != null){
                        queryWrapper.eq(FaceDetectionInfoAll::getDeepAnalysisUnlocked, vo.getDeepAnalysisUnlocked());
                    }
                if(StringUtils.isNotEmpty(vo.getAgingParts())) {
                        queryWrapper.eq(FaceDetectionInfoAll::getAgingParts, vo.getAgingParts());
                    }
                    if(vo.getImpressionAge() != null){
                        queryWrapper.eq(FaceDetectionInfoAll::getImpressionAge, vo.getImpressionAge());
                    }
                if(StringUtils.isNotEmpty(vo.getUploadImageResourceKey())) {
                        queryWrapper.eq(FaceDetectionInfoAll::getUploadImageResourceKey, vo.getUploadImageResourceKey());
                    }
                if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                        queryWrapper.eq(FaceDetectionInfoAll::getPhoneNumber, vo.getPhoneNumber());
                    }
                    if(vo.getMemberLevelId() != null){
                        queryWrapper.eq(FaceDetectionInfoAll::getMemberLevelId, vo.getMemberLevelId());
                    }
                if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
                        queryWrapper.eq(FaceDetectionInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
                    }
                    if(vo.getCustomPlanUnlocked() != null){
                        queryWrapper.eq(FaceDetectionInfoAll::getCustomPlanUnlocked, vo.getCustomPlanUnlocked());
                    }
                if(StringUtils.isNotEmpty(vo.getPassword())) {
                        queryWrapper.eq(FaceDetectionInfoAll::getPassword, vo.getPassword());
                    }
                if(StringUtils.isNotEmpty(vo.getEmail())) {
                        queryWrapper.eq(FaceDetectionInfoAll::getEmail, vo.getEmail());
                    }
                if(StringUtils.isNotEmpty(vo.getUsername())) {
                                queryWrapper.like(FaceDetectionInfoAll::getUsername, vo.getUsername());
                    }
            List<FaceDetectionInfoAll> list = faceDetectionInfoAllService.list(queryWrapper);
            ExcelUtil<FaceDetectionInfoAll> util = new ExcelUtil<>(FaceDetectionInfoAll.class);
            util.exportExcel(response, list, "数据");
        }


}
