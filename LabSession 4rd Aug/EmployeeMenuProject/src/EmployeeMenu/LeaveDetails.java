package EmployeeMenu;

import java.util.HashMap;
import java.util.Map;

public class LeaveDetails {

    private Map<String, Map<String, Integer>> leaveInfo = new HashMap<>();

    public LeaveDetails() {
      
        Map<String, Integer> mrinal = new HashMap<>();
        mrinal.put("Earned Leave", 12);
        mrinal.put("Casual Leave", 6);
        mrinal.put("Medical Leaves", 2);
        leaveInfo.put("Mrinal Ghosh", mrinal);

      
        Map<String, Integer> amit = new HashMap<>();
        amit.put("Earned Leave", 8);
        amit.put("Casual Leave", 4);
        amit.put("Medical Leaves", 1);
        leaveInfo.put("Amit Sharma", amit);

      
        Map<String, Integer> priya = new HashMap<>();
        priya.put("Earned Leave", 10);
        priya.put("Casual Leave", 3);
        leaveInfo.put("Priya Verma", priya);

      
        Map<String, Integer> sneha = new HashMap<>();
        sneha.put("Earned Leave", 15);
        sneha.put("Casual Leave", 5);
        leaveInfo.put("Sneha Kapoor", sneha);

   
        Map<String, Integer> rahul = new HashMap<>();
        rahul.put("Earned Leave", 7);
        rahul.put("Casual Leave", 2);
        leaveInfo.put("Rahul Mehta", rahul);
    }

    public void displayLeaveDetails(String name) {
        System.out.println("\n--- Leave Details ---");
        Map<String, Integer> details = leaveInfo.get(name);
        if (details != null) {
            System.out.println("Name: " + name);
            for (Map.Entry<String, Integer> entry : details.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue() + " days");
            }
        } else {
            System.out.println("Employee not found. Please enter a valid name from the list.");
        }
    }

    public void displayNameOptions() {
        System.out.println("\nAvailable Employee Names:");
        int i = 1;
        for (String name : leaveInfo.keySet()) {
            System.out.println(i + ". " + name);
            i++;
        }
    }
}
