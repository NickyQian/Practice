package com.nicky.practice.thread;

public class BaseNumber {
	private int data = 0;
	public void inc() throws InterruptedException {
		Thread.sleep(2000);
		data++;
	}
	public void dec() throws InterruptedException {
		Thread.sleep(800);
		data--;
//		notifyAll();
	}
	
	public int getData(){
		return data;
	}
	
}
