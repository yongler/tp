package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataConversionException;
import seedu.address.model.InternApplyMemory;
import seedu.address.model.ReadOnlyInternApplyMemory;

/**
 * Represents a storage for {@link InternApplyMemory}.
 */
public interface AddressBookStorage {

    /**
     * Returns the file path of the data file.
     */
    Path getAddressBookFilePath();

    /**
     * Returns AddressBook data as a {@link ReadOnlyInternApplyMemory}.
     *   Returns {@code Optional.empty()} if storage file is not found.
     * @throws DataConversionException if the data in storage is not in the expected format.
     * @throws IOException if there was any problem when reading from the storage.
     */
    Optional<ReadOnlyInternApplyMemory> readAddressBook() throws DataConversionException, IOException;

    /**
     * @see #getAddressBookFilePath()
     */
    Optional<ReadOnlyInternApplyMemory> readAddressBook(Path filePath) throws DataConversionException, IOException;

    /**
     * Saves the given {@link ReadOnlyInternApplyMemory} to the storage.
     * @param addressBook cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveAddressBook(ReadOnlyInternApplyMemory addressBook) throws IOException;

    /**
     * @see #saveAddressBook(ReadOnlyInternApplyMemory)
     */
    void saveAddressBook(ReadOnlyInternApplyMemory addressBook, Path filePath) throws IOException;

}
