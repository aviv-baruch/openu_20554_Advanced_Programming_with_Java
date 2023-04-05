package q2;

import static org.junit.Assert.*;
import org.junit.Test;

public class Testim {

    @Test
    public void test_plus_plus_minus() {
        // addition of two positive numbers with different lengths
        BigInt num1 = new BigInt("-999999999999999999999999999999999999");
        BigInt num2 = new BigInt("-99999999923999999999999999999999999999");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("-100999999923999999999999999999999999998"), result);
    }

    @Test
    public void test_minus_plus_plus() {
        // addition of two positive numbers with different lengths
        BigInt num1 = new BigInt("-421323");
        BigInt num2 = new BigInt("45023");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("-376300"), result);
    }

    @Test
    public void testPlus_differentLengths() {
        // addition of two positive numbers with different lengths
        BigInt num1 = new BigInt("24900");
        BigInt num2 = new BigInt("145");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("25045"), result);
    }

    @Test
    public void testPlus_positiveAndZero() {
        // addition of a positive number and zero
        BigInt num1 = new BigInt("123456789");
        BigInt num2 = new BigInt("0");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("123456789"), result);
    }

    @Test
    public void testPlus_negativeAndZero() {
        // addition of a negative number and zero
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("0");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("-123456789"), result);
    }

    @Test
    public void testPlus_largePositiveNumbers() {
        // addition of two large positive numbers
        BigInt num1 = new BigInt("123456789012345678901234567890");
        BigInt num2 = new BigInt("987654321098765432109876543210");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("1111111110111111111011111111100"), result);
    }

    @Test
    public void testPlus_largeNegativeNumbers() {
        // addition of two large negative numbers
        BigInt num1 = new BigInt("-123456789012345678901234567890");
        BigInt num2 = new BigInt("-987654321098765432109876543210");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("-1111111110111111111011111111100"), result);
    }

    @Test
    public void testPlus_positiveAndNegativeWithSameAbsoluteValue() {
        // addition of a positive number and a negative number with the same absolute value
        BigInt num1 = new BigInt("123456789");
        BigInt num2 = new BigInt("-123456789");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("0"), result);
    }

    @Test
    public void testPlus_largePositiveAndSmallNegative() {
        // addition of a large positive number and a small negative number
        BigInt num1 = new BigInt("123456789012345678901234567890");
        BigInt num2 = new BigInt("-987654321");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("123456789012345678900246913569"), result);
    }

    @Test
    public void testPlus_largeNegativeAndSmallPositive() {
        // addition of a large negative number and a small positive number
        BigInt num1 = new BigInt("-123456789012345678901234567890");
        BigInt num2 = new BigInt("987654321");
        BigInt result = num1.plus(num2);
        assertEquals(new BigInt("-123456789012345678900246913569"), result);
    }

    @Test
    public void testMinusBasic() {
        BigInt num1 = new BigInt("987654321");
        BigInt num2 = new BigInt("123456789");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("864197532"), result);
    }

    @Test
    public void testMinusNegative() {
        BigInt num1 = new BigInt("-987654321");
        BigInt num2 = new BigInt("-123456789");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("-864197532"), result);
    }

    @Test
    public void testMinusDifferentLengths() {
        BigInt num1 = new BigInt("12345");
        BigInt num2 = new BigInt("678910");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("-666565"), result);
    }

    @Test
    public void testMinusPositiveZero() {
        BigInt num1 = new BigInt("123456789");
        BigInt num2 = new BigInt("0");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("123456789"), result);
    }

    @Test
    public void testMinusNegativeZero() {
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("0");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("-123456789"), result);
    }

    @Test
    public void testMinusLargePositive() {
        BigInt num1 = new BigInt("123456789012345678901234567890");
        BigInt num2 = new BigInt("987654321098765432109876543210");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("-864197532086419753208641975320"), result);
    }

    @Test
    public void testMinusLargeNegative() {
        BigInt num1 = new BigInt("-123456789012345678901234567890");
        BigInt num2 = new BigInt("-987654321098765432109876543210");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("864197532086419753208641975320"), result);
    }

    @Test
    public void testMinusPositiveNegativeSameValue() {
        BigInt num1 = new BigInt("123456789");
        BigInt num2 = new BigInt("-123456789");
        BigInt result = num1.minus(num2);
        assertEquals(new BigInt("246913578"), result);
    }

// Multiplication Tests

    @Test
    public void testMultiplyPositiveNumbers() {
        BigInt num1 = new BigInt("152");
        BigInt num2 = new BigInt("475");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("72200"), result);
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("-987654321");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("121932631112635269"), result);
    }

    @Test
    public void testMultiplyZero() {
        BigInt num1 = new BigInt("123456789");
        BigInt num2 = new BigInt("0");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("0"), result);
    }

    @Test
    public void testMultiplyNegativeZero() {
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("0");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("0"), result);
    }

    @Test
    public void testMultiplyOne() {
        BigInt num1 = new BigInt("123456789");
        BigInt num2 = new BigInt("1");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("123456789"), result);
    }

    @Test
    public void testMultiplyNegativeOne() {
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("1");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("-123456789"), result);
    }

    @Test
    public void testMultiplyLargeNumbers() {
        BigInt num1 = new BigInt("999999999999999999999999999999999999");
        BigInt num2 = new BigInt("999999999999999999999999999999999999");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("999999999999999999999999999999999998000000000000000000000000000000000001"), result);
    }

    @Test
    public void testMultiplyLargeAndSmallNumbers() {
        BigInt num1 = new BigInt("25202321312871283123");
        BigInt num2 = new BigInt("234");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("5897343187211880250782"), result);
    }

    @Test
    public void testMultiplyNegativeLargeNumbers() {
        BigInt num1 = new BigInt("-999999999999999999999999999999999999");
        BigInt num2 = new BigInt("-999999999999999999999999999999999999");
        BigInt result = num1.multiply(num2);
        assertEquals(new BigInt("999999999999999999999999999999999998000000000000000000000000000000000001"), result);
    }

    //divide


    @Test
    public void testDivideByOne() {
        // division by 1
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("1");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("-123456789"), result);
    }

    @Test
    public void testDivideByNegativeOne() {
        // division by -1
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("-1");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("123456789"), result);
    }

    @Test
    public void testDivideZeroByPositive() {
        // division of zero by a positive number
        BigInt num1 = new BigInt("0");
        BigInt num2 = new BigInt("123456789");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("0"), result);
    }

    @Test
    public void testDivideZeroByNegative() {
        // division of zero by a negative number
        BigInt num1 = new BigInt("0");
        BigInt num2 = new BigInt("-123456789");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("0"), result);
    }

    @Test
    public void testDividePositiveByNegative() {
        // division of a positive number by a negative number
        BigInt num1 = new BigInt("123456789");
        BigInt num2 = new BigInt("-987654321");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("0"), result);
    }

    @Test
    public void testDivideNegativeByPositive() {
        // division of a negative number by a positive number
        BigInt num1 = new BigInt("-123456789");
        BigInt num2 = new BigInt("987654321");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("0"), result);
    }

    @Test
    public void testDividePositiveByPositiveNoRemainder() {
        // division of a positive number by a positive number with no remainder
        BigInt num1 = new BigInt("1000");
        BigInt num2 = new BigInt("10");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("100"), result);
    }

    @Test
    public void testDividePositiveByPositiveWithRemainder() {
        // division of a positive number by a positive number with a remainder
        BigInt num1 = new BigInt("1001");
        BigInt num2 = new BigInt("10");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("100"), result);
    }

    @Test
    public void testDivideNegativeByNegativeNoRemainder() {
        // division of a negative number by a negative number with no remainder
        BigInt num1 = new BigInt("-1000");
        BigInt num2 = new BigInt("-10");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("100"), result);
    }

    @Test
    public void testDivideNegativeByNegativeWithRemainder() {
        // division of a negative number by a negative number with a remainder
        BigInt num1 = new BigInt("-1001");
        BigInt num2 = new BigInt("-10");
        BigInt result = num1.divide(num2);
        assertEquals(new BigInt("100"), result);
    }

}
