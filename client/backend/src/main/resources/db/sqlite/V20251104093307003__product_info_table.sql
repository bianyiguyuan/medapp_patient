drop table if exists `product_info`;
create table `product_info` (
	product_info_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	product_name	varchar(512)	not null,
	price	DECIMAL(18,6)	not null,
	image_resource_key	varchar(255)		default	'image_resource_key',
	coupon_amount	DECIMAL(18,6)	,
	mini_program_path	varchar(512)	
);insert into	product_info	(coupon_amount,mini_program_path,product_info_id,price,product_name)	values	("200.0","pages/product1","1","2999.0","玻尿酸注射");
insert into	product_info	(coupon_amount,mini_program_path,product_info_id,price,product_name)	values	("300.0","pages/product2","2","4999.0","激光美白套餐");
insert into	product_info	(coupon_amount,mini_program_path,product_info_id,price,product_name)	values	("50.0","pages/product3","3","899.0","抗衰老精华液");
insert into	product_info	(coupon_amount,mini_program_path,product_info_id,price,product_name)	values	("1000.0","pages/product4","4","15000.0","面部提升手术");
insert into	product_info	(coupon_amount,mini_program_path,product_info_id,price,product_name)	values	("100.0","pages/product5","5","1200.0","皮肤护理套餐");
insert into	product_info	(coupon_amount,mini_program_path,product_info_id,price,product_name)	values	("30.0","pages/product6","6","350.0","定制面膜");
