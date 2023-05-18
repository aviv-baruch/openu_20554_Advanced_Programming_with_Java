package q2;

import java.util.Objects;
import java.io.Serializable;

/**
 * Represents a date with day, month, and year components.
 */
public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    /**
     * Constructs a new Date object with the specified day, month, and year.
     *
     * @param day   The day component of the date.
     * @param month The month component of the date.
     * @param year  The year component of the date.
     */
    public Date(int day, int month, int year) {
        super();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Checks if this Date object is equal to another object.
     *
     * @param o The object to compare.
     * @return true if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;
        Date date = (Date) o;
        return getDay() == date.getDay() && getMonth() == date.getMonth() && getYear() == date.getYear();
    }

    /**
     * Returns a string representation of the Date object in the format "dd/mm/yyyy".
     *
     * @return The string representation of the Date object.
     */
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }

    /**
     * Generates a hash code for the Date object based on its day, month, and year components.
     *
     * @return The hash code value for the Date object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getDay(), getMonth(), getYear());
    }

    /**
     * Gets the year component of the date.
     *
     * @return The year component.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year component of the date.
     *
     * @param year The year component to set.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the month component of the date.
     *
     * @return The month component.
     */
    public int getMonth() {
        return month;
    }

    /**
     * Sets the month component of the date.
     *
     * @param month The month component to set.
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     * Gets the day component of the date.
     *
     * @return The day component.
     */
    public int getDay() {
        return day;
    }

    /**
     * Sets the day component of the date.
     *
     * @param day The day component to set.
     */
    public void setDay(int day) {
        this.day = day;
    }
}
