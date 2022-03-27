package seedu.address.logic.sort;

import java.util.Comparator;
import java.util.Optional;

import seedu.address.model.application.Application;
import seedu.address.model.tag.PriorityTag;
import seedu.address.model.tag.PriorityTagType;

public class PriorityComparator implements Comparator<Application> {

    public static final String COMMAND_WORD = "priority";

    @Override
    public int compare(Application o1, Application o2) {
        Optional<PriorityTag> p1 = o1.getPriorityTag();
        Optional<PriorityTag> p2 = o2.getPriorityTag();

        if (p1.isPresent() && p2.isEmpty()) {
            return 1;
        } else if (p1.isEmpty() && p2.isPresent()) {
            return -1;
        } else if (p1.isEmpty()) {
            return o1.getName().toString().compareTo(o2.getName().toString());
        } else {
            if (p1.get().toString().equals(p2.get().toString())) {
                return 0;
            } else if (p1.get().toString().equals(PriorityTagType.HIGH.toString())) {
                return 1;
            } else if (p2.get().toString().equals(PriorityTagType.HIGH.toString())) {
                return -1;
            } else if (p2.get().toString().equals(PriorityTagType.LOW.toString())) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
