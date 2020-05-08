package cn.xiyou.certification.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 紫苏
 * @date: 2019/11/4 上午11:44
 * @description:
 */
@Data
public class ActivesVO {

    @ApiModelProperty(name = "id", value = "行程id")
    private int id;

    @ApiModelProperty(name = "day", value = "天数")
    private int day;

    @ApiModelProperty(name = "startTime", value = "开始时间")
    private String startTime;

    @ApiModelProperty(name = "endTime", value = "结束时间")
    private String endTime;

    @ApiModelProperty(name = "title", value = "标题")
    private String title;

    @ApiModelProperty(name = "timeFrame", value = "时段")
    private int timeFrame;

    @ApiModelProperty(name = "participant", value = "参与人")
    private String participant;

    @ApiModelProperty(name = "location", value = "地址")
    private String location;

    public ActivesVO(int id, int day, String startTime, String endTime, String title, int timeFrame, String participant, String location) {
        this.id = id;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.timeFrame = timeFrame;
        this.participant = participant;
        this.location = location;
    }
}
