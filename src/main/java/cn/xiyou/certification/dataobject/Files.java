package cn.xiyou.certification.dataobject;

import lombok.Data;

import java.util.Date;

/**
 * @author: 紫苏
 * @date: 2019/11/4 上午11:52
 * @description:
 */
@Data
public class Files {

    /**
     * 文件id
     */
    private int id;

    /**
     * 文件名称
     */
    private String name;

    /**
     * 文件的链接
     */
    private String link;

    /**
     * 文件的类型(0:word, 1:excel, 2:powerpoint, 3:pdf, 4:其他)
     */
    private int type;

    /**
     * 从属实验室的id
     */
    private int belongLabId;

    /**
     * 作者
     */
    private String author;

    /**
     * 更新时间
     */
    private Date updateAt;

}
