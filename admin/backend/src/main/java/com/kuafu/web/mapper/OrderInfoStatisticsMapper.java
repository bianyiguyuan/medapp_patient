package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.OrderInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> order_info Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface OrderInfoStatisticsMapper extends BaseMapper<OrderInfo> {

                        List<Object> order_info_statistic_78be52de_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_cac602ba_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_c1f3da7b_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_b678dff5_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_13a72ffb_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_2549672a_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_47128f62_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_9340d0f4_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_55633d24_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_ecbc57bf_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_634a7ba6_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_statistic_03b9e7eb_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_order_status_enum_id_status_statistic_546711ee_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_order_status_enum_id_status_statistic_a3491f78_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_info_order_status_enum_id_status_statistic_43727b26_count(@Param("ew") Wrapper queryWrapper);

}
