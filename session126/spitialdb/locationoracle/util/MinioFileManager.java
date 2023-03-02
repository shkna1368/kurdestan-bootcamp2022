
import io.minio.MinioClient;
import ir.pakcharkh.bdood.core.exception.MinioException;
import org.apache.http.entity.ContentType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@Component
public class MinioFileManager {

    public String addFileToMinio(MultipartFile file, String bucketName, String endPoint, String accessKey,
                                 String secretKey, String exceptionMessage, ContentType contentType) {

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

        try {

            MinioClient minioClient = new MinioClient(endPoint, accessKey, secretKey);
            boolean isExist = minioClient.bucketExists(bucketName);
            if (isExist) {
            } else {
                minioClient.makeBucket(bucketName);
            }


            String filePath = convertMultiPartToFile(file).toString();
            minioClient.putObject(bucketName, fileName, filePath, file.getSize(),
                    null, null, contentType.toString());


            String fileUrl = minioClient.presignedGetObject(bucketName, fileName, 60 * 24 * 365);


            if (null == fileUrl) {
                throw new MinioException(exceptionMessage);
            }

            File tempFile = new File(filePath);
            if (tempFile.exists()) {
                tempFile.delete();
            }

            return fileUrl;
        } catch (Exception e) {
            throw new MinioException(exceptionMessage);
        }

    }

    private File convertMultiPartToFile(MultipartFile file) {
        File convFile = new File(file.getOriginalFilename());
        try {
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convFile;
    }


}
