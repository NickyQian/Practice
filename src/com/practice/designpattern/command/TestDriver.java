package com.practice.designpattern.command;

import com.practice.designpattern.command.homeapplications.DVDPlayer;
import com.practice.designpattern.command.homeapplications.Light;
/**
 * 命令模式
 * 将“请求”封装成对象，以便使用不同的请求、
 * 队列或者日志来参数化其他对象。命令模式也
 * 支持可撤销的操作。
 *
 */
public class TestDriver {
    public static void main(String[] args) {
        RemoteController controller = new RemoteController();
        controller.PressOnButton(0);
        
        /* 黄金分割线 */
        for (int i = 0; i<60;i++) {
            System.out.print("=");
        }
        System.out.println();
        /* 定义家电 ：灯 */
        Light light = new Light("Nice Light in Dinning Room.");
        /* 包装灯的命令 */
        LightOnCommand lightOnCommand = new LightOnCommand(light);
        LightOffCommand lightOffCommand = new LightOffCommand(light);
        /* 设置遥控器的指令槽 */
        controller.setCommand(0, lightOnCommand, lightOffCommand);
        controller.PressOnButton(0);
        controller.PressOffButton(0);
        
        /* 黄金分割线 */
        for (int i = 0; i<60;i++) {
            System.out.print("=");
        }
        System.out.println();
        
        DVDPlayer dvdplayer = new DVDPlayer("SAMSUNG DVD PLAYER");
        DVDOnCommand dvdOnCommand =  new DVDOnCommand(dvdplayer);
        DVDOffCommand dvdOffCommand =  new DVDOffCommand(dvdplayer);
        controller.setCommand(1, dvdOnCommand, dvdOffCommand);
        controller.PressOnButton(0);
        controller.PressOffButton(0);
        controller.PressOnButton(1);
        controller.PressOffButton(1);
        /* 黄金分割线 */
        for (int i = 0; i<60;i++) {
            System.out.print("=");
        }
        System.out.println();
        
        /* 撤销操作 */
        controller.PressUndoButton();
    }
}
