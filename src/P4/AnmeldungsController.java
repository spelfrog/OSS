package P4;

import P2.Benutzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AnmeldungsController {
    @FXML private TextField userTextfield;
    @FXML private PasswordField passTextField;
    @FXML private PasswordField passTextField2;

    @FXML public void createAccountAction(ActionEvent actionEvent) {
        if(!passTextField.getText().equals(passTextField2.getText())){
            userTextfield.appendText("Passwort != Wiederholung");
        } else {
            Benutzer benutzer = new Benutzer(userTextfield.getText(), passTextField.getText().toCharArray());
            System.out.println(benutzer);
            Stage stage = (Stage) userTextfield.getScene().getWindow();
            stage.close();
        }
    }

}
