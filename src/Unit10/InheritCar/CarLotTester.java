package Unit10.InheritCar;

public class CarLotTester {
    public static void main(String[] args) {
        //makes some cars
        Car c1 = new Car("Toy Yoda",300, 32.1);
        Car c2 = new Car("FoRd", 105789, 46.7689);
        Car c3 = new Car("FoRd", 105789,1530.66);

        //sets prices of cars
        c1.setPrice(88.8);
        c2.setPrice(580.278);
        c3.setPrice(4.4444);

        //makes a CarLot
        CarLot carLot = new CarLot();

        //adds 3 cars to CarLot
        carLot.addCar(c1);
        carLot.addCar(c2);
        carLot.addCar(c3);

        //prints out all cars in lot
        System.out.println("Here are all the cars available");
        carLot.printCarsInLot();
        System.out.println();

        //does a search in the lot for a specific year and make
        System.out.println("Here are all the cars that match year 105789 and make FoRd");
        carLot.printMatchingCars(105789, "FoRd");
    }
}
