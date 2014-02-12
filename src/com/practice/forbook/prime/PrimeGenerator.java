package com.practice.forbook.prime;

import java.util.ArrayList;

public class PrimeGenerator {
    private static int[] primes;
    private static ArrayList<Integer> multiplesOfPrimesFactors;
    
   protected static int[] generate(int n) {
       primes = new int[n];
       multiplesOfPrimesFactors = new ArrayList<Integer>();
       set2AsFirstPrime();
       checkOddNumbersForSubsequentPrimes();
       return primes;
   }
   
   private static void set2AsFirstPrime() {
       primes[0] = 2;
       multiplesOfPrimesFactors.add(2);
   }
   
   private static void checkOddNumbersForSubsequentPrimes() {
       int primeIndex = 1;
       for (int candidate = 3; primeIndex < primes.length; candidate += 2) {
           if (isPrime(candidate)) {
               primes[primeIndex++] = candidate;
           }
       }
   }
   
   private static boolean isPrime(int candidate) {
       if (isLeastRelevantMultipleOfNextLargerPrimeFactor(candidate)) {
           multiplesOfPrimesFactors.add(candidate);
           return false;
       }
       return isNotMultipleOfAnyPreviousPrimeFactor(candidate);
   }
   
   private static boolean isLeastRelevantMultipleOfNextLargerPrimeFactor(int candidate) {
       int nextLargerPrimeFactor = primes[multiplesOfPrimesFactors.size()];
       int leastRelevantMultiple = nextLargerPrimeFactor * nextLargerPrimeFactor;
       return candidate == leastRelevantMultiple;
   }
   
   private static boolean isNotMultipleOfAnyPreviousPrimeFactor(int candidate) {
       for (int n = 1; n < multiplesOfPrimesFactors.size(); n++) {
           if(isMultipleOfNthPrimeFactor(candidate, n)) {
               return false;
           }
       }
       return true;
   }
   
   private static boolean isMultipleOfNthPrimeFactor(int candidate, int n) {
       return 
         candidate == smallestOddNthMultipleNotLessThanCandidate(candidate, n);
   }
   
   private static int smallestOddNthMultipleNotLessThanCandidate(int candidate, int n) {
       int multiple = multiplesOfPrimesFactors.get(n);
       while (multiple < candidate) {
           multiple += 2 * primes[n];
       }
       multiplesOfPrimesFactors.set(n, multiple);
       return multiple;
   }
}













