package coinSorter;	// package that holds a group of related classes. In this case CoinSorter, TestCoinSorter, CoinSorterGUI and TestCoinSorterGUI

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * 
 * @author ***** not given as instructed in the brief
 *
 * this class will create a Coin Sorter that can be used to exchange a total value of coins into one, or many denominations
 */
public class CoinSorter {	// class is public so its methods and attributes are available to other classes
	
	// Attributes
	/* I have initialised most attributes as it is needed in some other languages, though it is not necessary to do so in Java.
	   All attributes here are private, meaning they can only be accessed within this class. */
	private String currency = "";	// currency of the CoinSorter
	private int minCoinIn = -997;	// minimum coins the can be exchanged using the coin sorter
	private int maxCoinIn = -998;	// maximum coins to be exchanged using the coin sorter
	private int totalCoinIn = -999;	// total coins the user wants to exchange using the coin sorter
	private int excludedCoin = 0;	// the coin the user will exchange into, or exclude from the exchange - depending on the method used
	private int coinToExchange = 0;
	private ArrayList<Integer> coinList;	// the list of coin denominations available in the current currency
		
	/* so as we can change to currency I will create coinLists for a few different currencies */
	private ArrayList<Integer> GBPCoinList = new ArrayList<>(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1));
	private ArrayList<Integer> USDCoinList = new ArrayList<>(Arrays.asList(100, 50, 25, 10, 5, 1));
	private ArrayList<Integer> EURCoinList = new ArrayList<>(Arrays.asList(200, 100, 50, 20, 10, 5, 2, 1));
	
	/* a symbol, which indicated the currency, e.g the symbol for GBP would be 'p' (not asked for in brief, but useful) */
	private String symbol = "p";
	
	private String successStatement = "";	// success statement used in validation procedures
	private String answerString = "";	// store user input as a string
	private int answerInt = -999;	// store user input as an integer

	
	// Methods (I will use the convention of (name of formal parameter with 'In' concatenated)
	// Constructors
	/* I have adapted the constructors (though not explicitly asked to do so, to include a symbol which is related to the currency
	   the constructors do not need a return type (not even void) they are unique in this way, 
	   they are also unique in that all words in their name are capitalised. */
	public CoinSorter(String currencyIn, int minCoinInIn, int maxCoinInIn, ArrayList<Integer> coinListIn, String symbolIn) {
		currency = currencyIn;
		minCoinIn = minCoinInIn;
		maxCoinIn = maxCoinInIn;
		coinList = coinListIn;
		symbol = symbolIn;
	}
	
	/* As we have created our own constructor we must recreate the default constructor if we wish to use it. In this case we do.
	   we have chosen the default parameters based on the brief given */
	public CoinSorter() {
		//currency = "Pound sterling (£)";
		currency = "GBP (p)";
		minCoinIn = 0;
		maxCoinIn = 10000;
		coinList = GBPCoinList;
		symbol = "p";
		
	}
	
	// Getters and Setters
	
	/* These, as with the other methods are public, this means that the methods can be accessed by other classes.
	  This is particularly useful in the case of these methods as they allow us to access and modify the attributes 
	  of the objects of this class. */
	
	/* all methods other than the constructors follow the convention of camelCase.
	   setters have a return statement of void (meaning they return no value)
	    and take a parameter that is used to set an attribute */
	
	/**
	 * modify the currency of the coin sorter
	 * modify symbol and coinList to match currency
	 * @param String currencyIn
	 */
	public void setCurrency(String currencyIn) {
		currency = currencyIn;
		
		if (currency.equals("GBP (p)")) {	// if chosen currency is GBP change symbol and coin list appropriately
			symbol = "p";
			coinList = GBPCoinList;
		} else if (currency.equals("EUR (cent)")) {	// if chosen currency is EUR change symbol and coin list appropriately
			symbol = " cent";
			coinList = EURCoinList;
		} else {	// else chosen currency is USD, change symbol and coin list appropriately
			symbol = " cent";
			coinList = USDCoinList;
		}
	}
	
	/**
	 * modify minimum value of coins accepted by the coin sorter
	 * @param int minCoinInIn
	 */
	public void setMinCoinIn(int minCoinInIn) {
		minCoinIn = minCoinInIn;
	}
	
	/**
	 * modify the maximum value of coins accepted by the coin sorter
	 * @param int maxCoinInIn
	 */
	public void setMaxCoinIn(int maxCoinInIn) {
		maxCoinIn = maxCoinInIn;
	}
	
	/**
	 * access the coin sorters current currency
	 * @return String currency
	 */
	public String getCurrency() {
		return currency;
	}
	
	/**
	 * access the coin sorters minimum accepted input coin value
	 * @return int minCoinIn
	 */
	public int getMinCoinIn() {
		return minCoinIn;
	}
	
	/**
	 * access the coin sorters maximum accepted input coin value
	 * @return int maxCoinIn
	 */
	public int getMaxCoinIn() {
		return maxCoinIn;
	}
	
	// the following getters and setters are not asked for explicitly, but allow our program to work much more easily
	/**
	 * access the total coin value inputed by the user
	 * @return int totalCoinIn
	 */
	public int getTotalCoinIn() {
		return totalCoinIn;
	}
	
	/**
	 * access the coin denomination chosen by the user
	 * @return int excludedCoin
	 */
	public int getExcludedCoin() {
		return excludedCoin;
	}
	
	/**
	 * access the symbol of the current currency of the coin sorter
	 * @return String symbol
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * access the array list containing the coin denominations in GBP (p)
	 * @return ArrayList<Integer> GBPCoinList
	 */
	public ArrayList<Integer> getGBPCoinList() {
		return GBPCoinList;
	}

	/**
	 *  access the array list containing the coin denominations in USD (cent)
	 * @return ArrayList<Integer> USDCoinList
	 */
	public ArrayList<Integer> getUSDCoinList() {
		return USDCoinList;
	}

	/**
	 * access the array list containing the coin denominations in USD (cent)
	 * @return ArrayList<Integer> EURCoinList
	 */
	public ArrayList<Integer> getEURCoinList() {
		return EURCoinList;
	}
	
	/**
	 * access the current coin list of the coin sorter
	 * @return ArrayList<Integer> coinList
	 */
	public ArrayList<Integer> getCoinList() {
		return coinList;
	}
	
	/**
	 * modify the current coin list of the coin sorter
	 * @param ArrayList<Integer> coinListIn
	 */
	public void setCoinList(ArrayList<Integer> coinListIn) {
		coinList = coinListIn;
	}
	
	/**
	 * modify the symbol of the current coin list
	 * @param String symbolIn
	 */
	public void setSymbol(String symbolIn) {
		symbol = symbolIn;
	}
	
	/**
	 * modify the total coin value the user would like to exchange with the coin list
	 * @param int totalCoinInIn
	 */
	public void setTotalCoinIn(int totalCoinInIn) {
		totalCoinIn = totalCoinInIn;
	}
	
	/**
	 * access success statement
	 */
	public String getSuccessStatement() {
		return successStatement;
	}
	
	/**
	 * modify success statement
	 * @param successStatementIn
	 */
	public void setSuccessStatement(String successStatementIn) {
		successStatement = successStatementIn;
	}
	
	/**
	 * modify excluded coin
	 * @param excludedCoinIn
	 */
	public void setExcludedCoin(int excludedCoinIn) {
		excludedCoin = excludedCoinIn;
	}
	
	/**
	 * modify answerString
	 * @param String stringIn
	 */
	public void setAnswerString(String stringIn) {
		answerString = stringIn;
	}
	
	/**
	 * access answerString
	 * @return String answerString
	 */
	public String getAnswerString() {
		return answerString;
	}
	
	/**
	 * modify answerInt
	 * @param int intIn
	 */
	public void setAnswerInt(int intIn) {
		answerInt = intIn;
	}
	
	/**
	 * access answerInt
	 * @return int answerInt
	 */
	public int getAnswerInt() {
		return answerInt;
	}
	
	// Other Methods

	/**
	 * prints the values of the coin list in a user friendly manner
	 * @return String stringOut
	 */
	public String printCoinList() {
		

		String stringOut = "\nThe current coin denominations in circulation are:\n";	// a String variable with the start of the string the method will return
		
		for (Integer coin : coinList) {	// a for each loop to iterate through coinList and append each item (Which are integers), separated by a comma to the result String object
			stringOut += coin + ", ";
		}
		
		stringOut = stringOut.substring(0, stringOut.length() - 2);	// take of the last comma by taking a substring of the return string
		stringOut += '.';	// replace this comma with a full stop
		
		return stringOut;	// return stringOut
	}
	
	
	/**
	 * accesses the program configurations as a human readable String
	 * uses decimal formatting so that the output is easier to read
	 * 
	 * @return String (program configurations)
	 */
	public String displayProgramConfigs() {
		DecimalFormat df = new DecimalFormat("#,##0");
		return "\nCurrency: \t\t\t\t\t\t\t" + getCurrency()
		+ "\nMinimum Value that can be exchanged: \t" + df.format(getMinCoinIn())
		+ "\nMaximum Value that can be exchanged: \t" + df.format(getMaxCoinIn()) + "\n";
	}
	
	/* validation methods */
	
	/* I have been asked in the brief to create 2 validation methods, validateTotalValue() and validateExcludedValue()
	 * I have created many other methods here that will be used to assist these two methods and also for other validation purposes */
	
	/**
	 * takes in a string
	 * returns true if the string can be cast to type int (is an integer that is smaller than 2147483648 and larger than -2147483649)
	 * returns false otherwise
	 * 
	 * @param String stringIn
	 * @return boolean
	 */
	public boolean isInt(String stringIn) {
		try {	// try catch block to catch a NumberFormatException that would arise if the number could not be cast to type int
			Integer.parseInt(stringIn);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * takes in a value intIn and checks if it is between minIn and maxIn inclusive
	 * returns -1 if it is less than minIn
	 * returns 0 if it is between minIn and maxIn
	 * returns 1 if it is above maxIn
	 * 
	 * @param int intIn
	 * @param int minIn
	 * @param int maxIn
	 * @return int
	 */
	public int isBetween(int intIn, int minIn, int maxIn) {
		if (intIn < minIn) {	// if else if else statement to check whether intIn is less than greater than or between minIn and maxIn
			return -1;
		} else if (intIn > maxIn) {
			return 1;
		} else {
			return 0;
		}
	}
	
	/**
	 * takes in an integer that represents a coin, and checks weather it is in an array list - in our case, a coin list
	 * returns true if it is in the list and false otherwise
	 * 
	 * @param int intIn
	 * @param ArrayList<Integer> listIn
	 * @return boolean
	 */
	public boolean inCoinList(int intIn, ArrayList<Integer> listIn) {
		if (listIn.contains(intIn)) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * prints a prompt message to the console
	 * collects user input as a string so that we do not have to recreate scanner objects
	 * strings have been used to both simplify and customise error handling by using the NumberFormatException possibility when casting a String to an in
	 * 
	 * @param messageIn
	 * @return String
	 */
	public String promptUser(String messageIn) {
		System.out.println(messageIn);
		Scanner keyboardString = new Scanner(System.in);
		return keyboardString.nextLine();
	}
	
	/**
	 * convenience method to parse integers from strings after they have been validated by isInt
	 * @param String stringIn
	 * @return int
	 */
	public int toInt(String stringIn) {
		return Integer.parseInt(stringIn);
	}
	
	/* 	validateTotalCoinValue() 
		validateExcludedCoin() 
		These methods should prompt for user input and validate the values to ensure that it’s within the expected range
		as outlined in the brief. The methods should keep prompting for user inputs until a valid value is entered.
 */
	/**
	 * prompts the user for input of the total coin value they would like to exchange using the coin calculator or multiple coin calculator
	 * validates that this value is a valid integer
	 * validates that this value is between the minimum accepted coin value and the maximum accepted coin value
	 * prompts the user for another input if this is not the case
	 */
	public void validateTotalCoinValue() {
		
		answerString = "";	// resetting answer to an empty String so that it can be used with no errors
		answerInt = -999;	// resetting answerInt to negative number so that it can be used with no errors
		
		do {	// start a do while loop to iterate over whilst validation fails
			
			answerString = promptUser("Please enter an integer between " + minCoinIn + " and " + maxCoinIn + " inclusive.");	//prompt user and store the answer using promptUser() method
			
			if (isInt(answerString)) {	// check if input is a valid integer
				answerInt = toInt(answerString);	// cast input to type int
			} else {	// if it cannot be cast to an int, we display the appropriate error
				if (answerString.equals("")) {
					System.out.println("You gave no response");	// user entered no input
				} else {
					System.out.println("The response you gave either, wasn't an integer, was less than -2147483648 or was greater than 2147483647");	// input entered was not a valid integer
				}
				continue;
			}
			
			if (isBetween(answerInt, minCoinIn, maxCoinIn) == 0) {	// check whether the user input is between the minimum and maximum allowed values
				totalCoinIn = answerInt;	// set totalCoinIn equal to the user input
			} else if (isBetween(answerInt, minCoinIn, maxCoinIn) == 1) {	// else check if it is greater than the maximum allowed value
				System.out.println("The response you gave was greater than the maximum allowed value: " + maxCoinIn);	//display appropriate error message
				continue;	// end this iteration of the loop and start a new one to prompt the user again
			} else {	// else it must be less than the minimum allowed value
				System.out.println("The response you gave was less than the minimum allowed value: " + minCoinIn);	//display appropriate error message
				continue;	// end this iteration of the loop and start a new one to prompt the user again
			}
			
		} while (isBetween(answerInt, minCoinIn, maxCoinIn) != 0);	// while condition stipulates validation must pass
			
	}
	
	/**
	 * prompts the user for input of the minimum coin value they would like to allow coin calculator or multiple coin calculator to exchange
	 * validates that this value is a valid integer
	 * validates that this value is between 0 and the maximum accepted coin value
	 * prompts the user for another input if this is not the case
	 */
	public void validateMinCoinIn() {
		
		answerString = "";	// resetting answer to an empty String so that it can be used with no errors
		answerInt = -999;	// resetting answerInt to negative number so that it can be used with no errors
		
		do {	// start a do while loop to iterate over whilst validation fails
			
			answerString = promptUser("Please enter an integer between 0 and " + maxCoinIn + " inclusive.");	//prompt user and store the answer using promptUser() method
			
			if (isInt(answerString)) {	// check if input is a valid integer
				answerInt = toInt(answerString);	// cast input to type int
			} else {	// if it cannot be cast to an int, we display the appropriate error
				if (answerString.equals("")) {
					System.out.println("You gave no response");	// user entered no input
				} else {
					System.out.println("The response you gave either, wasn't an integer, was less than -2147483648 or was greater than 2147483647");	// input entered was not a valid integer
				}
				continue;
			}
			
			if (isBetween(answerInt, 0, maxCoinIn) == 0) {	// check whether the user input is between 0 and maximum allowed values
				minCoinIn = answerInt;	// set minCoinIn equal to the user input
			} else if (isBetween(answerInt, 0, maxCoinIn) == 1) {	// else check if it is greater than the maximum allowed value
				System.out.println("The response you gave was greater than the maximum allowed value: " + maxCoinIn);	//display appropriate error message
				continue;	// end this iteration of the loop and start a new one to prompt the user again
			} else {	// else it must be less than the minimum allowed value
				System.out.println("The response you gave was less than the minimum allowed value: 0");	//display appropriate error message
				continue;	// end this iteration of the loop and start a new one to prompt the user again. This is not necessary as we reach the end of the loop either way and the while loop test will pass, nor is it an issue
			}
			
		} while (isBetween(answerInt, 0, maxCoinIn) != 0);	// while condition stipulates validation must pass
			
	}
	
	/**
	 * prompts the user for input of the maximum coin value they would like to allow coin calculator or multiple coin calculator to exchange
	 * validates that this value is a valid integer
	 * validates that this value is between the minimum accepted coin value and 2147483647
	 * prompts the user for another input if this is not the case
	 */
	public void validateMaxCoinIn() {
		
		answerString = "";	// resetting answer to an empty String so that it can be used with no errors
		answerInt = -999;	// resetting answerInt to negative number so that it can be used with no errors
		
		do {	// start a do while loop to iterate over whilst validation fails
			
			answerString = promptUser("Please enter an integer between " + minCoinIn + " and 2147483647 inclusive.");	//prompt user and store the answer using promptUser() method
			
			if (isInt(answerString)) {	// check if input is a valid integer
				answerInt = toInt(answerString);	// cast input to type int
			} else {	// if it cannot be cast to an int, we display the appropriate error
				if (answerString.equals("")) {
					System.out.println("You gave no response");	// user entered no input
				} else {
					System.out.println("The response you gave either, wasn't an integer, was less than -2147483648 or was greater than 2147483647");	// input entered was not a valid integer
				}
				continue;
			}
			
			if (isBetween(answerInt, minCoinIn, 2147483647) == 0) {	// check whether the user input is between the minimum allowed value and 2147483647
				minCoinIn = answerInt;	// set minCoinIn equal to the user input
			} else {	// else it must be less than the minimum allowed value as a number greater than 2147483647 cannot be stored as an int
				System.out.println("The response you gave was less than the minimum allowed value: " + minCoinIn);	//display appropriate error message
				continue;	// end this iteration of the loop and start a new one to prompt the user again. This is not necessary as we reach the end of the loop either way and the while loop test will pass, nor is it an issue
			}
			
			
			
			
		} while (isBetween(answerInt, minCoinIn, 2147483647) != 0);	// while condition stipulates validation must pass
			
	}
	
	
	/**
	 * prompts the user to input their choice of coin to exclude
	 * validates that this value is a valid integer
	 * validates that this value is between the minimum accepted coin value and 2147483647
	 * prompts the user for another input if this is not the case
	 */
	
	public void validateExcludedCoin() {
		
		answerString = "";	// resetting answer to an empty String so that it can be used with no errors
		answerInt = -999;	// resetting answerInt to negative number so that it can be used with no errors
		excludedCoin = -999;	// setting excluded coin so that it is out of bounds so that it can be used with no errors
		
		do {	// start a do while loop to iterate over whilst validation fails
			
			answerString = promptUser("Please enter the coin you would like to exclude, as an integer in (" + symbol + ") - " + currency + " from the list below:\n" + printCoinList());	//prompt user and store the answer using promptUser() method

			if (isInt(answerString)) {	// check if input is a valid integer
				answerInt = toInt(answerString);	// cast input to type int
			} else {	// if it cannot be cast to an int, we display the appropriate error
				if (answerString.equals("")) {
					System.out.println("You gave no response");	// user entered no input
				} else {
					System.out.println("The response you gave either, wasn't an integer, was less than -2147483648 or was greater than 2147483647");	// input entered was not a valid integer
				}
				continue;
			}
			
			if (inCoinList(answerInt, coinList)) {	// check if the user input is in the current coin list
				excludedCoin = answerInt;	// if user input in coin list, set it as excluded coin
			} else {	// else print appropriate error
				System.out.println(answerInt + " is not a valid coin denomination in the curent coin list");
				continue;	// this is not necessary as it is at the end of the do while loop and to get to this stage, the result would not pass the conditions in the wile loop. However, it is not an issue and can help avoid an error if there is a mistake in the code
			}
		
		
		} while(!inCoinList(excludedCoin, coinList));	// loop again whilst the coin selection is invalid
	}
	
	
	/**
	 * *** same as validateExcludedCoin() method, except for wording in the prompt, will not be used in CoinSorterGUI ***
	 * prompts the user to input their choice of coin to use in the exchange
	 * validates that this value is a valid integer
	 * validates that this value is between the minimum accepted coin value and 2147483647
	 * prompts the user for another input if this is not the case
	 */
	public void validateCoinToExchange() {
		
		answerString = "";	// resetting answer to an empty String so that it can be used with no errors
		answerInt = -999;	// resetting answerInt to negative number so that it can be used with no errors
		excludedCoin = -999;	// setting excluded coin so that it is out of bounds so that it can be used with no errors
		
		do {	// start a do while loop to iterate over whilst validation fails
			
			answerString = promptUser("Please enter the coin you would like to use in the exchange, as an integer in (" + symbol + ") - " + currency + " from the list below:\n" + printCoinList());	//prompt user and store the answer using promptUser() method

			if (isInt(answerString)) {	// check if input is a valid integer
				answerInt = toInt(answerString);	// cast input to type int
			} else {	// if it cannot be cast to an int, we display the appropriate error
				if (answerString.equals("")) {
					System.out.println("You gave no response");	// user entered no input
				} else {
					System.out.println("The response you gave either, wasn't an integer, was less than -2147483648 or was greater than 2147483647");	// input entered was not a valid integer
				}
				continue;
			}
			
			if (inCoinList(answerInt, coinList)) {	// check if the user input is in the current coin list
				excludedCoin = answerInt;	// if user input in coin list, set it as excluded coin
			} else {	// else print appropriate error
				System.out.println(answerInt + " is not a valid coin denomination in the curent coin list");
				continue;	// this is not necessary as it is at the end of the do while loop and to get to this stage, the result would not pass the conditions in the wile loop. However, it is not an issue and can help avoid an error if there is a mistake in the code
			}
		
		
		} while(!inCoinList(excludedCoin, coinList));	// loop again whilst the coin selection is invalid
	}
	
	/* calculation methods */
	
	/**
	 * Pass two pre-validated arguments, validating them with validateTotalCoinValue() and validate validateCoinToExchange()
	 * calculate the number of coins in the chosen denomination can be exchanged before the chosen total value in is reached
	 * calculate the remainder
	 * show this in a human readable manner
	 * 
	 * @param int totalCoinValueIn
	 * @param int coinToExchangeIn
	 * @return String
	 */
	public String coinCalculator(int totalCoinValueIn, int coinToExchangeIn) {
		
		/* we initialise two integer variables to be reset later */
		int numberOfCoins = -999;
		int remainder = -999;
		
		numberOfCoins = totalCoinValueIn / coinToExchangeIn;	// this line calculates the number of the specified coins that we can have before we surpass the total value
		remainder = totalCoinValueIn % coinToExchangeIn;		// this line calculates the remainder
		
		// we then return this in a manner that is easy to read and understand
		return "A total of " + numberOfCoins + " x " + coinToExchangeIn + symbol + " coins can be exchanged, with a remainder of " + remainder + symbol + ".";
	}
	
	

	/**
	 * Pass two pre-validated arguments, validating them with validateTotalCoinValue() and validate validateCoinToExclude()
	 * calculate the number of coins in each denomination except the chosen excluded denomination that can be exchanged 
	 * before the chosen total value in is reached
	 * calculate the remainder
	 * show this in a human readable manner
	 * 
	 * @param int totalCoinValueIn
	 * @param int excludedCoinIn
	 * @return String
	 */
	public String multiCoinCalculator(int totalCoinValueIn, int excludedCoinIn) {
		
		/* again we initialise these variables to be reset later */
		int numberOfCoins = 0;
		int remainder = 0;
		
		// we then initialise our output String
		String outputString = "The coins exchanged are: ";
			
			
		Collections.sort(coinList, Collections.reverseOrder());	// we sort our list so that is is ordered from high to low
		
		
		for (int coin : coinList) {	// we then use a for each loop to iterate through our coinList
			
			// we now filter out our excluded coin
			if (coin != excludedCoinIn) {
				
				// then calculate the number of each coin we need and the remainder, before adding the numbers of each coin to our Output String
				numberOfCoins = totalCoinValueIn / coin;
				remainder = totalCoinValueIn % coin;
				totalCoinValueIn = remainder;
				outputString += numberOfCoins + " x " + coin + symbol + ", ";
			}
		}
		
		outputString += "with a remainder of " + remainder + symbol;	// then we add the remainder to the outputString
		
		return outputString;	// we return the outputString
	}
	
	/**
	 * I have chosen to overload this method so that we allow for the option to not exclude a coin
	 * 
	 * Pass one pre-validated argument, validating it with validateTotalCoinValue()
	 * calculate the number of coins in each denomination that can be exchanged 
	 * before the chosen total value in is reached
	 * calculate the remainder
	 * show this in a human readable manner
	 * 
	 * @param int totalCoinValueIn
	 * @param int excludedCoinIn
	 * @return String
	 */
	public String multiCoinCalculator(int totalCoinValueIn) {
		
		/* again we initialise these variables to be reset later */
		int numberOfCoins = 0;
		int remainder = 0;
		
		// we then initialise our output String
		String outputString = "The coins exchanged are: ";
			
			
		Collections.sort(coinList, Collections.reverseOrder());	// we sort our list so that is is ordered from high to low
		
		
		for (int coin : coinList) {	// we then use a for each loop to iterate through our coinList
			
			// then calculate the number of each coin we need and the remainder, before adding the numbers of each coin to our Output String
			numberOfCoins = totalCoinValueIn / coin;
			remainder = totalCoinValueIn % coin;
			totalCoinValueIn = remainder;
			outputString += numberOfCoins + " x " + coin + symbol + ", ";
		}
		
		outputString += "with a remainder of " + remainder + symbol;	// then we add the remainder to the outputString
		
		return outputString;	// we return the outputString
	}
}