package P5.prak4client;

import P5.prak4gemklassen.*;

import java.util.ArrayList;

/**
 * <p>Überschrift:Admin Klasse zur Datenverwaltung</p>
 * <p>Ermöglicht das anlegen, überprüfen und löschen von Nutzern und speichert diese in einem Array</p>
 *
 * <p>Copyright: Constantin Kalversberg Copyright (c) 2019</p>
 * <p>Organisation: FH Aachen, FB05 </p>
 * @author Constantin Kalversberg
 * @version 1.0
 */
public class BenutzerVerwaltungAdmin extends Client implements BenutzerVerwaltung {

  private ArrayList<Benutzer> users;

  public BenutzerVerwaltungAdmin(String adresse) {
    super(adresse);
  }

  public String toString() {
    String rückgabe ="";
    for (Benutzer benutzer: users) {
      rückgabe +=benutzer.toString();

    }
    return rückgabe;
  }
}
