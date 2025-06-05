import java.util.List;

interface CarElement {
    void accept(CarElementVisitor visitor);
}

interface CarElementVisitor {
    void visit(Body body);
    void visit(Car car);
    void visit(Engine engine);
    void visit(Wheel wheel);
    void visit(CarAudio carAudio);
}

class Wheel implements CarElement {
    private final String name;

    public Wheel(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Body implements CarElement {
    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Engine implements CarElement {
    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class CarAudio implements CarElement {
    private final String brand;
    private final int speakers;

    public CarAudio(final String brand, final int speakers) {
        this.brand = brand;
        this.speakers = speakers;
    }

    public String getBrand() {
        return brand;
    }

    public int getSpeakers() {
        return speakers;
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        visitor.visit(this);
    }
}

class Car implements CarElement {
    private final List<CarElement> elements;

    public Car() {
        this.elements = List.of(
            new Wheel("front left"), new Wheel("front right"),
            new Wheel("back left"), new Wheel("back right"),
            new Body(), new Engine(),
            new CarAudio("Pioneer", 6)
        );
    }

    @Override
    public void accept(CarElementVisitor visitor) {
        for (CarElement element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}

class CarElementDoVisitor implements CarElementVisitor {
    @Override
    public void visit(Body body) {
        System.out.println("Moving my body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Starting my car");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Kicking my " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Starting my engine");
    }

    @Override
    public void visit(CarAudio carAudio) {
        System.out.println("Turning on my " + carAudio.getBrand() + 
                         " audio system with " + carAudio.getSpeakers() + " speakers");
    }
}

class CarElementPrintVisitor implements CarElementVisitor {
    @Override
    public void visit(Body body) {
        System.out.println("Visiting body");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Visiting car");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Visiting engine");
    }

    @Override
    public void visit(Wheel wheel) {
        System.out.println("Visiting " + wheel.getName() + " wheel");
    }

    @Override
    public void visit(CarAudio carAudio) {
        System.out.println("Visiting " + carAudio.getBrand() + 
                         " audio system (" + carAudio.getSpeakers() + " speakers)");
    }
}

public class VisitorDemo {
    public static void main(final String[] args) {
        Car car = new Car();
        
        System.out.println("=== Print Visitor ===");
        car.accept(new CarElementPrintVisitor());
        
        System.out.println("\n=== Do Visitor ===");
        car.accept(new CarElementDoVisitor());
    }
}