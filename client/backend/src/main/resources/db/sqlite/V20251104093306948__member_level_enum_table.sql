drop table if exists `member_level_enum`;
create table `member_level_enum` (
	member_level_enum_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	level_name	varchar(512)	not null,
	description	TEXT	
);insert into	member_level_enum	(level_name,description,member_level_enum_id)	values	("普通会员","普通会员描述","1");
insert into	member_level_enum	(level_name,description,member_level_enum_id)	values	("黄金会员","黄金会员描述","2");
insert into	member_level_enum	(level_name,description,member_level_enum_id)	values	("钻石会员","钻石会员描述","3");
