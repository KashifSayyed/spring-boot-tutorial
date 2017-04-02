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
public class SocialSecurityTaxRule extends PayRule {

	private static final Logger log = LoggerFactory.getLogger(SocialSecurityTaxRule.class);
	
	@Override
	protected void processPay(EmployeeData employeeData, PaySlip paySlip) {
		Double socialSecurityTaxRate = new Double(6);
		log.info("Calculating Social Security Tax at Rate: :"+ socialSecurityTaxRate);
		
		Double socialSecurityTaxAmount = (paySlip.getGrossPay() * socialSecurityTaxRate) / 100;
		
		log.info("Social Security Tax Amount:"+ socialSecurityTaxAmount);
		
		paySlip.setSocialSecurityTaxAmount(socialSecurityTaxAmount);
	}
}
