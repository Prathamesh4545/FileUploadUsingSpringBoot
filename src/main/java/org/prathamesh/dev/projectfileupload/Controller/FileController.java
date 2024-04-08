package org.prathamesh.dev.projectfileupload.Controller;

import org.prathamesh.dev.projectfileupload.Response.ResponseMessage;
import org.prathamesh.dev.projectfileupload.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if(fileService.hasCSVFormat(file)){
            fileService.processAndSaveData(file);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage("Uploaded Successfully : "+file.getOriginalFilename()));
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage("Please upload a CSV file!"));

    }
}
