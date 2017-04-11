package com.nicky.practice.computeprime;

/*
 * 筛选法
 * 从2开始 去除2的倍数
 * 再去后面第一个没被去除的数，再筛选此数的倍数直到结束为止。
 * 剩下的数则为素数。
 * 
 * 筛选 剔除的数都标记为0 最后输出不为0的值即为素数。
 */
public class PrimeFilter {
    public static void main(String[] arg) {
        int[] num = new int[101];
        for (int i = 1; i <= 100; i++) { // 初始化数组 使得下标即为所存的数。0~100共101个数。
            num[i] = i;
        }
        num[1] = 0; // 认为 1不是素数。
        for (int i = 2; i < 100; i++) {
            if (num[i] != 0) {
                for (int j = i + 1; j <= 100; j++) {
                    if (num[j] != 0 && num[j] % i == 0) {
                        num[j] = 0;
                    }
                }
            }
        }

        int count = 0;
        for (int prime : num) {
            if (prime != 0) {
                count++;
                System.out.println(prime + " is a prime");
            }
        }
        System.out.println("Total : " + count);

    }
}
