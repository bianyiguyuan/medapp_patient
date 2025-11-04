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
import com.kuafu.web.entity.UserInfoAll;
import com.kuafu.web.service.IUserInfoAllService;
import com.kuafu.web.vo.UserInfoAllPageVO;

import com.kuafu.web.service.IMemberLevelEnumService;
import com.kuafu.web.entity.MemberLevelEnum;


/**
 * <p> 用户信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/userInfoAll")
@Api(tags = {"用户信息"})
public class UserInfoAllController  {

    private final IUserInfoAllService userInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody UserInfoAllPageVO pageVO){
        IPage<UserInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<UserInfoAll> queryWrapper = new LambdaQueryWrapper<>();

        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
            queryWrapper.eq(UserInfoAll::getPassword, pageVO.getPassword());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(UserInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
            if(pageVO.getMemberLevelId() != null){
            queryWrapper.eq(UserInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
        }
        if(StringUtils.isNotEmpty(pageVO.getDescription())) {
            queryWrapper.eq(UserInfoAll::getDescription, pageVO.getDescription());
        }
        if(StringUtils.isNotEmpty(pageVO.getAvatarResourceKey())) {
            queryWrapper.eq(UserInfoAll::getAvatarResourceKey, pageVO.getAvatarResourceKey());
        }
        if(StringUtils.isNotEmpty(pageVO.getLevelName())) {
            queryWrapper.like(UserInfoAll::getLevelName, pageVO.getLevelName());
        }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
            queryWrapper.eq(UserInfoAll::getEmail, pageVO.getEmail());
        }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {
            queryWrapper.like(UserInfoAll::getUsername, pageVO.getUsername());
        }
        return ResultUtils.success(userInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody UserInfoAllPageVO vo){
        LambdaQueryWrapper<UserInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getPassword())) {
            queryWrapper.eq(UserInfoAll::getPassword, vo.getPassword());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(UserInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
                if(vo.getMemberLevelId() != null){
            queryWrapper.eq(UserInfoAll::getMemberLevelId, vo.getMemberLevelId());
        }
            if(StringUtils.isNotEmpty(vo.getDescription())) {
            queryWrapper.eq(UserInfoAll::getDescription, vo.getDescription());
        }
            if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
            queryWrapper.eq(UserInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
        }
            if(StringUtils.isNotEmpty(vo.getLevelName())) {
            queryWrapper.like(UserInfoAll::getLevelName, vo.getLevelName());
        }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
            queryWrapper.eq(UserInfoAll::getEmail, vo.getEmail());
        }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
            queryWrapper.like(UserInfoAll::getUsername, vo.getUsername());
        }
        return ResultUtils.success(userInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer userInfoId) {
        UserInfoAll entity = this.userInfoAllService.getById(userInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


        private final IMemberLevelEnumService memberLevelEnumService;

        @GetMapping("get/member_level_enum_list")
        @ApiOperation("查询下拉框的外键信息")
        public BaseResponse get_member_level_enum_list() {
            List<MemberLevelEnum> list = this.memberLevelEnumService.list();
            final List<SelectVO> selectVoList = list.stream().map(p ->
                new SelectVO(p.getMemberLevelEnumId(), p.getLevelName().toString()))
                        .collect(Collectors.toList());
            return ResultUtils.success(selectVoList);
        }


        /**
         * 导出excel
         */
        @PostMapping("/export")
        public void export(HttpServletResponse response, @RequestBody UserInfoAllPageVO vo) {

            LambdaQueryWrapper<UserInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(StringUtils.isNotEmpty(vo.getPassword())) {
                        queryWrapper.eq(UserInfoAll::getPassword, vo.getPassword());
                    }
                if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                        queryWrapper.eq(UserInfoAll::getPhoneNumber, vo.getPhoneNumber());
                    }
                    if(vo.getMemberLevelId() != null){
                        queryWrapper.eq(UserInfoAll::getMemberLevelId, vo.getMemberLevelId());
                    }
                if(StringUtils.isNotEmpty(vo.getDescription())) {
                        queryWrapper.eq(UserInfoAll::getDescription, vo.getDescription());
                    }
                if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
                        queryWrapper.eq(UserInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
                    }
                if(StringUtils.isNotEmpty(vo.getLevelName())) {
                                queryWrapper.like(UserInfoAll::getLevelName, vo.getLevelName());
                    }
                if(StringUtils.isNotEmpty(vo.getEmail())) {
                        queryWrapper.eq(UserInfoAll::getEmail, vo.getEmail());
                    }
                if(StringUtils.isNotEmpty(vo.getUsername())) {
                                queryWrapper.like(UserInfoAll::getUsername, vo.getUsername());
                    }
            List<UserInfoAll> list = userInfoAllService.list(queryWrapper);
            ExcelUtil<UserInfoAll> util = new ExcelUtil<>(UserInfoAll.class);
            util.exportExcel(response, list, "数据");
        }


}
