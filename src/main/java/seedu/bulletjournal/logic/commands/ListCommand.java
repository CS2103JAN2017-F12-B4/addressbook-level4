package seedu.bulletjournal.logic.commands;

import seedu.bulletjournal.logic.commands.exceptions.CommandException;

/**
 * Lists all tasks in the address book to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all tasks";


    @Override
    public CommandResult execute() {
        model.updateFilteredListToShowAll();
        return new CommandResult(MESSAGE_SUCCESS);
    }


    @Override
    public CommandResult undo() throws CommandException {
        // TODO Auto-generated method stub
        return null;
    }
}
