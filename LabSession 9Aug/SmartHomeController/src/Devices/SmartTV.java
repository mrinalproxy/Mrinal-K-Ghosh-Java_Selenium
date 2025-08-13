package Devices;

public class SmartTV implements SmartDevice, Adjustable {
    private boolean isOn;
    private int volume;

    public SmartTV() {
        isOn = false;
        volume = 10;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Smart TV is ON");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Smart TV is OFF");
    }

    @Override
    public void increaseSetting() {
        if (volume < 100) volume += 5;
        System.out.println("Volume increased to: " + volume);
    }

    @Override
    public void decreaseSetting() {
        if (volume > 0) volume -= 5;
        System.out.println("Volume decreased to: " + volume);
    }

    @Override
    public boolean isDeviceOn() {
        return isOn;
    }
}
