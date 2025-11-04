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
import com.kuafu.web.entity.CouponInfo;
import com.kuafu.web.service.ICouponInfoService;
import com.kuafu.web.vo.CouponInfoPageVO;
import com.kuafu.web.vo.CouponInfoVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 优惠券信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("CouponInfoControllerService")
@RequiredArgsConstructor
public class CouponInfoControllerService  {

    private final ICouponInfoService couponInfoService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( CouponInfoPageVO pageVO){
        IPage<CouponInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<CouponInfo> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<CouponInfo> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(CouponInfo::getCouponInfoId);

            if(pageVO.getCouponInfoId() != null){
                queryWrapper.eq(CouponInfo::getCouponInfoId, pageVO.getCouponInfoId());
            }


            if(pageVO.getUserInfoUserInfoId4() != null){
                queryWrapper.eq(CouponInfo::getUserInfoUserInfoId4, pageVO.getUserInfoUserInfoId4());
            }


            if(pageVO.getAmount() != null){
                queryWrapper.eq(CouponInfo::getAmount, pageVO.getAmount());
            }


            if(pageVO.getIsUsed() != null){
                queryWrapper.eq(CouponInfo::getIsUsed, pageVO.getIsUsed());
            }

            return ResultUtils.success(couponInfoService.page(page, queryWrapper));
        }


        public BaseResponse list(  CouponInfoVO vo){
            LambdaQueryWrapper<CouponInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId4() != null){
                    queryWrapper.eq(CouponInfo::getUserInfoUserInfoId4, vo.getUserInfoUserInfoId4());
                }
                if(vo.getAmount() != null){
                    queryWrapper.eq(CouponInfo::getAmount, vo.getAmount());
                }
                if(vo.getIsUsed() != null){
                    queryWrapper.eq(CouponInfo::getIsUsed, vo.getIsUsed());
                }
                return ResultUtils.success(couponInfoService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  CouponInfoVO vo) {
                CouponInfo entity =  CouponInfo.builder()
                    .userInfoUserInfoId4(vo.getUserInfoUserInfoId4())
                    .amount(vo.getAmount())
                    .isUsed(vo.getIsUsed())
                .build();








                boolean flag =this.couponInfoService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("coupon_info").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getCouponInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( CouponInfoVO vo) {
                CouponInfo entity =  CouponInfo.builder()
                    .couponInfoId(vo.getCouponInfoId())
                    .userInfoUserInfoId4(vo.getUserInfoUserInfoId4())
                    .amount(vo.getAmount())
                    .isUsed(vo.getIsUsed())
                .build();



                        boolean flag = this.couponInfoService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getCouponInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( CouponInfoVO vo ) {
                CouponInfo entity = this.couponInfoService.getById(vo.getCouponInfoId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( CouponInfoVO vo) {
                boolean flag = this.couponInfoService.removeById(vo.getCouponInfoId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
