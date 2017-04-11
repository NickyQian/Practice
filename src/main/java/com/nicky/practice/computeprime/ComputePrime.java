package com.nicky.practice.computeprime;

/*
 * 计算100以内的所有素数。
 *  双重循环  第二次以原数的平方根来循环。
 */
public class ComputePrime {
    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) { // 程序默认2是素数，当j=2时，循环不执行
            // 注意平方根。
            if (num % i == 0) { // 如果能被整除 那就不是素数了。
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int count = 0;
        for (int j = 2; j <= 100; j++) {
            if (ComputePrime.isPrime(j)) {
                count++;
                System.out.println(j + " is a prime");
            }
        }
        System.out.println("Total : " + count);
    }
}
