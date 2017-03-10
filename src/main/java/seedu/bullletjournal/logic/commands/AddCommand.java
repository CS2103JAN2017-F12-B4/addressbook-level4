package seedu.bullletjournal.logic.commands;

import java.util.HashSet;
import java.util.Set;

import seedu.bullletjournal.commons.exceptions.IllegalValueException;
import seedu.bullletjournal.logic.commands.exceptions.CommandException;
import seedu.bullletjournal.model.tag.Tag;
import seedu.bullletjournal.model.tag.UniqueTagList;
import seedu.bullletjournal.model.task.Detail;
import seedu.bullletjournal.model.task.Status;
import seedu.bullletjournal.model.task.Description;
import seedu.bullletjournal.model.task.Task;
import seedu.bullletjournal.model.task.Deadline;
import seedu.bullletjournal.model.task.UniqueTaskList;

/**
 * Adds a person to the address book.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a person to the address book. "
            + "Parameters: NAME p/PHONE e/EMAIL a/ADDRESS  [t/TAG]...\n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 t/friends t/owesMoney";

    public static final String MESSAGE_SUCCESS = "New person added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";

    private final Task toAdd;

    /**
     * Creates an AddCommand using raw values.
     *
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public AddCommand(String name, String phone, String email, String address, Set<String> tags)
            throws IllegalValueException {
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(new Tag(tagName));
        }
        this.toAdd = new Task(
                new Description(name),
                new Deadline(phone),
                new Status(email),
                new Detail(address),
                new UniqueTagList(tagSet)
        );
    }

    @Override
    public CommandResult execute() throws CommandException {
        assert model != null;
        try {
            model.addPerson(toAdd);
            return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
        } catch (UniqueTaskList.DuplicatePersonException e) {
            throw new CommandException(MESSAGE_DUPLICATE_PERSON);
        }

    }

}