package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DistinctPrimes {
    public static void main(String[] args) {
        List<Integer> luckyNumbers = new LinkedList<>();
        try(Scanner input = new Scanner(System.in)){
            int numberOfTestCases = input.nextInt();
            while(numberOfTestCases-->0){
                luckyNumbers.add(findLuckyNumber(input.nextInt()));
            } 
        }
        printLuckyNumbers(luckyNumbers);
    }
    
    // print the lucky numbers
    private static void printLuckyNumbers(List<Integer> luckyNumberList){
        for (int i = 0; i < luckyNumberList.size(); i++) {
            System.out.println(luckyNumberList.get(i));
        }
    }

    // generate lucky numbers
    private static Integer findLuckyNumber(int nthTerm){
        List<Integer> luckyNumberList = new LinkedList<>(Arrays.asList(30));
        Integer i = 31;
        if(nthTerm != 1){   
        while(true){
            if(isLucky(i)) luckyNumberList.add(i);
            if(luckyNumberList.size() == nthTerm) break;
            i++;
        }
        }
        return luckyNumberList.get(luckyNumberList.size()-1);
    }

    // check the number is lucky or not
    private static boolean isLucky(Integer number){
        boolean luckyNumber = false;
        List<Integer> primeFactors = findPrimeFactors(number);
        if(primeFactors.size()>=3) luckyNumber = true;
        return luckyNumber;
    }

    // traverse all the numbers from 2 to n
    private static List<Integer> findPrimeFactors(Integer number){
        List<Integer> primeFactorsOfLuckyNumber = addPrimeFactors(number);
        return primeFactorsOfLuckyNumber;
    }

    // Find the factors of the specific numbers and add all the factors to an array
    private static List<Integer> addPrimeFactors(Integer number){
        List<Integer> primeFactors = new ArrayList<>();
        for (int i = 2; i <= number; i++) {
            if(number%i==0 && isPrime(i)){
                    primeFactors.add(i);
            }
        }
        return primeFactors;
    }


    // Find prime factors from that array
    private static boolean isPrime(Integer factor){
        boolean prime = true;
        for (int i = 2; i < factor; i++) {
            if(factor%i == 0){
                prime = false;
                break;
            }
        }
        return prime;
    }
}
