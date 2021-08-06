package com.example.producer.service.aws;

import org.springframework.core.io.InputStreamResource;

import java.io.InputStream;

public interface AwsFileService {

    boolean doesObjectExist(String fileName);

    void upload(String fileName, InputStream inputStream);

    InputStreamResource download(String fileName);

    void delete(String filename);

}