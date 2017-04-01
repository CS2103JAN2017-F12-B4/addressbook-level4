package seedu.bulletjournal.logic.commands;


import seedu.bulletjournal.commons.core.EventsCenter;
import seedu.bulletjournal.commons.events.ui.ShowHelpRequestEvent;
import seedu.bulletjournal.logic.commands.exceptions.CommandException;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Opened help window.";

    @Override
    public CommandResult execute() {
        EventsCenter.getInstance().post(new ShowHelpRequestEvent());
        return new CommandResult(SHOWING_HELP_MESSAGE);
    }

    @Override
    public CommandResult undo() throws CommandException {
        // TODO Auto-generated method stub
        return null;
    }
}
