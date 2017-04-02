/**
 * 
 */
package com.cdk.global.assignment.paycheck.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cdk.global.assignment.PaycheckApplication;
import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.cdk.global.assignment.paycheck.model.PayCheckBulkRequest;
import com.cdk.global.assignment.paycheck.model.PaySlip;
import com.cdk.global.assignment.paycheck.service.PayCheckService;


/**
 * @author Kashif
 *
 */
@RestController
public class PayCheckRestController {
	
	private static final Logger log = LoggerFactory.getLogger(PayCheckRestController.class);
	
	@Resource
	private PayCheckService paycheckService;
	
	@RequestMapping(value = "/payslip", method = RequestMethod.POST)
	public ResponseEntity<String> generatePaySlip(@RequestBody EmployeeData employeeData){
		log.info("Processing Request:"+ employeeData);
		
		paycheckService.processRequest(employeeData);
		
		return new ResponseEntity("Payslip Generated Successfully for employee:" + employeeData.getEmployeeName(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/payslip/bulkupload", method = RequestMethod.POST)
	public ResponseEntity<String> generatePaySlips(@RequestBody PayCheckBulkRequest payCheckBulkRequest){
		
		List<EmployeeData> employeeDataList = payCheckBulkRequest.getEmployeeDataList();
		log.info("Processing Bulk Request with size:"+ employeeDataList.size());
		
		List<PaySlip> paySlips = paycheckService.processBulkRequest(employeeDataList);
		
		return new ResponseEntity("Payslips Generated Successfully for total employees:" + paySlips.size(), HttpStatus.OK);
	}
}

