package com.kuafu.login.domain;

import com.kuafu.login.domain.SelectVo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LoginReverence {

            kfSystemConfig("系统配置","kfSystemConfig"),
        delayedTasks("延迟任务","delayedTasks"),
        generalOrders("系统订单信息","generalOrders"),
        userInfo("用户信息","userInfo"),
        memberLevelEnum("会员等级","memberLevelEnum"),
        appointmentInfo("预约信息","appointmentInfo"),
        appointmentStatusEnum("预约状态","appointmentStatusEnum"),
        faceDetectionInfo("人脸检测信息","faceDetectionInfo"),
        productInfo("品牌商品信息","productInfo"),
        commissionInfo("佣金信息","commissionInfo"),
        couponInfo("优惠券信息","couponInfo"),
        orderInfo("订单信息","orderInfo"),
        orderStatusEnum("订单状态","orderStatusEnum"),
    ;


    private String label;
    private String value;

    LoginReverence(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public String getValue() {
        return value;
    }

    public static List<SelectVo> all() {
        final LoginReverence[] values = LoginReverence.values();
        return Arrays.stream(values).map(r -> {
            return new SelectVo(r.getValue(), r.getLabel(),r.getLabel());
        }).collect(Collectors.toList());
    }
}
