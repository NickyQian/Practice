package com.practice.computeprime;

/*
 *  ����100���ڵ�����������
 *  ˫��ѭ��  �ڶ�����ԭ����ƽ������ѭ����
 */
public class ComputePrime {
    public static boolean isPrime(int num) { 
        for(int i = 2; i <= Math.sqrt(num); i++) {			//����Ĭ��2����������j=2ʱ��ѭ����ִ�� ע��ƽ������
            if(num % i == 0) {								// ����ܱ����� �ǾͲ��������ˡ�
              return false;
            }
        }
        return true;
     }
     public static void main(String[] args) {
    	 int count = 0;
         for(int j = 2; j <= 100; j++) {
             if(ComputePrime.isPrime(j)) {
                 count++;
            	 System.out.println(j + " is a prime");
             }
         }
         System.out.println("Total : " + count);
     }
}
