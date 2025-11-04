package com.kuafu.web.controller;

import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.kuafu.common.resource.service.IStaticResourceService;
import com.kuafu.common.event.EventVo;
import com.kuafu.common.event.MyEventService;
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
import org.springframework.transaction.support.TransactionTemplate;
import com.kuafu.common.sensitive.SensitiveFilter;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.OrderInfo;
import com.kuafu.web.service.IOrderInfoService;
import com.kuafu.web.vo.OrderInfoPageVO;
import com.kuafu.web.vo.OrderInfoVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 订单信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("OrderInfoControllerService")
@RequiredArgsConstructor
public class OrderInfoControllerService  {

    private final IOrderInfoService orderInfoService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( OrderInfoPageVO pageVO){
        IPage<OrderInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<OrderInfo> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<OrderInfo> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(OrderInfo::getOrderInfoId);

            if(pageVO.getOrderInfoId() != null){
                queryWrapper.eq(OrderInfo::getOrderInfoId, pageVO.getOrderInfoId());
            }


            if(pageVO.getUserInfoUserInfoId5() != null){
                queryWrapper.eq(OrderInfo::getUserInfoUserInfoId5, pageVO.getUserInfoUserInfoId5());
            }


            if(pageVO.getProductInfoProductInfoId() != null){
                queryWrapper.eq(OrderInfo::getProductInfoProductInfoId, pageVO.getProductInfoProductInfoId());
            }


            if(pageVO.getQuantity() != null){
                queryWrapper.eq(OrderInfo::getQuantity, pageVO.getQuantity());
            }


            if(pageVO.getTotalPrice() != null){
                queryWrapper.eq(OrderInfo::getTotalPrice, pageVO.getTotalPrice());
            }


            if(pageVO.getOrderStatusEnumId() != null){
                queryWrapper.eq(OrderInfo::getOrderStatusEnumId, pageVO.getOrderStatusEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getPaymentOrderNo())) {
                queryWrapper.eq(OrderInfo::getPaymentOrderNo, pageVO.getPaymentOrderNo());
            }

            return ResultUtils.success(orderInfoService.page(page, queryWrapper));
        }


        public BaseResponse list(  OrderInfoVO vo){
            LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId5() != null){
                    queryWrapper.eq(OrderInfo::getUserInfoUserInfoId5, vo.getUserInfoUserInfoId5());
                }
                if(vo.getProductInfoProductInfoId() != null){
                    queryWrapper.eq(OrderInfo::getProductInfoProductInfoId, vo.getProductInfoProductInfoId());
                }
                if(vo.getQuantity() != null){
                    queryWrapper.eq(OrderInfo::getQuantity, vo.getQuantity());
                }
                if(vo.getTotalPrice() != null){
                    queryWrapper.eq(OrderInfo::getTotalPrice, vo.getTotalPrice());
                }
                if(vo.getOrderStatusEnumId() != null){
                    queryWrapper.eq(OrderInfo::getOrderStatusEnumId, vo.getOrderStatusEnumId());
                }
            if(StringUtils.isNotEmpty(vo.getPaymentOrderNo())) {
                    queryWrapper.eq(OrderInfo::getPaymentOrderNo, vo.getPaymentOrderNo());
                }
                return ResultUtils.success(orderInfoService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  OrderInfoVO vo) {
                OrderInfo entity =  OrderInfo.builder()
                    .userInfoUserInfoId5(vo.getUserInfoUserInfoId5())
                    .productInfoProductInfoId(vo.getProductInfoProductInfoId())
                    .quantity(vo.getQuantity())
                    .totalPrice(vo.getTotalPrice())
                    .orderStatusEnumId(vo.getOrderStatusEnumId())
                    .paymentOrderNo(vo.getPaymentOrderNo())
                .build();








                boolean flag =this.orderInfoService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("order_info").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getOrderInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( OrderInfoVO vo) {
                OrderInfo entity =  OrderInfo.builder()
                    .orderInfoId(vo.getOrderInfoId())
                    .userInfoUserInfoId5(vo.getUserInfoUserInfoId5())
                    .productInfoProductInfoId(vo.getProductInfoProductInfoId())
                    .quantity(vo.getQuantity())
                    .totalPrice(vo.getTotalPrice())
                    .orderStatusEnumId(vo.getOrderStatusEnumId())
                    .paymentOrderNo(vo.getPaymentOrderNo())
                .build();



                        boolean flag = this.orderInfoService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getOrderInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( OrderInfoVO vo ) {
                OrderInfo entity = this.orderInfoService.getById(vo.getOrderInfoId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( OrderInfoVO vo) {
                boolean flag = this.orderInfoService.removeById(vo.getOrderInfoId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
