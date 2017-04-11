package com.nicky.practice.thread;

public class IncNumber implements Runnable {
	
	private BaseNumber baseNumber;
	public IncNumber(BaseNumber number) {
		baseNumber = number;
	}
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub

		while(true) {
			synchronized(baseNumber){
				try {
					Thread.sleep(1000);
					baseNumber.inc();
					System.out.println(Thread.currentThread().getName()+"  "+baseNumber.getData());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					baseNumber.notifyAll();
				}
			}
		}
	}

}
