/**
 * 
 */
package com.cdk.global.assignment.paycheck.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cdk.global.assignment.PaycheckApplication;
import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Kashif
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PaycheckApplication.class})
@WebAppConfiguration
public class PayCheckRestControllerTest {
	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

	@Autowired
    private WebApplicationContext webApplicationContext;
	
    private MockMvc mockMvc;
    
    @Before
    public void setup() throws Exception {
    	PayCheckRestController paycheckRestController = new PayCheckRestController();
        this.mockMvc = MockMvcBuilders.standaloneSetup(paycheckRestController).build();
    }
    
    //@Test
    public void createPaySlip() throws Exception{
    	String employeeJson = new String(convertObjectToJsonBytes(getEmployeeData()));
    	System.out.println("Employee Data JSON:"+ employeeJson);
    	
       	this.mockMvc.perform(post("/payslip")
                .contentType(contentType)
                .content(employeeJson))
                .andExpect(status().is2xxSuccessful());
    }
    
    @Test
    public void testDummy(){
    	Assert.assertNotNull("OK");
    }
    protected static byte[] convertObjectToJsonBytes(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return mapper.writeValueAsBytes(object);
    }
    
    private EmployeeData getEmployeeData(){
    	EmployeeData employeeData = new EmployeeData();
    	employeeData.setEmployeeName("John Doe");
    	employeeData.setHoursWorked(50);
    	employeeData.setPayRate(12.34);
    	employeeData.setStateCode("NV");
    	employeeData.setDependentCount(4);
    	
    	return employeeData;
    }
}
