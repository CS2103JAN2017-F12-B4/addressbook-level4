package seedu.bulletjournal.logic.commands;

import java.util.List;
import java.util.Optional;

import seedu.bulletjournal.commons.core.Messages;
import seedu.bulletjournal.commons.util.CollectionUtil;
import seedu.bulletjournal.logic.commands.exceptions.CommandException;
import seedu.bulletjournal.model.tag.UniqueTagList;
import seedu.bulletjournal.model.task.DateTime;
import seedu.bulletjournal.model.task.ReadOnlyTask;
import seedu.bulletjournal.model.task.Status;
import seedu.bulletjournal.model.task.Task;
import seedu.bulletjournal.model.task.TaskName;
import seedu.bulletjournal.model.task.UniqueTaskList;

/**
 * Edits the details of an existing person in the address book.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    // CODESTYLE.OFF: RuleName
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Edits the details of the task identified "
            + "by the index number used in the last task listing. "
            + "Existing values will be overwritten by the input values.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[TASKNAME] [d/DateTime] [s/STATUS] [b/BEGINDATE ] [t/TAG]...\n" + "Example: " + COMMAND_WORD
            + " 1 d/91234567 s/undone";
    // CODESTYLE.ON: RuleName
    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Task: %1$s";
    public static final String MESSAGE_NOT_EDITED = "At least one field to edit must be provided.";
    public static final String MESSAGE_DUPLICATE_TASK = "This task already exists in the todo list.";

    private final int filteredPersonListIndex;
    private final EditTaskDescriptor editTaskDescriptor;

    /**
     * @param filteredPersonListIndex
     *            the index of the person in the filtered person list to edit
     * @param editTaskDescriptor
     *            details to edit the person with
     */
    public EditCommand(int filteredPersonListIndex, EditTaskDescriptor editTaskDescriptor) {
        assert filteredPersonListIndex > 0;
        assert editTaskDescriptor != null;

        // converts filteredPersonListIndex from one-based to zero-based.
        this.filteredPersonListIndex = filteredPersonListIndex - 1;

        this.editTaskDescriptor = new EditTaskDescriptor(editTaskDescriptor);
    }

    @Override
    public CommandResult execute() throws CommandException {
        List<ReadOnlyTask> lastShownList = model.getFilteredPersonList();

        if (filteredPersonListIndex >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_TASK_DISPLAYED_INDEX);
        }

        ReadOnlyTask personToEdit = lastShownList.get(filteredPersonListIndex);
        Task editedPerson = createEditedPerson(personToEdit, editTaskDescriptor);

        try {
            model.updateTask(filteredPersonListIndex, editedPerson);
        } catch (UniqueTaskList.DuplicateTaskException dpe) {
            throw new CommandException(MESSAGE_DUPLICATE_TASK);
        }
        model.updateFilteredListToShowAll();
        return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, personToEdit));
    }

    /**
     * Creates and returns a {@code Person} with the details of
     * {@code personToEdit} edited with {@code editPersonDescriptor}.
     */
    private static Task createEditedPerson(ReadOnlyTask personToEdit, EditTaskDescriptor editTaskDescriptor) {
        assert personToEdit != null;

        TaskName updatedName = editTaskDescriptor.getTaskName().orElseGet(personToEdit::getTaskName);
        DateTime updatedDeadline = editTaskDescriptor.getDeadline().orElseGet(personToEdit::getEndDate);
        Status updatedStatus = editTaskDescriptor.getStatus().orElseGet(personToEdit::getStatus);
        UniqueTagList updatedTags = editTaskDescriptor.getTags().orElseGet(personToEdit::getTags);

        return new Task(updatedName, updatedDeadline, updatedStatus, updatedTags);
    }

    /**
     * Stores the details to edit the person with. Each non-empty field value
     * will replace the corresponding field value of the person.
     */
    public static class EditTaskDescriptor {
        private Optional<TaskName> taskName = Optional.empty();
        private Optional<DateTime> deadline = Optional.empty();
        private Optional<Status> status = Optional.empty();
        private Optional<UniqueTagList> tags = Optional.empty();

        public EditTaskDescriptor() {
        }

        public EditTaskDescriptor(EditTaskDescriptor toCopy) {
            this.taskName = toCopy.getTaskName();
            this.deadline = toCopy.getDeadline();
            this.status = toCopy.getStatus();
            this.tags = toCopy.getTags();
        }

        /**
         * Returns true if at least one field is edited.
         */
        public boolean isAnyFieldEdited() {
            return CollectionUtil.isAnyPresent(this.taskName, this.deadline, this.status, this.tags);
        }

        public void setName(Optional<TaskName> taskName) {
            assert taskName != null;
            this.taskName = taskName;
        }

        public Optional<TaskName> getTaskName() {
            return taskName;
        }

        public void setDeadline(Optional<DateTime> deadline) {
            assert deadline != null;
            this.deadline = deadline;
        }

        public Optional<DateTime> getDeadline() {
            return deadline;
        }

        public void setEmail(Optional<Status> status) {
            assert status != null;
            this.status = status;
        }

        public Optional<Status> getStatus() {
            return status;
        }

        public void setTags(Optional<UniqueTagList> tags) {
            assert tags != null;
            this.tags = tags;
        }

        public Optional<UniqueTagList> getTags() {
            return tags;
        }
    }
}
