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
	}
	
	public static void greetings(String name) {
		System.out.println("Hello, " + name + " how are you?");
	}
	
}
