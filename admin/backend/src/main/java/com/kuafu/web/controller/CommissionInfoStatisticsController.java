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
import com.kuafu.web.entity.CommissionInfo;
import com.kuafu.web.service.ICommissionInfoStatisticsService;
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
@RequestMapping("/commissionInfoStatistics")

public class CommissionInfoStatisticsController  {

    private final ICommissionInfoStatisticsService commissionInfoStatisticsService;


    @PostMapping("commission_info_statistic_2eb6e6e9_count")
    public BaseResponse commission_info_statistic_2eb6e6e9_count(@RequestBody CommissionInfo statisticVo) {
        LambdaQueryWrapper<CommissionInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( commissionInfoStatisticsService.commission_info_statistic_2eb6e6e9_count(queryWrapper));
    }
    @PostMapping("commission_info_statistic_715fc2a4_count")
    public BaseResponse commission_info_statistic_715fc2a4_count(@RequestBody CommissionInfo statisticVo) {
        LambdaQueryWrapper<CommissionInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( commissionInfoStatisticsService.commission_info_statistic_715fc2a4_count(queryWrapper));
    }
    @PostMapping("commission_info_statistic_12ffaa16_count")
    public BaseResponse commission_info_statistic_12ffaa16_count(@RequestBody CommissionInfo statisticVo) {
        LambdaQueryWrapper<CommissionInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( commissionInfoStatisticsService.commission_info_statistic_12ffaa16_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<CommissionInfo> queryWrapper, CommissionInfo statisticVo){
            if(statisticVo.getUserInfoUserInfoId3() != null){
                queryWrapper.eq(CommissionInfo::getUserInfoUserInfoId3, statisticVo.getUserInfoUserInfoId3());
            }
            if(statisticVo.getCommissionRatio() != null){
                queryWrapper.eq(CommissionInfo::getCommissionRatio, statisticVo.getCommissionRatio());
            }
            if(statisticVo.getTotalEarnings() != null){
                queryWrapper.eq(CommissionInfo::getTotalEarnings, statisticVo.getTotalEarnings());
            }
    }



}
