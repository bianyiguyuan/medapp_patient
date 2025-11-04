package com.kuafu.web.service;

import java.util.List;
import com.kuafu.web.entity.UserInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p>  user_info 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IUserInfoStatisticsService extends IService<UserInfo> {
        List<Object> user_info_statistic_b8e54625_count(LambdaQueryWrapper queryWrapper);

        List<Object> user_info_statistic_d3ee33f0_count(LambdaQueryWrapper queryWrapper);

        List<Object> user_info_statistic_d0fbf2c7_count(LambdaQueryWrapper queryWrapper);

}
