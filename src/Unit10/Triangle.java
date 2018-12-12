package Unit10;

public class Triangle extends Shape{
    double side1;
    double side2;
    double side3;
    double angle;

    public Triangle(double x, double y, double z, boolean angle) {
        this.side1 = x;
        this.side2 = y;
        if(angle){
            this.angle = z;
            calculateSide3();
        } else {
            this.side3 = z;
            calculateAngle();
        }
    }

    //a*a = b*b + c*c - 2bccosA
    private void calculateSide3(){
        this.side3 = Math.sqrt(side1*side1+side2*side2 - 2 * side1 * side2 * Math.cos(Math.toRadians(angle)));
    }
    //a*a -b*b - c*c= - 2bccosA
    //(b*b+c*c-a*a)/2*b*c
    private void calculateAngle(){
        this.angle = Math.acos((side2*side2+side3*side3-side1*side1)/(2*side1*side3));
    }

    @Override
    public double area() {
        double s = (side1+side3+side2)/2;
        double val = Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        return val;
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}
