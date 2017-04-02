/**
 * 
 */
package com.cdk.global.assignment.paycheck.rules;

import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.cdk.global.assignment.paycheck.model.PaySlip;


/**
 * @author Kashif
 *
 */
public abstract class PayRule {
	 
	protected PayRule nextPayRule;
	
	public void setNextPayRule(PayRule nextPayRule){
		this.nextPayRule = nextPayRule;
	}
	
	public void applyRule(EmployeeData employeeData,PaySlip paySlip){
		
		processPay(employeeData, paySlip);
		
		if(this.nextPayRule != null){
			this.nextPayRule.applyRule(employeeData, paySlip);
		}
	}
	
	abstract protected void processPay(EmployeeData employeeData,PaySlip paySlip);
}
