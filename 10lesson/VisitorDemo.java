public class VisitorDemo {
    public static void main(final String[] args) {
        Car car = new Car();
        
        System.out.println("=== Print Visitor ===");
        car.accept(new CarElementPrintVisitor());
        
        System.out.println("\n=== Do Visitor ===");
        car.accept(new CarElementDoVisitor());
    }
}