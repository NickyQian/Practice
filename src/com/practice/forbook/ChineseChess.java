package com.practice.forbook;

public class ChineseChess {
	public static void main(String[] args) {
		// 一共81种情况 每种情况判断一下
		// 把冲突的棋子位置数出来
		/*	棋子的位置：
		 *   	 1 2 3
		 *    	 4 5 6
		 *    	 7 8 9
		 */
		int i = 80;
		while(i>=0) {
			if((i/9)%3 == (i%9)%3){
				System.out.println("A = "+((i/9)+1)+"; B = "+((i%9)+1));
			}
			i--;
		}
	}
}
