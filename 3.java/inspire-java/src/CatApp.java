import lgcns.Car;

public class CatApp {
    
    public static void main(String[] args) {
        
        Car car = new Car("911", "Porshe", 50000);
        
        car.drive();
        
        System.out.println(car.repair());

        car.performance("full");

        System.out.println(500);
        
        System.out.println(car.dreamCarInfo());
    }
}
