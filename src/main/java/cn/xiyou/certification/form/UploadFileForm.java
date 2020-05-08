package cn.xiyou.certification.form;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午4:02
 * @description:
 */
@Data
public class UploadFileForm {
    private String name;

    private int type;

    private String author;
}
