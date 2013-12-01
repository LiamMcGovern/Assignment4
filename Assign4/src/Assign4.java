import java.util.Scanner;

public class Assign4 {
        private int iArrLength;
        static Scanner input = new Scanner(System.in);
        private int iEnteredNumbers[];
        private int iUniqueNumbers[];
        private int iUniqueIndexCount = 0;
        private boolean bUniqueZero=false;

        Assign4() {
                iArrLength = 0;
                iUniqueIndexCount=0;
        }

        private void getArrayLength() {
                System.out.println("Please enter the quanity of numbers you will enter");
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

        private void getArrayData() {

                System.out.println("Please enter " + iArrLength + " number(s):");
                for (int i = 0; i < iArrLength; i++) {

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
        }

        private void findUniqueNumbers() {
                if (iArrLength > 1) { 
                        //int iUniqueIndexCount = 0;
                        for (int i = 0; i < iArrLength; i++) {
                                for (int j = 0; j < iArrLength; j++) {
                                        //if (i == j) {
                                        //        continue;
                                        //}
                                        if (iEnteredNumbers[i] == iUniqueNumbers[j] ) {
                                        	if (iUniqueNumbers[j] == 0 && bUniqueZero == false){
                                        		iUniqueNumbers[iUniqueIndexCount] = 0;
                                        		iUniqueIndexCount++;
                                        		bUniqueZero=true;
                                        		break;
                                        	}
                                                //System.out.println("going to break now" + i + j);
                                                break;
                                                
                                        }
                                        
                                        if (j == iArrLength - 1) {
                                                System.out.printf("going to add it to array now i is at %d, j is at %d and the number to enter is %d%n", i, j, iEnteredNumbers[i] );
                                                iUniqueNumbers[iUniqueIndexCount] = iEnteredNumbers[i];
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
                        System.out.println("The value of the array is "        + iEnteredNumbers[i]);
                }
        }

        private void displayUniqueNumbers() {
                System.out.print("The unique numbers you entered are:\t");
                for (int i = 0; i < iUniqueIndexCount; i++) {
                        System.out.print(iUniqueNumbers[i]);
                }
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