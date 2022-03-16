package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.InternApplyMemory;
import seedu.address.model.ReadOnlyInternApplyMemory;
import seedu.address.model.application.Address;
import seedu.address.model.application.Application;
import seedu.address.model.application.Email;
import seedu.address.model.application.InterviewSlot;
import seedu.address.model.application.JobTitle;
import seedu.address.model.application.Name;
import seedu.address.model.application.Phone;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code InternApplyMemory} with sample data.
 */
public class SampleDataUtil {
    public static Application[] getSampleApplications() {
        return new Application[] {

            new Application(new Name("Shopee"), new JobTitle("Software Engineer Intern"), new Phone("87438807"),
                    new Email("hr@shopee.sg"), new Address("5 Science Park Dr, #06-40"), new InterviewSlot(),
                    getTagSet("friends", "HIGH")),
            new Application(new Name("Grab Holdings Singapore"), new JobTitle("AI Engineer"), new Phone("99272758"),
                    new Email("hr@grab.sg"), new Address("3 Media Cl, #07-18"), new InterviewSlot(),
                    getTagSet("colleagues", "friends")),
            new Application(new Name("Microsoft"), new JobTitle("Software Engineer Intern"), new Phone("93210283"),
                    new Email("hr@microsoft.com"), new Address("182 Cecil St, #13-01"), new InterviewSlot(),
                getTagSet("neighbours")),
            new Application(new Name("Google Asia Pacific"), new JobTitle("ML Engineer"), new Phone("91031282"),
                    new Email("hr@google.com"), new Address("70 Pasir Panjang Rd, #16-43"),
                    new InterviewSlot("28-03-2022 13:00"), getTagSet("family")),

        };
    }

    public static ReadOnlyInternApplyMemory getSampleInternApplyMemory() {
        InternApplyMemory sampleIam = new InternApplyMemory();
        for (Application sampleApplication : getSampleApplications()) {
            sampleIam.addApplication(sampleApplication);
        }
        return sampleIam;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }
}
