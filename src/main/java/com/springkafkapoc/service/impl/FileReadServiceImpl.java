package com.springkafkapoc.service.impl;

/*
service responsible to read in the file and determine if it's compatible or not.
 */

import com.springkafkapoc.constants.EmailConstants;
import com.springkafkapoc.producer.Producer;
import com.springkafkapoc.service.FileService;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileReadServiceImpl implements FileService {

    private final Producer producer;

  @Autowired
  public FileReadServiceImpl(Producer producer) {
    this.producer = producer;
  }

  /*
  business method for processing the received file, for demo purposes, this one is just triggering
  the action based on file name
   */
  public void processFile(MultipartFile file) {

    if(Objects.requireNonNull(file.getOriginalFilename()).equalsIgnoreCase("failed.txt")) {
       producer.sendMessage(EmailConstants.FAILED_SUBJECT);
    }
  }
}
