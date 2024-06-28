package com.forum.forum.service;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Struct;
import java.util.Random;

@Service
public class FileService {

    public String uploadImage(String path, MultipartFile file) throws IOException {

        String name = file.getOriginalFilename();
        String extension = name.substring(name.lastIndexOf("."));
        String fileNameWithoutExtension = name.substring(0, name.lastIndexOf("."));

        String filePath;
        File file1 = new File(path);

        if (!file1.exists()) {
            file1.mkdir();
        }

// Generate a random 4-digit number
        Random random = new Random();
        int randomNumber = random.nextInt(9000) + 1000; // Generates a number between 1000 and 9999

// Append the random number to the file name
        String uniqueFileName = fileNameWithoutExtension + "_" + randomNumber + extension;

        filePath = path + File.separator + uniqueFileName;

        Files.copy(file.getInputStream(), Paths.get(filePath));

        return uniqueFileName;

    }

}