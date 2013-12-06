import java.util.Scanner;

public class UniqueNumbers {
	Scanner input = new Scanner(System.in);
	 private int iArrLength;
	private int iEnteredNumbers[];
	private int iUniqueNumbers[];
	private int iUniqueIndexCount;
	private boolean bUniqueZero;

	UniqueNumbers() {
		iArrLength = 0;
		iUniqueIndexCount = 0;
		bUniqueZero = false;
	}

	public void getAmountOfNumbers() {
		System.out.println("Please enter the quanity of numbers you will enter");
		// Only allow Integer input
		while (true) {
			try {
				iArrLength = Integer.parseInt(input.next());
				if (iArrLength > 0) {
					break;
				} else {
					System.out.println("Enter a number greater than 0");
				}
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid integer");
			}
		}
		iEnteredNumbers = new int[iArrLength];
		iUniqueNumbers = new int[iArrLength];

	}

	public void getNumbersEntered() {

		System.out.println("Please enter " + iArrLength + " number(s):");
		for (int i = 0; i < iArrLength; i++) {
			// Only allow Integer input
			while (true) {
				try {
					iEnteredNumbers[i] = Integer.parseInt(input.next());
					iUniqueNumbers[i] = 0;
					break;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid integer");
				}
			}
		}
		input.close();
	}

	public void findUniqueNumbers() {
		// Find the numbers
		if (iArrLength > 1) {
			for (int i = 0; i < iArrLength; i++) {
				for (int j = 0; j < iArrLength; j++) {
					if (iEnteredNumbers[i] == iUniqueNumbers[j]) {
						if (iUniqueNumbers[j] == 0 && bUniqueZero == false) {
							iUniqueNumbers[iUniqueIndexCount] = 0;
							iUniqueIndexCount++;
							bUniqueZero = true;
							break;
						}
						break;

					}

					if (j == iArrLength - 1) {
						iUniqueNumbers[iUniqueIndexCount] = iEnteredNumbers[i];
						iUniqueIndexCount++;
					}
				}
			}
			//Display the unique numbers
			System.out.print("The unique numbers you entered are:\t");
			for (int i = 0; i < iUniqueIndexCount; i++) {
				System.out.print(iUniqueNumbers[i] + " ");
			}
		} else { // If the user enters a single number, no sense in displaying
					// the numbers twice
			System.out.print("The single (unique) number you entered is:\t");
			System.out.println(iEnteredNumbers[0]);
		}
	}

}
