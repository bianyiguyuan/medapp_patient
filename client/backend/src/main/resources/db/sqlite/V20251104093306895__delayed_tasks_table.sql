drop table if exists `delayed_tasks`;
create table `delayed_tasks` (
	id	INTEGER PRIMARY KEY AUTOINCREMENT,
	task_type	varchar(512)	not null,
	task_data	varchar(512)	not null,
	status	varchar(512)	not null,
	execute_time	DATETIME	not null,
	create_time	DATETIME	not null,
	update_time	DATETIME	not null
);