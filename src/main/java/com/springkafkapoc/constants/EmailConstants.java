package com.springkafkapoc.constants;

public class EmailConstants {

  private EmailConstants() {
    throw new IllegalStateException("Utility class");
  }

  public static final String TARGET_EMAIL = "[ADD EMAIL TO SEND IT TO]";
  public static final String FAILED_SUBJECT = "ALERT: File submission failure.";


  public static final String ATTACHMENT_PATH = "[ADD THE PATH TO THE FILE HERE]";
}
