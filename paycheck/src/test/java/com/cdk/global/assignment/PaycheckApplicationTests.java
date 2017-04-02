package com.cdk.global.assignment;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaycheckApplication.class)
@WebAppConfiguration
public class PaycheckApplicationTests {

	@Test
	public void contextLoads() {
		assertNotNull("Ok","Ok");
	}

}
