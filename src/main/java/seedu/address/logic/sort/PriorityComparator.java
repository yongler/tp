package seedu.address.logic.sort;

import java.util.Comparator;
import java.util.Optional;

import seedu.address.model.application.Application;
import seedu.address.model.tag.PriorityTagType;
import seedu.address.model.tag.Tag;

public class PriorityComparator implements Comparator<Application> {

    public static final String COMMAND_WORD = "priority";

    private static final String PRIORITY_HIGH = "[" + PriorityTagType.HIGH + "]";
    private static final String PRIORITY_LOW = "[" + PriorityTagType.LOW + "]";

    /**
     * Compares the two application's priority field. Returns a negative integer, zero, or a positive integer as
     * the first argument is less than, equal to, or greater than the second base on alphanumeric order.
     * The default order from ascending to descend is as follows HIGH, MEDIUM, LOW.
     * An empty tag will be considered as the lowest ranking, ranked below LOW.
     * */
    @Override
    public int compare(Application o1, Application o2) {
        Optional<Tag> p1 = o1.getPriorityTag();
        Optional<Tag> p2 = o2.getPriorityTag();

        if (p1.isPresent() && p2.isEmpty()) {
            return 1;
        } else if (p1.isEmpty() && p2.isPresent()) {
            return -1;
        } else if (p1.isEmpty()) {
            return o1.getName().toString().compareTo(o2.getName().toString());
        } else {
            if (p1.get().toString().equals(p2.get().toString())) {
                return o1.getName().toString().compareTo(o2.getName().toString());
            } else if (p1.get().toString().equals(PRIORITY_HIGH)) {
                return 1;
            } else if (p2.get().toString().equals(PRIORITY_HIGH)) {
                return -1;
            } else if (p2.get().toString().equals(PRIORITY_LOW)) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    @Override
    public String toString() {
        return COMMAND_WORD;
    }
}
