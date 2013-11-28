import java.util.Scanner;

public class Assign4 {
	private int iArrLength;
	static Scanner input = new Scanner(System.in);
	private int iEnteredNumbers[];
	private int iUniqueNumbers[];
	private int iUniqueIndexCount = 0;

	Assign4() {
		iArrLength = 0;
	}

	private void getArrayLength() {
		System.out.println("Please enter the quanity of unique numbers you will enter");

		while (true) {
			try {
				iArrLength = Integer.parseInt(input.next()); //don't allow user to input anything but a a Int
				if (iArrLength > 0){
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

	private void getArrayData() {

		System.out.println("Please enter " + iArrLength + " number(s):");
		for (int i = 0; i < iArrLength; i++) {

			while (true) {
				try {
					iEnteredNumbers[i] = Integer.parseInt(input.next()); //don't allow user to input anything but a a Int
//					bIsUnique[i]=false;
					break;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid integer");
				}
			}
		}
}
	//}
//
	/*
	 * New Idea, make a second list, and create a loop that enters a number, 
	 * if it's not already in the list, display that list
	 * this eliminates the issues that result of setting non unique numbers to 1.
	 */
	private void findUniqueNumbers() {
		if (iArrLength > 1){ //no sense in checking for unique numbers if there is only 1,
			int uniqueIndex=0;
			for (int i = 0; i < iArrLength; i++) { //starting from the last position in the index, subtract one until you are at the first.
				
				for (int j = 0; j <iArrLength; j++){
					if (j==i){
						continue;
					}
					if (iEnteredNumbers[i]==iEnteredNumbers[j]){
						break;
					}
					if (j == iArrLength-1){
						iUniqueNumbers[uniqueIndex] = iEnteredNumbers[i];
						iUniqueIndexCount++;
					}
				}
			}
			
		} else {
			System.out.print("The single (unique) number you entered is:\t");
			System.out.println(iEnteredNumbers[0]);
		}
	}
	private void test() {
		for (int i = 0; i < iArrLength; i++) {
			System.out.println("The value of the array is " + iEnteredNumbers[i]);
		}
	}
	private void displayUniqueNumbers(){
		System.out.print("The unique numbers you entered are:\t");
//		for (int i = 0; i < iArrLength; i++) {
//			if(bIsUnique[i] == true){
//				System.out.print(iEnteredNumbers[i]);
//			}
//		}
	}

	public static void main(String[] args) {
		Assign4 ign4 = new Assign4();
		ign4.getArrayLength();
		ign4.getArrayData();
		input.close();
		ign4.test();
		System.out.println("_____________________________________________________________________________________________________________");
		ign4.findUniqueNumbers();
		ign4.displayUniqueNumbers();


	} 

}
