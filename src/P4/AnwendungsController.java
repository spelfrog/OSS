package P4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.Event;
import javafx.stage.Stage;

public class AnwendungsController {
    @FXML
    private Button Abbrechen;

    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        System.out.println("Abbrechen");
        Stage stage = (Stage) Abbrechen.getScene().getWindow();
        stage.close();

    }

}
