drop table if exists `commission_info`;
create table `commission_info` (
	commission_info_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	user_info_user_info_id_3	INTEGER	not null,
	commission_ratio	DECIMAL(18,6)	not null,
	total_earnings	DECIMAL(18,6)	not null
);insert into	commission_info	(commission_info_id,total_earnings,commission_ratio,user_info_user_info_id_3)	values	("1","1200.5","0.1","1");
insert into	commission_info	(commission_info_id,total_earnings,commission_ratio,user_info_user_info_id_3)	values	("2","2500.0","0.15","2");
insert into	commission_info	(commission_info_id,total_earnings,commission_ratio,user_info_user_info_id_3)	values	("3","1800.75","0.12","3");
insert into	commission_info	(commission_info_id,total_earnings,commission_ratio,user_info_user_info_id_3)	values	("4","900.0","0.08","4");
insert into	commission_info	(commission_info_id,total_earnings,commission_ratio,user_info_user_info_id_3)	values	("5","3200.0","0.2","5");
insert into	commission_info	(commission_info_id,total_earnings,commission_ratio,user_info_user_info_id_3)	values	("6","1500.25","0.1","6");
