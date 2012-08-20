package com.practice.computeprime;


/*
 * ɸѡ��
 * ��2��ʼ ȥ��2�ı���
 * ��ȥ�����һ��û��ȥ����������ɸѡ�����ı���ֱ������Ϊֹ��
 * ʣ�µ�����Ϊ������
 * 
 * ɸѡ �޳����������Ϊ0 ��������Ϊ0��ֵ��Ϊ������
 */
public class PrimeFilter {
	public static void main(String[] arg){
		int[] num = new int[101];
		for(int i = 1; i <= 100; i++){					//��ʼ������ ʹ���±꼴Ϊ���������0~100��101������
			num[i] = i;
		}
		num[1] = 0; 									// ��Ϊ 1����������
		for(int i = 2; i<100; i++){
			if(num[i] != 0){
				for(int j = i + 1; j<= 100; j++){
					if (num[j] != 0 && num[j] % i == 0){
						num[j] = 0;
					}
				}
			}
		}
		
		int count = 0;
		for(int prime : num){
			if(prime !=0){
				count++;
				System.out.println(prime + " is a prime");
			}
		}
		System.out.println("Total : " + count);
				
	}
}
