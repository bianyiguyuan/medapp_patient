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
import com.kuafu.web.entity.OrderInfo;
import com.kuafu.web.service.IOrderInfoStatisticsService;
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
@RequestMapping("/orderInfoStatistics")

public class OrderInfoStatisticsController  {

    private final IOrderInfoStatisticsService orderInfoStatisticsService;


    @PostMapping("order_info_statistic_78be52de_count")
    public BaseResponse order_info_statistic_78be52de_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_78be52de_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_cac602ba_count")
    public BaseResponse order_info_statistic_cac602ba_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_cac602ba_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_c1f3da7b_count")
    public BaseResponse order_info_statistic_c1f3da7b_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_c1f3da7b_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_b678dff5_count")
    public BaseResponse order_info_statistic_b678dff5_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_b678dff5_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_13a72ffb_count")
    public BaseResponse order_info_statistic_13a72ffb_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_13a72ffb_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_2549672a_count")
    public BaseResponse order_info_statistic_2549672a_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_2549672a_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_47128f62_count")
    public BaseResponse order_info_statistic_47128f62_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_47128f62_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_9340d0f4_count")
    public BaseResponse order_info_statistic_9340d0f4_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_9340d0f4_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_55633d24_count")
    public BaseResponse order_info_statistic_55633d24_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_55633d24_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_ecbc57bf_count")
    public BaseResponse order_info_statistic_ecbc57bf_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_ecbc57bf_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_634a7ba6_count")
    public BaseResponse order_info_statistic_634a7ba6_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_634a7ba6_count(queryWrapper));
    }
    @PostMapping("order_info_statistic_03b9e7eb_count")
    public BaseResponse order_info_statistic_03b9e7eb_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_statistic_03b9e7eb_count(queryWrapper));
    }
    @PostMapping("order_info_order_status_enum_id_status_statistic_546711ee_count")
    public BaseResponse order_info_order_status_enum_id_status_statistic_546711ee_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_order_status_enum_id_status_statistic_546711ee_count(queryWrapper));
    }
    @PostMapping("order_info_order_status_enum_id_status_statistic_a3491f78_count")
    public BaseResponse order_info_order_status_enum_id_status_statistic_a3491f78_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_order_status_enum_id_status_statistic_a3491f78_count(queryWrapper));
    }
    @PostMapping("order_info_order_status_enum_id_status_statistic_43727b26_count")
    public BaseResponse order_info_order_status_enum_id_status_statistic_43727b26_count(@RequestBody OrderInfo statisticVo) {
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderInfoStatisticsService.order_info_order_status_enum_id_status_statistic_43727b26_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<OrderInfo> queryWrapper, OrderInfo statisticVo){
            if(statisticVo.getUserInfoUserInfoId5() != null){
                queryWrapper.eq(OrderInfo::getUserInfoUserInfoId5, statisticVo.getUserInfoUserInfoId5());
            }
            if(statisticVo.getProductInfoProductInfoId() != null){
                queryWrapper.eq(OrderInfo::getProductInfoProductInfoId, statisticVo.getProductInfoProductInfoId());
            }
            if(statisticVo.getQuantity() != null){
                queryWrapper.eq(OrderInfo::getQuantity, statisticVo.getQuantity());
            }
            if(statisticVo.getTotalPrice() != null){
                queryWrapper.eq(OrderInfo::getTotalPrice, statisticVo.getTotalPrice());
            }
            if(statisticVo.getOrderStatusEnumId() != null){
                queryWrapper.eq(OrderInfo::getOrderStatusEnumId, statisticVo.getOrderStatusEnumId());
            }
        if(StringUtils.isNotEmpty(statisticVo.getPaymentOrderNo())) {
                queryWrapper.eq(OrderInfo::getPaymentOrderNo, statisticVo.getPaymentOrderNo());
            }
    }



}
