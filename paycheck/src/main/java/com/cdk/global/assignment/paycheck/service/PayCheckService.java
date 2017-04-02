/**
 * 
 */
package com.cdk.global.assignment.paycheck.service;

import java.util.List;

import com.cdk.global.assignment.paycheck.model.EmployeeData;
import com.cdk.global.assignment.paycheck.model.PaySlip;
import com.cdk.global.assignment.paycheck.rules.AdditionalHealthInsuranceRule;
import com.cdk.global.assignment.paycheck.rules.FederalTaxRule;
import com.cdk.global.assignment.paycheck.rules.OverTimePayRule;
import com.cdk.global.assignment.paycheck.rules.PayRule;
import com.cdk.global.assignment.paycheck.rules.RegularHoursPayRule;
import com.cdk.global.assignment.paycheck.rules.SocialSecurityTaxRule;
import com.cdk.global.assignment.paycheck.rules.StateTaxRule;
import com.cdk.global.assignment.paycheck.rules.UnionDuesRule;


/**
 * @author Kashif
 *
 */
public abstract class PayCheckService {
	
	public PayRule getChainOfRules(){
		RegularHoursPayRule regularHoursPayRule = new RegularHoursPayRule();
		OverTimePayRule overTimePayRule = new OverTimePayRule();
		SocialSecurityTaxRule socialSecurityTaxRule = new SocialSecurityTaxRule();
		FederalTaxRule federalTaxRule = new FederalTaxRule();
		StateTaxRule stateTaxRule = new StateTaxRule();
		UnionDuesRule unionDuesRule = new UnionDuesRule();
		AdditionalHealthInsuranceRule additionalHealthInsuranceRule = new AdditionalHealthInsuranceRule();
	
		regularHoursPayRule.setNextPayRule(overTimePayRule);
		overTimePayRule.setNextPayRule(socialSecurityTaxRule);
		socialSecurityTaxRule.setNextPayRule(federalTaxRule);
		federalTaxRule.setNextPayRule(stateTaxRule);
		stateTaxRule.setNextPayRule(unionDuesRule);
		unionDuesRule.setNextPayRule(additionalHealthInsuranceRule);
		
		return regularHoursPayRule;
	}
	
	public abstract PaySlip processRequest(EmployeeData employeeData);
	
	public abstract List<PaySlip> processBulkRequest(List<EmployeeData> employeeDataList);
}
