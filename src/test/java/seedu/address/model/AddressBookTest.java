package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_LOCAL;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalApplications.GRAB;
import static seedu.address.testutil.TypicalApplications.getTypicalInternApplyMemory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.application.Application;
import seedu.address.model.application.exceptions.DuplicateApplicationException;
import seedu.address.testutil.ApplicationBuilder;

public class AddressBookTest {

    private final InternApplyMemory addressBook = new InternApplyMemory();

    @Test
    public void constructor() {
        assertEquals(Collections.emptyList(), addressBook.getApplicationList());
    }

    @Test
    public void resetData_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.resetData(null));
    }

    @Test
    public void resetData_withValidReadOnlyAddressBook_replacesData() {
        InternApplyMemory newData = getTypicalInternApplyMemory();
        addressBook.resetData(newData);
        assertEquals(newData, addressBook);
    }

    @Test
    public void resetData_withDuplicatePersons_throwsDuplicatePersonException() {
        // Two persons with the same identity fields
        Application editedAlice = new ApplicationBuilder(GRAB).withAddress(VALID_ADDRESS_GARENA).withTags(VALID_TAG_LOCAL)
                .build();
        List<Application> newApplications = Arrays.asList(GRAB, editedAlice);
        InternApplyMemoryStub newData = new InternApplyMemoryStub(newApplications);

        assertThrows(DuplicateApplicationException.class, () -> addressBook.resetData(newData));
    }

    @Test
    public void hasPerson_nullPerson_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> addressBook.hasApplication(null));
    }

    @Test
    public void hasPerson_personNotInAddressBook_returnsFalse() {
        assertFalse(addressBook.hasApplication(GRAB));
    }

    @Test
    public void hasPerson_personInAddressBook_returnsTrue() {
        addressBook.addApplication(GRAB);
        assertTrue(addressBook.hasApplication(GRAB));
    }

    @Test
    public void hasPerson_personWithSameIdentityFieldsInAddressBook_returnsTrue() {
        addressBook.addApplication(GRAB);
        Application editedAlice = new ApplicationBuilder(GRAB).withAddress(VALID_ADDRESS_GARENA).withTags(VALID_TAG_LOCAL)
                .build();
        assertTrue(addressBook.hasApplication(editedAlice));
    }

    @Test
    public void getPersonList_modifyList_throwsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> addressBook.getApplicationList().remove(0));
    }

    /**
     * A stub ReadOnlyAddressBook whose persons list can violate interface constraints.
     */
    private static class InternApplyMemoryStub implements ReadOnlyInternApplyMemory {
        private final ObservableList<Application> applications = FXCollections.observableArrayList();

        InternApplyMemoryStub(Collection<Application> applications) {
            this.applications.setAll(applications);
        }

        @Override
        public ObservableList<Application> getApplicationList() {
            return applications;
        }
    }

}
