package q2;

import java.util.ArrayList;

import static q2.Utils.*;

public class BigInt implements Comparable<BigInt> {
    // Constants to represent comparison results
    final int SMALLER = -1;
    final int EQUALS = 0;
    final int GREATER = 1;

    // The digits of the BigInt are stored as an ArrayList of integers
    private final ArrayList<Integer> digits;
    // Flag to indicate whether the BigInt is negative
    private boolean isNegative;

    /**
     * Constructor for BigInt.
     *
     * @param num A string representation of the BigInt.
     */
    public BigInt(String num) {
        this.digits = new ArrayList<>();
        // Check whether the number is negative
        this.isNegative = num.charAt(0) == '-';

        // Iterate through the string and add each digit to the ArrayList
        for (int i = (isNegative ? 1 : 0); i < num.length(); i++) {
            // Throw an exception if the character is not a digit
            if (num.charAt(i) > 57 || num.charAt(i) < 48)
                throw new IllegalArgumentException(
                        "\nError: The String " + num + " is invalid. \n" +
                                "Char at location: " + (i + 1) + " With the value of ~" + num.charAt(i) + "~ is not digit.\n"
                );
            int digit = Character.getNumericValue(num.charAt(i));
            digits.add(digit);
        }
    }

    /**
     * Get the ArrayList of digits for the BigInt.
     *
     * @return The ArrayList of digits for the BigInt.
     */
    public ArrayList<Integer> getDigits() {
        return this.digits;
    }

    /**
     * Get the negativity flag for the BigInt.
     *
     * @return The negativity flag for the BigInt.
     */
    public boolean getNegativity() {
        return this.isNegative;
    }

    /**
     * Adds the given BigInt to this BigInt and returns the sum as a new BigInt object.
     *
     * @param num the BigInt to be added to this BigInt
     * @return the sum of this BigInt and the given BigInt as a new BigInt object
     */
    public BigInt plus(BigInt num) {

        // Create a copy of this BigInt to perform the addition on
        boolean signFlag = false;

        // Handle special cases
        if (isZero(this)) {
            return num;
        }
        else if (isZero(num)) {
            return this;
        }
        else if (!this.isNegative && num.isNegative) {
            BigInt numClone = new BigInt(num.toString());
            numClone.isNegative = false;
            return this.minus(numClone);
        }

        else if(this.isNegative && !num.isNegative){
            BigInt thisClone = new BigInt(this.toString());
            thisClone.isNegative = false;
            return num.minus(thisClone);
        }
        else if(this.isNegative){ //num is for sure already negative or positive in this case, s
            signFlag = true;
            this.isNegative = false;
            num.isNegative = false;
        }

        //sets larger and smaller num according to the guidance in the course book, using function from utils
        ArrayList<BigInt> largerAndSmaller = setLargerAndSmallerNumbers(this, num);
        BigInt largerNum = largerAndSmaller.get(0);
        BigInt smallerNum = largerAndSmaller.get(1);

        final int SIZE_OF_LARGER_NUM = largerNum.digits.size();
        final int SIZE_OF_SMALLER_NUM = smallerNum.digits.size();


        // Add the digits of the two BigInts
        int carry = 0;
        int count = 0;
        for(int i = SIZE_OF_SMALLER_NUM - 1; i >= 0; i--) {
            int res = largerNum.digits.get(SIZE_OF_LARGER_NUM-1-count) + carry;
            if (i < SIZE_OF_SMALLER_NUM) {
                int toIncrease = smallerNum.digits.get(i);
                res += toIncrease;
            }
            if (res >= 10) {
                res -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            largerNum.digits.set(SIZE_OF_LARGER_NUM-1-count, res);
            count++;
        }
        while(carry != 0){ // adds the carry to the final number
            if(SIZE_OF_LARGER_NUM-1-count < 0) {//if is the last digit
                largerNum.digits.add(0,carry);
                carry =0;
            }else {
                int res = largerNum.digits.get(SIZE_OF_LARGER_NUM - 1 - count) + carry;

                if (res >= 10) res -= 10;
                else carry = 0;

                largerNum.digits.set(SIZE_OF_LARGER_NUM - 1 - count, res);
            }
            count++;
        }

        if(signFlag){
            this.isNegative = true;
            num.isNegative = true;
            largerNum.isNegative = true;
        }

        return largerNum;
    }



    /**
     * Subtract a given BigInt from this BigInt.
     *
     * @param num The BigInt to subtract from this BigInt.
     * @return The difference between this BigInt and the given BigInt.
     */
    public BigInt minus(BigInt num) {
        if(isZero(num)) //in case when second num is zero
            return this;

        boolean isGreaterThan = isGreaterThan(this,num);

        //checks if num are equals eg -123--123 or 123-123
        if(this.equals(num)){
        if((this.isNegative && num.isNegative) || (!this.isNegative && !num.isNegative))
            return new BigInt("0");
        }

        //sets larger and smaller num according to the guidance in the course book, using function from utils
        ArrayList<BigInt> largerAndSmaller = setLargerAndSmallerNumbers(this, num);
        BigInt largerNum = largerAndSmaller.get(0);
        BigInt smallerNum = largerAndSmaller.get(1);


        //math axiom, in the field of N, (--) === +
        if(num.isNegative) {
            BigInt numClone = new BigInt(num.toString());
            numClone.isNegative = false;
            return this.plus(numClone);
        }


        final int SIZE_OF_LARGER_NUM = largerNum.digits.size();

        int carry = 0;
        int count = 0;
        for(int i = smallerNum.digits.size() - 1; i >= 0; i--) {
            int res = largerNum.digits.get(SIZE_OF_LARGER_NUM-1-count) - carry;
            if (i < smallerNum.digits.size()) {
                int toDecrease = smallerNum.digits.get(i);
                res -= toDecrease;
            }
            if (res < 0) {
                res += 10;
                carry = 1;
            } else {
                carry = 0;
            }
            largerNum.digits.set(SIZE_OF_LARGER_NUM-1-count, res);
            count++;
        }

        if(carry != 0)
            largerNum.digits.set(SIZE_OF_LARGER_NUM-1-count,  largerNum.digits.get(SIZE_OF_LARGER_NUM-1-count)-1);

        // Remove leading zeroes from the result
        while (largerNum.digits.size() > 1 && largerNum.digits.get(0) == 0) {
            largerNum.digits.remove(0);
        }

        // Set the sign of the result
        if (!isGreaterThan)
            largerNum.isNegative = true;

        return largerNum;
    }

    /**

     Multiplies the current BigInt object by another BigInt object.
     @param multiBy the BigInt object to multiply the current BigInt object by.
     @return a new BigInt object representing the result of the multiplication.
     @throws IllegalArgumentException if the input parameter is null.
     */
    public BigInt multiply(BigInt multiBy) {
        if (multiBy == null) {
            throw new IllegalArgumentException("Error: Input cannot be null.");
        }
        final BigInt multiplier = new BigInt(multiBy.toString());
        BigInt res = new BigInt("0");
        BigInt temp;
        int count = this.digits.size()-1;
        int tenTimesSpot;
        while(count >= 0){
            tenTimesSpot = this.digits.size()-count;
            temp =  new BigInt("0");
            for(int i = 0; i < this.digits.get(count);i++)
                temp = temp.plus(new BigInt(multiplier.toString()));

            while(tenTimesSpot-1 > 0){
                temp.digits.add(temp.digits.size(), 0);
                tenTimesSpot--;
            }
            res = res.plus(temp);
            count--;
        }
        // Remove leading zeroes from the result
        while (res.digits.size() > 1 && res.digits.get(0) == 0) {
            res.digits.remove(0);
        }
        res.isNegative =  !isZero(res) && (this.isNegative && !multiBy.isNegative) || (!this.isNegative && multiBy.isNegative);
        return res;
    }

    /**

     Divides the current BigInt object by another BigInt object.
     @param divisor the BigInt object to divide the current BigInt object by.
     @return a new BigInt object representing the result of the division.
     @throws ArithmeticException if division by zero is attempted.
     */
    public BigInt divide(BigInt divisor) {
        // Check for division by zero
        if (divisor.digits.size() == 1 && divisor.digits.get(0) == 0) {
            throw new ArithmeticException("Division by zero has been found.");
        }

        final BigInt BIG_INT_ONE = new BigInt("1");
        BigInt res = new BigInt("0");
        BigInt runner = new BigInt("0");

        //Handles base cases
        if(this.equals( new BigInt("0"))) //if base num is zero
            return new BigInt("0");

        if(divisor.equals(BIG_INT_ONE)) // if divided by one
            return this;

        if(divisor.multiply(new BigInt("-1")).equals(BIG_INT_ONE)) //if divided by minus one
            return this.multiply(new BigInt("-1"));


        // Initialize the dividend as the current BigInt object
        BigInt dividend = new BigInt(this.toString());
        dividend.isNegative = false;

        // Initialize the divisor as the absolute value of the input divisor
        BigInt absDivisor =  new BigInt(divisor.toString());
        absDivisor.isNegative = false;

        if(isGreaterThan(absDivisor,dividend))
            return new BigInt("0");

        while(dividend.compareTo(runner.plus(absDivisor)) > 0 || dividend.equals(runner.plus(absDivisor))) { //add one to the result while the runner is smaller than or equal to the original number
            res = res.plus(BIG_INT_ONE); //res accumulator
            runner = runner.plus(absDivisor);
        }

        res.isNegative =  isZero(this) && ((this.isNegative && !divisor.isNegative) || (!this.isNegative && divisor.isNegative));

        return res;
    }



    /**
     * Returns a string representation of this BigInt.
     *
     * @return a string representation of this BigInt
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isNegative) {
            sb.append("-");
        }
        for (int digit : digits) {
            sb.append(digit);
        }
        return sb.toString();
    }

    /**
     * Returns true if this BigInt is equal to the given object.
     *
     * @param obj the object to compare to
     * @return true if this BigInt is equal to the given object, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BigInt)) {
            return false;
        }
        BigInt secondNum = (BigInt) obj;
        if (this.isNegative != secondNum.isNegative) {
            return false;
        }
        if (this.digits.size() != secondNum.digits.size()) {
            return false;
        }
        for (int i = 0; i < this.digits.size(); i++) {
            if (!this.digits.get(i).equals(secondNum.digits.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Compares this BigInt to the given BigInt.
     *
     * @param num the BigInt to compare to
     * @return -1, 0, or 1 if this BigInt is less than, equal to, or greater than the given BigInt, respectively
     */
    @Override
    public int compareTo(BigInt num) {
        if(this.equals(num))
            return EQUALS;
        else if(isGreaterThan(this,num))
            return GREATER;
        return SMALLER;
    }
}
