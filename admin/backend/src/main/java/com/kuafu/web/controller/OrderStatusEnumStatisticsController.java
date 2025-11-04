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
import com.kuafu.web.entity.OrderStatusEnum;
import com.kuafu.web.service.IOrderStatusEnumStatisticsService;
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
@RequestMapping("/orderStatusEnumStatistics")

public class OrderStatusEnumStatisticsController  {

    private final IOrderStatusEnumStatisticsService orderStatusEnumStatisticsService;


    @PostMapping("order_status_enum_order_status_enum_id_status_statistic_9bc9ef17_count")
    public BaseResponse order_status_enum_order_status_enum_id_status_statistic_9bc9ef17_count(@RequestBody OrderStatusEnum statisticVo) {
        LambdaQueryWrapper<OrderStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderStatusEnumStatisticsService.order_status_enum_order_status_enum_id_status_statistic_9bc9ef17_count(queryWrapper));
    }
    @PostMapping("order_status_enum_order_status_enum_id_status_statistic_2bcfa4b6_count")
    public BaseResponse order_status_enum_order_status_enum_id_status_statistic_2bcfa4b6_count(@RequestBody OrderStatusEnum statisticVo) {
        LambdaQueryWrapper<OrderStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderStatusEnumStatisticsService.order_status_enum_order_status_enum_id_status_statistic_2bcfa4b6_count(queryWrapper));
    }
    @PostMapping("order_status_enum_order_status_enum_id_status_statistic_da23ad10_count")
    public BaseResponse order_status_enum_order_status_enum_id_status_statistic_da23ad10_count(@RequestBody OrderStatusEnum statisticVo) {
        LambdaQueryWrapper<OrderStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderStatusEnumStatisticsService.order_status_enum_order_status_enum_id_status_statistic_da23ad10_count(queryWrapper));
    }
    @PostMapping("order_status_enum_status_name_status_statistic_a8cf06c4_count")
    public BaseResponse order_status_enum_status_name_status_statistic_a8cf06c4_count(@RequestBody OrderStatusEnum statisticVo) {
        LambdaQueryWrapper<OrderStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderStatusEnumStatisticsService.order_status_enum_status_name_status_statistic_a8cf06c4_count(queryWrapper));
    }
    @PostMapping("order_status_enum_status_name_status_statistic_50ddd169_count")
    public BaseResponse order_status_enum_status_name_status_statistic_50ddd169_count(@RequestBody OrderStatusEnum statisticVo) {
        LambdaQueryWrapper<OrderStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderStatusEnumStatisticsService.order_status_enum_status_name_status_statistic_50ddd169_count(queryWrapper));
    }
    @PostMapping("order_status_enum_status_name_status_statistic_f7be0462_count")
    public BaseResponse order_status_enum_status_name_status_statistic_f7be0462_count(@RequestBody OrderStatusEnum statisticVo) {
        LambdaQueryWrapper<OrderStatusEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( orderStatusEnumStatisticsService.order_status_enum_status_name_status_statistic_f7be0462_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<OrderStatusEnum> queryWrapper, OrderStatusEnum statisticVo){
        if(StringUtils.isNotEmpty(statisticVo.getStatusName())) {
                        queryWrapper.like(OrderStatusEnum::getStatusName, statisticVo.getStatusName());
            }
    }



}
