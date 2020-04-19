package com.xyy.dubbo.fileservice.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.xyy.dubbo.client.service.IFileService;
import com.xyy.dubbo.fileservice.common.AppConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * @Author: Xiongyy
 * @Date: 2020/4/12 15:18
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

@Component
@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    protected FastFileStorageClient storageClient;

    @Autowired
    private AppConfig appConfig;

    @Override
    public String uploadFile(InputStream inputStream, long fileSize, String fileExtName) {

        StorePath storePath = storageClient.uploadFile(inputStream,fileSize, fileExtName, null);
        return appConfig.getFileServer() + storePath.getFullPath();
    }
}
