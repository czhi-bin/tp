package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Sorts the contacts in the address book.
 */
public class SortCommand extends Command{

    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_SUCCESS = "Address book sorted.";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts the contact in the address book in alphabetical order.\n"
            + "Example: " + COMMAND_WORD + " -a";


    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.sortsAddressBook();
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
