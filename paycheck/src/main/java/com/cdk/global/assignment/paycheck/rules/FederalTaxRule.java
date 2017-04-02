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
public class FederalTaxRule extends PayRule {

	private static final Logger log = LoggerFactory.getLogger(FederalTaxRule.class);
	
	@Override
	protected void processPay(EmployeeData employeeData, PaySlip paySlip) {
		Double federalTaxRate = new Double(14);
		log.info("Federal Tax at Rate: :"+ federalTaxRate);
		
		Double federalTaxAmount = (paySlip.getGrossPay() * federalTaxRate) / 100;
		
		log.info("Federal Tax Amount:"+ federalTaxAmount);
		
		paySlip.setFederalTaxAmount(federalTaxAmount);
	}
}
