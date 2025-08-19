package application;

import java.util.Date;

public class Product {
	private int product_id;
    private String product_code;
    private String product_desc;
    private double product_price;
    private int product_qty;
    private Date product_expdate;
	public Product(int product_id, String product_code, String product_desc, double product_price, int product_qty,
			Date product_expdate) {
		super();
		this.product_id = product_id;
		this.product_code = product_code;
		this.product_desc = product_desc;
		this.product_price = product_price;
		this.product_qty = product_qty;
		this.product_expdate = product_expdate;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_code() {
		return product_code;
	}
	public void setProduct_code(String product_code) {
		this.product_code = product_code;
	}
	public String getProduct_desc() {
		return product_desc;
	}
	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}
	public double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_qty() {
		return product_qty;
	}
	public void setProduct_qty(int product_qty) {
		this.product_qty = product_qty;
	}
	public Date getProduct_expdate() {
		return product_expdate;
	}
	public void setProduct_expdate(Date product_expdate) {
		this.product_expdate = product_expdate;
	}
    
}
