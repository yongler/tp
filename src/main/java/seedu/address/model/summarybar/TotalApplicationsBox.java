package seedu.address.model.summarybar;

import java.util.Optional;

public class TotalApplicationsBox extends SummaryBox {

    public TotalApplicationsBox(String name, int totalApplications) {
        super(name, totalApplications);
    }

    @Override
    public Optional<Integer> getCurrApplications() {
        return Optional.empty();
    }

    @Override
    public void update(int[] summaryInfo) {
        int totalApplications = summaryInfo[SummaryList.TOTAL_APPLICATIONS_INDEX];
        super.setTotalApplications(totalApplications);
    }
}
