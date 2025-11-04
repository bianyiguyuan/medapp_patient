drop table if exists `face_detection_info`;
create table `face_detection_info` (
	face_detection_info_id	INTEGER PRIMARY KEY AUTOINCREMENT,
	user_info_user_info_id_2	INTEGER	not null,
	upload_image_resource_key	varchar(255)	not null	default	'upload_image_resource_key',
	impression_age	INTEGER	,
	aging_parts	varchar(512)	,
	deep_analysis_unlocked	BOOL	,
	custom_plan_unlocked	BOOL	
);insert into	face_detection_info	(aging_parts,custom_plan_unlocked,deep_analysis_unlocked,impression_age,user_info_user_info_id_2,face_detection_info_id)	values	("眼角皱纹","false","false","28","1","1");
insert into	face_detection_info	(aging_parts,custom_plan_unlocked,deep_analysis_unlocked,impression_age,user_info_user_info_id_2,face_detection_info_id)	values	("脸颊松弛","false","true","35","2","2");
insert into	face_detection_info	(aging_parts,custom_plan_unlocked,deep_analysis_unlocked,impression_age,user_info_user_info_id_2,face_detection_info_id)	values	("法令纹","true","true","40","3","3");
insert into	face_detection_info	(aging_parts,custom_plan_unlocked,deep_analysis_unlocked,impression_age,user_info_user_info_id_2,face_detection_info_id)	values	("额头细纹","false","false","25","4","4");
insert into	face_detection_info	(aging_parts,custom_plan_unlocked,deep_analysis_unlocked,impression_age,user_info_user_info_id_2,face_detection_info_id)	values	("眼袋","true","false","30","5","5");
insert into	face_detection_info	(aging_parts,custom_plan_unlocked,deep_analysis_unlocked,impression_age,user_info_user_info_id_2,face_detection_info_id)	values	("皮肤暗沉","true","true","33","6","6");
