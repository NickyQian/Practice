package com.practice.thread;

public class Inc implements Runnable {
	
	private int data;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(data<=1000) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data++;
			System.out.println(Thread.currentThread().getName() + " "+ data );
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inc inc = new Inc();
		Thread t1 = new Thread(inc, "thread one");
		Thread t2 = new Thread(inc, "thread two");
		Thread t3 = new Thread(){public void run (){System.out.println("000");}};
		t1.start();
		t2.start();
		t3.start();
	}

}
