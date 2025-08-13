package employeemanager;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteEmployee {
    public void delete(int id) {
        try {
            Connection conn = DBConnection.getConnection();
            String query = "DELETE FROM employee WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            System.out.println(rows + " record deleted.");
            conn.close();
        } catch (Exception e) {
            System.out.println("Delete error: " + e.getMessage());
        }
    }
}
