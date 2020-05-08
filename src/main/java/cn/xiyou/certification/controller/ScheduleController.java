package cn.xiyou.certification.controller;

import cn.xiyou.certification.dataobject.Actives;
import cn.xiyou.certification.form.ScheduleForm;
import cn.xiyou.certification.query.FileFindQuery;
import cn.xiyou.certification.query.ScheduleQuery;
import cn.xiyou.certification.service.ScheduleService;
import cn.xiyou.certification.utils.API;
import cn.xiyou.certification.utils.ResultVOUtil;
import cn.xiyou.certification.vo.ActivesVO;
import cn.xiyou.certification.vo.FileVO;
import cn.xiyou.certification.vo.ResultVO;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: 紫苏
 * @date: 19-10-25 下午3:58
 * @description:
 */

@RestController
@Slf4j
@Api(value = "日程", tags = "日程")
public class ScheduleController {

    @Autowired
    private ScheduleService service;

    @RequestMapping(value = API.API_SCHEDULE + "/find", method = RequestMethod.POST)
    @ApiOperation(value = "查找所有日程")
    public ResultVO<PageInfo<FileVO>> findFileByType(@RequestBody ScheduleQuery query) {

        return ResultVOUtil.success(service.findAllSchedule(query));
    }

    @RequestMapping(value = API.API_SCHEDULE + "/count", method = RequestMethod.GET)
    @ApiOperation(value = "查询日程的天数")
    public ResultVO<Integer> countDate() {
        return ResultVOUtil.success(service.countDate());
    }

    @RequestMapping(value = API.API_SCHEDULE + "/query", method = RequestMethod.GET)
    @ApiOperation(value = "查询当天日程")
    public ResultVO<ActivesVO> query(@RequestParam int day) {
        return ResultVOUtil.success(service.queryActive(day));
    }

    @RequestMapping(value = API.API_SCHEDULE + "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加日程")
    public ResultVO<Boolean> addSchedule(@RequestBody ScheduleForm form) {
        return ResultVOUtil.success(service.addSchedule(form));
    }

    @RequestMapping(value = API.API_SCHEDULE + "/remove", method = RequestMethod.GET)
    @ApiOperation(value = "删除日程")
    public ResultVO<Boolean> removeSchedule(int id) {
        return ResultVOUtil.success(service.removeSchedule(id));
    }

    @RequestMapping(value = API.API_SCHEDULE + "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改日程")
    public ResultVO<Boolean> updateSchedule(@RequestBody ScheduleForm form) {
        return ResultVOUtil.success(service.updateSchedule(form));
    }
}
