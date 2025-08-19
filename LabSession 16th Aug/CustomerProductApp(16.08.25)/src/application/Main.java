package application;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Orders shop = new Orders();
       

        while (true) {
            System.out.println("\n===== Shopping Menu =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Product");
            System.out.println("3. Buy Product");
            System.out.println("4. Display Customer Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                	System.out.print("Enter Customer ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Enter Address: ");
                    String addr = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    System.out.print("Enter Zipcode: ");
                    String zip = sc.nextLine();

                    Customer c = new Customer( cid, name, contact, gender, addr, city, zip);
                    shop.insertCustomer(c); // no return id
                    break;

                case 2:
                    System.out.print("Enter Customer ID: ");
                    int cid1 = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Product ID: ");
                    int pid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Product Code: ");
                    String code = sc.nextLine();
                    System.out.print("Enter Product Desc: ");
                    String desc = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
                    String expdate = sc.nextLine();

                    Product p = new Product(pid, code, desc, price, qty, Date.valueOf(expdate));
                    shop.insertProduct(p, cid1);
                    break;

                case 3:
                    System.out.print("Enter Product ID: ");
                    int pid1 = sc.nextInt();
                    System.out.print("Enter Quantity to Buy: ");
                    int buyQty = sc.nextInt();
                    shop.buyProduct(pid1, buyQty);
                    break;

                case 4:
                    System.out.print("Enter Customer ID: ");
                    int cid2 = sc.nextInt();
                    shop.displayCustomerProducts(cid2);
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}