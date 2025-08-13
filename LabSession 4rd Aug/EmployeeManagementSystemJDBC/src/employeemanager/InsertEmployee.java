package employeemanager;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertEmployee {
    public void insert(Employee emp) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "INSERT INTO employee (id, name, dept, salary) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDept());
            ps.setDouble(4, emp.getSalary());

            int rows = ps.executeUpdate();
            System.out.println(rows + " record inserted.");
            conn.close();
        } catch (Exception e) {
            System.out.println("Insert error: " + e.getMessage());
        }
    }
}
