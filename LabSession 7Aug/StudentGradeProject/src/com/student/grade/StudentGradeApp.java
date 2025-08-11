package com.student.grade;

import java.util.Scanner;

public class StudentGradeApp {
    public static void main(String[] args) {
        Scanner sc = null;

        try {
            sc = new Scanner(System.in);
            System.out.print("Enter the number of students: ");
            int n = sc.nextInt();
            sc.nextLine();

            String[] names = new String[n];
            int[] grades = new int[n];

            for (int i = 0; i < n; i++) {
                System.out.println("\nStudent " + (i + 1) + " details:");

                System.out.print("Enter name: ");
                names[i] = sc.nextLine();

                System.out.print("Enter grade (0 to 100): ");
                int grade = sc.nextInt();
                sc.nextLine(); // clear buffer

                // Validate using custom exception
                if (grade < 0 || grade > 100) {
                    throw new InvalidGradeException("Invalid grade for " + names[i] + ": " + grade);
                }

                grades[i] = grade;
            }

            // Print student data
            System.out.println("\n Student Grades Summary ");
            for (int i = 0; i < n; i++) {
                System.out.println(names[i] + " scored: " + grades[i]);
            }

        } catch (InvalidGradeException e) {
            System.out.println(" Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Unexpected Error: " + e);
        } finally {
            if (sc != null) {
                sc.close();
                System.out.println(" Scanner closed.");
            }
        }
    }
}