package com.springkafkapoc.service;

public interface EmailService {

  public void sendSimpleMessage(
      String to, String subject, String text);

  void sendMessageWithFailedFile(String to, String subject, String text, String pathToAttachment);

}
