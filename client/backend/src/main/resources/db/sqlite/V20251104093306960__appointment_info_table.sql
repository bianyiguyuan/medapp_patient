drop table if exists `appointment_info`;
create table `appointment_info` (
	appointment_info_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	user_info_user_info_id_1	INTEGER	not null,
	doctor_name	varchar(512)	not null,
	appointment_date	DATETIME	not null,
	appointment_time	varchar(512)	not null,
	status_enum_id	INTEGER	not null,
	deposit_paid	BOOL	,
	deposit_amount	DECIMAL(18,6)	,
	coupon_received	BOOL	,
	appointment_code	varchar(512)	
);insert into	appointment_info	(deposit_amount,status_enum_id,appointment_time,coupon_received,appointment_info_id,user_info_user_info_id_1,appointment_date,appointment_code,doctor_name,deposit_paid)	values	("100.0","2","09:00-10:00","true","1","1","2024-07-01 00:00:00.0","APPT20240701001","张医生","true");
insert into	appointment_info	(deposit_amount,status_enum_id,appointment_time,coupon_received,appointment_info_id,user_info_user_info_id_1,appointment_date,appointment_code,doctor_name,deposit_paid)	values	("0.0","1","14:00-15:00","false","2","2","2024-07-02 00:00:00.0","APPT20240702002","李医生","false");
insert into	appointment_info	(deposit_amount,status_enum_id,appointment_time,coupon_received,appointment_info_id,user_info_user_info_id_1,appointment_date,appointment_code,doctor_name,deposit_paid)	values	("100.0","2","16:00-17:00","true","3","3","2024-07-03 00:00:00.0","APPT20240703003","王医生","true");
insert into	appointment_info	(deposit_amount,status_enum_id,appointment_time,coupon_received,appointment_info_id,user_info_user_info_id_1,appointment_date,appointment_code,doctor_name,deposit_paid)	values	("0.0","3","10:00-11:00","false","4","4","2024-07-04 00:00:00.0","APPT20240704004","赵医生","false");
insert into	appointment_info	(deposit_amount,status_enum_id,appointment_time,coupon_received,appointment_info_id,user_info_user_info_id_1,appointment_date,appointment_code,doctor_name,deposit_paid)	values	("100.0","2","13:00-14:00","true","5","5","2024-07-05 00:00:00.0","APPT20240705005","钱医生","true");
insert into	appointment_info	(deposit_amount,status_enum_id,appointment_time,coupon_received,appointment_info_id,user_info_user_info_id_1,appointment_date,appointment_code,doctor_name,deposit_paid)	values	("0.0","1","15:00-16:00","false","6","6","2024-07-06 00:00:00.0","APPT20240706006","孙医生","false");
