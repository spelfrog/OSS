package P5;

import P5.Benutzer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 */
public class LoginController {
    @FXML private PasswordField passwordTextField;
    @FXML private Button LogIn;
    @FXML private TextField userID;
    @FXML private CheckBox neuAnmeldungCheck;

    private MainApplication mainApplication;
    private boolean neuAnmeldung = false;

    /**
     * veränderts var neuAnmeldung abhängig von checkbox
     */
    @FXML public void neuAnmeldungAction(ActionEvent actionEvent){
        neuAnmeldung = neuAnmeldungCheck.isSelected();
        System.out.println("Neu- Anmeldung: "+neuAnmeldung);
    }

    /**
     * legt neuen Benutzer an, wenn felder user und passwort nicht leer sind
     */
    public void LogInAction(ActionEvent actionEvent) {
        String user = userID.getText();
        String pass = passwordTextField.getText();
        if(user.isEmpty() || pass.isEmpty()){
            System.err.println("Benutzername oder Passwort nicht eingetragen");
        } else {
            if(neuAnmeldung) {
                mainApplication.neuAnmeldung();
            } else {
                Benutzer benutzer = new Benutzer(user,pass.toCharArray());
                try {
                    System.out.println(mainApplication);
                    mainApplication.benutzerLogin(benutzer);
                } catch (BenutzerNotInList benutzerNotInList) {
                    userID.setText("Benutzer existiert nicht");
                }
            }
        }
    }

    /**
     * Speichert die übergebene Referenz
     */
    public void setMainRef(MainApplication main){
        this.mainApplication = main;
    }

}
