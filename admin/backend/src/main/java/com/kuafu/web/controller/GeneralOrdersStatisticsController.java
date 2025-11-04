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
import com.kuafu.web.entity.GeneralOrders;
import com.kuafu.web.service.IGeneralOrdersStatisticsService;
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
@RequestMapping("/generalOrdersStatistics")

public class GeneralOrdersStatisticsController  {

    private final IGeneralOrdersStatisticsService generalOrdersStatisticsService;


    @PostMapping("general_orders_order_status_status_statistic_3c2baf0b_count")
    public BaseResponse general_orders_order_status_status_statistic_3c2baf0b_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_order_status_status_statistic_3c2baf0b_count(queryWrapper));
    }
    @PostMapping("general_orders_order_status_status_statistic_b02c5267_count")
    public BaseResponse general_orders_order_status_status_statistic_b02c5267_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_order_status_status_statistic_b02c5267_count(queryWrapper));
    }
    @PostMapping("general_orders_order_status_status_statistic_97de812d_count")
    public BaseResponse general_orders_order_status_status_statistic_97de812d_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_order_status_status_statistic_97de812d_count(queryWrapper));
    }
    @PostMapping("general_orders_pay_status_status_statistic_11ed7b8b_count")
    public BaseResponse general_orders_pay_status_status_statistic_11ed7b8b_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_pay_status_status_statistic_11ed7b8b_count(queryWrapper));
    }
    @PostMapping("general_orders_pay_status_status_statistic_aa455c23_count")
    public BaseResponse general_orders_pay_status_status_statistic_aa455c23_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_pay_status_status_statistic_aa455c23_count(queryWrapper));
    }
    @PostMapping("general_orders_pay_status_status_statistic_d61bf563_count")
    public BaseResponse general_orders_pay_status_status_statistic_d61bf563_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_pay_status_status_statistic_d61bf563_count(queryWrapper));
    }
    @PostMapping("general_orders_delivery_status_status_statistic_b439ebb6_count")
    public BaseResponse general_orders_delivery_status_status_statistic_b439ebb6_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_delivery_status_status_statistic_b439ebb6_count(queryWrapper));
    }
    @PostMapping("general_orders_delivery_status_status_statistic_4f231347_count")
    public BaseResponse general_orders_delivery_status_status_statistic_4f231347_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_delivery_status_status_statistic_4f231347_count(queryWrapper));
    }
    @PostMapping("general_orders_delivery_status_status_statistic_abaf9427_count")
    public BaseResponse general_orders_delivery_status_status_statistic_abaf9427_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_delivery_status_status_statistic_abaf9427_count(queryWrapper));
    }
    @PostMapping("general_orders_payment_time_datetime_statistic_5bdc6c9a_count")
    public BaseResponse general_orders_payment_time_datetime_statistic_5bdc6c9a_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_payment_time_datetime_statistic_5bdc6c9a_count(queryWrapper));
    }
    @PostMapping("general_orders_payment_time_datetime_statistic_68854977_count")
    public BaseResponse general_orders_payment_time_datetime_statistic_68854977_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_payment_time_datetime_statistic_68854977_count(queryWrapper));
    }
    @PostMapping("general_orders_payment_time_datetime_statistic_f669d7fd_count")
    public BaseResponse general_orders_payment_time_datetime_statistic_f669d7fd_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_payment_time_datetime_statistic_f669d7fd_count(queryWrapper));
    }
    @PostMapping("general_orders_create_time_datetime_statistic_49245188_count")
    public BaseResponse general_orders_create_time_datetime_statistic_49245188_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_create_time_datetime_statistic_49245188_count(queryWrapper));
    }
    @PostMapping("general_orders_create_time_datetime_statistic_5a64018c_count")
    public BaseResponse general_orders_create_time_datetime_statistic_5a64018c_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_create_time_datetime_statistic_5a64018c_count(queryWrapper));
    }
    @PostMapping("general_orders_create_time_datetime_statistic_3c178831_count")
    public BaseResponse general_orders_create_time_datetime_statistic_3c178831_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_create_time_datetime_statistic_3c178831_count(queryWrapper));
    }
    @PostMapping("general_orders_update_time_datetime_statistic_cf60f828_count")
    public BaseResponse general_orders_update_time_datetime_statistic_cf60f828_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_update_time_datetime_statistic_cf60f828_count(queryWrapper));
    }
    @PostMapping("general_orders_update_time_datetime_statistic_56123fa7_count")
    public BaseResponse general_orders_update_time_datetime_statistic_56123fa7_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_update_time_datetime_statistic_56123fa7_count(queryWrapper));
    }
    @PostMapping("general_orders_update_time_datetime_statistic_3abbe917_count")
    public BaseResponse general_orders_update_time_datetime_statistic_3abbe917_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_update_time_datetime_statistic_3abbe917_count(queryWrapper));
    }
    @PostMapping("general_orders_cancel_time_datetime_statistic_e3d18a44_count")
    public BaseResponse general_orders_cancel_time_datetime_statistic_e3d18a44_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_cancel_time_datetime_statistic_e3d18a44_count(queryWrapper));
    }
    @PostMapping("general_orders_cancel_time_datetime_statistic_39eff77a_count")
    public BaseResponse general_orders_cancel_time_datetime_statistic_39eff77a_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_cancel_time_datetime_statistic_39eff77a_count(queryWrapper));
    }
    @PostMapping("general_orders_cancel_time_datetime_statistic_1cd9fc53_count")
    public BaseResponse general_orders_cancel_time_datetime_statistic_1cd9fc53_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_cancel_time_datetime_statistic_1cd9fc53_count(queryWrapper));
    }
    @PostMapping("general_orders_complete_time_datetime_statistic_1c4c5d69_count")
    public BaseResponse general_orders_complete_time_datetime_statistic_1c4c5d69_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_complete_time_datetime_statistic_1c4c5d69_count(queryWrapper));
    }
    @PostMapping("general_orders_complete_time_datetime_statistic_26b52752_count")
    public BaseResponse general_orders_complete_time_datetime_statistic_26b52752_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_complete_time_datetime_statistic_26b52752_count(queryWrapper));
    }
    @PostMapping("general_orders_complete_time_datetime_statistic_3b7ddf49_count")
    public BaseResponse general_orders_complete_time_datetime_statistic_3b7ddf49_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_complete_time_datetime_statistic_3b7ddf49_count(queryWrapper));
    }
    @PostMapping("general_orders_deliver_time_datetime_statistic_56a27fe9_count")
    public BaseResponse general_orders_deliver_time_datetime_statistic_56a27fe9_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_deliver_time_datetime_statistic_56a27fe9_count(queryWrapper));
    }
    @PostMapping("general_orders_deliver_time_datetime_statistic_7d95dc04_count")
    public BaseResponse general_orders_deliver_time_datetime_statistic_7d95dc04_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_deliver_time_datetime_statistic_7d95dc04_count(queryWrapper));
    }
    @PostMapping("general_orders_deliver_time_datetime_statistic_eee9ace7_count")
    public BaseResponse general_orders_deliver_time_datetime_statistic_eee9ace7_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_deliver_time_datetime_statistic_eee9ace7_count(queryWrapper));
    }
    @PostMapping("general_orders_refund_status_status_statistic_be66fbf1_count")
    public BaseResponse general_orders_refund_status_status_statistic_be66fbf1_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_refund_status_status_statistic_be66fbf1_count(queryWrapper));
    }
    @PostMapping("general_orders_refund_status_status_statistic_61064702_count")
    public BaseResponse general_orders_refund_status_status_statistic_61064702_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_refund_status_status_statistic_61064702_count(queryWrapper));
    }
    @PostMapping("general_orders_refund_status_status_statistic_104a645e_count")
    public BaseResponse general_orders_refund_status_status_statistic_104a645e_count(@RequestBody GeneralOrders statisticVo) {
        LambdaQueryWrapper<GeneralOrders> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( generalOrdersStatisticsService.general_orders_refund_status_status_statistic_104a645e_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<GeneralOrders> queryWrapper, GeneralOrders statisticVo){
        if(StringUtils.isNotEmpty(statisticVo.getOrderNo())) {
                queryWrapper.eq(GeneralOrders::getOrderNo, statisticVo.getOrderNo());
            }
            if(statisticVo.getUserId() != null){
                queryWrapper.eq(GeneralOrders::getUserId, statisticVo.getUserId());
            }
        if(StringUtils.isNotEmpty(statisticVo.getOpId())) {
                queryWrapper.eq(GeneralOrders::getOpId, statisticVo.getOpId());
            }
        if(StringUtils.isNotEmpty(statisticVo.getOrderType())) {
                queryWrapper.eq(GeneralOrders::getOrderType, statisticVo.getOrderType());
            }
        if(StringUtils.isNotEmpty(statisticVo.getOrderStatus())) {
                queryWrapper.eq(GeneralOrders::getOrderStatus, statisticVo.getOrderStatus());
            }
        if(StringUtils.isNotEmpty(statisticVo.getPayStatus())) {
                queryWrapper.eq(GeneralOrders::getPayStatus, statisticVo.getPayStatus());
            }
        if(StringUtils.isNotEmpty(statisticVo.getDeliveryStatus())) {
                queryWrapper.eq(GeneralOrders::getDeliveryStatus, statisticVo.getDeliveryStatus());
            }
            if(statisticVo.getProductsId() != null){
                queryWrapper.eq(GeneralOrders::getProductsId, statisticVo.getProductsId());
            }
            if(statisticVo.getQuality() != null){
                queryWrapper.eq(GeneralOrders::getQuality, statisticVo.getQuality());
            }
            if(statisticVo.getTotalAmount() != null){
                queryWrapper.eq(GeneralOrders::getTotalAmount, statisticVo.getTotalAmount());
            }
            if(statisticVo.getDiscountAmount() != null){
                queryWrapper.eq(GeneralOrders::getDiscountAmount, statisticVo.getDiscountAmount());
            }
            if(statisticVo.getShippingFee() != null){
                queryWrapper.eq(GeneralOrders::getShippingFee, statisticVo.getShippingFee());
            }
            if(statisticVo.getActualAmount() != null){
                queryWrapper.eq(GeneralOrders::getActualAmount, statisticVo.getActualAmount());
            }
        if(StringUtils.isNotEmpty(statisticVo.getPaymentChannel())) {
                queryWrapper.eq(GeneralOrders::getPaymentChannel, statisticVo.getPaymentChannel());
            }
        if(StringUtils.isNotEmpty(statisticVo.getPaymentOrderId())) {
                queryWrapper.eq(GeneralOrders::getPaymentOrderId, statisticVo.getPaymentOrderId());
            }
            if(statisticVo.getPaymentTime() != null){
                queryWrapper.eq(GeneralOrders::getPaymentTime, statisticVo.getPaymentTime());
            }
            if(statisticVo.getPaymentAmount() != null){
                queryWrapper.eq(GeneralOrders::getPaymentAmount, statisticVo.getPaymentAmount());
            }
        if(StringUtils.isNotEmpty(statisticVo.getShippingMethod())) {
                queryWrapper.eq(GeneralOrders::getShippingMethod, statisticVo.getShippingMethod());
            }
        if(StringUtils.isNotEmpty(statisticVo.getShippingAddress())) {
                queryWrapper.eq(GeneralOrders::getShippingAddress, statisticVo.getShippingAddress());
            }
        if(StringUtils.isNotEmpty(statisticVo.getShippingCompany())) {
                queryWrapper.eq(GeneralOrders::getShippingCompany, statisticVo.getShippingCompany());
            }
        if(StringUtils.isNotEmpty(statisticVo.getTrackingNumber())) {
                queryWrapper.eq(GeneralOrders::getTrackingNumber, statisticVo.getTrackingNumber());
            }
        if(StringUtils.isNotEmpty(statisticVo.getTel())) {
                queryWrapper.eq(GeneralOrders::getTel, statisticVo.getTel());
            }
        if(StringUtils.isNotEmpty(statisticVo.getRecipient())) {
                queryWrapper.eq(GeneralOrders::getRecipient, statisticVo.getRecipient());
            }
            if(statisticVo.getCreateTime() != null){
                queryWrapper.eq(GeneralOrders::getCreateTime, statisticVo.getCreateTime());
            }
            if(statisticVo.getUpdateTime() != null){
                queryWrapper.eq(GeneralOrders::getUpdateTime, statisticVo.getUpdateTime());
            }
            if(statisticVo.getCancelTime() != null){
                queryWrapper.eq(GeneralOrders::getCancelTime, statisticVo.getCancelTime());
            }
            if(statisticVo.getCompleteTime() != null){
                queryWrapper.eq(GeneralOrders::getCompleteTime, statisticVo.getCompleteTime());
            }
            if(statisticVo.getDeliverTime() != null){
                queryWrapper.eq(GeneralOrders::getDeliverTime, statisticVo.getDeliverTime());
            }
        if(StringUtils.isNotEmpty(statisticVo.getRefundId())) {
                queryWrapper.eq(GeneralOrders::getRefundId, statisticVo.getRefundId());
            }
        if(StringUtils.isNotEmpty(statisticVo.getRefundNo())) {
                queryWrapper.eq(GeneralOrders::getRefundNo, statisticVo.getRefundNo());
            }
        if(StringUtils.isNotEmpty(statisticVo.getRefundType())) {
                queryWrapper.eq(GeneralOrders::getRefundType, statisticVo.getRefundType());
            }
            if(statisticVo.getRefundAmount() != null){
                queryWrapper.eq(GeneralOrders::getRefundAmount, statisticVo.getRefundAmount());
            }
        if(StringUtils.isNotEmpty(statisticVo.getRefundReason())) {
                queryWrapper.eq(GeneralOrders::getRefundReason, statisticVo.getRefundReason());
            }
        if(StringUtils.isNotEmpty(statisticVo.getRefundStatus())) {
                queryWrapper.eq(GeneralOrders::getRefundStatus, statisticVo.getRefundStatus());
            }
        if(StringUtils.isNotEmpty(statisticVo.getRemark())) {
                queryWrapper.eq(GeneralOrders::getRemark, statisticVo.getRemark());
            }
            if(statisticVo.getIsDeleted() != null){
                queryWrapper.eq(GeneralOrders::getIsDeleted, statisticVo.getIsDeleted());
            }
        if(StringUtils.isNotEmpty(statisticVo.getTableName())) {
                        queryWrapper.like(GeneralOrders::getTableName, statisticVo.getTableName());
            }
        if(StringUtils.isNotEmpty(statisticVo.getFieldName())) {
                        queryWrapper.like(GeneralOrders::getFieldName, statisticVo.getFieldName());
            }
    }



}
