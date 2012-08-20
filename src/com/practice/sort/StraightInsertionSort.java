package com.practice.sort;

/*
 * ֱ�Ӳ�������
 * �����ǰ�棺���򲿷� ���棺���򲿷�
 * �Ӵ��򲿷ֵĵ�һ�� �����򲿷��ҵ����ʵ�λ��
 * Ȼ���������������ƣ��ڳ�λ�ø��µ�����
 */
public class StraightInsertionSort {
	public int[] dataToSort = { 9, 2, 1, 3, 4, 5, 8, 5, 1, 17, 45, 18, 46, 89,
			82, 12, 3, 456, 18 };

	public void straightInsert() {
		for(int i = 1; i < dataToSort.length; i++){
			int temp = dataToSort[i];
			for(int j = 0; j < i; j++){
				if(dataToSort[j] > temp){
					for(int k = i; k > j; k--){
						dataToSort[k] = dataToSort[k-1];
					}
					dataToSort[j] = temp;
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		StraightInsertionSort sis = new StraightInsertionSort();
		sis.straightInsert();
		for(int result : sis.dataToSort){
			System.out.println(result);
		}
	}
}
