package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.CouponInfoAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  优惠券信息 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface ICouponInfoAllService extends IService<CouponInfoAll> {
        List<CouponInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<CouponInfoAll> queryWrapper);
        List<CouponInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<CouponInfoAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<CouponInfoAll> queryWrapper);

        IPage pageNew(IPage<CouponInfoAll> page, PageRequest pageRequest, LambdaQueryWrapper<CouponInfoAll> queryWrapper);
        }
