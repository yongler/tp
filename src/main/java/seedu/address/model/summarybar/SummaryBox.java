package seedu.address.model.summarybar;

import java.util.Objects;

public class SummaryBox {

    private String name;
    private int currApplications;
    private int totalApplications;


    public SummaryBox(String name, int numApplications, int totalApplications) {
        this.name = name;
        this.currApplications =  numApplications;
        this.totalApplications = totalApplications;
    }

    public String getName() {
        return name;
    }

    public int getCurrApplications() {
        return currApplications;
    }

    public int getTotalApplications() {
        return totalApplications;
    }

    public void setCurrApplications(int currApplications) {
        this.currApplications = currApplications;
    }

    public void setTotalApplications(int totalApplications) {
        this.totalApplications = totalApplications;
    }

    public void update(int currApplications, int totalApplications) {
        this.currApplications = currApplications;
        this.totalApplications = totalApplications;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SummaryBox that = (SummaryBox) o;
        return currApplications == that.currApplications
                && totalApplications == that.totalApplications
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, currApplications, totalApplications);
    }
}
