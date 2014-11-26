package com.xy.test.multithread;

import static java.lang.System.out;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestObjImplRunnable implements Runnable {

	
	@Override
	public void run() {
		for( int i=0 ; i < 30; i++){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.println(Thread.currentThread().getName() + "---" + i + "---" + df.format(new Date()));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Runnable r = new TestObjImplRunnable();
		 new Thread(r, "子线程0").start();
		 new Thread(r, "子线程1").start();
		 
	}

}
