package EmployeeMenu;

import java.util.HashMap;
import java.util.Map;

public class SalaryDetails {
    private Map<String, Map<String, Double>> salaryData = new HashMap<>();

    public SalaryDetails() {

        Map<String, Double> mrinal = new HashMap<>();
        mrinal.put("Basic", 50000.0);
        mrinal.put("HRA", 10000.0);
        mrinal.put("DA", 5000.0);
        mrinal.put("PF", 3000.0);
        mrinal.put("Net Salary", 62000.0);
        salaryData.put("Mrinal Ghosh", mrinal);

        Map<String, Double> amit = new HashMap<>();
        amit.put("Basic", 45000.0);
        amit.put("HRA", 9000.0);
        amit.put("DA", 4000.0);
        amit.put("PF", 2500.0);
        amit.put("Net Salary", 55500.0);
        salaryData.put("Amit Sharma", amit);

        Map<String, Double> priya = new HashMap<>();
        priya.put("Basic", 42000.0);
        priya.put("HRA", 8500.0);
        priya.put("DA", 3500.0);
        priya.put("PF", 2200.0);
        priya.put("Net Salary", 51800.0);
        salaryData.put("Priya Verma", priya);


        Map<String, Double> sneha = new HashMap<>();
        sneha.put("Basic", 47000.0);
        sneha.put("HRA", 9500.0);
        sneha.put("DA", 4500.0);
        sneha.put("PF", 2800.0);
        sneha.put("Net Salary", 58200.0);
        salaryData.put("Sneha Kapoor", sneha);

 
        Map<String, Double> rahul = new HashMap<>();
        rahul.put("Basic", 48000.0);
        rahul.put("HRA", 9700.0);
        rahul.put("DA", 4700.0);
        rahul.put("PF", 2900.0);
        rahul.put("Net Salary", 60500.0);
        salaryData.put("Rahul Mehta", rahul);
    }

    public void displaySalary(String name) {
        System.out.println("\n--- Salary Details ---");
        if (salaryData.containsKey(name)) {
            Map<String, Double> details = salaryData.get(name);
            for (Map.Entry<String, Double> entry : details.entrySet()) {
                System.out.println(entry.getKey() + ": ₹" + entry.getValue());
            }
        } else {
            System.out.println("Employee not found.");
        }
    }

    public void displayNameOptions() {
        System.out.println("\nAvailable Employee Names:");
        int i = 1;
        for (String name : salaryData.keySet()) {
            System.out.println(i + ". " + name);
            i++;
        }
    }
}