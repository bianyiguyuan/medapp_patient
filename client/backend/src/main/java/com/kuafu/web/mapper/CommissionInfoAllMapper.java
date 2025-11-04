package com.kuafu.web.mapper;

import java.util.List;
import com.kuafu.web.entity.CommissionInfoAll;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;

/**
 * <p> 佣金信息 Mapper </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Mapper
public interface CommissionInfoAllMapper extends BaseMapper<CommissionInfoAll> {
    public List<CommissionInfoAll> selectListNew(@Param("ew") Wrapper<CommissionInfoAll> queryWrapper);
}
