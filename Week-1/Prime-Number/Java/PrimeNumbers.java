package Java;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            // take last input
            int lastNumber = scan.nextInt();

            // Take a boolean array and fill all of them with true values
            // True: Prime number, False: Non prime number
            boolean[] booleanArry = new boolean[lastNumber + 1];
            printPrimeValues(setBooleanForPrimeNumbersAndGetTheArray(booleanArry, lastNumber));
        }

    }

    // Checking prime number from : 2 to sqrt(n)
    protected static boolean[] setBooleanForPrimeNumbersAndGetTheArray(boolean[] booleanArray, int lastNumber) {
        // set boolean value fot the corresponding boolean array
        Arrays.fill(booleanArray, true);
        // Intializing 0th and 1th index to false
        booleanArray[0] = booleanArray[1] = false;

        // Setting prime numbers
        for (int i = 2; i <= Math.sqrt(lastNumber); i++) {
            if (booleanArray[i] == true)
                // Making its factors as non-prime
                for (int j = i * i; j < booleanArray.length; j += i)
                    booleanArray[j] = false;
        }
        return booleanArray;
    }

    // print only prime values
    protected static void printPrimeValues(boolean[] booleanArray) {
        for (int i = 2; i < booleanArray.length; i++) {
            if (booleanArray[i] == true)
                System.out.println(booleanArray[i] + " ");
        }
    }
}
