package services;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

import java.util.Date;



public class ContractService {
	
	private PaymentService paymentService;

	public ContractService(PaymentService paymentService) {
		this.paymentService = paymentService; //no prog pcpal vou ter que instanciar um paymentservice nessa classe
	}
	
	public void processContract(Contract contract, int months) {
			double basicQuota = contract.getTotalValue() / months;
		for(int i=1; i<=months; i++ ) {
			Date date = addMonths(contract.getDate(), i);
			double updatedQuota = basicQuota + paymentService.interest(basicQuota, i);
			double fullQuota = updatedQuota + paymentService.paymentFee(updatedQuota);
			contract.addInstallment(new Installment(date, fullQuota));
		}
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
		
		

}
