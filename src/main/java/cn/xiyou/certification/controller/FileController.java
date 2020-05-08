package cn.xiyou.certification.controller;

import cn.xiyou.certification.form.FileUpdateForm;
import cn.xiyou.certification.query.FileFindQuery;
import cn.xiyou.certification.service.FileService;
import cn.xiyou.certification.utils.API;
import cn.xiyou.certification.utils.ResultVOUtil;
import cn.xiyou.certification.vo.FileVO;
import cn.xiyou.certification.vo.ResultVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 * @author: 紫苏
 * @date: 2019/11/4 上午11:35
 * @description:
 */
@RestController
@Slf4j
@Api(value = "文件", tags = "文件")
public class FileController {

    @Autowired
    private FileService service;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @RequestMapping(value = API.API_FIFE + "/find", method = RequestMethod.POST)
    @ApiOperation(value = "按文件类型查找文件")
    public ResultVO<PageInfo<FileVO>> findFileByType(@RequestBody FileFindQuery query) {

        return ResultVOUtil.success(service.findFileByType(query));
    }


    @RequestMapping(value = API.API_FIFE + "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "上传文件")
    public ResultVO<Boolean> upload(MultipartFile file, String author, String fileName, int type, int belongLabId) throws IOException {

        if (file.isEmpty()) {
            return ResultVOUtil.success(false);
        }

        String oldName = file.getOriginalFilename();

        int index = oldName.lastIndexOf(".");

        String newName = new StringBuilder(String.valueOf(UUID.randomUUID())).append(oldName.hashCode()).append(".").append(oldName.substring(index + 1)).toString();
        System.out.println(newName);


        File path = new File(ResourceUtils.getURL("classpath:").getPath());

        File upload = new File(path.getAbsolutePath(),"static/");
        if(!upload.exists()) {
            upload.mkdirs();
        }

        String filePath = upload.getAbsolutePath() + "/";
        File dest = new File(filePath + newName);
        try {
            file.transferTo(dest);
            log.info("上传成功");
            service.save(newName, author, fileName, type, belongLabId);
            return ResultVOUtil.success(true);
        } catch (IOException e) {
            log.error(e.toString(), e);
        }

        return ResultVOUtil.success(false);
    }

    @RequestMapping(value = API.API_FIFE + "/remove", method = RequestMethod.GET)
    @ApiOperation(value = "删除文件")
    public ResultVO<Boolean> remove(int id) {
        return ResultVOUtil.success(service.remove(id));
    }

    @RequestMapping(value = API.API_FIFE + "/update", method = RequestMethod.POST)
    @ApiOperation(value = "修改文件基本信息")
    public ResultVO<Boolean> update(@RequestBody FileUpdateForm form) {
        return ResultVOUtil.success(service.update(form));
    }


}
