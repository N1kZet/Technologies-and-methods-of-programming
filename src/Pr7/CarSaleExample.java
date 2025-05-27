package Pr7;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

abstract class Car implements Serializable {
    protected String brand;
    protected int year;
    protected double price;
    protected String комплектация;
    protected String country;
    protected LocalDate saleDate;
    protected String customerFullName;

    protected Car(String brand, int year, double price, String комплектация, 
                 String country, LocalDate saleDate, String customerFullName) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.комплектация = комплектация;
        this.country = country;
        this.saleDate = saleDate;
        this.customerFullName = customerFullName;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return String.format("%s (Year: %d, Price: %.2f, Country: %s, Sale Date: %s)", 
            brand, year, price, country, saleDate);
    }
}

class UsedCar extends Car {
    private final String condition;
    private final int mileage;

    public UsedCar(String brand, int year, double price, String комплектация, 
                   String country, LocalDate saleDate, String customerFullName, 
                   String condition, int mileage) {
        super(brand, year, price, комплектация, country, saleDate, customerFullName);
        this.condition = condition;
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return String.format("Used %s (Condition: %s, Mileage: %d)", 
            super.toString(), condition, mileage);
    }
}

class SportsCar extends Car {
    private final double accelerationTime;
    private final int horsepower;

    public SportsCar(String brand, int year, double price, String комплектация, 
                    String country, LocalDate saleDate, String customerFullName, 
                    double accelerationTime, int horsepower) {
        super(brand, year, price, комплектация, country, saleDate, customerFullName);
        this.accelerationTime = accelerationTime;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return String.format("Sports %s (0-100: %.1fs, HP: %d)", 
            super.toString(), accelerationTime, horsepower);
    }
}

class SpecialEquipment extends Car {
    private final String type;
    private final double weight;

    public SpecialEquipment(String brand, int year, double price, String комплектация, 
                           String country, LocalDate saleDate, String customerFullName, 
                           String type, double weight) {
        super(brand, year, price, комплектация, country, saleDate, customerFullName);
        this.type = type;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.format("Special %s (Type: %s, Weight: %.1f kg)", 
            super.toString(), type, weight);
    }
}

class CarSalesList implements Serializable {
    private final List<Car> cars = new ArrayList<>();

    public void addCar(Car car) { cars.add(car); }
    public List<Car> getCars() { return cars; }
    
    public void sortByBrand() {
        cars.sort(Comparator.comparing(Car::getBrand));
    }
    
    public void sortByPrice() {
        cars.sort(Comparator.comparing(Car::getPrice));
    }

    public void printCars() {
        cars.forEach(System.out::println);
    }
}

public class CarSaleExample {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILE = "cars.dat";

    public static void main(String[] args) {
        CarSalesList salesList = new CarSalesList();
        loadData(salesList);

        while (true) {
            System.out.println("\n1. Add Car | 2. Sort by Brand | 3. Sort by Price | " +
                             "4. Save | 5. Load | 0. Exit");
            System.out.print("Choose action: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 0) break;

            switch (choice) {
                case 1 -> addCar(salesList);
                case 2 -> { salesList.sortByBrand(); salesList.printCars(); }
                case 3 -> { salesList.sortByPrice(); salesList.printCars(); }
                case 4 -> saveData(salesList);
                case 5 -> loadData(salesList);
                default -> System.out.println("Invalid choice");
            }
        }

        saveData(salesList);
        scanner.close();
    }

    private static void addCar(CarSalesList salesList) {
        System.out.println("Car type: 1. Used | 2. Sports | 3. Special Equipment");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Brand: ");
        String brand = scanner.nextLine();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.print("Configuration: ");
        String config = scanner.nextLine();
        System.out.print("Country: ");
        String country = scanner.nextLine();
        System.out.print("Sale date (YYYY-MM-DD): ");
        LocalDate saleDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Customer name: ");
        String customer = scanner.nextLine();

        Car car = switch (type) {
            case 1 -> {
                System.out.print("Condition: ");
                String condition = scanner.nextLine();
                System.out.print("Mileage: ");
                int mileage = scanner.nextInt();
                yield new UsedCar(brand, year, price, config, country, saleDate, 
                                customer, condition, mileage);
            }
            case 2 -> {
                System.out.print("Acceleration (0-100): ");
                double acc = scanner.nextDouble();
                System.out.print("Horsepower: ");
                int hp = scanner.nextInt();
                yield new SportsCar(brand, year, price, config, country, saleDate, 
                                  customer, acc, hp);
            }
            case 3 -> {
                System.out.print("Type: ");
                String equipType = scanner.nextLine();
                System.out.print("Weight: ");
                double weight = scanner.nextDouble();
                yield new SpecialEquipment(brand, year, price, config, country, 
                                         saleDate, customer, equipType, weight);
            }
            default -> throw new IllegalArgumentException("Invalid car type");
        };

        salesList.addCar(car);
        System.out.println("Car added successfully!");
    }

    private static void saveData(CarSalesList salesList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(salesList.getCars());
            System.out.println("Data saved successfully");
        } catch (IOException e) {
            System.err.println("Error saving data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadData(CarSalesList salesList) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            salesList.getCars().clear();
            salesList.getCars().addAll((List<Car>) ois.readObject());
            System.out.println("Data loaded successfully");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }
}
