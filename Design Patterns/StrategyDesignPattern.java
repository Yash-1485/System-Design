public class StrategyDesignPattern {
    public static void main(String[] args) {
        // System.out.println("Hello World!");

        Robot cr = new CompanionRobot(new NormalTalk(), new NormalWalk(), new NoFly());
        Robot hr = new HelperRobot(new NormalTalk(), new NoWalk(), new NormalFly());

        System.out.println("--------------------------------------");
        System.out.println("Companion Robot");
        System.out.println("--------------------------------------");
        cr.projection();
        cr.talk();
        cr.walk();
        cr.fly();
        System.out.println("--------------------------------------");

        System.out.println("--------------------------------------");
        System.out.println("Helper Robot");
        System.out.println("--------------------------------------");
        hr.projection();
        hr.talk();
        hr.walk();
        hr.fly();
        System.out.println("--------------------------------------");

    }
}

// ---------------------------------------------
// Abstract Class
// ---------------------------------------------
abstract class Robot {
    Talkable t;
    Walkable w;
    Flyable f;

    Robot(Talkable t, Walkable w, Flyable f) {
        this.t = t;
        this.w = w;
        this.f = f;
    }

    abstract void projection();

    void talk() {
        t.talk();
    }

    void walk() {
        w.walk();
    }

    void fly() {
        f.fly();
    }
}
// ---------------------------------------------

// ---------------------------------------------
// Talkables
// ---------------------------------------------
interface Talkable {
    void talk();
}

class NormalTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Normal Talk");
    }
}

class NoTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("No Talk");
    }
}
// ---------------------------------------------

// ---------------------------------------------
// Walkables
// ---------------------------------------------
interface Walkable {
    void walk();
}

class NormalWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("Normal Walk");
    }
}

class NoWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("No Walk");
    }
}
// ---------------------------------------------

// ---------------------------------------------
// Flayables
// ---------------------------------------------
interface Flyable {
    void fly();
}

class NormalFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("Normal Fly");
    }
}

class NoFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("No Fly");
    }
}
// ---------------------------------------------

// ---------------------------------------------
// Child Classes
// ---------------------------------------------
class CompanionRobot extends Robot {

    CompanionRobot(Talkable t, Walkable w, Flyable f) {
        super(t, w, f);
    }

    @Override
    void projection() {
        System.out.println("Companion Robot");
    }
}

class HelperRobot extends Robot {

    HelperRobot(Talkable t, Walkable w, Flyable f) {
        super(t, w, f);
    }

    @Override
    void projection() {
        System.out.println("Helper Robot");
    }
}
// ---------------------------------------------