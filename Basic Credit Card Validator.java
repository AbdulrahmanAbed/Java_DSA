package hw2;

import java.util.Scanner;

public class Hw2 {

	public static void main(String args[]) throws Exception {

		Scanner s = new Scanner(System.in);		// Creating a new scanner for user input

		String cardHoldersFirst = "Robert";		// Initializing and setting vals for the correct card holder first name
		String cardHoldersLast = " Bruce";		// Initializing and setting vals for the correct card holder last name

		System.out.println("What is the credit card holder's full name?");		// Print command asking user for input
		String firstName = s.next();		//Initializing a String var and setting it to whatever the user inputs as the first name
		String lastName = " " + s.next();	//Initializing a String var and setting it to whatever the user inputs as the last name

		while (!firstName.equals(cardHoldersFirst) && !lastName.equals(cardHoldersLast)) {		//A while continuously asking the user for more input, as long as the input was invalid
			System.out.println("The name provided is invalid, please try again.");
			firstName = s.next(); 		//Resetting the String var values every time new input is requested
			lastName = " " + s.next();	//Resetting the String var values every time new input is requested
		}

		System.out.println("What is the credit card number?");		//Once the user enters the correct input they pass to this print statement
		String creditCardNum = s.next();					//Initializing the credit card number as a String var because the "isThisCreditCardValid" requires it
		while (!isThisCreditCardValid(creditCardNum)) {		//Passing the CC number input to the method for validation
			System.out.println("The credit card number provided is invalid, please try again.");
			creditCardNum = s.next();
		}

		System.out.println("How much should be charged on the credit card?");
		float chargeAmount = s.nextFloat();		// Initializing charge amount as a float because need to account for change and we won't need more than 4 bytes because the max is $1000.00
		while (chargeAmount > 1000.00) { 		// A while loop to insure that insures a sure can only input charges =>1000.00
			System.out.println("The charge exceeds the credit maximum of the card, please try again.");
			chargeAmount = s.nextFloat();
		}
		System.out.println("You have successfully processed the payment in the amount of $" + chargeAmount);

	}
	
	// Testing valid console inputs:			Testing invalid console inputs:
	// Robert Bruce								Robert Bruse
	// 4417123456789113							4417123456789444
	// 110.14									1110.14

	public static boolean isThisCreditCardValid(String ccNumber) {	// CC number validation method provided
		int sum = 0;
		boolean alternate = false;
		for (int i = ccNumber.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(ccNumber.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}
}
