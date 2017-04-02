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
public class UnionDuesRule  extends PayRule {
	
	private static final Logger log = LoggerFactory.getLogger(UnionDuesRule.class);
	
	@Override
	protected void processPay(EmployeeData employeeData, PaySlip paySlip) {
		Double unionDuePerWeek = new Double(10);
		
		Double unionDues = unionDuePerWeek;
		
		log.info("Union Dues:"+ unionDues);
		
		paySlip.setUnionDues(unionDues);
	}
}
