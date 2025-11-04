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

import com.kuafu.web.mapper.OrderStatusEnumStatisticsMapper;
import com.kuafu.web.entity.OrderStatusEnum;
import com.kuafu.web.service.IOrderStatusEnumStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> order_status_enum 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("OrderStatusEnumStatistics")
public class OrderStatusEnumStatisticsServiceImpl extends ServiceImpl<OrderStatusEnumStatisticsMapper, OrderStatusEnum> implements IOrderStatusEnumStatisticsService {
    @Resource
    private OrderStatusEnumStatisticsMapper orderStatusEnumStaticMapper;

                        @Override
                        public List<Object> order_status_enum_order_status_enum_id_status_statistic_9bc9ef17_count(LambdaQueryWrapper queryWrapper) {
                                return orderStatusEnumStaticMapper.order_status_enum_order_status_enum_id_status_statistic_9bc9ef17_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_status_enum_order_status_enum_id_status_statistic_2bcfa4b6_count(LambdaQueryWrapper queryWrapper) {
                                return orderStatusEnumStaticMapper.order_status_enum_order_status_enum_id_status_statistic_2bcfa4b6_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_status_enum_order_status_enum_id_status_statistic_da23ad10_count(LambdaQueryWrapper queryWrapper) {
                                return orderStatusEnumStaticMapper.order_status_enum_order_status_enum_id_status_statistic_da23ad10_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_status_enum_status_name_status_statistic_a8cf06c4_count(LambdaQueryWrapper queryWrapper) {
                                return orderStatusEnumStaticMapper.order_status_enum_status_name_status_statistic_a8cf06c4_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_status_enum_status_name_status_statistic_50ddd169_count(LambdaQueryWrapper queryWrapper) {
                                return orderStatusEnumStaticMapper.order_status_enum_status_name_status_statistic_50ddd169_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_status_enum_status_name_status_statistic_f7be0462_count(LambdaQueryWrapper queryWrapper) {
                                return orderStatusEnumStaticMapper.order_status_enum_status_name_status_statistic_f7be0462_count(queryWrapper);
                                }


}
