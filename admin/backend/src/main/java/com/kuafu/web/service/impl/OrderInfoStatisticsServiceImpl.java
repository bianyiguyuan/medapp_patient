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

import com.kuafu.web.mapper.OrderInfoStatisticsMapper;
import com.kuafu.web.entity.OrderInfo;
import com.kuafu.web.service.IOrderInfoStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> order_info 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("OrderInfoStatistics")
public class OrderInfoStatisticsServiceImpl extends ServiceImpl<OrderInfoStatisticsMapper, OrderInfo> implements IOrderInfoStatisticsService {
    @Resource
    private OrderInfoStatisticsMapper orderInfoStaticMapper;

                        @Override
                        public List<Object> order_info_statistic_78be52de_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_78be52de_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_cac602ba_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_cac602ba_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_c1f3da7b_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_c1f3da7b_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_b678dff5_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_b678dff5_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_13a72ffb_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_13a72ffb_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_2549672a_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_2549672a_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_47128f62_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_47128f62_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_9340d0f4_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_9340d0f4_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_55633d24_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_55633d24_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_ecbc57bf_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_ecbc57bf_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_634a7ba6_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_634a7ba6_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_statistic_03b9e7eb_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_statistic_03b9e7eb_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_order_status_enum_id_status_statistic_546711ee_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_order_status_enum_id_status_statistic_546711ee_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_order_status_enum_id_status_statistic_a3491f78_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_order_status_enum_id_status_statistic_a3491f78_count(queryWrapper);
                                }


                        @Override
                        public List<Object> order_info_order_status_enum_id_status_statistic_43727b26_count(LambdaQueryWrapper queryWrapper) {
                                return orderInfoStaticMapper.order_info_order_status_enum_id_status_statistic_43727b26_count(queryWrapper);
                                }


}
