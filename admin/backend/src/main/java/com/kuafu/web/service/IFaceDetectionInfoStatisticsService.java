package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.FaceDetectionInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  face_detection_info 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IFaceDetectionInfoStatisticsService extends IService<FaceDetectionInfo> {
        List<Object> face_detection_info_statistic_bd49b0c1_count(LambdaQueryWrapper queryWrapper);

        List<Object> face_detection_info_statistic_bd9cef3c_count(LambdaQueryWrapper queryWrapper);

        List<Object> face_detection_info_statistic_2006561b_count(LambdaQueryWrapper queryWrapper);

}
