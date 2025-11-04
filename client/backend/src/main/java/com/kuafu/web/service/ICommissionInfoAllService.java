package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.CommissionInfoAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  佣金信息 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface ICommissionInfoAllService extends IService<CommissionInfoAll> {
        List<CommissionInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<CommissionInfoAll> queryWrapper);
        List<CommissionInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<CommissionInfoAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<CommissionInfoAll> queryWrapper);

        IPage pageNew(IPage<CommissionInfoAll> page, PageRequest pageRequest, LambdaQueryWrapper<CommissionInfoAll> queryWrapper);
        }
