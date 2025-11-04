package com.kuafu.web.mapper;

import java.util.List;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.web.entity.CouponInfo;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
/**
 * <p> coupon_info Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface CouponInfoStatisticsMapper extends BaseMapper<CouponInfo> {

                        List<Object> coupon_info_statistic_d903bc2c_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> coupon_info_statistic_e2133559_count(@Param("ew") Wrapper queryWrapper);


                        List<Object> coupon_info_statistic_76e50a69_count(@Param("ew") Wrapper queryWrapper);

}
