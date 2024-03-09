package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{

    private int theNumerator;
    private int theDenominator;      // added

    public Rational() {
        this(0);
    }

    public Rational(int a) {
        this(a, 1);
    }

    public Rational(int a, int b) {  // added
        if (b == 0) {
            throw new IllegalArgumentException("Denominator of zero is undefined");
        }

        boolean aEqualsMinValue = a == Integer.MIN_VALUE;
        boolean bEqualsMinValue = b == Integer.MIN_VALUE;
        if ((aEqualsMinValue &&
            b == -1) ||
            (a == -1 &&
            bEqualsMinValue)) {
            throw new IllegalArgumentException("Integer overflow error ");
        }

        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        boolean isNegative = (a < 0 && b > 0) || (a > 0 && b < 0);
        if (isNegative) {
            theNumerator = -1 * Math.abs(a);
            theDenominator = Math.abs(b);
        }
        else {
            theNumerator = a;
            theDenominator = b;
        }
    }

    public Rational(Rational r) {
        this(r.numerator(), r.denominator());
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

    public Rational plus(Rational r) {
        // a/b + c/d = (ad + bc)/bd
        // use safe operations to avoid overflow
        int numeratorTerm1 = safeMultiply(numerator(), r.denominator());
        int numeratorTerm2 = safeMultiply(r.numerator(), denominator());
        int newNumerator = safeAdd(numeratorTerm1, numeratorTerm2);
        int newDenominator = safeMultiply(denominator(), r.denominator());
        return new Rational(newNumerator, newDenominator);
    }

    public Rational minus(Rational r) {
        return plus(r.opposite());
    }

    public Rational times(Rational r) {
        return new Rational(safeMultiply(numerator(), r.numerator()), safeMultiply(denominator(), r.denominator()));
    }

    public Rational dividedBy(Rational r) {
        if (r.numerator() == 0) {
            throw new IllegalArgumentException("Division by zero is undefined");
        }
        return times(r.reciprocal());
    }

    public Rational raisedToThePowerOf(int n) {
        if (n < 0 && numerator() == 0) {
            throw new IllegalArgumentException("Zero raised to a negative power is undefined");
        }
        if (n < 0) {
            return reciprocal().raisedToThePowerOf(-n);
        }
        if (n == 0) {
            return new Rational(1);
        }
        if (n == 1) {
            return this;
        }
        return times(raisedToThePowerOf(n - 1));
    }

    public boolean equals(Object o) { // TODO
        if (o == null) {
            return false;
        }
        else if (o instanceof Rational) {
            Rational r = (Rational) o;
            return (numerator() == r.numerator()) && (denominator() == r.denominator());
        }
        else {
            return false;
        }
    }

    public boolean greaterThan(Number n) { 
        if (n == null) {
            return false;
        }
        else if (n instanceof Float) {
            return (float) numerator() / denominator() > n.floatValue();
        }
        return (double) numerator() / denominator() > n.doubleValue();
    }

    public boolean greaterThan(Rational r) {
        if (r == null) {
            return false;
        }
        return safeMultiply(numerator(), r.denominator()) > 
            safeMultiply(r.numerator(), denominator());
    }

    public boolean lessThan(Number n) { 
        if (n == null) {
            return false;
        }
        else if (n instanceof Float) {
            return (float) numerator() / denominator() < n.floatValue();
        }
        else {
            return (double) numerator() / denominator() < n.doubleValue();
        }
        
    }

    public boolean lessThan(Rational r) { 
        if (r == null) {
            return false;
        }
        return safeMultiply(numerator(), r.denominator()) < 
            safeMultiply(r.numerator(), denominator());
    }

    public boolean isZero() { 
        return numerator() == 0;
    }

    public boolean isOne() { 
        return numerator() == 1;
    }

    public boolean isMinusOne() { 
        return numerator() == -1;
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

    public int safeAdd(int a, int b) {
        if (a > 0 && b > Integer.MAX_VALUE - a) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        if (a < 0 && b < Integer.MIN_VALUE - a) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        return a + b;
    }

    public int safeMultiply(int a, int b) {
        if (a > 0 && 
            (b > Integer.MAX_VALUE / a || 
            b < Integer.MIN_VALUE / a)) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        if (a < -1 && 
            (b < Integer.MAX_VALUE / a || 
            b > Integer.MIN_VALUE / a)) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        if (a == -1 && b == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        return a * b;
    }

}
