package cn.xiyou.certification.dao;

import cn.xiyou.certification.dataobject.Actives;
import cn.xiyou.certification.dataobject.Files;
import cn.xiyou.certification.form.ScheduleForm;
import cn.xiyou.certification.vo.ActivesVO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: 紫苏
 * @date: 19-10-25 下午4:12
 * @description:
 */
@Component
@Mapper
public interface ScheduleDao {

    @Select("select count(*) " +
            "from(" +
            "select count(*) from actives where is_deleted = 0 group by day" +
            ") actives")
    int countDate();

    @Select("select id, day, start_time, end_time, title, time_frame, participant, location " +
            "from actives " +
            "where day = #{day} " +
            "and is_deleted = 0")
    List<Actives> queryActive(int day);

    @Insert("insert into actives(day, start_time, end_time, title, time_frame, participant, location)\n" +
            "value (#{form.day}, #{form.startTime}, #{form.endTime}, #{form.title}, #{form.timeFrame}, #{form.participant}, #{form.location})")
    int addSchedule(@Param("form") ScheduleForm form);

    @Update("update actives\n" +
            "set is_deleted = 1\n" +
            "where id = #{id}")
    int removeSchedule(int id);

    @Update("update actives set day = #{form.day}, " +
            "start_time = #{form.startTime}, " +
            "end_time = #{form.endTime}, " +
            "title = #{form.title}, " +
            "time_frame #{form.timeFrame}, " +
            "participant = #{form.participant}, " +
            "location = #{form.location} " +
            "where id = #{form.id}")
    int updateSchedule(@Param("form") ScheduleForm form);

    @Select("select id, day, start_time, end_time, title, time_frame, participant, location " +
            "from actives " +
            "where is_deleted = 0 " +
            "order by day, start_time")
    List<ActivesVO> findAllSchedule();
}
