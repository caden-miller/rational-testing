package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{

    private int theNumerator;
    private int theDenominator;      // added

    public Rational(int a, int b) {  // added
        if (b == 0) {
            throw new IllegalArgumentException("Denominator of zero is undefined");
        }

        int gcd = gcd(a, b);
        boolean aEqualsMinValue = a == Integer.MIN_VALUE;
        boolean bEqualsMinValue = b == Integer.MIN_VALUE;
        if ((aEqualsMinValue &&
            b == -1) ||
            (a == -1 &&
            bEqualsMinValue)) {
            throw new IllegalArgumentException("Integer overflow error ");
        }



        theNumerator = a / gcd;
        theDenominator = b / gcd;
    }

    public Rational(Rational r) {
        this(r.numerator(), r.denominator());
    }

    public Rational(int a) {
        this(a, 1);
    }

    public Rational() {
        this(0);
    }

    public int numerator() {
        return theNumerator;
    }

    public int denominator() {
        return theDenominator;        // changed
    }

    public Rational opposite() {
        return new Rational(-numerator(), denominator());
    }

    public Rational reciprocal() {
        if (numerator() == 0) {
            throw new IllegalArgumentException("Reciprocal of zero is undefined");
        }
        if (denominator() == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        return new Rational(denominator(), numerator());
    }

    public Rational times(Rational r) {
        return new Rational(numerator() * r.numerator(), denominator() * r.denominator());
    }

    public String toString() {
        if (denominator() == 1) {
            return Integer.toString(numerator());
        }
        return Integer.toString(numerator()) + "/" + Integer.toString(denominator());
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
