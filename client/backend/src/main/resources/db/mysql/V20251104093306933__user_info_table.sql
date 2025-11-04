drop table if exists `user_info`;
create table `user_info` (
	user_info_id	INT	 not null auto_increment,
	phone_number	VARCHAR(64)	not null,
	username	varchar(512)	,
	password	VARCHAR(64)	not null,
	email	VARCHAR(64)	,
	member_level_id	INT	,
	avatar_resource_key	varchar(255)		default	'avatar_resource_key',
	primary key (user_info_id)
);insert into	user_info	(password,member_level_id,phone_number,user_info_id,email,username)	values	("pass1234","1","13800138000","1","xiaofeifei@example.com","小飞飞");
insert into	user_info	(password,member_level_id,phone_number,user_info_id,email,username)	values	("password1","2","13900139000","2","meilihua@example.com","美丽花");
insert into	user_info	(password,member_level_id,phone_number,user_info_id,email,username)	values	("mypassword","3","13700137000","3","jiankangbao@example.com","健康宝");
insert into	user_info	(password,member_level_id,phone_number,user_info_id,email,username)	values	("securepass","1","13600136000","4","yanzhiwang@example.com","颜值王");
insert into	user_info	(password,member_level_id,phone_number,user_info_id,email,username)	values	("fashion123","2","13500135000","5","shishang@example.com","时尚达人");
insert into	user_info	(password,member_level_id,phone_number,user_info_id,email,username)	values	("expert2024","3","13400134000","6","meirongzj@example.com","美容专家");
