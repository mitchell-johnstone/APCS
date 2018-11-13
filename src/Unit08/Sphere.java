package Unit08;

public class Sphere {
    public double r;

    public Sphere(double r) {
        this.r = r;
    }

    public double volume(){
        return 4.0/3.0*Math.PI*r*r*r;
    }

    public double surface(){
        return 4.0*r*r*Math.PI;
    }
}
