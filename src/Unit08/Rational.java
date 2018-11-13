package Unit08;

import java.util.ArrayList;

public class Rational {
    private int numerator;
    private int denominator;
    private static int operationNumber = 0;

    public Rational(int num, int den) {
        this.numerator = num;
        this.denominator = den;
        reduce();
    }

    private void reduce(){
        for (int i = 2; i <= numerator; i++) {
            if(numerator%i==0 && denominator%i==0){
                numerator/=i;
                denominator/=i;
                i--;
            }
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public Rational multiply(Rational frac2){
        return new Rational(this.numerator*frac2.getNumerator(), this.denominator * frac2.getDenominator());
    }

    public Rational divide(Rational frac2){
        return new Rational(this.numerator*frac2.getDenominator(), this.denominator*frac2.getNumerator());
    }

    public Rational add(Rational frac2){
        int den = gcd(this.denominator, frac2.getDenominator());
        int n1 = den/this.denominator;
        int n2 = den/frac2.getDenominator();
        return new Rational(this.numerator*n1+frac2.getNumerator()*n2, den);
    }

    public Rational subtract(Rational frac2){
        int den = gcd(this.denominator, frac2.getDenominator());
        int n1 = den/this.denominator;
        int n2 = den/frac2.getDenominator();
        return new Rational(this.numerator*n1-frac2.getNumerator()*n2, den);
    }

    private int gcd (int den1, int den2){
        int likeFactors = 1;
        for (int i = 2; i <= den1; i++) {
            if(den1%i==0 && den2%i==0){
                den1/=i;
                den2/=i;
                likeFactors*=i;
                i--;
            }
        }
        return likeFactors*den1*den2;
    }

    public boolean equals(Object frac2){
        if(frac2 instanceof Rational){
            return(((Rational) frac2).getDenominator() == this.getDenominator()
                    && ((Rational) frac2).getNumerator() == this.getNumerator());
        }
        return false;
    }

    public String toString() {
        String tmp = "<" + (this.numerator/10>0?" ":"  ") + this.numerator+ "|" + this.denominator
                + (this.denominator/10>0?" ":"  ") + ">";
        return tmp;
    }
}
