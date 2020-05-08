package cn.xiyou.certification.controller;

import cn.xiyou.certification.form.LabForm;
import cn.xiyou.certification.form.LabUpdateForm;
import cn.xiyou.certification.query.LabIntroQuery;
import cn.xiyou.certification.service.LabService;
import cn.xiyou.certification.utils.API;
import cn.xiyou.certification.utils.ResultVOUtil;
import cn.xiyou.certification.vo.LabDetailVO;
import cn.xiyou.certification.vo.LabIntroVO;
import cn.xiyou.certification.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午2:37
 * @description:
 */
@RestController
@Slf4j
@Api(value = "实验室", tags = "实验室")
public class LabController {
    @Autowired
    private LabService service;

    @RequestMapping(value = API.API_LAB + "/find", method = RequestMethod.POST)
    @ApiOperation(value = "查找所有实验室简介")
    public ResultVO<PageInfo<LabIntroVO>> findLabIntro(@RequestBody LabIntroQuery query) {

        return ResultVOUtil.success(service.findLabIntro(query));
    }

    @RequestMapping(value = API.API_LAB + "/findById", method = RequestMethod.POST)
    @ApiOperation(value = "查找实验室详情")
    public ResultVO<LabDetailVO> findLabDetail(int id) {
        return ResultVOUtil.success(service.findLabDetail(id));
    }

    @RequestMapping(value = API.API_LAB + "/add", method = RequestMethod.POST)
    @ApiOperation(value = "添加实验室")
    public ResultVO<Boolean> addSchedule(@RequestBody LabForm form) {
        return ResultVOUtil.success(service.addLab(form));
    }

    @RequestMapping(value = API.API_LAB + "/remove", method = RequestMethod.GET)
    @ApiOperation(value = "删除实验室")
    public ResultVO<Boolean> removeSchedule(int id) {
        return ResultVOUtil.success(service.removeLab(id));
    }

    @RequestMapping(value = API.API_LAB + "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改实验室")
    public ResultVO<Boolean> updateSchedule(@RequestBody LabUpdateForm form) {
        return ResultVOUtil.success(service.updateLab(form));
    }
}
