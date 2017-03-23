package seedu.bulletjournal.testutil;

import seedu.bulletjournal.commons.exceptions.IllegalValueException;
import seedu.bulletjournal.model.tag.Tag;
import seedu.bulletjournal.model.tag.UniqueTagList;
import seedu.bulletjournal.model.task.DateTime;
import seedu.bulletjournal.model.task.Status;
import seedu.bulletjournal.model.task.TaskName;

/**
 *
 */
public class TaskBuilder {

    private TestTask task;

    public TaskBuilder() {
        this.task = new TestTask();
    }

    /**
     * Initializes the TaskBuilder with the data of {@code taskToCopy}.
     */
    public TaskBuilder(TestTask taskToCopy) {
        this.task = new TestTask(taskToCopy);
    }

    public TaskBuilder withTaskName(String taskName) throws IllegalValueException {
        this.task.setName(new TaskName(taskName));
        return this;
    }

    public TaskBuilder withTags(String... tags) throws IllegalValueException {
        task.setTags(new UniqueTagList());
        for (String tag : tags) {
            task.getTags().add(new Tag(tag));
        }
        return this;
    }

    public TaskBuilder withDueDate(String deadline) throws IllegalValueException {
        this.task.setDeadline(new DateTime(deadline));
        return this;
    }

    public TaskBuilder withStatus(String email) throws IllegalValueException {
        this.task.setEmail(new Status(email));
        return this;
    }

    public TestTask build() {
        return this.task;
    }

}
