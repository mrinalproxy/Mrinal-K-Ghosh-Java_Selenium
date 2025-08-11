package JavaClass1;

public class JavaClass {

    public static void main(String[] args) {
        Flower flower1 = new Flower("Rose", "Red");
        System.out.println(flower1);

        Flower flower2 = new Flower("Lily", "White");
        System.out.println(flower2);

        Flower demoFlower = new Flower();  // Calls the default constructor
    }
}
