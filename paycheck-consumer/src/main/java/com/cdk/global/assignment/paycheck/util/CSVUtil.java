/**
 * 
 */
package com.cdk.global.assignment.paycheck.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdk.global.assignment.paycheck.model.EmployeeData;

/**
 * @author Kashif
 *
 */
public class CSVUtil {
	private static final Logger log = LoggerFactory.getLogger(CSVUtil.class);

	public static List<EmployeeData> readCsv(String csvFile){
		List<EmployeeData> employeeDataList = new ArrayList<EmployeeData>();
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(csvFile));
			String line = null;
			Scanner scanner = null;
			int index = 0;
			while ((line = reader.readLine()) != null) {
				EmployeeData employeeData = new EmployeeData();
				scanner = new Scanner(line);
				scanner.useDelimiter(",");
				while (scanner.hasNext()) {
					String data = scanner.next();
					if (index == 0)
						employeeData.setEmployeeName(data);
					else if(index == 1)
						employeeData.setHoursWorked(Integer.parseInt(data));
					else if(index == 2)
						employeeData.setPayRate(Double.parseDouble(data));
					else if(index == 3)
						employeeData.setStateCode(data);
					else if(index == 4)
						employeeData.setDependentCount(Integer.parseInt(data));
					else
						System.out.println("Invalid data in file: "+ data);
					
					index++;
				}	
				index = 0;
				employeeDataList.add(employeeData);
			}
		} catch (FileNotFoundException e) {
			log.error("CSV File not found: "+ csvFile, e);
		} catch (IOException e1) {
			log.error("Failed in reading CSV File: "+ csvFile, e1);
		}
		return employeeDataList;
	}
}
