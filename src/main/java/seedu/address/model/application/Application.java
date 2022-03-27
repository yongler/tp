package seedu.address.model.application;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import seedu.address.model.tag.PriorityTag;
import seedu.address.model.tag.Tag;

/**
 * Represents an Application in InternApply.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Application {

    // Identity fields
    /** Name of the Company */
    private final Name name;
    /** Job Title */
    private final JobTitle jobTitle;
    /** Company Phone Number */
    private final Phone phone;
    /** Company Email */
    private final Email email;

    // Data fields
    /** Company Address */
    private final Address address;
    /** Interview Slot */
    private final InterviewSlot interviewSlot;
    /** Details of application */
    private final Details details;
    /** [W.I.P] Will be repurposed in the future */
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Application(Name name, JobTitle jobTitle, Phone phone, Email email, Address address,
                       InterviewSlot interviewSlot, Details details, Set<Tag> tags) {
        requireAllNonNull(name, phone, email, address, tags);
        this.name = name;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.tags.addAll(tags);
        this.interviewSlot = interviewSlot;
        this.details = details;
    }

    public Name getName() {
        return name;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public InterviewSlot getInterviewSlot() {
        return interviewSlot;
    }

    public Details getDetails() {
        return details;
    }

    public Optional<PriorityTag> getPriorityTag() {
        for (Tag tag: tags) {
            if (tag instanceof PriorityTag) {
                return Optional.of((PriorityTag) tag);
            }
        }
        return Optional.empty();
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both applications have the same name.
     * This defines a weaker notion of equality between two applications.
     */
    public boolean isSameApplication(Application otherApplication) {
        if (otherApplication == this) {
            return true;
        }

        return otherApplication != null
                && otherApplication.getName().equals(getName());
    }

    /**
     * Returns true if the InterviewSlot of this application falls within a week of the local of the local machine else
     * returns false.
     * If the InterviewSlot of this application is not currently set, this will return false.
     */
    public boolean isUpcomingInterview() {
        // Checks if the InterviewSlot of this application is the default InterviewSlot
        if (this.interviewSlot.equals(new InterviewSlot())) {
            return false;
        }

        return this.interviewSlot.isUpcoming();
    }

    /**
     * Returns true if both applications have the same identity and data fields.
     * This defines a stronger notion of equality between two applications.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Application)) {
            return false;
        }

        Application otherApplication = (Application) other;
        return otherApplication.getName().equals(getName())
                && otherApplication.getJobTitle().equals(getJobTitle())
                && otherApplication.getPhone().equals(getPhone())
                && otherApplication.getEmail().equals(getEmail())
                && otherApplication.getAddress().equals(getAddress())
                && otherApplication.getInterviewSlot().equals(getInterviewSlot())
                && otherApplication.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, jobTitle, phone, email, address, tags, interviewSlot, details);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("; Job Title: ")
                .append(getJobTitle())
                .append("; Phone: ")
                .append(getPhone())
                .append("; Email: ")
                .append(getEmail())
                .append("; Address: ")
                .append(getAddress())
                .append("; Interview Slot: ")
                .append(getInterviewSlot())
                .append("; Details: ")
                .append(getDetails());

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        return builder.toString();
    }

}
