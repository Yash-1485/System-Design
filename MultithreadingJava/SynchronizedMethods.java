public class SynchronizedMethods {
    public static void main(String[] args) throws Exception {
        // Synchronized Methods Are Used To Lock a Method For Threads So That Only
        // Single Thread At A Time Enters The Method and Execute It
        Counter c = new Counter();
        Thread t1 = new Thread(() -> {
            Thread.currentThread().setName("Thread - t1");
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                c.incrementCounter();
            }
        });

        Thread t2 = new Thread(() -> {
            Thread.currentThread().setName("Thread - t2");
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
                c.incrementCounter();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Counter is: " + c.getCounter());
    }
}

class Counter {
    int count = 0;

    synchronized void incrementCounter() {
        this.count++;
    }

    int getCounter() {
        return this.count;
    }
}