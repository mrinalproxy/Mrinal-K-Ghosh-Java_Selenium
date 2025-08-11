package orderapp;

public class ServiceOrder extends Order {

    public ServiceOrder(String order_id) {
        super(order_id);
    }

    @Override
    public void process_order() {
        System.out.println("Scheduling service for order " + order_id + ".");
    }
}