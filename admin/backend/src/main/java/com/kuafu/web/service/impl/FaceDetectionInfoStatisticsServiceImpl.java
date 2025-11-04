package com.kuafu.web.service.impl;

import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kuafu.web.mapper.FaceDetectionInfoStatisticsMapper;
import com.kuafu.web.entity.FaceDetectionInfo;
import com.kuafu.web.service.IFaceDetectionInfoStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> face_detection_info 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("FaceDetectionInfoStatistics")
public class FaceDetectionInfoStatisticsServiceImpl extends ServiceImpl<FaceDetectionInfoStatisticsMapper, FaceDetectionInfo> implements IFaceDetectionInfoStatisticsService {
    @Resource
    private FaceDetectionInfoStatisticsMapper faceDetectionInfoStaticMapper;

                        @Override
                        public List<Object> face_detection_info_statistic_bd49b0c1_count(LambdaQueryWrapper queryWrapper) {
                                return faceDetectionInfoStaticMapper.face_detection_info_statistic_bd49b0c1_count(queryWrapper);
                                }


                        @Override
                        public List<Object> face_detection_info_statistic_bd9cef3c_count(LambdaQueryWrapper queryWrapper) {
                                return faceDetectionInfoStaticMapper.face_detection_info_statistic_bd9cef3c_count(queryWrapper);
                                }


                        @Override
                        public List<Object> face_detection_info_statistic_2006561b_count(LambdaQueryWrapper queryWrapper) {
                                return faceDetectionInfoStaticMapper.face_detection_info_statistic_2006561b_count(queryWrapper);
                                }


}
