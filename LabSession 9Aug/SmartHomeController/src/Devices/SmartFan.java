package Devices;

public class SmartFan implements SmartDevice, Adjustable {
    private boolean isOn;
    private int speed;

    public SmartFan() {
        isOn = false;
        speed = 1;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Smart Fan is ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Smart Fan is OFF");
    }

    @Override
    public void increaseSetting() {
        if (speed < 5) speed++;
        System.out.println("Fan speed increased to: " + speed);
    }

    @Override
    public void decreaseSetting() {
        if (speed > 1) speed--;
        System.out.println("Fan speed decreased to: " + speed);
    }

    @Override
    public boolean isDeviceOn() {
        return isOn;
    }
}