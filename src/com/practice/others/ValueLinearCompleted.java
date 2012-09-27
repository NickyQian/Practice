package com.practice.others;

import java.util.ArrayList;
import java.util.List;

/*
 * change the 0 value in the middle of the
 * double array to the value which is 
 * linear to the value 
 * on the left and right sides.
 */
public class ValueLinearCompleted {
	
	public int findFirstNoneZeroIndex(double[] data) {
		int i = 0;
		for(; i<data.length; i++){
			if(data[i] != 0){
				break;
			}
		}
		return i;
	}
	
	public int findLastNoneZeroIndex(double[] data) {
		int j = data.length - 1;
		for(; j >= 0; j--){
			if(data[j]!= 0){
				break;
			}
		}
		return j;
	}

	public List<int[]> findMiddleZeroIndex(double[] data) {
		int FirstIndex = findFirstNoneZeroIndex(data);
		int LastIndex = findLastNoneZeroIndex(data);
		List<int[]> resultIndex = new ArrayList<int[]>();
		for(int i = FirstIndex; i < LastIndex; i++){
			int[] value = new int[2];
			if(data[i] == 0){
				value[0] = i-1;
				a:for(int j = i; j<= LastIndex; j++){
					if(data[j]!=0){
						i = j;
						value[1] = j;
						resultIndex.add(value);
						break a;
					}
				}
			}
		}
		return resultIndex;
	}
	
	public void linearComplete(double[] data) {
		List<int[]> middleZeroIndex = findMiddleZeroIndex(data);
		if(middleZeroIndex.size()!=0){
			for(int[] middleZero : middleZeroIndex){
				int step = middleZero[1] - middleZero[0];
				double diff = data[middleZero[1]] - data[middleZero[0]];
				for(int i = 1; i<= step; i++){
					data[middleZero[0]+i] = (diff/step)*i + data[middleZero[0]];
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		double[] data = {0,0,1,0,0,4,0,0,7,13,0,0,0,9,0,0};
		ValueLinearCompleted vlc = new ValueLinearCompleted();
		vlc.linearComplete(data);
		for(double value : data) {
			System.out.print(value + " ");
		}
	}
}
