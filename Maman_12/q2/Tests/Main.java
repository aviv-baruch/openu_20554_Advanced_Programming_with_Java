package q2;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Testim.class);
        for (Failure failure : result.getFailures()) {
            System.out.println("Test Failed: " + failure.toString());
        }
        System.out.println("Tests Run: " + result.getRunCount());
        System.out.println("Tests Passed: " + (result.getRunCount() - result.getFailureCount()));
        System.out.println("Tests Failed: " + result.getFailureCount());
    }
}
