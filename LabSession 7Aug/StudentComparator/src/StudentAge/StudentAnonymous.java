package StudentAge;


	import java.util.ArrayList;
	import java.util.Collections;
	import java.util.Comparator;
	import java.util.List;

	public class StudentAnonymous {

	    public static void main(String[] args) {
	        List<Student> list = new ArrayList<>();

	        list.add(new Student( "Garry", 21));
	        list.add(new Student("Binny", 26));
	        list.add(new Student("Fenny", 22));

	        System.out.println("Before Sorting (By Age):");
	        for (Student s : list) {
	            System.out.println(s);
	        }

	        // --- 1. Using Anonymous Class ---
	        Collections.sort(list, new Comparator<Student>() {
	            @Override
	            public int compare(Student s1, Student s2) {
	                return Integer.compare(s1.getAge(), s2.getAge());
	            }
	        });

	        System.out.println("\nAfter Sorting (Using Anonymous Class - By Age):");
	        for (Student s : list) {
	            System.out.println(s);
	        }

	        // --- 2. Using Lambda Expression ---
	        list.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));

	        System.out.println("\nAfter Sorting (Using Lambda - By Name):");
	        list.forEach(System.out::println);
	    }
	}