package orderapp;

public class OrderTest {
    public static void main(String[] args) {
        Order physical = new PhysicalProductOrder("P123");
        Order digital = new DigitalProductOrder("D456");
        Order service = new ServiceOrder("S789");

        physical.process_order();
        physical.print_order_summary();

        digital.process_order();
        digital.print_order_summary();

        service.process_order();
        service.print_order_summary();
    }
}