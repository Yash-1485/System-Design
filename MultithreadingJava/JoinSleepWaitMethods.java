public class JoinSleepWaitMethods {
    public static void main(String[] args) throws Exception {
        Thread t1 = new MyThread("t1");
        Thread t2 = new MyThread("t2");

        // start methods is used to run execution fo threads
        // join method can be used to let other threads wait for current thread
        // execution
        t2.start();
        t2.join();

        t1.start();
        t1.join();

        System.out.println("Main Thread");
    }
}

class MyThread extends Thread {
    MyThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        System.out.println("Hello, World! From " + this.getName());
    }
}
