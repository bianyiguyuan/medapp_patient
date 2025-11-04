package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.CommissionInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  commission_info 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface ICommissionInfoStatisticsService extends IService<CommissionInfo> {
        List<Object> commission_info_statistic_2eb6e6e9_count(LambdaQueryWrapper queryWrapper);

        List<Object> commission_info_statistic_715fc2a4_count(LambdaQueryWrapper queryWrapper);

        List<Object> commission_info_statistic_12ffaa16_count(LambdaQueryWrapper queryWrapper);

}
