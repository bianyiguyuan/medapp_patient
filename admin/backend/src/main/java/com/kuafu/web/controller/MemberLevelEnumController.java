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
import com.kuafu.web.entity.MemberLevelEnum;
import com.kuafu.web.service.IMemberLevelEnumService;
import com.kuafu.web.vo.MemberLevelEnumPageVO;
import com.kuafu.web.vo.MemberLevelEnumVO;
import com.kuafu.web.event.MyEventService;
import com.kuafu.web.event.EventVo;
/**
 * <p> 会员等级 接口 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/memberLevelEnum")
@Api(tags = {"会员等级"})
public class MemberLevelEnumController  {

    private final IMemberLevelEnumService memberLevelEnumService;

    private final MyEventService myEventService;

    private final ExcelProvider excelProvider;
    private final IStaticResourceService staticResourceService;

    @PostMapping("page")
    @ApiOperation("分页")
    public BaseResponse page( @RequestBody MemberLevelEnumPageVO pageVO){
        IPage<MemberLevelEnum> page = new Page<>(pageVO.getCurrent(), pageVO.getPageSize());
        LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(pageVO.getLevelName())) {
            queryWrapper.like(MemberLevelEnum::getLevelName, pageVO.getLevelName());
        }
            if(StringUtils.isNotEmpty(pageVO.getDescription())) {
            queryWrapper.eq(MemberLevelEnum::getDescription, pageVO.getDescription());
        }
        return ResultUtils.success(memberLevelEnumService.page(page, queryWrapper));
    }

    @PostMapping("list")
    @ApiOperation("列表")
    public BaseResponse list( @RequestBody MemberLevelEnumVO vo){
        LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

            if(StringUtils.isNotEmpty(vo.getLevelName())) {
            queryWrapper.like(MemberLevelEnum::getLevelName, vo.getLevelName());
        }
            if(StringUtils.isNotEmpty(vo.getDescription())) {
            queryWrapper.eq(MemberLevelEnum::getDescription, vo.getDescription());
        }
        return ResultUtils.success(memberLevelEnumService.list(queryWrapper));
    }


            @PostMapping("get_select_list")
            @ApiOperation("获取所有的下拉列表")
            public BaseResponse get_select_list( ){
                LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.select(MemberLevelEnum::getMemberLevelEnumId);

        List<MemberLevelEnum> list =memberLevelEnumService.list(queryWrapper);
        final List<SelectVO> selectVOS = list.stream().map(l -> new SelectVO(l.getMemberLevelEnumId(), l.getMemberLevelEnumId().toString())).collect(Collectors.toList());
        return ResultUtils.success(selectVOS);

                }

    @PostMapping("add")
    @ApiOperation("新增")
    @SensitiveFilter
    public BaseResponse add( @RequestBody MemberLevelEnumVO vo) {
        MemberLevelEnum entity =  MemberLevelEnum.builder()
                    .levelName(vo.getLevelName())
                    .description(vo.getDescription())
                .build();
        boolean flag =this.memberLevelEnumService.save(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("add").tableName("memberLevelEnum").data(entity).build());
                }


        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    @PutMapping("update")
    @ApiOperation("更新")
    @SensitiveFilter
    public BaseResponse update( @RequestBody MemberLevelEnumVO vo) {
        MemberLevelEnum entity =  MemberLevelEnum.builder()
                    .memberLevelEnumId(vo.getMemberLevelEnumId())
                    .levelName(vo.getLevelName())
                    .description(vo.getDescription())
                .build();
        boolean flag = this.memberLevelEnumService.updateById(entity);
                if (flag) {
                    myEventService.publishEvent(EventVo.builder().model("update").tableName("memberLevelEnum").data(entity).build());
                }



        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @GetMapping("get/{id}")
    @ApiOperation("根据Id查询")
    public BaseResponse get(@PathVariable(value="id") Integer memberLevelEnumId) {
        MemberLevelEnum entity = this.memberLevelEnumService.getById(memberLevelEnumId);
        return entity!=null ? ResultUtils.success(entity) : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }


    @DeleteMapping("delete/{id}")
    @ApiOperation("删除")
    public BaseResponse delete(@PathVariable(value="id") Integer memberLevelEnumId) {
        boolean flag = this.memberLevelEnumService.removeById(memberLevelEnumId);
        if (flag) {
            myEventService.publishEvent(EventVo.builder().model("delete").tableName("memberLevelEnum").data( MemberLevelEnum.builder().memberLevelEnumId(memberLevelEnumId).build() ).build());
        }
        return flag ? ResultUtils.success() : ResultUtils.error(ErrorCode.OPERATION_ERROR);
    }

    /**
     * 导出excel
     */
    @PostMapping("/export")
    public void export(HttpServletResponse response, @RequestBody MemberLevelEnumPageVO pageVO) {

        LambdaQueryWrapper<MemberLevelEnum> queryWrapper = new LambdaQueryWrapper<>();

                    if(StringUtils.isNotEmpty(pageVO.getLevelName())) {
                                    queryWrapper.like(MemberLevelEnum::getLevelName, pageVO.getLevelName());
                        }
                    if(StringUtils.isNotEmpty(pageVO.getDescription())) {
                            queryWrapper.eq(MemberLevelEnum::getDescription, pageVO.getDescription());
                        }
            List<MemberLevelEnum> list = memberLevelEnumService.list(queryWrapper);
            ExcelUtil<MemberLevelEnum> util = new ExcelUtil<>(MemberLevelEnum.class);
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
            excelProvider.pdfData(file, MemberLevelEnum.class, memberLevelEnumService::saveBatch);
        }
        else{
            excelProvider.importData(file, MemberLevelEnum.class, memberLevelEnumService::saveBatch);
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
                        Workbook workbook = excelProvider.downloadExcelTemplate(MemberLevelEnum.class);
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
