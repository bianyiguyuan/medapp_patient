package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.AppointmentInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> appointment_info Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface AppointmentInfoStatisticsMapper extends BaseMapper<AppointmentInfo> {

                        List<Object> appointment_info_statistic_79c41f2d_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_statistic_68bf9dc9_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_statistic_2295eb27_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_statistic_ea7f3f64_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_statistic_bd73227b_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_statistic_a642f352_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_appointment_date_datetime_statistic_51bb93f2_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_appointment_date_datetime_statistic_2552826b_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_appointment_date_datetime_statistic_9af84525_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_status_enum_id_status_statistic_b808bb00_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_status_enum_id_status_statistic_6a735f1e_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> appointment_info_status_enum_id_status_statistic_1bfef9e7_count(@Param("ew") Wrapper queryWrapper);

}
