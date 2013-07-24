package com.practice.subclassjudgment;

public class TestClass {
    
    public static void judgment(IBasicClass base) {
        if (base instanceof Asubclass) {
            System.out.println("This is A instance.");
        }
        if (base instanceof Bsubclass) {
            System.out.println("This is B instance.");
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        IBasicClass A =  new Asubclass();
        IBasicClass B =  new Bsubclass();
        judgment(A);
        judgment(B);
    }

}
