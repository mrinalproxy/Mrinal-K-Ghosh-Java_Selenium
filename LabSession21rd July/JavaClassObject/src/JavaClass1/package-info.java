package JavaClass1;

class Flower {
    private String name;
    private String color;

    public Flower() {
        System.out.println("Demo Flower for display");
    }

    public Flower(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Flower [name=" + name + ", color=" + color + "]";
    }
}