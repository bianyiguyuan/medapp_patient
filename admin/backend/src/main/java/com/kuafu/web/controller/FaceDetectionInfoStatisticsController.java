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
import com.kuafu.web.entity.FaceDetectionInfo;
import com.kuafu.web.service.IFaceDetectionInfoStatisticsService;
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
@RequestMapping("/faceDetectionInfoStatistics")

public class FaceDetectionInfoStatisticsController  {

    private final IFaceDetectionInfoStatisticsService faceDetectionInfoStatisticsService;


    @PostMapping("face_detection_info_statistic_bd49b0c1_count")
    public BaseResponse face_detection_info_statistic_bd49b0c1_count(@RequestBody FaceDetectionInfo statisticVo) {
        LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( faceDetectionInfoStatisticsService.face_detection_info_statistic_bd49b0c1_count(queryWrapper));
    }
    @PostMapping("face_detection_info_statistic_bd9cef3c_count")
    public BaseResponse face_detection_info_statistic_bd9cef3c_count(@RequestBody FaceDetectionInfo statisticVo) {
        LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( faceDetectionInfoStatisticsService.face_detection_info_statistic_bd9cef3c_count(queryWrapper));
    }
    @PostMapping("face_detection_info_statistic_2006561b_count")
    public BaseResponse face_detection_info_statistic_2006561b_count(@RequestBody FaceDetectionInfo statisticVo) {
        LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( faceDetectionInfoStatisticsService.face_detection_info_statistic_2006561b_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<FaceDetectionInfo> queryWrapper, FaceDetectionInfo statisticVo){
            if(statisticVo.getUserInfoUserInfoId2() != null){
                queryWrapper.eq(FaceDetectionInfo::getUserInfoUserInfoId2, statisticVo.getUserInfoUserInfoId2());
            }
        if(StringUtils.isNotEmpty(statisticVo.getUploadImageResourceKey())) {
                queryWrapper.eq(FaceDetectionInfo::getUploadImageResourceKey, statisticVo.getUploadImageResourceKey());
            }
            if(statisticVo.getImpressionAge() != null){
                queryWrapper.eq(FaceDetectionInfo::getImpressionAge, statisticVo.getImpressionAge());
            }
        if(StringUtils.isNotEmpty(statisticVo.getAgingParts())) {
                queryWrapper.eq(FaceDetectionInfo::getAgingParts, statisticVo.getAgingParts());
            }
            if(statisticVo.getDeepAnalysisUnlocked() != null){
                queryWrapper.eq(FaceDetectionInfo::getDeepAnalysisUnlocked, statisticVo.getDeepAnalysisUnlocked());
            }
            if(statisticVo.getCustomPlanUnlocked() != null){
                queryWrapper.eq(FaceDetectionInfo::getCustomPlanUnlocked, statisticVo.getCustomPlanUnlocked());
            }
    }



}
