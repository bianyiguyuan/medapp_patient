package com.kuafu.web.service.impl;

import java.util.List;
import org.springframework.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.kuafu.web.mapper.AppointmentStatusEnumMapper;
import com.kuafu.web.entity.AppointmentStatusEnum;
import com.kuafu.web.service.IAppointmentStatusEnumService;
import lombok.extern.slf4j.Slf4j;

/**
 * <p> 预约状态 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("AppointmentStatusEnum")
public class AppointmentStatusEnumServiceImpl extends ServiceImpl<AppointmentStatusEnumMapper, AppointmentStatusEnum> implements IAppointmentStatusEnumService {


}
