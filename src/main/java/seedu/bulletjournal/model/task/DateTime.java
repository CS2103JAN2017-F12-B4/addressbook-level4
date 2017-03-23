package seedu.bulletjournal.model.task;

import seedu.bulletjournal.commons.exceptions.IllegalValueException;

/**
 * Represents the date & time of tasks or events in the todolist
 *
 * @author A0127826Y
 *
 */
public class DateTime {
    public static final String MESSAGE_DATETIME_CONSTRAINTS = "Date & time should be alphanumeric";
    public static final String DATETIME_INVALID_REGEX = "[^\\s].*";
    public static final String DATETIME_VALID_REGEX = "(((?iu)now)|"
            // Matches all cases of now or
            + "((?iu)(today|tomorrow|yesterday))|"
            // Matches all cases of today, tomorrow, yesterday or
            + "(?<day>[0-9]{2})(/|-?)(?<month>[0-9]{2})(/|-?)(?<year>((19|20)?[0-9]{2})?)|"
            // Matches DDMMYY(YY), DD-MM-YY(YY), DD/MM/YY(YY) numeric & mixed or
            // separators
            + "(<month>(/|-?)<day>(/|-?)<year>?)|"
            // Matches MMDDYY(YY), MM-DD-YY(YY), MM/DD/YY(YY) or
            + "(<year>(/|-?)<month>(/|-?)<day>?))?"
            // Matches (YY)YYMMDD, (YY)YY-MM-DD, (YY)YY/MM/DD numeric & mixed
            // separators
            // All of the above are optional
            + "\\s*((?<hour>2[0-3]|[01][0-9]):(?<minute>[0-5][0-9]):?(?<second>[0-5][0-9])?)?";
    // Matches hh:mm:ss, hh:mm with a space in front

    public final String dateTime;

    /**
     * Validates given dateTime.
     *
     * @throws IllegalValueException
     *             if the given tag name string is invalid.
     */
    public DateTime(String dateTime) throws IllegalValueException {
        assert dateTime != null;
        String trimmedDateTime = dateTime.trim();
        if (!isValidTagName(trimmedDateTime)) {
            throw new IllegalValueException(MESSAGE_DATETIME_CONSTRAINTS);
        }
        this.dateTime = trimmedDateTime;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(DATETIME_VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateTime // instanceof handles nulls
                        && this.dateTime.equals(((DateTime) other).dateTime)); // state
        // check
    }

    @Override
    public int hashCode() {
        return dateTime.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + dateTime + ']';
    }

}
