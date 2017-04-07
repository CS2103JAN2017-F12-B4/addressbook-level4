# A0146738U-reused
###### \java\seedu\bulletjournal\commons\events\model\FilePathChangedEvent.java
``` java
package seedu.bulletjournal.commons.events.model;

import seedu.bulletjournal.commons.events.BaseEvent;

/** Indicates the file path of the task master should change. */
public class FilePathChangedEvent extends BaseEvent {

    public final String newFilePath;

    public FilePathChangedEvent(String newFilePath) {
        this.newFilePath = newFilePath;
    }

    @Override
    public String toString() {
        return "File path changes to :" + newFilePath;
    }
}
```
###### \java\seedu\bulletjournal\commons\events\ui\FailedCommandAttemptedEvent.java
``` java

/**
 * Indicates an attempt to execute a failed command
 */
public class FailedCommandAttemptedEvent extends BaseEvent {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
```
###### \java\seedu\bulletjournal\commons\events\ui\IncorrectCommandAttemptedEvent.java
``` java

/**
 * Indicates an attempt to execute an incorrect command
 */
public class IncorrectCommandAttemptedEvent extends BaseEvent {

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}
```
###### \java\seedu\bulletjournal\logic\commands\ChangeDirectoryCommand.java
``` java

/**
 * Changes the file path of the file and exports all existing data to the
 * specified file.
 */
public class ChangeDirectoryCommand extends Command {

    public static final String COMMAND_WORD = "change";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Changes the directory for the tasklist."
            + "Parameters: FILE_PATH\n" + "Example: " + COMMAND_WORD + " D:\t.xml";

    public static final String MESSAGE_SUCCESS = "Alert: This operation is irreversible."
            + "\nFile path successfully changed to : %1$s";
    public static final String MESSAGE_IO_ERROR = "Error when saving/reading file...";
    public static final String MESSAGE_CONVENSION_ERROR = "Wrong file type/Invalid file path detected.";

    private final String filePath;

    public ChangeDirectoryCommand(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public CommandResult execute() {
        try {
            if (!filePath.endsWith(".xml")) {
                throw new DataConversionException(null);
            }
            XmlTodoListStorage newFile = new XmlTodoListStorage(filePath);
            newFile.saveTodoList(model.getTodoList(), filePath);
            model.changeDirectory(filePath);
            Config config = ConfigUtil.readConfig(Config.DEFAULT_CONFIG_FILE).get();
            config.setBulletJournalFilePath(filePath);
            ConfigUtil.saveConfig(config, Config.DEFAULT_CONFIG_FILE);
            return new CommandResult(String.format(MESSAGE_SUCCESS, filePath));
        } catch (DataConversionException dce) {
            indicateAttemptToExecuteIncorrectCommand();
            return new CommandResult(MESSAGE_CONVENSION_ERROR);
        } catch (IOException ioe) {
            indicateAttemptToExecuteFailedCommand();
            return new CommandResult(MESSAGE_IO_ERROR);
        }
    }

}
```
###### \java\seedu\bulletjournal\logic\commands\Command.java
``` java
    /**
     * Raises an event to indicate an attempt to execute an incorrect command
     */
    protected void indicateAttemptToExecuteIncorrectCommand() {
        EventsCenter.getInstance().post(new IncorrectCommandAttemptedEvent());
    }

    /**
     * Raises an event to indicate an attempt to execute a failed command
     */
    protected void indicateAttemptToExecuteFailedCommand() {
        EventsCenter.getInstance().post(new FailedCommandAttemptedEvent());
    }
```
###### \java\seedu\bulletjournal\logic\commands\RedoCommand.java
``` java

public class RedoCommand extends Command {
    public static final String COMMAND_WORD = "redo";

    public static final String MESSAGE_SUCCESS = "Redo successful: ";
    public static final String MESSAGE_NO_MORE_REDO = "No more actions available to redo";

    @Override
    public CommandResult execute() throws CommandException {
        HistoryManager historyManager = HistoryManager.getInstance();
        String commandText;
        try {
            commandText = historyManager.redo();
        } catch (Exception e) {
            throw new CommandException(MESSAGE_NO_MORE_REDO);
        }
        return new CommandResult(MESSAGE_SUCCESS + commandText);
    }
}
```
###### \java\seedu\bulletjournal\logic\commands\UndoCommand.java
``` java

public class UndoCommand extends Command {
    public static final String COMMAND_WORD = "undo";

    public static final String MESSAGE_SUCCESS = "Undo successful: ";
    public static final String MESSAGE_NO_MORE_UNDO = "No more actions available to undo";

    @Override
    public CommandResult execute() throws CommandException {
        HistoryManager historyManager = HistoryManager.getInstance();
        String commandText;
        try {
            commandText = historyManager.undo();
        } catch (Exception e) {
            throw new CommandException(MESSAGE_NO_MORE_UNDO);
        }
        return new CommandResult(MESSAGE_SUCCESS + commandText);
    }
}
```
###### \java\seedu\bulletjournal\logic\LogicManager.java
``` java
    @Override
    public String getCommandText() {
        return this.commandText;
    }
}
```
###### \java\seedu\bulletjournal\model\HistoryManager.java
``` java

/**
 * Represents the History of user commands in this session
 */
public class HistoryManager extends ComponentManager {

    private Model model;
    private static HistoryManager instance = null;
    private static final Logger logger = LogsCenter.getLogger(StorageManager.class);
    private ArrayList<ReadOnlyTodoList> historyList;
    private ArrayList<ReadOnlyTodoList> futureList;
    private ArrayList<String> historyCommands;
    private ArrayList<String> futureCommands;

    protected HistoryManager() {
        super();

        historyList = new ArrayList<ReadOnlyTodoList>();
        futureList = new ArrayList<ReadOnlyTodoList>();
        historyCommands = new ArrayList<String>();
        futureCommands = new ArrayList<String>();
    }

    public static HistoryManager getInstance() {
        if (instance == null) {
            instance = new HistoryManager();
        }
        return instance;
    }

    public void init(Model model) {
        this.model = model;
        TodoList taskManager = new TodoList(model.getTodoList());
        historyList.add(taskManager);
    }

    @Subscribe
    public void handleTaskManagerChangedEvent(TodoListChangedEvent event) {
        TodoList taskManager = new TodoList(event.data);
        String commandText = new String(event.commandText);
        historyList.add(taskManager);
        if (!commandText.equals(RedoCommand.COMMAND_WORD) && !commandText.equals(UndoCommand.COMMAND_WORD)) {
            historyCommands.add(commandText);
        }
        if (!(commandText.equals(RedoCommand.COMMAND_WORD) || commandText.equals(UndoCommand.COMMAND_WORD))) {
            futureList.clear();
            futureCommands.clear();
        }
        logger.info(LogsCenter.getEventHandlingLogMessage(event,
                ("Local data changed, updating history manager. Histories = " + historyList.size() + " Futures = "
                        + futureList.size())));
    }

    @Subscribe
    public void handleTaskManagerStorageDirectoryChangedEvent(FilePathChangedEvent event) {
        historyList.clear();
        futureList.clear();
        historyCommands.clear();
        futureCommands.clear();
        logger.info(LogsCenter.getEventHandlingLogMessage(event,
                ("Storage file location changed, resetting history. Histories = " + historyList.size() + " Futures = "
                        + futureList.size())));
    }

    private HistoryItemPair getMostRecentHistory() {
        if (historyList.size() < 2) {
            throw new NullPointerException();
        }
        ReadOnlyTodoList taskManager = historyList.remove(historyList.size() - 1);
        futureList.add(new TodoList(taskManager));
        String commandText = historyCommands.remove(historyCommands.size() - 1);
        futureCommands.add(commandText);
        HistoryItemPair history = new HistoryItemPair(historyList.remove(historyList.size() - 1), commandText);
        return history;
    }

    private HistoryItemPair getMostRecentFuture() {
        if (futureList.size() < 1) {
            throw new NullPointerException();
        }
        String commandText = futureCommands.remove(futureCommands.size() - 1);
        historyCommands.add(commandText);
        HistoryItemPair history = new HistoryItemPair(futureList.remove(futureList.size() - 1), commandText);
        return history;
    }

    public String undo() {
        HistoryItemPair t = getMostRecentHistory();
        model.resetData(t.getTodoList());
        return t.getCommandText();
    }

    public String redo() {
        HistoryItemPair t = getMostRecentFuture();
        model.resetData(t.getTodoList());
        return t.getCommandText();
    }
}

class HistoryItemPair {
    private ReadOnlyTodoList taskManager;
    private String commandText;

    public HistoryItemPair(ReadOnlyTodoList tm, String text) {
        taskManager = tm;
        commandText = text;
    }

    public ReadOnlyTodoList getTodoList() {
        return taskManager;
    }

    public String getCommandText() {
        return commandText;
    }
}
```
###### \java\seedu\bulletjournal\ui\StatusBarFooter.java
``` java
    @Subscribe
    public void handleFilePathChangeEvent(FilePathChangedEvent fpce) {
        setSaveLocation(fpce.newFilePath);
    }
```
