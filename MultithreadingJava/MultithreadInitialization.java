public class MultithreadInitialization {
    public static void main(String[] args) {
        Thread t1 = new UsingThreadClass();
        t1.start();

        Thread t2 = new Thread(new UsingRunnableinterface());
        t2.start();

        Thread t3 = new Thread(() -> { // Using Lamda Function
            System.out.println("This is a Thread Using Lamda Function");
        });
        t3.start();
    }
}

class UsingThreadClass extends Thread {
    @Override
    public void run() {
        System.out.println("This is a Thread Using Thread Class");
    }
}

class UsingRunnableinterface implements Runnable {
    @Override
    public void run() {
        System.out.println("this is a Thread Using Runnable Interface");
    }
}