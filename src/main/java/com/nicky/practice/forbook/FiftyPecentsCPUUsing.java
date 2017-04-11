package com.nicky.practice.forbook;
// not exactly
public class FiftyPecentsCPUUsing {
	public static void main(String[] args) {
		int busyTime = 10;
		int idleTime = busyTime;
		long startTime = 0;
		while (true) {
			startTime = System.currentTimeMillis();
			while(System.currentTimeMillis()-startTime <= busyTime);
			try {
				Thread.sleep(idleTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
