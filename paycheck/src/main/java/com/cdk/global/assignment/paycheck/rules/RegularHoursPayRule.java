/**
 * 
 */
package com.cdk.global.assignment.paycheck.rules;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.cdk.global.assignment.paycheck.model.PaySlip;


/**
 * @author Kashif
 *
 */
public class RegularHoursPayRule extends PayRule {
	
	private static final Logger log = LoggerFactory.getLogger(RegularHoursPayRule.class);
	
	@Override
	protected void processPay(EmployeeData employeeData, PaySlip paySlip) {
		Integer regularHours = employeeData.getHoursWorked() > 40 ? 40 : employeeData.getHoursWorked();
		
		log.info("Calculating RegularHoursPayRule for Hours:"+ regularHours);
		
		Double regularHourPay = regularHours * employeeData.getPayRate();
		
		log.info("Regular Hours Pay:"+ regularHourPay);
		
		paySlip.setRegularHourPay(regularHourPay);
	}
}
