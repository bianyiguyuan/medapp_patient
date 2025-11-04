// import request from '@/utils/request';

import service from "@/utils/request";
const BASE_API = "/faceDetectionInfoStatistics";

export default {
face_detection_info_statistic_bd49b0c1_count(data){
  return service({
    url: BASE_API + "/face_detection_info_statistic_bd49b0c1_count",
    method: "post",
    data:data
  });
},
face_detection_info_statistic_bd9cef3c_count(data){
  return service({
    url: BASE_API + "/face_detection_info_statistic_bd9cef3c_count",
    method: "post",
    data:data
  });
},
face_detection_info_statistic_2006561b_count(data){
  return service({
    url: BASE_API + "/face_detection_info_statistic_2006561b_count",
    method: "post",
    data:data
  });
},
};
