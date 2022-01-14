package com.humblebee.patterns.singleton;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		
		// ---------------------------------------------
//		MultiThreadingTest.test();	// Multithreading test
		// ---------------------------------------------
		
		
//		DateUtil dateUtil = new DateUtil();	// this will not work, as we have created PRIVATE constructor ;)
		
		DateUtil dateUtil1 = DateUtil.getInstance();

		DateUtil dateUtil2 = DateUtil.getInstance();
		
		System.out.println(dateUtil1 == dateUtil2);  // checking if the object is same (Only single object is created or not)


	}

}
