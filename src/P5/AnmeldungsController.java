package P5;

import P5.Benutzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class AnmeldungsController {
    @FXML private TextField userTextfield;
    @FXML private PasswordField passTextField;
    @FXML private PasswordField passTextField2;

    private MainApplication mainApplication;

    /**
     * Prüfe ob Passwörter gleich. wenn ja, erstelle einen neuen Benutzer und schließe das Fenster
     */
    @FXML public void createAccountAction(ActionEvent actionEvent) {
        if(!passTextField.getText().equals(passTextField2.getText())){
            userTextfield.setText("Passwort != Wiederholung");
        } else {
            Benutzer benutzer = new Benutzer(userTextfield.getText(), passTextField.getText().toCharArray());
            try {
                mainApplication.neuerBenutzer(benutzer);
            } catch (BenutzerExits benutzerExits) {
                userTextfield.setText("Benutzer existiert bereits");
            }
            System.out.println(benutzer);
        }
    }

    /**
     * Speichert die übergebene Referenz
     */
    public void setMainRef(MainApplication main){
        this.mainApplication = main;
    }
}
