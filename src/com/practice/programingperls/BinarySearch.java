package com.practice.programingperls;
/**
 * 二分查找
 * @author qianlei
 *
 */
public class BinarySearch {
    /**
     * 
     * @param source 所要查询的数据源 （必须从小到大有序）
     * @param target 所要查询的数据
     * @param first 查询的起点
     * @param last 查询的终点
     * @return
     */
    public boolean binarySearch(Integer[] source, Integer target,
            Integer first, Integer last) {
        if (first > last) {
            return false;
        }
        // 中点
        Integer m = (first + last) / 2;
        if (target.intValue() == source[m].intValue()) {
            return true;
        } else if (target.intValue() < source[m].intValue()) {
            return binarySearch(source, target, first, m-1);
        } else {
            return binarySearch(source, target, m+1, last);
        }
    }

    public static void main(String[] args) {
        Integer[] source1 = new Integer[]{1,5,8,9,13,17,24,36,78};
        Integer[] source2 = new Integer[]{20,24,28,38,39,45,46,61,68};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(source1, 5, 0, source1.length-1)); // return true
        System.out.println(binarySearch.binarySearch(source1, 4, 0, source1.length-1)); // return false
        System.out.println(binarySearch.binarySearch(source2, 20, 0, source1.length-1));// return true
        System.out.println(binarySearch.binarySearch(source2, 68, 0, source1.length-1));// return true
    }

}
