package seedu.address.model.tag;

import org.junit.jupiter.api.Test;

import static seedu.address.testutil.Assert.assertThrows;

class ApplicationStatusTagTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ApplicationStatusTag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new ApplicationStatusTag(invalidTagName));
    }
}