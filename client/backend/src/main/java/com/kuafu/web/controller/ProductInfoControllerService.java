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
import com.kuafu.web.entity.ProductInfo;
import com.kuafu.web.service.IProductInfoService;
import com.kuafu.web.vo.ProductInfoPageVO;
import com.kuafu.web.vo.ProductInfoVO;
import com.kuafu.common.util.QueryUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


/**
 * <p> 品牌商品信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Service("ProductInfoControllerService")
@RequiredArgsConstructor
public class ProductInfoControllerService  {

    private final IProductInfoService productInfoService;

    private final IStaticResourceService staticResourceService;

    private final TransactionTemplate transactionTemplate;

    private final MyEventService myEventService;



    public BaseResponse page( ProductInfoPageVO pageVO){
        IPage<ProductInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());

         final QueryWrapper<ProductInfo> objectQueryWrapper = new QueryWrapper<>();

        QueryUtils.getQueryWrapper(objectQueryWrapper,pageVO);
        LambdaQueryWrapper<ProductInfo> queryWrapper = objectQueryWrapper.lambda();
        queryWrapper.orderByDesc(ProductInfo::getProductInfoId);

            if(pageVO.getProductInfoId() != null){
                queryWrapper.eq(ProductInfo::getProductInfoId, pageVO.getProductInfoId());
            }


        if(StringUtils.isNotEmpty(pageVO.getProductName())) {
//                        queryWrapper.like(ProductInfo::getProductName, pageVO.getProductName());
                        String s_string = pageVO.getProductName();
                String[] strings = s_string.split(" ");
                queryWrapper.and(wrapper -> {
                    for (int i = 0; i < strings.length; i++) {
                        String s = strings[i];
                        if (StringUtils.isNotEmpty(s)) {
                            final String trim = s.trim();
                            wrapper.like(ProductInfo::getProductName, trim);
                            if (i != strings.length - 1) {
                                wrapper.or();
                            }
                        }
                    }
                });
            }


            if(pageVO.getPrice() != null){
                queryWrapper.eq(ProductInfo::getPrice, pageVO.getPrice());
            }


            if(pageVO.getCouponAmount() != null){
                queryWrapper.eq(ProductInfo::getCouponAmount, pageVO.getCouponAmount());
            }


        if(StringUtils.isNotEmpty(pageVO.getMiniProgramPath())) {
                queryWrapper.eq(ProductInfo::getMiniProgramPath, pageVO.getMiniProgramPath());
            }

            return ResultUtils.success(productInfoService.page(page, queryWrapper));
        }


        public BaseResponse list(  ProductInfoVO vo){
            LambdaQueryWrapper<ProductInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getProductName())) {
                            queryWrapper.like(ProductInfo::getProductName, vo.getProductName());
                }
                if(vo.getPrice() != null){
                    queryWrapper.eq(ProductInfo::getPrice, vo.getPrice());
                }
                if(vo.getCouponAmount() != null){
                    queryWrapper.eq(ProductInfo::getCouponAmount, vo.getCouponAmount());
                }
            if(StringUtils.isNotEmpty(vo.getMiniProgramPath())) {
                    queryWrapper.eq(ProductInfo::getMiniProgramPath, vo.getMiniProgramPath());
                }
                return ResultUtils.success(productInfoService.list(queryWrapper));
            }


            @SensitiveFilter
            public BaseResponse add(  ProductInfoVO vo) {
                ProductInfo entity =  ProductInfo.builder()
                    .productName(vo.getProductName())
                    .price(vo.getPrice())
                    .couponAmount(vo.getCouponAmount())
                    .miniProgramPath(vo.getMiniProgramPath())
                .build();







                boolean  f = transactionTemplate.execute(status -> {
                    try {

                boolean flag =this.productInfoService.save(entity);


                final List<StaticResource> ImageImage = vo.getImage();
                if (ImageImage  != null && !ImageImage .isEmpty()) {
                    ImageImage.forEach(i -> {
                        i.setRelateTableColumnName("image");
                        i.setRelatedTableName("product_info");
                        i.setResourceId(null);
                        i.setRelatedTableKey(entity.getProductInfoId());
                    });
                }
                staticResourceService.saveBatch(ImageImage);




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
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("product_info").data(entity).build());
                }

                return
                                f
                              
                ? ResultUtils.success(entity.getProductInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }


            @SensitiveFilter
            public BaseResponse update( ProductInfoVO vo) {
                ProductInfo entity =  ProductInfo.builder()
                    .productInfoId(vo.getProductInfoId())
                    .productName(vo.getProductName())
                    .price(vo.getPrice())
                    .couponAmount(vo.getCouponAmount())
                    .miniProgramPath(vo.getMiniProgramPath())
                .build();


                boolean  f = transactionTemplate.execute(status -> {
                    try {

                        boolean flag = this.productInfoService.saveOrUpdate(entity);



                        final List<StaticResource> ImageImage = vo.getImage();

                        if (ImageImage  != null) {
                        final LambdaQueryWrapper<StaticResource> imagequeryWrapper = new LambdaQueryWrapper<>();
                        imagequeryWrapper.eq(StaticResource::getRelatedTableName,"product_info").eq(StaticResource::getRelateTableColumnName,"image").eq(StaticResource::getRelatedTableKey,entity.getProductInfoId());
                        staticResourceService.remove(imagequeryWrapper);
                        }


                        if (ImageImage  != null && !ImageImage .isEmpty()) {
                            ImageImage.forEach(i -> {
                                i.setRelateTableColumnName("image");
                                i.setRelatedTableName("product_info");
                                i.setRelatedTableKey(entity.getProductInfoId());
                            });
                        }
                        staticResourceService.saveBatch(ImageImage);




                        return true;
                    } catch (Exception e) {
                        e.printStackTrace();
                        status.setRollbackOnly();
                        throw e;
                    }
                });


                return  
                f
                         ? ResultUtils.success(entity.getProductInfoId()) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse get( ProductInfoVO vo ) {
                ProductInfo entity = this.productInfoService.getById(vo.getProductInfoId());
                return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }



            public BaseResponse delete( ProductInfoVO vo) {
                boolean flag = this.productInfoService.removeById(vo.getProductInfoId());




                final LambdaQueryWrapper<StaticResource> imagequeryWrapper = new LambdaQueryWrapper<>();
                imagequeryWrapper.eq(StaticResource::getRelatedTableName,"product_info").eq(StaticResource::getRelateTableColumnName,"image").eq(StaticResource::getRelatedTableKey,vo.getProductInfoId());
                staticResourceService.remove(imagequeryWrapper);


                return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
            }

        }
