package Unit10.InheritCar;

public class CarLotTester {
    public static void main(String[] args) {
        Car c1 = new Car("Toy Yoda",300, 32.1);
        Car c2 = new Car("FoRd", 105789, 46.7689);
        Car c3 = new Car("FoRd", 105789,1530.66);

        c1.setPrice(88.8);
        c2.setPrice(580.278);
        c3.setPrice(4.4444);

        System.out.println("Here are all the cars available");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println();

        CarLot carLot = new CarLot();

        carLot.addCar(c1);
        carLot.addCar(c2);
        carLot.addCar(c3);
        System.out.println("Here are all the cars that match year and make");
        carLot.printMatchingCars(105789, "FoRd");
    }
}
