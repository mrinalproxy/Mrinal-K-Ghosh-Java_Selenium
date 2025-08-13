package employeemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateEmployee {
    public void update(int id, String newName, String newDept, double newSalary) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "UPDATE employee SET name=?, dept=?, salary=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, newName);
            ps.setString(2, newDept);
            ps.setDouble(3, newSalary);
            ps.setInt(4, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record updated.");
            conn.close();
        } catch (Exception e) {
            System.out.println("Update error: " + e.getMessage());
        }
    }
}
