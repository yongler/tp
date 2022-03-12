package seedu.address.model.application;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the interview date and time of an Application in InternApply.
 */

public class InterviewDateTime {

    public static final String MESSAGE_CONSTRAINTS =
            "Interview date should be of the format d-mm-yyyy hh:mm and "
                    + "should only contain numbers and respective separators";
    public static final String VALIDATION_REGEX =
            "^([1-9]|([012][0-9])|(3[01]))\\-([0]{0,1}[1-9]|1[012])\\-\\d\\d\\d\\d\\s([0-1]?[0-9]|2?[0-3]):([0-5]\\d)$";
    public final String value;

    /**
     * Constructs a {@code InterviewDateTime}.
     *
     * @param interviewDateTime A valid interview date and time.
     */
    public InterviewDateTime(String interviewDateTime) {
        requireNonNull(interviewDateTime);
        checkArgument(isValidPhone(interviewDateTime), MESSAGE_CONSTRAINTS);
        value = interviewDateTime;
    }

    /**
     * Returns true if a given string is a valid date and time.
     */
    public static boolean isValidPhone(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
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

}
