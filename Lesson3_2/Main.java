package Lesson3_2;

import Lesson3_2.Cars.AirCar;
import Lesson3_2.Cars.NewCar;
import Lesson3_2.Cars.SimpleCar;
import Lesson3_2.Cars.SweepingCar;
import Lesson3_2.Cars.TruckCar;
import Lesson3_2.FeaturesCar.CarBodyType;
import Lesson3_2.FeaturesCar.Color;
import Lesson3_2.FeaturesCar.GearboxType;
import Lesson3_2.Fuel.Fuel;

public class Main {

    public static void main(String[] args) {
        
        // 2. Создать конкретный автомобиль путём наследования класса «Car».
        SimpleCar renault = new SimpleCar("Renault", "Sandero", Color.Green, CarBodyType.Hatchback, 4, Fuel.Petrol, GearboxType.AKPP, 1.6);
        System.out.println(renault);
        System.out.println(renault.carDrive(true));

        // 3. Расширить абстрактный класс «Car», добавить метод: подметать улицу. Создать конкретный автомобиль 
        // путём наследования класса «Car». Провести проверку принципа SRP.
        SweepingCar sweeper = new SweepingCar("Sweeper", "ММК-1500", Color.Yello, CarBodyType.Truck, 4, Fuel.Diesel, GearboxType.MKPP, 2.45);
        System.out.println(sweeper);
        System.out.print(sweeper.carDrive(true) + " ");
        sweeper.toSweep(true);

        // 4. Расширить абстрактный класс «Car», добавить метод: включение противотуманных фар, перевозка груза. 
        // Провести проверку принципа OCP.
        TruckCar truck = new TruckCar("ГАЗ", "Садко", Color.Green, CarBodyType.Truck, 4, Fuel.Petrol, GearboxType.MKPP, 4.67);
        System.out.println(truck);
        truck.fogLights(true);
        truck.carryCargo(true);

        // 5. Создать конкретный автомобиль путём наследования класса «Car», определить число колёс = 3. Провести проверку принципа LSP.
        // 6. Создать конкретный автомобиль путём наследования класса «Car», определить метод «движение»-«полёт». 
        // Провести проверку принципа LSP.
        AirCar airCar = new AirCar("Renault", "Sandero", Color.Green, CarBodyType.Hatchback, 3, Fuel.Petrol, GearboxType.AKPP, 1.6);
        System.out.println(airCar);
        System.out.println(airCar.carFly(true));
        System.out.println(airCar.carFly(false));
        System.out.println(airCar.carDrive(true));

        // 7. Создать интерфейс «Заправочная станция», создать метод: заправка топливом.
        // 8. Имплементировать метод интерфейса «Заправочная станция» в конкретный класс «Car».
        // 9. Добавить в интерфейс «Заправочная станция» методы: протирка лобового стекла, протирка фар, протирка зеркал.
        // 10. Имплементировать все методы интерфейса «Заправочная станция» в конкретный класс «Car». Провести проверку принципа ISP. 
        // Создать дополнительный/е интерфейсы и имплементировать их в конкретный класс «Car». Провести проверку принципа ISP.
        NewCar newCar = new NewCar("Renault", "Sandero", Color.Green, CarBodyType.Hatchback, 4, Fuel.Gas, GearboxType.AKPP, 1.6);
        System.out.println(newCar);
        newCar.fuelling();
        newCar.wipeTheWindshield();
        newCar.wipeHeadlights();
        newCar.wipeMirrors();
        System.out.println(newCar.carDrive(true));

        // 11. Создать путём наследования класса «Car» два автомобиля: с бензиновым и дизельным двигателями, 
        // имплементировать метод «Заправка топливом» интерфейса «Заправочная станция». Реализовать заправку каждого автомобиля 
        // подходящим топливом. Провести проверку принципа DIP.
        NewCar car1 = new NewCar("Renault", "Sandero", Color.Green, CarBodyType.Hatchback, 4, Fuel.Petrol, GearboxType.AKPP, 1.6);
        NewCar car2 = new NewCar("Renault", "Sandero", Color.Green, CarBodyType.Hatchback, 4, Fuel.Diesel, GearboxType.AKPP, 1.6);
        System.out.println(car1);
        car1.fuelling();
        System.out.println(car2);
        car2.fuelling();
    }
    
}