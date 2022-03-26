package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

public class ReminderCommand extends Command{

    public final static String COMMAND_WORD = "reminder";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Reminds you of your upcoming interviews."
            + "If you have no upcoming intervi  ews a response "
            + "informing you as such will be given instead.\n"
            + "Example: " + COMMAND_WORD;

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "Remark command not implemented yet";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult(MESSAGE_NOT_IMPLEMENTED_YET);
    }
}
