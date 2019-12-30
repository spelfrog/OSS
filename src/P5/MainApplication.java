package P5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApplication extends Application {
    private Stage primaryStage;
    private BenutzerVerwaltungAdmin admin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;
        this.admin = new BenutzerVerwaltungAdmin();

        System.out.println("Wollen Sie die Datenhaltung initialisieren? nein: 0, rest ja");

        int eingabe = 1;
/*
        try {
            eingabe = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        if (eingabe == 0) {
            System.out.println("Datenhaltung wird nicht initialisiert.");
        } else {
            admin.dbInitialisieren();
            System.out.println("Datenhaltung wurde initialisiert.");
        }

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LoginController loginController = loader.getController();
        loginController.setMainRef(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Die Scene wird durch eine AnmeldungsScene ersetzt und deren
     * Controller wird die eigene Referenz übergeben.
     */
    void neuAnmeldung() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Anmeldung.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        AnmeldungsController anmeldungsController = loader.getController();
        anmeldungsController.setMainRef(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * Es wird versucht den neuen Benutzer durch Aufruf der Methode
     * benutzerEintragen(benutzer)in die BenutzerVerwaltungAdmin
     * einzutragen.
     * @param benutzer
     */
    void neuerBenutzer(Benutzer benutzer) throws BenutzerExits {
        admin.benutzerEintragen(benutzer);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
        Parent root = null;

        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        LoginController loginController = loader.getController();
        loginController.setMainRef(this);

        Scene scene = new Scene(root);
        primaryStage.setTitle("Benutzerverwaltung");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    void benutzerLogin(Benutzer benutzer) throws BenutzerNotInList {
        if(admin.benutzerOk(benutzer)) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Anwendung.fxml"));
            Parent root = null;
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Scene scene = new Scene(root);
            primaryStage.setTitle("Benutzerverwaltung");
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.show();
            primaryStage.show();
        } else {
            throw new BenutzerNotInList("Benutzer existiert nicht");
        }
    }


}