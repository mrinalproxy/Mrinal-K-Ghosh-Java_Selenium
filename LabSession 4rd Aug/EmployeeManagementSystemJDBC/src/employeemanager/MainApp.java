package employeemanager;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InsertEmployee inserter = new InsertEmployee();
        DeleteEmployee deleter = new DeleteEmployee();
        UpdateEmployee updater = new UpdateEmployee();
        DisplayEmployee displayer = new DisplayEmployee();

        while (true) {
            System.out.println("Employee Menu");
            System.out.println("--------------");
            System.out.println("1. Insert a new Record");
            System.out.println("2. Delete a record");
            System.out.println("3. Update the record");
            System.out.println("4. Display all records");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    inserter.insert(new Employee(id, name, dept, salary));
                    break;

                case 2:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();
                    deleter.delete(did);
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Department: ");
                    String newDept = sc.nextLine();
                    System.out.print("Enter New Salary: ");
                    double newSalary = sc.nextDouble();
                    updater.update(uid, newName, newDept, newSalary);
                    break;

                case 4:
                    displayer.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
