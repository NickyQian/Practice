package com.nicky.practice;

import java.util.ArrayList;
import java.util.List;

public class ForeachClass {

    public static void foreachFun(List<String> testStr) {
        for (String item : testStr) {
            System.out.println(item + "OK");
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> testStr = new ArrayList<String>();
        // 如果testStr为null的话 在foreach循环中会出错！
        // 事先判断是否为null还是有必要的
        foreachFun(testStr);
        System.out.println("the end");
    }

}
