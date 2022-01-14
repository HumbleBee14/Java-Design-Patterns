package com.humblebee.patterns.singleton;

/**
 * Singleton Design Pattern
 *
 * Steps: 
 * 
 * 1. Declare the constructor of the class as private
 * 2. Declare a static method
 * 3. Declare a static member of the same class type in the class
 */

public class DateUtil {

	private static volatile DateUtil instance;

	
	private DateUtil() { }
	
	public static DateUtil getInstance() { 	// Lazy initialization

		if(instance == null) {
			synchronized(DateUtil.class)
			{
				if(instance == null) {
					instance = new DateUtil();
					System.out.println("A new instance just created!");
				}
			}
		}

		
		return instance;
	}
	
	
}



// With lazy initialization you create instance only when its needed and not when the class is loaded. So you escape the unnecessary object creation. That being said there are other things to consider too. In lazy initialization you give a public API to get the instance.

/*
Lazy initialization is technique were we restrict the object creation until its created by application code. This saves the memory from redundant objects which some time may be very big/heavy.
In other way, Eager initialization creates the object in advance and just after starting the application or module. This is helpful in case the object is mandatory and in all the cases functional. 
This way application provides the ready to use object and saves execution time at time of actual request.
 */


// Method 1 
/*

	private static DateUtil instance;

	private DateUtil() {
		// to prevent new object creation by "new DateUitl()"
	}
	
	public static DateUtil getInstance() { 	// Lazy initialization
			if(instance == null) {
				instance = new DateUtil();			
			}
		return instance;
	}

 */


// Method 2
/*
  --> Eager Initialization (object initialized right)


	private static DateUtil instance = new DateUtil();  // eager initialization
	
	private DateUtil() { }
	
	public static DateUtil getInstance() {
		return instance;
	}

*/

// Method 3
/*
	--> Using static blocks (static blocks are executed when class is loaded into memory) => eager initialization

	private static DateUtil instance;
	
	static {
		instance = new DateUtil();
	}
	
	private DateUtil() { }
	
	public static DateUtil getInstance() {
		return instance;
	}


*/