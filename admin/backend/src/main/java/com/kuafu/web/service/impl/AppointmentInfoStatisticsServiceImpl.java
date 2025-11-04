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

import com.kuafu.web.mapper.AppointmentInfoStatisticsMapper;
import com.kuafu.web.entity.AppointmentInfo;
import com.kuafu.web.service.IAppointmentInfoStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> appointment_info 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("AppointmentInfoStatistics")
public class AppointmentInfoStatisticsServiceImpl extends ServiceImpl<AppointmentInfoStatisticsMapper, AppointmentInfo> implements IAppointmentInfoStatisticsService {
    @Resource
    private AppointmentInfoStatisticsMapper appointmentInfoStaticMapper;

                        @Override
                        public List<Object> appointment_info_statistic_79c41f2d_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_statistic_79c41f2d_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_statistic_68bf9dc9_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_statistic_68bf9dc9_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_statistic_2295eb27_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_statistic_2295eb27_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_statistic_ea7f3f64_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_statistic_ea7f3f64_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_statistic_bd73227b_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_statistic_bd73227b_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_statistic_a642f352_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_statistic_a642f352_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_appointment_date_datetime_statistic_51bb93f2_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_appointment_date_datetime_statistic_51bb93f2_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_appointment_date_datetime_statistic_2552826b_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_appointment_date_datetime_statistic_2552826b_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_appointment_date_datetime_statistic_9af84525_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_appointment_date_datetime_statistic_9af84525_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_status_enum_id_status_statistic_b808bb00_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_status_enum_id_status_statistic_b808bb00_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_status_enum_id_status_statistic_6a735f1e_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_status_enum_id_status_statistic_6a735f1e_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_info_status_enum_id_status_statistic_1bfef9e7_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentInfoStaticMapper.appointment_info_status_enum_id_status_statistic_1bfef9e7_count(queryWrapper);
                                }


}
