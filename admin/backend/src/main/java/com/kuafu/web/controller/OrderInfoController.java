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
import com.kuafu.web.entity.OrderInfo;
import com.kuafu.web.service.IOrderInfoService;
import com.kuafu.web.vo.OrderInfoPageVO;
import com.kuafu.web.vo.OrderInfoVO;
import com.kuafu.web.event.MyEventService;
import com.kuafu.web.event.EventVo;
/**
 * <p> 订单信息 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/orderInfo")
@Api(tags = {"订单信息"})
public class OrderInfoController  {

    private final IOrderInfoService orderInfoService;

    private final MyEventService myEventService;

    private final ExcelProvider excelProvider;
    private final IStaticResourceService staticResourceService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody OrderInfoPageVO pageVO){
        IPage<OrderInfo> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

            if(pageVO.getUserInfoUserInfoId5() != null){
            queryWrapper.eq(OrderInfo::getUserInfoUserInfoId5, pageVO.getUserInfoUserInfoId5());
        }
            if(pageVO.getProductInfoProductInfoId() != null){
            queryWrapper.eq(OrderInfo::getProductInfoProductInfoId, pageVO.getProductInfoProductInfoId());
        }
            if(pageVO.getQuantity() != null){
            queryWrapper.eq(OrderInfo::getQuantity, pageVO.getQuantity());
        }
            if(pageVO.getTotalPrice() != null){
            queryWrapper.eq(OrderInfo::getTotalPrice, pageVO.getTotalPrice());
        }
            if(pageVO.getOrderStatusEnumId() != null){
            queryWrapper.eq(OrderInfo::getOrderStatusEnumId, pageVO.getOrderStatusEnumId());
        }
            if(StringUtils.isNotEmpty(pageVO.getPaymentOrderNo())) {
            queryWrapper.eq(OrderInfo::getPaymentOrderNo, pageVO.getPaymentOrderNo());
        }
        return ResultUtils.success(orderInfoService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody OrderInfoVO vo){
        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

                if(vo.getUserInfoUserInfoId5() != null){
            queryWrapper.eq(OrderInfo::getUserInfoUserInfoId5, vo.getUserInfoUserInfoId5());
        }
                if(vo.getProductInfoProductInfoId() != null){
            queryWrapper.eq(OrderInfo::getProductInfoProductInfoId, vo.getProductInfoProductInfoId());
        }
                if(vo.getQuantity() != null){
            queryWrapper.eq(OrderInfo::getQuantity, vo.getQuantity());
        }
                if(vo.getTotalPrice() != null){
            queryWrapper.eq(OrderInfo::getTotalPrice, vo.getTotalPrice());
        }
                if(vo.getOrderStatusEnumId() != null){
            queryWrapper.eq(OrderInfo::getOrderStatusEnumId, vo.getOrderStatusEnumId());
        }
            if(StringUtils.isNotEmpty(vo.getPaymentOrderNo())) {
            queryWrapper.eq(OrderInfo::getPaymentOrderNo, vo.getPaymentOrderNo());
        }
        return ResultUtils.success(orderInfoService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(OrderInfo::getOrderInfoId);

        List<OrderInfo> list =orderInfoService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getOrderInfoId(), l.getOrderInfoId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    @SensitiveFilter
    public BaseResponse add( @RequestBody OrderInfoVO vo) {
        OrderInfo entity =  OrderInfo.builder()
                    .userInfoUserInfoId5(vo.getUserInfoUserInfoId5())
                    .productInfoProductInfoId(vo.getProductInfoProductInfoId())
                    .quantity(vo.getQuantity())
                    .totalPrice(vo.getTotalPrice())
                    .orderStatusEnumId(vo.getOrderStatusEnumId())
                    .paymentOrderNo(vo.getPaymentOrderNo())
                .build();
        boolean flag =this.orderInfoService.save(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("orderInfo").data(entity).build());
                }


        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    @SensitiveFilter
    public BaseResponse update( @RequestBody OrderInfoVO vo) {
        OrderInfo entity =  OrderInfo.builder()
                    .orderInfoId(vo.getOrderInfoId())
                    .userInfoUserInfoId5(vo.getUserInfoUserInfoId5())
                    .productInfoProductInfoId(vo.getProductInfoProductInfoId())
                    .quantity(vo.getQuantity())
                    .totalPrice(vo.getTotalPrice())
                    .orderStatusEnumId(vo.getOrderStatusEnumId())
                    .paymentOrderNo(vo.getPaymentOrderNo())
                .build();
        boolean flag = this.orderInfoService.updateById(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("update").tableName("orderInfo").data(entity).build());
                }



        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer orderInfoId) {
        OrderInfo entity = this.orderInfoService.getById(orderInfoId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer orderInfoId) {
        boolean flag = this.orderInfoService.removeById(orderInfoId);
        if (flag) {
            myEventService.publishEvent(EventVo.builder().model("delete").tableName("orderInfo").data( OrderInfo.builder().orderInfoId(orderInfoId).build() ).build());
        }
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 导出excel
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody OrderInfoPageVO pageVO) {

        LambdaQueryWrapper<OrderInfo> queryWrapper = new LambdaQueryWrapper<>();

                        if(pageVO.getUserInfoUserInfoId5() != null){
                            queryWrapper.eq(OrderInfo::getUserInfoUserInfoId5, pageVO.getUserInfoUserInfoId5());
                        }
                        if(pageVO.getProductInfoProductInfoId() != null){
                            queryWrapper.eq(OrderInfo::getProductInfoProductInfoId, pageVO.getProductInfoProductInfoId());
                        }
                        if(pageVO.getQuantity() != null){
                            queryWrapper.eq(OrderInfo::getQuantity, pageVO.getQuantity());
                        }
                        if(pageVO.getTotalPrice() != null){
                            queryWrapper.eq(OrderInfo::getTotalPrice, pageVO.getTotalPrice());
                        }
                        if(pageVO.getOrderStatusEnumId() != null){
                            queryWrapper.eq(OrderInfo::getOrderStatusEnumId, pageVO.getOrderStatusEnumId());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getPaymentOrderNo())) {
                            queryWrapper.eq(OrderInfo::getPaymentOrderNo, pageVO.getPaymentOrderNo());
                        }
            List<OrderInfo> list = orderInfoService.list(queryWrapper);
            ExcelUtil<OrderInfo> util = new ExcelUtil<>(OrderInfo.class);
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
            excelProvider.pdfData(file, OrderInfo.class, orderInfoService::saveBatch);
        }
        else{
            excelProvider.importData(file, OrderInfo.class, orderInfoService::saveBatch);
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
                        Workbook workbook = excelProvider.downloadExcelTemplate(OrderInfo.class);
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
