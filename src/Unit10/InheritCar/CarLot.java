package Unit10.InheritCar;

import java.util.ArrayList;

public class CarLot {
    public CarLot(){
        lot = new Car[MAX_CARS];
    }

    public void addCar(Car aNewCar){
        lot[numberOfCars] = aNewCar;
        numberOfCars++;
    }

    public void printCarsInLot(){
        for (int i = 0; i<numberOfCars; i++){
            Car c = lot[i];
            System.out.println(c);
        }
    }

    private ArrayList<Car> findMatchingCars(int year, String make){
        ArrayList<Car> cars = new ArrayList <>();
        for (int i = 0; i < numberOfCars; i++) {
            Car c = lot[i];
            if(c.getMake().equalsIgnoreCase(make) && c.getYear() == year){
                cars.add(c);
            }
        }
        return cars;
    }

    public void printMatchingCars(int year, String make){
        ArrayList<Car> cars = findMatchingCars(year,make);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i));
        }
    }

    private static final int MAX_CARS = 100;
    private static int numberOfCars = 0;
    private Car[] lot;
}
