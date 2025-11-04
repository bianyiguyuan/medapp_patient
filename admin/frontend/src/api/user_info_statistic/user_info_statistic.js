// import request from '@/utils/request';

import service from "@/utils/request";
const BASE_API = "/userInfoStatistics";

export default {
user_info_statistic_b8e54625_count(data){
  return service({
    url: BASE_API + "/user_info_statistic_b8e54625_count",
    method: "post",
    data:data
  });
},
user_info_statistic_d3ee33f0_count(data){
  return service({
    url: BASE_API + "/user_info_statistic_d3ee33f0_count",
    method: "post",
    data:data
  });
},
user_info_statistic_d0fbf2c7_count(data){
  return service({
    url: BASE_API + "/user_info_statistic_d0fbf2c7_count",
    method: "post",
    data:data
  });
},
};
