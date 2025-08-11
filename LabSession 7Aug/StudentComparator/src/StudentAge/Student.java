package StudentAge;

public class Student {
    private int id;
    private String name;
    private int age;

    // Constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters only
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // toString
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age;
    }
}
