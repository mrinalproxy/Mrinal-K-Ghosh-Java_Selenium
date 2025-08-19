package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Orders {
	public void insertCustomer(Customer customer) {
	    String sql = "INSERT INTO Customer(cust_id, cust_name, cust_contact, cust_gender, cust_addr, city, zipcode) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setInt(1, customer.getCust_id()); 
	        ps.setString(2, customer.getCust_name());
	        ps.setString(3, customer.getCust_contact());
	        ps.setString(4, customer.getCust_gender());
	        ps.setString(5, customer.getCust_addr());
	        ps.setString(6, customer.getCity());
	        ps.setString(7, customer.getZipcode());

	        ps.executeUpdate();
	        System.out.println("Customer inserted successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	 
	 public void insertProduct(Product product, int cust_id) {
	        String sql = "INSERT INTO Product(product_id,product_code, product_desc, product_price, product_qty, product_expdate, cust_id) VALUES (?,?, ?, ?, ?, ?, ?)";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	        	 ps.setInt(1, product.getProduct_id());  
	            ps.setString(2, product.getProduct_code());
	            ps.setString(3, product.getProduct_desc());
	            ps.setDouble(4, product.getProduct_price());
	            ps.setInt(5, product.getProduct_qty());
	            ps.setDate(6, (Date) product.getProduct_expdate());
	            ps.setInt(7, cust_id);
	            ps.executeUpdate();
	            System.out.println("Product inserted successfully.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  public void buyProduct(int product_id, int qty) {
	        String sql = "UPDATE Product SET product_qty = product_qty - ? WHERE product_id = ? AND product_qty >= ?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, qty);
	            ps.setInt(2, product_id);
	            ps.setInt(3, qty);
	            int rows = ps.executeUpdate();
	            if (rows > 0) {
	                System.out.println("Product purchased successfully.");
	            } else {
	                System.out.println("Not  stock");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	  public void displayCustomerProducts(int cust_id) {
	        String sql = "SELECT c.cust_name, p.product_code, p.product_desc, p.product_price, p.product_qty " +
	                     "FROM Customer c JOIN Product p ON c.cust_id = p.cust_id WHERE c.cust_id=?";
	        try (Connection conn = DBConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {

	            ps.setInt(1, cust_id);
	            ResultSet rs = ps.executeQuery();

	            double total = 0;
	            System.out.println("Customer Products:");
	            while (rs.next()) {
	                System.out.println("Customer: " + rs.getString("cust_name") +
	                                   ", Product: " + rs.getString("product_code") +
	                                   ", Desc: " + rs.getString("product_desc") +
	                                   ", Price: " + rs.getDouble("product_price") +
	                                   ", Qty: " + rs.getInt("product_qty"));
	                total += rs.getDouble("product_price") * rs.getInt("product_qty");
	            }
	            System.out.println("Total Price: " + total);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
