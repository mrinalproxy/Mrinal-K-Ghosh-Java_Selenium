package SerializationDemo;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    transient String password; // won't be serialized

    public Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age + ", Password: " + password);
    }
}
