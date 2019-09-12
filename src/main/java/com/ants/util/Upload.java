//package com.ants.util;
//
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.servlet.http.HttpServletRequest;
//import java.io.File;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @Author czd
// * @Date:created in 2019/10/11
// * @Version: V1.0
// */
//public class Upload {
//
//    public static Map<String, String> uploadPhoto(MultipartFile photo, HttpServletRequest request){
//        Map<String, String> upload = new HashMap<>();
//
//        if (photo == null) {
//            upload.put("type", "error");
//            upload.put("errorMessage", "选择要上传的文件！");
//            return upload;
//        }
//        if (photo.getSize() > 1024 * 1024 * 1024) {
//            upload.put("type", "error");
//            upload.put("errorMessage", "文件大小不能超过10M！");
//            return upload;
//        }
//        //获取文件后缀
//        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1, photo.getOriginalFilename().length());
//        if (!"jpg,jpeg,gif,png".toUpperCase().contains(suffix.toUpperCase())) {
//            upload.put("errorType", "error");
//            upload.put("errorMessage", "请选择jpg,jpeg,gif,png格式的图片！");
//            return upload;
//        }
//        String savePath = request.getServletContext().getRealPath("/") + "resources\\images\\";
//        File savePathFile = new File(savePath);
//        if (!savePathFile.exists()) {
//            //若不存在改目录，则创建目录
//            savePathFile.mkdirs();
//        }
//        String fileName = new Date().getTime() + "." + suffix;
//        System.out.println("FILENAME=" + fileName);
//        try {
//            //将文件保存至指定目录
//            photo.transferTo(new File(savePath + fileName));
//        } catch (Exception e) {
//            upload.put("errorType", "error");
//            upload.put("errorMessage", "保存文件异常！");
//            e.printStackTrace();
//            return upload;
//        }
//        upload.put("errorType", "success");
//        upload.put("errorMessage", "用户上传成功！");
//        upload.put("filepath", savePath + fileName);
//        return upload;
//    }
//}
