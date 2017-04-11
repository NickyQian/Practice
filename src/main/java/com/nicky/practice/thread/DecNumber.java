package com.nicky.practice.thread;

public class DecNumber implements Runnable {
	private BaseNumber baseNumber;
	public DecNumber(BaseNumber number) {
		baseNumber = number;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			synchronized(baseNumber){  // must!
				if(baseNumber.getData()>0){
					try {
						baseNumber.dec();
						System.out.println(Thread.currentThread().getName()+"  "+baseNumber.getData());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				baseNumber.notifyAll();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		BaseNumber baseNumber = new BaseNumber();
		IncNumber inc = new IncNumber(baseNumber);
		DecNumber dec = new DecNumber(baseNumber);
		Thread t1 = new Thread(inc, "add number");
		Thread t2 = new Thread(dec,"consume~");
//		t1.setDaemon(true);
//		t2.setDaemon(true);
		t1.start();
		t2.start();
//		Thread.sleep(10000);
	}
}
