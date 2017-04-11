package com.nicky.practice.sort;

import java.text.DecimalFormat;


/*
 * ð�ݷ�
 *  �Ƚ��ٽ�2��  �Ѵ��ֵ����ð�� ���һ���������� 
 */
public class BubbleSort {
	public int[] dataToSort = {9,2,1,3,4,5,8,5,1,17,45,18,46,89,82,12,3,456,18};
	
	public void bubbleSort(){
		for(int i = dataToSort.length; i > 1; i--){       
			for(int j = 0; j < i-1; j++){                       // һ��ʼѭ���Ƚϵ����Ȼ�����ڶ� ������...
				if(dataToSort[j] > dataToSort[j+1]){
					int temp;
					temp = dataToSort[j];
					dataToSort[j] = dataToSort[j+1];
					dataToSort[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args){
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort();
		for(int result : bs.dataToSort){
			System.out.println(result);
		}
		double d = 12.34567890123;
		
		String formatValue = new  DecimalFormat("#.###").format(d);
		System.out.println(formatValue);
		System.out.println((float)d);
		
	}
}
