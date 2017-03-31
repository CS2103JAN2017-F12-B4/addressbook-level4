package seedu.bulletjournal.logic.commands;

import seedu.bulletjournal.commons.core.Messages;
import seedu.bulletjournal.logic.commands.exceptions.CommandException;
import seedu.bulletjournal.model.Model;

/**
 * Represents a command with hidden internal logic and the ability to be executed.
 */
public abstract class Command {
    protected Model model;
    public static final String MESSAGE_UNDO_FAILURE = "Cannot undo";
    /**
     * @@author A0127826Y
     */
    public static final String MESSAGE_UNDO_SUCCESS = "Successfully undo";


    /**
     * Constructs a feedback message to summarise an operation that displayed a listing of tasks.
     *
     * @param displaySize used to generate summary
     * @return summary message for tasks displayed
     */
    public static String getMessageForTaskListShownSummary(int displaySize) {
        return String.format(Messages.MESSAGE_TASKS_LISTED_OVERVIEW, displaySize);
    }

    /**
     * Executes the command and returns the result message.
     *
     * @return feedback message of the operation result for display
     * @throws CommandException If an error occurs during command execution.
     */
    public abstract CommandResult execute() throws CommandException;

    /**
     * Undoes the command and return the result message.
     *
     * @return feedback message of which command is undone
     * @throws CommandException if an error occurs during command execution.
     * @@author A0127826Y
     */
    public abstract CommandResult undo() throws CommandException;

    /**
     * Provides any needed dependencies to the command.
     * Commands making use of any of these should override this method to gain
     * access to the dependencies.
     */
    public void setData(Model model) {
        this.model = model;
    }
}
