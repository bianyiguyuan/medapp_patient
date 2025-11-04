drop table if exists `kf_system_config`;
create table `kf_system_config` (
 	 `id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `name` 	 varchar(512) not null  ,
	 `chinese_name` 	 varchar(512)   ,
	 `description` 	 varchar(512)   ,
	 `content` 	 TEXT   ,
	 `remark` 	 varchar(512)   ,
	 `type` 	 varchar(512)   
 );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("order.expire.time","订单多少时间未支付自动关闭，单位分钟","","30","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("order.automatic.receiptTime","订单多长时间自动确认收货，单位 天","","5","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("order.automatic.schedule.corn","订单自动确认收货的定时任务的执行周期","","*/10 * * * * ?","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wechat.app-id","微信小程序appid","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wechat.app-secret","微信小程序secret","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wechat.is-register","默认配置不需要修改","","0","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.pay-back-url","微信支付回调url","","https://view.kuafuai.net/1238181/api/generalOrder/callback","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.mch-serial-no","微信支付序列号","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.app-id","微信支付对应的appid","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.mch-id","微信支付商户号","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.api-v3-key","微信支付 apiv3 key","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.is_test","微信支付是否开启测试,开启测试后，支付金额统一为0.01，正式上线请关闭（true/false）","","true","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.is_test_amount","微信支付测试金额","","0.01","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.mock_enable","是否开启mock支付（没有申请支付的情况下，true/false）","","true","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.wechat_enable","是否开启微信支付(true/false)","","false","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.mp-app-id","微信公众号的APPID","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wechat.mp-redirect_uri","重定向的url","","https://view.kuafuai.net/1238181/api/login/redirect/238181","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.mp-app-secret","","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wechat.mp-frontend_redirect_uri","前端的重定向地址","","https://view.kuafuai.net/1238181/","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("order.orderStatusField","订单表中的订单状态字段","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("order.refundStatusValue","系统订单中退款状态与业务订单表退款状态的中的映射关系","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.private-key","微信支付私钥内容 （apiclient_key.pem）","","","","" );
insert into `kf_system_config` (`name`, `chinese_name`, `description`, `content`, `remark`, `type` ) values ("wx.pay.order_pre_key","支付商户号的统一前缀(请谨慎修改,该值变化后将使存量的支付订单不可用)","","order-238181-","","" );

drop table if exists `delayed_tasks`;
create table `delayed_tasks` (
 	 `id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `task_type` 	 varchar(512) not null  ,
	 `task_data` 	 varchar(512) not null  ,
	 `status` 	 varchar(512) not null  ,
	 `execute_time` 	 DATETIME not null  ,
	 `create_time` 	 DATETIME  DEFAULT (CURRENT_TIMESTAMP) ,
	 `update_time` 	 DATETIME  DEFAULT (CURRENT_TIMESTAMP) 
 );


drop table if exists `general_orders`;
create table `general_orders` (
 	 `id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `order_no` 	 varchar(512) not null  ,
	 `user_id` 	 INTEGER not null  ,
	 `op_id` 	 varchar(512)   ,
	 `order_type` 	 varchar(512)   ,
	 `order_status` 	 varchar(512) not null  ,
	 `pay_status` 	 varchar(512) not null  ,
	 `delivery_status` 	 varchar(512)   ,
	 `products_id` 	 INTEGER not null  ,
	 `quality` 	 INTEGER not null  ,
	 `total_amount` 	 DECIMAL(18,6) not null  ,
	 `discount_amount` 	 DECIMAL(18,6)   ,
	 `shipping_fee` 	 DECIMAL(18,6)   ,
	 `actual_amount` 	 DECIMAL(18,6) not null  ,
	 `payment_channel` 	 varchar(512)   ,
	 `payment_order_id` 	 varchar(512)   ,
	 `payment_time` 	 DATETIME   ,
	 `payment_amount` 	 DECIMAL(18,6)   ,
	 `shipping_method` 	 varchar(512)   ,
	 `shipping_address` 	 varchar(512)   ,
	 `shipping_company` 	 varchar(512)   ,
	 `tracking_number` 	 varchar(512)   ,
	 `tel` 	 varchar(512)   ,
	 `recipient` 	 varchar(512)   ,
	 `create_time` 	 DATETIME  DEFAULT (CURRENT_TIMESTAMP) ,
	 `update_time` 	 DATETIME  DEFAULT (CURRENT_TIMESTAMP) ,
	 `cancel_time` 	 DATETIME   ,
	 `complete_time` 	 DATETIME   ,
	 `deliver_time` 	 DATETIME   ,
	 `refund_id` 	 varchar(512)   ,
	 `refund_no` 	 varchar(512)   ,
	 `refund_type` 	 varchar(512)   ,
	 `refund_amount` 	 DECIMAL(18,6)   ,
	 `refund_reason` 	 varchar(512)   ,
	 `refund_status` 	 varchar(512)   ,
	 `remark` 	 varchar(512)   ,
	 `is_deleted` 	 INTEGER   ,
	 `table_name` 	 varchar(512)   ,
	 `field_name` 	 varchar(512)   
 );


drop table if exists `user_info`;
create table `user_info` (
 	 `user_info_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `phone_number` 	 VARCHAR(64) not null  ,
	 `username` 	 varchar(512)   ,
	 `password` 	 VARCHAR(64) not null  ,
	 `email` 	 VARCHAR(64)   ,
	 `member_level_id` 	 INTEGER   ,
	 `avatar_resource_key` 	 VARCHAR(255)   
 );
insert into `user_info` (`phone_number`, `username`, `password`, `email`, `member_level_id`, `avatar_resource_key` ) values ("13800138000","小飞飞","pass1234","xiaofeifei@example.com","1","0" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/girl-smile.jpg','user_info', '1', 'avatar');
insert into `user_info` (`phone_number`, `username`, `password`, `email`, `member_level_id`, `avatar_resource_key` ) values ("13900139000","美丽花","password1","meilihua@example.com","2","0" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/woman-reading-book.jpg','user_info', '2', 'avatar');
insert into `user_info` (`phone_number`, `username`, `password`, `email`, `member_level_id`, `avatar_resource_key` ) values ("13700137000","健康宝","mypassword","jiankangbao@example.com","3","0" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/doctor-patient.jpg','user_info', '3', 'avatar');
insert into `user_info` (`phone_number`, `username`, `password`, `email`, `member_level_id`, `avatar_resource_key` ) values ("13600136000","颜值王","securepass","yanzhiwang@example.com","1","0" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/ai-girl5.jpg','user_info', '4', 'avatar');
insert into `user_info` (`phone_number`, `username`, `password`, `email`, `member_level_id`, `avatar_resource_key` ) values ("13500135000","时尚达人","fashion123","shishang@example.com","2","0" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/curious-sheep.jpg','user_info', '5', 'avatar');
insert into `user_info` (`phone_number`, `username`, `password`, `email`, `member_level_id`, `avatar_resource_key` ) values ("13400134000","美容专家","expert2024","meirongzj@example.com","3","0" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/expert-health.jpg','user_info', '6', 'avatar');

drop table if exists `member_level_enum`;
create table `member_level_enum` (
 	 `member_level_enum_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `level_name` 	 varchar(512) not null  ,
	 `description` 	 TEXT   
 );
insert into `member_level_enum` (`level_name`, `description` ) values ("普通会员","普通会员描述" );
insert into `member_level_enum` (`level_name`, `description` ) values ("黄金会员","黄金会员描述" );
insert into `member_level_enum` (`level_name`, `description` ) values ("钻石会员","钻石会员描述" );

drop table if exists `appointment_info`;
create table `appointment_info` (
 	 `appointment_info_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `user_info_user_info_id_1` 	 INTEGER not null  ,
	 `doctor_name` 	 varchar(512) not null  ,
	 `appointment_date` 	 DATETIME not null  ,
	 `appointment_time` 	 varchar(512) not null  ,
	 `status_enum_id` 	 INTEGER not null  ,
	 `deposit_paid` 	 BOOL   ,
	 `deposit_amount` 	 DECIMAL(18,6)   ,
	 `coupon_received` 	 BOOL   ,
	 `appointment_code` 	 varchar(512)   
 );
insert into `appointment_info` (`user_info_user_info_id_1`, `doctor_name`, `appointment_date`, `appointment_time`, `status_enum_id`, `deposit_paid`, `deposit_amount`, `coupon_received`, `appointment_code` ) values ("1","张医生","2025-01-01 00:00:00","09:00-10:00","2","True","100.0","True","APPT20240701001" );
insert into `appointment_info` (`user_info_user_info_id_1`, `doctor_name`, `appointment_date`, `appointment_time`, `status_enum_id`, `deposit_paid`, `deposit_amount`, `coupon_received`, `appointment_code` ) values ("2","李医生","2025-01-01 00:00:00","14:00-15:00","1","","","","APPT20240702002" );
insert into `appointment_info` (`user_info_user_info_id_1`, `doctor_name`, `appointment_date`, `appointment_time`, `status_enum_id`, `deposit_paid`, `deposit_amount`, `coupon_received`, `appointment_code` ) values ("3","王医生","2025-01-01 00:00:00","16:00-17:00","2","True","100.0","True","APPT20240703003" );
insert into `appointment_info` (`user_info_user_info_id_1`, `doctor_name`, `appointment_date`, `appointment_time`, `status_enum_id`, `deposit_paid`, `deposit_amount`, `coupon_received`, `appointment_code` ) values ("4","赵医生","2025-01-01 00:00:00","10:00-11:00","3","","","","APPT20240704004" );
insert into `appointment_info` (`user_info_user_info_id_1`, `doctor_name`, `appointment_date`, `appointment_time`, `status_enum_id`, `deposit_paid`, `deposit_amount`, `coupon_received`, `appointment_code` ) values ("5","钱医生","2025-01-01 00:00:00","13:00-14:00","2","True","100.0","True","APPT20240705005" );
insert into `appointment_info` (`user_info_user_info_id_1`, `doctor_name`, `appointment_date`, `appointment_time`, `status_enum_id`, `deposit_paid`, `deposit_amount`, `coupon_received`, `appointment_code` ) values ("6","孙医生","2025-01-01 00:00:00","15:00-16:00","1","","","","APPT20240706006" );

drop table if exists `appointment_status_enum`;
create table `appointment_status_enum` (
 	 `appointment_status_enum_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `status_name` 	 varchar(512) not null  
 );
insert into `appointment_status_enum` (`status_name` ) values ("待支付" );
insert into `appointment_status_enum` (`status_name` ) values ("已支付" );
insert into `appointment_status_enum` (`status_name` ) values ("已取消" );

drop table if exists `face_detection_info`;
create table `face_detection_info` (
 	 `face_detection_info_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `user_info_user_info_id_2` 	 INTEGER not null  ,
	 `upload_image_resource_key` 	 VARCHAR(255)   ,
	 `impression_age` 	 INTEGER   ,
	 `aging_parts` 	 varchar(512)   ,
	 `deep_analysis_unlocked` 	 BOOL   ,
	 `custom_plan_unlocked` 	 BOOL   
 );
insert into `face_detection_info` (`user_info_user_info_id_2`, `upload_image_resource_key`, `impression_age`, `aging_parts`, `deep_analysis_unlocked`, `custom_plan_unlocked` ) values ("1","0","28","眼角皱纹","","" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/ai-girl5.jpg','face_detection_info', '1', 'upload_image');
insert into `face_detection_info` (`user_info_user_info_id_2`, `upload_image_resource_key`, `impression_age`, `aging_parts`, `deep_analysis_unlocked`, `custom_plan_unlocked` ) values ("2","0","35","脸颊松弛","True","" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/girl-smile.jpg','face_detection_info', '2', 'upload_image');
insert into `face_detection_info` (`user_info_user_info_id_2`, `upload_image_resource_key`, `impression_age`, `aging_parts`, `deep_analysis_unlocked`, `custom_plan_unlocked` ) values ("3","0","40","法令纹","True","True" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/doctor-patient.jpg','face_detection_info', '3', 'upload_image');
insert into `face_detection_info` (`user_info_user_info_id_2`, `upload_image_resource_key`, `impression_age`, `aging_parts`, `deep_analysis_unlocked`, `custom_plan_unlocked` ) values ("4","0","25","额头细纹","","" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/woman-reading-book.jpg','face_detection_info', '4', 'upload_image');
insert into `face_detection_info` (`user_info_user_info_id_2`, `upload_image_resource_key`, `impression_age`, `aging_parts`, `deep_analysis_unlocked`, `custom_plan_unlocked` ) values ("5","0","30","眼袋","","True" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/curious-sheep.jpg','face_detection_info', '5', 'upload_image');
insert into `face_detection_info` (`user_info_user_info_id_2`, `upload_image_resource_key`, `impression_age`, `aging_parts`, `deep_analysis_unlocked`, `custom_plan_unlocked` ) values ("6","0","33","皮肤暗沉","True","True" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/expert-health.jpg','face_detection_info', '6', 'upload_image');

drop table if exists `product_info`;
create table `product_info` (
 	 `product_info_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `product_name` 	 varchar(512) not null  ,
	 `price` 	 DECIMAL(18,6) not null  ,
	 `image_resource_key` 	 VARCHAR(255)   ,
	 `coupon_amount` 	 DECIMAL(18,6)   ,
	 `mini_program_path` 	 varchar(512)   
 );
insert into `product_info` (`product_name`, `price`, `image_resource_key`, `coupon_amount`, `mini_program_path` ) values ("玻尿酸注射","2999.0","0","200.0","pages/product1" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/flower-vase.jpg','product_info', '1', 'image');
insert into `product_info` (`product_name`, `price`, `image_resource_key`, `coupon_amount`, `mini_program_path` ) values ("激光美白套餐","4999.0","0","300.0","pages/product2" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/woman-hiking.jpg','product_info', '2', 'image');
insert into `product_info` (`product_name`, `price`, `image_resource_key`, `coupon_amount`, `mini_program_path` ) values ("抗衰老精华液","899.0","0","50.0","pages/product3" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/girl-smile.jpg','product_info', '3', 'image');
insert into `product_info` (`product_name`, `price`, `image_resource_key`, `coupon_amount`, `mini_program_path` ) values ("面部提升手术","15000.0","0","1000.0","pages/product4" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/doctor-patient.jpg','product_info', '4', 'image');
insert into `product_info` (`product_name`, `price`, `image_resource_key`, `coupon_amount`, `mini_program_path` ) values ("皮肤护理套餐","1200.0","0","100.0","pages/product5" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/curious-sheep.jpg','product_info', '5', 'image');
insert into `product_info` (`product_name`, `price`, `image_resource_key`, `coupon_amount`, `mini_program_path` ) values ("定制面膜","350.0","0","30.0","pages/product6" );
insert into `static_resources` (`resource_path`, `related_table_name`, `related_table_key`, `relate_table_column_name`) values ('https://www.codeflying.net/preview/woman-reading-book.jpg','product_info', '6', 'image');

drop table if exists `commission_info`;
create table `commission_info` (
 	 `commission_info_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `user_info_user_info_id_3` 	 INTEGER not null  ,
	 `commission_ratio` 	 DECIMAL(18,6) not null  ,
	 `total_earnings` 	 DECIMAL(18,6) not null  
 );
insert into `commission_info` (`user_info_user_info_id_3`, `commission_ratio`, `total_earnings` ) values ("1","0.1","1200.5" );
insert into `commission_info` (`user_info_user_info_id_3`, `commission_ratio`, `total_earnings` ) values ("2","0.15","2500.0" );
insert into `commission_info` (`user_info_user_info_id_3`, `commission_ratio`, `total_earnings` ) values ("3","0.12","1800.75" );
insert into `commission_info` (`user_info_user_info_id_3`, `commission_ratio`, `total_earnings` ) values ("4","0.08","900.0" );
insert into `commission_info` (`user_info_user_info_id_3`, `commission_ratio`, `total_earnings` ) values ("5","0.2","3200.0" );
insert into `commission_info` (`user_info_user_info_id_3`, `commission_ratio`, `total_earnings` ) values ("6","0.1","1500.25" );

drop table if exists `coupon_info`;
create table `coupon_info` (
 	 `coupon_info_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `user_info_user_info_id_4` 	 INTEGER not null  ,
	 `amount` 	 DECIMAL(18,6) not null  ,
	 `is_used` 	 BOOL   
 );
insert into `coupon_info` (`user_info_user_info_id_4`, `amount`, `is_used` ) values ("1","50.0","" );
insert into `coupon_info` (`user_info_user_info_id_4`, `amount`, `is_used` ) values ("2","100.0","True" );
insert into `coupon_info` (`user_info_user_info_id_4`, `amount`, `is_used` ) values ("3","30.0","" );
insert into `coupon_info` (`user_info_user_info_id_4`, `amount`, `is_used` ) values ("4","20.0","True" );
insert into `coupon_info` (`user_info_user_info_id_4`, `amount`, `is_used` ) values ("5","80.0","" );
insert into `coupon_info` (`user_info_user_info_id_4`, `amount`, `is_used` ) values ("6","60.0","" );

drop table if exists `order_info`;
create table `order_info` (
 	 `order_info_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `user_info_user_info_id_5` 	 INTEGER not null  ,
	 `product_info_product_info_id` 	 INTEGER not null  ,
	 `quantity` 	 INTEGER not null  ,
	 `total_price` 	 DECIMAL(18,6) not null  ,
	 `order_status_enum_id` 	 INTEGER not null  ,
	 `payment_order_no` 	 VARCHAR(64)   
 );
insert into `order_info` (`user_info_user_info_id_5`, `product_info_product_info_id`, `quantity`, `total_price`, `order_status_enum_id`, `payment_order_no` ) values ("1","1","1","2999.0","2","ORD20240701001" );
insert into `order_info` (`user_info_user_info_id_5`, `product_info_product_info_id`, `quantity`, `total_price`, `order_status_enum_id`, `payment_order_no` ) values ("2","3","2","1798.0","1","ORD20240702002" );
insert into `order_info` (`user_info_user_info_id_5`, `product_info_product_info_id`, `quantity`, `total_price`, `order_status_enum_id`, `payment_order_no` ) values ("3","2","1","4999.0","2","ORD20240703003" );
insert into `order_info` (`user_info_user_info_id_5`, `product_info_product_info_id`, `quantity`, `total_price`, `order_status_enum_id`, `payment_order_no` ) values ("4","5","3","","3","ORD20240704004" );
insert into `order_info` (`user_info_user_info_id_5`, `product_info_product_info_id`, `quantity`, `total_price`, `order_status_enum_id`, `payment_order_no` ) values ("5","6","3","","1","ORD20240705005" );
insert into `order_info` (`user_info_user_info_id_5`, `product_info_product_info_id`, `quantity`, `total_price`, `order_status_enum_id`, `payment_order_no` ) values ("6","4","1","15000.0","2","ORD20240706006" );

drop table if exists `order_status_enum`;
create table `order_status_enum` (
 	 `order_status_enum_id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `status_name` 	 varchar(512) not null  
 );
insert into `order_status_enum` (`status_name` ) values ("待支付" );
insert into `order_status_enum` (`status_name` ) values ("已支付" );
insert into `order_status_enum` (`status_name` ) values ("已取消" );

drop table if exists `dynamic_api_setting`;
create table `dynamic_api_setting` (
 	 `id` 	 INTEGER PRIMARY KEY AUTOINCREMENT ,
	 `key_name` 	 VARCHAR(512)   ,
	 `description` 	 VARCHAR(512)   ,
	 `url` 	 VARCHAR(512)   ,
	 `token` 	 VARCHAR(512)   ,
	 `app_id` 	 VARCHAR(512)   ,
	 `api_key` 	 VARCHAR(512)   ,
	 `api_secret` 	 VARCHAR(512)   ,
	 `method` 	 VARCHAR(512)   ,
	 `body_type` 	 VARCHAR(512)   ,
	 `body_template` 	 VARCHAR(512)   ,
	 `header` 	 VARCHAR(512)   ,
	 `auth_type` 	 VARCHAR(512)   ,
	 `protocol` 	 VARCHAR(512)   ,
	 `data_path` 	 VARCHAR(512)   ,
	 `data_type` 	 VARCHAR(512)   
 );
insert into `dynamic_api_setting` (`key_name`, `description`, `url`, `token`, `app_id`, `api_key`, `api_secret`, `method`, `body_type`, `body_template`, `header`, `auth_type`, `protocol`, `data_path`, `data_type` ) values ("word2pic","AI文本生成图片","http://1.94.150.175:8087/api/word2pic","sk-sBI9a8/7FnDj18AJhx+F5WSZvs9O57oX9wYDv/GGh0s=","","","","post","template",'{"input":"${{text}}"}','{"Authorization": "Bearer ${{token}}", "Content-Type": "application/json"}',"codeflying","http","","" );
insert into `dynamic_api_setting` (`key_name`, `description`, `url`, `token`, `app_id`, `api_key`, `api_secret`, `method`, `body_type`, `body_template`, `header`, `auth_type`, `protocol`, `data_path`, `data_type` ) values ("pic2word","AI图片识别理解","http://1.94.150.175:8087/api/pic2word","sk-sBI9a8/7FnDj18AJhx+F5WSZvs9O57oX9wYDv/GGh0s=","","","","post","template",'{"input":"请详细描述一下图中有什么？如果图片中是文本，请将文本内容原样输出。","content":"${{content}}"}','{"Authorization": "Bearer ${{token}}", "Content-Type": "application/json"}',"codeflying","http","","" );
insert into `dynamic_api_setting` (`key_name`, `description`, `url`, `token`, `app_id`, `api_key`, `api_secret`, `method`, `body_type`, `body_template`, `header`, `auth_type`, `protocol`, `data_path`, `data_type` ) values ("text2text","AI文本生成文本","http://1.94.150.175:8087/llm/chat-block","sk-sBI9a8/7FnDj18AJhx+F5WSZvs9O57oX9wYDv/GGh0s=","","","","post","","",'{"Authorization": "Bearer ${{token}}", "Content-Type": "application/json"}',"codeflying","http","","" );
insert into `dynamic_api_setting` (`key_name`, `description`, `url`, `token`, `app_id`, `api_key`, `api_secret`, `method`, `body_type`, `body_template`, `header`, `auth_type`, `protocol`, `data_path`, `data_type` ) values ("tts","文本生成语音","http://1.94.150.175:8087/api/text2speech","sk-sBI9a8/7FnDj18AJhx+F5WSZvs9O57oX9wYDv/GGh0s=","","","","post","template",'{"content":"${{text}}"}','{"Authorization": "Bearer ${{token}}", "Content-Type": "application/json"}',"codeflying","http","","" );
insert into `dynamic_api_setting` (`key_name`, `description`, `url`, `token`, `app_id`, `api_key`, `api_secret`, `method`, `body_type`, `body_template`, `header`, `auth_type`, `protocol`, `data_path`, `data_type` ) values ("amap_geo","高德-将详细的结构化地址转换为经纬度坐标","http://1.94.150.175:8087/mcp/amap?method=maps_geo","sk-sBI9a8/7FnDj18AJhx+F5WSZvs9O57oX9wYDv/GGh0s=","","","","post","template",'{"city":"${{city}}","address":"${{address}}"}','{"Authorization": "Bearer ${{token}}", "Content-Type": "application/json"}',"codeflying","http","$.data.content[0].text","json" );
insert into `dynamic_api_setting` (`key_name`, `description`, `url`, `token`, `app_id`, `api_key`, `api_secret`, `method`, `body_type`, `body_template`, `header`, `auth_type`, `protocol`, `data_path`, `data_type` ) values ("amap_regeocode","高德-经纬度坐标转换为行政区划地址信息","http://1.94.150.175:8087/mcp/amap?method=maps_regeocode","sk-sBI9a8/7FnDj18AJhx+F5WSZvs9O57oX9wYDv/GGh0s=","","","","post","template",'{"location":"${{location}}"}','{"Authorization": "Bearer ${{token}}", "Content-Type": "application/json"}',"codeflying","http","$.data.content[0].text","json" );
insert into `dynamic_api_setting` (`key_name`, `description`, `url`, `token`, `app_id`, `api_key`, `api_secret`, `method`, `body_type`, `body_template`, `header`, `auth_type`, `protocol`, `data_path`, `data_type` ) values ("amap_direction_driving","高德-驾车路径规划","http://1.94.150.175:8087/mcp/amap?method=maps_direction_driving","sk-sBI9a8/7FnDj18AJhx+F5WSZvs9O57oX9wYDv/GGh0s=","","","","post","template",'{"origin":"${{origin}}","destination":"${{destination}}"}','{"Authorization": "Bearer ${{token}}", "Content-Type": "application/json"}',"codeflying","http","$.data.content[0].text","json" );

drop table if exists `login`;

    create table `login` (
        `login_id`      INTEGER PRIMARY KEY AUTOINCREMENT,
        `relevance_id`  VARCHAR ,
        `password`      VARCHAR ,
        `user_name`     VARCHAR ,
        `relevance_table`       VARCHAR ,
        `phone_number`  VARCHAR ,
        `wx_open_id`    VARCHAR
    );
    
    insert into `login` (`relevance_id`,`password`,`user_name`,`relevance_table`,`phone_number`,`wx_open_id` ) values ("","$2a$10$bOrRjyHCMT2DUnXoVuFWNO1dSd6Zj/fyjS0TETmcD1ZXlR/BGklc2","admin","","admin","" );
    
    insert into `login` (`relevance_id`,`password`,`user_name`,`relevance_table`,`phone_number`,`wx_open_id` ) values ("1","$2a$10$bOrRjyHCMT2DUnXoVuFWNO1dSd6Zj/fyjS0TETmcD1ZXlR/BGklc2","test","userInfo","18852718858","" );
