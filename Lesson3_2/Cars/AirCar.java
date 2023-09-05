package Lesson3_2.Cars;

import Lesson3_2.FeaturesCar.CarBodyType;
import Lesson3_2.FeaturesCar.Color;
import Lesson3_2.FeaturesCar.GearboxType;
import Lesson3_2.Fuel.Fuel;

// 5. Создать конкретный автомобиль путём наследования класса «Car», определить число колёс = 3. Провести проверку принципа LSP.
// 6. Создать конкретный автомобиль путём наследования класса «Car», определить метод «движение»-«полёт». 
// Провести проверку принципа LSP.
public class AirCar extends Car {

    public AirCar(String carBrand, String carModel, Color carColor, CarBodyType carBodyType, int numberOfWheels,
            Fuel fuelType, GearboxType gearboxType, double engineCapacity) {
        super(carBrand, carModel, carColor, carBodyType, numberOfWheels, fuelType, gearboxType, engineCapacity);
    }

    public String carFly(boolean fly) {
        if (fly) return "Летим";
        return "Стоим";
    }
    
    @Override
    public String toString() {
        return "AirCar{" +
                "carBrand='" + getCarBrand() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", carBodyType='" + getCarBodyType() + '\'' +
                '}';
    }
}
