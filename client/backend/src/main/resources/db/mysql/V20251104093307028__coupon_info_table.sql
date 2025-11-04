drop table if exists `coupon_info`;
create table `coupon_info` (
	coupon_info_id	INT	 not null auto_increment,
	user_info_user_info_id_4	INT	not null,
	amount	DECIMAL(18,6)	not null,
	is_used	BOOL	,
	primary key (coupon_info_id)
);insert into	coupon_info	(amount,coupon_info_id,user_info_user_info_id_4,is_used)	values	("50.0","1","1","false");
insert into	coupon_info	(amount,coupon_info_id,user_info_user_info_id_4,is_used)	values	("100.0","2","2","true");
insert into	coupon_info	(amount,coupon_info_id,user_info_user_info_id_4,is_used)	values	("30.0","3","3","false");
insert into	coupon_info	(amount,coupon_info_id,user_info_user_info_id_4,is_used)	values	("20.0","4","4","true");
insert into	coupon_info	(amount,coupon_info_id,user_info_user_info_id_4,is_used)	values	("80.0","5","5","false");
insert into	coupon_info	(amount,coupon_info_id,user_info_user_info_id_4,is_used)	values	("60.0","6","6","false");
