import java.util.Scanner;

public class Assign4 {
	private int iArrLength;
	static Scanner input = new Scanner(System.in);
	private int iData[];

	Assign4() {
		iArrLength = 0;
	}

	public void getArrayLength() {
		System.out
				.println("Please enter the quanity of unique numbers you will enter");

		while (true) {
			try {
				iArrLength = Integer.parseInt(input.next());
				break;
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid integer");
			}
		}
		iData = new int[iArrLength];
	}

	public void getArrayData() {

		System.out.println("Please enter " + iArrLength + " number(s):");
		for (int i = 0; i < iArrLength; i++) {

			while (true) {
				try {
					iData[i] = Integer.parseInt(input.next());
					break;
				} catch (NumberFormatException e) {
					System.out.println("Please enter a valid integer");
				}
			}
		}

	}

	public void displayUniqueNumbers() {
		for (int i = 0; i < iArrLength; i++) {

		}
	}

	public void test() {
		for (int i = 0; i < iArrLength; i++) {
			System.out.println("The value of the array is " + iData[i]);
		}
	}

	public static void main(String[] args) {
		Assign4 ign4 = new Assign4();
		ign4.getArrayLength();
		ign4.getArrayData();
		ign4.test();

		input.close();
	}

}
