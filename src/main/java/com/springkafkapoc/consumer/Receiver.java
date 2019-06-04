package com.springkafkapoc.consumer;

import java.util.concurrent.CountDownLatch;
import org.springframework.kafka.annotation.KafkaListener;

public class Receiver {

  private String receivedMessage;

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "helloworld.t")
  public void receive(String payload) {
    receivedMessage = payload;
    latch.countDown();
  }

}
