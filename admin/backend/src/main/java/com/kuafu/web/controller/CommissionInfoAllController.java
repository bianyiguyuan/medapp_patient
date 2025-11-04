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
import com.kuafu.web.entity.CommissionInfoAll;
import com.kuafu.web.service.ICommissionInfoAllService;
import com.kuafu.web.vo.CommissionInfoAllPageVO;

import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;


/**
 * <p> 佣金信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/commissionInfoAll")
@Api(tags = {"佣金信息"})
public class CommissionInfoAllController  {

    private final ICommissionInfoAllService commissionInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody CommissionInfoAllPageVO pageVO){
        IPage<CommissionInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<CommissionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
            queryWrapper.eq(CommissionInfoAll::getPassword, pageVO.getPassword());
        }
            if(pageVO.getUserInfoUserInfoId3() != null){
            queryWrapper.eq(CommissionInfoAll::getUserInfoUserInfoId3, pageVO.getUserInfoUserInfoId3());
        }
            if(pageVO.getCommissionRatio() != null){
            queryWrapper.eq(CommissionInfoAll::getCommissionRatio, pageVO.getCommissionRatio());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(CommissionInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
            if(pageVO.getTotalEarnings() != null){
            queryWrapper.eq(CommissionInfoAll::getTotalEarnings, pageVO.getTotalEarnings());
        }
            if(pageVO.getMemberLevelId() != null){
            queryWrapper.eq(CommissionInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
        }
        if(StringUtils.isNotEmpty(pageVO.getAvatarResourceKey())) {
            queryWrapper.eq(CommissionInfoAll::getAvatarResourceKey, pageVO.getAvatarResourceKey());
        }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
            queryWrapper.eq(CommissionInfoAll::getEmail, pageVO.getEmail());
        }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {
            queryWrapper.like(CommissionInfoAll::getUsername, pageVO.getUsername());
        }
        return ResultUtils.success(commissionInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody CommissionInfoAllPageVO vo){
        LambdaQueryWrapper<CommissionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getPassword())) {
            queryWrapper.eq(CommissionInfoAll::getPassword, vo.getPassword());
        }
                if(vo.getUserInfoUserInfoId3() != null){
            queryWrapper.eq(CommissionInfoAll::getUserInfoUserInfoId3, vo.getUserInfoUserInfoId3());
        }
                if(vo.getCommissionRatio() != null){
            queryWrapper.eq(CommissionInfoAll::getCommissionRatio, vo.getCommissionRatio());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(CommissionInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
                if(vo.getTotalEarnings() != null){
            queryWrapper.eq(CommissionInfoAll::getTotalEarnings, vo.getTotalEarnings());
        }
                if(vo.getMemberLevelId() != null){
            queryWrapper.eq(CommissionInfoAll::getMemberLevelId, vo.getMemberLevelId());
        }
            if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
            queryWrapper.eq(CommissionInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
        }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
            queryWrapper.eq(CommissionInfoAll::getEmail, vo.getEmail());
        }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
            queryWrapper.like(CommissionInfoAll::getUsername, vo.getUsername());
        }
        return ResultUtils.success(commissionInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer commissionInfoId) {
        CommissionInfoAll entity = this.commissionInfoAllService.getById(commissionInfoId);
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


        /**
         * 导出excel
         */
        @PostMapping("/export")
        public void export(HttpServletResponse response, @RequestBody CommissionInfoAllPageVO vo) {

            LambdaQueryWrapper<CommissionInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(StringUtils.isNotEmpty(vo.getPassword())) {
                        queryWrapper.eq(CommissionInfoAll::getPassword, vo.getPassword());
                    }
                    if(vo.getUserInfoUserInfoId3() != null){
                        queryWrapper.eq(CommissionInfoAll::getUserInfoUserInfoId3, vo.getUserInfoUserInfoId3());
                    }
                    if(vo.getCommissionRatio() != null){
                        queryWrapper.eq(CommissionInfoAll::getCommissionRatio, vo.getCommissionRatio());
                    }
                if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                        queryWrapper.eq(CommissionInfoAll::getPhoneNumber, vo.getPhoneNumber());
                    }
                    if(vo.getTotalEarnings() != null){
                        queryWrapper.eq(CommissionInfoAll::getTotalEarnings, vo.getTotalEarnings());
                    }
                    if(vo.getMemberLevelId() != null){
                        queryWrapper.eq(CommissionInfoAll::getMemberLevelId, vo.getMemberLevelId());
                    }
                if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
                        queryWrapper.eq(CommissionInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
                    }
                if(StringUtils.isNotEmpty(vo.getEmail())) {
                        queryWrapper.eq(CommissionInfoAll::getEmail, vo.getEmail());
                    }
                if(StringUtils.isNotEmpty(vo.getUsername())) {
                                queryWrapper.like(CommissionInfoAll::getUsername, vo.getUsername());
                    }
            List<CommissionInfoAll> list = commissionInfoAllService.list(queryWrapper);
            ExcelUtil<CommissionInfoAll> util = new ExcelUtil<>(CommissionInfoAll.class);
            util.exportExcel(response, list, "数据");
        }


}
