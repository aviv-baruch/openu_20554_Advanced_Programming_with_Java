package q1;

import java.util.Scanner;
import static q1.GenerateMatrix.generateMatrix;
import static q1.GenerateMatrix.printMatrix;

/**
 * The Main class is the entry point of the program.
 * It generates two matrices, multiplies them,
 * and prints the resulting matrix.
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     *
     * @param args Command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows (n): ");
        int n = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix A (m): ");
        int m = scanner.nextInt();
        System.out.print("Enter the number of columns for matrix B (p): ");
        int p = scanner.nextInt();
        scanner.close();

        // Generate and print matrix A
        int[][] matrixA = generateMatrix(n, m);
        System.out.println("Matrix A:");
        printMatrix(matrixA);

        // Generate and print matrix B
        int[][] matrixB = generateMatrix(m, p);
        System.out.println("Matrix B:");
        printMatrix(matrixB);

        int[][] resultMatrix = Matrix.multiply(matrixA, matrixB);

        // Print the resulting matrix
        System.out.println("Resulting Matrix:");
        printMatrix(resultMatrix);
    }
}
