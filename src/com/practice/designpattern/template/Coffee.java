package com.practice.designpattern.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coffee extends BaseCoffineDrink {

    /**
     * 咖啡 需要过滤
     */
    @Override
    public void brew() {
        System.out.println("Dripping coffee through filter.");
    }

    /**
     * 咖啡 加入的调料为糖和牛奶
     */
    @Override
    public void addCondiments() {
        // TODO Auto-generated method stub
        System.out.println("Adding Sugar and Milk.");
    }
    
    @Override
    public boolean wantsCondiments() {
        String answer = getUserInput();
        if (answer.toLowerCase().equals("y")){
            return true;
        }
        else {
            return false;
        }
    }
    
    public String getUserInput() {
        String answer = null;
        System.out.println("Would you like milk and sugar with your coffee (y/n)?");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            answer = in.readLine();
        } catch (IOException e) {
            System.out.println("IO error trying to read your anwser.");
        }
        if (answer == null) {
            return "n";
        }
        return answer;
    }
}
