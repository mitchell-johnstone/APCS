package Unit08;

public class Geometry {
    public static double sphereVolume(double r ){
        return 4.0/3.0*Math.PI*r*r*r;
    }

    public static double sphereSurface(double r){
        return 4.0*r*r*Math.PI;
    }

    public static double cylinderVolume(double r, double h){
        return Math.PI*r*r*h;
    }

    public static double cylinderSurface(double r, double h){
        return Math.PI*r*r*2+2*r*Math.PI*h;
    }

    public static double coneVolume(double r, double h){
        return 1.0/3.0*h*(Math.PI*r*r);
    }

    public static double coneSurface(double r, double h){
        return Math.PI*r*(r+Math.sqrt(h*h+r*r));
    }
}
