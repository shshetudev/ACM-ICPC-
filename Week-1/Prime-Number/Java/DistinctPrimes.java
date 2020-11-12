package Java;

import java.util.ArrayList;
import java.util.List;

public class DistinctPrimes {
    public static void main(String[] args) {
        Integer number = 30;
       System.out.println(isLucky(number));
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
        System.out.println(primeFactorsOfLuckyNumber);
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
