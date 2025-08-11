package orderapp;

public class PhysicalProductOrder extends Order {

    public PhysicalProductOrder(String order_id) {
        super(order_id);
    }
    public void process_order() {
        System.out.println("Shipping physical product for order " + order_id + ".");
    }
}