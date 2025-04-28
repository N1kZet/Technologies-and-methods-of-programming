import java.util.Date;

public class Car{

    private String brand;
    private int year;
    private double price;
    private String equipment;
    private String country;
    private Date saleDate;
    private String buyerName;

    public Car(String brand, int year, double price, String equipment, String country, Date saleDate, String buyerName) {
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.equipment = equipment;
        this.country = country;
        this.saleDate = saleDate;
        this.buyerName = buyerName;
    }

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

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", equipment='" + equipment + '\'' +
                ", country='" + country + '\'' +
                ", saleDate=" + saleDate +
                ", buyerName='" + buyerName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Car car = new Car("Toyota", 2022, 25000.0, "Full", "Japan", new Date(), "John Doe");
        System.out.println(car);
    }
}
