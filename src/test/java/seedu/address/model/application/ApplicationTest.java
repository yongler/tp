package seedu.address.model.application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_LOCAL;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalApplications.BOB;
import static seedu.address.testutil.TypicalApplications.SHOPEE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.ApplicationBuilder;

public class ApplicationTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Application application = new ApplicationBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> application.getTags().remove(0));
    }

    @Test
    public void isSamePerson() {
        // same object -> returns true
        assertTrue(SHOPEE.isSameApplication(SHOPEE));

        // null -> returns false
        assertFalse(SHOPEE.isSameApplication(null));

        // same name, all other attributes different -> returns true
        Application editedAlice = new ApplicationBuilder(SHOPEE).withPhone(VALID_PHONE_GARENA).withEmail(VALID_EMAIL_GARENA)
                .withAddress(VALID_ADDRESS_GARENA).withTags(VALID_TAG_LOCAL).build();
        assertTrue(SHOPEE.isSameApplication(editedAlice));

        // different name, all other attributes same -> returns false
        editedAlice = new ApplicationBuilder(SHOPEE).withName(VALID_NAME_GARENA).build();
        assertFalse(SHOPEE.isSameApplication(editedAlice));

        // name differs in case, all other attributes same -> returns false
        Application editedBob = new ApplicationBuilder(BOB).withName(VALID_NAME_GARENA.toLowerCase()).build();
        assertFalse(BOB.isSameApplication(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_GARENA + " ";
        editedBob = new ApplicationBuilder(BOB).withName(nameWithTrailingSpaces).build();
        assertFalse(BOB.isSameApplication(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Application aliceCopy = new ApplicationBuilder(SHOPEE).build();
        assertTrue(SHOPEE.equals(aliceCopy));

        // same object -> returns true
        assertTrue(SHOPEE.equals(SHOPEE));

        // null -> returns false
        assertFalse(SHOPEE.equals(null));

        // different type -> returns false
        assertFalse(SHOPEE.equals(5));

        // different person -> returns false
        assertFalse(SHOPEE.equals(BOB));

        // different name -> returns false
        Application editedAlice = new ApplicationBuilder(SHOPEE).withName(VALID_NAME_GARENA).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new ApplicationBuilder(SHOPEE).withPhone(VALID_PHONE_GARENA).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new ApplicationBuilder(SHOPEE).withEmail(VALID_EMAIL_GARENA).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new ApplicationBuilder(SHOPEE).withAddress(VALID_ADDRESS_GARENA).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new ApplicationBuilder(SHOPEE).withTags(VALID_TAG_LOCAL).build();
        assertFalse(SHOPEE.equals(editedAlice));
    }
}
