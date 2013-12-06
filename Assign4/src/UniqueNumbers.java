/**
 * Class: 			CST8110
 * Lab Teacher:     Prof. Howard Rosenblum
 * Lab Section: 	402
 * Student: 		Liam McGovern
 * Assignment:		#4 Unique Numbers.
 */

import java.util.Scanner;

public class UniqueNumbers {
	Scanner input = new Scanner(System.in); //Allow input
	private int iArrLength; //Used to defines the length of the Arrays
	private int iEnteredNumbers[]; //Array to hold the values of the Entered Numbers
	private int iUniqueNumbers[]; //Array to hold the values of the Unique Numbers
	
	UniqueNumbers() { //Default constructor
		iArrLength = 0;
	}

	public void getAmountOfNumbers() { //Get the quantity of numbers to be entered.
		System.out.println("Please enter the quanity of numbers you will enter");
		// Only allow Integer input
		while (true) {
			try {
				iArrLength = Integer.parseInt(input.next());
				if (iArrLength > 0) { 
					break;
				} else { //Prevents numbers entered being less than or equal to 0.
					System.out.println("Enter a number greater than 0");
				}
			} catch (NumberFormatException e) { //Prevents non integer input.
				System.out.println("Please enter a valid integer");
			}
		}
		// Define scope of arrays
		iEnteredNumbers = new int[iArrLength]; 
		iUniqueNumbers = new int[iArrLength];
	}

	public void getNumbersEntered() { //Get each number to be put in iEnteredNumbers at position i.
		System.out.println("Please enter " + iArrLength + " number(s):");
		for (int i = 0; i < iArrLength; i++) {
			// Only allow Integer input
			while (true) {
				try {
					iEnteredNumbers[i] = Integer.parseInt(input.next());
					iUniqueNumbers[i] = 0;
					break;
				} catch (NumberFormatException e) { //Prevents non integer input.
					System.out.println("Please enter a valid integer");
				}//end catch
			}//end while
		}//end for
		input.close(); //Scanner is no longer used at this point, therefore it can be safely closed.
	} //end gNE

	public void findUniqueNumbers() {  //Find and display the Unique Numbers
		boolean boUniqueZero = false; //Used to check if a zero has been entered into the unique numbers.
		int iUniqueIndexCount = 0; //Used to count and later display the number of unique numbers.
		if (iArrLength > 1) { //If there is only one number entered, no sense in checking for unique numbers.
			for (int i = 0; i < iArrLength; i++) { //i in this loop is for the position of iEnteredNumbers, that will be check against j in iUniqueNumbers
				for (int j = 0; j < iArrLength; j++) { //j in this loop is for the position in iUniqueNumbers
					if (iEnteredNumbers[i] == iUniqueNumbers[j]) { //If the value of the position we are checking is equal to any value iUnique then....
						if (iUniqueNumbers[j] == 0 && boUniqueZero == false) { 
							iUniqueNumbers[iUniqueIndexCount] = 0;
							iUniqueIndexCount++;
							boUniqueZero = true;
							break; 
						}//end if
						break;

					} // end if
					//If we reach reach the scope of the array without finding a match, add it to iUniqueNumbes.
					if (j == iArrLength - 1) {
						iUniqueNumbers[iUniqueIndexCount] = iEnteredNumbers[i];
						iUniqueIndexCount++;
					} // end if
				}// end for j
			}// end for i
			//Display the unique numbers
			System.out.print("The unique numbers you entered are:\t");
			for (int i = 0; i < iUniqueIndexCount; i++) {
				System.out.print(iUniqueNumbers[i] + " ");
			}// end for i
		} else { // If the user enters a single number, no sense in displaying the numbers twice
			System.out.print("The single (unique) number you entered is:\t");
			System.out.println(iEnteredNumbers[0]);
		} //end else
	}//end fUN
}//end UN class
