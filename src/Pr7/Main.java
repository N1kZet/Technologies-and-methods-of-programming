package Pr7;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.Scanner;

class Automobile implements Serializable {
    private static final long serialVersionUID = 1L;
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
    private static final String FILE_NAME = "car_sales.dat";

    public void addCar(Automobile car) {
        soldCars.add(car);
        saveToFile();
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

    public void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(soldCars);
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении данных: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public void loadFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            soldCars = (List<Automobile>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке данных: " + e.getMessage());
        }
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarSales sales = new CarSales();

    public static void main(String[] args) {
        sales.loadFromFile();
        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Добавить автомобиль");
            System.out.println("2. Вывести список автомобилей (сортировка по марке)");
            System.out.println("3. Вывести список автомобилей (сортировка по цене)");
            System.out.println("4. Сохранить данные в файл");
            System.out.println("5. Загрузить данные из файла");
            System.out.println("6. Выход");
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
                    sales.saveToFile();
                    System.out.println("Данные сохранены в файл.");
                    break;
                case 5:
                    sales.loadFromFile();
                    System.out.println("Данные загружены из файла.");
                    break;
                case 6:
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
