/**
 * 
 */
package com.cdk.global.assignment.paycheck.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.cdk.global.assignment.paycheck.model.PaySlip;
import com.cdk.global.assignment.paycheck.rules.PayRule;
import com.cdk.global.assignment.paycheck.rules.STATES;
import com.cdk.global.assignment.paycheck.util.PaySlipFileWorker;


/**
 * @author Kashif
 *
 */
@Component("filePayService")
public class FilePayService extends PayCheckService {

	private static final Logger log = LoggerFactory.getLogger(FilePayService.class);
	
	public PaySlip processRequest(EmployeeData employeeData) {
		log.info("Processing Employee Data:"+ employeeData);
		PayRule payRule = getChainOfRules();
		
		PaySlip paySlip = new PaySlip(employeeData.getEmployeeName());
		
		if(!validateEmployeeData(employeeData)){
			paySlip.setIsPaySlipError(Boolean.TRUE);
			paySlip.setErrorMessage("Invalid Data receieved for Below Employee. \n"+ employeeData);
		}else{
			paySlip.setIsPaySlipError(Boolean.FALSE);
			payRule.applyRule(employeeData, paySlip);
		}
		
		log.info("Final PaySlip:\n"+ paySlip);
		//PaySlipWriter.writePaySlip(paySlip);
		writePaySlipToFile(paySlip);
		
		return paySlip;
	}
	
	public List<PaySlip> processBulkRequest(List<EmployeeData> employeeDataList) {
		List<PaySlip> paySlips = new ArrayList<PaySlip>();
		PayRule payRule = getChainOfRules();
		
		for(EmployeeData employeeData: employeeDataList){
			log.info("Processing Employee Data:"+ employeeData);
			PaySlip paySlip = new PaySlip(employeeData.getEmployeeName());
			
			if(!validateEmployeeData(employeeData)){
				paySlip.setIsPaySlipError(Boolean.TRUE);
				paySlip.setErrorMessage("Invalid Data receieved for Below Employee. \n"+ employeeData);
			}else{
				paySlip.setIsPaySlipError(Boolean.FALSE);
				payRule.applyRule(employeeData, paySlip);
			}
			
			log.info("Final PaySlip:\n"+ paySlip);
			//PaySlipWriter.writePaySlip(paySlip);
			writePaySlipToFile(paySlip);
			
			paySlips.add(paySlip);
		}
		
		return paySlips;
	}
	
	private void writePaySlipToFile(PaySlip paySlip){
		PaySlipFileWorker paySlipWorker = new PaySlipFileWorker(paySlip);
		Thread workerThread = new Thread(paySlipWorker);
		workerThread.start();
	}
	
	private Boolean validateEmployeeData(EmployeeData employeeData){
		Boolean isEmployeeValid = Boolean.TRUE;
		if(employeeData.getEmployeeName()== null){
			isEmployeeValid = Boolean.FALSE;
		}
		
		for(STATES STATE: STATES.values()){
			if(!STATE.getStateCode().equalsIgnoreCase(employeeData.getStateCode())){
				continue;
				
			}else{
				isEmployeeValid = Boolean.TRUE;
			}
		}
		
		if(employeeData.getHoursWorked() == null || employeeData.getHoursWorked() < 0){
			isEmployeeValid = Boolean.FALSE;
		}
		if(employeeData.getPayRate() == null || employeeData.getPayRate() < 0){
			isEmployeeValid = Boolean.FALSE;
		}
		if(employeeData.getDependentCount() == null || employeeData.getDependentCount() < 0){
			isEmployeeValid = Boolean.FALSE;
		}
		return isEmployeeValid;
	}
}
