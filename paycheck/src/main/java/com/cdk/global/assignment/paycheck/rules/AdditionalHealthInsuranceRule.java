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
public class AdditionalHealthInsuranceRule  extends PayRule {
	private static final Logger log = LoggerFactory.getLogger(AdditionalHealthInsuranceRule.class);
	
	@Override
	protected void processPay(EmployeeData employeeData, PaySlip paySlip) {
		Double additionalHealthInsuranceCost = employeeData.getDependentCount() >= 3 ? new Double(35) : new Double(0);
		
		log.info("Additional Health Insurance Cost:"+ additionalHealthInsuranceCost);
		
		paySlip.setAdditionalHealthInsuranceCost(additionalHealthInsuranceCost);
	}
}
