/**
 * 
 */
package com.cdk.global.assignment.paycheck.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdk.global.assignment.paycheck.model.PaySlip;


/**
 * @author Kashif
 *
 */
public class PaySlipWriter {
	private static final Logger log = LoggerFactory.getLogger(PaySlipWriter.class);
	
	public static final void writePaySlip(PaySlip paySlip){
		
		String fileName = System.getProperty("user.home") + "/paychecks/PaySlip_" + paySlip.getEmployeeName() + ".txt";
		File paySlipFile = new File(fileName);
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(paySlipFile);
			fileWriter.write(paySlip.toString());
			fileWriter.close();
			log.info("PaySlip of "+ paySlip.getEmployeeName() + " written to " + fileName + " !!!");
		} catch (IOException e) {
			log.error("Failed to write file for Employee:"+ paySlip.getEmployeeName(), e);
			
			if(fileWriter != null){
				try {
					fileWriter.close();
				} catch (IOException e1) {
					log.error("Failed to close FileWriter!!!", e1);
				}
			}
		}
	}
}

