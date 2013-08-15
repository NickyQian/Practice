package com.practice.designpattern.state;
/**
 * 糖果机
 * @author Nicky
 *
 */
public class GumbalMachine {
    /* 糖果机拥有4种状态 */
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    /* 当前处于的状态 */
    State state = soldState;
    int count = 0;
    
    public GumbalMachine(int count) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.count = count;
        if (count > 0) { // 如果有货 就处于没有投入25美分状态
            this.state = noQuarterState;
        }
    }
    
    public void insertQuarter() {
        /* 
         * 动作委托给具体的state类了
         * 具体实现的方法有state的实现类决定
         */
        state.insertQuarter();
    }
    
    public void ejectQuarter() {
        state.ejectQuarter();
    }
    
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }
    public void setState(State state) {
        this.state = state;
    }
    
    public void realeasBall() {
        System.out.println("A gumBall comes rolling out the slot...");
        if (count != 0) {
            count--;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void setSoldOutState(State soldOutState) {
        this.soldOutState = soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public void setNoQuarterState(State noQuarterState) {
        this.noQuarterState = noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public void setHasQuarterState(State hasQuarterState) {
        this.hasQuarterState = hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public void setSoldState(State soldState) {
        this.soldState = soldState;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
}
