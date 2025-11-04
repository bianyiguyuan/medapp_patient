package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.AppointmentInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  appointment_info 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IAppointmentInfoStatisticsService extends IService<AppointmentInfo> {
        List<Object> appointment_info_statistic_79c41f2d_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_statistic_68bf9dc9_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_statistic_2295eb27_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_statistic_ea7f3f64_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_statistic_bd73227b_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_statistic_a642f352_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_appointment_date_datetime_statistic_51bb93f2_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_appointment_date_datetime_statistic_2552826b_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_appointment_date_datetime_statistic_9af84525_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_status_enum_id_status_statistic_b808bb00_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_status_enum_id_status_statistic_6a735f1e_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_info_status_enum_id_status_statistic_1bfef9e7_count(LambdaQueryWrapper queryWrapper);

}
