import java.util.Scanner;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;  //enumeration

/**
 * @author mnewsum
 * This is a simple invoice application that exhibits some of the fundamental components 
 * of the Java language. 
 */

public class InvoiceApp {

	public static void main(String[] args) {
		
		/*
		 * It's often best to create BigDecimal objects from strings rather than 
		 * floating point numbers because float/doubles do not always represent decimal numbers exactly.
		 */
		final BigDecimal SALES_TAX_PCT = new BigDecimal(".0925");
				
		System.out.println("Simple Invoice Application");
		System.out.println(); // prints a blank line
		
		// instantiate a new scanner object named sc. Pass as parameter System.in...
		Scanner sc = new Scanner(System.in);
		
		// perform invoice calculations until choice isn't equal to "y" or "Y"
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			
			//get the invoice subtotal from the user 
			System.out.print("Enter subtotal:  ");
			String subtotalString = sc.next();
			
			// create the BigDecimal objects
			BigDecimal subtotal = new BigDecimal(subtotalString);
			BigDecimal discountPercent;
			if (subtotal.doubleValue() >= 200) {
				discountPercent = new BigDecimal(".2");
			} else if (subtotal.doubleValue() >= 100) {
				discountPercent = new BigDecimal(".1");				
			} else {
				discountPercent = new BigDecimal("0.0");
			}
			
			// calculate the discount amount and total 
			BigDecimal discountAmount = subtotal.multiply(discountPercent).setScale(2, RoundingMode.HALF_UP);
			BigDecimal totalBeforeTax = subtotal.subtract(discountAmount);
			BigDecimal salesTax = SALES_TAX_PCT.multiply(totalBeforeTax).setScale(2, RoundingMode.HALF_UP);
			BigDecimal total = totalBeforeTax.add(salesTax);
			
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
