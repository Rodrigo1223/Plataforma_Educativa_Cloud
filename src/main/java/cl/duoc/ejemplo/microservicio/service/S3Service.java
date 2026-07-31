package cl.duoc.ejemplo.microservicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class S3Service {

    @Autowired
    private S3Client s3Client;

    @Value("${aws.s3.bucket-name}")
    private String bucketName;

    public String uploadFile(MultipartFile file) {
        try {
            String fileName = file.getOriginalFilename();
            s3Client.putObject(PutObjectRequest.builder().bucket(bucketName).key(fileName).build(),
                    RequestBody.fromInputStream(file.getInputStream(), file.getSize()));
            return "https://" + bucketName + ".s3.amazonaws.com/" + fileName;
        } catch (IOException e) {
            throw new RuntimeException("Error al subir", e);
        }
    }

    public List<String> listFiles() {
        ListObjectsV2Request request = ListObjectsV2Request.builder().bucket(bucketName).build();
        return s3Client.listObjectsV2(request).contents().stream()
                .map(S3Object::key).collect(Collectors.toList());
    }

    public byte[] downloadFile(String fileName) {
        GetObjectRequest request = GetObjectRequest.builder().bucket(bucketName).key(fileName).build();
        return s3Client.getObjectAsBytes(request).asByteArray();
    }

    public void deleteFile(String fileName) {
        s3Client.deleteObject(DeleteObjectRequest.builder().bucket(bucketName).key(fileName).build());
    }
}