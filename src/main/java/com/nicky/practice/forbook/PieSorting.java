package com.nicky.practice.forbook;

public class PieSorting {

	public int[] pie = {1,2,3,4,5,6,7,3,4,89};
	
	// num <= pie.length
	/*
	 * inverse pie.
	 */
	public void inverse(int[] pie, int num){
		int temp;
		
		for(int i = 0; i< num/2; i++){
			temp = pie[num-1-i];
			pie[num-1-i] = pie[i];
			pie[i] = temp;
		}
	}
	
	/*
	 * the input int array is from small to large then return true.
	 *  else return false
	 */
	public boolean isSorted(int[] pie){
		for(int i = 0; i < pie.length-1; i++){
			if(pie[i] > pie[i+1]){
				return false;
			}
		}
		return true;
	}
	
	public void inverseAll(int[] pie){
		while(isSorted(pie)){
			
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PieSorting ps = new PieSorting();
		System.out.println(ps.isSorted(ps.pie));
		ps.inverse(ps.pie, ps.pie.length);
		for(int s : ps.pie) {
		 System.out.println(s);
		}
	}

}
