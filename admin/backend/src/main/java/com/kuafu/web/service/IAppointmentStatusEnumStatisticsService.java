package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.AppointmentStatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  appointment_status_enum 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IAppointmentStatusEnumStatisticsService extends IService<AppointmentStatusEnum> {
        List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_c8bb39e7_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_f5b4188e_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_d95ed513_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_status_enum_status_name_status_statistic_249d4459_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_status_enum_status_name_status_statistic_3b4314ee_count(LambdaQueryWrapper queryWrapper);

        List<Object> appointment_status_enum_status_name_status_statistic_335ff694_count(LambdaQueryWrapper queryWrapper);

}
