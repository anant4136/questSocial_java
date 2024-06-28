package com.forum.forum.controller;

import com.forum.forum.entity.FileResponse;
import com.forum.forum.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/file/")
@CrossOrigin("*")
public class FileController {

    @Autowired
    private FileService fileService;

    private String path = "images/";

    @PostMapping("upload/")
    public ResponseEntity<?> fileUpload(@RequestParam("image") MultipartFile image){
        try {
            String filename = this.fileService.uploadImage(path,image);
            return ResponseEntity.ok(new FileResponse(filename));
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file: " + e.getMessage());
        }




    }

}