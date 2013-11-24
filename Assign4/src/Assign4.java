import java.util.Scanner;

public class Assign4 {
	private int iArrLength;
	static Scanner input = new Scanner(System.in);
	private int iUniqueNumbers[];
	private boolean bNotUnique[];

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
		iUniqueNumbers = new int[iArrLength];
		bNotUnique = new boolean[iArrLength];
	}

	private void getArrayData() {

		System.out.println("Please enter " + iArrLength + " number(s):");
		for (int i = 0; i < iArrLength; i++) {

			while (true) {
				try {
					iUniqueNumbers[i] = Integer.parseInt(input.next()); //don't allow user to input anything but a a Int
					bNotUnique[i]=false;
					break;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid integer");
				}
			}
		}
}
	//}
//
	private void findUniqueNumbers() {
		System.out.print("The unique numbers you entered are:\t");
		if (iArrLength > 1){ //no sense in checking for unique numbers if there is only 1,
			for (int i = 1; i < iArrLength; i++) { //starting from the last position in the index, subtract one until you are at the first.
				for(int j = 0; j< iArrLength; j++){//starting at the first position in the index, increasing until the limit
					if (iUniqueNumbers[i] == iUniqueNumbers[j] && i !=j ){
						bNotUnique[i]= true;
					}
				}
			}
			
		} else {
			System.out.println(iUniqueNumbers[0]);
		}
	}
	private void test() {
		for (int i = 0; i < iArrLength; i++) {
			System.out.println("The value of the array is " + iUniqueNumbers[i]);
		}
	}

	public static void main(String[] args) {
		Assign4 ign4 = new Assign4();
		ign4.getArrayLength();
		ign4.getArrayData();
		ign4.test();
		System.out.println("_____________________________________________________________________________________________________________");
		ign4.findUniqueNumbers();
		ign4.test();
		input.close();
	}

}
