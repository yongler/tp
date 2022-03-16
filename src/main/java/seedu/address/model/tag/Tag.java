package seedu.address.model.tag;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Tag in InternApply.
 * Guarantees: immutable; name is valid as declared in {@link #isValidTagName(String)}
 */
public class Tag {
    public static final String MESSAGE_CONSTRAINTS = "Tags names should be alphanumeric";
    public static final String VALIDATION_REGEX = "\\p{Alnum}+";

    public final String tagName;
    public final TagType tagType;

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     */
    public Tag(String tagName) {
        requireNonNull(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        switch(tagName.toUpperCase()) {
        case "HIGH":
                //Fallthrough
        case "MEDIUM":
                //Fallthrough
        case "LOW":
            this.tagName = tagName;
            this.tagType = TagType.PRIORITY;
            break;
        case "NOTAPPLIED":
                //Fallthrough
        case "APPLIED":
                //Fallthrough
        case "INTERVIEWED":
                //Fallthrough
        case "REJECTED":
                //Fallthrough
        case "ACCEPTED":
            this.tagName = tagName;
            this.tagType = TagType.APPLICATION_STATUS;
            break;
        default:
            this.tagName = tagName;
            this.tagType = TagType.JOB_SCOPE;
            break;
        }
    }

    /**
     * Constructs a {@code Tag}.
     *
     * @param tagName A valid tag name.
     * @param tagType A valid tag type.
     */
    public Tag(String tagName, TagType tagType) {
        requireNonNull(tagName);
        checkArgument(isValidTagName(tagName), MESSAGE_CONSTRAINTS);
        this.tagName = tagName;
        this.tagType = tagType;
    }

    /**
     * Returns true if a given string is a valid tag name.
     */
    public static boolean isValidTagName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Tag // instanceof handles nulls
                && tagName.equals(((Tag) other).tagName)
                && tagType.equals(((Tag) other).tagType)
                ); // state check
    }

    @Override
    public int hashCode() {
        return tagName.hashCode();
    }

    /**
     * Format state as text for viewing.
     */
    public String toString() {
        return '[' + tagName + ']';
    }

}
