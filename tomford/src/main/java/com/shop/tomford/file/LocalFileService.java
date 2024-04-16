package com.shop.tomford.file;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;
@Service

public class LocalFileService implements IFileService {

    @Value("${app.host}")
    private String host;

    @Override
    public String uploadFile(MultipartFile file) {


        String filePath = UUID.randomUUID().toString() + file.getOriginalFilename();
        try {
            var fileUrl = new java.io.File(filePath);
            fileUrl.createNewFile();
            var bytes = file.getBytes();
            var stream = new java.io.FileOutputStream(fileUrl);
            stream.write(bytes);
            stream.close();
            return host.replace(" ","") + "/api/file/" + filePath;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void deleteFile(String url) {
        try {
            var filePath = url.substring(url.lastIndexOf("/") + 1);
            new java.io.File( filePath).delete();
        } catch (Exception ignored) {
        }
    }
}
