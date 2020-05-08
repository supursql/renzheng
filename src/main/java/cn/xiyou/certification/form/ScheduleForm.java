package cn.xiyou.certification.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午8:37
 * @description:
 */
@Data
public class ScheduleForm {

    @ApiModelProperty(name = "id", value = "日程id")
    private int id;

    @ApiModelProperty(name = "day", value = "第几天")
    private int day;

    @ApiModelProperty(name = "startTime", value = "开始时间")
    private String startTime;

    @ApiModelProperty(name = "endTime", value = "结束时间")
    private String endTime;

    @ApiModelProperty(name = "title", value = "标题")
    private String title;

    @ApiModelProperty(name = "timeFrame", value = "活动时段(0:morning;1:afternoon;2:evening)")
    private int timeFrame;

    @ApiModelProperty(name = "participant", value = "参与人员")
    private String participant;

    @ApiModelProperty(name = "location", value = "地点")
    private String location;

}
