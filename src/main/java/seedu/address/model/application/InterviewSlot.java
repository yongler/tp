package seedu.address.model.application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the interview date and time of an Application in InternApply.
 */

public class InterviewSlot {

    public static final String FORMAT_DATETIME = "dd-MM-yyyy HH:mm";
    public static final String FORMAT_DATETIME_DISPLAY = "d MMM yyyy HH:mm";
    public static final String MESSAGE_CONSTRAINTS = "Interview date should be of the format "
            + FORMAT_DATETIME
            + ", containing only numbers and respective separators.";
    public static  final String MESSAGE_NOT_SET = "Interview date is not set.";

    public final LocalDateTime value;

    /**
     * Constructs a {@code InterviewDateTime}.
     *
     * @param interviewDateTime A valid interview date and time.
     */
    public InterviewSlot(String interviewDateTime) {
        requireNonNull(interviewDateTime);
        checkArgument(isValidDateTime(interviewDateTime), MESSAGE_CONSTRAINTS);
        value = toLocalDateTime(interviewDateTime);
    }

    /**
     * Constructs a {@code InterviewDateTime}.
     */
    public InterviewSlot() {
        value = LocalDateTime.MAX;
    }

    /**
     * Returns true if a given string is a valid date and time.
     */
    public static boolean isValidDateTime(String test) {
        try {
            toLocalDateTime(test);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isNotSet(String test) {
        return test.equals(LocalDateTime.MAX.format(DateTimeFormatter.
                ofPattern(InterviewSlot.FORMAT_DATETIME)));
    }

    @Override
    public String toString() {
        return !isNotSet(this.value.format(DateTimeFormatter.ofPattern(InterviewSlot.FORMAT_DATETIME)))
                ? value.format(DateTimeFormatter.ofPattern(FORMAT_DATETIME_DISPLAY))
                : MESSAGE_NOT_SET;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Phone // instanceof handles nulls
                && value.equals(((Phone) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    private static LocalDateTime toLocalDateTime(String input) {
        return LocalDateTime.parse(input, DateTimeFormatter.ofPattern(FORMAT_DATETIME));
    }
}
