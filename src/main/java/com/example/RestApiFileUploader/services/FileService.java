package com.example.RestApiFileUploader.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String fileUpload(String path, MultipartFile file) throws IOException;
}
