// File: MultithreadingDemo.java
class MultithreadingDemo implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() + " printing " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted");
        }
    }

    public static void main(String[] args) {
        MultithreadingDemo demo = new MultithreadingDemo();

        Thread t1 = new Thread(demo, "Thread-1");
        Thread t2 = new Thread(demo, "Thread-2");
        Thread t3 = new Thread(demo, "Thread-3");

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }

        System.out.println(" All threads have finished execution.");
    }
}
