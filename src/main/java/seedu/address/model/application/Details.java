package seedu.address.model.application;

import static java.util.Objects.requireNonNull;

public class Details {

    //TODO finalize the default detail format
    private static final String DEFAULT_DETAIL = "To add details, use the edit command";

    private final String detail;

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
}
