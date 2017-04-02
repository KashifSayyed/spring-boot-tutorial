/**
 * 
 */
package com.cdk.global.assignment.paycheck.model;

import java.util.List;

/**
 * @author Kashif
 *
 */
public class PayCheckBulkRequest {

	private List<EmployeeData> employeeDataList;

	public void setEmployeeDataList(List<EmployeeData> employeeDataList) {
		this.employeeDataList = employeeDataList;
	}

	public List<EmployeeData> getEmployeeDataList() {
		return employeeDataList;
	}
}
