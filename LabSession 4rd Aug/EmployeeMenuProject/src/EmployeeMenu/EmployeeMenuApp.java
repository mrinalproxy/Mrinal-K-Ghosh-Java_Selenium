package EmployeeMenu;

import java.util.Scanner;

public class EmployeeMenuApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        PersonalDetails personal = new PersonalDetails();
        ProfessionalDetails professional = new ProfessionalDetails();
        SalaryDetails salary = new SalaryDetails();
        LeaveDetails leave = new LeaveDetails();
        ProjectDetails project = new ProjectDetails();

        do {
            System.out.println("Employee Menu");
            System.out.println("-------------");
            System.out.println("1. Display Personal Details");
            System.out.println("2. Display Professional Details");
            System.out.println("3. Display Salary Details");
            System.out.println("4. Display Leave Details");
            System.out.println("5. Display Projects Undertaken");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    personal.displayNameOptions();
                    System.out.print("Enter employee name from above: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    personal.displayDetails(name);
                    break;
                case 2:
                    professional.displayNameOptions();
                    System.out.print("Enter employee name from above: ");
                    sc.nextLine();
                    String proName = sc.nextLine();
                    professional.displayProfessional(proName);
                    break;
                case 3:
                	 salary.displayNameOptions();
                     System.out.print("Enter employee name from above: ");
                     sc.nextLine();
                     String salName = sc.nextLine();
                     salary.displaySalary(salName);
                     break;
                case 4:
                    leave.displayNameOptions();
                    System.out.print("Enter employee name from above: ");
                    sc.nextLine();
                    String leaveName = sc.nextLine();
                    leave.displayLeaveDetails(leaveName);
                    break;
                case 5:
                    project.displayNameOptions();
                    System.out.print("Enter employee name from above: ");
                    sc.nextLine();
                    String projectName = sc.nextLine();
                    project.displayProjectDetails(projectName);
                    break;
                case 6:
                    System.out.println("Thank you for using Employee Menu.");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter between 1–6.");
            }

        } while (choice != 6);

        sc.close();
    }
}