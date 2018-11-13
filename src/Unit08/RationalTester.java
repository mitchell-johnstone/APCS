package Unit08;

public class RationalTester {
    public static void main(String[] args) {
        Rational r1 = new Rational(12,16);
        Rational r2 = new Rational(2,6);

        System.out.println("First fraction: " + r1);
        System.out.println("Second fraction: " + r2);

        Rational r3 = r1.add(r2);
        Rational r4 = r1.subtract(r2);
        Rational r5 = r1.multiply(r2);
        Rational r6 = r1.divide(r2);

        System.out.println("r1 + r2: " + r3 );
        System.out.println("r1 - r2: " + r4 );
        System.out.println("r1 * r2: " + r5 );
        System.out.println("r1 / r2: " + r6 );
    }
}
