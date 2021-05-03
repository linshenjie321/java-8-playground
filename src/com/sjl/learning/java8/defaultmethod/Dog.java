package com.sjl.learning.java8.defaultmethod;

public interface Dog {
	
	default void whatAmI() {
		System.out.println("I am a dog");
	}

}
