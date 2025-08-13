package HashSet;

	import java.util.HashSet;
	import java.util.Objects;

	class Person {
	    private String name;
	    private int age;

	    Person(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    // Override hashCode() and equals()
	    @Override
	    public int hashCode() {
	        return Objects.hash(name, age); // Combines both fields
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (!(obj instanceof Person)) return false;
	        Person p = (Person) obj;
	        return age == p.age && Objects.equals(name, p.name);
	    }

	    @Override
	    public String toString() {
	        return name + " (" + age + ")";
	    }
	}

	public class HashCodeDemo {
	    public static void main(String[] args) {
	        HashSet<Person> people = new HashSet<>();

	        Person p1 = new Person("Harry", 25);
	        Person p2 = new Person("Steven", 30);
	        Person p3 = new Person("Harry", 25); // Same as p1

	        people.add(p1);   // p1 is sharing a different memory location
	        people.add(p2);
	        people.add(p3);   // Will NOT be added (duplicate)

	        System.out.println("People in HashSet:");
	        for (Person p : people) {
	            System.out.println(p + " - hashCode: " + p.hashCode());
	        }
	    }
	}