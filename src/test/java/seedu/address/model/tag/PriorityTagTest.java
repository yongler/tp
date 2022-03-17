package seedu.address.model.tag;

import org.junit.jupiter.api.Test;

import static seedu.address.testutil.Assert.assertThrows;

class PriorityTagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new PriorityTag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new PriorityTag(invalidTagName));
    }
}