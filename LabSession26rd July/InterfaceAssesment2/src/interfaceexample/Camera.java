package interfaceexample;

public class Camera implements Recordable, Streamable {

    public void record() {
        System.out.println("Camera recording video.");
    }

    public void stream() {
        System.out.println("Camera streaming live video.");
    }
}