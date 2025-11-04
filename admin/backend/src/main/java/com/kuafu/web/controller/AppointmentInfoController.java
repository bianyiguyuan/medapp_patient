package com.kuafu.web.controller;

import java.util.List;
import java.io.IOException;
import java.util.stream.Collectors;
import com.kuafu.common.util.excel.ExcelProvider;
import org.apache.poi.ss.usermodel.Workbook;
import com.kuafu.common.file.FileUploadUtils;
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
import org.springframework.web.bind.annotation.RequestPart;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.SelectVO;
import com.kuafu.common.util.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;
import com.kuafu.common.sensitive.SensitiveFilter;
import com.kuafu.common.domin.StaticResource;
import com.kuafu.common.resource.service.IStaticResourceService;

import lombok.RequiredArgsConstructor;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.servlet.http.HttpServletResponse;
import com.kuafu.common.domin.BaseResponse;
import com.kuafu.common.domin.ErrorCode;
import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.util.StringUtils;
import com.kuafu.web.entity.AppointmentInfo;
import com.kuafu.web.service.IAppointmentInfoService;
import com.kuafu.web.vo.AppointmentInfoPageVO;
import com.kuafu.web.vo.AppointmentInfoVO;
import com.kuafu.web.event.MyEventService;
import com.kuafu.web.event.EventVo;
/**
 * <p> 预约信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/appointmentInfo")
@Api(tags = {"预约信息"})
public class AppointmentInfoController  {

    private final IAppointmentInfoService appointmentInfoService;

    private final MyEventService myEventService;

    private final ExcelProvider excelProvider;
    private final IStaticResourceService staticResourceService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody AppointmentInfoPageVO pageVO){
        IPage<AppointmentInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getUserInfoUserInfoId1() != null){
            queryWrapper.eq(AppointmentInfo::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
        }
            if(StringUtils.isNotEmpty(pageVO.getDoctorName())) {
            queryWrapper.like(AppointmentInfo::getDoctorName, pageVO.getDoctorName());
        }
            if(pageVO.getAppointmentDate() != null){
            queryWrapper.eq(AppointmentInfo::getAppointmentDate, pageVO.getAppointmentDate());
        }
            if(StringUtils.isNotEmpty(pageVO.getAppointmentTime())) {
            queryWrapper.eq(AppointmentInfo::getAppointmentTime, pageVO.getAppointmentTime());
        }
            if(pageVO.getStatusEnumId() != null){
            queryWrapper.eq(AppointmentInfo::getStatusEnumId, pageVO.getStatusEnumId());
        }
            if(pageVO.getDepositPaid() != null){
            queryWrapper.eq(AppointmentInfo::getDepositPaid, pageVO.getDepositPaid());
        }
            if(pageVO.getDepositAmount() != null){
            queryWrapper.eq(AppointmentInfo::getDepositAmount, pageVO.getDepositAmount());
        }
            if(pageVO.getCouponReceived() != null){
            queryWrapper.eq(AppointmentInfo::getCouponReceived, pageVO.getCouponReceived());
        }
            if(StringUtils.isNotEmpty(pageVO.getAppointmentCode())) {
            queryWrapper.eq(AppointmentInfo::getAppointmentCode, pageVO.getAppointmentCode());
        }
        return ResultUtils.success(appointmentInfoService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody AppointmentInfoVO vo){
        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId1() != null){
            queryWrapper.eq(AppointmentInfo::getUserInfoUserInfoId1, vo.getUserInfoUserInfoId1());
        }
            if(StringUtils.isNotEmpty(vo.getDoctorName())) {
            queryWrapper.like(AppointmentInfo::getDoctorName, vo.getDoctorName());
        }
                if(vo.getAppointmentDate() != null){
            queryWrapper.eq(AppointmentInfo::getAppointmentDate, vo.getAppointmentDate());
        }
            if(StringUtils.isNotEmpty(vo.getAppointmentTime())) {
            queryWrapper.eq(AppointmentInfo::getAppointmentTime, vo.getAppointmentTime());
        }
                if(vo.getStatusEnumId() != null){
            queryWrapper.eq(AppointmentInfo::getStatusEnumId, vo.getStatusEnumId());
        }
                if(vo.getDepositPaid() != null){
            queryWrapper.eq(AppointmentInfo::getDepositPaid, vo.getDepositPaid());
        }
                if(vo.getDepositAmount() != null){
            queryWrapper.eq(AppointmentInfo::getDepositAmount, vo.getDepositAmount());
        }
                if(vo.getCouponReceived() != null){
            queryWrapper.eq(AppointmentInfo::getCouponReceived, vo.getCouponReceived());
        }
            if(StringUtils.isNotEmpty(vo.getAppointmentCode())) {
            queryWrapper.eq(AppointmentInfo::getAppointmentCode, vo.getAppointmentCode());
        }
        return ResultUtils.success(appointmentInfoService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(AppointmentInfo::getAppointmentInfoId);

        List<AppointmentInfo> list =appointmentInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getAppointmentInfoId(), l.getAppointmentInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    @SensitiveFilter
    public BaseResponse add( @RequestBody AppointmentInfoVO vo) {
        AppointmentInfo entity =  AppointmentInfo.builder()
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .doctorName(vo.getDoctorName())
                    .appointmentDate(vo.getAppointmentDate())
                    .appointmentTime(vo.getAppointmentTime())
                    .statusEnumId(vo.getStatusEnumId())
                    .depositPaid(vo.getDepositPaid())
                    .depositAmount(vo.getDepositAmount())
                    .couponReceived(vo.getCouponReceived())
                    .appointmentCode(vo.getAppointmentCode())
                .build();
        boolean flag =this.appointmentInfoService.save(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("appointmentInfo").data(entity).build());
                }


        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    @SensitiveFilter
    public BaseResponse update( @RequestBody AppointmentInfoVO vo) {
        AppointmentInfo entity =  AppointmentInfo.builder()
                    .appointmentInfoId(vo.getAppointmentInfoId())
                    .userInfoUserInfoId1(vo.getUserInfoUserInfoId1())
                    .doctorName(vo.getDoctorName())
                    .appointmentDate(vo.getAppointmentDate())
                    .appointmentTime(vo.getAppointmentTime())
                    .statusEnumId(vo.getStatusEnumId())
                    .depositPaid(vo.getDepositPaid())
                    .depositAmount(vo.getDepositAmount())
                    .couponReceived(vo.getCouponReceived())
                    .appointmentCode(vo.getAppointmentCode())
                .build();
        boolean flag = this.appointmentInfoService.updateById(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("update").tableName("appointmentInfo").data(entity).build());
                }



        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer appointmentInfoId) {
        AppointmentInfo entity = this.appointmentInfoService.getById(appointmentInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer appointmentInfoId) {
        boolean flag = this.appointmentInfoService.removeById(appointmentInfoId);
        if (flag) {
            myEventService.publishEvent(EventVo.builder().model("delete").tableName("appointmentInfo").data( AppointmentInfo.builder().appointmentInfoId(appointmentInfoId).build() ).build());
        }
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 导出excel
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody AppointmentInfoPageVO pageVO) {

        LambdaQueryWrapper<AppointmentInfo> queryWrapper = new LambdaQueryWrapper<>();

                        if(pageVO.getUserInfoUserInfoId1() != null){
                            queryWrapper.eq(AppointmentInfo::getUserInfoUserInfoId1, pageVO.getUserInfoUserInfoId1());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getDoctorName())) {
                                    queryWrapper.like(AppointmentInfo::getDoctorName, pageVO.getDoctorName());
                        }
                        if(pageVO.getAppointmentDate() != null){
                            queryWrapper.eq(AppointmentInfo::getAppointmentDate, pageVO.getAppointmentDate());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getAppointmentTime())) {
                            queryWrapper.eq(AppointmentInfo::getAppointmentTime, pageVO.getAppointmentTime());
                        }
                        if(pageVO.getStatusEnumId() != null){
                            queryWrapper.eq(AppointmentInfo::getStatusEnumId, pageVO.getStatusEnumId());
                        }
                        if(pageVO.getDepositPaid() != null){
                            queryWrapper.eq(AppointmentInfo::getDepositPaid, pageVO.getDepositPaid());
                        }
                        if(pageVO.getDepositAmount() != null){
                            queryWrapper.eq(AppointmentInfo::getDepositAmount, pageVO.getDepositAmount());
                        }
                        if(pageVO.getCouponReceived() != null){
                            queryWrapper.eq(AppointmentInfo::getCouponReceived, pageVO.getCouponReceived());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getAppointmentCode())) {
                            queryWrapper.eq(AppointmentInfo::getAppointmentCode, pageVO.getAppointmentCode());
                        }
            List<AppointmentInfo> list = appointmentInfoService.list(queryWrapper);
            ExcelUtil<AppointmentInfo> util = new ExcelUtil<>(AppointmentInfo.class);
            util.exportExcel(response, list, "数据");
        }

    /**
     * 导入excel
     * @param file
     * @return
     */
    @PostMapping("/import")
    public BaseResponse importExcel(@RequestPart(name = "file") MultipartFile file)
    {
        String extension = FileUploadUtils.getExtension(file);
        if (StringUtils.equalsIgnoreCase(extension, "pdf")) {
            excelProvider.pdfData(file, AppointmentInfo.class, appointmentInfoService::saveBatch);
        }
        else{
            excelProvider.importData(file, AppointmentInfo.class, appointmentInfoService::saveBatch);
        }
            return ResultUtils.success("导入成功");
    }

    /**
     * 下载 excel 模版
     * @param response
     * @throws IOException
     */
    @GetMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
                    try {
                        Workbook workbook = excelProvider.downloadExcelTemplate(AppointmentInfo.class);
                        // 返回文件流
                        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                        response.setCharacterEncoding("utf-8");
                        workbook.write(response.getOutputStream());
                        workbook.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
    }


            }
