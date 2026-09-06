public class InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        TwoDimensionalShape rectangle = new Rectangle();
        ThreeDimensionalShape cube = new Cube();

        rectangle.area();

        cube.area();
        cube.volume();
    }
}

interface TwoDimensionalShape {
    void area();
}

interface ThreeDimensionalShape {
    void area();

    void volume();
}

class Square implements TwoDimensionalShape {
    @Override
    public void area() {
        System.out.println("Square Area");
    }
}

class Rectangle implements TwoDimensionalShape {
    @Override
    public void area() {
        System.out.println("Rectangle Area");
    }
}

class Cube implements ThreeDimensionalShape {
    @Override
    public void area() {
        System.out.println("Cube Area");
    }

    @Override
    public void volume() {
        System.out.println("Cube Volume");
    }
}