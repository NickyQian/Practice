package com.practice.thread;
/*
 * ��̨�߳� �����߳̽�����ʱ�򣬺�̨�߳�Ҳ�����
 * 
 * �������Ϊ��̨�߳� Daemon����main������  �����̻߳������ִ�С�
 * �����߳�ֹͣʱ����̨�߳�����ֹͣ������ִ������ִ��finally��
 * ���������ŵķ�ʽ�رպ�̨�̡߳�
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
