package SingletonDesignPattern;

public class ThreadSafeSingletonDesignPattern {

    public static void main(String[] args) throws Exception {

        final Singleton[] instances = new Singleton[2];

        Thread t1 = new Thread(() -> {
            instances[0] = Singleton.getInstance();
        });

        Thread t2 = new Thread(() -> {
            instances[1] = Singleton.getInstance();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Instance 1: " + instances[0]);
        System.out.println("Instance 2: " + instances[1]);
        System.out.println(
                "Are Both Instances Same? " +
                        (instances[0] == instances[1]));
    }
}

class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
        System.out.println("Singleton Constructor");
    }

    public static Singleton getInstance() {

        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}