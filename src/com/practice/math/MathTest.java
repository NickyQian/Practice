package com.practice.math;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Test;

public class MathTest {

    public static double[][] multiply(double[][] a, double[][] b){
        RealMatrix n1 = new Array2DRowRealMatrix(a);
        RealMatrix  n2 = new Array2DRowRealMatrix(b);
        RealMatrix p = n1.multiply(n2);
        return p.getData();
    }
    @Test
    public void test() {
        double[][] a = {{1,1,1}};
        double[][] b = {{1},{1},{1}};
        double[][] result = multiply(a,b);
        System.out.println(result);
    }
}
