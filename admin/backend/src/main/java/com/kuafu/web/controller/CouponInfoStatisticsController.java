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
import com.kuafu.web.entity.CouponInfo;
import com.kuafu.web.service.ICouponInfoStatisticsService;
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
@RequestMapping("/couponInfoStatistics")

public class CouponInfoStatisticsController  {

    private final ICouponInfoStatisticsService couponInfoStatisticsService;


    @PostMapping("coupon_info_statistic_d903bc2c_count")
    public BaseResponse coupon_info_statistic_d903bc2c_count(@RequestBody CouponInfo statisticVo) {
        LambdaQueryWrapper<CouponInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( couponInfoStatisticsService.coupon_info_statistic_d903bc2c_count(queryWrapper));
    }
    @PostMapping("coupon_info_statistic_e2133559_count")
    public BaseResponse coupon_info_statistic_e2133559_count(@RequestBody CouponInfo statisticVo) {
        LambdaQueryWrapper<CouponInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( couponInfoStatisticsService.coupon_info_statistic_e2133559_count(queryWrapper));
    }
    @PostMapping("coupon_info_statistic_76e50a69_count")
    public BaseResponse coupon_info_statistic_76e50a69_count(@RequestBody CouponInfo statisticVo) {
        LambdaQueryWrapper<CouponInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( couponInfoStatisticsService.coupon_info_statistic_76e50a69_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<CouponInfo> queryWrapper, CouponInfo statisticVo){
            if(statisticVo.getUserInfoUserInfoId4() != null){
                queryWrapper.eq(CouponInfo::getUserInfoUserInfoId4, statisticVo.getUserInfoUserInfoId4());
            }
            if(statisticVo.getAmount() != null){
                queryWrapper.eq(CouponInfo::getAmount, statisticVo.getAmount());
            }
            if(statisticVo.getIsUsed() != null){
                queryWrapper.eq(CouponInfo::getIsUsed, statisticVo.getIsUsed());
            }
    }



}
