package SingletonDesignPattern;

public class SingletonDesignPattern {
    public static void main(String[] args) throws Exception {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        System.out.println("First Instance: " + s1);
        System.out.println("Second Instance: " + s2);
        System.out.println("Are Both Instance Same? " + (s1 == s2));
    }
}

class Singleton {
    static Singleton instance = null;

    private Singleton() {
        System.out.println("Singleton Constructor");
    }

    static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}