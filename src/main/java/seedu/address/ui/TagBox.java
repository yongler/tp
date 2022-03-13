package seedu.address.ui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import seedu.address.commons.util.Colors;
import seedu.address.model.tag.Tag;

import java.util.Comparator;
import java.util.Locale;
import java.util.Set;

public class TagBox extends HBox {
    private static final String FXML = "/view/TagBox.fxml";

    @FXML
    private FlowPane tags;

    public TagBox(Set<Tag> tagSet){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource(FXML));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tagSet.stream()
            .sorted(Comparator.comparing(tag -> tag.tagName)).sorted(Comparator.comparing(tag -> tag.tagType))
            .forEach(tag -> tags.getChildren().add(chooseColor(tag)));
    }

    public Label chooseColor(Tag tag){
        Label returnTag = new Label(tag.tagName);
        switch (tag.tagType){
        case PRIORITY:
            switch (tag.tagName.toUpperCase()){
            case "HIGH":
                returnTag.setStyle(Colors.RED);
                break;
            case "MEDIUM":
                returnTag.setStyle(Colors.ORANGE);
                break;
            case "LOW":
                returnTag.setStyle(Colors.GREEN);
                break;
            }
            break;
        case APPLICATION_STATUS:
            switch (tag.tagName.toUpperCase()) {
            case "NOT_APPLIED":
                returnTag.setStyle(Colors.BLUE);
                break;
            case "APPLIED":
                returnTag.setStyle(Colors.TEAL);
                break;
            case "INTERVIEWED":
                returnTag.setStyle(Colors.YELLOW);
                break;
            case "REJECTED":
                returnTag.setStyle(Colors.RED);
                break;
            case "ACCEPTED":
                returnTag.setStyle(Colors.GREEN);
                break;
            }
            break;
        default:
            returnTag.setStyle(Colors.GREY);
        }
        return returnTag;
    }
}
