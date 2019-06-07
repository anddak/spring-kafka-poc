package com.springkafkapoc.controller;

import com.springkafkapoc.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/kafka")
public class FileProcessController {

  private FileService fileService;

  @Autowired
  public FileProcessController(FileService fileService) {
    this.fileService = fileService;
  }

  /*
  endpoint for reading in file
   */
  @PostMapping(value = "/file")
  public void sendMessageToKafkaTopic(@RequestParam("file") MultipartFile file) {
    fileService.processFile(file);
  }



}
