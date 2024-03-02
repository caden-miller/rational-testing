package numbers;

/**
 * Hello world!
 *
 */
public class Rational 
{

    private int theNumerator;  // added

    public Rational(int a) {   // added
    theNumerator = a;
    }

    public Rational() {        // added
    this(0);
    }

    public int numerator() {
    return theNumerator;    // changed
    }

    public int denominator() {
        return 1;
    }
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
