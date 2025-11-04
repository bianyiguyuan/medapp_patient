drop table if exists `appointment_status_enum`;
create table `appointment_status_enum` (
	appointment_status_enum_id	INT	 not null auto_increment,
	status_name	varchar(512)	not null,
	primary key (appointment_status_enum_id)
);insert into	appointment_status_enum	(appointment_status_enum_id,status_name)	values	("1","待支付");
insert into	appointment_status_enum	(appointment_status_enum_id,status_name)	values	("2","已支付");
insert into	appointment_status_enum	(appointment_status_enum_id,status_name)	values	("3","已取消");
