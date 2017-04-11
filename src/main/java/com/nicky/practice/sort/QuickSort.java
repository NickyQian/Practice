package com.nicky.practice.sort;

import java.util.ArrayList;
import java.util.List;

/*
 * ��������
 * ÿ��ѡ���һ��Ԫ����Ϊ�Ƚ϶��� �������ࣨС��һ��ʹ��һ�ࣩ
 * ֱ��ĳһ��Ϊ�գ��򷵻ؽ��������ݹ���ô˷�����
 */
public class QuickSort {
	// public int[] dataToSort = { 1,2,3,4,5,6,7,8,9,10 };
	public int[] dataToSort = { 9, 2, 1, 3, 4, 5, 8, 5, 1, 17, 45, 18, 46, 89,
			82, 12, 3, 456, 18 };
	public List<Integer> data = new ArrayList<Integer>() { // �����ݱ��List
		private static final long serialVersionUID = 1L;
		{
			for (int i : dataToSort) {
				this.add(i);
			}
		}
	};

	public List<Integer> quickSort(List<Integer> data) {
		int first = data.get(0);
		List<Integer> left = new ArrayList<Integer>();
		List<Integer> right = new ArrayList<Integer>();

		// ����һ������
		for (int i = 1; i < data.size(); i++) {
			if (data.get(i) <= first) {
				left.add(data.get(i));
			} else {
				right.add(data.get(i));
			}
		}

		// �ж�һ�������Ľ��
		if (left.size() == 0 && right.size() != 0) { // �������� �ұ�û�����
			right = quickSort(right);
			right.add(0, first);
			return right;
		} else if (left.size() != 0 && right.size() == 0) { // �ұ������ ���û�����
			left = quickSort(left);
			left.add(first);
			return left;
		} else if (left.size() == 0 && right.size() == 0) { // ���Ҷ������
			left.add(first);
			return left;
		} else { // ���Ҷ�û�����
			left.add(first);
			left = quickSort(left);
			right = quickSort(right);
			for (int i : right) {
				left.add(i);
			}
			return left;
		}
	}

	public static void main(String[] args) {
		QuickSort cs = new QuickSort();
		List<Integer> result = cs.quickSort(cs.data);
		for (int i : result) {
			System.out.println(i);
		}
	}
}
