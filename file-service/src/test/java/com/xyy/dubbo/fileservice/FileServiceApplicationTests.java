package com.xyy.dubbo.fileservice;

import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
class FileServiceApplicationTests {

    @Autowired
    protected FastFileStorageClient storageClient;


    @Test
    void contextLoads() throws FileNotFoundException {

        File file = new File("D://170157_Qfw4_1767531.jpg");
        FileInputStream stream = new FileInputStream(file);
        String fileName = file.getName();
        String extName = fileName.substring(fileName.lastIndexOf(".") + 1);
        StorePath storePath = storageClient.uploadFile(stream, file.length(), extName, null);

        System.out.println(storePath.getFullPath());
        System.out.println(storePath.getGroup());
        System.out.println(storePath.getPath());
    }

}
