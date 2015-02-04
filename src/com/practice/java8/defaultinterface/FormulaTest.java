package com.practice.java8.defaultinterface;
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
        formula.calculate(100);     // 100.0
        formula.sqrt(16);           // 4.0
    }
}
