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
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.service.IUserInfoStatisticsService;
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
@RequestMapping("/userInfoStatistics")

public class UserInfoStatisticsController  {

    private final IUserInfoStatisticsService userInfoStatisticsService;


    @PostMapping("user_info_statistic_b8e54625_count")
    public BaseResponse user_info_statistic_b8e54625_count(@RequestBody UserInfo statisticVo) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( userInfoStatisticsService.user_info_statistic_b8e54625_count(queryWrapper));
    }
    @PostMapping("user_info_statistic_d3ee33f0_count")
    public BaseResponse user_info_statistic_d3ee33f0_count(@RequestBody UserInfo statisticVo) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( userInfoStatisticsService.user_info_statistic_d3ee33f0_count(queryWrapper));
    }
    @PostMapping("user_info_statistic_d0fbf2c7_count")
    public BaseResponse user_info_statistic_d0fbf2c7_count(@RequestBody UserInfo statisticVo) {
        LambdaQueryWrapper<UserInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( userInfoStatisticsService.user_info_statistic_d0fbf2c7_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<UserInfo> queryWrapper, UserInfo statisticVo){
        if(StringUtils.isNotEmpty(statisticVo.getPhoneNumber())) {
                queryWrapper.eq(UserInfo::getPhoneNumber, statisticVo.getPhoneNumber());
            }
        if(StringUtils.isNotEmpty(statisticVo.getUsername())) {
                        queryWrapper.like(UserInfo::getUsername, statisticVo.getUsername());
            }
        if(StringUtils.isNotEmpty(statisticVo.getPassword())) {
                queryWrapper.eq(UserInfo::getPassword, statisticVo.getPassword());
            }
        if(StringUtils.isNotEmpty(statisticVo.getEmail())) {
                queryWrapper.eq(UserInfo::getEmail, statisticVo.getEmail());
            }
            if(statisticVo.getMemberLevelId() != null){
                queryWrapper.eq(UserInfo::getMemberLevelId, statisticVo.getMemberLevelId());
            }
        if(StringUtils.isNotEmpty(statisticVo.getAvatarResourceKey())) {
                queryWrapper.eq(UserInfo::getAvatarResourceKey, statisticVo.getAvatarResourceKey());
            }
    }



}
