package numbers;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

/**
 * Unit test for simple App.
 */
public class RationalTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RationalTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RationalTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testRational()
    {
        // Given no preconditions

        // When I create a default `Rational` value
        Rational value = new Rational();
        // Then the value should have numerator 0
        assertThat("the numerator should be 0", value.numerator(), is(0));
        // And the value should have denominator 1
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    public void testRationalInt() 
    {
        // Given that I have constructed a `Rational` value using the argument `2`
        Rational value = new Rational(2);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));
    }

    public void testRationalIntInt()
    {
        // Given that I have created a Rational value using arguments `2` and `3`
        Rational value = new Rational(2, 3);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the value should have denominator `3`
        assertThat("the denominator should be 3", value.denominator(), is(3));

        // Given I have created a `Rational` value using `48` and `-72`
        value = new Rational(48, -72);
        // Then the value should have numerator `-2`
        assertThat("48 / -72 = -2 / 3", value.numerator(), is(-2));
        // And the value should have denominator `3`
        assertThat("48 / -72 = -2 / 3", value.denominator(), is(3));

        // Given I have created a 'Rational' value using '1' and '0'
        // Then the constructor should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational(1, 0));

        // Given I have created a 'Rational' value using '-1' and '1'
        value = new Rational(-1, 1);
        // Then the value should have numerator `-1`
        assertThat("the numerator should be -1", value.numerator(), is(-1));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));

        // Given I have created a 'Rational' value using '1' and '-1'
        value = new Rational(1, -1);
        // Then the value should have numerator `-1`
        assertThat("the numerator should be -1", value.numerator(), is(-1));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));

        // Given I have created a 'Rational' value using '-1' and '-1'
        value = new Rational(-1, -1);
        // Then the value should have numerator `1`
        assertThat("the numerator should be 1", value.numerator(), is(1));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));

        // Given I have created a 'Rational' value using '4' and '2'
        value = new Rational(4, 2);
        // Then the value should have numerator `2`
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));

        // Given I have created a 'Rational' value using '2' and '4'
        value = new Rational(2, 4);
        // Then the value should have numerator `1`
        assertThat("the numerator should be 1", value.numerator(), is(1));
        // And the value should have denominator `2`
        assertThat("the denominator should be 2", value.denominator(), is(2));

        // Given I have created a 'Rational' value using '2' and '2'
        value = new Rational(2, 2);
        // Then the value should have numerator `1`
        assertThat("the numerator should be 1", value.numerator(), is(1));
        // And the value should have denominator `1`
        assertThat("the denominator should be 1", value.denominator(), is(1));

        // Given I have created a 'Rational' value using 'MIN_VALUE' and '-1'
        // Then the constructor should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational(Integer.MIN_VALUE, -1));

        // Given I have created a 'Rational' value using '-1' and 'MIN_VALUE'
        // Then the constructor should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational(-1, Integer.MIN_VALUE));
    }


    public void testRationalRational()
    {
        // Given that I have created the `Rational` value `2/3`
        Rational original = new Rational(2, 3);
        // When I create a `Rational` value as a copy of the original `Rational` value
        Rational value = new Rational(original);
        // Then the copy's value should have numerator 2
        assertThat("the numerator should be 2", value.numerator(), is(2));
        // And the copy's value should have denominator 3
        assertThat("the denominator should be 3", value.denominator(), is(3));
    }


    public void testRationalOpposite()
    {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I create a `Rational` value as the opposite of the original `Rational` value
        Rational opposite = value.opposite();
        // Then the opposite's value should have numerator -2
        assertThat("the opposite of 2 is -2", opposite.numerator(), is(-2));
        // And the opposite's value should have denominator 3
        assertThat("the denominator should be 3", opposite.denominator(), is(3));
    }

    public void testRationalReciprocal() 
    {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I create a `Rational` value as the reciprocal of the original `Rational` value
        Rational reciprocal = value.reciprocal();
        // Then the reciprocal's value should have numerator 3
        assertThat("the numerator should be 3", reciprocal.numerator(), is(3));
        // And the reciprocal's value should have denominator 2
        assertThat("the denominator should be 2", reciprocal.denominator(), is(2));

        // Given that I have created the 'Rational' value '0'
        value = new Rational(0);
        // Then the reciprocal of the value should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, value::reciprocal);

        // Given that I have created the 'Rational' value '2/MIN_VALUE'
        value = new Rational(1, Integer.MIN_VALUE);
        // Then the reciprocal of the value should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, value::reciprocal);
    }


    public void testRationalTimes() {
        // Given that I have created the `Rational` value `2/3`
        Rational p = new Rational(2, 3);
        // And I have created the `Rational` value `5/7`
        Rational q = new Rational(5, 7);
        // When I multiply the two `Rational` values
        Rational result = p.times(q);
        // Then the result's value should have numerator 10
        assertThat("2 * 5 = 10", result.numerator(), is(10));
        // And the result's value should have denominator 21
        assertThat("3 * 7 = 21", result.denominator(), is(21));
    }

    public void testRationalDividedBy() {
        // Given that I have created the `Rational` value `2/3`
        Rational p = new Rational(2, 3);
        // And I have created the `Rational` value `5/7`
        Rational q = new Rational(5, 7);
        // When I divide the two `Rational` values
        Rational result = p.dividedBy(q);
        // Then the result's value should have numerator 14
        assertThat("2 * 7 = 14", result.numerator(), is(14));
        // And the result's value should have denominator 15
        assertThat("3 * 5 = 15", result.denominator(), is(15));
    }

    public void testRationalToString() {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I convert the `Rational` value to a string
        String result = value.toString();
        // Then the result should be the string "2/3"
        assertThat("the string should be 2/3", result, is("2/3"));

        // Given that I have created the `Rational` value `2/1`
        value = new Rational(2, 1);
        // When I convert the `Rational` value to a string
        result = value.toString();
        // Then the result should be the string "2"
        assertThat("the string should be 2", result, is("2"));
    }

    public void testRationalPlus() {
        // Given that I have created the `Rational` value `2/3`
        Rational p1 = new Rational(2, 3);
        // And I have created the `Rational` value `5/7`
        Rational q1 = new Rational(5, 7);
        // When I add the two `Rational` values
        Rational result = p1.plus(q1);
        // Then the result's value should have numerator 29
        assertThat("2 * 7 + 3 * 5 = 29", result.numerator(), is(29));
        // And the result's value should have denominator 21
        assertThat("3 * 7 = 21", result.denominator(), is(21));

        // Given that I have created the 'Rational' value '2/1'
        Rational p2 = new Rational(2, 1);
        // And I have created the 'Rational' value '1/MAX_VALUE'
        Rational q2 = new Rational(1, Integer.MAX_VALUE);
        // When I add the two 'Rational' values
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> p2.plus(q2));

        // Given that I have created the 'Rational' value '-1/1'
        Rational p3 = new Rational(-2, 1);
        // And I have created the 'Rational' value '-1/MAX_VALUE'
        Rational q3 = new Rational(-1, Integer.MAX_VALUE);
        // When I add the two 'Rational' values
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> p3.plus(q3));

        // Given that I have created the 'Rational' value '-1/1'
        Rational p4 = new Rational(-1, 1);
        // And I have created the 'Rational' value '1/MIN_VALUE'
        Rational q4 = new Rational(1, Integer.MIN_VALUE);
        // When I add the two 'Rational' values
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> p4.plus(q4));
    }

    public void testRationalMinus() {
        // Given that I have created the `Rational` value `2/3`
        Rational p1 = new Rational(2, 3);
        // And I have created the `Rational` value `5/7`
        Rational q1 = new Rational(5, 7);
        // When I subtract the two `Rational` values
        Rational result = p1.minus(q1);
        // Then the result's value should have numerator -1
        System.out.println(result.toString());
        assertThat("2 * 7 - 3 * 5 = -1", result.numerator(), is(-1));
        // And the result's value should have denominator 21
        assertThat("3 * 7 = 21", result.denominator(), is(21));
    }

    public void testRationalSafeAdd() {
        // Given that I have the integers 1 && 1
        // When I add the two integers
        // Then the result should be 2
        assertThat("1 + 1 = 2", new Rational().safeAdd(1, 1), is(2));

        // Given that I have the integers 1 && MAX_VALUE
        // When I add the two integers
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational().safeAdd(1, Integer.MAX_VALUE));
        
        // Given that I have the integers -1 && MIN_VALUE
        // When I add the two integers
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational().safeAdd(-1, Integer.MIN_VALUE));

    }

    public void testRationalSafeMultiply() {
        // Given that I have the integers 1 && 1
        // When I multiply the two integers
        // Then the result should be 1
        assertThat("1 * 1 = 1", new Rational().safeMultiply(1, 1), is(1));

        // Given that I have the integers 0 && 1
        // When I multiply the two integers
        // Then the result should be 0
        assertThat("0 * 1 = 0", new Rational().safeMultiply(0, 1), is(0));

        // Given that I have the integers 1 && 0
        // When I multiply the two integers
        // Then the result should be 0
        assertThat("1 * 0 = 0", new Rational().safeMultiply(1, 0), is(0));

        // Given that I have the integers 1 && -1
        // When I multiply the two integers
        // Then the result should be -1
        assertThat("1 * -1 = -1", new Rational().safeMultiply(1, -1), is(-1));

        // Given that I have the integers -2 && -1
        // When I multiply the two integers
        // Then the result should be 2
        assertThat("-2 * -1 = 2", new Rational().safeMultiply(-2, -1), is(2));

        // Given that I have the integers 2 && MAX_VALUE
        // When I multiply the two integers
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational().safeMultiply(2, Integer.MAX_VALUE));

        // Given that I have the integers 2 && MIN_VALUE
        // When I multiply the two integers
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational().safeMultiply(2, Integer.MIN_VALUE));
        
        // Given that I have the integers -2 && MIN_VALUE
        // When I multiply the two integers
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational().safeMultiply(-2, Integer.MIN_VALUE));

        // Given that I have the integers -2 && MAX_VALUE
        // When I multiply the two integers
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational().safeMultiply(-2, Integer.MAX_VALUE));

        // Given that I have the integers -1 && MIN_VALUE
        // When I multiply the two integers
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational().safeMultiply(-1, Integer.MIN_VALUE));
    }




}
