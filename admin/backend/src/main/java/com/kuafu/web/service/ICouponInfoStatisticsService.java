package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.CouponInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  coupon_info 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface ICouponInfoStatisticsService extends IService<CouponInfo> {
        List<Object> coupon_info_statistic_d903bc2c_count(LambdaQueryWrapper queryWrapper);

        List<Object> coupon_info_statistic_e2133559_count(LambdaQueryWrapper queryWrapper);

        List<Object> coupon_info_statistic_76e50a69_count(LambdaQueryWrapper queryWrapper);

}
