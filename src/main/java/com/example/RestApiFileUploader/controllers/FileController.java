package com.example.RestApiFileUploader.controllers;

import com.example.RestApiFileUploader.payload.FileResponse;
import com.example.RestApiFileUploader.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileController {

    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image) {

        String fileName = null;
        try {
            fileName = fileService.fileUpload(path, image);
        } catch (IOException e) {
            return new ResponseEntity<>(new FileResponse(null, "There is some error going on..."), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new FileResponse(fileName, "Image is successfully uploaded..."), HttpStatus.OK);
    }
}
