package Unit08;

public class Cone {
    public double r;
    public double h;

    public Cone(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double volume(){
        return 1.0/3.0*h*(Math.PI*r*r);
    }

    public double surface(){
        return Math.PI*r*(r+Math.sqrt(h*h+r*r));
    }
}
