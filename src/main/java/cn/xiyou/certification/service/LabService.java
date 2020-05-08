package cn.xiyou.certification.service;

import cn.xiyou.certification.dao.LabDao;
import cn.xiyou.certification.dataobject.Laboratory;
import cn.xiyou.certification.form.LabForm;
import cn.xiyou.certification.form.LabUpdateForm;
import cn.xiyou.certification.query.LabIntroQuery;
import cn.xiyou.certification.utils.PagedResult;
import cn.xiyou.certification.vo.LabDetailVO;
import cn.xiyou.certification.vo.LabIntroVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 紫苏
 * @date: 2019/11/4 下午2:41
 * @description:
 */
@Service
public class LabService {

    @Autowired
    private LabDao dao;

    @Autowired
    private FileService service;
    
    public PagedResult findLabIntro(LabIntroQuery query) {
        PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<Laboratory> list = dao.findLabIntro();

        List<LabIntroVO> out = list.stream().map(
                laboratory -> new LabIntroVO(
                        laboratory.getId(),
                        laboratory.getName(),
                        laboratory.getPrincipal(),
                        laboratory.getImageUrl(),
                        laboratory.getLocation()
                )
        ).collect(Collectors.toList());

        PageInfo<Laboratory> pageList = new PageInfo<>(list);

        PagedResult res = new PagedResult();
        res.setTotal(pageList.getPages());
        res.setRows(out);
        res.setPage(query.getPageNo());
        res.setRecords(pageList.getTotal());

        return res;
    }

    public LabDetailVO findLabDetail(int id) {
        Laboratory vo = dao.findLabDetail(id);

        return new LabDetailVO(
                vo.getId(),
                vo.getName(),
                vo.getDetail(),
                vo.getPrincipal(),
                vo.getImageUrl(),
                vo.getVideoUrl(),
                vo.getLocation(),
                service.findFileByBelongLabId(vo.getId())
        );
    }

    public Boolean addLab(LabForm form) {
        return dao.addLab(form) == 1;
    }

    public Boolean removeLab(int id) {
        return dao.removeLab(id) == 1;
    }

    public Boolean updateLab(LabUpdateForm form) {
        return dao.updateLab(form) == 1;
    }
}
