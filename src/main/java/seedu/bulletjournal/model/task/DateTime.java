package seedu.bulletjournal.model.task;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    // TODO Support System format of string
    // e.g. Wed May 02 20:48:32 EEST 2012

    private final String dateTime;

    /**
     * Validates given dateTime.
     *
     * @throws IllegalValueException
     *             if the given tag name string is invalid.
     */
    public DateTime(String dateTime) throws IllegalValueException {
        assert dateTime != null;
        String trimmedDateTime = dateTime.trim();
        if (!isValidDateTime(trimmedDateTime)) {
            throw new IllegalValueException(MESSAGE_DATETIME_CONSTRAINTS);
        }
        this.dateTime = trimmedDateTime;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidDateTime(String test) {
        return !test.matches(DATETIME_INVALID_REGEX) && test.matches(DATETIME_VALID_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DateTime // instanceof handles nulls
                        && this.dateTime.equals(((DateTime) other).dateTime));
        // state check
    }

    public Calendar getDateTime() {
        Calendar date = Calendar.getInstance();

        if (isValidDateTime(dateTime)) {
            Pattern p = Pattern.compile(DATETIME_VALID_REGEX);
            // get a matcher object
            Matcher m = p.matcher(dateTime);
            if (m.group("now") != null) {
            }
            if (m.group("word") != null) {

                switch (m.group("word")) {
                case "yesterday":
                    date.add(Calendar.DATE, -1);
                    break;
                case "today":
                    break;
                case "tomorrow":
                    date.add(Calendar.DATE, 1);
                    break;
                }
            }
            if (m.group("day") != null)
                date.set(Calendar.DAY_OF_MONTH, Integer.parseInt(m.group("day")));
            if (m.group("month") != null)
                date.set(Calendar.MONTH, Integer.parseInt(m.group("month")));
            if (m.group("year") != null)
                date.set(Calendar.YEAR, Integer.parseInt(m.group("year")));
            if (m.group("hour") != null)
                date.set(Calendar.HOUR, Integer.parseInt(m.group("hour")));
            if (m.group("min") != null)
                date.set(Calendar.MINUTE, Integer.parseInt(m.group("min")));
            if (m.group("sec") != null)
                date.set(Calendar.SECOND, Integer.parseInt(m.group("sec")));
            return date;
        }

        return null;

    }

    @Override
    public int hashCode() {
        return dateTime.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        Calendar date = getDateTime();
        return date.toString();
    }

}
