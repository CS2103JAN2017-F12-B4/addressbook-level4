package seedu.bullletjournal.logic;

import javafx.collections.ObservableList;
import seedu.bullletjournal.logic.commands.CommandResult;
import seedu.bullletjournal.logic.commands.exceptions.CommandException;
import seedu.bullletjournal.model.task.ReadOnlyTask;

/**
 * API of the Logic component
 */
public interface Logic {
    /**
     * Executes the command and returns the result.
     * @param commandText The command as entered by the user.
     * @return the result of the command execution.
     * @throws CommandException If an error occurs during command execution.
     */
    CommandResult execute(String commandText) throws CommandException;

    /** Returns the filtered list of persons */
    ObservableList<ReadOnlyTask> getFilteredPersonList();

}