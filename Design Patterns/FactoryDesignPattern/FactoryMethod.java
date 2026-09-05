package FactoryDesignPattern;
public class FactoryMethod {
    public static void main(String[] args) {
        CarType type = CarType.FAMILY;

        // CarFactory carFactory = new PetrolCarFactory();
        // CarFactory carFactory = new EVCarFactory();
        CarFactory carFactory = new DieselCarFactory();

        try {
            Car car = carFactory.createCar(type);
            car.run();
        } catch (InvalidCarTypeException e) {
            System.out.println(e.getMessage());
        }

    }
}

// --------------------------------------------------------------------
interface Car {
    void run();
}
// --------------------------------------------------------------------

// --------------------------------------------------------------------
class SUVPetrolCar implements Car {
    @Override
    public void run() {
        System.out.println("SUV (Petrol) => Car Is Running...");
    }
}

class SedanPetrolCar implements Car {
    @Override
    public void run() {
        System.out.println("Sedan (Petrol) => Car Is Running...");
    }
}

class FamilyPetrolCar implements Car {
    @Override
    public void run() {
        System.out.println("Family (Petrol) => Car Is Running...");
    }
}
// --------------------------------------------------------------------

// --------------------------------------------------------------------
class SUVDieselCar implements Car {
    @Override
    public void run() {
        System.out.println("SUV (Diesel) => Car Is Running...");
    }
}

class SedanDieselCar implements Car {
    @Override
    public void run() {
        System.out.println("Sedan (Diesel) => Car Is Running...");
    }
}

class FamilyDieselCar implements Car {
    @Override
    public void run() {
        System.out.println("Family (Diesel) => Car Is Running...");
    }
}
// --------------------------------------------------------------------

// --------------------------------------------------------------------
class SUVEVCar implements Car {
    @Override
    public void run() {
        System.out.println("SUV (EV) => Car Is Running...");
    }
}

class SedanEVCar implements Car {
    @Override
    public void run() {
        System.out.println("Sedan (EV) => Car Is Running...");
    }
}

class FamilyEVCar implements Car {
    @Override
    public void run() {
        System.out.println("Family (EV) => Car Is Running...");
    }
}
// --------------------------------------------------------------------

// --------------------------------------------------------------------
// Factory
// --------------------------------------------------------------------

interface CarFactory {
    Car createCar(CarType type) throws InvalidCarTypeException;
}

class PetrolCarFactory implements CarFactory {
    @Override
    public Car createCar(CarType type) throws InvalidCarTypeException {
        Car car;
        switch (type) {
            case SUV:
                car = new SUVPetrolCar();
                break;
            case SEDAN:
                car = new SedanPetrolCar();
                break;
            case FAMILY:
                car = new FamilyPetrolCar();
                break;
            default:
                throw new InvalidCarTypeException("Invalid Car Type");
        }
        return car;
    }
}

class DieselCarFactory implements CarFactory {
    @Override
    public Car createCar(CarType type) throws InvalidCarTypeException {
        Car car;
        switch (type) {
            case SUV:
                car = new SUVDieselCar();
                break;
            case SEDAN:
                car = new SedanDieselCar();
                break;
            case FAMILY:
                car = new FamilyDieselCar();
                break;
            default:
                throw new InvalidCarTypeException("Invalid Car Type");
        }
        return car;
    }
}

class EVCarFactory implements CarFactory {
    @Override
    public Car createCar(CarType type) throws InvalidCarTypeException {
        Car car;
        switch (type) {
            case SUV:
                car = new SUVEVCar();
                break;
            case SEDAN:
                car = new SedanEVCar();
                break;
            case FAMILY:
                car = new FamilyEVCar();
                break;
            default:
                throw new InvalidCarTypeException("Invalid Car Type");
        }
        return car;
    }
}

// --------------------------------------------------------------------
// Car Type
// --------------------------------------------------------------------
enum CarType {
    SUV,
    SEDAN,
    FAMILY;
}
// --------------------------------------------------------------------

// --------------------------------------------------------------------
// Exception Class
// --------------------------------------------------------------------
class InvalidCarTypeException extends Exception {
    InvalidCarTypeException(String msg) {
        super(msg);
    }
}
// --------------------------------------------------------------------
