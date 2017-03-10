package seedu.bullletjournal.storage;

import java.io.IOException;
import java.util.Optional;

import seedu.bullletjournal.commons.exceptions.DataConversionException;
import seedu.bullletjournal.model.ReadOnlyTodoList;

/**
 * Represents a storage for {@link seedu.bullletjournal.model.TodoList}.
 */
public interface TodoListStorage {

    /**
     * Returns the file path of the data file.
     */
    String getAddressBookFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyTodoList}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyTodoList> readAddressBook() throws DataConversionException, IOException;

    /**
     * @see #getAddressBookFilePath()
     */
    Optional<ReadOnlyTodoList> readAddressBook(String filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyTodoList} to the storage.
     * @param addressBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveAddressBook(ReadOnlyTodoList addressBook) throws IOException;

    /**
     * @see #saveAddressBook(ReadOnlyTodoList)
     */
    void saveAddressBook(ReadOnlyTodoList addressBook, String filePath) throws IOException;

}