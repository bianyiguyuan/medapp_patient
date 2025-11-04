package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.OrderStatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  order_status_enum 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IOrderStatusEnumStatisticsService extends IService<OrderStatusEnum> {
        List<Object> order_status_enum_order_status_enum_id_status_statistic_9bc9ef17_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_status_enum_order_status_enum_id_status_statistic_2bcfa4b6_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_status_enum_order_status_enum_id_status_statistic_da23ad10_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_status_enum_status_name_status_statistic_a8cf06c4_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_status_enum_status_name_status_statistic_50ddd169_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_status_enum_status_name_status_statistic_f7be0462_count(LambdaQueryWrapper queryWrapper);

}
