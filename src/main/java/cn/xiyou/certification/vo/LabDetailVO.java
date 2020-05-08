package cn.xiyou.certification.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午2:47
 * @description:
 */
@Data
public class LabDetailVO {

    private int id;

    private String name;

    private String detail;

    private String principal;

    private String imageUrl;

    private String videoUrl;

    private String location;

    private List<FileVO> fileList;

    public LabDetailVO(int id, String name, String detail, String principal, String imageUrl, String videoUrl, String location, List<FileVO> fileList) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.principal = principal;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.location = location;
        this.fileList = fileList;
    }
}
