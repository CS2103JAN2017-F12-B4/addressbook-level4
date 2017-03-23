package seedu.bulletjournal.model.task;

import java.util.Objects;

import seedu.bulletjournal.commons.util.CollectionUtil;
import seedu.bulletjournal.model.tag.UniqueTagList;

/**
 * Represents a Task in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Task implements ReadOnlyTask {

    private TaskName taskName;

    /**
     * @author A0127826Y
     */
    private DateTime deadline;
    private Status status;

    private UniqueTagList tags;

    /**
     * Every field must be present and not null.
     */
    public Task(TaskName taskName, DateTime deadline, Status status, UniqueTagList tags) {
        assert !CollectionUtil.isAnyNull(taskName, deadline, status, tags);
        this.taskName = taskName;
        this.deadline = deadline;
        this.status = status;
        this.tags = new UniqueTagList(tags); // protect internal tags from
                                             // changes in the arg list
    }

    /**
     * Creates a copy of the given ReadOnlyTask.
     */
    public Task(ReadOnlyTask source) {
        this(source.getTaskName(), source.getEndDate(), source.getStatus(), source.getTags());
    }

    public void setName(TaskName taskName) {
        assert taskName != null;
        this.taskName = taskName;
    }

    @Override
    public TaskName getTaskName() {
        return taskName;
    }

    /**
     * @author A0127826Y
     */
    public void setDeadline(DateTime dueDate) {
        assert dueDate != null;
        this.deadline = dueDate;
    }

    /**
     * @author A0127826Y
     */

    @Override
    public DateTime getEndDate() {
        return deadline;
    }

    public void setStatus(Status status) {
        assert status != null;
        this.status = status;
    }

    @Override
    public Status getStatus() {
        return status;
    }

    @Override
    public UniqueTagList getTags() {
        return new UniqueTagList(tags);
    }

    /**
     * Replaces this task's tags with the tags in the argument tag list.
     */
    public void setTags(UniqueTagList replacement) {
        tags.setTags(replacement);
    }

    /**
     * Updates this task with the details of {@code replacement}.
     */
    public void resetData(ReadOnlyTask replacement) {
        assert replacement != null;

        this.setName(replacement.getTaskName());
        this.setDeadline(replacement.getEndDate());
        this.setStatus(replacement.getStatus());
        this.setTags(replacement.getTags());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ReadOnlyTask // instanceof handles nulls
                        && this.isSameStateAs((ReadOnlyTask) other));
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing
        // your own
        return Objects.hash(taskName, deadline, status, tags);
    }

    @Override
    public String toString() {
        return getAsText();
    }

}
