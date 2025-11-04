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
import com.kuafu.web.entity.MemberLevelEnum;
import com.kuafu.web.service.IMemberLevelEnumService;
import com.kuafu.web.vo.MemberLevelEnumPageVO;
import com.kuafu.web.vo.MemberLevelEnumVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 会员等级 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("MemberLevelEnumControllerService")
@RequiredArgsConstructor
public class MemberLevelEnumControllerService  {

    private final IMemberLevelEnumService memberLevelEnumService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( MemberLevelEnumPageVO pageVO){
        IPage<MemberLevelEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<MemberLevelEnum> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<MemberLevelEnum> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(MemberLevelEnum::getMemberLevelEnumId);

            if(pageVO.getMemberLevelEnumId() != null){
                queryWrapper.eq(MemberLevelEnum::getMemberLevelEnumId, pageVO.getMemberLevelEnumId());
            }


        if(StringUtils.isNotEmpty(pageVO.getLevelName())) {
//                        queryWrapper.like(MemberLevelEnum::getLevelName, pageVO.getLevelName());
                        String s_string = pageVO.getLevelName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(MemberLevelEnum::getLevelName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }


        if(StringUtils.isNotEmpty(pageVO.getDescription())) {
                queryWrapper.eq(MemberLevelEnum::getDescription, pageVO.getDescription());
            }

            return ResultUtils.success(memberLevelEnumService.page(page, queryWrapper));
        }


        public BaseResponse list(  MemberLevelEnumVO vo){
            LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getLevelName())) {
                            queryWrapper.like(MemberLevelEnum::getLevelName, vo.getLevelName());
                }
            if(StringUtils.isNotEmpty(vo.getDescription())) {
                    queryWrapper.eq(MemberLevelEnum::getDescription, vo.getDescription());
                }
                return ResultUtils.success(memberLevelEnumService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  MemberLevelEnumVO vo) {
                MemberLevelEnum entity =  MemberLevelEnum.builder()
                    .levelName(vo.getLevelName())
                    .description(vo.getDescription())
                .build();








                boolean flag =this.memberLevelEnumService.save(entity);






                if(flag
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("member_level_enum").data(entity).build());
                }

                return
flag

                ? ResultUtils.success(entity.getMemberLevelEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( MemberLevelEnumVO vo) {
                MemberLevelEnum entity =  MemberLevelEnum.builder()
                    .memberLevelEnumId(vo.getMemberLevelEnumId())
                    .levelName(vo.getLevelName())
                    .description(vo.getDescription())
                .build();



                        boolean flag = this.memberLevelEnumService.saveOrUpdate(entity);








                return  flag
                         ? ResultUtils.success(entity.getMemberLevelEnumId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( MemberLevelEnumVO vo ) {
                MemberLevelEnum entity = this.memberLevelEnumService.getById(vo.getMemberLevelEnumId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( MemberLevelEnumVO vo) {
                boolean flag = this.memberLevelEnumService.removeById(vo.getMemberLevelEnumId());





                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
