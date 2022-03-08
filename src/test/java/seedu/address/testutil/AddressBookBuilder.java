package seedu.address.testutil;

import seedu.address.model.InternApplyMemory;
import seedu.address.model.application.Application;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withPerson("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private InternApplyMemory addressBook;

    public AddressBookBuilder() {
        addressBook = new InternApplyMemory();
    }

    public AddressBookBuilder(InternApplyMemory addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Person} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withPerson(Application application) {
        addressBook.addPerson(application);
        return this;
    }

    public InternApplyMemory build() {
        return addressBook;
    }
}
