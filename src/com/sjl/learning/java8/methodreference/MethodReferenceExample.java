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
	}
	
	public MethodReferenceExample() {
		System.out.println("Constructing an instance of MethodReferenceExample...");
	}
	
	public static void greetings(String name) {
		System.out.println("Hello, " + name + " how are you? -- from static method");
	}
	
	
	public void greetingsNonStatic(String name) {
		System.out.println("Hello, " + name + " how are you? -- from instance method");
	}
	
}
