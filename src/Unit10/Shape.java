package Unit10;

public abstract class Shape implements Comparable{
    public abstract double area();
    public abstract double perimeter();
    public int compareTo(Object obj) {
        if(this.area() == ((Shape)obj).area()){
            return 0;
        } else if( this.area()>((Shape)obj).area()){
            return 1;
        } else {
            return -1;
        }
    }
}
