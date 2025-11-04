drop table if exists `appointment_status_enum`;
create table `appointment_status_enum` (
	appointment_status_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	status_name	varchar(512)	not null
);insert into	appointment_status_enum	(appointment_status_enum_id,status_name)	values	("1","待支付");
insert into	appointment_status_enum	(appointment_status_enum_id,status_name)	values	("2","已支付");
insert into	appointment_status_enum	(appointment_status_enum_id,status_name)	values	("3","已取消");
