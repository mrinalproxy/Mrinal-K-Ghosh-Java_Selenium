package Devices;

public class SmartAC implements SmartDevice, Adjustable {
    private boolean isOn;
    private int temperature;

    public SmartAC() {
        isOn = false;
        temperature = 24;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Smart AC is ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Smart AC is OFF");
    }

    @Override
    public void increaseSetting() {
        temperature++;
        System.out.println("Temperature increased to: " + temperature);
    }

    @Override
    public void decreaseSetting() {
        temperature--;
        System.out.println("Temperature decreased to: " + temperature);
    }

    @Override
    public boolean isDeviceOn() {
        return isOn;
    }
}