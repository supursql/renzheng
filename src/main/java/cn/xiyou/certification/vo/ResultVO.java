package cn.xiyou.certification.vo;

import lombok.Data;

/**
 * @author: 紫苏
 * @date: 19-10-25 下午4:07
 * @description:
 */
@Data
public class ResultVO<T> {

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体内容 */
    private T data;

}