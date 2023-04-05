package q1;


public class Fire extends Alarm {

    private boolean active; //indicates if the alarm is active

    /**
     * Creates a new Fire object with the given address and activatedBy parameters.
     * Sets the 'active' field to true.
     *
     * @param address The address of the fire alarm.
     * @param activatedBy The entity that activated the fire alarm.
     */
    public Fire(String address, String activatedBy) {
        super(address, activatedBy);
        active = true;
    }

    /**
     * Prints out a message stating that the fire alarm has been triggered, along with the address, start time,
     * and the entity that activated the alarm.
     * Sets the 'active' field to false.
     */
    public void action() {
        active = false;
        System.out.println("Fire alarm triggered at " + getAddress() + " at " + getStartTime() + " activated by " + getActivatedBy());
    }

    /**
     * Returns the value of the 'active' field.
     *
     * @return The value of the 'active' field.
     */
    public boolean isActive() {
        return active;
    }
}
