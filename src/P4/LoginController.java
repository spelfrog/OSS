package P4;

import P2.Benutzer;
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
        }else{
            Benutzer benutzer = new Benutzer(user,pass.toCharArray());
            System.out.println(benutzer);
            Stage stage = (Stage) LogIn.getScene().getWindow();
            stage.close();
        }
    }
}
