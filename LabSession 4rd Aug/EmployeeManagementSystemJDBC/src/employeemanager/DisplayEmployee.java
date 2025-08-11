package employeemanager;

import java.sql.*;
import java.util.ArrayList;

public class DisplayEmployee {
    public void displayAll() {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "SELECT * FROM employee";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            ArrayList<Employee> empList = new ArrayList<>();

            while (rs.next()) {
                Employee emp = new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("dept"),
                    rs.getDouble("salary"));
                empList.add(emp);
            }

            System.out.println("ID | Name | Department | Salary");
            System.out.println("--------------------------------");
            for (Employee e : empList) {
                System.out.println(e);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Display error: " + e.getMessage());
        }
    }
}