/*@@author A0115959R*/
package seedu.bulletjournal.logic.parser;


import seedu.bulletjournal.logic.commands.ChangePathCommand;
import seedu.bulletjournal.logic.commands.Command;

public class ChangePathCommandParser {
    public Command parse(String args) {
        return new ChangePathCommand(args.trim());
    }
}
