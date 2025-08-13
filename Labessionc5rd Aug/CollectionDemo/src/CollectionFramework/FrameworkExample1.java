package CollectionFramework;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

	public class FrameworkExample1 {

	    public static void main(String[] args) {

	        // Step 1 - Create an object of ArrayList
	        List<String> names = new ArrayList<>();

	        // Step 2 - Add elements to the list
	        names.add("Steven");
	        names.add("Bob");
	        names.add("Alex");
	        names.add("Alex");
	        names.add("Turner");
	        names.add("Martin");
	        names.add("Fox");
	        names.add("Jack");
	        names.add("Lily");

	        // Optional: names.add(null); // Uncomment to test null (avoid if sorting)

	        // Display before sorting
	        System.out.println("Before sorting: " + names);

	        // Step 3 - Sort the list
	        Collections.sort(names);

	        // Display after sorting
	        System.out.println("After sorting: " + names);
	    
}}
