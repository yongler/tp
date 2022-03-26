package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Reminds the user of upcoming interviews
 */
public class ReminderCommand extends Command{

    public static final String COMMAND_WORD = "reminder";

    @Override
    public CommandResult execute(Model model) throws CommandException {
        return new CommandResult("This is a reminder");
    }
}
