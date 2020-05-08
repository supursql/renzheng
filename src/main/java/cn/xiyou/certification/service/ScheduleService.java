package cn.xiyou.certification.service;

import cn.xiyou.certification.dao.ScheduleDao;
import cn.xiyou.certification.dataobject.Actives;
import cn.xiyou.certification.dataobject.Files;
import cn.xiyou.certification.form.ScheduleForm;
import cn.xiyou.certification.query.ScheduleQuery;
import cn.xiyou.certification.utils.PagedResult;
import cn.xiyou.certification.vo.ActivesVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 紫苏
 * @date: 19-10-25 下午3:59
 * @description:
 */

@Service
@Slf4j
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    public int countDate() {
        return scheduleDao.countDate();
    }

    public List<ActivesVO> queryActive(int day) {

        return scheduleDao.queryActive(day).stream().map(
                actives -> new ActivesVO(
                        actives.getId(),
                        actives.getDay(),
                        actives.getStartTime(),
                        actives.getEndTime(),
                        actives.getTitle(),
                        actives.getTimeFrame(),
                        actives.getParticipant(),
                        actives.getLocation())
        ).collect(Collectors.toList());
    }

    public Boolean addSchedule(ScheduleForm form) {
        return scheduleDao.addSchedule(form) == 1;
    }

    public Boolean removeSchedule(int id) {
        return scheduleDao.removeSchedule(id) == 1;
    }

    public Boolean updateSchedule(ScheduleForm form) {
        return scheduleDao.updateSchedule(form) == 1;
    }

    public PagedResult findAllSchedule(ScheduleQuery query) {

        PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<ActivesVO> list = scheduleDao.findAllSchedule();


        PageInfo<ActivesVO> pageList = new PageInfo<>(list);

        PagedResult res = new PagedResult();
        res.setTotal(pageList.getPages());
        res.setRows(list);
        res.setPage(query.getPageNo());
        res.setRecords(pageList.getTotal());

        return res;
    }
}
