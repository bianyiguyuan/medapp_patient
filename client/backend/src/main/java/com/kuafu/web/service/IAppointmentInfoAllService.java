package com.kuafu.web.service;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.kuafu.common.domin.PageRequest;
import com.kuafu.web.entity.AppointmentInfoAll;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;



/**
 * <p>  预约信息 服务类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
public interface IAppointmentInfoAllService extends IService<AppointmentInfoAll> {
        List<AppointmentInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<AppointmentInfoAll> queryWrapper);
        List<AppointmentInfoAll> selectListNew(PageRequest pageRequest, LambdaQueryWrapper<AppointmentInfoAll> queryWrapper,boolean isPage);

        long selectCount(PageRequest pageRequest, LambdaQueryWrapper<AppointmentInfoAll> queryWrapper);

        IPage pageNew(IPage<AppointmentInfoAll> page, PageRequest pageRequest, LambdaQueryWrapper<AppointmentInfoAll> queryWrapper);
        }
