package com.example.uk.ford;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(value = FordControllerTest.class)
public class FordApplicationTests {  // Run sonar with -->> gradle sonarqube -Dsonar.host.url=http://localhost:9000

    @Autowired
    public MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

}