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

    private int getStatusRanking(Optional<Tag> t) {
        if (t.isEmpty()) {
            return 1;
        } else if (t.get().toString().equals(NOT_APPLIED.toString())) {
            return 2;
        } else if (t.get().toString().equals(APPLIED.toString())) {
            return 3;
        } else if (t.get().toString().equals(INTERVIEWED.toString())) {
            return 4;
        } else if (t.get().toString().equals(REJECTED.toString())) {
            return 5;
        } else if (t.get().toString().equals(ACCEPTED.toString())) {
            return 6;
        } else {
            return 0;
        }
    }
}
