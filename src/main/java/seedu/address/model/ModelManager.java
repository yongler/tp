package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.application.Application;
import seedu.address.model.summarybar.SummaryBox;
import seedu.address.model.summarybar.SummaryList;

/**
 * Represents the in-memory model of InternApply data.
 */
public class ModelManager implements Model {
    private static final Logger logger = LogsCenter.getLogger(ModelManager.class);

    private final InternApplyMemory internApplyMemory;
    private final UserPrefs userPrefs;
    private final FilteredList<Application> filteredApplications;
    private final SummaryList summaryList;
    private final ObservableList<Application> applications;

    /**
     * Initializes a ModelManager with the given internApplyMemory and userPrefs.
     */
    public ModelManager(ReadOnlyInternApplyMemory internApplyMemory, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(internApplyMemory, userPrefs);

        logger.fine("Initializing with intern apply memory: " + internApplyMemory
                + " and user prefs " + userPrefs);

        this.internApplyMemory = new InternApplyMemory(internApplyMemory);
        this.userPrefs = new UserPrefs(userPrefs);
        filteredApplications = new FilteredList<>(this.internApplyMemory.getApplicationList());
        summaryList = new SummaryList(this.internApplyMemory.getSummaryBoxes());
        applications = FXCollections.observableList(this.internApplyMemory.getApplicationList());
    }

    public ModelManager() {
        this(new InternApplyMemory(), new UserPrefs());
    }

    //=========== UserPrefs ==================================================================================

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getInternApplyMemoryFilePath() {
        return userPrefs.getInternApplyMemoryFilePath();
    }

    @Override
    public void setInternApplyMemoryFilePath(Path internApplyMemoryFilePath) {
        requireNonNull(internApplyMemoryFilePath);
        userPrefs.setInternApplyMemoryFilePath(internApplyMemoryFilePath);
    }

    //=========== InternApplyMemory ==========================================================================

    @Override
    public void setInternApplyMemory(ReadOnlyInternApplyMemory internApplyMemory) {
        this.internApplyMemory.resetData(internApplyMemory);
    }

    @Override
    public ReadOnlyInternApplyMemory getInternApplyMemory() {
        return internApplyMemory;
    }

    @Override
    public boolean hasApplication(Application application) {
        requireNonNull(application);
        return internApplyMemory.hasApplication(application);
    }

    @Override
    public void deleteApplication(Application target) {
        internApplyMemory.removeApplication(target);
    }

    @Override
    public void addApplication(Application application) {
        internApplyMemory.addApplication(application);
        updateFilteredApplicationList(PREDICATE_SHOW_ALL_APPLICATIONS);
    }

    @Override
    public void setApplication(Application target, Application editedApplication) {
        requireAllNonNull(target, editedApplication);

        internApplyMemory.setApplication(target, editedApplication);
    }

    //=========== Filtered Application List Accessors ========================================================

    /**
     * Returns an unmodifiable view of the list of {@code Application} backed by the internal list of
     * {@code versionedInternApplyMemory}
     */
    @Override
    public ObservableList<Application> getFilteredApplicationList() {
        return filteredApplications;
    }

    @Override
    public void updateFilteredApplicationList(Predicate<Application> predicate) {
        requireNonNull(predicate);
        filteredApplications.setPredicate(predicate);
    }

    //========== Summary Box List Accessors ===============================================================

    @Override
    public ObservableList<SummaryBox> getSummaryBoxList() {
        return summaryList.getObservableList();
    }

    @Override
    public void updateSummaryBoxList() {
        summaryList.update(getTotalApplications());
    }

    private int getTotalApplications() {
        int count = 0;
        for (Application application : applications) {
            count++;
        }
        return count;
    }


    @Override
    public boolean equals(Object obj) {
        // short circuit if same object
        if (obj == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(obj instanceof ModelManager)) {
            return false;
        }

        // state check
        ModelManager other = (ModelManager) obj;
        return internApplyMemory.equals(other.internApplyMemory)
                && userPrefs.equals(other.userPrefs)
                && filteredApplications.equals(other.filteredApplications);
    }

}
