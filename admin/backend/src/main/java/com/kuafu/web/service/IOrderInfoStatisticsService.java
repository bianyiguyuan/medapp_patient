package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.OrderInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  order_info 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IOrderInfoStatisticsService extends IService<OrderInfo> {
        List<Object> order_info_statistic_78be52de_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_cac602ba_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_c1f3da7b_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_b678dff5_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_13a72ffb_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_2549672a_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_47128f62_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_9340d0f4_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_55633d24_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_ecbc57bf_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_634a7ba6_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_statistic_03b9e7eb_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_order_status_enum_id_status_statistic_546711ee_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_order_status_enum_id_status_statistic_a3491f78_count(LambdaQueryWrapper queryWrapper);

        List<Object> order_info_order_status_enum_id_status_statistic_43727b26_count(LambdaQueryWrapper queryWrapper);

}
