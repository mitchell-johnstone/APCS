package Unit10;

import java.awt.*;
import java.util.Random;

public class VehicleTester {
    public static void main(String[] args) {
        Random r = new Random();
        Canvas c = new Canvas("Vehicles",1400,800, Color.black);
        c.setVisible(true);
        Vehicle car = new Car(200,200);
        car.draw(c);
        Vehicle truck = new Truck(200,500);
        truck.draw(c);
        Vehicle mf = new MilleniumFalcon(500,300);
        mf.draw(c);
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0]=car;
        vehicles[1]=truck;
        vehicles[2]=mf;
        /*for (int i = 0; i < 1400; i++) {
            c.setInkColor(Color.WHITE);
//            c.drawPoint(new Point(i,(int)(400+50*Math.sin(Math.toRadians(i)))));
            c.pause(10);
            c.pause(10);
            c.erase();
        }*/
        for (int i = 0; i <2000; i++) {
            c.pause(100);
            c.erase();
            car.move(1);
            truck.move(3);
            mf.move(5);
            for(Vehicle vehicle: vehicles){
                vehicle.draw(c);
            }
        }
    }
}
