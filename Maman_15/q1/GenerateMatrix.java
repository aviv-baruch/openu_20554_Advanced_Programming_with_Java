package q1;

import java.util.Random;

/**
 * The GenerateMatrix class provides methods to generate and print matrices.
 */
public class GenerateMatrix {

    /**
     * Generates a matrix with random values between 0 and 10.
     *
     * @param rows    The number of rows in the matrix.
     * @param columns The number of columns in the matrix.
     * @return The generated matrix.
     */
    static int[][] generateMatrix(int rows, int columns) {
        Random random = new Random();
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(11); // Generate random value between 0 and 10
            }
        }
        return matrix;
    }

    /**
     * Prints a matrix.
     *
     * @param matrix The matrix to be printed.
     */
    static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
