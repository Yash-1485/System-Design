public class BrokenInterfaceSegregationPrinciple {
    public static void main(String[] args) {
        Shape square = new Square();
        Shape cube = new Cube();

        square.area();

        try {
            square.volume();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        cube.area();
        try {
            cube.volume();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

interface Shape {
    void area();

    void volume() throws Exception;
}

class Square implements Shape {
    @Override
    public void area() {
        System.out.println("Square Area");
    }

    @Override
    public void volume() throws Exception {
        throw new Exception("2d Objects Can't Have Volume");
    }
}

class Rectangle implements Shape {
    @Override
    public void area() {
        System.out.println("Rectangle Area");
    }

    @Override
    public void volume() throws Exception {
        throw new Exception("2d Objects Can't Have Volume");
    }
}

class Cube implements Shape {
    @Override
    public void area() {
        System.out.println("Cube Area");
    }

    @Override
    public void volume() throws Exception {
        System.out.println("Cube Volume");
    }
}