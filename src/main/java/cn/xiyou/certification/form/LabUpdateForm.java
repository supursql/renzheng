package cn.xiyou.certification.form;

import lombok.Data;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午8:55
 * @description:
 */
@Data
public class LabUpdateForm {

    private int id;

    private String name;

    private String detail;

    private String principal;

    private String imageUrl;

    private String videoUrl;

    private String location;

}
