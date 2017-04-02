/**
 * 
 */
package com.cdk.global.assignment.paycheck.model;

import java.io.Serializable;

/**
 * @author Kashif
 *
 */
public class EmployeeData implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String employeeName;
	private Integer hoursWorked;
	private Double payRate;
	private String stateCode;
	private Integer dependentCount;
	
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the hoursWorked
	 */
	public Integer getHoursWorked() {
		return hoursWorked;
	}
	/**
	 * @param hoursWorked the hoursWorked to set
	 */
	public void setHoursWorked(Integer hoursWorked) {
		this.hoursWorked = hoursWorked;
	}
	/**
	 * @return the payRate
	 */
	public Double getPayRate() {
		return payRate;
	}
	/**
	 * @param payRate the payRate to set
	 */
	public void setPayRate(Double payRate) {
		this.payRate = payRate;
	}
	/**
	 * @return the stateCode
	 */
	public String getStateCode() {
		return stateCode;
	}
	/**
	 * @param stateCode the stateCode to set
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}
	/**
	 * @return the dependentCount
	 */
	public Integer getDependentCount() {
		return dependentCount;
	}
	/**
	 * @param dependentCount the dependentCount to set
	 */
	public void setDependentCount(Integer dependentCount) {
		this.dependentCount = dependentCount;
	}
	
	public String toString(){
		StringBuilder stringBuilder = new StringBuilder("\nEmployeeData: {");
		stringBuilder.append("\nEmployee Name:"+ this.employeeName);
		stringBuilder.append("\nHours Worked:"+ this.hoursWorked);
		stringBuilder.append("\nPay Rate:"+ this.payRate);
		stringBuilder.append("\nState Code:"+ this.stateCode);
		stringBuilder.append("\nNumber of Dependents:"+ this.dependentCount);
		stringBuilder.append("\n}");
		return stringBuilder.toString();
	}
}

