package EmployeeMenu;

import java.util.*;

public class ProjectDetails {

    private Map<String, List<String>> projectInfo = new HashMap<>();

    public ProjectDetails() {
     
        List<String> mrinalProjects = new ArrayList<>();
        mrinalProjects.add("AI Chatbot Development");
        mrinalProjects.add("Disaster Response AI System");
        mrinalProjects.add("NLP Text Analyzer");
        projectInfo.put("Mrinal Ghosh", mrinalProjects);

       
        List<String> amitProjects = new ArrayList<>();
        amitProjects.add("Test Automation Framework");
        amitProjects.add("API Testing using Postman");
        amitProjects.add("Selenium with Java");
        projectInfo.put("Amit Sharma", amitProjects);

      
        List<String> priyaProjects = new ArrayList<>();
        priyaProjects.add("Website Redesign Project");
        priyaProjects.add("Mobile App Wireframing");
        priyaProjects.add("UX Feedback Dashboard");
        projectInfo.put("Priya Verma", priyaProjects);

   
        List<String> snehaProjects = new ArrayList<>();
        snehaProjects.add("E-commerce Backend System");
        snehaProjects.add("Spring Boot API Integration");
        snehaProjects.add("Database Migration Project");
        projectInfo.put("Sneha Kapoor", snehaProjects);

        List<String> rahulProjects = new ArrayList<>();
        rahulProjects.add("CI/CD Pipeline Setup");
        rahulProjects.add("Cloud Monitoring Tools");
        rahulProjects.add("Docker & Kubernetes Deployment");
        projectInfo.put("Rahul Mehta", rahulProjects);
    }

    public void displayProjectDetails(String name) {
        System.out.println("--- Project Details ---");
        List<String> projects = projectInfo.get(name);
        if (projects != null) {
            System.out.println("Name: " + name);
            for (String project : projects) {
                System.out.println("- " + project);
            }
        } else {
            System.out.println("Employee not found. Please enter a name from the list.");
        }
    }

    public void displayNameOptions() {
        System.out.println("Available Employee Names:");
        int i = 1;
        for (String name : projectInfo.keySet()) {
            System.out.println(i + ". " + name);
            i++;
        }
    }
}