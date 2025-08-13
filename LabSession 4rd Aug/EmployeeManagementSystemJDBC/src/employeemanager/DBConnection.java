package employeemanager;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee_db", "root", "Mrinal@9733");
        } catch (Exception e) {
            System.out.println("Connection error: " + e.getMessage());
        }
        return conn;
    }
}
