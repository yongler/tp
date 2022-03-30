package seedu.address.logic.sort;

import java.util.Comparator;

import seedu.address.model.application.Application;

public class NameComparator implements Comparator<Application> {

    public static final String COMMAND_WORD = "name";

    @Override
    public int compare(Application o1, Application o2) {
        return o1.getName().toString().compareTo(o2.getName().toString());
    }

    @Override
    public String toString() {
        return COMMAND_WORD;
    }
}
