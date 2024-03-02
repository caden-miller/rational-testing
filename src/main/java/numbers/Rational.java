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
    theNumerator = a;
    theDenominator = b;
    }

    public Rational(int a) {
    theNumerator = a;
    theDenominator = 1;           // added
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
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
