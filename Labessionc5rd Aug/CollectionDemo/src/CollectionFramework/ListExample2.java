package CollectionFramework;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ListExample2 {

    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();

        // Adding elements (including duplicates)
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Apple");

        System.out.println("Original List: " + fruits);

        // Accessing element by index
        System.out.println("Element at index 1: " + fruits.get(1));

        // Replacing element at index 2
        fruits.set(2, "Blueberry");
        System.out.println("After set: " + fruits);

        // Remove first occurrence of "Apple"
        fruits.remove("Apple");
        System.out.println("After removing 'Apple': " + fruits);

        // Index of an element
        System.out.println("Index of Banana: " + fruits.indexOf("Banana"));

        // List size
        System.out.println("Size: " + fruits.size());

        // Get a sublist
        System.out.println("Sublist (0 to 2): " + fruits.subList(0, 2));

        // Clear the list
        fruits.clear();
        System.out.println("Empty List: " + fruits);

        // Check if list is empty
        System.out.println("Is empty? " + fruits.isEmpty());
    }
}
