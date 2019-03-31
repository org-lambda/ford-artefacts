package com.example.uk.ford;


import com.example.uk.ford.controller.FordController;
import com.example.uk.ford.service.FordService;
import org.junit.Assert;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

//@WebMvcTest(FordController.class)
public class FordControllerTest extends FordApplicationTests{



    @Test
    public void retrieveTest01() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/retrieve/");

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertNotNull(result);
        /*JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);*/
    }
}
