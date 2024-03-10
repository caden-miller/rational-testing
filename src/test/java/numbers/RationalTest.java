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

        // Given I have created a 'Rational' value using 'MIN_VALUE' and 'MIN_VALUE'
        // Then the constructor should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> new Rational(Integer.MIN_VALUE, Integer.MIN_VALUE));
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

        // Given that I have created the 'Rational' value '1/1'
        Rational p2 = new Rational(1, 1);
        // And I have created the 'Rational' value '0/1'
        Rational q2 = new Rational(0, 1);
        // When I divide the two 'Rational' values
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> p2.dividedBy(q2));
    }

    public void testRaisedToThePowerOf() {
        // Given that I have created the `Rational` value `2/3`
        Rational value1 = new Rational(2, 3);
        // When I raise the `Rational` value to the power of 3
        Rational result = value1.raisedToThePowerOf(3);
        // Then the result's value should have numerator 8
        assertThat("2 * 2 * 2 = 8", result.numerator(), is(8));
        // And the result's value should have denominator 27
        assertThat("3 * 3 * 3 = 27", result.denominator(), is(27));

        // Given that I have created the `Rational` value `2/3`
        value1 = new Rational(2, 3);
        // When I raise the `Rational` value to the power of 0
        result = value1.raisedToThePowerOf(0);
        // Then the result's value should have numerator 1
        assertThat("2^0 = 1", result.numerator(), is(1));
        // And the result's value should have denominator 1
        assertThat("3^0 = 1", result.denominator(), is(1));

        // Given that I have created the `Rational` value `2/3`
        value1 = new Rational(2, 3);
        // When I raise the `Rational` value to the power of -3
        result = value1.raisedToThePowerOf(-3);
        // Then the result's value should have numerator 27
        assertThat("3 * 3 * 3 = 27", result.numerator(), is(27));
        // And the result's value should have denominator 8
        assertThat("2 * 2 * 2 = 8", result.denominator(), is(8));

        // Given that I have created the `Rational` value `0/1`
        Rational value2 = new Rational(0, 1);
        // When I raise the `Rational` value to the power of -1
        // Then the result should throw an `IllegalArgumentException`
        assertThrows(IllegalArgumentException.class, () -> value2.raisedToThePowerOf(-1));
    }

    public void testRationalEquals() {
        // Given that I have created the 'Rational' value '2/3'
        Rational value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '2/3'
        Rational value2 = new Rational(2, 3);
        // When I compare the two 'Rational' values
        // Then the result should be `true`
        assertThat("2/3 == 2/3", value1.equals(value2), is(true));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '3/2'
        value2 = new Rational(3, 2);
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("2/3 != 3/2", value1.equals(value2), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Double' value '2/3'
        Double value3 = 2.0 / 3.0;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("(Rational)2/3 != (Double)2/3", value1.equals(value3), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value '2/3'
        Float value4 = 2.0f / 3.0f;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("(Rational)2/3 != (Float)2/3", value1.equals(value4), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Rational' value 'null'
        Rational value5 = null;
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("2/3 != null", value1.equals(value5), is(false));
    }

    public void testRationalCompareTo() {
        // Given that I have created the 'Rational' value '2/3'
        Rational value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '2/3'
        Rational value2 = new Rational(2, 3);
        // When I compare the two 'Rational' values
        // Then the result should be `0`
        assertThat("2/3 == 2/3", value1.compareTo(value2), is(0));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '3/2'
        value2 = new Rational(3, 2);
        // When I compare the two 'Rational' values
        // Then the result should be `-1`
        assertThat("2/3 < 3/2", value1.compareTo(value2), is(-1));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '1/3'
        value2 = new Rational(1, 3);
        // When I compare the two 'Rational' values
        // Then the result should be `1`
        assertThat("2/3 > 1/3", value1.compareTo(value2), is(1));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value '2/3'
        Float value3 = 2.0f / 3.0f;
        // When I compare the two 'Object's values
        // Then the result should be `0`
        assertThat("(Rational)2/3 == (Float)2/3", value1.compareTo(value3), is(0));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value '3/2'
        value3 = 3.0f / 2.0f;
        // When I compare the two 'Object's values
        // Then the result should be `-1`
        assertThat("(Rational)2/3 < (Float)3/2", value1.compareTo(value3), is(-1));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value '1/3'
        value3 = 1.0f / 3.0f;
        // When I compare the two 'Object's values
        // Then the result should be `1`
        assertThat("(Rational)2/3 > (Float)1/3", value1.compareTo(value3), is(1));
    }

    public void testRationalGreaterThan() {
        // Given that I have created the 'Rational' value '2/3'
        Rational value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '2/3'
        Rational value2 = new Rational(2, 3);
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("2/3 <= 2/3", value1.greaterThan(value2), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '3/2'
        value2 = new Rational(1, 3);
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("2/3 > 1/3", value1.greaterThan(value2), is(true));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Rational' value 'null'
        Rational value4 = null;
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("2/3 > null", value1.greaterThan(value4), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Double' value '2/3'
        Double value3 = 2.0 / 3.0;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("(Rational)2/3 <= (Double)2/3", value1.greaterThan(value3), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Double' value '1/3'
        value3 = 1.0 / 3.0;
        // When I compare the two 'Object's values
        // Then the result should be `true`
        assertThat("(Rational)2/3 > (Double)1/3", value1.greaterThan(value3), is(true));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value '2/3'
        Float value5 = 2.0f / 3.0f;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("(Rational)2/3 <= (Float)2/3", value1.greaterThan(value5), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value '1/3'
        value5 = 1.0f / 3.0f;
        // When I compare the two 'Object's values
        // Then the result should be `true`
        assertThat("(Rational)2/3 > (Float)1/3", value1.greaterThan(value5), is(true));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value 'null'
        value5 = null;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("2/3 > null", value1.greaterThan(value5), is(false));
    }

    public void testRationalLessThan() {
        // Given that I have created the 'Rational' value '2/3'
        Rational value1 = new Rational(2, 3);
        // And I have created the 'Rational' value '2/3'
        Rational value2 = new Rational(2, 3);
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("2/3 >= 2/3", value1.lessThan(value2), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(1, 3);
        // And I have created the 'Rational' value '3/2'
        value2 = new Rational(2, 3);
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("1/3 < 2/3", value1.lessThan(value2), is(true));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Rational' value 'null'
        Rational value4 = null;
        // When I compare the two 'Rational' values
        // Then the result should be `false`
        assertThat("2/3 < null", value1.lessThan(value4), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Double' value '2/3'
        Double value3 = 2.0 / 3.0;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("(Rational)2/3 >= (Double)2/3", value1.lessThan(value3), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(1, 3);
        // And I have created the 'Double' value '1/3'
        value3 = 2.0 / 3.0;
        // When I compare the two 'Object's values
        // Then the result should be `true`
        assertThat("(Rational)1/3 < (Double)2/3", value1.lessThan(value3), is(true));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value '2/3'
        Float value5 = 2.0f / 3.0f;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("(Rational)2/3 >= (Float)2/3", value1.lessThan(value5), is(false));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(1, 3);
        // And I have created the 'Float' value '1/3'
        value5 = 2.0f / 3.0f;
        // When I compare the two 'Object's values
        // Then the result should be `true`
        assertThat("(Rational)1/3 < (Float)2/3", value1.lessThan(value5), is(true));

        // Given that I have created the 'Rational' value '2/3'
        value1 = new Rational(2, 3);
        // And I have created the 'Float' value 'null'
        value5 = null;
        // When I compare the two 'Object's values
        // Then the result should be `false`
        assertThat("2/3 < null", value1.lessThan(value5), is(false));
    }

    public void testRationalIsZero() {
        // Given that I have created the 'Rational' value '0/1'
        Rational value = new Rational(0, 1);
        // When I check if the value is zero
        // Then the result should be `true`
        assertThat("0/1 is zero", value.isZero(), is(true));

        // Given that I have created the 'Rational' value '0/2'
        value = new Rational(0, 2);
        // When I check if the value is zero
        // Then the result should be `true`
        assertThat("0/2 is zero", value.isZero(), is(true));

        // Given that I have created the 'Rational' value '1/1'
        value = new Rational(1, 1);
        // When I check if the value is zero
        // Then the result should be `false`
        assertThat("1/1 is not zero", value.isZero(), is(false));
    }

    public void testRationalIsOne() {
        // Given that I have created the 'Rational' value '1/1'
        Rational value = new Rational(1, 1);
        // When I check if the value is one
        // Then the result should be `true`
        assertThat("1/1 is one", value.isOne(), is(true));

        // Given that I have created the 'Rational' value '1/2'
        value = new Rational(1, 2);
        // When I check if the value is one
        // Then the result should be `false`
        assertThat("1/2 is not one", value.isOne(), is(false));

        // Given that I have created the 'Rational' value '2/1'
        value = new Rational(2, 1);
        // When I check if the value is one
        // Then the result should be `false`
        assertThat("2/1 is not one", value.isOne(), is(false));
    }

    public void testRationalIsMinusOne() {
        // Given that I have created the 'Rational' value '-1/1'
        Rational value = new Rational(-1, 1);
        // When I check if the value is minus one
        // Then the result should be `true`
        assertThat("-1/1 is minus one", value.isMinusOne(), is(true));

        // Given that I have created the 'Rational' value '1/-1'
        value = new Rational(1, -1);
        // When I check if the value is minus one
        // Then the result should be `true`
        assertThat("1/-1 is minus one", value.isMinusOne(), is(true));

        // Given that I have created the 'Rational' value '-1/2'
        value = new Rational(-1, 2);
        // When I check if the value is minus one
        // Then the result should be `false`
        assertThat("-1/2 is not minus one", value.isMinusOne(), is(false));

        // Given that I have created the 'Rational' value '1/1'
        value = new Rational(1, 1);
        // When I check if the value is minus one
        // Then the result should be `false`
        assertThat("1/1 is not minus one", value.isMinusOne(), is(false));
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

    public void testRationalIntValue() {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I convert the `Rational` value to an integer
        int result = value.intValue();
        // Then the result should be 0
        assertThat("(Rational)2/3.intValue() == 2/3", result, is(value.numerator() / value.denominator()));

        // Given that I have created the `Rational` value `2/1`
        value = new Rational(2, 1);
        // When I convert the `Rational` value to an integer
        result = value.intValue();
        // Then the result should be 2
        assertThat("(Rational)2/1.intValue() == 2/1", result, is(value.numerator() / value.denominator()));
    }

    public void testRationalLongValue() {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I convert the `Rational` value to a long
        long result = value.longValue();
        // Then the result should be 0
        assertThat("(Rational)2/3.longValue() == 2/3", result, is((long)value.numerator() / value.denominator()));

        // Given that I have created the `Rational` value `2/1`
        value = new Rational(2, 1);
        // When I convert the `Rational` value to a long
        result = value.longValue();
        // Then the result should be 2
        assertThat("(Rational)2/1.longValue() == 2/1", result, is((long)value.numerator() / value.denominator()));
    }

    public void testRationalFloatValue() {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I convert the `Rational` value to a float
        float result = value.floatValue();
        // Then the result should be 0.6666667
        assertThat("(Rational)2/3.floatValue() == 2.0f / 3.0f", result, is(2.0f / 3.0f));

        // Given that I have created the `Rational` value `2/1`
        value = new Rational(2, 1);
        // When I convert the `Rational` value to a float
        result = value.floatValue();
        // Then the result should be 2.0
        assertThat("(Rational)2/1.floatValue() == 2.0f / 1.0f", result, is(2.0f / 1.0f));
    }

    public void testRationalDoubleValue() {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I convert the `Rational` value to a double
        double result = value.doubleValue();
        // Then the result should be 0.6666666666666666
        assertThat("(Rational)2/3.doubleValue() == 2.0 / 3.0", result, is(2.0 / 3.0));

        // Given that I have created the `Rational` value `2/1`
        value = new Rational(2, 1);
        // When I convert the `Rational` value to a double
        result = value.doubleValue();
        // Then the result should be 2.0
        assertThat("(Rational)2/1.doubleValue() == 2.0 / 1.0", result, is((double)2.0 / 1.0));
    }

    public void testRationalByteValue() {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I convert the `Rational` value to a byte
        byte result = value.byteValue();
        // Then the result should be 0
        assertThat("(Rational)2/3.byteValue() == 2/3", result, is((byte)(value.numerator() / value.denominator())));

        // Given that I have created the `Rational` value `2/1`
        value = new Rational(2, 1);
        // When I convert the `Rational` value to a byte
        result = value.byteValue();
        // Then the result should be 2
        assertThat("(Rational)2/1.byteValue() == 2/1", result, is((byte)(value.numerator() / value.denominator())));
    }

    public void testRationalShortValue() {
        // Given that I have created the `Rational` value `2/3`
        Rational value = new Rational(2, 3);
        // When I convert the `Rational` value to a short
        short result = value.shortValue();
        // Then the result should be 0
        assertThat("(Rational)2/3.shortValue() == 2/3", result, is((short)(value.numerator() / value.denominator())));

        // Given that I have created the `Rational` value `2/1`
        value = new Rational(2, 1);
        // When I convert the `Rational` value to a short
        result = value.shortValue();
        // Then the result should be 2
        assertThat("(Rational)2/1.shortValue() == 2/1", result, is((short)(value.numerator() / value.denominator())));
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
