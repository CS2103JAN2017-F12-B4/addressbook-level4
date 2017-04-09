package seedu.bulletjournal.model.task;

import java.util.Date;

import seedu.bulletjournal.model.tag.UniqueTagList;

/**
 * A read-only immutable interface for a Task in the addressbook.
 * Implementations should guarantee: details are present and not null, field values are validated.
 */
public interface ReadOnlyTask {

    TaskName getTaskName();
    DueDate getPhone();
    Status getStatus();
    BeginDate getAddress();
    Date getSortDate();


    /**
     * The returned TagList is a deep copy of the internal TagList,
     * changes on the returned list will not affect the task's internal tags.
     */
    UniqueTagList getTags();

    //@@author A0105748B
    /**
     * Returns true if both have the same state. (interfaces cannot override .equals)
     */
    default boolean isSameStateAs(ReadOnlyTask other) {
        return other == this // short circuit if same object
                || (other != null // this is first to avoid NPE below
                && other.getTaskName().equals(this.getTaskName()) // state checks here onwards
                && (other.getPhone() == null ?
                        "" : other.getPhone()).equals(this.getPhone() == null ?
                                "" : this.getPhone())
                && (other.getStatus() == null ?
                        "" : other.getStatus()).equals(this.getStatus() == null ?
                                "" : this.getStatus())
                && (other.getAddress() == null ?
                        "" : other.getAddress()).equals(this.getAddress() == null ?
                                "" : this.getAddress()));
    }
    //@@author

    /**
     * Formats the task as text, showing all contact details.
     */
    default String getAsText() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getTaskName())
                .append(" Begin date: ")
                .append(getAddress())
                .append(" Due date: ")
                .append(getPhone())
                .append(" Status: ")
                .append(getStatus())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }

}
