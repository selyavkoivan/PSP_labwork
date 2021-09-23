import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        Bus bus = new Bus(42, "МАЗ", "карбюраторный", 212, 5120, 512424);
        Truck truck = new Truck(24.2, "закрытый", "MAN", "карбюраторный", 523, 8123, 1040354);
        Minivan minivan = new Minivan(12, 23.4, "Шкода", "карбюраторный", 87, 3201, 123456);
        PickUp pickUp = new PickUp(22, 15.4, "Ford", "карбюраторный", 312, 3201, 123456);

        bus.print();
        truck.print();
        minivan.print();
        pickUp.print();

    }


}

interface Car
{
    String carBrand = " ";
    String engineType = " ";
    int power = 0;
    int weight = 0;
    int mileage = 0;

    public abstract void brand();

    public String getCarBrand();
    public String getEngineType();
    public int getPower();
    public int getWeight();
    public int getMileage();

}

interface Object
{

    void print();
}
class Bus implements Object, Car {

    private int numberOfSeats;
    protected String carBrand;
    protected String engineType;
    protected int power;
    protected int weight;
    protected int mileage;

    public Bus() {}
    public Bus(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
    public Bus(int numberOfSeats, String carBrand, String engineType, int power, int weight, int mileage) {
        this.numberOfSeats = numberOfSeats;
        this.carBrand = carBrand;
        this.engineType = engineType;
        this.power = power;
        this.weight = weight;
        this.mileage = mileage;
    }

    public void brand()
    {
        System.out.println("Марка автобуса : " + carBrand);
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    public int getMileage() {
        return mileage;
    }

    public void print()
    {
        System.out.println("\n\n--- АВТОБУС ---");
        brand();
        System.out.println("Тип двигателя : " + getEngineType());
        System.out.println("Мощность : " + getPower() + "л/с");
        System.out.println("Вес : " + getWeight() + "кг");
        System.out.println("Пробег : " + getMileage() + "км");
        System.out.println("Количество мест : " + getNumberOfSeats());
    }
}

class Truck implements Object, Car {
    private double carryingCapacity;
    private String bodyType;
    protected String carBrand;
    protected String engineType;
    protected int power;
    protected int weight;
    protected int mileage;

    public Truck() {}
    public Truck(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }
    public Truck(double carryingCapacity, String bodyType, String carBrand, String engineType, int power, int weight, int mileage) {
        this.carryingCapacity = carryingCapacity;
        this.bodyType = bodyType;
        this.carBrand = carBrand;
        this.engineType = engineType;
        this.power = power;
        this.weight = weight;
        this.mileage = mileage;
    }

    public void brand()
    {
        System.out.println("Марка грузового автомобиля : " + carBrand);
    }

    public double getCarryingCapacity() {
        return carryingCapacity;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }
    public String getCarBrand() {
        return carBrand;
    }

    public String getEngineType() {
        return engineType;
    }

    public int getPower() {
        return power;
    }

    public int getWeight() {
        return weight;
    }

    public int getMileage() {
        return mileage;
    }

    public void print()
    {
        System.out.println("\n\n--- ГРУЗОВИК ---");
        brand();
        System.out.println("Тип двигателя : " + getEngineType());
        System.out.println("Мощность : " + getPower() + "л/с");
        System.out.println("Вес : " + getWeight() + "кг");
        System.out.println("Пробег : " + getMileage() + "км");
        System.out.println("Грузоподъемность : " + carryingCapacity + "т");
        System.out.println("Тип кузова : " + bodyType);
    }

}


abstract class PassengerCar implements Object, Car {
    protected double fuelConsumption;
    protected double acceleration;
    protected String carBrand;
    protected String engineType;
    protected int power;
    protected int weight;
    protected int mileage;

    public PassengerCar() {}
    public PassengerCar(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public PassengerCar(double fuelConsumption, double acceleration, String carBrand, String engineType, int power, int weight, int mileage) {
        this.fuelConsumption = fuelConsumption;
        this.acceleration = acceleration;
        this.carBrand = carBrand;
        this.engineType = engineType;
        this.power = power;
        this.weight = weight;
        this.mileage = mileage;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public double getAcceleration() {
        return acceleration;
    }

    @java.lang.Override
    public String getCarBrand() {
        return carBrand;
    }

    @java.lang.Override
    public String getEngineType() {
        return engineType;
    }

    @java.lang.Override
    public int getPower() {
        return power;
    }

    @java.lang.Override
    public int getWeight() {
        return weight;
    }

    @java.lang.Override
    public int getMileage() {
        return mileage;
    }

    public void brand()
    {
        System.out.println("Марка легкового автомобиля : " + carBrand);
    }

}

class Minivan extends PassengerCar {// класс-наследник класса треугольник, который реализует 2 интерфейса

    public Minivan(double fuelConsumption, double acceleration, String carBrand, String engineType, int power, int weight, int mileage) {
        super(fuelConsumption, acceleration, carBrand, engineType, power, weight, mileage);
    }
    public void print() {
        System.out.println("\n\n--- МИНИВЕН ---");
        brand();
        System.out.println("Тип двигателя : " + getEngineType());
        System.out.println("Мощность : " + getPower() + "л/с");
        System.out.println("Вес : " + getWeight() + "кг");
        System.out.println("Пробег : " + getMileage() + "км");
        System.out.println("Расход топлива на 100км : " + getFuelConsumption() + "л");
        System.out.println("Разгон до 100 км/ч : " + getAcceleration() + "с");
    }

    public void brand() {
        System.out.println("Марка минивена : " + carBrand);
    }
}

class PickUp extends PassengerCar {// класс-наследник класса треугольник, который реализует 2 интерфейса

    public PickUp(double fuelConsumption, double acceleration, String carBrand, String engineType, int power, int weight, int mileage) {
        super(fuelConsumption, acceleration, carBrand, engineType, power, weight, mileage);
    }
    public void print() {
        System.out.println("\n\n--- ПИКАП ---");
        brand();
        System.out.println("Тип двигателя : " + getEngineType());
        System.out.println("Мощность : " + getPower() + "л/с");
        System.out.println("Вес : " + getWeight() + "кг");
        System.out.println("Пробег : " + getMileage() + "км");
        System.out.println("Расход топлива на 100км : " + getFuelConsumption() + "л");
        System.out.println("Разгон до 100 км/ч : " + getAcceleration() + "с");
    }

    public void brand() {
        System.out.println("ПИКАП минивена : " + carBrand);
    }
}
