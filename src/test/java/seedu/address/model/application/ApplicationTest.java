package seedu.address.model.application;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.BOB;
import static seedu.address.testutil.TypicalPersons.SHOPEE;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class ApplicationTest {

    @Test
    public void asObservableList_modifyList_throwsUnsupportedOperationException() {
        Application application = new PersonBuilder().build();
        assertThrows(UnsupportedOperationException.class, () -> application.getTags().remove(0));
    }

    @Test
    public void isSamePerson() {
        // same object -> returns true
        assertTrue(SHOPEE.isSameApplication(SHOPEE));

        // null -> returns false
        assertFalse(SHOPEE.isSameApplication(null));

        // same name, all other attributes different -> returns true
        Application editedAlice = new PersonBuilder(SHOPEE).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
                .withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND).build();
        assertTrue(SHOPEE.isSameApplication(editedAlice));

        // different name, all other attributes same -> returns false
        editedAlice = new PersonBuilder(SHOPEE).withName(VALID_NAME_BOB).build();
        assertFalse(SHOPEE.isSameApplication(editedAlice));

        // name differs in case, all other attributes same -> returns false
        Application editedBob = new PersonBuilder(BOB).withName(VALID_NAME_BOB.toLowerCase()).build();
        assertFalse(BOB.isSameApplication(editedBob));

        // name has trailing spaces, all other attributes same -> returns false
        String nameWithTrailingSpaces = VALID_NAME_BOB + " ";
        editedBob = new PersonBuilder(BOB).withName(nameWithTrailingSpaces).build();
        assertFalse(BOB.isSameApplication(editedBob));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Application aliceCopy = new PersonBuilder(SHOPEE).build();
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
        Application editedAlice = new PersonBuilder(SHOPEE).withName(VALID_NAME_BOB).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different phone -> returns false
        editedAlice = new PersonBuilder(SHOPEE).withPhone(VALID_PHONE_BOB).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different email -> returns false
        editedAlice = new PersonBuilder(SHOPEE).withEmail(VALID_EMAIL_BOB).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different address -> returns false
        editedAlice = new PersonBuilder(SHOPEE).withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(SHOPEE.equals(editedAlice));

        // different tags -> returns false
        editedAlice = new PersonBuilder(SHOPEE).withTags(VALID_TAG_HUSBAND).build();
        assertFalse(SHOPEE.equals(editedAlice));
    }
}
