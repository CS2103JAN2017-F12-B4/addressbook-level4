package seedu.bulletjournal.model.task;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TaskNameTest {

    @Test
    public void isValidName() {
        // invalid name
        assertFalse(TaskName.isValidName("")); // empty string
        assertFalse(TaskName.isValidName(" ")); // spaces only
        assertFalse(TaskName.isValidName("^")); // only non-alphanumeric characters
        assertFalse(TaskName.isValidName("homework*")); // contains non-alphanumeric characters

        // valid name
        assertTrue(TaskName.isValidName("kill jack")); // alphabets only
        assertTrue(TaskName.isValidName("12345")); // numbers only
        assertTrue(TaskName.isValidName("get 2nd honor")); // alphanumeric characters
        assertTrue(TaskName.isValidName("call Capital Tan")); // with capital letters
        assertTrue(TaskName.isValidName("meet David Roger Jackson Ray Jr 2nd")); // long names
    }
}
