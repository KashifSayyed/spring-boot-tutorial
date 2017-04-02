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
public class OverTimePayRule extends PayRule{
	private static final Logger log = LoggerFactory.getLogger(OverTimePayRule.class);
	
	@Override
	protected void processPay(EmployeeData employeeData, PaySlip paySlip) {
		Integer overTimeHours = employeeData.getHoursWorked() <= 40 ? 0 : (employeeData.getHoursWorked() - 40);
		
		log.info("Calculating Overtime HoursPayRule for Hours:"+ overTimeHours);
		
		Double overTimePay = overTimeHours * employeeData.getPayRate() * 1.5;
		
		log.info("Overtime Hours Pay:"+ overTimePay);
		
		paySlip.setOverTimePay(overTimePay);
	}
}
