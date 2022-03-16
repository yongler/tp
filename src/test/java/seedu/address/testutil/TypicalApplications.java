package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOBTITLE_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_JOBTITLE_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_SHOPEE;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_GARENA;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_LOCAL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.InternApplyMemory;
import seedu.address.model.application.Application;

/**
 * A utility class containing a list of {@code Application} objects to be used in tests.
 */
public class TypicalApplications {

    public static final Application GRAB = new ApplicationBuilder().withName("Grab")
            .withAddress("123, Jurong West Ave 6, #08-111").withEmail("hr@grab.com")
            .withPhone("94351253")
            .withTags("friends").withJobTitle("Intern").withInterviewSlot("13-02-2022 16:00").build();
    public static final Application LAZADA = new ApplicationBuilder().withName("Lazada")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("lazada@sg.com").withPhone("98765432")
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

    // Manually added - Application's details found in {@code CommandTestUtil}
    public static final Application SHOPEE = new ApplicationBuilder().withName(VALID_NAME_SHOPEE).withPhone(VALID_PHONE_SHOPEE)
            .withEmail(VALID_EMAIL_SHOPEE).withAddress(VALID_ADDRESS_SHOPEE)
            .withTags(VALID_TAG_FRIEND).withJobTitle(VALID_JOBTITLE_SHOPEE).build();
    public static final Application GARENA = new ApplicationBuilder().withName(VALID_NAME_GARENA).withPhone(VALID_PHONE_GARENA)
            .withEmail(VALID_EMAIL_GARENA).withAddress(VALID_ADDRESS_GARENA).withTags(VALID_TAG_LOCAL, VALID_TAG_FRIEND)
            .withJobTitle(VALID_JOBTITLE_GARENA).build();

    public static final String KEYWORD_MATCHING_MEIER = "Meier"; // A keyword that matches MEIER

    private TypicalApplications() {} // prevents instantiation

    /**
     * Returns an {@code InternApplyMemory} with all the typical applications.
     */
    public static InternApplyMemory getTypicalInternApplyMemory() {
        InternApplyMemory iam = new InternApplyMemory();
        for (Application application : getTypicalApplications()) {
            iam.addApplication(application);
        }
        return iam;
    }

    public static List<Application> getTypicalApplications() {
        return new ArrayList<>(Arrays.asList(GRAB, LAZADA, SEAGROUP, SEATALK, SEAMONEY, SEAFIONA, SEAMARKETPLACE));
    }
}
