package com.practice.programingperls;

/**
 * 快速排序
 * 
 * @author qianlei
 * 
 */
public class QuickSort {
    private Integer[] matrix = { 1534, 567, 223, 67, 3534, 6, 9, 654732, 1, 4 };

    public void runQuickSort() {
        quickSort(0, matrix.length - 1);
    }

    public void quickSort(Integer firstIndex, Integer lastIndex) {
        if (firstIndex >= lastIndex) {
            return;
        }
        Integer m = firstIndex;
        for (int i = firstIndex + 1; i <= lastIndex; i++) {
            if (matrix[i] < matrix[firstIndex])
                swap(++m, i); // 把小的往左边压，右边都是大的
        }
        swap(firstIndex, m); // 压完值后把第一个轴跟最右边的小的值互换
        /* 递归计算时，中轴m那个值就不要算了 */
        quickSort(firstIndex, m - 1);
        quickSort(m + 1, lastIndex);
    }

    public void swap(Integer i, Integer j) {
        Integer temp = matrix[i];
        matrix[i] = matrix[j];
        matrix[j] = temp;
    }

    public void print() {
        for (Integer i : matrix) {
            System.out.println(i);
        }
        System.out.println("===================");
    }

    public Integer[] getMatrix() {
        return matrix;
    }

    public void setMatrix(Integer[] matrix) {
        this.matrix = matrix;
    }

    public static void main(String[] args) {
        QuickSort testDriver = new QuickSort();
        testDriver.runQuickSort();
        testDriver.print();

        testDriver.setMatrix(new Integer[] { 1, 23, 45, 7987896, 777, 1883,
                62371, 9, 10, 8, 7, 7 });
        testDriver.runQuickSort();
        testDriver.print();
    }
}
