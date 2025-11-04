package com.kuafu.web.controller;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public enum LoginReverenceValue {
generalOrders("generalOrders","order_info_all.get_general_orders_list"),memberLevelEnum("memberLevelEnum","user_info_all.get_member_level_enum_list"),userInfo("userInfo","order_info_all.get_user_info_list"),orderStatusEnum("orderStatusEnum","order_info_all.get_order_status_enum_list"),appointmentStatusEnum("appointmentStatusEnum","appointment_info_all.get_appointment_status_enum_list"),productInfo("productInfo","order_info_all.get_product_info_list"),appointment_status_enum("appointment_status_enum","appointment_status_enum.get_select_list"),dynamic_api_setting("dynamic_api_setting","dynamic_api_setting.get_select_list"),appointment_info("appointment_info","appointment_info.get_select_list"),commission_info("commission_info","commission_info.get_select_list"),product_info("product_info","product_info.get_select_list"),delayed_tasks("delayed_tasks","delayed_tasks.get_select_list"),coupon_info("coupon_info","coupon_info.get_select_list"),order_info("order_info","order_info.get_select_list"),order_status_enum("order_status_enum","order_status_enum.get_select_list"),face_detection_info("face_detection_info","face_detection_info.get_select_list"),member_level_enum("member_level_enum","member_level_enum.get_select_list"),general_orders("general_orders","general_orders.get_select_list"),user_info("user_info","user_info.get_select_list"),kf_system_config("kf_system_config","kf_system_config.get_select_list"),;
    private String label;
    private String value;


    LoginReverenceValue(String label, String value) {
        this.label = label;
        this.value = value;
    }

    public static String getValue(String label) {
        for (LoginReverenceValue item : values()) {
            if (StringUtils.equalsIgnoreCase(item.getLabel(), label)) {
                return item.getValue();
            }
        }
        return null;
    }
}
