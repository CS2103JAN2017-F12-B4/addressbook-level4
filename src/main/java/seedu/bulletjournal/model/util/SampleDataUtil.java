package seedu.bulletjournal.model.util;

import seedu.bulletjournal.commons.exceptions.IllegalValueException;
import seedu.bulletjournal.model.ReadOnlyTodoList;
import seedu.bulletjournal.model.TodoList;
import seedu.bulletjournal.model.tag.UniqueTagList;
import seedu.bulletjournal.model.task.DateTime;
import seedu.bulletjournal.model.task.Status;
import seedu.bulletjournal.model.task.Task;
import seedu.bulletjournal.model.task.TaskName;
import seedu.bulletjournal.model.task.UniqueTaskList.DuplicateTaskException;

public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        try {
            return new Task[] {
                    new Task(new TaskName("Assignment for CS"), new DateTime("today"), new Status("undone"),
                            new UniqueTagList("friends")),
                    new Task(new TaskName("Burn homework"), new DateTime("tomorrow"), new Status("undone"),
                            new UniqueTagList("colleagues", "friends")),
                    new Task(new TaskName("Carry burdens"), new DateTime("3103"), new Status("undone"),
                            new UniqueTagList("neighbours")),
                    new Task(new TaskName("Destroy homework"), new DateTime("20180501"), new Status("undone"),
                            new UniqueTagList("family")),
                    new Task(new TaskName("Irrigate fields"), new DateTime("12/12 22:30"), new Status("undone"),
                            new UniqueTagList("classmates")),
                    new Task(new TaskName("Return bicycle"), new DateTime("2017-03-25"), new Status("undone"),
                            new UniqueTagList("colleagues")) };
        } catch (IllegalValueException e) {
            throw new AssertionError("sample data cannot be invalid", e);
        }
    }

    public static ReadOnlyTodoList getSampleTodoList() {
        try {
            TodoList sampleAB = new TodoList();
            for (Task sampleTask : getSampleTasks()) {
                sampleAB.addTask(sampleTask);
            }
            return sampleAB;
        } catch (DuplicateTaskException e) {
            throw new AssertionError("sample data cannot contain duplicate tasks", e);
        }
    }
}
