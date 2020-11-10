package Java;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNumberFindingUsingSieveOfEratrothenis {
    public static void main(String[] args) {
        int lastNumber = initializeScanner().nextInt();
        // initialize an boolean array and fill all the values as true
        boolean[] primeNumbers = new boolean[lastNumber+1];
        // fill all the array values as true
        Arrays.fill(primeNumbers, true);
        // fill first two index as false
        primeNumbers[0]=primeNumbers[1]=false;

        // find primes and print them
        printPrimeNumbers(findPrimes(primeNumbers,lastNumber));

    }

    // init the scanner
    private static Scanner initializeScanner(){
      Scanner scanner = new Scanner(System.in);
            return scanner;
    }

    // find the primes
    private static boolean[] findPrimes(boolean[] primeNumbersArray,int lastNumber){
            for (int i = 0; i <=Math.sqrt(lastNumber); i++) {
                if(primeNumbersArray[i] == true) makePrimeNumbersFactorsNonPrime(primeNumbersArray,i);
            }
            return primeNumbersArray;
    }

    /// make the prime numbers factors non-prime
    private static boolean[] makePrimeNumbersFactorsNonPrime(boolean[] primeNumbersArray, int i){
        for (int j = i*i; j < primeNumbersArray.length; j+=i) {
            primeNumbersArray[j] = false;
        }
        return primeNumbersArray;
    }

    // print the prime numbers
    private static void printPrimeNumbers(boolean[] primeNumbersArray){
        for (int i = 0; i < primeNumbersArray.length; i++) {
            if(primeNumbersArray[i] == true) System.out.print(i+" ");
        }
    }
}