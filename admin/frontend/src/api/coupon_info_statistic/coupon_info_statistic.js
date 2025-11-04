// import request from '@/utils/request';

import service from "@/utils/request";
const BASE_API = "/couponInfoStatistics";

export default {
coupon_info_statistic_d903bc2c_count(data){
  return service({
    url: BASE_API + "/coupon_info_statistic_d903bc2c_count",
    method: "post",
    data:data
  });
},
coupon_info_statistic_e2133559_count(data){
  return service({
    url: BASE_API + "/coupon_info_statistic_e2133559_count",
    method: "post",
    data:data
  });
},
coupon_info_statistic_76e50a69_count(data){
  return service({
    url: BASE_API + "/coupon_info_statistic_76e50a69_count",
    method: "post",
    data:data
  });
},
};
