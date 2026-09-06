public class PreConditionMethodRule {
    public static void main(String[] args) {
        // Overridden Method Should Be The Same Or More Weaker
        // But Not More Constraint
        ParentClass object = new ChildClass();
        // ParentClass object = new ParentClass();

        object.check(20); // Valid Number
        object.check(21); // Valid Number
        object.check(31); // Invalid Number
    }
}

class ParentClass {
    void check(int num) {
        if (num < 0 || num > 20) {
            System.out.println(num + " Invalid Number");
            return;
        }
        System.out.println(num + " Valid Number");
    }
}

class ChildClass extends ParentClass {
    @Override
    void check(int num) {
        if (num < 0 || num > 30) {
            System.out.println(num + " Invalid Number");
            return;
        }
        System.out.println(num + " Valid Number");
    }
}