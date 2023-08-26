package Lesson3_2.Cars;

import Lesson3_2.FeaturesCar.CarBodyType;
import Lesson3_2.FeaturesCar.Color;
import Lesson3_2.FeaturesCar.GearboxType;
import Lesson3_2.Fuel.Fuel;

/*
 * 3. Расширить абстрактный класс «Car», добавить метод: подметать улицу. Создать конкретный автомобиль 
 * путём наследования класса «Car». Провести проверку принципа SRP.
 */
public class SweepingCar extends Car {

    public SweepingCar(String carBrand, String carModel, Color carColor, CarBodyType carBodyType, int numberOfWheels,
            Fuel fuelType, GearboxType gearboxType, double engineCapacity) {
        super(carBrand, carModel, carColor, carBodyType, numberOfWheels, fuelType, gearboxType, engineCapacity);
    }

    public void toSweep(boolean toSwitch) {
        if (toSwitch) System.out.println("Подметание включено");
        else System.out.println("Подметание выключено");
    }

    @Override
    public String toString() {
        return "SweepingCar{" +
                "carBrand='" + getCarBrand() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", carBodyType='" + getCarBodyType() + '\'' +
                '}';
    }
    
}
