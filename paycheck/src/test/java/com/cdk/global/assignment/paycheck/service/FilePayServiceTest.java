/**
 * 
 */
package com.cdk.global.assignment.paycheck.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.cdk.global.assignment.PaycheckApplication;
import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.cdk.global.assignment.paycheck.model.PaySlip;


/**
 * @author Kashif
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PaycheckApplication.class})
@WebAppConfiguration
public class FilePayServiceTest {
	
	private static final Logger log = LoggerFactory.getLogger(FilePayServiceTest.class);
	
	@Resource
	@Qualifier("filePayService")
	private PayCheckService paycheckService;
	
	@Test
	public void testProcessRequest(){
		PaySlip paySlip =  paycheckService.processRequest(getEmployeeData());
		log.info("Test PaySlip:\n"+ paySlip);
	}
	
	@Test
	public void testProcessInvalidRequest(){
		PaySlip paySlip =  paycheckService.processRequest(getInvalidEmployeeData());
		log.info("Test PaySlip:\n"+ paySlip);
	}
	
	@Test
	public void testProcessBulkRequest(){
		List<PaySlip> paySlips =  paycheckService.processBulkRequest(getEmployeeList());
		log.info("Payslips Generated Successfully for total employees:"+ paySlips.size());
	}
	
	private EmployeeData getInvalidEmployeeData(){
    	EmployeeData employeeData = new EmployeeData();
    	employeeData.setEmployeeName("John Bay");
    	employeeData.setHoursWorked(-5);
    	employeeData.setPayRate(-1D);
    	employeeData.setStateCode("JK");
    	employeeData.setDependentCount(-1);
    	
    	return employeeData;
    }
	
	private EmployeeData getEmployeeData(){
    	EmployeeData employeeData = new EmployeeData();
    	employeeData.setEmployeeName("Jane Diaz");
    	employeeData.setHoursWorked(50);
    	employeeData.setPayRate(12.34);
    	employeeData.setStateCode("NV");
    	employeeData.setDependentCount(3);
    	
    	return employeeData;
    }
	
	private List<EmployeeData> getEmployeeList(){
		List<EmployeeData> employeeList = new ArrayList<EmployeeData>();
		EmployeeData employeeData = new EmployeeData();
    	employeeData.setEmployeeName("John Doe");
    	employeeData.setHoursWorked(-5);
    	employeeData.setPayRate(-1D);
    	employeeData.setStateCode("JK");
    	employeeData.setDependentCount(-1);
    	employeeList.add(employeeData);
    	
    	employeeData = new EmployeeData();
    	employeeData.setEmployeeName("Jane Doe");
    	employeeData.setHoursWorked(50);
    	employeeData.setPayRate(12.34);
    	employeeData.setStateCode("NV");
    	employeeData.setDependentCount(3);
    	employeeList.add(employeeData);
    	
    	employeeData = new EmployeeData();
    	employeeData.setEmployeeName("Bob Dylan");
    	employeeData.setHoursWorked(40);
    	employeeData.setPayRate(12.34);
    	employeeData.setStateCode("HV");
    	employeeData.setDependentCount(2);
    	employeeList.add(employeeData);
    	
    	employeeData = new EmployeeData();
    	employeeData.setEmployeeName("Chris Allen");
    	employeeData.setHoursWorked(35);
    	employeeData.setPayRate(12D);
    	employeeData.setStateCode("MS");
    	employeeData.setDependentCount(1);
    	employeeList.add(employeeData);
    	
		return employeeList;
	}
}
