/**
 * 
 */
package com.cdk.global.assignment.paycheck.model;

/**
 * @author Kashif
 *
 */
public class PaySlip {

	private Double regularHourPay;
	private Double overTimePay;
	private Double socialSecurityTaxAmount;
	private Double federalTaxAmount;
	private Double stateTaxAmount;
	private Double unionDues;
	private Double additionalHealthInsuranceCost;
	private Boolean isPaySlipError = Boolean.FALSE;
	private String errorMessage;
	private String employeeName;
	
	public PaySlip(String employeeName){
		this.employeeName = employeeName;
	}
	
	public Double getGrossPay() {
		return regularHourPay + overTimePay;
	}
	
	public Double getTotalDeductions() {
		return socialSecurityTaxAmount + federalTaxAmount + stateTaxAmount + unionDues + additionalHealthInsuranceCost;
	}
	
	public Double getTotalInhandSalary() {
		return getGrossPay() - getTotalDeductions();
	}
	
	public Double getUnionDues() {
		return unionDues;
	}

	public void setUnionDues(Double unionDues) {
		this.unionDues = unionDues;
	}

	public Double getAdditionalHealthInsuranceCost() {
		return additionalHealthInsuranceCost;
	}

	public void setAdditionalHealthInsuranceCost(
			Double additionalHealthInsuranceCost) {
		this.additionalHealthInsuranceCost = additionalHealthInsuranceCost;
	}

	public Double getOverTimePay() {
		return overTimePay;
	}

	public void setOverTimePay(Double overTimePay) {
		this.overTimePay = overTimePay;
	}

	public Double getRegularHourPay() {
		return regularHourPay;
	}

	public void setRegularHourPay(Double regularHourPay) {
		this.regularHourPay = regularHourPay;
	}

	public void setSocialSecurityTaxAmount(Double socialSecurityTaxAmount) {
		this.socialSecurityTaxAmount = socialSecurityTaxAmount;
	}

	public Double getSocialSecurityTaxAmount() {
		return socialSecurityTaxAmount;
	}

	public void setFederalTaxAmount(Double federalTaxAmount) {
		this.federalTaxAmount = federalTaxAmount;
	}

	public Double getFederalTaxAmount() {
		return federalTaxAmount;
	}

	public void setStateTaxAmount(Double stateTaxAmount) {
		this.stateTaxAmount = stateTaxAmount;
	}

	public Double getStateTaxAmount() {
		return stateTaxAmount;
	}

	public String toString(){
		StringBuilder stringBuilder = new StringBuilder("\nPaySlip of ").append(getEmployeeName())
		.append(" : {");
		if(IsPaySlipError()){
			stringBuilder.append("\nError Message: "+ this.errorMessage);
		}else{
			stringBuilder.append("\nRegular Hour Pay:"+ this.regularHourPay);
			stringBuilder.append("\nOvertime Pay:"+ this.overTimePay);
			stringBuilder.append("\nGross Salary:"+ this.getGrossPay());
			stringBuilder.append("\nDeductions");
			stringBuilder.append("\nSocial Securiy Tax:"+ this.socialSecurityTaxAmount);
			stringBuilder.append("\nFederal Tax:"+ this.federalTaxAmount);
			stringBuilder.append("\nState Tax:"+ this.stateTaxAmount);
			stringBuilder.append("\nUnion Dues:"+ this.unionDues);
			stringBuilder.append("\nAddional Health Insrunce Cost:"+ this.additionalHealthInsuranceCost);
			stringBuilder.append("\nTotal Deductions:"+ this.getTotalDeductions());
			stringBuilder.append("\nTotal InHand Salary:"+ this.getTotalInhandSalary());
		}
		stringBuilder.append("\n}");
		return stringBuilder.toString();
	}

	public void setIsPaySlipError(Boolean isPaySlipError) {
		this.isPaySlipError = isPaySlipError;
	}

	public Boolean IsPaySlipError() {
		return isPaySlipError;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeName() {
		return employeeName;
	}
}

