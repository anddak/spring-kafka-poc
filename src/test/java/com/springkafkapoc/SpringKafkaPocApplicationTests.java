package com.springkafkapoc;

import com.springkafkapoc.consumer.Receiver;
import com.springkafkapoc.producer.Sender;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
public class SpringKafkaPocApplicationTests {

	static final String HELLOWORLD_TOPIC = "helloworld.t";

	@Autowired
	private Receiver receiver;

	@Autowired
	private Sender sender;

	@Test
	public void testReceive() throws Exception {
		sender.send("Hello Spring Kafka!");
		receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
		Assert.assertEquals(receiver.getLatch().getCount(), 0);
	}

}
