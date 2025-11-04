package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.AppointmentStatusEnum;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> appointment_status_enum Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface AppointmentStatusEnumStatisticsMapper extends BaseMapper<AppointmentStatusEnum> {

                        List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_c8bb39e7_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_f5b4188e_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_status_enum_appointment_status_enum_id_status_statistic_d95ed513_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_status_enum_status_name_status_statistic_249d4459_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_status_enum_status_name_status_statistic_3b4314ee_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_status_enum_status_name_status_statistic_335ff694_count(@Param("ew") Wrapper queryWrapper);

}
