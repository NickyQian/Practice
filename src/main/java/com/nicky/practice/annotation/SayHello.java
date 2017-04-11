package com.nicky.practice.annotation;

import java.lang.reflect.Method;

import com.nicky.practice.annotation.Yts.YtsType;

@Yts(classType = YtsType.util)
public class SayHello {
    @HelloWorld(name = "Nick")
    @Yts
    public void sayHelloFnc(String name){
        if(name == null || name.equals("")) {
            System.out.println("hello world!");
        } else {
            System.out.println(name + "say hello world!");
        }
    }
    public static void main(String[] args) {
        // 解析注解
        Method[] methods = SayHello.class.getDeclaredMethods();
        for (Method method : methods) {
            /* 
             * 判断方法中是否有指定注解类型的注解 
             */
            boolean hasAnnotation = method.isAnnotationPresent(HelloWorld.class);
            if (hasAnnotation) {
                /* 
                 * 根据注解类型返回方法的指定类型注解 
                 */
                HelloWorld annotation = method.getAnnotation(HelloWorld.class);
                System.out.println("method = " + method.getName()
                        + " , name = " + annotation.name() );
            }
        }
    }
}
