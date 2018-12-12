package Unit10;

public class Rhombus extends Shape{
    double diagonal1;
    double diagonal2;
    double angle;
    double side;

    public Rhombus(double x, double y, boolean diagonals) {
        if(diagonals){
            diagonal1 = x;
            diagonal2 = y;
            getAngleSide();
        } else {
            angle = x;
            side = y;
            getDiagonals();
        }
    }

    private void getDiagonals(){
        diagonal1 = Math.sin(Math.toRadians(angle))*side*2;
        diagonal2 = Math.cos(Math.toRadians(angle))*side*2;
    }

    private void getAngleSide(){
        angle = Math.atan((diagonal1/2)/(diagonal2/2))*2;
        side = Math.sqrt(Math.pow(diagonal1/2,2)+Math.pow(diagonal2/2,2));
    }

    @Override
    public double area() {
        return diagonal2*diagonal1/2;
    }

    @Override
    public double perimeter() {
        return side*4;
    }
}
