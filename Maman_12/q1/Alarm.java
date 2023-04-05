package q1;
import java.util.Date;

/**
 * The Alarm class represents an alarm triggered by a sensor, which can be reset or have an action taken.
 */
public abstract class Alarm {
    private Date startTime;
    private String address;
    private String activatedBy;

    /**
     * Creates a new Alarm object with the given address and activatedBy parameters.
     * Sets the startTime field to the current date and time.
     *
     * @param address The address of the alarm.
     * @param activatedBy The entity that activated the alarm.
     */
    public Alarm(String address, String activatedBy) {
        this.startTime = new Date();
        this.address = address;
        this.activatedBy = activatedBy;
    }

    /**
     * Gets the start time of the alarm.
     * @return the start time of the alarm
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Prints the date in which alarm has been activated
     */
    @Override
    public String toString() {
        return startTime.toString();
    }

    /**
     * Gets the address of the sensor that triggered the alarm.
     * @return the address of the sensor
     */
    public String getAddress() {
        return address;
    }

    /**
     * Gets who activated the alarm.
     * @return the name of who activated the alarm
     */
    public String getActivatedBy() {
        return activatedBy;
    }

    /**
     * An abstract method that performs the action to be taken when the alarm is triggered.
     */
    public void action() {
    }
}
