package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

public class ReminderCommand extends Command{

    public final static String COMMAND_WORD = "reminder";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Reminds you of your upcoming interviews."
            + "If you have no upcoming interviews a response "
            + "informing you as such will be given instead.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_REMINDER_MESSAGE = "Opened reminder window.";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateUpcomingApplicationList(Model.PREDICATE_SHOW_UPCOMING_APPLICATIONS_ONLY);
        return new CommandResult(SHOWING_REMINDER_MESSAGE, false, true, false);
    }
}
