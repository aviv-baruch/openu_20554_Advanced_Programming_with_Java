package q2;

import java.util.ArrayList;

public class Utils {

    /**
     * Determines whether the given BigInt is greater than this BigInt.
     *
     * @param other The BigInt to compare to this BigInt.
     * @return True if this BigInt is greater than the given BigInt, false otherwise.
     */
    public static boolean isGreaterThan(BigInt thisBigInt, BigInt other) {
        if (thisBigInt.equals(other)) { //if they are equals
            return false;
        }
        if (thisBigInt.getNegativity() && !other.getNegativity()) {
            return false;
        }
        if (!thisBigInt.getNegativity() && other.getNegativity()) {
            return true;
        }
        if (!thisBigInt.getNegativity() && !other.getNegativity()) {
            if (thisBigInt.getDigits().size() > other.getDigits().size()) {
                return true;
            } else if (thisBigInt.getDigits().size() < other.getDigits().size()) {
                return false;
            }
        } else {
            if (thisBigInt.getDigits().size() < other.getDigits().size()) {
                return true;
            } else if (thisBigInt.getDigits().size() > other.getDigits().size()) {
                return false;
            }
        }

        // At this point, the two BigInts have the same number of digits
        for (int i = 0; i < thisBigInt.getDigits().size(); i++) {
            int thisDigit = thisBigInt.getDigits().get(i);
            int otherDigit = other.getDigits().get(i);

            if (thisDigit != otherDigit) {
                return thisDigit > otherDigit;
            }
        }

        // The two BigInts are equal
        return false;
    }

    /**
     * Determines whether this BigInt is zero.
     *
     * @return True if this BigInt is zero, false otherwise.
     */
    public static boolean isZero(BigInt thisBigInt) {
        for (int digit : thisBigInt.getDigits()) {
            if (digit != 0) {
                return false;
            }
        }
        return true;
    }

    /**

     Determines the larger and smaller numbers between two BigInt objects.
     @param thisBigInt the first BigInt object to be compared.
     @param otherBigInt the second BigInt object to be compared.
     @return an ArrayList containing two BigInt objects; the first one is the bigger number and the second one is the smaller number.
     */
    public static ArrayList<BigInt> setLargerAndSmallerNumbers(BigInt thisBigInt, BigInt otherBigInt) {
        ArrayList<BigInt> res = new ArrayList<>();
        boolean isGreaterThan = isGreaterThan(thisBigInt, otherBigInt);
        if (!isGreaterThan) {
            res.add(new BigInt(otherBigInt.toString())); //biggerNum
            res.add(new BigInt(thisBigInt.toString())); //smallerNum
        } else {
            res.add(new BigInt(thisBigInt.toString())); //biggerNum
            res.add(new BigInt(otherBigInt.toString())); //smaller num
        }

        return res;
    }


}
