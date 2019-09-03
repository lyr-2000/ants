package com.ants.controller.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author czd
 */
@Controller
@RequestMapping(value = "/ants/upload")
public class uploadController {

    /**
     * 上传图片
     * @param photo
     * @param request
     * @return
     */
    @RequestMapping(value="/imgUpload",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadPhoto(MultipartFile photo,
                                           HttpServletRequest request){
        Map<String, String> upload = new HashMap<>();

        if (photo == null) {
            upload.put("type", "error");
            upload.put("message", "选择要上传的文件！");
            return upload;
        }
        if (photo.getSize() > 1024 * 1024 * 1024) {
            upload.put("type", "error");
            upload.put("message", "文件大小不能超过10M！");
            return upload;
        }
        //获取文件后缀
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1, photo.getOriginalFilename().length());
        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
            upload.put("type", "error");
            upload.put("message", "请选择jpg,jpeg,gif,png格式的图片！");
            return upload;
        }
        String savePath = request.getServletContext().getRealPath("/") + "resources\\images\\";
        File savePathFile = new File(savePath);
        if (!savePathFile.exists()) {
            //若不存在改目录，则创建目录
            savePathFile.mkdirs();
        }
        String fileName = new Date().getTime() + "." + suffix;
        System.out.println("FILENAME=" + fileName);
        try {
            //将文件保存至指定目录
            photo.transferTo(new File(savePath + fileName));
        } catch (Exception e) {
            upload.put("type", "error");
            upload.put("message", "保存文件异常！");
            e.printStackTrace();
            return upload;
        }
        upload.put("type", "success");
        upload.put("message", "图片上传成功！");
//        upload.put("filepath", savePath + fileName);
        return upload;
    }


}
