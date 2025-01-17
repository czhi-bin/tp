package seedu.address.model.moduleclass;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Time {

    public static final String MESSAGE_CONSTRAINTS =
            "Time should only contain numbers in HH:MM format";
    public static final String VALIDATION_REGEX = "([01]?[0-9]|2[0-3]):[0-5][0-9]";
    private final LocalTime value;

    /**
     * Represents a moduleClass's time in the address book.
     * Guarantees: immutable; is valid as declared in {@link #isValidTime(String)}
     */
    public Time(String time) {
        requireNonNull(time);
        checkArgument(isValidTime(time), MESSAGE_CONSTRAINTS);
        this.value = LocalTime.parse(time);
    }


    /**
     * Returns true if a string is valid DateTime.
     *
     * @param test the given String.
     * @return True if the string can be parsed and is a valid time, false otherwise.
     */
    public static boolean isValidTime(String test) {
        try {
            LocalTime.parse(test);
        } catch (DateTimeParseException e) {
            return false;
        }
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Time // instanceof handles nulls
                && value.equals(((Time) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
