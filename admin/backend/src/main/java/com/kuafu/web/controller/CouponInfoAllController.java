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
import com.kuafu.web.entity.CouponInfoAll;
import com.kuafu.web.service.ICouponInfoAllService;
import com.kuafu.web.vo.CouponInfoAllPageVO;

import com.kuafu.web.service.IUserInfoService;
import com.kuafu.web.entity.UserInfo;


/**
 * <p> 优惠券信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/couponInfoAll")
@Api(tags = {"优惠券信息"})
public class CouponInfoAllController  {

    private final ICouponInfoAllService couponInfoAllService;

    @PostMapping("page")
    @ApiOperation("全字段分页")
    public BaseResponse page(@RequestBody CouponInfoAllPageVO pageVO){
        IPage<CouponInfoAll> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<CouponInfoAll> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getUserInfoUserInfoId4() != null){
            queryWrapper.eq(CouponInfoAll::getUserInfoUserInfoId4, pageVO.getUserInfoUserInfoId4());
        }
            if(pageVO.getAmount() != null){
            queryWrapper.eq(CouponInfoAll::getAmount, pageVO.getAmount());
        }
        if(StringUtils.isNotEmpty(pageVO.getPassword())) {
            queryWrapper.eq(CouponInfoAll::getPassword, pageVO.getPassword());
        }
        if(StringUtils.isNotEmpty(pageVO.getPhoneNumber())) {
            queryWrapper.eq(CouponInfoAll::getPhoneNumber, pageVO.getPhoneNumber());
        }
            if(pageVO.getMemberLevelId() != null){
            queryWrapper.eq(CouponInfoAll::getMemberLevelId, pageVO.getMemberLevelId());
        }
        if(StringUtils.isNotEmpty(pageVO.getAvatarResourceKey())) {
            queryWrapper.eq(CouponInfoAll::getAvatarResourceKey, pageVO.getAvatarResourceKey());
        }
        if(StringUtils.isNotEmpty(pageVO.getEmail())) {
            queryWrapper.eq(CouponInfoAll::getEmail, pageVO.getEmail());
        }
            if(pageVO.getIsUsed() != null){
            queryWrapper.eq(CouponInfoAll::getIsUsed, pageVO.getIsUsed());
        }
        if(StringUtils.isNotEmpty(pageVO.getUsername())) {
            queryWrapper.like(CouponInfoAll::getUsername, pageVO.getUsername());
        }
        return ResultUtils.success(couponInfoAllService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("全字段列表")
    public BaseResponse list(@RequestBody CouponInfoAllPageVO vo){
        LambdaQueryWrapper<CouponInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId4() != null){
            queryWrapper.eq(CouponInfoAll::getUserInfoUserInfoId4, vo.getUserInfoUserInfoId4());
        }
                if(vo.getAmount() != null){
            queryWrapper.eq(CouponInfoAll::getAmount, vo.getAmount());
        }
            if(StringUtils.isNotEmpty(vo.getPassword())) {
            queryWrapper.eq(CouponInfoAll::getPassword, vo.getPassword());
        }
            if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
            queryWrapper.eq(CouponInfoAll::getPhoneNumber, vo.getPhoneNumber());
        }
                if(vo.getMemberLevelId() != null){
            queryWrapper.eq(CouponInfoAll::getMemberLevelId, vo.getMemberLevelId());
        }
            if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
            queryWrapper.eq(CouponInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
        }
            if(StringUtils.isNotEmpty(vo.getEmail())) {
            queryWrapper.eq(CouponInfoAll::getEmail, vo.getEmail());
        }
                if(vo.getIsUsed() != null){
            queryWrapper.eq(CouponInfoAll::getIsUsed, vo.getIsUsed());
        }
            if(StringUtils.isNotEmpty(vo.getUsername())) {
            queryWrapper.like(CouponInfoAll::getUsername, vo.getUsername());
        }
        return ResultUtils.success(couponInfoAllService.list(queryWrapper));
    }

    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer couponInfoId) {
        CouponInfoAll entity = this.couponInfoAllService.getById(couponInfoId);
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
        public void export(HttpServletResponse response, @RequestBody CouponInfoAllPageVO vo) {

            LambdaQueryWrapper<CouponInfoAll> queryWrapper = new LambdaQueryWrapper<>();

                    if(vo.getUserInfoUserInfoId4() != null){
                        queryWrapper.eq(CouponInfoAll::getUserInfoUserInfoId4, vo.getUserInfoUserInfoId4());
                    }
                    if(vo.getAmount() != null){
                        queryWrapper.eq(CouponInfoAll::getAmount, vo.getAmount());
                    }
                if(StringUtils.isNotEmpty(vo.getPassword())) {
                        queryWrapper.eq(CouponInfoAll::getPassword, vo.getPassword());
                    }
                if(StringUtils.isNotEmpty(vo.getPhoneNumber())) {
                        queryWrapper.eq(CouponInfoAll::getPhoneNumber, vo.getPhoneNumber());
                    }
                    if(vo.getMemberLevelId() != null){
                        queryWrapper.eq(CouponInfoAll::getMemberLevelId, vo.getMemberLevelId());
                    }
                if(StringUtils.isNotEmpty(vo.getAvatarResourceKey())) {
                        queryWrapper.eq(CouponInfoAll::getAvatarResourceKey, vo.getAvatarResourceKey());
                    }
                if(StringUtils.isNotEmpty(vo.getEmail())) {
                        queryWrapper.eq(CouponInfoAll::getEmail, vo.getEmail());
                    }
                    if(vo.getIsUsed() != null){
                        queryWrapper.eq(CouponInfoAll::getIsUsed, vo.getIsUsed());
                    }
                if(StringUtils.isNotEmpty(vo.getUsername())) {
                                queryWrapper.like(CouponInfoAll::getUsername, vo.getUsername());
                    }
            List<CouponInfoAll> list = couponInfoAllService.list(queryWrapper);
            ExcelUtil<CouponInfoAll> util = new ExcelUtil<>(CouponInfoAll.class);
            util.exportExcel(response, list, "数据");
        }


}
