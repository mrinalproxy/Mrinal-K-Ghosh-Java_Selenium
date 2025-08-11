package ThreadPriority;

public class ThreadPriorityDemo extends Thread {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(500); // pause for 0.5 second
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e);
            }
        }
    }

    public static void main(String[] args) {
        ThreadPriorityDemo t1 = new ThreadPriorityDemo();
        ThreadPriorityDemo t2 = new ThreadPriorityDemo();

        t1.setName("LowPriorityThread");
        t2.setName("HighPriorityThread");

        // Set priorities
        t1.setPriority(5);  // Normal priority
        t2.setPriority(10); // Highest priority

        // Start both threads
        t1.start();
        t2.start();

        // Print priorities
        System.out.println("Priority of thread " + t1.getName() + ": " + t1.getPriority());
        System.out.println("Priority of thread " + t2.getName() + ": " + t2.getPriority());
    }
}
