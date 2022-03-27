package seedu.address.model.summarybar;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SummaryList {

    private ObservableList<SummaryBox> summaryList;

    public SummaryList(ArrayList<SummaryBox> summaryBoxes) {
        summaryList = FXCollections.observableArrayList(summaryBoxes);
    }

    public ObservableList<SummaryBox> getObservableList() {
        return summaryList;
    }

    public void update(int totalApplications) {
        // TODO: update all the individual summary boxes by setting their relevant fields

    }

    private void updateTotalApplications(int totalApplications) {

    }
}
