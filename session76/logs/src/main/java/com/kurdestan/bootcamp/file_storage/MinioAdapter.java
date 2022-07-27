package com.kurdestan.bootcamp.file_storage;


import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.ObjectWriteResponse;
import io.minio.PutObjectArgs;
import io.minio.messages.Bucket;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@Service
public class MinioAdapter {

    @Autowired
    MinioClient minioClient;

    @Value("${minio.bucket.name}")
    String defaultBucketName;

    @Value("${minio.default.folder}")
    String defaultBaseFolder;

    public List<Bucket> getAllBuckets() {
        try {
            return minioClient.listBuckets();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }


    public String uploadFile(  MultipartFile files) {

        try {

            String name=System.currentTimeMillis()+files.getOriginalFilename();



            ObjectWriteResponse objectWriteResponse = minioClient.putObject(
                    PutObjectArgs.builder().bucket(defaultBucketName).object(name).stream(
                                    files.getInputStream(), files.getSize(), -1)
                            .contentType(files.getContentType())
                            .build());
            return objectWriteResponse.object();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public byte[] getFile(String key) {
        try {
          //  InputStream obj = minioClient.getObject(defaultBucketName, defaultBaseFolder + "/" + key);



            InputStream obj =     minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(defaultBucketName)
                            .object(key)
                            .build());

            byte[] content = IOUtils.toByteArray(obj);
            obj.close();
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}