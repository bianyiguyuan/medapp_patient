package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.FaceDetectionInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> face_detection_info Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface FaceDetectionInfoStatisticsMapper extends BaseMapper<FaceDetectionInfo> {

                        List<Object> face_detection_info_statistic_bd49b0c1_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> face_detection_info_statistic_bd9cef3c_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> face_detection_info_statistic_2006561b_count(@Param("ew") Wrapper queryWrapper);

}
