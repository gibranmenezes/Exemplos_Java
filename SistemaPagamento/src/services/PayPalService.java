package services;

public class PayPalService implements PaymentService {
	
	public static final double PAYMENT_FEE = 0.02;
	public static final double MONTHLY_INTEREST = 0.01; //para n�o precisar ficar colocando os valores na implementa��o.

	@Override
	public double paymentFee(double amount) {
		return amount * PAYMENT_FEE;
	}

	@Override
	public double interest(double amount, int months) {
		return amount * MONTHLY_INTEREST * months; //os juros em cada parcela � a taxa*valor*qtd de parcelas
	}
	
}
