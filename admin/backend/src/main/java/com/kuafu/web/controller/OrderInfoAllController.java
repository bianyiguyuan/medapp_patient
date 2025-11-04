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
import com.kuafu.web.entity.OrderInfoAll;
import com.kuafu.web.service.IOrderInfoAllService;
import com.kuafu.web.vo.OrderInfoAllPageVO;

import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;
import com.kuafu.web.service.IProductInfoService;
import com.kuafu.web.entity.ProductInfo;
import com.kuafu.web.service.IOrderStatusEnumService;
import com.kuafu.web.entity.OrderStatusEnum;
import com.kuafu.web.service.IGeneralOrdersService;
import com.kuafu.web.entity.GeneralOrders;


/**
 * <p> 订单信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/orderInfoAll")
@Api(tags = {"订单信息"})
public class OrderInfoAllController  {

    private final IOrderInfoAllService orderInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody OrderInfoAllPageVO pageVO){
        IPage<OrderInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<OrderInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getProductsId() != null){
            queryWrapper.eq(OrderInfoAll::getProductsId, pageVO.getProductsId());
        }
        if(StringUtils.isNotEmpty(pageVO.getOrderNo())) {
            queryWrapper.eq(OrderInfoAll::getOrderNo, pageVO.getOrderNo());
        }
        if(StringUtils.isNotEmpty(pageVO.getOrderStatus())) {
            queryWrapper.eq(OrderInfoAll::getOrderStatus, pageVO.getOrderStatus());
        }
        if(StringUtils.isNotEmpty(pageVO.getOpId())) {
            queryWrapper.eq(OrderInfoAll::getOpId, pageVO.getOpId());
        }
            if(pageVO.getMemberLevelId() != null){
            queryWrapper.eq(OrderInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
        }
        if(StringUtils.isNotEmpty(pageVO.getAvatarResourceKey())) {
            queryWrapper.eq(OrderInfoAll::getAvatarResourceKey, pageVO.getAvatarResourceKey());
        }
            if(pageVO.getUserId() != null){
            queryWrapper.eq(OrderInfoAll::getUserId, pageVO.getUserId());
        }
            if(pageVO.getDeliverTime() != null){
            queryWrapper.eq(OrderInfoAll::getDeliverTime, pageVO.getDeliverTime());
        }
            if(pageVO.getIsDeleted() != null){
            queryWrapper.eq(OrderInfoAll::getIsDeleted, pageVO.getIsDeleted());
        }
            if(pageVO.getPaymentAmount() != null){
            queryWrapper.eq(OrderInfoAll::getPaymentAmount, pageVO.getPaymentAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
            queryWrapper.eq(OrderInfoAll::getPassword, pageVO.getPassword());
        }
            if(pageVO.getPrice() != null){
            queryWrapper.eq(OrderInfoAll::getPrice, pageVO.getPrice());
        }
            if(pageVO.getCompleteTime() != null){
            queryWrapper.eq(OrderInfoAll::getCompleteTime, pageVO.getCompleteTime());
        }
            if(pageVO.getActualAmount() != null){
            queryWrapper.eq(OrderInfoAll::getActualAmount, pageVO.getActualAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getTel())) {
            queryWrapper.eq(OrderInfoAll::getTel, pageVO.getTel());
        }
            if(pageVO.getRefundAmount() != null){
            queryWrapper.eq(OrderInfoAll::getRefundAmount, pageVO.getRefundAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getRefundType())) {
            queryWrapper.eq(OrderInfoAll::getRefundType, pageVO.getRefundType());
        }
        if(StringUtils.isNotEmpty(pageVO.getMiniProgramPath())) {
            queryWrapper.eq(OrderInfoAll::getMiniProgramPath, pageVO.getMiniProgramPath());
        }
        if(StringUtils.isNotEmpty(pageVO.getStatusName())) {
            queryWrapper.like(OrderInfoAll::getStatusName, pageVO.getStatusName());
        }
        if(StringUtils.isNotEmpty(pageVO.getShippingMethod())) {
            queryWrapper.eq(OrderInfoAll::getShippingMethod, pageVO.getShippingMethod());
        }
            if(pageVO.getQuality() != null){
            queryWrapper.eq(OrderInfoAll::getQuality, pageVO.getQuality());
        }
        if(StringUtils.isNotEmpty(pageVO.getPaymentOrderNo())) {
            queryWrapper.eq(OrderInfoAll::getPaymentOrderNo, pageVO.getPaymentOrderNo());
        }
            if(pageVO.getTotalAmount() != null){
            queryWrapper.eq(OrderInfoAll::getTotalAmount, pageVO.getTotalAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getRefundStatus())) {
            queryWrapper.eq(OrderInfoAll::getRefundStatus, pageVO.getRefundStatus());
        }
        if(StringUtils.isNotEmpty(pageVO.getDeliveryStatus())) {
            queryWrapper.eq(OrderInfoAll::getDeliveryStatus, pageVO.getDeliveryStatus());
        }
            if(pageVO.getProductInfoProductInfoId() != null){
            queryWrapper.eq(OrderInfoAll::getProductInfoProductInfoId, pageVO.getProductInfoProductInfoId());
        }
        if(StringUtils.isNotEmpty(pageVO.getOrderType())) {
            queryWrapper.eq(OrderInfoAll::getOrderType, pageVO.getOrderType());
        }
        if(StringUtils.isNotEmpty(pageVO.getPaymentChannel())) {
            queryWrapper.eq(OrderInfoAll::getPaymentChannel, pageVO.getPaymentChannel());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(OrderInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
        if(StringUtils.isNotEmpty(pageVO.getRemark())) {
            queryWrapper.eq(OrderInfoAll::getRemark, pageVO.getRemark());
        }
            if(pageVO.getShippingFee() != null){
            queryWrapper.eq(OrderInfoAll::getShippingFee, pageVO.getShippingFee());
        }
            if(pageVO.getDiscountAmount() != null){
            queryWrapper.eq(OrderInfoAll::getDiscountAmount, pageVO.getDiscountAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getPaymentOrderId())) {
            queryWrapper.eq(OrderInfoAll::getPaymentOrderId, pageVO.getPaymentOrderId());
        }
        if(StringUtils.isNotEmpty(pageVO.getTrackingNumber())) {
            queryWrapper.eq(OrderInfoAll::getTrackingNumber, pageVO.getTrackingNumber());
        }
        if(StringUtils.isNotEmpty(pageVO.getProductName())) {
            queryWrapper.like(OrderInfoAll::getProductName, pageVO.getProductName());
        }
            if(pageVO.getCouponAmount() != null){
            queryWrapper.eq(OrderInfoAll::getCouponAmount, pageVO.getCouponAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getTableName())) {
            queryWrapper.like(OrderInfoAll::getTableName, pageVO.getTableName());
        }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
            queryWrapper.eq(OrderInfoAll::getEmail, pageVO.getEmail());
        }
        if(StringUtils.isNotEmpty(pageVO.getRefundId())) {
            queryWrapper.eq(OrderInfoAll::getRefundId, pageVO.getRefundId());
        }
        if(StringUtils.isNotEmpty(pageVO.getShippingAddress())) {
            queryWrapper.eq(OrderInfoAll::getShippingAddress, pageVO.getShippingAddress());
        }
            if(pageVO.getCreateTime() != null){
            queryWrapper.eq(OrderInfoAll::getCreateTime, pageVO.getCreateTime());
        }
            if(pageVO.getQuantity() != null){
            queryWrapper.eq(OrderInfoAll::getQuantity, pageVO.getQuantity());
        }
            if(pageVO.getTotalPrice() != null){
            queryWrapper.eq(OrderInfoAll::getTotalPrice, pageVO.getTotalPrice());
        }
            if(pageVO.getCancelTime() != null){
            queryWrapper.eq(OrderInfoAll::getCancelTime, pageVO.getCancelTime());
        }
        if(StringUtils.isNotEmpty(pageVO.getRefundReason())) {
            queryWrapper.eq(OrderInfoAll::getRefundReason, pageVO.getRefundReason());
        }
            if(pageVO.getUserInfoUserInfoId5() != null){
            queryWrapper.eq(OrderInfoAll::getUserInfoUserInfoId5, pageVO.getUserInfoUserInfoId5());
        }
            if(pageVO.getPaymentTime() != null){
            queryWrapper.eq(OrderInfoAll::getPaymentTime, pageVO.getPaymentTime());
        }
        if(StringUtils.isNotEmpty(pageVO.getFieldName())) {
            queryWrapper.like(OrderInfoAll::getFieldName, pageVO.getFieldName());
        }
        if(StringUtils.isNotEmpty(pageVO.getRefundNo())) {
            queryWrapper.eq(OrderInfoAll::getRefundNo, pageVO.getRefundNo());
        }
        if(StringUtils.isNotEmpty(pageVO.getPayStatus())) {
            queryWrapper.eq(OrderInfoAll::getPayStatus, pageVO.getPayStatus());
        }
        if(StringUtils.isNotEmpty(pageVO.getRecipient())) {
            queryWrapper.eq(OrderInfoAll::getRecipient, pageVO.getRecipient());
        }
        if(StringUtils.isNotEmpty(pageVO.getShippingCompany())) {
            queryWrapper.eq(OrderInfoAll::getShippingCompany, pageVO.getShippingCompany());
        }
        if(StringUtils.isNotEmpty(pageVO.getImageResourceKey())) {
            queryWrapper.eq(OrderInfoAll::getImageResourceKey, pageVO.getImageResourceKey());
        }
            if(pageVO.getUpdateTime() != null){
            queryWrapper.eq(OrderInfoAll::getUpdateTime, pageVO.getUpdateTime());
        }
            if(pageVO.getOrderStatusEnumId() != null){
            queryWrapper.eq(OrderInfoAll::getOrderStatusEnumId, pageVO.getOrderStatusEnumId());
        }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {
            queryWrapper.like(OrderInfoAll::getUsername, pageVO.getUsername());
        }
        return ResultUtils.success(orderInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody OrderInfoAllPageVO vo){
        LambdaQueryWrapper<OrderInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getProductsId() != null){
            queryWrapper.eq(OrderInfoAll::getProductsId, vo.getProductsId());
        }
            if(StringUtils.isNotEmpty(vo.getOrderNo())) {
            queryWrapper.eq(OrderInfoAll::getOrderNo, vo.getOrderNo());
        }
            if(StringUtils.isNotEmpty(vo.getOrderStatus())) {
            queryWrapper.eq(OrderInfoAll::getOrderStatus, vo.getOrderStatus());
        }
            if(StringUtils.isNotEmpty(vo.getOpId())) {
            queryWrapper.eq(OrderInfoAll::getOpId, vo.getOpId());
        }
                if(vo.getMemberLevelId() != null){
            queryWrapper.eq(OrderInfoAll::getMemberLevelId, vo.getMemberLevelId());
        }
            if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
            queryWrapper.eq(OrderInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
        }
                if(vo.getUserId() != null){
            queryWrapper.eq(OrderInfoAll::getUserId, vo.getUserId());
        }
                if(vo.getDeliverTime() != null){
            queryWrapper.eq(OrderInfoAll::getDeliverTime, vo.getDeliverTime());
        }
                if(vo.getIsDeleted() != null){
            queryWrapper.eq(OrderInfoAll::getIsDeleted, vo.getIsDeleted());
        }
                if(vo.getPaymentAmount() != null){
            queryWrapper.eq(OrderInfoAll::getPaymentAmount, vo.getPaymentAmount());
        }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
            queryWrapper.eq(OrderInfoAll::getPassword, vo.getPassword());
        }
                if(vo.getPrice() != null){
            queryWrapper.eq(OrderInfoAll::getPrice, vo.getPrice());
        }
                if(vo.getCompleteTime() != null){
            queryWrapper.eq(OrderInfoAll::getCompleteTime, vo.getCompleteTime());
        }
                if(vo.getActualAmount() != null){
            queryWrapper.eq(OrderInfoAll::getActualAmount, vo.getActualAmount());
        }
            if(StringUtils.isNotEmpty(vo.getTel())) {
            queryWrapper.eq(OrderInfoAll::getTel, vo.getTel());
        }
                if(vo.getRefundAmount() != null){
            queryWrapper.eq(OrderInfoAll::getRefundAmount, vo.getRefundAmount());
        }
            if(StringUtils.isNotEmpty(vo.getRefundType())) {
            queryWrapper.eq(OrderInfoAll::getRefundType, vo.getRefundType());
        }
            if(StringUtils.isNotEmpty(vo.getMiniProgramPath())) {
            queryWrapper.eq(OrderInfoAll::getMiniProgramPath, vo.getMiniProgramPath());
        }
            if(StringUtils.isNotEmpty(vo.getStatusName())) {
            queryWrapper.like(OrderInfoAll::getStatusName, vo.getStatusName());
        }
            if(StringUtils.isNotEmpty(vo.getShippingMethod())) {
            queryWrapper.eq(OrderInfoAll::getShippingMethod, vo.getShippingMethod());
        }
                if(vo.getQuality() != null){
            queryWrapper.eq(OrderInfoAll::getQuality, vo.getQuality());
        }
            if(StringUtils.isNotEmpty(vo.getPaymentOrderNo())) {
            queryWrapper.eq(OrderInfoAll::getPaymentOrderNo, vo.getPaymentOrderNo());
        }
                if(vo.getTotalAmount() != null){
            queryWrapper.eq(OrderInfoAll::getTotalAmount, vo.getTotalAmount());
        }
            if(StringUtils.isNotEmpty(vo.getRefundStatus())) {
            queryWrapper.eq(OrderInfoAll::getRefundStatus, vo.getRefundStatus());
        }
            if(StringUtils.isNotEmpty(vo.getDeliveryStatus())) {
            queryWrapper.eq(OrderInfoAll::getDeliveryStatus, vo.getDeliveryStatus());
        }
                if(vo.getProductInfoProductInfoId() != null){
            queryWrapper.eq(OrderInfoAll::getProductInfoProductInfoId, vo.getProductInfoProductInfoId());
        }
            if(StringUtils.isNotEmpty(vo.getOrderType())) {
            queryWrapper.eq(OrderInfoAll::getOrderType, vo.getOrderType());
        }
            if(StringUtils.isNotEmpty(vo.getPaymentChannel())) {
            queryWrapper.eq(OrderInfoAll::getPaymentChannel, vo.getPaymentChannel());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(OrderInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
            if(StringUtils.isNotEmpty(vo.getRemark())) {
            queryWrapper.eq(OrderInfoAll::getRemark, vo.getRemark());
        }
                if(vo.getShippingFee() != null){
            queryWrapper.eq(OrderInfoAll::getShippingFee, vo.getShippingFee());
        }
                if(vo.getDiscountAmount() != null){
            queryWrapper.eq(OrderInfoAll::getDiscountAmount, vo.getDiscountAmount());
        }
            if(StringUtils.isNotEmpty(vo.getPaymentOrderId())) {
            queryWrapper.eq(OrderInfoAll::getPaymentOrderId, vo.getPaymentOrderId());
        }
            if(StringUtils.isNotEmpty(vo.getTrackingNumber())) {
            queryWrapper.eq(OrderInfoAll::getTrackingNumber, vo.getTrackingNumber());
        }
            if(StringUtils.isNotEmpty(vo.getProductName())) {
            queryWrapper.like(OrderInfoAll::getProductName, vo.getProductName());
        }
                if(vo.getCouponAmount() != null){
            queryWrapper.eq(OrderInfoAll::getCouponAmount, vo.getCouponAmount());
        }
            if(StringUtils.isNotEmpty(vo.getTableName())) {
            queryWrapper.like(OrderInfoAll::getTableName, vo.getTableName());
        }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
            queryWrapper.eq(OrderInfoAll::getEmail, vo.getEmail());
        }
            if(StringUtils.isNotEmpty(vo.getRefundId())) {
            queryWrapper.eq(OrderInfoAll::getRefundId, vo.getRefundId());
        }
            if(StringUtils.isNotEmpty(vo.getShippingAddress())) {
            queryWrapper.eq(OrderInfoAll::getShippingAddress, vo.getShippingAddress());
        }
                if(vo.getCreateTime() != null){
            queryWrapper.eq(OrderInfoAll::getCreateTime, vo.getCreateTime());
        }
                if(vo.getQuantity() != null){
            queryWrapper.eq(OrderInfoAll::getQuantity, vo.getQuantity());
        }
                if(vo.getTotalPrice() != null){
            queryWrapper.eq(OrderInfoAll::getTotalPrice, vo.getTotalPrice());
        }
                if(vo.getCancelTime() != null){
            queryWrapper.eq(OrderInfoAll::getCancelTime, vo.getCancelTime());
        }
            if(StringUtils.isNotEmpty(vo.getRefundReason())) {
            queryWrapper.eq(OrderInfoAll::getRefundReason, vo.getRefundReason());
        }
                if(vo.getUserInfoUserInfoId5() != null){
            queryWrapper.eq(OrderInfoAll::getUserInfoUserInfoId5, vo.getUserInfoUserInfoId5());
        }
                if(vo.getPaymentTime() != null){
            queryWrapper.eq(OrderInfoAll::getPaymentTime, vo.getPaymentTime());
        }
            if(StringUtils.isNotEmpty(vo.getFieldName())) {
            queryWrapper.like(OrderInfoAll::getFieldName, vo.getFieldName());
        }
            if(StringUtils.isNotEmpty(vo.getRefundNo())) {
            queryWrapper.eq(OrderInfoAll::getRefundNo, vo.getRefundNo());
        }
            if(StringUtils.isNotEmpty(vo.getPayStatus())) {
            queryWrapper.eq(OrderInfoAll::getPayStatus, vo.getPayStatus());
        }
            if(StringUtils.isNotEmpty(vo.getRecipient())) {
            queryWrapper.eq(OrderInfoAll::getRecipient, vo.getRecipient());
        }
            if(StringUtils.isNotEmpty(vo.getShippingCompany())) {
            queryWrapper.eq(OrderInfoAll::getShippingCompany, vo.getShippingCompany());
        }
            if(StringUtils.isNotEmpty(vo.getImageResourceKey())) {
            queryWrapper.eq(OrderInfoAll::getImageResourceKey, vo.getImageResourceKey());
        }
                if(vo.getUpdateTime() != null){
            queryWrapper.eq(OrderInfoAll::getUpdateTime, vo.getUpdateTime());
        }
                if(vo.getOrderStatusEnumId() != null){
            queryWrapper.eq(OrderInfoAll::getOrderStatusEnumId, vo.getOrderStatusEnumId());
        }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
            queryWrapper.like(OrderInfoAll::getUsername, vo.getUsername());
        }
        return ResultUtils.success(orderInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer orderInfoId) {
        OrderInfoAll entity = this.orderInfoAllService.getById(orderInfoId);
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
        private final IProductInfoService productInfoService;

        @GetMapping("get/product_info_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_product_info_list() {
            List<ProductInfo> list = this.productInfoService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getProductInfoId(), p.getProductName().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }
        private final IOrderStatusEnumService orderStatusEnumService;

        @GetMapping("get/order_status_enum_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_order_status_enum_list() {
            List<OrderStatusEnum> list = this.orderStatusEnumService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getOrderStatusEnumId(), p.getStatusName().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }
        private final IGeneralOrdersService generalOrdersService;

        @GetMapping("get/general_orders_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_general_orders_list() {
            List<GeneralOrders> list = this.generalOrdersService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getId(), p.getPaymentOrderId().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }


        /**
         * 导出excel
         */
        @PostMapping("/export")
        public void export(HttpServletResponse response, @RequestBody OrderInfoAllPageVO vo) {

            LambdaQueryWrapper<OrderInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                    if(vo.getProductsId() != null){
                        queryWrapper.eq(OrderInfoAll::getProductsId, vo.getProductsId());
                    }
                if(StringUtils.isNotEmpty(vo.getOrderNo())) {
                        queryWrapper.eq(OrderInfoAll::getOrderNo, vo.getOrderNo());
                    }
                if(StringUtils.isNotEmpty(vo.getOrderStatus())) {
                        queryWrapper.eq(OrderInfoAll::getOrderStatus, vo.getOrderStatus());
                    }
                if(StringUtils.isNotEmpty(vo.getOpId())) {
                        queryWrapper.eq(OrderInfoAll::getOpId, vo.getOpId());
                    }
                    if(vo.getMemberLevelId() != null){
                        queryWrapper.eq(OrderInfoAll::getMemberLevelId, vo.getMemberLevelId());
                    }
                if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
                        queryWrapper.eq(OrderInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
                    }
                    if(vo.getUserId() != null){
                        queryWrapper.eq(OrderInfoAll::getUserId, vo.getUserId());
                    }
                    if(vo.getDeliverTime() != null){
                        queryWrapper.eq(OrderInfoAll::getDeliverTime, vo.getDeliverTime());
                    }
                    if(vo.getIsDeleted() != null){
                        queryWrapper.eq(OrderInfoAll::getIsDeleted, vo.getIsDeleted());
                    }
                    if(vo.getPaymentAmount() != null){
                        queryWrapper.eq(OrderInfoAll::getPaymentAmount, vo.getPaymentAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getPassword())) {
                        queryWrapper.eq(OrderInfoAll::getPassword, vo.getPassword());
                    }
                    if(vo.getPrice() != null){
                        queryWrapper.eq(OrderInfoAll::getPrice, vo.getPrice());
                    }
                    if(vo.getCompleteTime() != null){
                        queryWrapper.eq(OrderInfoAll::getCompleteTime, vo.getCompleteTime());
                    }
                    if(vo.getActualAmount() != null){
                        queryWrapper.eq(OrderInfoAll::getActualAmount, vo.getActualAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getTel())) {
                        queryWrapper.eq(OrderInfoAll::getTel, vo.getTel());
                    }
                    if(vo.getRefundAmount() != null){
                        queryWrapper.eq(OrderInfoAll::getRefundAmount, vo.getRefundAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getRefundType())) {
                        queryWrapper.eq(OrderInfoAll::getRefundType, vo.getRefundType());
                    }
                if(StringUtils.isNotEmpty(vo.getMiniProgramPath())) {
                        queryWrapper.eq(OrderInfoAll::getMiniProgramPath, vo.getMiniProgramPath());
                    }
                if(StringUtils.isNotEmpty(vo.getStatusName())) {
                                queryWrapper.like(OrderInfoAll::getStatusName, vo.getStatusName());
                    }
                if(StringUtils.isNotEmpty(vo.getShippingMethod())) {
                        queryWrapper.eq(OrderInfoAll::getShippingMethod, vo.getShippingMethod());
                    }
                    if(vo.getQuality() != null){
                        queryWrapper.eq(OrderInfoAll::getQuality, vo.getQuality());
                    }
                if(StringUtils.isNotEmpty(vo.getPaymentOrderNo())) {
                        queryWrapper.eq(OrderInfoAll::getPaymentOrderNo, vo.getPaymentOrderNo());
                    }
                    if(vo.getTotalAmount() != null){
                        queryWrapper.eq(OrderInfoAll::getTotalAmount, vo.getTotalAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getRefundStatus())) {
                        queryWrapper.eq(OrderInfoAll::getRefundStatus, vo.getRefundStatus());
                    }
                if(StringUtils.isNotEmpty(vo.getDeliveryStatus())) {
                        queryWrapper.eq(OrderInfoAll::getDeliveryStatus, vo.getDeliveryStatus());
                    }
                    if(vo.getProductInfoProductInfoId() != null){
                        queryWrapper.eq(OrderInfoAll::getProductInfoProductInfoId, vo.getProductInfoProductInfoId());
                    }
                if(StringUtils.isNotEmpty(vo.getOrderType())) {
                        queryWrapper.eq(OrderInfoAll::getOrderType, vo.getOrderType());
                    }
                if(StringUtils.isNotEmpty(vo.getPaymentChannel())) {
                        queryWrapper.eq(OrderInfoAll::getPaymentChannel, vo.getPaymentChannel());
                    }
                if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                        queryWrapper.eq(OrderInfoAll::getPhoneNumber, vo.getPhoneNumber());
                    }
                if(StringUtils.isNotEmpty(vo.getRemark())) {
                        queryWrapper.eq(OrderInfoAll::getRemark, vo.getRemark());
                    }
                    if(vo.getShippingFee() != null){
                        queryWrapper.eq(OrderInfoAll::getShippingFee, vo.getShippingFee());
                    }
                    if(vo.getDiscountAmount() != null){
                        queryWrapper.eq(OrderInfoAll::getDiscountAmount, vo.getDiscountAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getPaymentOrderId())) {
                        queryWrapper.eq(OrderInfoAll::getPaymentOrderId, vo.getPaymentOrderId());
                    }
                if(StringUtils.isNotEmpty(vo.getTrackingNumber())) {
                        queryWrapper.eq(OrderInfoAll::getTrackingNumber, vo.getTrackingNumber());
                    }
                if(StringUtils.isNotEmpty(vo.getProductName())) {
                                queryWrapper.like(OrderInfoAll::getProductName, vo.getProductName());
                    }
                    if(vo.getCouponAmount() != null){
                        queryWrapper.eq(OrderInfoAll::getCouponAmount, vo.getCouponAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getTableName())) {
                                queryWrapper.like(OrderInfoAll::getTableName, vo.getTableName());
                    }
                if(StringUtils.isNotEmpty(vo.getEmail())) {
                        queryWrapper.eq(OrderInfoAll::getEmail, vo.getEmail());
                    }
                if(StringUtils.isNotEmpty(vo.getRefundId())) {
                        queryWrapper.eq(OrderInfoAll::getRefundId, vo.getRefundId());
                    }
                if(StringUtils.isNotEmpty(vo.getShippingAddress())) {
                        queryWrapper.eq(OrderInfoAll::getShippingAddress, vo.getShippingAddress());
                    }
                    if(vo.getCreateTime() != null){
                        queryWrapper.eq(OrderInfoAll::getCreateTime, vo.getCreateTime());
                    }
                    if(vo.getQuantity() != null){
                        queryWrapper.eq(OrderInfoAll::getQuantity, vo.getQuantity());
                    }
                    if(vo.getTotalPrice() != null){
                        queryWrapper.eq(OrderInfoAll::getTotalPrice, vo.getTotalPrice());
                    }
                    if(vo.getCancelTime() != null){
                        queryWrapper.eq(OrderInfoAll::getCancelTime, vo.getCancelTime());
                    }
                if(StringUtils.isNotEmpty(vo.getRefundReason())) {
                        queryWrapper.eq(OrderInfoAll::getRefundReason, vo.getRefundReason());
                    }
                    if(vo.getUserInfoUserInfoId5() != null){
                        queryWrapper.eq(OrderInfoAll::getUserInfoUserInfoId5, vo.getUserInfoUserInfoId5());
                    }
                    if(vo.getPaymentTime() != null){
                        queryWrapper.eq(OrderInfoAll::getPaymentTime, vo.getPaymentTime());
                    }
                if(StringUtils.isNotEmpty(vo.getFieldName())) {
                                queryWrapper.like(OrderInfoAll::getFieldName, vo.getFieldName());
                    }
                if(StringUtils.isNotEmpty(vo.getRefundNo())) {
                        queryWrapper.eq(OrderInfoAll::getRefundNo, vo.getRefundNo());
                    }
                if(StringUtils.isNotEmpty(vo.getPayStatus())) {
                        queryWrapper.eq(OrderInfoAll::getPayStatus, vo.getPayStatus());
                    }
                if(StringUtils.isNotEmpty(vo.getRecipient())) {
                        queryWrapper.eq(OrderInfoAll::getRecipient, vo.getRecipient());
                    }
                if(StringUtils.isNotEmpty(vo.getShippingCompany())) {
                        queryWrapper.eq(OrderInfoAll::getShippingCompany, vo.getShippingCompany());
                    }
                if(StringUtils.isNotEmpty(vo.getImageResourceKey())) {
                        queryWrapper.eq(OrderInfoAll::getImageResourceKey, vo.getImageResourceKey());
                    }
                    if(vo.getUpdateTime() != null){
                        queryWrapper.eq(OrderInfoAll::getUpdateTime, vo.getUpdateTime());
                    }
                    if(vo.getOrderStatusEnumId() != null){
                        queryWrapper.eq(OrderInfoAll::getOrderStatusEnumId, vo.getOrderStatusEnumId());
                    }
                if(StringUtils.isNotEmpty(vo.getUsername())) {
                                queryWrapper.like(OrderInfoAll::getUsername, vo.getUsername());
                    }
            List<OrderInfoAll> list = orderInfoAllService.list(queryWrapper);
            ExcelUtil<OrderInfoAll> util = new ExcelUtil<>(OrderInfoAll.class);
            util.exportExcel(response, list, "数据");
        }


}
