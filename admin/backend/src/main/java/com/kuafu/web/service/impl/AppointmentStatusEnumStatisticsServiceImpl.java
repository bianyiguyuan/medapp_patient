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

import com.kuafu.web.mapper.AppointmentStatusEnumStatisticsMapper;
import com.kuafu.web.entity.AppointmentStatusEnum;
import com.kuafu.web.service.IAppointmentStatusEnumStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> appointment_status_enum 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("AppointmentStatusEnumStatistics")
public class AppointmentStatusEnumStatisticsServiceImpl extends ServiceImpl<AppointmentStatusEnumStatisticsMapper, AppointmentStatusEnum> implements IAppointmentStatusEnumStatisticsService {
    @Resource
    private AppointmentStatusEnumStatisticsMapper appointmentStatusEnumStaticMapper;

                        @Override
                        public List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_c8bb39e7_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentStatusEnumStaticMapper.appointment_status_enum_appointment_status_enum_id_status_statistic_c8bb39e7_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_f5b4188e_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentStatusEnumStaticMapper.appointment_status_enum_appointment_status_enum_id_status_statistic_f5b4188e_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_d95ed513_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentStatusEnumStaticMapper.appointment_status_enum_appointment_status_enum_id_status_statistic_d95ed513_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_status_enum_status_name_status_statistic_249d4459_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentStatusEnumStaticMapper.appointment_status_enum_status_name_status_statistic_249d4459_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_status_enum_status_name_status_statistic_3b4314ee_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentStatusEnumStaticMapper.appointment_status_enum_status_name_status_statistic_3b4314ee_count(queryWrapper);
                                }


                        @Override
                        public List<Object> appointment_status_enum_status_name_status_statistic_335ff694_count(LambdaQueryWrapper queryWrapper) {
                                return appointmentStatusEnumStaticMapper.appointment_status_enum_status_name_status_statistic_335ff694_count(queryWrapper);
                                }


}
