public class PostConditionMethodRule {
    public static void main(String[] args) {
        // Overridden Method Should Be The Same Or More Constarint
        // But Not Weaker
        Car c = new ElectricCar(80, 100);

        c.brake();
    }
}

class Car {
    int speed;
    int charge;

    Car(int speed, int charge) {
        this.speed = speed;
        this.charge = charge;
    }

    void brake() {
        speed -= 20;
        System.out.println("Speed " + this.speed);
        System.out.println("Charge " + this.charge);
    }
}

class ElectricCar extends Car {
    ElectricCar(int speed, int charge) {
        super(speed, charge);
    }

    @Override
    void brake() {
        // speed -= 20; // Shouldn't Be Less Than 20
        speed -= 25; // Shouldn't Be Less Than 20
        charge -= 2;

        System.out.println("Speed " + this.speed);
        System.out.println("Charge " + this.charge);
    }
}