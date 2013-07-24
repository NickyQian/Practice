package com.practice.sort;

/*
 * 简单选择排序算法
 * 每次从无序队列中选一个最小的
 * 于无序队列中的第一个交换位置
 * 最终排序为从小到大。
 */
public class SimpleSelectionSort {
	public int[] dataToSort = { 9, 2, 1, 3, 4, 5, 8, 5, 1, 17, 45, 18, 46, 89,
			82, 12, 3, 456, 18 };
	public void selectionSort(){
		
		for(int i = 0; i<dataToSort.length-1; i++){
			int min = dataToSort[i];//默认第一个值为最小的
			int index = i;
			for(int j = i+1; j<dataToSort.length; j++){
					if(min > dataToSort[j]){
						min = dataToSort[j];    // 比较 交换 保证min为最小
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
