package com.nicky.practice.generics;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

public class GenericsTest {
    @Test
    public void test() {
        List<String> strList = Lists.newArrayList("1","2","3");
        GenericsClass.swapHelper(strList, 1, 2);
    }
}
