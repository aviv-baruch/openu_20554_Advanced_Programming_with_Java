package q1;

import java.util.ArrayList;

public class Driver {
    /**
     * This method creates several alarms of different types and adds them to an ArrayList.
     * It then calls the process method in the TestAlarms class to trigger each alarm and perform its action.
     *
     * @throws BadAlarmException if an invalid address is passed to a Smoke alarm.
     */
    public static void driver() throws BadAlarmException {
        ArrayList<Alarm> alarms = new ArrayList<>();

        Smoke smokeAlarm1 = new Smoke("Holon, Bialik 136", "Kitchen");
        Smoke smokeAlarm2 = new Smoke("Tel Aviv, Rothschild Blvd. 1", "Living room");
        Fire fireAlarm = new Fire("Jerusalem, Jaffa St. 10", "Second floor");
        Elevator elevatorAlarm = new Elevator("Ramat Gan, Bialik St. 3", 5);
        Smoke smokeAlarm3 = new Smoke("Holon, Weizmann St. 12", "Bedroom");
        Fire fireAlarm2 = new Fire("Haifa, Herzl St. 25", "Third floor");
        Elevator elevatorAlarm2 = new Elevator("Netanya, Ben Gurion St. 8", 2);
        Smoke smokeAlarm4 = new Smoke("Holon, HaAliyah St. 2", "Bathroom");
        Fire fireAlarm3 = new Fire("Tel Aviv, Allenby St. 15", "First floor");
        Elevator elevatorAlarm3 = new Elevator("Eilat, Ben Yehuda St. 4", 7);

        alarms.add(smokeAlarm1);
        alarms.add(smokeAlarm2);
        alarms.add(fireAlarm);
        alarms.add(elevatorAlarm);
        alarms.add(smokeAlarm3);
        alarms.add(fireAlarm2);
        alarms.add(elevatorAlarm2);
        alarms.add(smokeAlarm4);
        alarms.add(fireAlarm3);
        alarms.add(elevatorAlarm3);

        TestAlarms.process(alarms);
    }
}
