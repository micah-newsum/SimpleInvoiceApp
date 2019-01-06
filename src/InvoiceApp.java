import java.util.Scanner;
/**
 * @author mnewsum
 * Credit Murach's Java Programming 5th Edition
 */

public class InvoiceApp {

	public static void main(String[] args) {
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
			double total = subtotal - discountAmount;
			
			// display the results 
			String message = "Discount percent: " + discountPercent + "\n"
						   + "Discount amount:  " + discountAmount  + "\n"
						   + "Invoice total:    " + total + "\n";
			System.out.println(message);
			
			// see if user wants to continue 
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
		    System.out.println();
		}
	}
}
