package EmployeeApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeListExample {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Adding Employees
        employeeList.add(new Employee(101, "Alice", "HR"));
        employeeList.add(new Employee(102, "Bob", "IT"));
        employeeList.add(new Employee(103, "Charlie", "Finance"));

        // Display All Employees
        System.out.println("All Employees:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        // Search by ID
        System.out.print("\nEnter Employee ID to search: ");
        int searchId = scanner.nextInt();
        boolean found = false;

        for (Employee emp : employeeList) {
            if (emp.getId() == searchId) {
                System.out.println("Found: " + emp);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Employee with ID " + searchId + " not found.");
        }

        // Remove by ID
        System.out.print("\nEnter Employee ID to remove: ");
        int removeId = scanner.nextInt();
        Employee toRemove = null;
        for (Employee emp : employeeList) {
            if (emp.getId() == removeId) {
                toRemove = emp;
                break;
            }
        }

        if (toRemove != null) {
            employeeList.remove(toRemove);
            System.out.println("Employee removed.");
        } else {
            System.out.println("Employee with ID " + removeId + " not found.");
        }

        // Final List
        System.out.println("\nUpdated Employee List:");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }

        scanner.close();
    }
}