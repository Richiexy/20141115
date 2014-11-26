package com.xy.test.multithread;

import static java.lang.System.out;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestObjExtendsThread extends Thread{

	TestObjExtendsThread(String threadName){
		super(threadName);
	}
	public void run(){
		for(int i=0;i<10;i++){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(Thread.currentThread().getState() + "--" +Thread.currentThread().getName() + "---" + i + "---" + df.format(new Date()));
		}
	}
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		new TestObjExtendsThread("线程1").start();
		new TestObjExtendsThread("线程2").start();
	}

}
