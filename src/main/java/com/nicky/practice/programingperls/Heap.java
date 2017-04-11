package com.nicky.practice.programingperls;

public class Heap {
    private static int max = 30;
    public static int[] x = new int[max + 1];

    /**
     * 容量为n的堆，插入第n个值，往上移动形成堆 其中[1..n-1]已经是堆
     * 
     * @param n
     */
    public void shiftUp(int n) {
        int i = n;
        while (true) {
            if (i == 1)
                break;
            int p = i / 2;
            if (x[p] <= x[i])
                break;
            swap(p, i);
            i = p;
        }
    }

    /**
     * 把第一个元素移下，使得形成堆。 [2..n]已经为堆
     * 
     * @param n
     */
    public void shiftDown(int n) {
        int i = 1;
        while (true) {
            int c = 2 * i;
            if (c > n) {
                break;
            }
            // 从下级中找到较小的进行比较
            if (c + 1 <= n) {
                if (x[c + 1] < x[c])
                    c++;
            }
            if (x[i] <= x[c]) {
                break;
            }
            // 确保最小的往堆上推送
            swap(c, i);
            i = c;
        }
    }

    /**
     * 堆排序 （不稳定） 时间复杂度O(nlogn)
     */
    public void heapSort() {
        // 建立堆。
        for (int i = 2; i < x.length; i++) {
            shiftUp(i);
        }
        // 每次从堆里把最小的放最后，然后重新对前面的值进行建堆。
        for (int i = x.length - 1; i >= 2; i--) {
            swap(1, i);
            shiftDown(i - 1);
        }
    }

    // 打印x
    public void print() {
        for (int xValue : x) {
            System.out.println(xValue);
        }
        System.out.println("============");
    }

    public void swap(int i, int j) {
        int temp;
        temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        // 浪费第一个元素， 从index=1开始使用起
        int[] x = { 0, 1, 6, 4, 9, 10, 28, 4 };
        Heap.x = x;
        heap.print();
        heap.heapSort();
        heap.print();

    }
}
