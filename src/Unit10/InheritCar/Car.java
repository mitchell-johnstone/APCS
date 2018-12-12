package Unit10.InheritCar;

public class Car {
    private String make;
    private int year;
    private double price;
    private double mileage;

    public Car(String make, int year, double mileage) {
        this.make = make;
        this.year = year;
        this.mileage = mileage;
        price = 0;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public void addMiles(double m){
        mileage+=m;
    }

    public double getMileage() {
        return mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", mileage=" + mileage +
                '}';
    }
}
