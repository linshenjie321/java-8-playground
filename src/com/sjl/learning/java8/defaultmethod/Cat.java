package com.sjl.learning.java8.defaultmethod;

public interface Cat {
	
	default void whatAmI() {
		System.out.println("I am a cat");
	}
	
}
