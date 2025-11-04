package com.kuafu.web.vo;

import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;
import lombok.NoArgsConstructor;
import com.kuafu.common.domin.StaticResource;
import java.util.List;

/**
 * <p>延迟任务</p>
 *
 * @author kuafuai
 * @description
 * @date 2025/11/04 09:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DelayedTasksVO  {

     @JsonProperty(value = "id")
    private Integer id;
     @JsonProperty(value = "taskType")
    private String taskType;
     @JsonProperty(value = "taskData")
    private String taskData;
     @JsonProperty(value = "status")
    private String status;
     @JsonProperty(value = "executeTime")
    private Date executeTime;
     @JsonProperty(value = "createTime")
    private Date createTime;
     @JsonProperty(value = "updateTime")
    private Date updateTime;


}
