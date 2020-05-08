package cn.xiyou.certification.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: 紫苏
 * @date: 2019/11/4 上午11:51
 * @description:
 */
@Data
public class FileVO {

    @ApiModelProperty(name = "id", value = "文件id")
    private int id;

    @ApiModelProperty(name = "name", value = "文件名称")
    private String name;

    @ApiModelProperty(name = "link", value = "文件链接")
    private String link;

    @ApiModelProperty(name = "type", value = "文件类型(0:word;1:excel;2:ppt;3pdf;4其他)")
    private int type;

    @ApiModelProperty(name = "belongLabId", value = "从属实验室的id")
    private int belongLabId;

    @ApiModelProperty(name = "author", value = "作者")
    private String author;

    @ApiModelProperty(name = "updateAt", value = "修改时间")
    private Date updateAt;

    public FileVO() {
    }

    public FileVO(int id, String name, String link, int type, int belongLabId, String author, Date updateAt) {
        this.id = id;
        this.name = name;
        this.link = link;
        this.type = type;
        this.belongLabId = belongLabId;
        this.author = author;
        this.updateAt = updateAt;
    }
}
