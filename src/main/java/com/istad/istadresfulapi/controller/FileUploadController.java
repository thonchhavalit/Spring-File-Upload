package com.istad.istadresfulapi.controller;


import com.istad.istadresfulapi.model.response.FileResponse;
import com.istad.istadresfulapi.service.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileUploadController {
    private final FileUploadService fileUploadService;
    @Value("images/")
    private String path;
    @PostMapping("/upload-file")
    public ResponseEntity<FileResponse> fileUpload(@RequestParam("image") MultipartFile image){
        String filename = null;
        try {
            filename = this.fileUploadService.uploadImage(path, image);

        } catch (IOException e) {
            return new ResponseEntity<>(new FileResponse(null, "no image uploaded!!"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new FileResponse(filename, "image uploaded successfully!"), HttpStatus.OK);
    }
}
