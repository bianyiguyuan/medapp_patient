package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.CouponInfoAll;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p> 优惠券信息 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface CouponInfoAllMapper extends BaseMapper<CouponInfoAll> {
    public List<CouponInfoAll> selectListNew(@Param("ew") Wrapper<CouponInfoAll> queryWrapper);
}
