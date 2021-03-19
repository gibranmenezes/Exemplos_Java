package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.RentalService;
import model.services.BrazilTaxService;

public class Program_Loc {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		System.out.println("Enter rental data");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyyy HH:mm): ");
		Date finish = sdf.parse(sc.nextLine());
		
		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per hour: ");
		double pricePerDay = sc.nextDouble();
		
		CarRental carRental = new CarRental(start, finish, new Vehicle(carModel));
		
		RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());
		
		rentalService.processInvoid(carRental);
		
		System.out.println("INVOICE:");
		System.out.println("Basic payment: " + String.format("%.2f", carRental.getInvoice().getBasicPayment() ));
		System.out.println("Tax: " + String.format("%.2f", carRental.getInvoice().getTax() ));
		System.out.println("Total payment: " + String.format("%.2f", carRental.getInvoice().getTotalPayment() ));
		
		
		sc.close();

	}

}
