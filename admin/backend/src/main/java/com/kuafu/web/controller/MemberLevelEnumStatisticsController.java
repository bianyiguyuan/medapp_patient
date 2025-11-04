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
import com.kuafu.web.entity.MemberLevelEnum;
import com.kuafu.web.service.IMemberLevelEnumStatisticsService;
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
@RequestMapping("/memberLevelEnumStatistics")

public class MemberLevelEnumStatisticsController  {

    private final IMemberLevelEnumStatisticsService memberLevelEnumStatisticsService;


    @PostMapping("member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count")
    public BaseResponse member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count(@RequestBody MemberLevelEnum statisticVo) {
        LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( memberLevelEnumStatisticsService.member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count(queryWrapper));
    }
    @PostMapping("member_level_enum_member_level_enum_id_status_statistic_72e02317_count")
    public BaseResponse member_level_enum_member_level_enum_id_status_statistic_72e02317_count(@RequestBody MemberLevelEnum statisticVo) {
        LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( memberLevelEnumStatisticsService.member_level_enum_member_level_enum_id_status_statistic_72e02317_count(queryWrapper));
    }
    @PostMapping("member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count")
    public BaseResponse member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count(@RequestBody MemberLevelEnum statisticVo) {
        LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapperParams(queryWrapper, statisticVo);

                    
        return ResultUtils.success( memberLevelEnumStatisticsService.member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count(queryWrapper));
    }


    private void queryWrapperParams(LambdaQueryWrapper<MemberLevelEnum> queryWrapper, MemberLevelEnum statisticVo){
        if(StringUtils.isNotEmpty(statisticVo.getLevelName())) {
                        queryWrapper.like(MemberLevelEnum::getLevelName, statisticVo.getLevelName());
            }
        if(StringUtils.isNotEmpty(statisticVo.getDescription())) {
                queryWrapper.eq(MemberLevelEnum::getDescription, statisticVo.getDescription());
            }
    }



}
