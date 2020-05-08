package cn.xiyou.certification.dao;

import cn.xiyou.certification.dataobject.Files;
import cn.xiyou.certification.form.FileUpdateForm;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午12:04
 * @description:
 */
@Component
@Mapper
public interface FileDao {

    @Select("select id, name, link, type, belong_lab_id, author, update_at\n" +
            "from files\n" +
            "where type = #{type}\n" +
            "and is_deleted = 0")
    List<Files> findFileByType(int type);

    @Select("select id, name, link, type, belong_lab_id, author, update_at\n" +
            "from files\n" +
            "where is_deleted = 0")
    List<Files> findFiles();

    @Select("select id, name, link, type, belong_lab_id, author, update_at\n" +
            "from files\n" +
            "where belong_lab_id = #{belongLabId}\n" +
            "and is_deleted = 0\n" +
            "order by update_at")
    List<Files> findFileByBelongLabId(int belongLabId);

    @Insert("insert into files(name, link, type, belong_lab_id, author)\n" +
            "values (#{fileName}, #{newName}, #{type}, #{belongLabId}, #{author})")
    void save(String newName, String author, String fileName, int type, int belongLabId);

    @Update("update files\n" +
            "set is_deleted = 1\n" +
            "where id = #{id}")
    int remove(int id);

    @Update("update files\n" +
            "set name = #{form.name}\n" +
            "belong_lab_id = #{form.belongLabId}\n" +
            "author = #{form.author}\n" +
            "where id = #{form.id}")
    int update(@Param("form") FileUpdateForm form);
}
