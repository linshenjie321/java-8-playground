package com.sjl.learning.java8.methodreference;
import java.util.Scanner;

public class MethodReferenceExample {
	
	public static void main(String[] args) {
		// Method referencing a static method
		MethodReferenceExampleInterface methodRef = MethodReferenceExample::greetings;
		Scanner userInput = new Scanner(System.in);
		System.out.println("who do you want to say greetings to?");
		String username = userInput.nextLine();
		methodRef.greeting(username);
		userInput.close();
		
		// Method referencing an instance method
		MethodReferenceExample methodRefInstance = new MethodReferenceExample();
		MethodReferenceExampleInterface saySomethingInstance = methodRefInstance::greetingsNonStatic;
		saySomethingInstance.greeting("Sammy");
		
		// when we use the method reference to create an instance object, the left hand side need to be a functional interface, 
		// and you should have a constructor in the class that matches the functional interface method signature
		MethodReferenceExampleInterface methodRefInstace2 = MethodReferenceExample::new;
		methodRefInstace2.greeting("Jon");
	}
	
	public MethodReferenceExample() {
		System.out.println("Constructing an instance of MethodReferenceExample...");
	}
	
	public MethodReferenceExample(String name) {
		System.out.println("Constructing an instance of MethodReferenceExample for " + name + "...");
	}
	
	public static void greetings(String name) {
		System.out.println("Hello, " + name + " how are you? -- from static method");
	}
	
	
	public void greetingsNonStatic(String name) {
		System.out.println("Hello, " + name + " how are you? -- from instance method");
	}
	
}
