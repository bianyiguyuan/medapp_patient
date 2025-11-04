package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.ProductInfoAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  品牌商品信息 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IProductInfoAllService extends IService<ProductInfoAll> {
        List<ProductInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<ProductInfoAll> queryWrapper);
        List<ProductInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<ProductInfoAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<ProductInfoAll> queryWrapper);

        IPage pageNew(IPage<ProductInfoAll> page, PageRequest pageRequest, LambdaQueryWrapper<ProductInfoAll> queryWrapper);
        }
