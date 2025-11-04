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

import com.kuafu.web.mapper.MemberLevelEnumStatisticsMapper;
import com.kuafu.web.entity.MemberLevelEnum;
import com.kuafu.web.service.IMemberLevelEnumStatisticsService;
import lombok.extern.slf4j.Slf4j;
import javax.annotation.Resource;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
/**
 * <p> member_level_enum 服务实现类 </p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Slf4j
@Service("MemberLevelEnumStatistics")
public class MemberLevelEnumStatisticsServiceImpl extends ServiceImpl<MemberLevelEnumStatisticsMapper, MemberLevelEnum> implements IMemberLevelEnumStatisticsService {
    @Resource
    private MemberLevelEnumStatisticsMapper memberLevelEnumStaticMapper;

                        @Override
                        public List<Object> member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count(LambdaQueryWrapper queryWrapper) {
                                return memberLevelEnumStaticMapper.member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count(queryWrapper);
                                }


                        @Override
                        public List<Object> member_level_enum_member_level_enum_id_status_statistic_72e02317_count(LambdaQueryWrapper queryWrapper) {
                                return memberLevelEnumStaticMapper.member_level_enum_member_level_enum_id_status_statistic_72e02317_count(queryWrapper);
                                }


                        @Override
                        public List<Object> member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count(LambdaQueryWrapper queryWrapper) {
                                return memberLevelEnumStaticMapper.member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count(queryWrapper);
                                }


}
