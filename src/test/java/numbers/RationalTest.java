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


    public void testRationalopposite()
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




}
