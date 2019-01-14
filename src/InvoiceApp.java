import java.util.Scanner;
import java.text.NumberFormat;
/**
 * @author mnewsum
 * This is a simple invoice application that exhibits some of the fundamental components 
 * of the Java language. 
 */

public class InvoiceApp {

	public static void main(String[] args) {
		final double SALES_TAX_PCT = .0925;
				
		System.out.println("Simple Invoice Application");
		System.out.println(); // prints a blank line
		
		// instantiate a new scanner object named sc. Pass as parameter System.in...
		Scanner sc = new Scanner(System.in);
		
		// perform invoice calculations until choice isn't equal to "y" or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			//get the invoice subtotal from the user 
			System.out.print("Enter subtotal:  ");
			double subtotal = sc.nextDouble();
			
			// get the discount percent
			double discountPercent;
			if (subtotal >= 200) {
				discountPercent = .2;
			} else if (subtotal >= 100) {
				discountPercent = .1;				
			} else {
				discountPercent = 0.0;
			}
			
			// calculate the discount amount and total 
			double discountAmount = subtotal * discountPercent;
			double totalBeforeTax = subtotal - discountAmount;
			double salesTax = totalBeforeTax * SALES_TAX_PCT;
			double total = totalBeforeTax + salesTax;
			
			// display the results 
			NumberFormat currency = NumberFormat.getCurrencyInstance();
			NumberFormat percent = NumberFormat.getPercentInstance();
					
			String message = "Discount percent: " + percent.format(discountPercent) + "\n"
						   + "Discount amount:  " + currency.format(discountAmount)  + "\n"
						   + "Invoice total:    " + currency.format(total) + "\n"
						   + "Sales tax:        " + currency.format(salesTax) + "\n"
						   + "Invoice total:    " + currency.format(total) + "\n";
			System.out.println(message);
			
			// see if user wants to continue 
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
		    System.out.println();
		}
	}
}
