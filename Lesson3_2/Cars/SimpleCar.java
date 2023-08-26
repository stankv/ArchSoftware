package Lesson3_2.Cars;

import Lesson3_2.FeaturesCar.CarBodyType;
import Lesson3_2.FeaturesCar.Color;
import Lesson3_2.FeaturesCar.GearboxType;
import Lesson3_2.Fuel.Fuel;

// 2. Создать конкретный автомобиль путём наследования класса «Car».
public class SimpleCar extends Car {

    public SimpleCar(String carBrand, String carModel, Color carColor, CarBodyType carBodyType, int numberOfWheels,
            Fuel fuelType, GearboxType gearboxType, double engineCapacity) {
        super(carBrand, carModel, carColor, carBodyType, numberOfWheels, fuelType, gearboxType, engineCapacity);
    }
    
}
