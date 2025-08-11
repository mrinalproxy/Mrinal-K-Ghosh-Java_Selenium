package EncapProject;

public class EmployeeTest {
	 public static void main(String[] args) {
	        // First 5 using constructor
	        Employee emp1 = new Employee(101, "Amit Sharma", "IT", 55000);
	        Employee emp2 = new Employee(102, "Priya Verma", "HR", 48000);
	        Employee emp3 = new Employee(103, "Ravi Kumar", "Finance", 62000);
	        Employee emp4 = new Employee(104, "Sneha Iyer", "Marketing", 51000);
	        Employee emp5 = new Employee(105, "Rajesh Singh", "Operations", 57000);

	        // Next 5 using setters
	        Employee emp6 = new Employee();
	        emp6.setId(106);
	        emp6.setName("Kiran Joshi");
	        emp6.setDepartment("IT");
	        emp6.setSalary(53000);

	        Employee emp7 = new Employee();
	        emp7.setId(107);
	        emp7.setName("Manoj Mehta");
	        emp7.setDepartment("HR");
	        emp7.setSalary(49000);

	        Employee emp8 = new Employee();
	        emp8.setId(108);
	        emp8.setName("Deepa Nair");
	        emp8.setDepartment("Finance");
	        emp8.setSalary(60000);

	        Employee emp9 = new Employee();
	        emp9.setId(109);
	        emp9.setName("Anil Patil");
	        emp9.setDepartment("Marketing");
	        emp9.setSalary(52000);

	        Employee emp10 = new Employee();
	        emp10.setId(110);
	        emp10.setName("Pooja Desai");
	        emp10.setDepartment("Operations");
	        emp10.setSalary(58000);

	        // Display employees using getters
	        printEmployee(emp1);
	        printEmployee(emp2);
	        printEmployee(emp3);
	        printEmployee(emp4);
	        printEmployee(emp5);
	        printEmployee(emp6);
	        printEmployee(emp7);
	        printEmployee(emp8);
	        printEmployee(emp9);
	        printEmployee(emp10);
	    }

	    public static void printEmployee(Employee e) {
	        System.out.println("Employee Details:");
	        System.out.println("ID        : " + e.getId());
	        System.out.println("Name      : " + e.getName());
	        System.out.println("Department: " + e.getDepartment());
	        System.out.println("Salary    : " + e.getSalary());
	        System.out.println("-----------------------------------");
	    }
	}