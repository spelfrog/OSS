package P4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.Event;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class AnwendungsController {
    @FXML
    private Button Abbrechen;

    /**
     * Schließt die Anwendung
     */
    @FXML
    public void closeApplication(ActionEvent actionEvent) {
        System.out.println("Abbrechen");
        Stage stage = (Stage) Abbrechen.getScene().getWindow();
        stage.close();

    }

}
