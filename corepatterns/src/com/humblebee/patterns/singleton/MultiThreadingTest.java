package com.humblebee.patterns.singleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MultiThreadingTest {

	private static DateUtil dateUtil1;
	private static DateUtil dateUtil2;
	private static DateUtil dateUtil3;
	private static DateUtil dateUtil4;
	private static DateUtil dateUtil5;
	
	public static void test() throws InterruptedException {
	 
	   CountDownLatch countDownLatch = new CountDownLatch(1);
	   Runnable run1 = () -> { dateUtil1 = DateUtil.getInstance(); };
	   Runnable run2 = () -> { dateUtil2 = DateUtil.getInstance(); };
	   Runnable run3 = () -> { dateUtil3 = DateUtil.getInstance(); };
	   Runnable run4 = () -> { dateUtil4 = DateUtil.getInstance(); };
	   Runnable run5 = () -> { dateUtil5 = DateUtil.getInstance(); };
	   Thread thread1 = new Thread(run1);
	   Thread thread2 = new Thread (run2);
	   Thread thread3 = new Thread (run3);
	   Thread thread4 = new Thread (run4);
	   Thread thread5 = new Thread (run5);
	   thread1.start();
	   thread2.start();
	   thread3.start();
	   thread4.start();
	   thread5.start();
	   countDownLatch.await(2000, TimeUnit.MILLISECONDS);
	   
	  System.out.println(dateUtil1 == dateUtil2 && dateUtil2 == dateUtil3 && dateUtil3 == dateUtil4 && dateUtil4 == dateUtil5);
	 
	}
	
	
}
