package com.practice.sort;

/*
 * ��ѡ�������㷨
 * ÿ�δ����������ѡһ����С��
 * ����������еĵ�һ������λ��
 * ��������Ϊ��С����
 */
public class SimpleSelectionSort {
	public int[] dataToSort = { 9, 2, 1, 3, 4, 5, 8, 5, 1, 17, 45, 18, 46, 89,
			82, 12, 3, 456, 18 };
	public void selectionSort(){
		
		for(int i = 0; i<dataToSort.length-1; i++){
			int min = dataToSort[i];  //Ĭ�ϵ�һ��ֵΪ��С��
			int index = i;
			for(int j = i+1; j<dataToSort.length; j++){
					if(min > dataToSort[j]){
						min = dataToSort[j];   // �Ƚ� ���� ��֤minΪ��С
						index = j;
					}
					int temp = dataToSort[i];
					dataToSort[i] = dataToSort[index];
					dataToSort[index] = temp;
			}
		}
	}
	
	public static void main(String[] args){
		SimpleSelectionSort ss = new SimpleSelectionSort();
		ss.selectionSort();
		for(int result : ss.dataToSort){
			System.out.println(result);
		}
	}
}
