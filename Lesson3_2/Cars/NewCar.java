package Lesson3_2.Cars;

import Lesson3_2.FeaturesCar.CarBodyType;
import Lesson3_2.FeaturesCar.Color;
import Lesson3_2.FeaturesCar.GearboxType;
import Lesson3_2.Fuel.Fuel;
import Lesson3_2.Service.IFuellingStation;
import Lesson3_2.Service.IWashStation;

// 7. Создать интерфейс «Заправочная станция», создать метод: заправка топливом.
// 8. Имплементировать метод интерфейса «Заправочная станция» в конкретный класс «Car».
// 9. Добавить в интерфейс «Заправочная станция» методы: протирка лобового стекла, протирка фар, протирка зеркал.
// 10. Имплементировать все методы интерфейса «Заправочная станция» в конкретный класс «Car». Провести проверку принципа ISP. 
// Создать дополнительный/е интерфейсы и имплементировать их в конкретный класс «Car». Провести проверку принципа ISP.
public class NewCar extends Car implements IFuellingStation, IWashStation {

    public NewCar(String carBrand, String carModel, Color carColor, CarBodyType carBodyType, int numberOfWheels,
            Fuel fuelType, GearboxType gearboxType, double engineCapacity) {
        super(carBrand, carModel, carColor, carBodyType, numberOfWheels, fuelType, gearboxType, engineCapacity);
    }

    @Override
    public void fuelling() {
        System.out.println("Заправили полный бак " + getFuelType());
    }

    @Override
    public void wipeTheWindshield() {
        System.out.println("Помыли лобовое стекло");
    }

    @Override
    public void wipeHeadlights() {
        System.out.println("Протерли фары");
    }

    @Override
    public void wipeMirrors() {
        System.out.println("Протерли зеркала");
    }

    @Override
    public String toString() {
        return "NewCar{" +
        "carBrand='" + getCarBrand() + '\'' +
        ", carModel='" + getCarModel() + '\'' +
        ", carBodyType='" + getCarBodyType() + '\'' +
        ", carFuelType='" + getFuelType() + '\'' +
        '}';
    }
    
}
