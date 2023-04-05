package q1;

import java.util.ArrayList;

public class TestAlarms {
    /**
     * This method takes an ArrayList of Alarm objects and loops through them. For each Alarm, it calls the action method
     * and increments a count of how many Smoke alarms were triggered. If the Alarm is an Elevator, it also calls the reset
     * method on it.
     *
     * @param alarms the ArrayList of Alarms to process.
     */
    public static void process(ArrayList<Alarm> alarms) {
        int smokeCount = 0;

        for (Alarm alarm : alarms) {
            if (alarm instanceof Smoke) {
                smokeCount++;
            }

            alarm.action();

            if (alarm instanceof Elevator) {
                ((Elevator) alarm).reset();
            }
        }

        System.out.println("---\nSmoke alarms triggered: " + smokeCount);
    }
}
