drop table if exists `kf_system_config`;
create table `kf_system_config` (
	id	INT	 not null auto_increment,
	name	varchar(512)	not null,
	chinese_name	varchar(512)	,
	description	varchar(512)	,
	content	TEXT	,
	remark	varchar(512)	,
	type	varchar(512)	,
	primary key (id)
);insert into	kf_system_config	(chinese_name,name,content)	values	("订单多少时间未支付自动关闭，单位分钟","order.expire.time","30");
insert into	kf_system_config	(chinese_name,name,content)	values	("订单多长时间自动确认收货，单位 天","order.automatic.receiptTime","5");
insert into	kf_system_config	(chinese_name,name,content)	values	("订单自动确认收货的定时任务的执行周期","order.automatic.schedule.corn","*/10 * * * * ?");
insert into	kf_system_config	(chinese_name,name)	values	("微信小程序appid","wechat.app-id");
insert into	kf_system_config	(chinese_name,name)	values	("微信小程序secret","wechat.app-secret");
insert into	kf_system_config	(chinese_name,name,content)	values	("默认配置不需要修改","wechat.is-register","0");
insert into	kf_system_config	(chinese_name,name,content)	values	("微信支付回调url","wx.pay.pay-back-url","https://view.kuafuai.net/1238181/api/generalOrder/callback");
insert into	kf_system_config	(chinese_name,name)	values	("微信支付序列号","wx.pay.mch-serial-no");
insert into	kf_system_config	(chinese_name,name)	values	("微信支付对应的appid","wx.pay.app-id");
insert into	kf_system_config	(chinese_name,name)	values	("微信支付商户号","wx.pay.mch-id");
insert into	kf_system_config	(chinese_name,name)	values	("微信支付 apiv3 key","wx.pay.api-v3-key");
insert into	kf_system_config	(chinese_name,name,content)	values	("微信支付是否开启测试,开启测试后，支付金额统一为0.01，正式上线请关闭（true/false）","wx.pay.is_test","true");
insert into	kf_system_config	(chinese_name,name,content)	values	("微信支付测试金额","wx.pay.is_test_amount","0.01");
insert into	kf_system_config	(chinese_name,name,content)	values	("是否开启mock支付（没有申请支付的情况下，true/false）","wx.pay.mock_enable","true");
insert into	kf_system_config	(chinese_name,name,content)	values	("是否开启微信支付(true/false)","wx.pay.wechat_enable","false");
insert into	kf_system_config	(chinese_name,name)	values	("微信公众号的APPID","wx.pay.mp-app-id");
insert into	kf_system_config	(chinese_name,name,content)	values	("重定向的url","wechat.mp-redirect_uri","https://view.kuafuai.net/1238181/api/login/redirect/238181");
insert into	kf_system_config	(name)	values	("wx.pay.mp-app-secret");
insert into	kf_system_config	(chinese_name,name,content)	values	("前端的重定向地址","wechat.mp-frontend_redirect_uri","https://view.kuafuai.net/1238181/");
insert into	kf_system_config	(chinese_name,name)	values	("订单表中的订单状态字段","order.orderStatusField");
insert into	kf_system_config	(chinese_name,name)	values	("系统订单中退款状态与业务订单表退款状态的中的映射关系","order.refundStatusValue");
insert into	kf_system_config	(chinese_name,name)	values	("微信支付私钥内容 （apiclient_key.pem）","wx.pay.private-key");
insert into	kf_system_config	(chinese_name,name,content)	values	("支付商户号的统一前缀(请谨慎修改,该值变化后将使存量的支付订单不可用)","wx.pay.order_pre_key","order-238181-");
