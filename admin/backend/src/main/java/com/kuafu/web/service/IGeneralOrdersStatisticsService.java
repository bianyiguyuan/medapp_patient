package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.GeneralOrders;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  general_orders 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IGeneralOrdersStatisticsService extends IService<GeneralOrders> {
        List<Object> general_orders_order_status_status_statistic_3c2baf0b_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_order_status_status_statistic_b02c5267_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_order_status_status_statistic_97de812d_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_pay_status_status_statistic_11ed7b8b_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_pay_status_status_statistic_aa455c23_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_pay_status_status_statistic_d61bf563_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_delivery_status_status_statistic_b439ebb6_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_delivery_status_status_statistic_4f231347_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_delivery_status_status_statistic_abaf9427_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_payment_time_datetime_statistic_5bdc6c9a_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_payment_time_datetime_statistic_68854977_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_payment_time_datetime_statistic_f669d7fd_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_create_time_datetime_statistic_49245188_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_create_time_datetime_statistic_5a64018c_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_create_time_datetime_statistic_3c178831_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_update_time_datetime_statistic_cf60f828_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_update_time_datetime_statistic_56123fa7_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_update_time_datetime_statistic_3abbe917_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_cancel_time_datetime_statistic_e3d18a44_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_cancel_time_datetime_statistic_39eff77a_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_cancel_time_datetime_statistic_1cd9fc53_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_complete_time_datetime_statistic_1c4c5d69_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_complete_time_datetime_statistic_26b52752_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_complete_time_datetime_statistic_3b7ddf49_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_deliver_time_datetime_statistic_56a27fe9_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_deliver_time_datetime_statistic_7d95dc04_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_deliver_time_datetime_statistic_eee9ace7_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_refund_status_status_statistic_be66fbf1_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_refund_status_status_statistic_61064702_count(LambdaQueryWrapper queryWrapper);

        List<Object> general_orders_refund_status_status_statistic_104a645e_count(LambdaQueryWrapper queryWrapper);

}
