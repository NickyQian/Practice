package com.practice.programingperls;
/**
 * 优先级队列
 * @author qianlei
 *
 */
public class Priqueue {
    /**
     * 当前队列的个数
     */
    private int n;
    /**
     * 队列的最大容量
     */
    private int maxSize;
    private int[] x;
    public Priqueue(int m) {
        this.maxSize = m;
        x = new int[maxSize+1];
        n = 0;
    }
    
    public void insert(int t) throws Exception {
        if ( n >= maxSize) {
            System.out.println("error!");
            throw new Exception("stack overfow!");
        }
        x[++n] = t;
        shiftUp(n);
    }
    
    public int extractMin() throws Exception{
        if ( n <= 0) {
            throw new Exception("Empty queue!");
        }
        int result = x[1];
        x[1] = x[n--];
        shiftDown(n);
        return result;
    }
    /**
     * 容量为n的堆，插入第n个值，往上移动形成堆
     * 其中[1..n-1]已经是堆
     * @param n
     */
    public void shiftUp(int n) {
        int i = n;
        while (true) {
            if (i == 1)
                break;
            int p = i/2;
            if (x[p] <= x[i])
                break;
            swap(p,i);
            i = p;
        }
    }

    /**
     * 把第一个元素移下，使得形成堆。
     * [2..n]已经为堆
     * @param n
     */
    public void shiftDown(int n) {
        int i = 1;
        while (true) {
            int c = 2*i;
            if (c > n) {
                break;
            }
            // 从下级中找到较小的进行比较
            if (c+1 <= n){
                if (x[c+1] < x[c])
                    c++;
            }
            if (x[i] <= x[c]) {
                break;
            }
            // 确保最小的往堆上推送
            swap(c,i);
            i = c;
        }
    }

    public void swap(int i, int j) {
        int temp;
        temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static void main(String[] args) throws Exception{
        Priqueue p = new Priqueue(5);
        p.insert(100);
        p.insert(4);
        p.insert(6);
        p.insert(1);
        System.out.println(p.extractMin());
        System.out.println(p.extractMin());
        System.out.println(p.extractMin());
        System.out.println(p.extractMin());
    }
}
