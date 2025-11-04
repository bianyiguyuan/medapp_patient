drop table if exists `order_info`;
create table `order_info` (
	order_info_id	INT	 not null auto_increment,
	user_info_user_info_id_5	INT	not null,
	product_info_product_info_id	INT	not null,
	quantity	INT	not null,
	total_price	DECIMAL(18,6)	not null,
	order_status_enum_id	INT	not null,
	payment_order_no	VARCHAR(64)	,
	primary key (order_info_id)
);insert into	order_info	(payment_order_no,order_info_id,quantity,product_info_product_info_id,total_price,order_status_enum_id,user_info_user_info_id_5)	values	("ORD20240701001","1","1","1","2999.0","2","1");
insert into	order_info	(payment_order_no,order_info_id,quantity,product_info_product_info_id,total_price,order_status_enum_id,user_info_user_info_id_5)	values	("ORD20240702002","2","2","3","1798.0","1","2");
insert into	order_info	(payment_order_no,order_info_id,quantity,product_info_product_info_id,total_price,order_status_enum_id,user_info_user_info_id_5)	values	("ORD20240703003","3","1","2","4999.0","2","3");
insert into	order_info	(payment_order_no,order_info_id,quantity,product_info_product_info_id,total_price,order_status_enum_id,user_info_user_info_id_5)	values	("ORD20240704004","4","3","5","0.0","3","4");
insert into	order_info	(payment_order_no,order_info_id,quantity,product_info_product_info_id,total_price,order_status_enum_id,user_info_user_info_id_5)	values	("ORD20240705005","5","3","6","0.0","1","5");
insert into	order_info	(payment_order_no,order_info_id,quantity,product_info_product_info_id,total_price,order_status_enum_id,user_info_user_info_id_5)	values	("ORD20240706006","6","1","4","15000.0","2","6");
