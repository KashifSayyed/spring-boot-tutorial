/**
 * 
 */
package com.cdk.global.assignment.paycheck.util;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cdk.global.assignment.PaycheckConsumerApplication;
import com.cdk.global.assignment.paycheck.model.EmployeeData;

/**
 * @author Kashif
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PaycheckConsumerApplication.class})
public class CSVUtilTest {

	@Test
	public void testCsvUtil(){
		String csvFile = System.getProperty("user.home") + "/paychecks/employees.csv";
		List<EmployeeData> employeeDataList = CSVUtil.readCsv(csvFile);
		
		System.out.println("Employees Read from File:"+ employeeDataList.size());
		for(EmployeeData employeeData:employeeDataList){
			System.out.println(employeeData);
		}
	}
}
