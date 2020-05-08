package cn.xiyou.certification.dao;

import cn.xiyou.certification.dataobject.Laboratory;
import cn.xiyou.certification.form.LabForm;
import cn.xiyou.certification.form.LabUpdateForm;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午2:54
 * @description:
 */
@Component
@Mapper
public interface LabDao {

    @Select("select id, name, principal, image_url, location\n" +
            "from laboratory\n" +
            "where is_deleted = 0")
    List<Laboratory> findLabIntro();

    @Select("select id, name, detail, principal, image_url, video_url, location\n" +
            "from laboratory\n" +
            "where id = #{id}\n" +
            "and is_deleted = 0")
    Laboratory findLabDetail(int id);

    @Insert("insert into laboratory(name, detail, principal, image_url, video_url, location)\n" +
            "value (#{form.name}, #{form.detail}, #{form.principal}, #{form.imageUrl}, #{form.videoUrl}, #{form.location})")
    int addLab(@Param("form") LabForm form);

    @Update("update laboratory\n" +
            "set is_deleted = 1\n" +
            "where id = #{id}")
    int removeLab(int id);

    @Update("update laboratory\n" +
            "set name = #{form.name}\n" +
            "detail = #{form.detail}\n" +
            "principal = #{form.principal}\n" +
            "image_url = #{form.imageUrl}\n" +
            "video_url = #{form.videoUrl}\n" +
            "location = #{form.location}\n" +
            "where id = #{form.id}")
    int updateLab(@Param("form") LabUpdateForm form);
}
