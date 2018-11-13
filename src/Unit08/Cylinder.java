package Unit08;

public class Cylinder {
    public double r;
    public double h;

    public Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double volume(){
        return Math.PI*r*r*h;
    }

    public double surface(){
        return Math.PI*r*r*2+2*r*Math.PI*h;
    }
}
