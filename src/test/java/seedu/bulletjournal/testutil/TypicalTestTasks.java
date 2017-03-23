package seedu.bulletjournal.testutil;

import seedu.bulletjournal.commons.exceptions.IllegalValueException;
import seedu.bulletjournal.model.TodoList;
import seedu.bulletjournal.model.task.Task;
import seedu.bulletjournal.model.task.UniqueTaskList;

/**
 *
 */
public class TypicalTestTasks {

    public TestTask assignment, buymilk, creatework, dumpmilk, eatleftovers, findsocks, getclothes, hangclothes,
            interviewprep;

    public TypicalTestTasks() {
        try {
            assignment = new TaskBuilder().withTaskName("Assignment for CS2103").withStatus("undone")
                    .withDueDate("30042017").withTags("friends").build();
            buymilk = new TaskBuilder().withTaskName("Buy milk").withStatus("done").withDueDate("11/11")
                    .withTags("owesMoney", "friends").build();
            creatework = new TaskBuilder().withTaskName("Create more work").withDueDate("now").withStatus("done")
                    .build();
            dumpmilk = new TaskBuilder().withTaskName("Dump milk").withDueDate("11-02 12:10").withStatus("undone")
                    .build();
            eatleftovers = new TaskBuilder().withTaskName("Eat leftovers").withDueDate("today").withStatus("done")
                    .build();
            findsocks = new TaskBuilder().withTaskName("Find socks").withDueDate("tomorrow").withStatus("undone")
                    .build();
            getclothes = new TaskBuilder().withTaskName("Get clothes").withDueDate("yesterday").withStatus("undone")
                    .build();

            // Manually added
            hangclothes = new TaskBuilder().withTaskName("Hang up clothes").withDueDate("30/12/17").withStatus("done")
                    .build();
            interviewprep = new TaskBuilder().withTaskName("Interview preparation").withDueDate("03/31")
                    .withStatus("undone").build();
        } catch (IllegalValueException e) {
            e.printStackTrace();
            assert false : "not possible";
        }
    }

    public static void loadTodoListWithSampleData(TodoList ab) {
        for (TestTask task : new TypicalTestTasks().getTypicalTasks()) {
            try {
                ab.addTask(new Task(task));
            } catch (UniqueTaskList.DuplicateTaskException e) {
                assert false : "not possible";
            }
        }
    }

    public TestTask[] getTypicalTasks() {
        return new TestTask[] { assignment, buymilk, creatework, dumpmilk, eatleftovers, findsocks, getclothes };
    }

    public TodoList getTypicalTodoList() {
        TodoList ab = new TodoList();
        loadTodoListWithSampleData(ab);
        return ab;
    }
}
