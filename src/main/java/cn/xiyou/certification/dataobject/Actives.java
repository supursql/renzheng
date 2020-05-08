package cn.xiyou.certification.dataobject;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: 紫苏
 * @date: 19-10-25 下午4:40
 * @description:
 */
@Data
public class Actives {

    private int id;

    private int day;

    private String startTime;

    private String endTime;

    private String title;

    private int timeFrame;

    private String participant;

    private String location;

    @Override
    public String toString() {
        return "Actives{" +
                "id=" + id +
                ", day=" + day +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", title='" + title + '\'' +
                ", timeFrame=" + timeFrame +
                ", participant='" + participant + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
