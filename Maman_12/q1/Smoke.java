package q1;

public class Smoke extends Alarm {
    /**
     * Constructs a new Smoke alarm with the specified address and source of activation.
     *
     * @param address     the address of the Smoke alarm.
     * @param activatedBy the source of activation for the Smoke alarm.
     * @throws BadAlarmException if address is null.
     */
    public Smoke(String address, String activatedBy) throws BadAlarmException {
        super(address, activatedBy);
        if (address == null) {
            throw new BadAlarmException("Invalid address: address cannot be null");
        }
    }

    /**
     * Prints out a message stating that the smoke alarm has been triggered, along with the address, start time,
     * and the entity that activated the alarm.
     */
    public void action() {
        System.out.println("Smoke alarm triggered at " + getAddress() + " at " + getStartTime() + " activated by " + getActivatedBy());
    }
}

