package com.nicky.practice.tij.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringLengthWithChineseCharactor {
    @Test
    public void test() {
        String chineseCharactor = "中文长度";
        assertEquals(4, chineseCharactor.length());

        String chineseCharactorWithNumbers = "中文长度12";
        assertEquals(6, chineseCharactorWithNumbers.length());

        String englishCharactor = "English";
        assertEquals(7, englishCharactor.length());
    }
}
