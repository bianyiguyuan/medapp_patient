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
import com.kuafu.web.entity.CommissionInfo;
import com.kuafu.web.service.ICommissionInfoService;
import com.kuafu.web.vo.CommissionInfoPageVO;
import com.kuafu.web.vo.CommissionInfoVO;
import com.kuafu.web.event.MyEventService;
import com.kuafu.web.event.EventVo;
/**
 * <p> 佣金信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/commissionInfo")
@Api(tags = {"佣金信息"})
public class CommissionInfoController  {

    private final ICommissionInfoService commissionInfoService;

    private final MyEventService myEventService;

    private final ExcelProvider excelProvider;
    private final IStaticResourceService staticResourceService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody CommissionInfoPageVO pageVO){
        IPage<CommissionInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<CommissionInfo> queryWrapper = new LambdaQueryWrapper<>();

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

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody CommissionInfoVO vo){
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


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<CommissionInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(CommissionInfo::getCommissionInfoId);

        List<CommissionInfo> list =commissionInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getCommissionInfoId(), l.getCommissionInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    @SensitiveFilter
    public BaseResponse add( @RequestBody CommissionInfoVO vo) {
        CommissionInfo entity =  CommissionInfo.builder()
                    .userInfoUserInfoId3(vo.getUserInfoUserInfoId3())
                    .commissionRatio(vo.getCommissionRatio())
                    .totalEarnings(vo.getTotalEarnings())
                .build();
        boolean flag =this.commissionInfoService.save(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("commissionInfo").data(entity).build());
                }


        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    @SensitiveFilter
    public BaseResponse update( @RequestBody CommissionInfoVO vo) {
        CommissionInfo entity =  CommissionInfo.builder()
                    .commissionInfoId(vo.getCommissionInfoId())
                    .userInfoUserInfoId3(vo.getUserInfoUserInfoId3())
                    .commissionRatio(vo.getCommissionRatio())
                    .totalEarnings(vo.getTotalEarnings())
                .build();
        boolean flag = this.commissionInfoService.updateById(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("update").tableName("commissionInfo").data(entity).build());
                }



        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer commissionInfoId) {
        CommissionInfo entity = this.commissionInfoService.getById(commissionInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer commissionInfoId) {
        boolean flag = this.commissionInfoService.removeById(commissionInfoId);
        if (flag) {
            myEventService.publishEvent(EventVo.builder().model("delete").tableName("commissionInfo").data( CommissionInfo.builder().commissionInfoId(commissionInfoId).build() ).build());
        }
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 导出excel
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody CommissionInfoPageVO pageVO) {

        LambdaQueryWrapper<CommissionInfo> queryWrapper = new LambdaQueryWrapper<>();

                        if(pageVO.getUserInfoUserInfoId3() != null){
                            queryWrapper.eq(CommissionInfo::getUserInfoUserInfoId3, pageVO.getUserInfoUserInfoId3());
                        }
                        if(pageVO.getCommissionRatio() != null){
                            queryWrapper.eq(CommissionInfo::getCommissionRatio, pageVO.getCommissionRatio());
                        }
                        if(pageVO.getTotalEarnings() != null){
                            queryWrapper.eq(CommissionInfo::getTotalEarnings, pageVO.getTotalEarnings());
                        }
            List<CommissionInfo> list = commissionInfoService.list(queryWrapper);
            ExcelUtil<CommissionInfo> util = new ExcelUtil<>(CommissionInfo.class);
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
            excelProvider.pdfData(file, CommissionInfo.class, commissionInfoService::saveBatch);
        }
        else{
            excelProvider.importData(file, CommissionInfo.class, commissionInfoService::saveBatch);
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
                        Workbook workbook = excelProvider.downloadExcelTemplate(CommissionInfo.class);
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
