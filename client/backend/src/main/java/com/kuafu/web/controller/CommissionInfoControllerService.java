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
import com.kuafu.web.entity.CommissionInfo;
import com.kuafu.web.service.ICommissionInfoService;
import com.kuafu.web.vo.CommissionInfoPageVO;
import com.kuafu.web.vo.CommissionInfoVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 佣金信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("CommissionInfoControllerService")
@RequiredArgsConstructor
public class CommissionInfoControllerService  {

    private final ICommissionInfoService commissionInfoService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( CommissionInfoPageVO pageVO){
        IPage<CommissionInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<CommissionInfo> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<CommissionInfo> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(CommissionInfo::getCommissionInfoId);

            if(pageVO.getCommissionInfoId() != null){
                queryWrapper.eq(CommissionInfo::getCommissionInfoId, pageVO.getCommissionInfoId());
            }


            if(pageVO.getUserInfoUserInfoId3() != null){
                queryWrapper.eq(CommissionInfo::getUserInfoUserInfoId3, pageVO.getUserInfoUserInfoId3());
            }


            if(pageVO.getCommissionRatio() != null){
                queryWrapper.eq(CommissionInfo::getCommissionRatio, pageVO.getCommissionRatio());
            }


            if(pageVO.getTotalEarnings() != null){
                queryWrapper.eq(CommissionInfo::getTotalEarnings, pageVO.getTotalEarnings());
            }

            return ResultUtils.success(commissionInfoService.page(page, queryWrapper));
        }


        public BaseResponse list(  CommissionInfoVO vo){
            LambdaQueryWrapper<CommissionInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId3() != null){
                    queryWrapper.eq(CommissionInfo::getUserInfoUserInfoId3, vo.getUserInfoUserInfoId3());
                }
                if(vo.getCommissionRatio() != null){
                    queryWrapper.eq(CommissionInfo::getCommissionRatio, vo.getCommissionRatio());
                }
                if(vo.getTotalEarnings() != null){
                    queryWrapper.eq(CommissionInfo::getTotalEarnings, vo.getTotalEarnings());
                }
                return ResultUtils.success(commissionInfoService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  CommissionInfoVO vo) {
                CommissionInfo entity =  CommissionInfo.builder()
                    .userInfoUserInfoId3(vo.getUserInfoUserInfoId3())
                    .commissionRatio(vo.getCommissionRatio())
                    .totalEarnings(vo.getTotalEarnings())
                .build();








                boolean flag =this.commissionInfoService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("commission_info").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getCommissionInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( CommissionInfoVO vo) {
                CommissionInfo entity =  CommissionInfo.builder()
                    .commissionInfoId(vo.getCommissionInfoId())
                    .userInfoUserInfoId3(vo.getUserInfoUserInfoId3())
                    .commissionRatio(vo.getCommissionRatio())
                    .totalEarnings(vo.getTotalEarnings())
                .build();



                        boolean flag = this.commissionInfoService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getCommissionInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( CommissionInfoVO vo ) {
                CommissionInfo entity = this.commissionInfoService.getById(vo.getCommissionInfoId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( CommissionInfoVO vo) {
                boolean flag = this.commissionInfoService.removeById(vo.getCommissionInfoId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
