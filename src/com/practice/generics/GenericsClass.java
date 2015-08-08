package com.practice.generics;

import java.util.List;

public class GenericsClass {
    public static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i)));
    }

    public static void swap(List<?> list, int i, int j) {
        swapHelper(list, i, j);
    }
}
