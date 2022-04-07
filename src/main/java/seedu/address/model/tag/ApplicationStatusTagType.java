package seedu.address.model.tag;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A public enumeration class for application status tags.
 */
public enum ApplicationStatusTagType {
    NOT_APPLIED(0), APPLIED(1), INTERVIEWED(2),
    REJECTED(3), ACCEPTED(4);

    private final int statusRanking;

    ApplicationStatusTagType(int statusRanking) {
        this.statusRanking = statusRanking;
    }

    /**
     * Gets all enum values as strings.
     * @return All enum values as a concatenated string.
     */
    public static String getAllTypesInString() {
        return Stream.of(ApplicationStatusTagType.values())
                .map((tag) -> tag.name())
                .collect(Collectors.joining(", "));
    }

    /**
     * Checks whether the given string is within the enum values.
     * @param test String to test.
     * @return True if the string is same as one of the enum values.
     */
    public static boolean contains(String test) {
        for (ApplicationStatusTagType ast : ApplicationStatusTagType.values()) {
            if (ast.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    public int getStatusRanking() {
        return this.statusRanking;
    }
}
