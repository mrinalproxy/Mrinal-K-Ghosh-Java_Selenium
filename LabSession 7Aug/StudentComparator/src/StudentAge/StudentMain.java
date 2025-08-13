package StudentAge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentMain {
    private String name;
    private int age;

    public StudentMain() {
        // default constructor
    }

    public StudentMain(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}