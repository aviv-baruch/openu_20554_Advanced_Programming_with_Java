package q2;
import java.util.Scanner;

public class DriverBigInt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("~~~~\nPrior typing the numbers, please note that division of a relatively large number (eg 1 decillion and 2590 might take a several minutes to be completed.\n~~~~\n");
        // Prompt user for first number
        System.out.print("Enter the first number: ");
        final BigInt firstNum = readBigInt(scanner);

        // Prompt user for second number
        System.out.print("Enter the second number: ");
        final BigInt secondNum = readBigInt(scanner);

        // Perform addition
        BigInt sum = firstNum.plus(secondNum);
        System.out.println(firstNum + " + " + secondNum + " = " + sum);

        // Perform subtraction
        BigInt difference = firstNum.minus(secondNum);
        System.out.println(firstNum + " - " + secondNum + " = " + difference);

        // Perform multiplication
        BigInt product = firstNum.multiply(secondNum);
        System.out.println(firstNum + " * " + secondNum + " = " + product);

        // Perform division
        BigInt quotient = null;
        try {
            quotient = new BigInt(firstNum.divide(secondNum).toString());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(firstNum + " / " + secondNum + " = " + quotient);

    }

    /**
     * Prompts the user to enter a BigInt until a valid one is provided.
     *
     * @param scanner the scanner object to use for input
     * @return the valid BigInt entered by the user
     */
    private static BigInt readBigInt(Scanner scanner) {
        BigInt num = null;
        while (num == null) {
            try {
                String input = scanner.nextLine();
                num = new BigInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.print("Please enter a valid number: ");
            }
        }
        return num;
    }
}
