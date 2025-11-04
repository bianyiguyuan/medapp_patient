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
import com.kuafu.web.entity.FaceDetectionInfo;
import com.kuafu.web.service.IFaceDetectionInfoService;
import com.kuafu.web.vo.FaceDetectionInfoPageVO;
import com.kuafu.web.vo.FaceDetectionInfoVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 人脸检测信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("FaceDetectionInfoControllerService")
@RequiredArgsConstructor
public class FaceDetectionInfoControllerService  {

    private final IFaceDetectionInfoService faceDetectionInfoService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( FaceDetectionInfoPageVO pageVO){
        IPage<FaceDetectionInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<FaceDetectionInfo> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(FaceDetectionInfo::getFaceDetectionInfoId);

            if(pageVO.getFaceDetectionInfoId() != null){
                queryWrapper.eq(FaceDetectionInfo::getFaceDetectionInfoId, pageVO.getFaceDetectionInfoId());
            }


            if(pageVO.getUserInfoUserInfoId2() != null){
                queryWrapper.eq(FaceDetectionInfo::getUserInfoUserInfoId2, pageVO.getUserInfoUserInfoId2());
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


        public BaseResponse list(  FaceDetectionInfoVO vo){
            LambdaQueryWrapper<FaceDetectionInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId2() != null){
                    queryWrapper.eq(FaceDetectionInfo::getUserInfoUserInfoId2, vo.getUserInfoUserInfoId2());
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


            @SensitiveFilter
            public BaseResponse add(  FaceDetectionInfoVO vo) {
                FaceDetectionInfo entity =  FaceDetectionInfo.builder()
                    .userInfoUserInfoId2(vo.getUserInfoUserInfoId2())
                    .impressionAge(vo.getImpressionAge())
                    .agingParts(vo.getAgingParts())
                    .deepAnalysisUnlocked(vo.getDeepAnalysisUnlocked())
                    .customPlanUnlocked(vo.getCustomPlanUnlocked())
                .build();







                boolean  f = transactionTemplate.execute(status -> {
                    try {

                boolean flag =this.faceDetectionInfoService.save(entity);


                final List<StaticResource> UploadImageImage = vo.getUploadImage();
                if (UploadImageImage  != null && !UploadImageImage .isEmpty()) {
                    UploadImageImage.forEach(i -> {
                        i.setRelateTableColumnName("upload_image");
                        i.setRelatedTableName("face_detection_info");
                        i.setResourceId(null);
                        i.setRelatedTableKey(entity.getFaceDetectionInfoId());
                    });
                }
                staticResourceService.saveBatch(UploadImageImage);




                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        status.setRollbackOnly();
                        throw e;
                    }
                });


                if(
                f
                        ){
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("face_detection_info").data(entity).build());
                }

                return
                                f
                              
                ? ResultUtils.success(entity.getFaceDetectionInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( FaceDetectionInfoVO vo) {
                FaceDetectionInfo entity =  FaceDetectionInfo.builder()
                    .faceDetectionInfoId(vo.getFaceDetectionInfoId())
                    .userInfoUserInfoId2(vo.getUserInfoUserInfoId2())
                    .impressionAge(vo.getImpressionAge())
                    .agingParts(vo.getAgingParts())
                    .deepAnalysisUnlocked(vo.getDeepAnalysisUnlocked())
                    .customPlanUnlocked(vo.getCustomPlanUnlocked())
                .build();


                boolean  f = transactionTemplate.execute(status -> {
                    try {

                        boolean flag = this.faceDetectionInfoService.saveOrUpdate(entity);



                        final List<StaticResource> UploadImageImage = vo.getUploadImage();

                        if (UploadImageImage  != null) {
                        final LambdaQueryWrapper<StaticResource> upload_imagequeryWrapper = new LambdaQueryWrapper<>();
                        upload_imagequeryWrapper.eq(StaticResource::getRelatedTableName,"face_detection_info").eq(StaticResource::getRelateTableColumnName,"upload_image").eq(StaticResource::getRelatedTableKey,entity.getFaceDetectionInfoId());
                        staticResourceService.remove(upload_imagequeryWrapper);
                        }


                        if (UploadImageImage  != null && !UploadImageImage .isEmpty()) {
                            UploadImageImage.forEach(i -> {
                                i.setRelateTableColumnName("upload_image");
                                i.setRelatedTableName("face_detection_info");
                                i.setRelatedTableKey(entity.getFaceDetectionInfoId());
                            });
                        }
                        staticResourceService.saveBatch(UploadImageImage);




                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        status.setRollbackOnly();
                        throw e;
                    }
                });


                return  
                f
                         ? ResultUtils.success(entity.getFaceDetectionInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( FaceDetectionInfoVO vo ) {
                FaceDetectionInfo entity = this.faceDetectionInfoService.getById(vo.getFaceDetectionInfoId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( FaceDetectionInfoVO vo) {
                boolean flag = this.faceDetectionInfoService.removeById(vo.getFaceDetectionInfoId());




                final LambdaQueryWrapper<StaticResource> upload_imagequeryWrapper = new LambdaQueryWrapper<>();
                upload_imagequeryWrapper.eq(StaticResource::getRelatedTableName,"face_detection_info").eq(StaticResource::getRelateTableColumnName,"upload_image").eq(StaticResource::getRelatedTableKey,vo.getFaceDetectionInfoId());
                staticResourceService.remove(upload_imagequeryWrapper);


                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
