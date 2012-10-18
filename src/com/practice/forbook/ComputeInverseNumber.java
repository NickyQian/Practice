package com.practice.forbook;

// 计算逆序数  Inverse Number
public class ComputeInverseNumber {	
	// Direct Counting
	public int findInverseNumber(int[] inputArray){ // O(n^2)
		int count = 0;
		for(int i = 0; i< inputArray.length; i++) {
			for(int j = i; j < inputArray.length; j++){
				if(inputArray[i]>inputArray[j]){
					count++;
				}
			}
		}
		return count;
	}
	
	public int findInverseNumberQuickly(int[] inputArray, int begin, int end) {// 分治法(Divide and Conquer) 
		int count = 0;
		if(begin < end) { 
			int mid = (begin + end) / 2;
			count += findInverseNumberQuickly(inputArray, begin, mid);    // Divide
			count += findInverseNumberQuickly(inputArray, mid+1, end);    // Divide
			count += CountForOnePiece(inputArray, begin, end, mid);       // Conquer (Calculate)
		}
		return count;
	}
	
	public int CountForOnePiece(int[] inputArray, int begin, int end, int mid) {
		int count = 0;
		int n1 = mid - begin + 1;
		int n2 = end - mid;
		int[] left = new int[n1+1];
		int[] right = new int[n2+1];
		for(int m = 0; m < n1; m++) {
			left[m] = inputArray[begin+m];
		}
		for(int m = 0; m < n2; m++) {
			right[m] = inputArray[mid+1+m];
		}
		// Here is not perfect! 
		int MAX = Integer.MAX_VALUE;
		left[n1] = MAX;
		right[n2] = MAX;
		int  i=0;
		int  j=0;
		for(int k = begin; k <= end; k++ ){
			if(left[i] <= right[j]){ // stable
				inputArray[k] = left[i]; // sort!
				i++;
			} else {
				inputArray[k] = right[j];  // sort!					
				j++;
				count = n1 - i + count; // because two parts are in order. 
										// And the number in the left after i are all inversion.
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] inputArray = {2,3,4,4,1};
		ComputeInverseNumber inverseN = new ComputeInverseNumber();
		System.out.println(inverseN.findInverseNumber(inputArray));
		System.out.println(inverseN.findInverseNumberQuickly(inputArray,0,inputArray.length-1));
		// input array is in order now!
		for(int i : inputArray) {
			System.out.print( i +", ");
		}
	}
}
