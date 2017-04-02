/**
 * 
 */
package com.cdk.global.assignment;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.cdk.global.assignment.paycheck.model.PayCheckBulkRequest;
import com.cdk.global.assignment.paycheck.util.CSVUtil;

/**
 * @author Kashif
 *
 */
@SpringBootApplication
public class PaycheckConsumerApplication {
	private static final Logger log = LoggerFactory.getLogger(PaycheckConsumerApplication.class);

	public static void main(String[] args) throws Exception{
		SpringApplication.run(PaycheckConsumerApplication.class, args);
		log.info("PaycheckConsumerApplication Started...");
		runPayCheckBulkClient();
		runPayCheckClient();
	}
	
	public static void runPayCheckBulkClient() throws Exception {
		
		String uri = "http://localhost:8080/payslip/bulkupload";
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.postForObject(uri, getBulkRequest(), String.class);
		
		log.info(result);		
	}
	
	public static void runPayCheckClient() throws Exception {
		String uri = "http://localhost:8080/payslip";
		
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.postForObject(uri, getEmployeeData(), String.class);
		log.info(result);		
	}
	
	private static PayCheckBulkRequest getBulkRequest(){
		String csvFile = System.getProperty("user.home") + "/paychecks/employees.csv";
		List<EmployeeData> employeeDataList = CSVUtil.readCsv(csvFile);

		PayCheckBulkRequest payCheckBulkRequest = new PayCheckBulkRequest();
		payCheckBulkRequest.setEmployeeDataList(employeeDataList);
		
		return payCheckBulkRequest;
	}
	
	private static EmployeeData getEmployeeData(){
    	EmployeeData employeeData = new EmployeeData();
    	employeeData.setEmployeeName("Jane Diaz");
    	employeeData.setHoursWorked(50);
    	employeeData.setPayRate(12.34);
    	employeeData.setStateCode("NV");
    	employeeData.setDependentCount(3);
    	
    	return employeeData;
    }
}
