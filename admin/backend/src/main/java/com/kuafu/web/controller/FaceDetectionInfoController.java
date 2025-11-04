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
import com.kuafu.web.entity.FaceDetectionInfo;
import com.kuafu.web.service.IFaceDetectionInfoService;
import com.kuafu.web.vo.FaceDetectionInfoPageVO;
import com.kuafu.web.vo.FaceDetectionInfoVO;
import com.kuafu.web.event.MyEventService;
import com.kuafu.web.event.EventVo;
/**
 * <p> 人脸检测信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/faceDetectionInfo")
@Api(tags = {"人脸检测信息"})
public class FaceDetectionInfoController  {

    private final IFaceDetectionInfoService faceDetectionInfoService;

    private final MyEventService myEventService;

    private final ExcelProvider excelProvider;
    private final IStaticResourceService staticResourceService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody FaceDetectionInfoPageVO pageVO){
        IPage<FaceDetectionInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getUserInfoUserInfoId2() != null){
            queryWrapper.eq(FaceDetectionInfo::getUserInfoUserInfoId2, pageVO.getUserInfoUserInfoId2());
        }
            if(StringUtils.isNotEmpty(pageVO.getUploadImageResourceKey())) {
            queryWrapper.eq(FaceDetectionInfo::getUploadImageResourceKey, pageVO.getUploadImageResourceKey());
        }
            if(pageVO.getImpressionAge() != null){
            queryWrapper.eq(FaceDetectionInfo::getImpressionAge, pageVO.getImpressionAge());
        }
            if(StringUtils.isNotEmpty(pageVO.getAgingParts())) {
            queryWrapper.eq(FaceDetectionInfo::getAgingParts, pageVO.getAgingParts());
        }
            if(pageVO.getDeepAnalysisUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfo::getDeepAnalysisUnlocked, pageVO.getDeepAnalysisUnlocked());
        }
            if(pageVO.getCustomPlanUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfo::getCustomPlanUnlocked, pageVO.getCustomPlanUnlocked());
        }
        return ResultUtils.success(faceDetectionInfoService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody FaceDetectionInfoVO vo){
        LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId2() != null){
            queryWrapper.eq(FaceDetectionInfo::getUserInfoUserInfoId2, vo.getUserInfoUserInfoId2());
        }
            if(StringUtils.isNotEmpty(vo.getUploadImageResourceKey())) {
            queryWrapper.eq(FaceDetectionInfo::getUploadImageResourceKey, vo.getUploadImageResourceKey());
        }
                if(vo.getImpressionAge() != null){
            queryWrapper.eq(FaceDetectionInfo::getImpressionAge, vo.getImpressionAge());
        }
            if(StringUtils.isNotEmpty(vo.getAgingParts())) {
            queryWrapper.eq(FaceDetectionInfo::getAgingParts, vo.getAgingParts());
        }
                if(vo.getDeepAnalysisUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfo::getDeepAnalysisUnlocked, vo.getDeepAnalysisUnlocked());
        }
                if(vo.getCustomPlanUnlocked() != null){
            queryWrapper.eq(FaceDetectionInfo::getCustomPlanUnlocked, vo.getCustomPlanUnlocked());
        }
        return ResultUtils.success(faceDetectionInfoService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(FaceDetectionInfo::getFaceDetectionInfoId);

        List<FaceDetectionInfo> list =faceDetectionInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getFaceDetectionInfoId(), l.getFaceDetectionInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    @SensitiveFilter
    public BaseResponse add( @RequestBody FaceDetectionInfoVO vo) {
        FaceDetectionInfo entity =  FaceDetectionInfo.builder()
                    .userInfoUserInfoId2(vo.getUserInfoUserInfoId2())
                  .uploadImageResourceKey(vo.getUploadImageResourceKey() == null ? "default_resource_key" : vo.getUploadImageResourceKey())
                    .impressionAge(vo.getImpressionAge())
                    .agingParts(vo.getAgingParts())
                    .deepAnalysisUnlocked(vo.getDeepAnalysisUnlocked())
                    .customPlanUnlocked(vo.getCustomPlanUnlocked())
                .build();
        boolean flag =this.faceDetectionInfoService.save(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("faceDetectionInfo").data(entity).build());
                }

                final List<StaticResource> UploadImageImage = vo.getUploadImage();
                if (UploadImageImage  != null && !UploadImageImage.isEmpty()) {
                    UploadImageImage.forEach(i -> {
                        i.setRelateTableColumnName("upload_image");
                        i.setRelatedTableName("face_detection_info");
                        i.setRelatedTableKey(entity.getFaceDetectionInfoId());
                        i.setResourcePath(i.getResourceName());
                    });

                    staticResourceService.saveBatch(UploadImageImage);

                }

        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    @SensitiveFilter
    public BaseResponse update( @RequestBody FaceDetectionInfoVO vo) {
        FaceDetectionInfo entity =  FaceDetectionInfo.builder()
                    .faceDetectionInfoId(vo.getFaceDetectionInfoId())
                    .userInfoUserInfoId2(vo.getUserInfoUserInfoId2())
                    .uploadImageResourceKey(vo.getUploadImageResourceKey())
                    .impressionAge(vo.getImpressionAge())
                    .agingParts(vo.getAgingParts())
                    .deepAnalysisUnlocked(vo.getDeepAnalysisUnlocked())
                    .customPlanUnlocked(vo.getCustomPlanUnlocked())
                .build();
        boolean flag = this.faceDetectionInfoService.updateById(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("update").tableName("faceDetectionInfo").data(entity).build());
                }

                final LambdaQueryWrapper<StaticResource> upload_imagequeryWrapper = new LambdaQueryWrapper<>();
                upload_imagequeryWrapper
                        .eq(StaticResource::getRelatedTableName,"face_detection_info")
                        .eq(StaticResource::getRelateTableColumnName,"upload_image")
                        .eq(StaticResource::getRelatedTableKey,entity.getFaceDetectionInfoId());
                staticResourceService.remove(upload_imagequeryWrapper);


                final List<StaticResource> UploadImageImage = vo.getUploadImage();
                if (UploadImageImage  != null && !UploadImageImage.isEmpty()) {
                    UploadImageImage.forEach(i -> {
                        i.setRelateTableColumnName("upload_image");
                        i.setRelatedTableName("face_detection_info");
                        i.setRelatedTableKey(entity.getFaceDetectionInfoId());
                        if(StringUtils.isNotEmpty(i.getResourceName())) {
                            i.setResourcePath(i.getResourceName());
                        }
                    });

                    staticResourceService.saveBatch(UploadImageImage);

                }



        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer faceDetectionInfoId) {
        FaceDetectionInfo entity = this.faceDetectionInfoService.getById(faceDetectionInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer faceDetectionInfoId) {
        boolean flag = this.faceDetectionInfoService.removeById(faceDetectionInfoId);
        if (flag) {
            myEventService.publishEvent(EventVo.builder().model("delete").tableName("faceDetectionInfo").data( FaceDetectionInfo.builder().faceDetectionInfoId(faceDetectionInfoId).build() ).build());
        }
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 导出excel
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody FaceDetectionInfoPageVO pageVO) {

        LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();

                        if(pageVO.getUserInfoUserInfoId2() != null){
                            queryWrapper.eq(FaceDetectionInfo::getUserInfoUserInfoId2, pageVO.getUserInfoUserInfoId2());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getUploadImageResourceKey())) {
                            queryWrapper.eq(FaceDetectionInfo::getUploadImageResourceKey, pageVO.getUploadImageResourceKey());
                        }
                        if(pageVO.getImpressionAge() != null){
                            queryWrapper.eq(FaceDetectionInfo::getImpressionAge, pageVO.getImpressionAge());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getAgingParts())) {
                            queryWrapper.eq(FaceDetectionInfo::getAgingParts, pageVO.getAgingParts());
                        }
                        if(pageVO.getDeepAnalysisUnlocked() != null){
                            queryWrapper.eq(FaceDetectionInfo::getDeepAnalysisUnlocked, pageVO.getDeepAnalysisUnlocked());
                        }
                        if(pageVO.getCustomPlanUnlocked() != null){
                            queryWrapper.eq(FaceDetectionInfo::getCustomPlanUnlocked, pageVO.getCustomPlanUnlocked());
                        }
            List<FaceDetectionInfo> list = faceDetectionInfoService.list(queryWrapper);
            ExcelUtil<FaceDetectionInfo> util = new ExcelUtil<>(FaceDetectionInfo.class);
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
            excelProvider.pdfData(file, FaceDetectionInfo.class, faceDetectionInfoService::saveBatch);
        }
        else{
            excelProvider.importData(file, FaceDetectionInfo.class, faceDetectionInfoService::saveBatch);
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
                        Workbook workbook = excelProvider.downloadExcelTemplate(FaceDetectionInfo.class);
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
