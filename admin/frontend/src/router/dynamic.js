export const dynamicRoutes = [{
        path: '/',
        meta: {
            title: '首页',
            isParentView: false
        },
        component: ()=> import('@/views/dashboard_statistic/index.vue'),
    }, {
        path: '/kf_system_config',
        meta: {
            title: '系统配置',
            shownot: false
        },
        component: ()=> import('@/views/kf_system_config/index.vue'),
    }, {
        path: '/delayed_tasks',
        meta: {
            title: '延迟任务',
            shownot: false
        },
        component: ()=> import('@/views/delayed_tasks/index.vue'),
    }, {
        path: '/general_orders',
        meta: {
            title: '系统订单信息',
            shownot: false
        },
        component: ()=> import('@/views/general_orders/index.vue'),
    }, {
        path: '/user_info',
        meta: {
            title: '用户信息',
            shownot: false
        },
        component: ()=> import('@/views/user_info/index.vue'),
    }, {
        path: '/member_level_enum',
        meta: {
            title: '会员等级',
            shownot: false
        },
        component: ()=> import('@/views/member_level_enum/index.vue'),
    }, {
        path: '/appointment_info',
        meta: {
            title: '预约信息',
            shownot: false
        },
        component: ()=> import('@/views/appointment_info/index.vue'),
    }, {
        path: '/appointment_status_enum',
        meta: {
            title: '预约状态',
            shownot: false
        },
        component: ()=> import('@/views/appointment_status_enum/index.vue'),
    }, {
        path: '/face_detection_info',
        meta: {
            title: '人脸检测信息',
            shownot: false
        },
        component: ()=> import('@/views/face_detection_info/index.vue'),
    }, {
        path: '/product_info',
        meta: {
            title: '品牌商品信息',
            shownot: false
        },
        component: ()=> import('@/views/product_info/index.vue'),
    }, {
        path: '/commission_info',
        meta: {
            title: '佣金信息',
            shownot: false
        },
        component: ()=> import('@/views/commission_info/index.vue'),
    }, {
        path: '/coupon_info',
        meta: {
            title: '优惠券信息',
            shownot: false
        },
        component: ()=> import('@/views/coupon_info/index.vue'),
    }, {
        path: '/order_info',
        meta: {
            title: '订单信息',
            shownot: false
        },
        component: ()=> import('@/views/order_info/index.vue'),
    }, {
        path: '/order_status_enum',
        meta: {
            title: '订单状态',
            shownot: false
        },
        component: ()=> import('@/views/order_status_enum/index.vue'),
    }, {
        path: '/dynamic_api_setting',
        meta: {
            title: 'API配置',
            shownot: false
        },
        component: ()=> import('@/views/dynamic_api_setting/index.vue'),
    }, {
        path: '/kf_system_config/detail',
        meta: {
            title: '系统配置详情',
            shownot: true
        },
        component: ()=> import('@/views/kf_system_config/detail/index.vue'),
    }, {
        path: '/delayed_tasks/detail',
        meta: {
            title: '延迟任务详情',
            shownot: true
        },
        component: ()=> import('@/views/delayed_tasks/detail/index.vue'),
    }, {
        path: '/general_orders/detail',
        meta: {
            title: '系统订单信息详情',
            shownot: true
        },
        component: ()=> import('@/views/general_orders/detail/index.vue'),
    }, {
        path: '/user_info/detail',
        meta: {
            title: '用户信息详情',
            shownot: true
        },
        component: ()=> import('@/views/user_info/detail/index.vue'),
    }, {
        path: '/member_level_enum/detail',
        meta: {
            title: '会员等级详情',
            shownot: true
        },
        component: ()=> import('@/views/member_level_enum/detail/index.vue'),
    }, {
        path: '/appointment_info/detail',
        meta: {
            title: '预约信息详情',
            shownot: true
        },
        component: ()=> import('@/views/appointment_info/detail/index.vue'),
    }, {
        path: '/appointment_status_enum/detail',
        meta: {
            title: '预约状态详情',
            shownot: true
        },
        component: ()=> import('@/views/appointment_status_enum/detail/index.vue'),
    }, {
        path: '/face_detection_info/detail',
        meta: {
            title: '人脸检测信息详情',
            shownot: true
        },
        component: ()=> import('@/views/face_detection_info/detail/index.vue'),
    }, {
        path: '/product_info/detail',
        meta: {
            title: '品牌商品信息详情',
            shownot: true
        },
        component: ()=> import('@/views/product_info/detail/index.vue'),
    }, {
        path: '/commission_info/detail',
        meta: {
            title: '佣金信息详情',
            shownot: true
        },
        component: ()=> import('@/views/commission_info/detail/index.vue'),
    }, {
        path: '/coupon_info/detail',
        meta: {
            title: '优惠券信息详情',
            shownot: true
        },
        component: ()=> import('@/views/coupon_info/detail/index.vue'),
    }, {
        path: '/order_info/detail',
        meta: {
            title: '订单信息详情',
            shownot: true
        },
        component: ()=> import('@/views/order_info/detail/index.vue'),
    }, {
        path: '/order_status_enum/detail',
        meta: {
            title: '订单状态详情',
            shownot: true
        },
        component: ()=> import('@/views/order_status_enum/detail/index.vue'),
    }, {
        path: '/dynamic_api_setting/detail',
        meta: {
            title: 'API配置详情',
            shownot: true
        },
        component: ()=> import('@/views/dynamic_api_setting/detail/index.vue'),
    }]