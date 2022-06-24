package com.example.RestApiFileUploader.services;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String fileUpload(String path, MultipartFile file);
}
