package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.ListCommand.COMMAND_ORDER_WORD_ASCENDING;
import static seedu.address.logic.commands.ListCommand.COMMAND_ORDER_WORD_DESCENDING;

import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.logic.sort.InterviewSlotComparator;
import seedu.address.logic.sort.NameComparator;
import seedu.address.logic.sort.PriorityComparator;

/**
 * Parses input arguments and creates a new ListCommand object
 */
public class ListCommandParser implements Parser<ListCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ListCommand
     * and returns a ListCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public ListCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();

        if (trimmedArgs.isEmpty()) /* Handles default list */ {
            return new ListCommand();
        }

        String[] sortingArgs = trimmedArgs.split("\\s+");

        if (sortingArgs.length == 1) {
            String keyword = sortingArgs[0];
            if (keyword.equals(COMMAND_ORDER_WORD_DESCENDING)) {
                return new ListCommand(null, COMMAND_ORDER_WORD_DESCENDING);
            } else if (keyword.equals(COMMAND_ORDER_WORD_ASCENDING)) {
                return new ListCommand();
            }
        } else {
            String sortingField = sortingArgs[0];
            String orderBy = sortingArgs[1];

            if (validateOrderBy(orderBy)) {
                throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
            } else if (sortingField.equals(NameComparator.COMMAND_WORD)) {
                return new ListCommand(new NameComparator(), orderBy);
            } else if (sortingField.equals(InterviewSlotComparator.COMMAND_WORD)) {
                return new ListCommand(new InterviewSlotComparator(), orderBy);
            } else if (sortingField.equals(PriorityComparator.COMMAND_WORD)) {
                return new ListCommand(new PriorityComparator(), orderBy);
            }
        }

        throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, ListCommand.MESSAGE_USAGE));
    }

    private boolean validateOrderBy(String s) {
        return !s.equals(COMMAND_ORDER_WORD_DESCENDING) && !s.equals(COMMAND_ORDER_WORD_ASCENDING);
    }
}
