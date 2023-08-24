package Lesson3_1.OCP;

public class Main {

    public static void main(String[] args) {
        
        Car car = new Car(160, "car");
        System.out.println(car.calculateAllowedSpeed());

        Bus bus = new Bus(110,"bus");
        System.out.println(bus.calculateAllowedSpeed());
    }
    
}
