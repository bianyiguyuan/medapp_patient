// import request from '@/utils/request';

import service from "@/utils/request";
const BASE_API = "/memberLevelEnumStatistics";

export default {
member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count(data){
  return service({
    url: BASE_API + "/member_level_enum_member_level_enum_id_status_statistic_8fd8732a_count",
    method: "post",
    data:data
  });
},
member_level_enum_member_level_enum_id_status_statistic_72e02317_count(data){
  return service({
    url: BASE_API + "/member_level_enum_member_level_enum_id_status_statistic_72e02317_count",
    method: "post",
    data:data
  });
},
member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count(data){
  return service({
    url: BASE_API + "/member_level_enum_member_level_enum_id_status_statistic_22ba9e80_count",
    method: "post",
    data:data
  });
},
};
