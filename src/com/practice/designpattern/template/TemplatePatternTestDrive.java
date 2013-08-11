package com.practice.designpattern.template;
/**
 * 模板模式：
 * 在一个方法中定义一个算法的骨架，
 * 而将一些步骤延迟到子类中。模板方法使得
 * 子类可以在不改变算法结构的情况下，重新
 * 定义算法中的某些步骤。
 * @author qianlei
 *
 */
public class TemplatePatternTestDrive {

    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.prepareRecipe();
        
        for(int i = 0; i<50; i++){
            System.out.print("=");
        }
        System.out.println();
        
        Coffee coffee =  new Coffee();
        coffee.prepareRecipe(); // 咖啡需要询问要不要加调料
    }

}
