package seedu.address.model.application;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents the job title of an Application in InternApply.
 */
public class JobTitle {

    public final String jobTitle;

    /**
     * Constructs a {@code JobTitle}.
     *
     * @param jobTitle The job title.
     */
    public JobTitle(String jobTitle) {
        requireNonNull(jobTitle);
        this.jobTitle = jobTitle;
    }

    @Override
    public String toString() {
        return jobTitle;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof JobTitle // instanceof handles nulls
                && jobTitle.equals(((JobTitle) other).jobTitle)); // state check
    }

    @Override
    public int hashCode() {
        return jobTitle.hashCode();
    }

}
