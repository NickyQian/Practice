package com.nicky.practice.thread;
/*
 * 后台线程 当主线程结束的时候，后台线程也会结束
 * 
 * 如果不设为后台线程 Daemon，则main结束后  其他线程还会继续执行。
 * 当主线程停止时，后台线程立刻停止，不会执行总是执行finally。
 * 不能以优雅的方式关闭后台线程。
 */
public class SimpleDaemons implements Runnable {
	public void run(){
		try{
			while(true){
				Thread.sleep(100);
				System.out.println(Thread.currentThread()+" "+this);
			}
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupt");
		} finally {
			System.out.println("This is always run?");			
		}
	}
	public static void main(String[] args) throws Exception {
		for(int i=0;i<10;i++){
			Thread deamon = new Thread(new SimpleDaemons());
			deamon.setDaemon(true); // must call before start()
			deamon.start();
		}
		System.out.println("all daemons started");
		Thread.sleep(200);
	}
}
