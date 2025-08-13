package App;

import Controller.DeviceController;
import Devices.SmartLight;
import Devices.SmartFan;
import Devices.SmartAC;
import Devices.SmartTV;
import java.util.Scanner;

public class JavaMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DeviceController controller = new DeviceController();

       
        SmartLight light = new SmartLight();
        SmartFan fan = new SmartFan();
        SmartAC ac = new SmartAC();
        SmartTV tv = new SmartTV();

        
        controller.addDevice(light);
        controller.addDevice(fan);
        controller.addDevice(ac);
        controller.addDevice(tv);

        int choice;
        do {
            System.out.println("\n======= SMART HOME CONTROLLER MENU =======");
            System.out.println("1. Turn all devices ON");
            System.out.println("2. Turn all devices OFF");
            System.out.println("3. Adjust all adjustable devices");
            System.out.println("4. View device status");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    controller.turnAllOn();
                    break;
                case 2:
                    controller.turnAllOff();
                    break;
                case 3:
                    controller.adjustAllDevices();
                    break;
                case 4:
                    System.out.println("\n--- DEVICE STATUS ---");
                    System.out.println("Smart Light: " + (light.isDeviceOn() ? "ON" : "OFF"));
                    System.out.println("Smart Fan: " + (fan.isDeviceOn() ? "ON" : "OFF"));
                    System.out.println("Smart AC: " + (ac.isDeviceOn() ? "ON" : "OFF"));
                    System.out.println("Smart TV: " + (tv.isDeviceOn() ? "ON" : "OFF"));
                    break;
                case 5:
                    System.out.println("Exiting Smart Home Controller.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }
}
