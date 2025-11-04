package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.FaceDetectionInfoAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  人脸检测信息 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IFaceDetectionInfoAllService extends IService<FaceDetectionInfoAll> {
        List<FaceDetectionInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper);
        List<FaceDetectionInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper);

        IPage pageNew(IPage<FaceDetectionInfoAll> page, PageRequest pageRequest, LambdaQueryWrapper<FaceDetectionInfoAll> queryWrapper);
        }
