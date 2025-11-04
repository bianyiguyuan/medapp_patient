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

import com.kuafu.web.mapper.CouponInfoStatisticsMapper;
import com.kuafu.web.entity.CouponInfo;
import com.kuafu.web.service.ICouponInfoStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> coupon_info 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("CouponInfoStatistics")
public class CouponInfoStatisticsServiceImpl extends ServiceImpl<CouponInfoStatisticsMapper, CouponInfo> implements ICouponInfoStatisticsService {
    @Resource
    private CouponInfoStatisticsMapper couponInfoStaticMapper;

                        @Override
                        public List<Object> coupon_info_statistic_d903bc2c_count(LambdaQueryWrapper queryWrapper) {
                                return couponInfoStaticMapper.coupon_info_statistic_d903bc2c_count(queryWrapper);
                                }


                        @Override
                        public List<Object> coupon_info_statistic_e2133559_count(LambdaQueryWrapper queryWrapper) {
                                return couponInfoStaticMapper.coupon_info_statistic_e2133559_count(queryWrapper);
                                }


                        @Override
                        public List<Object> coupon_info_statistic_76e50a69_count(LambdaQueryWrapper queryWrapper) {
                                return couponInfoStaticMapper.coupon_info_statistic_76e50a69_count(queryWrapper);
                                }


}
