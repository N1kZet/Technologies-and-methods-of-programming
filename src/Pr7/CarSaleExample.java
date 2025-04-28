package Pr7;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

// Родительский класс
class Car implements Serializable { // Implement Serializable
    private String brand;
    private int year;
    private double price;
    private String комплектация; // Changed to комплектация to match Russian spelling
    private String country;
    private LocalDate saleDate;
    private String customerFullName;

    public Car(String brand, int year, double price, String комплектация, String country, LocalDate saleDate, String customerFullName) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.комплектация = комплектация;
        this.country = country;
        this.saleDate = saleDate;
        this.customerFullName = customerFullName;
    }

    // Геттеры и сеттеры для всех полей (для краткости показаны только для brand)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getКомплектация() {
        return комплектация;
    }

    public void setКомплектация(String комплектация) {
        this.комплектация = комплектация;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }
    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", комплектация='" + комплектация + '\'' +
                ", country='" + country + '\'' +
                ", saleDate=" + saleDate +
                ", customerFullName='" + customerFullName + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return year == car.year &&
                Double.compare(car.price, price) == 0 &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(комплектация, car.комплектация) &&
                Objects.equals(country, car.country) &&
                Objects.equals(saleDate, car.saleDate) &&
                Objects.equals(customerFullName, car.customerFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, year, price, комплектация, country, saleDate, customerFullName);
    }
}

// Дочерний класс "Поддержанные авто"
class UsedCar extends Car {
    private String condition; // степень сохранности
    private String previousOwnerFullName;
    private int mileage;

    public UsedCar(String brand, int year, double price, String комплектация, String country, LocalDate saleDate, String customerFullName, String condition, String previousOwnerFullName, int mileage) {
        super(brand, year, price, комплектация, country, saleDate, customerFullName);
        this.condition = condition;
        this.previousOwnerFullName = previousOwnerFullName;
        this.mileage = mileage;
    }

    // Геттеры и сеттеры для новых полей
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPreviousOwnerFullName() {
        return previousOwnerFullName;
    }

    public void setPreviousOwnerFullName(String previousOwnerFullName) {
        this.previousOwnerFullName = previousOwnerFullName;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
    @Override
    public String toString() {
        return "UsedCar{" +
                "condition='" + condition + '\'' +
                ", previousOwnerFullName='" + previousOwnerFullName + '\'' +
                ", mileage=" + mileage +
                "} " + super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UsedCar usedCar = (UsedCar) o;
        return mileage == usedCar.mileage && Objects.equals(condition, usedCar.condition) && Objects.equals(previousOwnerFullName, usedCar.previousOwnerFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), condition, previousOwnerFullName, mileage);
    }
}

// Дочерний класс "Спортивные"
class SportsCar extends Car {
    private double accelerationTime; // кол-во секунд до набора скорости
    private double engineCapacity; // объем двигателя
    private int horsepower; // мощность

    public SportsCar(String brand, int year, double price, String комплектация, String country, LocalDate saleDate, String customerFullName, double accelerationTime, double engineCapacity, int horsepower) {
        super(brand, year, price, комплектация, country, saleDate, customerFullName);
        this.accelerationTime = accelerationTime;
        this.engineCapacity = engineCapacity;
        this.horsepower = horsepower;
    }

    // Геттеры и сеттеры для новых полей
    public double getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(double engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(int horsepower) {
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "SportsCar{" +
                "accelerationTime=" + accelerationTime +
                ", engineCapacity=" + engineCapacity +
                ", horsepower=" + horsepower +
                "} " + super.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SportsCar sportsCar = (SportsCar) o;
        return Double.compare(sportsCar.accelerationTime, accelerationTime) == 0 && Double.compare(sportsCar.engineCapacity, engineCapacity) == 0 && horsepower == sportsCar.horsepower;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), accelerationTime, engineCapacity, horsepower);
    }
}

// Дочерний класс "Спецтехника"
class SpecialEquipment extends Car {
    private String type; // вид (строительная, грузовая, дорожная и т.д.)
    private double weight; // масса
    private String dimensions; // габаритные размеры

    public SpecialEquipment(String brand, int year, double price, String комплектация, String country, LocalDate saleDate, String customerFullName, String type, double weight, String dimensions) {
        super(brand, year, price, комплектация, country, saleDate, customerFullName);
        this.type = type;
        this.weight = weight;
        this.dimensions = dimensions;
    }

    // Геттеры и сеттеры для новых полей
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Override
    public String toString() {
        return "SpecialEquipment{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", dimensions='" + dimensions + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpecialEquipment that = (SpecialEquipment) o;
        return Double.compare(that.weight, weight) == 0 && Objects.equals(type, that.type) && Objects.equals(dimensions, that.dimensions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, weight, dimensions);
    }
}


// Класс для хранения списка проданных автомобилей
class CarSalesList {
    private List<Car> cars;

    public CarSalesList() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public void printCarList() {
        for (Car car : cars) {
            System.out.println(car);  // Используется переопределенный toString()
        }
    }

    // Сортировка по марке автомобиля
    public void sortByBrand() {
        Collections.sort(this.cars, Comparator.comparing(Car::getBrand));
    }

    // Сортировка по цене
    public void sortByPrice() {
        Collections.sort(this.cars, Comparator.comparing(Car::getPrice));
    }

    public List<Car> getCars() {
        return cars;
    }
}


// Пример использования
public class CarSaleExample {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String DATA_FILE = "cars.dat"; // File to store car data

    public static void main(String[] args) {
        CarSalesList salesList = new CarSalesList();
        int choice;

        // Load data from file on startup
        loadDataFromFile(salesList, DATA_FILE);

        do {
            printMenu();
            System.out.print("Выберите действие: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addCarToCollection(salesList);
                    break;
                case 2:
                    sortByBrandAndPrint(salesList);
                    break;
                case 3:
                    sortByPriceAndPrint(salesList);
                    break;
                case 4:
                    saveDataToFile(salesList, DATA_FILE);
                    break;
                case 5:
                    loadDataFromFile(salesList, DATA_FILE);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        } while (choice != 0);

        // Save data to file before exiting
        saveDataToFile(salesList, DATA_FILE);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить автомобиль");
        System.out.println("2. Вывести список автомобилей, отсортированный по марке");
        System.out.println("3. Вывести список автомобилей, отсортированный по цене");
        System.out.println("4. Сохранить данные в файл");
        System.out.println("5. Загрузить данные из файла");
        System.out.println("0. Выход");
    }

    private static void addCarToCollection(CarSalesList salesList) {
        System.out.println("Какой тип автомобиля вы хотите добавить?");
        System.out.println("1. Обычный автомобиль");
        System.out.println("2. Поддержанный автомобиль");
        System.out.println("3. Спортивный автомобиль");
        System.out.println("4. Спецтехника");

        int carType = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (carType) {
            case 1:
                salesList.addCar(createCarFromInput());
                break;
            case 2:
                salesList.addCar(createUsedCarFromInput());
                break;
            case 3:
                salesList.addCar(createSportsCarFromInput());
                break;
            case 4:
                salesList.addCar(createSpecialEquipmentFromInput());
                break;
            default:
                System.out.println("Неверный тип автомобиля.");
                return;
        }

        System.out.println("Автомобиль успешно добавлен!");
    }

    private static Car createCarFromInput() {
        System.out.print("Марка: ");
        String brand = scanner.nextLine();
        System.out.print("Год выпуска: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Цена: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Комплектация: ");
        String комплектация = scanner.nextLine();
        System.out.print("Страна производитель: ");
        String country = scanner.nextLine();
        System.out.print("Дата продажи (YYYY-MM-DD): ");
        LocalDate saleDate = LocalDate.parse(scanner.nextLine());
        System.out.print("ФИО покупателя: ");
        String customerFullName = scanner.nextLine();

        return new Car(brand, year, price, комплектация, country, saleDate, customerFullName);
    }

    private static UsedCar createUsedCarFromInput() {
        Car car = createCarFromInput();
        System.out.print("Состояние: ");
        String condition = scanner.nextLine();
        System.out.print("ФИО предыдущего владельца: ");
        String previousOwnerFullName = scanner.nextLine();
        System.out.print("Пробег: ");
        int mileage = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return new UsedCar(car.getBrand(), car.getYear(), car.getPrice(), car.getКомплектация(), car.getCountry(), car.getSaleDate(), car.getCustomerFullName(), condition, previousOwnerFullName, mileage);
    }

    private static SportsCar createSportsCarFromInput() {
        Car car = createCarFromInput();
        System.out.print("Время разгона до 100 км/ч (сек): ");
        double accelerationTime = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Объем двигателя: ");
        double engineCapacity = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Мощность (л.с.): ");
        int horsepower = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return new SportsCar(car.getBrand(), car.getYear(), car.getPrice(), car.getКомплектация(), car.getCountry(), car.getSaleDate(), car.getCustomerFullName(), accelerationTime, engineCapacity, horsepower);
    }

    private static SpecialEquipment createSpecialEquipmentFromInput() {
        Car car = createCarFromInput();
        System.out.print("Тип спецтехники: ");
        String type = scanner.nextLine();
        System.out.print("Масса (кг): ");
        double weight = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Габариты: ");
        String dimensions = scanner.nextLine();

        return new SpecialEquipment(car.getBrand(), car.getYear(), car.getPrice(), car.getКомплектация(), car.getCountry(), car.getSaleDate(), car.getCustomerFullName(), type, weight, dimensions);
    }

    private static void sortByBrandAndPrint(CarSalesList salesList) {
        salesList.sortByBrand();
        System.out.println("Список автомобилей, отсортированный по марке:");
        salesList.printCarList();
    }

    private static void sortByPriceAndPrint(CarSalesList salesList) {
        salesList.sortByPrice();
        System.out.println("Список автомобилей, отсортированный по цене:");
        salesList.printCarList();
    }

    private static void saveDataToFile(CarSalesList salesList, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(salesList.getCars());
            System.out.println("Данные успешно сохранены в файл " + filename);
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении данных в файл: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void loadDataFromFile(CarSalesList salesList, String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            List<Car> loadedCars = (List<Car>) ois.readObject();
            salesList.getCars().clear(); // Clear existing data
            salesList.getCars().addAll(loadedCars); // Add loaded data
            System.out.println("Данные успешно загружены из файла " + filename);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден. Будет создан новый при сохранении.");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке данных из файла: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Неверный класс при загрузке данных из файла: " + e.getMessage());
        }
    }
}
