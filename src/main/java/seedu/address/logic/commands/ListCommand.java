package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_APPLICATIONS;

import javafx.collections.transformation.FilteredList;
import seedu.address.logic.sort.InterviewSlotComparator;
import seedu.address.logic.sort.NameComparator;
import seedu.address.logic.sort.PriorityComparator;
import seedu.address.model.Model;
import seedu.address.model.application.Application;
import seedu.address.model.application.NameContainsKeywordsPredicate;

import java.util.Comparator;
import java.util.Optional;

/**
 * Lists all applications in InternApply to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String COMMAND_ORDER_WORD_ASCENDING = "ASC";

    public static final String COMMAND_ORDER_WORD_DESCENDING = "DESC";

    public static final String MESSAGE_SUCCESS = "Listed filtered applications";
    // TODO: Update it to variable as per edit

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Show a filtered list of all applications with the "
            + "selected parameter.\n"
            + "Parameters: [FIELD "
                + NameComparator.COMMAND_WORD + "|"
                + InterviewSlotComparator.COMMAND_WORD + "|"
                + PriorityComparator.COMMAND_WORD + " "
            + "[ORDER " + COMMAND_ORDER_WORD_ASCENDING + "|" + COMMAND_ORDER_WORD_DESCENDING + "] \n"
            + "Example: " + COMMAND_WORD + " INTERVIEW " + COMMAND_ORDER_WORD_DESCENDING + "\n"
            + "Note: For default listing use " + COMMAND_WORD + " [ORDER] without the sorting field.";

    private final Optional<Comparator<Application>> sortingComparator;
    private final String orderBy;

    public ListCommand() {
        sortingComparator = Optional.empty();
        orderBy = COMMAND_ORDER_WORD_ASCENDING;
    }

    public ListCommand(Comparator<Application> sortingComparator, String orderBy) {
        this.sortingComparator = Optional.ofNullable(sortingComparator);
        this.orderBy = orderBy;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredApplicationList(PREDICATE_SHOW_ALL_APPLICATIONS);

        FilteredList<Application> filteredApplications = new FilteredList<>(model
                .getInternApplyMemory().getApplicationList());

        if (sortingComparator.isEmpty()) {
            model.setFilteredApplicationList(filteredApplications);
        } else {
//            filteredApplications.sort(sortingComparator.get());
//            model.setFilteredApplicationList(filteredApplications);
            System.out.println("ok");
            model.getFilteredApplicationList().sort(sortingComparator.get());
        }
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
