# Bullet Journal - User Guide

By : `Team F12-B4`  &nbsp;&nbsp;&nbsp;&nbsp; Since: `Feb 2017`  &nbsp;&nbsp;&nbsp;&nbsp; Licence: `MIT`

---

1. [Quick Start](#1-quick-start)
2. [Features](#2-features)
3. [FAQ](#3-faq)
4. [Command Summary](#4-command-summary)

## 1. Quick Start

0. Ensure you have Java version `1.8.0_60` or later installed in your Computer.<br>

   > Having any Java 8 version is not enough. <br>
   > This app will not work with earlier versions of Java 8.

1. Download the latest `bulletjournal.jar` from the [releases](https://github.com/CS2103JAN2017-F12-B4/main/releases) tab.
2. Copy the file to the folder you want to use as the home folder for your BulletJournal.
3. Double-click the file to start the app. The GUI should appear in a few seconds.
   > <img src="images/Ui.png" width="600">

4. Type the command in the command box and press <kbd>Enter</kbd> to execute it. <br>
   e.g. typing **`help`** and pressing <kbd>Enter</kbd> will open the help window.
5. Some example commands you can try:
   * **`list`** : lists all tasks
   * **`add`**` Pick up laundry` :
     adds a task named `Pick up laundry` to the Task List.
   * **`delete`**` 3` : deletes the 3rd task shown in the current list
   * **`exit`** : exits the app
6. Refer to the [Features](#features) section below for details of each command.<br>


## 2. Features

> **Command Format**
>
> * Words in `UPPER_CASE` are the parameters.
> * Items in `SQUARE_BRACKETS` are optional.
> * Items with `...` after them can have multiple instances.
> * Parameters can be in any order.

### 2.1. Viewing help : `help`

Format: `help`

> Help is also shown if you enter an incorrect command e.g. `abcd`

### 2.2. Adding a task: `add`

Adds a task to the todolist of BulletJournal<br>
Format: `add TASK...`

Alternative commands: "a", "create", "new"

> Tasks can have any number of tags (including 0)

Examples:

* `add Pick up laundry`
* `add Do CS2103 V0.0 t/urgent`

### 2.3. Listing undone tasks : `list`

Shows a list of all undone tasks in the Task List.<br>
Format: `list`

Alternative commands: "ls", "display"

### 2.4. Editing a task : `edit`

Edits an existing task in the todo list.<br>
Format: `edit INDEX [TASK] [t/TAG]...`

Alternative commands: "e", "change"

> * Edits the task at the specified `INDEX`.
    The index refers to the index number shown in the last task listing.<br>
    The index **must be a positive integer** 1, 2, 3, ...
> * At least one of the optional fields must be provided.
> * Existing values will be updated to the input values.
> * When editing tags, the existing tags of the task will be removed i.e adding of tags is not cumulative.
> * You can remove all the task's tags by typing `t/` without specifying any tags after it.

Examples:

* `edit 1 Pick up laundry`<br>
  Edits the name of the 1st task to be `Pick up laundry`.

* `edit 2 Do CS2103 V0.0 t/`<br>
  Edits the name of the 2nd task to be `Do CS2103 V0.0` and clears all existing tags.

### 2.5. Finding all tasks containing any keyword in their name: `find`

Finds tasks whose names contain any of the given keywords.<br>
Format: `find KEYWORD [MORE_KEYWORDS]`

Alternative commands: "f", "search", "lookup"

> * The search is case sensitive. e.g `pick` will not match `Pick`
> * The order of the keywords does not matter. e.g. `Pick Up` will match `Up Pick`
> * Only the name is searched.
> * Only full words will be matched e.g. `Pic` will not match `Pick`
> * Tasks matching at least one keyword will be returned (i.e. `OR` search).
    e.g. `Pick` will match `Pick Up`

Examples:

* `find Pick`<br>
  Returns `Pick Up` but not `pick up`
* `find Pick Do`<br>
  Returns Any tasks having names `Pick`, or `Do`

<!-- @@author A0105748B -->
### 2.6. Showing done tasks: `show`

Shows tasks that are done or undone.<br>
Format: `show done/undone`

> * This command is case insensitive. e.g `DONE` works the same as `done`
> * Only the status is searched.
> * Only full words will be matched e.g `do` will not match `done`

Examples:

* `show done`<br>
  Returns tasks that are done
* `show undone`<br>
  Returns tasks that are undone
<!-- @@author -->

### 2.7. Deleting a task : `delete`

Deletes the specified task from the todo list. Irreversible.<br>
Format: `delete INDEX`

Alternative commands: "del", "d", "remove", "rm"

> Deletes the task at the specified `INDEX`. <br>
> The index refers to the index number shown in the most recent listing.<br>
> The index **must be a positive integer** 1, 2, 3, ...

Examples:

* `list`<br>
  `delete 2`<br>
  Deletes the 2nd task in the todo list.
* `find Pick`<br>
  `delete 1`<br>
  Deletes the 1st task in the results of the `find` command.

### 2.8. Select a task : `select`

Selects the task identified by the index number used in the last task listing.<br>
Format: `select INDEX`

Alternative commands: "choose"

> Selects the task and loads the Google search page the task at the specified `INDEX`.<br>
> The index refers to the index number shown in the most recent listing.<br>
> The index **must be a positive integer** 1, 2, 3, ...

Examples:

* `list`<br>
  `select 2`<br>
  Selects the 2nd task in the address book.
* `find Pick up` <br>
  `select 1`<br>
  Selects the 1st task in the results of the `find` command.

### 2.9. Clearing all entries : `clear`

Clears all entries from the Task List.<br>
Format: `clear`

Alternative commands: "clr", "empty"

### 2.10. Exiting the program : `exit`

Exits the program.<br>
Format: `exit`

Alternative commands: "logout"

### 2.11. Saving the data

Task List data are saved in the hard disk automatically after any command that changes the data.<br>
There is no need to save manually.

### 2.12. Changing the filepath : `change`

Changes the filepath for where the data is stored. <br>
Format: `change`

Alternative commands: "cd"

<!-- @@author A0105748B -->
### 2.13. Finish a task : `finish`

Mark an existing task as "done" in the todo list.<br>
Format: `finish INDEX`

Alternative commands: "done", "complete"

> Marks the task as "done" at the specified `INDEX`. <br>
> The index refers to the index number shown in the most recent listing.<br>
> The index **must be a positive integer** 1, 2, 3, ...

Examples:

* `list`<br>
  `finish 2`<br>
  Marks the 2nd task as "done" in the todo list.
* `find do`<br>
  `done 1`<br>
  Marks the 1st task as "done" in the results of the `find` command.
<!-- @@author -->

<!-- @@author A0146738U -->
### 2.14. Undo a task : `undo`

Undo a task in the todo list.<br>
Format: `undo`

### 2.15. Redo a task : `redo`

Redo an undone task in the todo list.<br>
Format: `redo`

<!-- @@author -->

## 3. FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with
       the file that contains the data of your previous Task List folder.

## 4. Command Summary

* **Add**  `add TASK [t/TAG]...` <br>
  e.g. `add Pick up laundry t/chores`

* **Clear** : `clear`
  e.g. 'clear'

* **Change** : `change FILEPATH` <br>
  e.g. 'change data/filepath.xml'

* **Delete** : `delete INDEX` <br>
  e.g. `delete 3`

* **Find** : `find KEYWORD [MORE_KEYWORDS]` <br>
  e.g. `find Pick Do`

* **List** : `list` <br>
  e.g. `list`

* **Show** : `show done/undone` <br>
  e.g. `show done`

* **Help** : `help` <br>
  e.g. 'help'

* **Select** : `select INDEX` <br>
  e.g.`select 2`
  
* **Undo** : `undo` <br>
  e.g.`undo`
  
* **Redo** : `redo` <br>
  e.g.`redo`




