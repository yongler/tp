package seedu.address.logic.sort;

import static seedu.address.model.tag.ApplicationStatusTagType.ACCEPTED;
import static seedu.address.model.tag.ApplicationStatusTagType.APPLIED;
import static seedu.address.model.tag.ApplicationStatusTagType.INTERVIEWED;
import static seedu.address.model.tag.ApplicationStatusTagType.NOT_APPLIED;
import static seedu.address.model.tag.ApplicationStatusTagType.REJECTED;

import java.util.Comparator;
import java.util.Optional;

import seedu.address.model.application.Application;
import seedu.address.model.tag.Tag;

public class ApplicationStatusComparator implements Comparator<Application> {

    public static final String COMMAND_WORD = "status";

    @Override
    public int compare(Application o1, Application o2) {
        return getStatusRanking(o1.getApplicationStatusTag()) - getStatusRanking(o2.getApplicationStatusTag());
    }

    /**
     * Compares the two application's status tag field. Returns a negative integer, zero, or a positive integer as
     * the first argument is less than, equal to, or greater than the second base on alphanumeric order.
     * The default order from ascending to descend is as follows ACCEPTED, REJECTED, INTERVIEWED, APPLIE and
     * NOT_APPLIED.
     * An empty tag will be considered as the lowest ranking, ranked below NOT_APPLIED.
     * */
    private int getStatusRanking(Optional<Tag> t) {
        if (t.isEmpty()) {
            return 6;
        } else if (t.get().toString().equals(NOT_APPLIED.toString())) {
            return 5;
        } else if (t.get().toString().equals(APPLIED.toString())) {
            return 4;
        } else if (t.get().toString().equals(INTERVIEWED.toString())) {
            return 3;
        } else if (t.get().toString().equals(REJECTED.toString())) {
            return 2;
        } else if (t.get().toString().equals(ACCEPTED.toString())) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return COMMAND_WORD;
    }
}
