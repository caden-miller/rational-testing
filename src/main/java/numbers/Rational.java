package numbers;

/**
 * Hello world!
 *
 */
public class Rational extends Number implements Comparable<Number> 
{

    private int theNumerator;
    private int theDenominator;      

    /************************************/
    /*          Constructors            */
    /************************************/
    public Rational() {
        this(0);
    }

    public Rational(int a) {
        this(a, 1);
    }

    public Rational(int a, int b) {  
        if (b == 0) {
            throw new IllegalArgumentException("Denominator of zero is undefined");
        }
        int gcd = gcd((long)a, (long)b);
        if (gcd < 0 && a == Integer.MIN_VALUE || b == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        a /= gcd;
        b /= gcd;
        boolean isNegative = (a > 0 && b < 0);
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
        if (r == null) {
            throw new NullPointerException("Rational is null");
        }
        else {
            theNumerator = r.numerator();
            theDenominator = r.denominator();
        }
    }

    /****************************/
    /*          Getters         */
    /****************************/
    public int numerator() {
        return theNumerator;
    }

    public int denominator() {
        return theDenominator;        
    }

    /****************************/
    /*          Methods         */
    /****************************/
    public Rational opposite() {
        return longRational((long)(-1 * numerator()), (long)denominator());
    }

    public Rational reciprocal() {
        if (numerator() == 0) {
            throw new IllegalArgumentException("Reciprocal of zero is undefined");
        }
        return longRational((long)denominator(), (long)numerator());
    }

    public Rational plus(Rational r) {
        if (r == null) {
            return null;
        }
        // a/b + c/d = (ad + bc)/bd
        long numeratorTerm1 = (long)numerator() * (long)r.denominator();
        long numeratorTerm2 = (long)r.numerator() * (long)denominator();
        long newNumerator = numeratorTerm1 + numeratorTerm2;
        long newDenominator = (long)denominator() * (long)r.denominator();

        // use long rational to avoid overflow unless its simplifiable
        return longRational(newNumerator, newDenominator);
    }

    public Rational minus(Rational r) {
        if (r == null) {
            return null;
        }
        return plus(r.opposite());
    }

    public Rational times(Rational r) {
        if (r == null) {
            return null;
        }
        return longRational((long)numerator() * (long)r.numerator(), (long)denominator() * (long)r.denominator());
    }

    public Rational dividedBy(Rational r) {
        if (r == null) {
            return null;
        }
        return times(r.reciprocal());
    }

    public Rational raisedToThePowerOf(int n) {
        if (n < 0 && numerator() == 0) {
            throw new IllegalArgumentException("Zero raised to a negative power is undefined");
        }
        else if (n < 0) {
            return reciprocal().raisedToThePowerOf(-n);
        }
        else if (n == 0) {
            return new Rational(1);
        }
        return times(raisedToThePowerOf(n - 1));
    }

    @Override
    public boolean equals(Object o) { 
        if (o == null) {
            return false;
        }
        else if (o instanceof Rational) {
            Rational r = (Rational) o;
            return (numerator() == r.numerator()) && (denominator() == r.denominator());
        }
        else if (o instanceof Float) {
            return Math.abs(floatValue() - ((Number)o).floatValue()) < Math.pow(2, -20);
        }
        else if (o instanceof Number) {
            return Math.abs(doubleValue() - ((Number)o).doubleValue()) < Math.pow(2, -40);
        }
        return false;
    }

    @Override
    public int compareTo(Number n) {
        if (n == null) {
            throw new NullPointerException("Number is null");
        }
        if (lessThan(n)) {
            return -1;
        }
        else if (equals(n)) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public boolean greaterThan(Number n) { 
        if (n == null) {
            return false;
        }
        else if (n instanceof Float) {
            float difference = floatValue() - n.floatValue();
            return difference >= Math.pow(2, -20);
        }
        else {
            double difference = doubleValue() - n.doubleValue();
            return difference >= Math.pow(2, -40);
        }
    }

    public boolean greaterThan(Rational r) { 
        if (r == null) {
            return false;
        }
        long lhs = (long)numerator() * (long)r.denominator();
        long rhs = (long)r.numerator() * (long)denominator();
        return lhs > rhs;
    }

    public boolean lessThan(Number n) { 
        if (n == null) {
            return false;
        }
        else if (n instanceof Float) {
            float difference = floatValue() - n.floatValue();
            return difference <= -Math.pow(2, -20);
        }
        else {
            double difference = doubleValue() - n.doubleValue();
            return difference <= -Math.pow(2, -40);
        }
    }

    public boolean lessThan(Rational r) { 
        if (r == null) {
            return false;
        }
        long lhs = (long)numerator() * (long)r.denominator();
        long rhs = (long)r.numerator() * (long)denominator();
        return lhs < rhs;
    }

    public boolean isZero() { 
        return numerator() == 0;
    }

    public boolean isOne() { 
        return numerator() == 1 && denominator() == 1;
    }

    public boolean isMinusOne() { 
        return numerator() == -1 && denominator() == 1;
    }

    public String toString() {
        if (denominator() == 1) {
            return Integer.toString(numerator());
        }
        return Integer.toString(numerator()) + "/" + Integer.toString(denominator());
    }

    /*****************************************/
    /*          Overridden Methods           */
    /*****************************************/
    @Override
    public int intValue() {
        return numerator() / denominator();
    }

    @Override
    public long longValue() {
        return (long) numerator() / denominator();
    }

    @Override
    public float floatValue() {
        return (float) numerator() / (float) denominator();
    }

    @Override
    public double doubleValue() {
        return (double) numerator() / (double) denominator();
    }


    /*****************************************/
    /*          Helper Functions             */
    /*****************************************/
    public int gcd(long a, long b) {
        if (b == 0) {
            return (int) a;
        } else {
            return (int) gcd(b, a % b);
        }
    }

    public Rational longRational(long a, long b) {
        if (b == 0) {
            throw new IllegalArgumentException("Denominator of zero is undefined");
        }
        int gcd = gcd(a, b);
        a /= gcd;
        b /= gcd;
        if (a > Integer.MAX_VALUE || a < Integer.MIN_VALUE ||
            b > Integer.MAX_VALUE || b < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Integer overflow error");
        }
        boolean isNegative = (a > 0 && b < 0);
        if (isNegative) {
            return new Rational(-1 * (int) Math.abs(a), (int) Math.abs(b));
        }
        else {
            return new Rational((int) a, (int) b);
        }
    }
}
