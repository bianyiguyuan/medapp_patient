package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.OrderStatusEnum;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> order_status_enum Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface OrderStatusEnumStatisticsMapper extends BaseMapper<OrderStatusEnum> {

                        List<Object> order_status_enum_order_status_enum_id_status_statistic_9bc9ef17_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_status_enum_order_status_enum_id_status_statistic_2bcfa4b6_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_status_enum_order_status_enum_id_status_statistic_da23ad10_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_status_enum_status_name_status_statistic_a8cf06c4_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_status_enum_status_name_status_statistic_50ddd169_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> order_status_enum_status_name_status_statistic_f7be0462_count(@Param("ew") Wrapper queryWrapper);

}
