drop table if exists `order_status_enum`;
create table `order_status_enum` (
	order_status_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	status_name	varchar(512)	not null
);insert into	order_status_enum	(order_status_enum_id,status_name)	values	("1","待支付");
insert into	order_status_enum	(order_status_enum_id,status_name)	values	("2","已支付");
insert into	order_status_enum	(order_status_enum_id,status_name)	values	("3","已取消");
