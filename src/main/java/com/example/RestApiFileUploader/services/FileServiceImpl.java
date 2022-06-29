package com.example.RestApiFileUploader.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public String fileUpload(String path, MultipartFile file) throws IOException {

        String randomID = UUID.randomUUID().toString();
        String name = file.getOriginalFilename();
        File f = new File(path);
        String fileNameNew = randomID.concat(name.substring(name.lastIndexOf(".")));
        String filePath = path + File.separator + fileNameNew;

        if(!f.exists())
            f.mkdir();

        Files.copy(file.getInputStream(), Paths.get(filePath));

        return name;
    }
}
