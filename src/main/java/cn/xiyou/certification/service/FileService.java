package cn.xiyou.certification.service;

import cn.xiyou.certification.dao.FileDao;
import cn.xiyou.certification.dataobject.Files;
import cn.xiyou.certification.form.FileUpdateForm;
import cn.xiyou.certification.query.FileFindQuery;
import cn.xiyou.certification.utils.PagedResult;
import cn.xiyou.certification.vo.FileVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: 紫苏
 * @date: 2019/11/4 上午11:50
 * @description:
 */
@Service
@Slf4j
public class FileService {

    @Autowired
    private FileDao dao;

    public PagedResult findFileByType(FileFindQuery query) {

        PageHelper.startPage(query.getPageNo(), query.getPageSize());

        List<Files> list = new ArrayList<>();

        if (query.getType() == -1) {
            list = dao.findFiles();
        } else {
            list = dao.findFileByType(query.getType());
        }

        PageInfo<Files> pageList = new PageInfo<>(list);

        PagedResult res = new PagedResult();
        res.setTotal(pageList.getPages());
        res.setRows(list);
        res.setPage(query.getPageNo());
        res.setRecords(pageList.getTotal());

        return res;
    }

    public List<FileVO> findFileByBelongLabId(int belongLabId) {
        return dao.findFileByBelongLabId(belongLabId).stream().map(
                files -> new FileVO(
                        files.getId(),
                        files.getName(),
                        files.getLink(),
                        files.getType(),
                        files.getBelongLabId(),
                        files.getAuthor(),
                        files.getUpdateAt()
                )
        ).collect(Collectors.toList());
    }

    public void save(String newName, String author, String fileName, int type, int belongLabId) {

        log.warn(fileName);
        log.warn(author);

        dao.save(newName, author, fileName, type, belongLabId);

    }

    public boolean remove(int id) {
        return dao.remove(id) == 1;
    }

    public boolean update(FileUpdateForm form) {
        return dao.update(form) == 1;
    }
}
