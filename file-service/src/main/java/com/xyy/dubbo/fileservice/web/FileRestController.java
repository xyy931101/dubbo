package com.xyy.dubbo.fileservice.web;

import com.xyy.dubbo.client.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/12 12:50
 * .............................................
 * 佛祖保佑             永无BUG
 * 佛曰:
 * 写字楼里写字间，写字间里程序员；
 * 程序人员写程序，又拿程序换酒钱。
 * 酒醒只在网上坐，酒醉还来网下眠；
 * 酒醉酒醒日复日，网上网下年复年。
 * 但愿老死电脑间，不愿鞠躬老板前；
 * 奔驰宝马贵者趣，公交自行程序员。
 * 别人笑我忒疯癫，我笑自己命太贱；
 * 不见满街漂亮妹，哪个归得程序员？
 */
@RestController
@RequestMapping("/api/file/")
public class FileRestController {


    @Autowired
    private IFileService fileService;

    @RequestMapping(value = "/upload")
    public Object get(MultipartFile file) throws IOException {
        System.out.println("开始上传文件了！！！！");
        String fileName = file.getOriginalFilename();
        String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
        return fileService.uploadFile(file.getInputStream(), file.getSize(),extName);
    }
}
