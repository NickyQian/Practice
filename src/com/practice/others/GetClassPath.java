package com.practice.others;

import java.io.File;
import java.io.IOException;

public class GetClassPath {
    public static void main(String[] args) throws IOException {

        /* 得到的是当前类FileTest.class文件的URI目录。不包括自己！ */
        System.out.println("1. getResource(\"\"): "
                + GetClassPath.class.getResource("").getPath()
                + GetClassPath.class.getSimpleName());
        /* 得到的是当前的classpath的绝对URI路径。 */
        System.out.println("2. getResource(\"/\"): "
                + GetClassPath.class.getResource("/").getPath());
        System.out.println("3. getClassLoader().getResource(\"\"): "
                + GetClassPath.class.getClassLoader().getResource(""));

        File directory = new File("./src");
        System.out.println(directory.getCanonicalPath());// 获取标准的路径
        System.out.println(directory.getAbsolutePath());// 获取绝对路径
        System.out.println(GetClassPath.class.getClass().getResource("/")
                .getPath());// 获取绝对路径
    }
}
