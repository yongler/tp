package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOBTITLE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOBTITLE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.InternApplyMemory;
import seedu.address.model.application.Application;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Application SHOPEE = new ApplicationBuilder().withName("Shopee")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("hr@shopee.com")
            .withPhone("94351253")
            .withTags("friends").withJobTitle("Intern").withInterviewSlot("13-02-2022 16:00").build();
    public static final Application GARENA = new ApplicationBuilder().withName("Garena")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("sea@garena.com").withPhone("98765432")
            .withTags("owesMoney", "friends").withJobTitle("Intern").withInterviewSlot("13-03-2022 16:00").build();
    public static final Application SEAGROUP = new ApplicationBuilder().withName("SEA Group").withPhone("95352563")
            .withEmail("sea@hr.com").withAddress("wall street").build();
    public static final Application SEATALK = new ApplicationBuilder().withName("SEA Talk").withPhone("87652533")
            .withEmail("sea@hr.com").withAddress("10th street").withTags("friends").build();
    public static final Application SEAMONEY = new ApplicationBuilder().withName("SEA Money").withPhone("9482224")
            .withEmail("sea@hr.com").withAddress("michegan ave").build();
    public static final Application SEAFIONA = new ApplicationBuilder().withName("Cloud").withPhone("9482427")
            .withEmail("sea@hr.com").withAddress("little tokyo").build();
    public static final Application SEAMARKETPLACE = new ApplicationBuilder().withName("Marketplace").withPhone("9482442")
            .withEmail("sea@hr.com").withAddress("4th street").build();

    // Manually added
    public static final Application HOON = new ApplicationBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withAddress("little india").build();
    public static final Application IDA = new ApplicationBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withAddress("chicago ave").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Application AMY = new ApplicationBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
            .withTags(VALID_TAG_FRIEND).withJobTitle(VALID_JOBTITLE_AMY).build();
    public static final Application BOB = new ApplicationBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB).withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND)
            .withJobTitle(VALID_JOBTITLE_BOB).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static InternApplyMemory getTypicalAddressBook() {
        InternApplyMemory ab = new InternApplyMemory();
        for (Application application : getTypicalPersons()) {
            ab.addApplication(application);
        }
        return ab;
    }

    public static List<Application> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(SHOPEE, GARENA, SEAGROUP, SEATALK, SEAMONEY, SEAFIONA, SEAMARKETPLACE));
    }
}
