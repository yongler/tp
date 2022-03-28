package seedu.address.model.summarybar;

import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.address.model.application.Application;
import seedu.address.model.tag.Tag;

public class SummaryList {

    private static final int SUMMARY_INFO_SIZE = 6;

    public static final int TOTAL_APPLICATIONS_INDEX = 0;
    public static final int TOTAL_HIGH_PRIORITY_APPLICATIONS_INDEX = 1;
    public static final int TOTAL_MEDIUM_PRIORITY_APPLICATIONS_INDEX = 2;
    public static final int TOTAL_LOW_PRIORITY_APPLICATIONS_INDEX = 3;
    public static final int TOTAL_APPLIED_APPLICATIONS_INDEX = 4;
    public static final int TOTAL_NOT_APPLIED_APPLICATIONS_INDEX = 5;

    private static final String HIGH_PRIORITY_TAG = "HIGH";
    private static final String MEDIUM_PRIORITY_TAG = "MEDIUM";
    private static final String LOW_PRIORITY_TAG = "LOW";
    private static final String APPLIED_STATUS_TAG = "APPLIED";
    private static final String NOT_APPLIED_STATUS_TAG = "NOT_APPLIED";

    private ObservableList<SummaryBox> summaryList;
    private ObservableList<Application> applications;

    public SummaryList(ObservableList<Application> applications) {
        this.applications = applications;
        summaryList = FXCollections.observableArrayList();
        int totalApplications = getTotalApplications();

        summaryList.add(new TotalApplicationsBox("Total", totalApplications));
        summaryList.add(new TagSummaryBox("High Priority", getTotalTagApplications(HIGH_PRIORITY_TAG),
                totalApplications, TOTAL_HIGH_PRIORITY_APPLICATIONS_INDEX));
        summaryList.add(new TagSummaryBox("Medium Priority", getTotalTagApplications(MEDIUM_PRIORITY_TAG),
                totalApplications, TOTAL_MEDIUM_PRIORITY_APPLICATIONS_INDEX));
        summaryList.add(new TagSummaryBox("Low Priority", getTotalTagApplications(LOW_PRIORITY_TAG),
                totalApplications, TOTAL_LOW_PRIORITY_APPLICATIONS_INDEX));
        summaryList.add(new TagSummaryBox("Applied", getTotalTagApplications(APPLIED_STATUS_TAG),
                totalApplications, TOTAL_APPLIED_APPLICATIONS_INDEX));
        summaryList.add(new TagSummaryBox("Not Applied", getTotalTagApplications(NOT_APPLIED_STATUS_TAG),
                totalApplications, TOTAL_NOT_APPLIED_APPLICATIONS_INDEX));
    }

    public ObservableList<SummaryBox> getObservableList() {
        return summaryList;
    }

    public void update(ObservableList<Application> applications) {
        this.applications = applications;
        int[] summaryInfo = new int[SUMMARY_INFO_SIZE];
        summaryInfo[TOTAL_APPLICATIONS_INDEX] = getTotalApplications();
        summaryInfo[TOTAL_HIGH_PRIORITY_APPLICATIONS_INDEX] = getTotalTagApplications(HIGH_PRIORITY_TAG);
        summaryInfo[TOTAL_MEDIUM_PRIORITY_APPLICATIONS_INDEX] = getTotalTagApplications(MEDIUM_PRIORITY_TAG);
        summaryInfo[TOTAL_LOW_PRIORITY_APPLICATIONS_INDEX] = getTotalTagApplications(LOW_PRIORITY_TAG);
        summaryInfo[TOTAL_APPLIED_APPLICATIONS_INDEX] = getTotalTagApplications(APPLIED_STATUS_TAG);
        summaryInfo[TOTAL_NOT_APPLIED_APPLICATIONS_INDEX] = getTotalTagApplications(NOT_APPLIED_STATUS_TAG);
        for (SummaryBox summaryBox : summaryList) {
            summaryBox.update(summaryInfo);
        }
    }

    private int getTotalApplications() {
        return applications.size();
    }

    private int getTotalTagApplications(String tagName) {
        int count = 0;
        Tag toFind = new Tag(tagName);
        for (Application application : applications) {
            if (application.getTags().contains(toFind)) {
                count++;
            }
        }
        return count;
    }
}
