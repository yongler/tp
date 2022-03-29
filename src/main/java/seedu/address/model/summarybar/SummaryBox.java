package seedu.address.model.summarybar;

import java.util.Objects;
import java.util.Optional;

public abstract class SummaryBox {

    private String name;
    private int totalApplications;


    public SummaryBox(String name, int totalApplications) {
        this.name = name;
        this.totalApplications = totalApplications;
    }

    public String getName() {
        return name;
    }

    public int getTotalApplications() {
        return totalApplications;
    }

    public void setTotalApplications(int totalApplications) {
        this.totalApplications = totalApplications;
    }

    public abstract Optional<Integer> getCurrApplications();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SummaryBox that = (SummaryBox) o;
        return totalApplications == that.totalApplications
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, totalApplications);
    }
}
