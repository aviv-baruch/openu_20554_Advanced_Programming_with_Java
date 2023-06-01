package q1;

/**
 * The TwoThreadsMonitor class is used as a monitor to control the printing order of threads.
 */
public class TwoThreadsMonitor {
    private int nextTurn = 2;

    /**
     * Waits for the thread's turn to print.
     *
     * @param threadNumber The number of the thread.
     */
    public synchronized void waitForMyTurn(int threadNumber) {
        while (threadNumber >= nextTurn) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
    }

    /**
     * Indicates that the thread has finished its printing and increments the turn counter.
     */
    public synchronized void imDone() {
        nextTurn++;
        notifyAll();
    }

    /**
     * Gets the current turn counter value.
     *
     * @return The current turn counter value.
     */
    public int getNextTurn() {
        return nextTurn;
    }
}
