package q1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The Matrix class represents a matrix multiplication task that can be executed by a thread.
 */
public class Matrix implements Runnable {
    private final int[][] resultMatrix;
    private final int[][] matrixA;
    private final int[][] matrixB;
    private final int row;
    private final int col;
    private final TwoThreadsMonitor monitor;

    /**
     * Constructs a Matrix task with the specified parameters.
     *
     * @param resultMatrix The result matrix to store the multiplication result.
     * @param matrixA      The first matrix.
     * @param matrixB      The second matrix.
     * @param row          The current row index.
     * @param col          The current column index.
     * @param monitor      The monitor to control the printing order of threads.
     */
    public Matrix(int[][] resultMatrix, int[][] matrixA, int[][] matrixB, int row, int col, TwoThreadsMonitor monitor) {
        this.resultMatrix = resultMatrix;
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.row = row;
        this.col = col;
        this.monitor = monitor;
    }

    /**
     * Executes the matrix multiplication task.
     */
    @Override
    public void run() {
        int sum = 0;
        for (int k = 0; k < matrixA[row].length; k++) {
            sum += matrixA[row][k] * matrixB[k][col];
        }
        synchronized (monitor) {
            monitor.waitForMyTurn(row); // Wait for the thread's turn to print
            resultMatrix[row][col] = sum;
            System.out.println(sum); // Print the vector*vector result
            monitor.imDone(); // Notify that the thread is done printing
            if (row != matrixA.length - 1) {
                try {
                    monitor.wait(); // Wait for other threads to finish printing
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                monitor.notifyAll(); // Notify all threads waiting for printing to finish
            }
        }
    }

    /**
     * Multiplies two matrices and returns the result matrix.
     *
     * @param matrixA The first matrix.
     * @param matrixB The second matrix.
     * @return The result matrix of the multiplication.
     * @throws IllegalArgumentException if the matrix dimensions are invalid for multiplication.
     */
    public static int[][] multiply(int[][] matrixA, int[][] matrixB) {
        if (matrixA[0].length != matrixB.length) {
            throw new IllegalArgumentException("Invalid matrix dimensions for multiplication");
        }

        int n = matrixA.length;
        int m = matrixA[0].length;
        int p = matrixB[0].length;
        int[][] resultMatrix = new int[n][p];
        ExecutorService executor = Executors.newFixedThreadPool(n * p * m); // Increase thread pool size

        TwoThreadsMonitor monitor = new TwoThreadsMonitor();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                Runnable task = new Matrix(resultMatrix, matrixA, matrixB, i, j, monitor);
                executor.execute(task);
            }
        }

        executor.shutdown();
        return resultMatrix;
    }
}
