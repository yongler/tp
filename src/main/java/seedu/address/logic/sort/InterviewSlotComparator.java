package seedu.address.logic.sort;

import java.util.Comparator;

import seedu.address.model.application.Application;

public class InterviewSlotComparator implements Comparator<Application> {

    public static final String COMMAND_WORD = "interview";

    /**
     * Compares the two application's interview slot field. Returns a negative integer, zero, or a positive integer as
     * the first argument is less than, equal to, or greater than the second base on alphanumeric order.
     * */
    @Override
    public int compare(Application o1, Application o2) {
        return o1.getInterviewSlot().getValue().compareTo(o2.getInterviewSlot().getValue());
    }

    @Override
    public String toString() {
        return COMMAND_WORD;
    }
}
