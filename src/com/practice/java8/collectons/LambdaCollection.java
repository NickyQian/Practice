package com.practice.java8.collectons;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class LambdaCollection {
    private static final int ARRAY_SIZE = 10;
    private char CHAR_A = 'A';
    @Test
    public void testCollectionNewFeature() {
        List<String> names = new ArrayList<>();
        Random ran = new Random();  
        for(int i = 0; i < ARRAY_SIZE; i++) {
            int firstCharactor = ran.nextInt(26);
            int secondCharactor = ran.nextInt(26);
            String first = String.valueOf((char)(CHAR_A + firstCharactor));
            String second = String.valueOf((char)(CHAR_A + secondCharactor));
            names.add(first+second);
        }
        names.forEach((s)->System.out.println(s));
    }
}
