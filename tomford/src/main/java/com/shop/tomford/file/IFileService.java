package com.shop.tomford.file;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String uploadFile(MultipartFile file);
//    void deleteFiles(Collection<String> urls);
    void deleteFile(String url);

}
