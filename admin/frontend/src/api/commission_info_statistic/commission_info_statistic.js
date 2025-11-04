// import request from '@/utils/request';

import service from "@/utils/request";
const BASE_API = "/commissionInfoStatistics";

export default {
commission_info_statistic_2eb6e6e9_count(data){
  return service({
    url: BASE_API + "/commission_info_statistic_2eb6e6e9_count",
    method: "post",
    data:data
  });
},
commission_info_statistic_715fc2a4_count(data){
  return service({
    url: BASE_API + "/commission_info_statistic_715fc2a4_count",
    method: "post",
    data:data
  });
},
commission_info_statistic_12ffaa16_count(data){
  return service({
    url: BASE_API + "/commission_info_statistic_12ffaa16_count",
    method: "post",
    data:data
  });
},
};
