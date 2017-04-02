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
public class StateTaxRule extends PayRule {
	
	private static final Logger log = LoggerFactory.getLogger(StateTaxRule.class);
	
	@Override
	protected void processPay(EmployeeData employeeData, PaySlip paySlip) {
		Double stateTaxRate = getStateTaxRateByStateCode(employeeData.getStateCode());
		
		Double stateTaxAmount = (paySlip.getGrossPay() * stateTaxRate) / 100;
		
		log.info("State Tax Amount:"+ stateTaxAmount);
		
		paySlip.setStateTaxAmount(stateTaxAmount);
	}
	
	protected Double getStateTaxRateByStateCode(String stateCode){
		Double taxRate = new Double(0);
		log.info("Getting Tax Rate for State :"+ stateCode);
		
		if(stateCode == null){
			return taxRate;
		}
		
		for(STATES STATE: STATES.values()){
			if(STATE.getStateCode().equalsIgnoreCase(stateCode)){
				taxRate = STATE.getStateTaxRate();	
			}
		}
		log.info("State Tax Rate :"+ taxRate);
		return taxRate;
	}
}
