package com.practice.forbook;

public class ChineseChess {
	public static void main(String[] args) {
		// һ��81����� ÿ������ж�һ��
		// �ѳ�ͻ������λ��������
		/*	���ӵ�λ�ã�
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
