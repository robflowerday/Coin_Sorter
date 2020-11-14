// This line shows the package this class is in. The package holds a group of related classes. In this case CoinSorter, TestCoinSorter, CoinSorterGUI and TestCoinSorterGUI
package coinSorter;

// here are our imports, in this case we only import Scanner form the java.util package
import java.util.Scanner;

// we create a public class that can be accessed by other classes
/*
 * The purpose of this class is to create a Menu in the terminal that can be used with an object of the CoinSorter class to test the methods and attributes in the CoinSorter class
 */
public class TestCoinSorter {
	
	// we create a main method which allows our program to be run
	public static void main(String[] args) {
		
		//create an object of the CoinSorter Class to test on
		CoinSorter newCoinSorter = new CoinSorter();
		
		// create a do-while loop so that our program runs until we tell it not too
		// create a variable for the while loop to check against.
		int choice = 0;
		
		do {
			// prompt the user to choose from the menu
			System.out.println("Please choose an option from the menu below by entering an integer between 1 and 6 inclusive, with no other characters.\n");

			// Display our Menu
			System.out.println("***Coin Sorter - Main Menu***");
			System.out.println("1 - Coin calculator");
			System.out.println("2 - Multiple coin calculator");
			System.out.println("3 - Print coin list");
			System.out.println("4 - Set details");
			System.out.println("5 - Display program configurations");
			System.out.println("6 - Quit the program");
			
			// Collect or users choice (We'll create a scanner and collect a string rather than an integer to make the task of validating easier)
			Scanner keyboardString = new Scanner(System.in);
			String choiceString = keyboardString.nextLine();
			
			// we'll now validate that the given string holds just an integer.
			// If it doesn't we iterate through the loop again
			try {
				choice = Integer.parseInt(choiceString);
			}
			catch (NumberFormatException e) {
				// a user giving no input throws an error here as no input cannot be converted to an int using parseInt
				if (choiceString.equals("")) {
					System.out.println("\nNo input was given.");
				}
				// now we will display a message to cover all data types other than integers
				else {
					System.out.println("\nInput given is not an Integer, is larger than 2147483647 or is less than -2147483648.");
				}
				continue;
			}
			
			// now we'll enact the users choice using a switch statement.
			switch (choice) {
			
			case 1: 
				// first we'll explain the process
				System.out.println("\nGive the Coin Sorter an amount to exchange and a coin to exchange it into. We'll tell you how many of those coins you'll get and what remains.");

				// we prompt the user, and validate their inputs
				newCoinSorter.validateTotalCoinValue();
				
				// I have created a new method in the CoinSorter class to use the correct prompts
				newCoinSorter.validateCoinToExchange();
				
				// now we will use the values our user has chosen and our coinCalculator
				System.out.println("\n" + newCoinSorter.coinCalculator(newCoinSorter.getTotalCoinIn(), newCoinSorter.getExcludedCoin()) + "\n");
				
				// we use the break, so that the code does not run on to case two, if case 1 has been executed
				break;
				
			case 2:
				// we complete the code for this case in a similar way to the last
				System.out.println("\nGive the Coin Sorter an amount to exchange and optionally a coin to exclude from the exchange. We'll tell you how many of each coin you'll get and what remains.");
				newCoinSorter.validateTotalCoinValue();
				System.out.println("\nWould you like to exclude a coin from the exchange? ( y / n )");
				
				// here we set each answer to lower case, but we could have also used equalsIgnoreCase()
				String answer = keyboardString.nextLine().toLowerCase();
				while (!( (answer.equals("yes")) || (answer.equals("y")) || (answer.equals("no")) || (answer.equals("n")) )) {
					System.out.println("\nYou must type yes, no, y or n. This is not case sensitive");
					answer = keyboardString.nextLine().toLowerCase();
				}
				
				// we check weather the users answer was yes, if so we use the multiCoinCalculator with an excluded coin
				if ((answer.equals("yes")) || (answer.equals("y"))) {
					newCoinSorter.validateExcludedCoin();
					System.out.println(newCoinSorter.multiCoinCalculator(newCoinSorter.getTotalCoinIn(), newCoinSorter.getExcludedCoin()));
				}
				
				// else we use the multiCoinCalculator without excluding any coins
				else {
					System.out.println(newCoinSorter.multiCoinCalculator(newCoinSorter.getTotalCoinIn()));

				}
				break;
				
			case 3:
				
				// for this case, we simply call the printCoinList method
				System.out.println(newCoinSorter.printCoinList());
				break;
				
			case 4:
				// Here we have to repeat the process for creating a menu, but with different options
				
				int choice2 = -999;
				// space added for visual improvement
				System.out.println("");
				
				do {
					System.out.println("Please choose an option from the menu below by entering an integer between 1 and 4 inclusive, with no other characters.\n");

					// Display our Menu
					System.out.println("***Set Details Sub-Menu***");
					System.out.println("1 - Set currency");
					System.out.println("2 - Set minimum coin input value");
					System.out.println("3 - Set maximum coin input value");
					System.out.println("4 - Return to main menu");
					
					// we'll collect our user info in the same way as our last menu
					String choiceString2 = keyboardString.nextLine();
					
					// we'll now validate that the given string is an integer, and if it isn't repeat the loop
					try {
						choice2 = Integer.parseInt(choiceString2);
					}
					catch (NumberFormatException e) {
						// a user giving no input throws an error here as no input cannot be converted to an int using parseInt
						if (choiceString2.equals("")) {
							System.out.println("\nNo input was given.");
						}
						// now we will display a message to cover all data types that could be given other than integers
						else {
							System.out.println("\nInput given is not an Integer, is larger than 2147483647 or is less than -2147483648.");
						}
						continue;
					}
					
					switch (choice2) {
					
					case 1:
						
						// we create choice3 for a third menu
						int choice3 = -999;
						
						// space added for visual purposes
						
						System.out.println("\n");
						do {
							// print the menu
							System.out.println("Please choose an option from the menu below by entering an integer between 1 and 3 inclusive, with no other characters.\n");

							System.out.println("1 - GBP");
							System.out.println("2 - EUR");
							System.out.println("3 - USD");
							
							// I felt the options above this code were more appropriate than the potential options I have commented out below
							/*
							System.out.println("1 - Pound sterling (£)");
							System.out.println("2 - Euro (€)");
							System.out.println("3 - Dollar ($)");
							*/
							
							// Collect or users choice (We'll create a scanner and collect a string rather than an integer to make the task of validating easier
							String choiceString3 = keyboardString.nextLine();
							
							// we'll now validate that the given string is an integer, and if it isn't repeat the loop
							try {
								choice3 = Integer.parseInt(choiceString3);
							}
							catch (NumberFormatException e) {
								// a user giving no input throws an error here as no input cannot be converted to an int using parseInt
								if (choiceString3.equals("")) {
									System.out.println("\nNo input was given.");
								}
								// now we will display a message to cover all data types other than integers
								else {
									System.out.println("\nInput given is not an Integer, is larger than 2147483647 or is less than -2147483648.");
								}
								continue;
							}
							
						// use a switch statement to determine what action to take based on the users choice
						switch (choice3) {
						
						// in case one, set the currency to the GBP and p, which is a reference for pence or pennies
						case 1:
							newCoinSorter.setCoinList(newCoinSorter.getGBPCoinList());
							newCoinSorter.setSymbol("p");
							newCoinSorter.setCurrency("GBP" + " (" + newCoinSorter.getSymbol() + ")");
							break;
							
						// in case one, set the currency to the EUR and cent
						case 2:
							newCoinSorter.setCoinList(newCoinSorter.getEURCoinList());
							newCoinSorter.setSymbol("cent");
							newCoinSorter.setCurrency("EUR" + " (" + newCoinSorter.getSymbol() + ")");
							break;
						
						// in case one, set the currency to the USD and cent
						case 3:
							newCoinSorter.setCoinList(newCoinSorter.getUSDCoinList());
							newCoinSorter.setSymbol("cent");
							newCoinSorter.setCurrency("USD" + " (" + newCoinSorter.getSymbol() + ")");
							break;
							
						// we should never reach the default case, but I have added it as a fallback
						default:
							System.out.println("\nThere is no option " + choice3 + ".");
						}
						// the while statement checks that the integer given is within the appropriate bounds
						} while ((choice3 > 3)||(choice3 < 1));

						// we then display the results of our code
						System.out.println("\nYour currency is now: " + newCoinSorter.getCurrency() + newCoinSorter.printCoinList());
						break;

					case 2:
						// we prompt the user, and validate their inputs
						newCoinSorter.validateMinCoinIn();
						break;
						
					case 3:
						// we prompt the user, and validate their inputs
						newCoinSorter.validateMaxCoinIn();
						break;
						
					case 4:
						// we do not want an action to take place, this however will end the loop due to the while statement
						break;
						
					default:
						// this would be invoked if the integer was out of the correct bounds (1 and 3)
						System.out.println("\nThere is no option " + choice2 + ".");

					}
				// this while statement tells us that the statement will run until the user chooses option 4
				} while (choice2 != 4);
				break;
				
			case 5:
				// here we call the displayProgramConfigs() from the CoinSorter class
				System.out.println(newCoinSorter.displayProgramConfigs());
				break;
				
			// this option allows the user to leave the menu and end the program
			case 6:
				System.out.println("Thank you for using our coin sorter, have a good day.");
				break;
			
			// if none of the previous cases are satisfied, since we have already validated that the user entered an integer, we just have to ask that they choose one within the correct bounds
			default:
				// we must account for the fact that they may choose an out of range integer and display an appropriate message.
				// The below code will account for all invalid integers between -2147483648 and 2147483647 inclusive
				System.out.println("\nThere is no option " + choice + ".");
					
			}
			// this allows the loop to iterate until option 6 is chosen
		} while (choice != 6);
		
		
	}
}
