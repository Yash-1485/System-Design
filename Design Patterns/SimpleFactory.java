public class SimpleFactory {
    public static void main(String[] args) throws Exception {
        String type = "premiasdum";

        Burger burger = BurgerFactory.createBurger(type);

        try {
            burger.prepare();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

abstract class Burger {
    abstract void prepare();
}

class BasicBurger extends Burger {
    @Override
    void prepare() {
        System.out.println("Basic Burger is preparing...");
    }
}

class StandardBurger extends Burger {
    @Override
    void prepare() {
        System.out.println("Standard Burger is preparing...");
    }
}

class PremiumBurger extends Burger {
    @Override
    void prepare() {
        System.out.println("Premium Burger is preparing...");
    }
}

class BurgerFactory {
    static Burger createBurger(String type) throws Exception {
        switch (type.toLowerCase()) {
            case "basic":
                return new BasicBurger();
            case "standard":
                return new StandardBurger();
            case "premium":
                return new PremiumBurger();
            default:
                throw new InvalidBurgerException("Invalid Burger Type");
        }
    }
}

class InvalidBurgerException extends Exception {
    InvalidBurgerException(String msg) {
        super(msg);
    }
}