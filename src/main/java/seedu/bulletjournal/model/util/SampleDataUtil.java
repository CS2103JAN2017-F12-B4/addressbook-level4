//@@author A0105748B

package seedu.bulletjournal.model.util;

import seedu.bulletjournal.commons.exceptions.IllegalValueException;
import seedu.bulletjournal.model.ReadOnlyTodoList;
import seedu.bulletjournal.model.TodoList;
import seedu.bulletjournal.model.tag.UniqueTagList;
import seedu.bulletjournal.model.task.BeginDate;
import seedu.bulletjournal.model.task.DueDate;
import seedu.bulletjournal.model.task.Status;
import seedu.bulletjournal.model.task.Task;
import seedu.bulletjournal.model.task.TaskName;
import seedu.bulletjournal.model.task.UniqueTaskList.DuplicateTaskException;

/**
 * Class for sample data to be loaded into the TodoList
 */

public class SampleDataUtil {
    public static Task[] getSampleTasks() {
        try {
            return new Task[] {
                new Task(new TaskName("Assignment for CS"), new DueDate("9th April 4pm"), new Status("undone"),
                            new BeginDate("9th April 2pm"), new UniqueTagList("school")),
                new Task(new TaskName("Do laundry"), null, new Status("undone"),
                            new BeginDate("8th April 1pm"), new UniqueTagList("life")),
                new Task(new TaskName("Take shower"), null, new Status("undone"),
                            new BeginDate("8th April 9pm"), new UniqueTagList("life")),
                new Task(new TaskName("Play basketball"), new DueDate("9th April 9pm"), new Status("undone"),
                            new BeginDate("9th April 7pm"), new UniqueTagList("life")),
                new Task(new TaskName("Change test cases"), new DueDate("10th April 10am"), new Status("undone"),
                            new BeginDate("10th April 8am"), new UniqueTagList("school")),
                new Task(new TaskName("Submit cs project"), new DueDate("10th April 12pm"), new Status("undone"),
                            null, new UniqueTagList("deadline")),
                new Task(new TaskName("project meeting"), null, new Status("undone"),
                            new BeginDate("10th April 6am"), new UniqueTagList("school")),
                new Task(new TaskName("CCA meeting"), new DueDate("15th April 12pm"), new Status("undone"),
                            new BeginDate("15th April 10am"), new UniqueTagList("cca")),
                new Task(new TaskName("go get a drink"), null, new Status("undone"),
                            new BeginDate("10th April 12:15"), new UniqueTagList("life")),
                new Task(new TaskName("Richard birthday"), null, new Status("undone"),
                            new BeginDate("20th May 12am"), new UniqueTagList("life")),
                new Task(new TaskName("Relocate plants"), null, new Status("undone"),
                            new BeginDate("16th April 5pm"), new UniqueTagList("life")),
                new Task(new TaskName("Study hacking"), new DueDate("22th April 4pm"), new Status("undone"),
                            new BeginDate("27th April 9am"), new UniqueTagList("life")),
                new Task(new TaskName("Apply for volunteer"), new DueDate("27th April 23:59"), new Status("undone"),
                            null, new UniqueTagList("deadline")),
                new Task(new TaskName("Buy new laptop"), null, new Status("undone"),
                            new BeginDate("29th April 2pm"), new UniqueTagList("life")),
                new Task(new TaskName("Buy new sandals"), null, new Status("undone"),
                            new BeginDate("29th April 2016 2pm"), new UniqueTagList("life")),
                new Task(new TaskName("Buy gift for Danny"), new DueDate("30th April 5pm"), new Status("undone"),
                            new BeginDate("30th April 2016 2pm"), new UniqueTagList("life")),
                new Task(new TaskName("3241 project due"), new DueDate("17th April 23:59"), new Status("undone"),
                            null, new UniqueTagList("deadline")),
                new Task(new TaskName("FYP presentation"), new DueDate("20th April 4pm"), new Status("undone"),
                            new BeginDate("20th April 12pm"), new UniqueTagList("school")),
                new Task(new TaskName("Submit FYP report"), new DueDate("24th March 4pm"), new Status("undone"),
                            null, new UniqueTagList("deadline")),
                new Task(new TaskName("Order Mcdonald"), null, new Status("undone"),
                            new BeginDate("24th March 4:15"), new UniqueTagList("life")),
                new Task(new TaskName("CS quiz"), new DueDate("22th February 3pm"), new Status("undone"),
                            new BeginDate("22th February 2pm"), new UniqueTagList("school")),
                new Task(new TaskName("Watch webcast"), new DueDate("21th February 9pm"), new Status("undone"),
                            new BeginDate("21th February 9am"), new UniqueTagList("school")),
                new Task(new TaskName("Print out pyp"), new DueDate("30th April 8am"), new Status("undone"),
                            new BeginDate("30th April 7am"), new UniqueTagList("school")),
                new Task(new TaskName("Check tutorial answer"), new DueDate("1 march 4pm"), new Status("undone"),
                            new BeginDate("1 march 12pm"), new UniqueTagList("school")),
                new Task(new TaskName("Revise for finals"), new DueDate("5th May 4pm"), new Status("undone"),
                            new BeginDate("30th April 12pm"), new UniqueTagList("school")),
                new Task(new TaskName("Buy eye drops"), new DueDate("9th Jan 3pm"), new Status("undone"),
                            new BeginDate("9th Jan 2pm"), new UniqueTagList("life")),
                new Task(new TaskName("Wash backpack"), null, new Status("undone"),
                            new BeginDate("10th May 2016 2pm"), new UniqueTagList("life")),
                new Task(new TaskName("Buy planting pots"), null, new Status("undone"),
                            new BeginDate("1 April 11pm"), new UniqueTagList("life")),
                new Task(new TaskName("Clean aircon"), new DueDate("1th April 2pm"), new Status("undone"),
                            new BeginDate("1th April 1pm"), new UniqueTagList("life")),
                new Task(new TaskName("Econs sharing session"), new DueDate("16th May 12pm"), new Status("undone"),
                            new BeginDate("16th May 2016 9am"), new UniqueTagList("school")),
                new Task(new TaskName("Google interview"), null, new Status("undone"),
                            new BeginDate("22th May 2018"), new UniqueTagList("work")),
                new Task(new TaskName("Read new novel"), null, null,
                            null, new UniqueTagList("life")),
                new Task(new TaskName("Dinner with girlfriend"), new DueDate("22th May 9pm"), new Status("undone"),
                            new BeginDate("22th May 6pm"), new UniqueTagList("life")),
                new Task(new TaskName("Move to new hostel"), null, new Status("undone"),
                            new BeginDate("1 May 2016"), new UniqueTagList("life")),
                new Task(new TaskName("Fly to Taipei"), new DueDate("1 June 2pm"), new Status("undone"),
                            new BeginDate("1 June 10am"), new UniqueTagList("travel")),
                new Task(new TaskName("Visit night markets"), new DueDate("1 June 11pm"), new Status("undone"),
                            new BeginDate("1 June 7pm"), new UniqueTagList("travel")),
                new Task(new TaskName("Buy souvenir for friends"), new DueDate("10 June 3pm"), new Status("undone"),
                            new BeginDate("1 June 2pm"), new UniqueTagList("travel")),
                new Task(new TaskName("Bus to Hualian"), new DueDate("10th June 6pm"), new Status("undone"),
                            new BeginDate("10th June 3pm"), new UniqueTagList("travel")),
                new Task(new TaskName("Book hotel in Beijing"), null, new Status("undone"),
                            new BeginDate("10th June 4pm"), new UniqueTagList("travel")),
                new Task(new TaskName("Fly to Tianjin"), new DueDate("15th June 5pm"), new Status("undone"),
                            new BeginDate("15th June 12pm"), new UniqueTagList("travel")),
                new Task(new TaskName("Watch Beijing opera"), new DueDate("20th June 9:30"), new Status("undone"),
                            new BeginDate("20th June 7pm"), new UniqueTagList("travel")),
                new Task(new TaskName("Fly to Paris"), new DueDate("10th July 11am"), new Status("undone"),
                            new BeginDate("10th July 2am"), new UniqueTagList("travel")),
                new Task(new TaskName("Visit London bridge"), new DueDate("13th July 5am"), new Status("undone"),
                            new BeginDate("13th July 3am"), new UniqueTagList("travel")),
                new Task(new TaskName("Shopping for CNY"), new DueDate("10th February 2018"), new Status("undone"),
                            new BeginDate("4th March"), new UniqueTagList("life")),
                new Task(new TaskName("Buy watermelon"), null, new Status("undone"),
                            new BeginDate("8th April 6pm"), new UniqueTagList("life")),
                new Task(new TaskName("Internship report"), new DueDate("23th June 23:59"), new Status("undone"),
                            null, new UniqueTagList("deadline")),
                new Task(new TaskName("Internship presentation"), new DueDate("20th June 12pm"), new Status("undone"),
                            new BeginDate("20th June 10am"), new UniqueTagList("work")),
                new Task(new TaskName("Site visit"), new DueDate("20th June 2pm"), new Status("undone"),
                            new BeginDate("20th June 12pm"), new UniqueTagList("work")),
                new Task(new TaskName("Call mom"), null, null,
                            null, new UniqueTagList("life")),
                new Task(new TaskName("Ride bicycle"), new DueDate("11th June 1am"), new Status("undone"),
                            new BeginDate("10th June 7pm"), new UniqueTagList("travel")) };
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
