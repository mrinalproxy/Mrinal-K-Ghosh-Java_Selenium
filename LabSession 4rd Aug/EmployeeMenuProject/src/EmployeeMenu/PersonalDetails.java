package EmployeeMenu;

import java.util.HashMap;
import java.util.Map;

public class PersonalDetails {
    private Map<String, Map<String, String>> allEmployees = new HashMap<>();

    public PersonalDetails() {
     
        Map<String, String> emp1 = new HashMap<>();
        emp1.put("Age", "30");
        emp1.put("Gender", "Male");
        emp1.put("Phone", "9876543210");
        emp1.put("Address", "Kolkata, India");
        allEmployees.put("Mrinal Ghosh", emp1);

     
        Map<String, String> emp2 = new HashMap<>();
        emp2.put("Age", "28");
        emp2.put("Gender", "Male");
        emp2.put("Phone", "9123456780");
        emp2.put("Address", "Delhi, India");
        allEmployees.put("Amit Sharma", emp2);

      
        Map<String, String> emp3 = new HashMap<>();
        emp3.put("Age", "26");
        emp3.put("Gender", "Female");
        emp3.put("Phone", "9988776655");
        emp3.put("Address", "Mumbai, India");
        allEmployees.put("Priya Verma", emp3);

       
        Map<String, String> emp4 = new HashMap<>();
        emp4.put("Age", "29");
        emp4.put("Gender", "Female");
        emp4.put("Phone", "9876501234");
        emp4.put("Address", "Bangalore, India");
        allEmployees.put("Sneha Kapoor", emp4);

      
        Map<String, String> emp5 = new HashMap<>();
        emp5.put("Age", "32");
        emp5.put("Gender", "Male");
        emp5.put("Phone", "9012345678");
        emp5.put("Address", "Chennai, India");
        allEmployees.put("Rahul Mehta", emp5);
    }

    public void displayDetails(String name) {
        System.out.println("--- Personal Details ---");

        if (allEmployees.containsKey(name)) {
            System.out.println("Name: " + name);
            Map<String, String> details = allEmployees.get(name);
            for (Map.Entry<String, String> entry : details.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayNameOptions() {
        System.out.println("\nAvailable Employee Names:");
        int i = 1;
        for (String name : allEmployees.keySet()) {
            System.out.println(i + ". " + name);
            i++;
        }
    }
}