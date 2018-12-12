package Unit10;

public class ShapeTester {
    public static void main(String[] args) {

        System.out.println("\tTriangle:");
        Triangle t = new Triangle(5,5,6,false);
        System.out.println(t.area());
        System.out.println(t.perimeter());
        System.out.println();

        t = new Triangle(6, 6, 60, true);
        System.out.println("\tTriangle V2.0:");
        System.out.println(t.area());
        System.out.println(t.perimeter());
        System.out.println();
        Circle c = new Circle(3);
        System.out.println("\tCircle:");
        System.out.println(c.area());
        System.out.println(c.perimeter());
        System.out.println();
        Rectangle rec = new Rectangle(10,5);
        System.out.println("\tRectangle");
        System.out.println(rec.area());
        System.out.println(rec.perimeter());
        System.out.println();
        Rhombus rho = new Rhombus(6,8, true);
        System.out.println("\tRhombus");
        System.out.println(rho.area());
        System.out.println(rho.perimeter());
        System.out.println();
        rho = new Rhombus(4,60,false);
        System.out.println("\tRhombus V2.0");
        System.out.println(rho.area());
        System.out.println(rho.perimeter());

        System.out.println(t.compareTo(rec));
    }
}
