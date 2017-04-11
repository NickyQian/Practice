package com.nicky.practice.designpattern.command;
/**
 * 遥控器类
 * 可以控制两种电器
 * 有2组按钮 每组有一个开,一个关
 * @author qianlei
 *
 */
public class RemoteController {
    private Command[] onSlots;
    private Command[] offSlots;
    /* 撤销功能 */
    private Command undoCommand;
    private Command noCommand;
    /**
     * 初始化遥控器的命令槽
     * 一开始的指令为空
     */
    public RemoteController() {
        onSlots = new Command[2];
        offSlots = new Command[2];
        noCommand = new NoCommand();
        for (int i = 0; i < 2; i++) {
            onSlots[i] = noCommand;
            offSlots[i] = noCommand;
        }
        undoCommand = noCommand;
    }
    
    public void setCommand(int slotIndex, Command onCommand, Command offCommand) {
        onSlots[slotIndex] = onCommand;
        offSlots[slotIndex] = offCommand;
    }
    
    public void PressOnButton(int index) {
        onSlots[index].execute();
        undoCommand = onSlots[index];
    }
    
    public void PressOffButton(int index) {
        offSlots[index].execute();
        undoCommand = offSlots[index];
    }
    
    /**
     * 撤销功能
     */
    public void PressUndoButton() {
        undoCommand.undo();
    }
}
