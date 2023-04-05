package q1;

public class Elevator extends Alarm {
    private int floor; //floor num

    /**
     * Creates a new Elevator object with the given address and floor parameters.
     * The activatedBy field is set to null.
     *
     * @param address The address of the elevator alarm.
     * @param floor The floor of the elevator.
     */
    public Elevator(String address, int floor) {
        super(address, null);
        this.floor = floor;
    }

    /**
     * Prints out a message stating that the elevator alarm has been triggered, along with the address, start time,
     * and the floor where the alarm was triggered.
     */
    public void action() {
        System.out.println("Elevator alarm triggered at " + getAddress() + " at " + getStartTime() + " on floor " + floor);
    }
    /**
     * Resets the floor field (level) to 0.
     */
    public void reset() {
        floor = 0;
    }
}
