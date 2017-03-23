//@@author A0105748B
package seedu.bulletjournal.model.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DateTimeTest {

    @Test
    public void isValidDateTime() {
        // invalid phone numbers
        assertFalse(DateTime.isValidDateTime("")); // empty string
        assertFalse(DateTime.isValidDateTime(" ")); // spaces only
        assertFalse(DateTime.isValidDateTime(" 3pm")); // starts with spaces
        assertFalse(DateTime.isValidDateTime("last month")); // non-specific time

        assertTrue(DateTime.isValidDateTime("9am")); // not supported yet
        assertTrue(DateTime.isValidDateTime("today")); // short phone numbers
    }
}
