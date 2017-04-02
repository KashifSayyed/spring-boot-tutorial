/**
 * 
 */
package com.cdk.global.assignment.paycheck.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cdk.global.assignment.paycheck.model.PaySlip;

/**
 * @author Kashif
 *
 */
public class PaySlipFileWorker implements Runnable {
	
	private static final Logger log = LoggerFactory.getLogger(PaySlipFileWorker.class);
	
	private PaySlip paySlip;
	
	public PaySlipFileWorker(PaySlip paySlip){
		this.paySlip = paySlip;
	}
	public void run() {
		log.info("Writing PaySlip to File by: "+ Thread.currentThread().getName());
		PaySlipWriter.writePaySlip(paySlip);
	}

}
