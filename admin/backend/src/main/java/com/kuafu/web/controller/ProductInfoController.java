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
import com.kuafu.web.entity.ProductInfo;
import com.kuafu.web.service.IProductInfoService;
import com.kuafu.web.vo.ProductInfoPageVO;
import com.kuafu.web.vo.ProductInfoVO;
import com.kuafu.web.event.MyEventService;
import com.kuafu.web.event.EventVo;
/**
 * <p> 品牌商品信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/productInfo")
@Api(tags = {"品牌商品信息"})
public class ProductInfoController  {

    private final IProductInfoService productInfoService;

    private final MyEventService myEventService;

    private final ExcelProvider excelProvider;
    private final IStaticResourceService staticResourceService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody ProductInfoPageVO pageVO){
        IPage<ProductInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<ProductInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(pageVO.getProductName())) {
            queryWrapper.like(ProductInfo::getProductName, pageVO.getProductName());
        }
            if(pageVO.getPrice() != null){
            queryWrapper.eq(ProductInfo::getPrice, pageVO.getPrice());
        }
            if(StringUtils.isNotEmpty(pageVO.getImageResourceKey())) {
            queryWrapper.eq(ProductInfo::getImageResourceKey, pageVO.getImageResourceKey());
        }
            if(pageVO.getCouponAmount() != null){
            queryWrapper.eq(ProductInfo::getCouponAmount, pageVO.getCouponAmount());
        }
            if(StringUtils.isNotEmpty(pageVO.getMiniProgramPath())) {
            queryWrapper.eq(ProductInfo::getMiniProgramPath, pageVO.getMiniProgramPath());
        }
        return ResultUtils.success(productInfoService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody ProductInfoVO vo){
        LambdaQueryWrapper<ProductInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getProductName())) {
            queryWrapper.like(ProductInfo::getProductName, vo.getProductName());
        }
                if(vo.getPrice() != null){
            queryWrapper.eq(ProductInfo::getPrice, vo.getPrice());
        }
            if(StringUtils.isNotEmpty(vo.getImageResourceKey())) {
            queryWrapper.eq(ProductInfo::getImageResourceKey, vo.getImageResourceKey());
        }
                if(vo.getCouponAmount() != null){
            queryWrapper.eq(ProductInfo::getCouponAmount, vo.getCouponAmount());
        }
            if(StringUtils.isNotEmpty(vo.getMiniProgramPath())) {
            queryWrapper.eq(ProductInfo::getMiniProgramPath, vo.getMiniProgramPath());
        }
        return ResultUtils.success(productInfoService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<ProductInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(ProductInfo::getProductInfoId);

        List<ProductInfo> list =productInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getProductInfoId(), l.getProductInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    @SensitiveFilter
    public BaseResponse add( @RequestBody ProductInfoVO vo) {
        ProductInfo entity =  ProductInfo.builder()
                    .productName(vo.getProductName())
                    .price(vo.getPrice())
                  .imageResourceKey(vo.getImageResourceKey() == null ? "default_resource_key" : vo.getImageResourceKey())
                    .couponAmount(vo.getCouponAmount())
                    .miniProgramPath(vo.getMiniProgramPath())
                .build();
        boolean flag =this.productInfoService.save(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("productInfo").data(entity).build());
                }

                final List<StaticResource> ImageImage = vo.getImage();
                if (ImageImage  != null && !ImageImage.isEmpty()) {
                    ImageImage.forEach(i -> {
                        i.setRelateTableColumnName("image");
                        i.setRelatedTableName("product_info");
                        i.setRelatedTableKey(entity.getProductInfoId());
                        i.setResourcePath(i.getResourceName());
                    });

                    staticResourceService.saveBatch(ImageImage);

                }

        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    @SensitiveFilter
    public BaseResponse update( @RequestBody ProductInfoVO vo) {
        ProductInfo entity =  ProductInfo.builder()
                    .productInfoId(vo.getProductInfoId())
                    .productName(vo.getProductName())
                    .price(vo.getPrice())
                    .imageResourceKey(vo.getImageResourceKey())
                    .couponAmount(vo.getCouponAmount())
                    .miniProgramPath(vo.getMiniProgramPath())
                .build();
        boolean flag = this.productInfoService.updateById(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("update").tableName("productInfo").data(entity).build());
                }

                final LambdaQueryWrapper<StaticResource> imagequeryWrapper = new LambdaQueryWrapper<>();
                imagequeryWrapper
                        .eq(StaticResource::getRelatedTableName,"product_info")
                        .eq(StaticResource::getRelateTableColumnName,"image")
                        .eq(StaticResource::getRelatedTableKey,entity.getProductInfoId());
                staticResourceService.remove(imagequeryWrapper);


                final List<StaticResource> ImageImage = vo.getImage();
                if (ImageImage  != null && !ImageImage.isEmpty()) {
                    ImageImage.forEach(i -> {
                        i.setRelateTableColumnName("image");
                        i.setRelatedTableName("product_info");
                        i.setRelatedTableKey(entity.getProductInfoId());
                        if(StringUtils.isNotEmpty(i.getResourceName())) {
                            i.setResourcePath(i.getResourceName());
                        }
                    });

                    staticResourceService.saveBatch(ImageImage);

                }



        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer productInfoId) {
        ProductInfo entity = this.productInfoService.getById(productInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer productInfoId) {
        boolean flag = this.productInfoService.removeById(productInfoId);
        if (flag) {
            myEventService.publishEvent(EventVo.builder().model("delete").tableName("productInfo").data( ProductInfo.builder().productInfoId(productInfoId).build() ).build());
        }
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 导出excel
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody ProductInfoPageVO pageVO) {

        LambdaQueryWrapper<ProductInfo> queryWrapper = new LambdaQueryWrapper<>();

                    if(StringUtils.isNotEmpty(pageVO.getProductName())) {
                                    queryWrapper.like(ProductInfo::getProductName, pageVO.getProductName());
                        }
                        if(pageVO.getPrice() != null){
                            queryWrapper.eq(ProductInfo::getPrice, pageVO.getPrice());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getImageResourceKey())) {
                            queryWrapper.eq(ProductInfo::getImageResourceKey, pageVO.getImageResourceKey());
                        }
                        if(pageVO.getCouponAmount() != null){
                            queryWrapper.eq(ProductInfo::getCouponAmount, pageVO.getCouponAmount());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getMiniProgramPath())) {
                            queryWrapper.eq(ProductInfo::getMiniProgramPath, pageVO.getMiniProgramPath());
                        }
            List<ProductInfo> list = productInfoService.list(queryWrapper);
            ExcelUtil<ProductInfo> util = new ExcelUtil<>(ProductInfo.class);
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
            excelProvider.pdfData(file, ProductInfo.class, productInfoService::saveBatch);
        }
        else{
            excelProvider.importData(file, ProductInfo.class, productInfoService::saveBatch);
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
                        Workbook workbook = excelProvider.downloadExcelTemplate(ProductInfo.class);
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
