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

import com.kuafu.web.mapper.CommissionInfoStatisticsMapper;
import com.kuafu.web.entity.CommissionInfo;
import com.kuafu.web.service.ICommissionInfoStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> commission_info 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("CommissionInfoStatistics")
public class CommissionInfoStatisticsServiceImpl extends ServiceImpl<CommissionInfoStatisticsMapper, CommissionInfo> implements ICommissionInfoStatisticsService {
    @Resource
    private CommissionInfoStatisticsMapper commissionInfoStaticMapper;

                        @Override
                        public List<Object> commission_info_statistic_2eb6e6e9_count(LambdaQueryWrapper queryWrapper) {
                                return commissionInfoStaticMapper.commission_info_statistic_2eb6e6e9_count(queryWrapper);
                                }


                        @Override
                        public List<Object> commission_info_statistic_715fc2a4_count(LambdaQueryWrapper queryWrapper) {
                                return commissionInfoStaticMapper.commission_info_statistic_715fc2a4_count(queryWrapper);
                                }


                        @Override
                        public List<Object> commission_info_statistic_12ffaa16_count(LambdaQueryWrapper queryWrapper) {
                                return commissionInfoStaticMapper.commission_info_statistic_12ffaa16_count(queryWrapper);
                                }


}
