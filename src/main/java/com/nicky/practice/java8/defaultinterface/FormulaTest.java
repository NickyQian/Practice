package com.nicky.practice.java8.defaultinterface;
import org.junit.Assert;
import org.junit.Test;

public class FormulaTest {
    @Test
    public void testDefaultInterface(){
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };
        Assert.assertEquals("100.0",String.valueOf(formula.calculate(100)));
        Assert.assertEquals("4.0", String.valueOf(formula.sqrt(16)));
    }
}
