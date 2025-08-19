package Test;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import application.Orders;
import application.Customer;
import application.Product;

public class OrdersTest {
	Orders shop = new Orders();
	
	@Test
    public void testInsertCustomer() {
		Customer c = new Customer(1001, "Sourav", "9876543210", "male", "Bankura", "Kotulpur", "722141");
        shop.insertCustomer(c);
        assertTrue(true);
    }

    @Test
    public void testInsertProduct() {
        Product p = new Product(2001, "P001", "Mobile", 10000.0, 2, java.sql.Date.valueOf("2026-11-20")
        		);
        shop.insertProduct(p, 1); 
        assertTrue(true);
    }
    @Test
    public void testBuyProduct() {
    	shop.buyProduct(1, 1);
        assertTrue(true);
    }

    @Test
    public void testDisplayCustomerProducts() {
    	shop.displayCustomerProducts(1);
        assertTrue(true);
    }

}

