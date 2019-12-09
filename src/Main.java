import P1.*;
import P2.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * <p>Überschrift: Main methode u. Testfälle</p>
 * <p>Startet das Programm und enthält Testfälle</p>
 *
 * <p>Copyright: Constantin Kalversberg Copyright (c) 2019</p>
 * <p>Organisation: FH Aachen, FB05 </p>
 * @author Constantin Kalversberg
 * @version 1.0
 */
public class Main extends Application {

  public static void main(String[] args) throws BenutzerExits {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root;
    //root = FXMLLoader.load(getClass().getResource("P4/Anwendung.fxml"));
    //root = FXMLLoader.load(getClass().getResource("P4/Login.fxml"));
    root = FXMLLoader.load(getClass().getResource("P4/Anmeldung.fxml"));
    Scene scene = new Scene(root);
    primaryStage.setTitle("Benutzerverwaltung");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private static void p2() {
    BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
    char[] password={'A','B','C'};

    Benutzer user1 = new Benutzer("B1", password);
    System.out.println(user1);
    Benutzer user2 = new Benutzer("B2", password);
    System.out.println(user2);
    System.out.println("User 1 und User 2 gleich? "+ user1.equals(user2));
    System.out.println();

    System.out.println("Leerer User");
    Benutzer user3 = new Benutzer();
    System.out.println(user3);
    System.out.println();

    System.out.println("User 1 hinzufügen");
    try  {
      admin.benutzerEintragen(user1);
      System.out.println("User 1 hinzugefuegt");
    }  catch (BenutzerExits e) {
      System.out.println(e);
    }
    System.out.println();

    System.out.println("User 2 hinzufügen");
    try  {
      admin.benutzerEintragen(user2);
      System.out.println("User 2 hinzugefuegt");
    }  catch (BenutzerExits e) {
      System.out.println(e);
    }
    System.out.println();

    System.out.println("User 1 erneut hinzufügen");
    try  {
      admin.benutzerEintragen(user1);
      System.out.println("User 1 hinzugefuegt");
    }  catch (BenutzerExits e) {
      System.out.println(e);
    }
    System.out.println();

    System.out.println("User 1 loeschen");
    try {
      admin.benutzerLoeschen(user1);
      System.out.println("User 1 geloescht");
    } catch (BenutzerNotInList e) {
      System.out.println(e);
    }
    System.out.println();

    System.out.println("User 1 erneut loeschen");
    try {
      admin.benutzerLoeschen(user1);
      System.out.println("User 1 geloescht");
    } catch (BenutzerNotInList e) {
      System.out.println(e);
    }
  }

  // erzeugt ein Pascal’sches Dreieck der tieft depth
  private static void p1aufgabe1() {
    final int depth = 10;
    int[][] pd = new int[depth][];
    for (int r = 0; r < depth; r++) {
      pd[r] = new int[r + 1];
      pd[r][0] = 1;
      pd[r][r] =1;
      for (int c = 1; c < r; c++) {
        pd[r][c] = pd[r - 1][c - 1] + pd[r - 1][c];
      }
    }

    for (int r = 0; r < depth; r++) {
      for (int c = 0; c <= r; c++) {
        System.out.print(pd[r][c] + " ");
      }
      System.out.println();
    }
  }

  //tests für die Aufgabe 2
  private static void p1aufgabe2() {
    KreisVererb k = new KreisVererb(1,2,3);
    System.out.println(k);
    k.move(5,5);
    System.out.println(k);
    KreisVererb k2 = new KreisVererb(6,7,3);
    System.out.println(k.equals(k2));
    Point p1 = new Point(0, 10);
    System.out.println(p1);
    p1.move(5, 5);
    System.out.println(p1);
    p1.setLocation(99, 15);
    System.out.println(p1);
    Point p2 = p1.getLocation();
    System.out.println(p2);
    System.out.println(p1.equals(p2));
    p2.move(1, 1);
    System.out.println(p2);

  }

  //erzeugt ein Array gefüllt mir 4 Formen und berechnet den gesamten Flächeninhalt
  public static void p1aufgabe3() {
    Form[] fs = new Form[4];
    fs[0] = new Rechteck(5, 5);
    fs[1] = new Rechteck(3, 3);
    fs[2] = new KreisAgg(1, 1, 1);
    fs[3] = new KreisAgg(1, 1, 1);
    double sum = 0;
    for (Form f : fs) {
      System.out.println(f);
      sum += f.flaechenInhalt();
    }
    System.out.printf("Gesamt Fläche: %.2f\n ", sum);
  }

}
