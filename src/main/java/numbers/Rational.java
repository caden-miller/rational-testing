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
        theNumerator = a / gcd(a, b);
        theDenominator = b / gcd(a, b);
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
        return new Rational(denominator(), numerator());
    }

    public Rational times(Rational r) {
        return new Rational(numerator() * r.numerator(), denominator() * r.denominator());
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

}
