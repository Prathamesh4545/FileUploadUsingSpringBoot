package org.prathamesh.dev.projectfileupload.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    boolean hasCSVFormat(MultipartFile file);

    void processAndSaveData(MultipartFile file) throws IOException;
}
