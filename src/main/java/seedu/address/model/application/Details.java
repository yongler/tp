package seedu.address.model.application;

import static java.util.Objects.requireNonNull;

public class Details {

    //TODO finalize the default detail format
    public static final String DEFAULT_DETAIL = "To add details, use the edit command";

    public final String detail;

    /**
     * Constructs a {@code Details}.
     */
    public Details() {
        detail = DEFAULT_DETAIL;
    }

    /**
     * Constructs a {@code Details}.
     *
     * @param detailInput A non-empty string of detail.
     */
    public Details(String detailInput) {
        requireNonNull(detailInput);
        detail = detailInput;
    }

    /**
     * Returns true if a given string is a placeholder for an empty detail.
     */
    public static boolean isNotSet(String test) {
        return test.equals(DEFAULT_DETAIL);
    }
}
