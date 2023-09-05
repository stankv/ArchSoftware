package Lesson3_2.Cars;

import Lesson3_2.FeaturesCar.CarBodyType;
import Lesson3_2.FeaturesCar.Color;
import Lesson3_2.FeaturesCar.GearboxType;
import Lesson3_2.Fuel.Fuel;

/*
 * 1. Спроектировать абстрактный класс «Car» у которого должны быть свойства: марка, модель, цвет, тип кузова, 
 * число колёс, тип топлива, тип коробки передач, объём двигателя; методы: движение, обслуживание, переключение передач, 
 * включение фар, включение дворников.
 */
public abstract class Car {
    private String carBrand;
    private String carModel;
    private Color carColor;
    private CarBodyType carBodyType;
    private int numberOfWheels;
    private Fuel fuelType;
    private GearboxType gearboxType;
    private double engineCapacity;

    public Car(String carBrand, String carModel, Color carColor, CarBodyType carBodyType, int numberOfWheels, Fuel fuelType, GearboxType gearboxType, double engineCapacity) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carBodyType = carBodyType;
        this.numberOfWheels = numberOfWheels;
        this.fuelType = fuelType;
        this.gearboxType = gearboxType;
        this.engineCapacity = engineCapacity;
    }

    public String getCarBrand() {
        return this.carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Color getCarColor() {
        return this.carColor;
    }

    public void setCarColor(Color carColor) {
        this.carColor = carColor;
    }

    public CarBodyType getCarBodyType() {
        return this.carBodyType;
    }

    public void setCarBodyType(CarBodyType carBodyType){
        this.carBodyType = carBodyType;
    }

    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }

    public void setNumberOfWheels(int numberOfWheels) {
        this.numberOfWheels = numberOfWheels;
    }

    public Fuel getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(Fuel fuelType) {
        this.fuelType = fuelType;
    }

    public GearboxType getGearboxType() {
        return this.gearboxType;
    }

    public void setGearBoxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public double getEngineCapacity() {
        return this.engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    // движение, обслуживание, переключение передач, включение фар, включение дворников.

    public String carDrive(boolean carMove) {
        if (carMove) return "Едем";
        return "Стоим";
    }

    public String carService(String toDo) {
        return toDo;
    }

    public int carGearShift(int gear) {
        return gear;
    }

    public String switchHeadlights(boolean headlightState) {
        if (headlightState) return "Фары включены";
        return "Фары выключены";
    }

    public String switchWindshieldWipers(boolean windshieldWipersState) {
        if (windshieldWipersState) return "Дворники включены";
        return "Дворники выключены";
    }

    @Override
    public String toString() {
        return "Car{" +
                "carBrand='" + carBrand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", carBodyType='" + carBodyType + '\'' +
                '}';
    }

}
