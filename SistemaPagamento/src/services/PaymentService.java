package services;

public interface PaymentService {
	
	double paymentFee(double amount);
	double interest(double amount, int mounths);

}
