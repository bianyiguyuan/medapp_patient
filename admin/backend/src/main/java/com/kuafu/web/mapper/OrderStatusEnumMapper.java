package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.OrderStatusEnum;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p> 订单状态 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface OrderStatusEnumMapper extends BaseMapper<OrderStatusEnum> {

}
