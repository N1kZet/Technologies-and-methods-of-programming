package Pr6;

import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

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

class CarSales {
    private List<Automobile> soldCars = new ArrayList<>();

    public void addCar(Automobile car) {
        soldCars.add(car);
    }

    public void sortByBrand() {
        soldCars.sort(Comparator.comparing(car -> car.brand));
    }

    public void sortByPrice() {
        soldCars.sort(Comparator.comparingDouble(car -> car.price));
    }

    public void printSales() {
        for (Automobile car : soldCars) {
            System.out.println(car);
            System.out.println("----------------------");
        }
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarSales sales = new CarSales();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить автомобиль");
            System.out.println("2. Вывести список автомобилей (сортировка по марке)");
            System.out.println("3. Вывести список автомобилей (сортировка по цене)");
            System.out.println("4. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addCar();
                    break;
                case 2:
                    sales.sortByBrand();
                    sales.printSales();
                    break;
                case 3:
                    sales.sortByPrice();
                    sales.printSales();
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный ввод, попробуйте снова.");
            }
        }
    }

    private static void addCar() {
        System.out.print("Введите марку автомобиля: ");
        String brand = scanner.nextLine();
        System.out.print("Введите год выпуска: ");
        int year = scanner.nextInt();
        System.out.print("Введите цену: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.print("Введите комплектацию: ");
        String configuration = scanner.nextLine();
        System.out.print("Введите страну производитель: ");
        String country = scanner.nextLine();
        System.out.print("Введите дату продажи (ГГГГ-ММ-ДД): ");
        LocalDate saleDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Введите ФИО покупателя: ");
        String buyer = scanner.nextLine();
        
        sales.addCar(new Automobile(brand, year, price, configuration, country, saleDate, buyer));
        System.out.println("Автомобиль успешно добавлен!");
    }
}
