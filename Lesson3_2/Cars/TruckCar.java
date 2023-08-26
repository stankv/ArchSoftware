package Lesson3_2.Cars;

import Lesson3_2.FeaturesCar.CarBodyType;
import Lesson3_2.FeaturesCar.Color;
import Lesson3_2.FeaturesCar.GearboxType;
import Lesson3_2.Fuel.Fuel;

// Расширить абстрактный класс «Car», добавить метод: включение противотуманных фар, перевозка груза. 
// Провести проверку принципа OCP.
public class TruckCar extends Car {

    public TruckCar(String carBrand, String carModel, Color carColor, CarBodyType carBodyType, int numberOfWheels,
            Fuel fuelType, GearboxType gearboxType, double engineCapacity) {
        super(carBrand, carModel, carColor, carBodyType, numberOfWheels, fuelType, gearboxType, engineCapacity);
    }

    public void fogLights(boolean toSwitch) {
        if(toSwitch) System.out.println("Противотуманки включены");
        else System.out.println("Противотуманки выключены");
    }

    public void carryCargo(boolean toSwitch) {
        if(toSwitch) System.out.println("Перевозка груза");
        else System.out.println("Груза нет");
    }

    @Override
    public String toString() {
        return "TruckCar{" +
                "carBrand='" + getCarBrand() + '\'' +
                ", carModel='" + getCarModel() + '\'' +
                ", carBodyType='" + getCarBodyType() + '\'' +
                '}';
    }
    
}
