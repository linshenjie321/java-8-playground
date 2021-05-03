package com.sjl.learning.java8.defaultmethod;

public class Animal implements Cat, Dog {
	
	public void whatAmI() {
		//an example of how a class implementing multiple interface with same default method can be resolved
		//you may also define specific content yourself if you do not wish to refer to any interface default method
		Cat.super.whatAmI();
	}

}
