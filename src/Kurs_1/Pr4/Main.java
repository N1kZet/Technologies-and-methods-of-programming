package Pr4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Automobile {
    protected String brand;
    protected int year;
    protected double price;
    protected String configuration;
    protected String countryOfOrigin;
    protected LocalDate saleDate;
    protected String buyerName;

    public Automobile(String brand, int year, double price, String configuration,
                      String countryOfOrigin, LocalDate saleDate, String buyerName) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.configuration = configuration;
        this.countryOfOrigin = countryOfOrigin;
        this.saleDate = saleDate;
        this.buyerName = buyerName;
    }

    @Override
    public String toString() {
        return String.format("Марка: %s\nГод выпуска: %d\nЦена: %.2f\nКомплектация: %s\nСтрана производитель: %s\nДата продажи: %s\nПокупатель: %s",
                brand, year, price, configuration, countryOfOrigin, saleDate, buyerName);
    }
}

class UsedCar extends Automobile {
    private String condition;//состояние автомобиля
    private String ownerName;//имя владельца
    private int mileage;//пробег

    public UsedCar(String brand, int year, double price, String configuration,
                    String countryOfOrigin,LocalDate saleDate, String buyerName, String condition, String ownerName, int mileage) {
        super(brand, year, price, configuration, countryOfOrigin, saleDate, buyerName);
        this.condition = condition;
        this.ownerName = ownerName;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nСостояние: %s\nВладелец: %s\nПробег: %d км", condition, ownerName, mileage);
    }
}

class SportsCar extends Automobile {
    private double acceleration;//время разгона до 100 км/ч
    private double engineVolume;//объем двигателя
    private int power;//мощность

    public SportsCar(String brand, int year, double price, String configuration, String countryOfOrigin,
                     LocalDate saleDate, String buyerName, double acceleration, double engineVolume, int power) {
        super(brand, year, price, configuration, countryOfOrigin, saleDate, buyerName);
        this.acceleration = acceleration;
        this.engineVolume = engineVolume;
        this.power = power;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nРазгон до 100 км/ч: %.1f сек\nОбъем двигателя: %.1f л\nМощность: %d л.с.", acceleration, engineVolume, power);
    }
}

class SpecialEquipment extends Automobile {
    private String type;//тип техники
    private double weight;//вес
    private String dimensions;//габариты

    public SpecialEquipment(String brand, int year, double price, String configuration, String countryOfOrigin,
                            LocalDate saleDate, String buyerName, String type, double weight, String dimensions) {
        super(brand, year, price, configuration, countryOfOrigin, saleDate, buyerName);
        this.type = type;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("\nТип: %s\nМасса: %.2f т\nГабариты: %s", type, weight, dimensions);
    }
}

class CarSales {
    private List<Automobile> soldCars = new ArrayList<>();

    public void addCar(Automobile car) {
        soldCars.add(car);
    }

    public void printSales() {
        for (Automobile car : soldCars) {
            System.out.println(car);
            System.out.println("----------------------");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CarSales sales = new CarSales();

        sales.addCar(new UsedCar("Toyota", 2018, 20000.0, "Standard", "Japan", LocalDate.of(2023, 5, 10), "Иван Иванов", "Хорошее", "Петров Петр", 50000));
        sales.addCar(new SportsCar("Ferrari", 2022, 250000.0, "Luxury", "Italy", LocalDate.of(2023, 6, 20), "Сидоров Алексей", 2.9, 4.0, 670));
        sales.addCar(new SpecialEquipment("Caterpillar", 2020, 120000.0, "Heavy Duty", "USA", LocalDate.of(2023, 7, 15), "Кузнецов Олег", "Строительная", 15.0, "10x3x3 м"));

        sales.printSales();
    }
}
