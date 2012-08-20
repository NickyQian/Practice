package com.practice.sort;

import java.util.ArrayList;
import java.util.List;

/*
 * 快速排序法
 * 每次选择第一个元素作为比较对象 并分两类（小的一类和大的一类）
 * 直到某一类为空，则返回结果。否则递归调用此方法。
 */
public class QuickSort {
	// public int[] dataToSort = { 1,2,3,4,5,6,7,8,9,10 };
	public int[] dataToSort = { 9, 2, 1, 3, 4, 5, 8, 5, 1, 17, 45, 18, 46, 89,
			82, 12, 3, 456, 18 };
	public List<Integer> data = new ArrayList<Integer>() { // 把数据变成List
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

		// 进行一次排序
		for (int i = 1; i < data.size(); i++) {
			if (data.get(i) <= first) {
				left.add(data.get(i));
			} else {
				right.add(data.get(i));
			}
		}

		// 判断一次排序后的结果
		if (left.size() == 0 && right.size() != 0) { // 左边排序好 右边没排序好
			right = quickSort(right);
			right.add(0, first);
			return right;
		} else if (left.size() != 0 && right.size() == 0) { // 右边排序好 左边没排序好
			left = quickSort(left);
			left.add(first);
			return left;
		} else if (left.size() == 0 && right.size() == 0) { // 左右都排序好
			left.add(first);
			return left;
		} else { // 左右都没排序好
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
