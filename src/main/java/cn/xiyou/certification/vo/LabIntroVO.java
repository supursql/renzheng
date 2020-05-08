package cn.xiyou.certification.vo;

import lombok.Data;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午2:41
 * @description:
 */
@Data
public class LabIntroVO {

    private int id;

    private String name;

    private String principal;

    private String imageUrl;

    private String location;

    public LabIntroVO(int id, String name, String principal, String imageUrl, String location) {
        this.id = id;
        this.name = name;
        this.principal = principal;
        this.imageUrl = imageUrl;
        this.location = location;
    }
}
