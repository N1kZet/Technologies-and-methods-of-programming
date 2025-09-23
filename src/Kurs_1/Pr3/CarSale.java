import java.time.LocalDate;
import java.util.Objects;

public class CarSale {

    private String brand;
    private int year;
    private double price;
    private String комплектация; // Changed to комплектация to match Russian spelling
    private String country;
    private LocalDate saleDate;
    private String customerFullName;

    // Конструктор
    public CarSale(String brand, int year, double price, String комплектация, String country, LocalDate saleDate, String customerFullName) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.комплектация = комплектация;
        this.country = country;
        this.saleDate = saleDate;
        this.customerFullName = customerFullName;
    }

    // Геттеры
    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getКомплектация() {
        return комплектация;
    }

    public String getCountry() {
        return country;
    }

    public LocalDate getSaleDate() {
        return saleDate;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    // Сеттеры
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setКомплектация(String комплектация) {
        this.комплектация = комплектация;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSaleDate(LocalDate saleDate) {
        this.saleDate = saleDate;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    // Переопределение метода toString()
    @Override
    public String toString() {
        return "CarSale{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", комплектация='" + комплектация + '\'' +
                ", country='" + country + '\'' +
                ", saleDate=" + saleDate +
                ", customerFullName='" + customerFullName + '\'' +
                '}';
    }

     //Переопределение методов equals() и hashCode() (рекомендуется при переопределении toString())
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarSale carSale = (CarSale) o;
        return year == carSale.year &&
               Double.compare(carSale.price, price) == 0 &&
               Objects.equals(brand, carSale.brand) &&
               Objects.equals(комплектация, carSale.комплектация) &&
               Objects.equals(country, carSale.country) &&
               Objects.equals(saleDate, carSale.saleDate) &&
               Objects.equals(customerFullName, carSale.customerFullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, year, price, комплектация, country, saleDate, customerFullName);
    }

    // Пример использования в main
    public static void main(String[] args) {
        LocalDate saleDate = LocalDate.of(2023, 10, 26);
        CarSale carSale = new CarSale("Toyota", 2022, 25000.0, "Comfort", "Japan", saleDate, "Иванов Иван Иванович");

        System.out.println(carSale); // Выведет информацию об объекте в отформатированном виде
        // Пример форматированного вывода (альтернативный вариант):
        System.out.println("Информация о продаже автомобиля:");
        System.out.println("Марка: " + carSale.getBrand());
        System.out.println("Год выпуска: " + carSale.getYear());
        System.out.println("Цена: " + carSale.getPrice());
        System.out.println("Комплектация: " + carSale.getКомплектация());
        System.out.println("Страна производитель: " + carSale.getCountry());
        System.out.println("Дата продажи: " + carSale.getSaleDate());
        System.out.println("ФИО покупателя: " + carSale.getCustomerFullName());


    }
}
