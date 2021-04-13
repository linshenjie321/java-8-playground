import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		streamAPITrials();

	}

	private static void streamAPITrials() {

		// creation of Stream using a literal array
		Stream<String> streamOfStringFromLiteralArray = Stream.of("a", "b", "c", "d", "e", "f", "g");
		// creation of Stream from a declared array
		String[] arrOfString = new String[] { "a", "b", "c", "d", "e", "f", "g", "g"};
		Stream<String> streamOfStringFromDeclaredArray = Arrays.stream(arrOfString);
		// creation of Stream from collection
		List<String> listOfString = Arrays.asList(arrOfString);
		Stream<String> streamOfStringFromCollection = listOfString.stream();
		
		//Multi-threading with streams, where as printing order is not guaranteed
		System.out.println("below is printed from parallel stream");
		listOfString.parallelStream().forEach(a -> System.out.println(a));
		
		//getting count from stream
		System.out.println("regular count: " + streamOfStringFromCollection.count());
		//Stream is single use, here we can see that we'll get exception for IllegalStateException with "stream has already been operated upon or closed"
		try {
			System.out.println("distinct then count: " + streamOfStringFromCollection.distinct().count());
		} catch (IllegalStateException ex) {
			System.out.println("we caught IllegalStateException from the already used stream");
		}
		//to use the stream again, we can create the stream again using the list, this time we'll distinct it
		System.out.println("distinct then count from the recreated stream: " + listOfString.stream().distinct().count());
		
		
		//stream can be used to loop
		System.out.println("below is printed from stream for each");
		listOfString.stream().forEach(e -> System.out.println(e));
		boolean foundLetterA = listOfString.stream().anyMatch(e -> e.contains("a"));
		System.out.println("found letter a: " + foundLetterA);
		
		System.out.println("filtering the stream and creates a new stream, this case we are filtering g");
		Stream<String> filteredStream = listOfString.stream().filter(e -> e.contains("g"));
		filteredStream.parallel().forEach(e -> System.out.println(e));
		
		//converting Stream<String> to Stream<Path> using map from stream
		List<String> uris = new ArrayList<>();
		uris.add("C:\\My.txt");
		Stream<Path> stream = uris.stream().map(uri -> Paths.get(uri));
		stream.forEach(e -> System.out.println(e));
		
		//below two demonstrating the difference between map and flatMap
		Optional.of("string").map(s -> Optional.of("String"));
		Optional.of("string").flatMap(s -> Optional.of("STRING"));
		
		List<List<String>> listOfListString = Arrays.asList(
				Arrays.asList("a","b","c"),
				Arrays.asList("e","f","g")
				);
		
		//see below flat map helps us convert the multi structured list of list of string into a list of string
		//we also demonstrated here the collectors
		List<String> flatListString = listOfListString.stream().flatMap(Collection::stream).collect(Collectors.toList());
		System.out.println(flatListString);
		
		//reduction examples
		List<Integer> listOfIntegers = Arrays.asList(1,2,3);
		Integer reduced = listOfIntegers.stream().reduce(30, (a, b) -> a + b);
		System.out.println(reduced);
	}

}
