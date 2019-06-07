package com.springkafkapoc.service.impl;

import com.springkafkapoc.service.EmailService;

import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  private JavaMailSender emailSender;

  @Autowired
  public EmailServiceImpl(JavaMailSender emailSender) {
    this.emailSender = emailSender;
  }

  /*
  sending email without attachments, currently inactive
   */
  public void sendSimpleMessage(
      String to, String subject, String text) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(to);
    message.setSubject(subject);
    message.setText(text);
//   emailSender.send(message);
  }

  /*
  sending emails with attachments, currently in use
   */
  public void sendMessageWithFailedFile(
      String to, String subject, String text, String pathToAttachment) {

    MimeMessage message = emailSender.createMimeMessage();
    try {
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setTo(to);
      helper.setSubject(subject);
      helper.setText(text);
      FileSystemResource file
          = new FileSystemResource(new File(pathToAttachment));
      helper.addAttachment("failed", file);
    } catch (MessagingException e) {
      e.getMessage();
    }
    emailSender.send(message);
  }

}
