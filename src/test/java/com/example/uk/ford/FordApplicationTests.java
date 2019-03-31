package com.example.uk.ford;

import com.example.uk.ford.Repository.StudentRepositoryInterface;
import com.example.uk.ford.controller.FordController;
import com.example.uk.ford.service.FordService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
//@SpringBootTest
@WebMvcTest(value = FordController.class)
public class FordApplicationTests {  // Run sonar with -->> gradle sonarqube -Dsonar.host.url=http://localhost:9000

    public MockMvc mockMvc;

    @Autowired
    public WebApplicationContext context;

	@MockBean
	private FordService service;

	@MockBean
	private StudentRepositoryInterface studentRepository;

	@MockBean
	private ModelMapper modelMapper;

	/*@InjectMocks
	FordController fordController;*/


	@Before
	public void setUp() throws  Exception{
		//service = new FordService(studentRepository,  modelMapper);
		//fordController = new FordController(service);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

	}


	@Test
	public void contextLoads() {
	}

}