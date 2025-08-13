package EmployeeMenu;

import java.util.HashMap;
import java.util.Map;

public class ProfessionalDetails {

    private Map<String, Map<String, String>> professionalInfo = new HashMap<>();

    public ProfessionalDetails() {
       
        Map<String, String> mrinal = new HashMap<>();
        mrinal.put("Employee ID", "EMP999");
        mrinal.put("Department", "AI Research");
        mrinal.put("Designation", "ML Engineer");
        mrinal.put("Experience", "7 Years");
        mrinal.put("Manager", "Dr. Raghavan");
        professionalInfo.put("Mrinal Ghosh", mrinal);

        
        Map<String, String> amit = new HashMap<>();
        amit.put("Employee ID", "EMP102");
        amit.put("Department", "Testing");
        amit.put("Designation", "QA Engineer");
        amit.put("Experience", "3 Years");
        amit.put("Manager", "Ravi Kumar");
        professionalInfo.put("Amit Sharma", amit);

        Map<String, String> priya = new HashMap<>();
        priya.put("Employee ID", "EMP103");
        priya.put("Department", "UI/UX");
        priya.put("Designation", "UI Designer");
        priya.put("Experience", "2 Years");
        priya.put("Manager", "Anita Rao");
        professionalInfo.put("Priya Verma", priya);

   
        Map<String, String> sneha = new HashMap<>();
        sneha.put("Employee ID", "EMP104");
        sneha.put("Department", "Software Development");
        sneha.put("Designation", "Backend Developer");
        sneha.put("Experience", "4 Years");
        sneha.put("Manager", "Neha Sharma");
        professionalInfo.put("Sneha Kapoor", sneha);


        Map<String, String> rahul = new HashMap<>();
        rahul.put("Employee ID", "EMP105");
        rahul.put("Department", "DevOps");
        rahul.put("Designation", "DevOps Engineer");
        rahul.put("Experience", "6 Years");
        rahul.put("Manager", "Sunil Dutta");
        professionalInfo.put("Rahul Mehta", rahul);
    }

 
    public void displayProfessional(String name) {
        System.out.println("\n--- Professional Details ---");

        Map<String, String> details = professionalInfo.get(name);
        if (details != null) {
            System.out.println("Name: " + name);
            for (Map.Entry<String, String> entry : details.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        } else {
            System.out.println("Employee not found. Please enter a name from the list.");
        }
    }

    public void displayNameOptions() {
        System.out.println("\nAvailable Employee Names:");
        int i = 1;
        for (String name : professionalInfo.keySet()) {
            System.out.println(i + ". " + name);
            i++;
        }
    }
}
