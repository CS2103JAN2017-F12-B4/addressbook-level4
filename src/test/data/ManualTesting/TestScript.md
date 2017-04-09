# Manual Testing
This document will describe the steps to do manual testing on _bulletjournal_.

## Setting Up
1. Download `bulletjournal.jar` from our Github repository release page.
2. Double click `bulletjournal.jar` to run the application. 50 tasks should be loaded in the task list panel.

## Test Cases

### Request help window
1. Type `help` to display the help window.
2. The help window should display as a popup.

### Add a floating task
1. Enter `add watch silicon valley`.
2. The task will be added to the end of the task list.
3. Enter `select 51` to see the newly added task.

### Add a deadline
1. Enter `add prepare cs2103 exam d/22 April 2015 8pm`
2. The deadline should be added as the first task in the list since the tasks are sorted by date.

### Add an event
1. Enter `add attend cs2103 workshop b/ tomorrow 8pm d/ next monday 8pm`.
2. The event should be added successfully. It can be seen from the ResultDisplay window.
3. It can be found by entering `find cs2013`

### Add an event with tags
1. Enter `add exam period b/ 22 april d/ 5 may 2017 t/ exam`
2. The event should be added successfully. It can be seen from the ResultDisplay window.
3. It can be found by entering `f exam`

### Edit a task description
1. Observe the current task name at index 1.
2. Enter `edit 1 buy many presents`.
3. The task name at index 1 should change to `buy many presents`.

### Edit a task with multiple fields
1. Observe the current task values at index 1.
2. Enter `edit 1 celebrate birthday b/ tomorrow 8pm d/tomorrow 9pm t/birthday`
3. The task fields should change to `celebrate birthday`, start date to tomorrow 8pm (relative), end date to 9pm (relative), with tags birthday. But the task's index may not be 1 anymore since it is ordered by date.
4. It can be found by entering `find birthday`

### Edit a task with multiple fields in any order
1. Observe the current task values at index 1.
2. Enter `edit 1 celebrate Jenny birthday t/birthday d/tomorrow 9pm b/ tomorrow 8pm`.
3. The task fields should change to `celebrate Jenny birthday`, start date to tomorrow 8pm (relative), end date to 9pm (relative), with tags birthday. But the task's index may not be 1 anymore since it is ordered by date.
4. It can be found by entering `find birthday`

### mark a task as done
1. Enter `finish 1`.
2. The task should disappear from home tab.
3. Enter `show done`.
4. The task you just marked will be displayed.

### Delete a task
1. Enter `list`
1. Enter `delete 1`.
2. The first task should be removed.
3. Enter `d 1`
4. The new first task should be removed.

### Undo an action
1. Enter `undo`.
2. The task you deleted in the previous test case will be recovered.

### Undo multiple times
1. Enter `undo`.
2. The earlier deleted task should recover.
3. Enter `undo` again.
4. ResultDisplay panel should show `No more actions available to undo`.

### Redo an action
1. Enter `redo`.
2. The first task will be deleted again.

### Redo multiple times
1. Enter `redo`.
2. The new first task should be deleted again.

### Find all task by name
1. Enter `find tutorial`
2. All tasks name that contain keyword `tutorial` should appear in the list.
3. Enter `list` to reset the home tab display.

### Change path for saving data file
1. Enter `change newfolder/new.xml`
2. Open the directory that you just entered, observe that `new.xml` is at that folder.

### Clear all taska
1. Enter `clear`.
2. All tasks in application will be deleted.

### Exit program
1. Enter `exit`.
2. The program should be exited.
