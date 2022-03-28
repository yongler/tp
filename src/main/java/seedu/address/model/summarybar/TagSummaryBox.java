package seedu.address.model.summarybar;

import java.util.Objects;
import java.util.Optional;

public class TagSummaryBox extends SummaryBox {
    private int id;
    private int currApplications;

    TagSummaryBox(String name, int currApplications, int totalApplications, int id) {
        super(name, totalApplications);
        this.id = id;
        this.currApplications = currApplications;
    }

    @Override
    public Optional<Integer> getCurrApplications() {
        return Optional.of(currApplications);
    }

    @Override
    public void update(int[] summaryInfo) {
        currApplications = summaryInfo[id];
        super.setTotalApplications(summaryInfo[SummaryList.TOTAL_APPLICATIONS_INDEX]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TagSummaryBox that = (TagSummaryBox) o;
        return id == that.id
                && currApplications == that.currApplications;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, currApplications);
    }
}
