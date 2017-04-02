/**
 * 
 */
package com.cdk.global.assignment.paycheck.rules;

/**
 * @author Kashif
 *
 */
public enum STATES {
	MISSISSIPPI("MS", new Double(5)),
	HAWAII("HI", new Double(11)),
	NEVADA("NV", new Double(0));
	
	STATES(String stateCode, Double stateTaxRate){
		this.stateCode = stateCode;
		this.stateTaxRate = stateTaxRate;
	}
	
	private String stateCode;
	private Double stateTaxRate;
	
	public String getStateCode(){
		return this.stateCode;
	}
	
	public Double getStateTaxRate(){
		return this.stateTaxRate;
	}
}
