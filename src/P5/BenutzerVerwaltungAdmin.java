package P5;

import java.io.*;
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
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

  private ArrayList<Benutzer> users;

  public void benutzerEintragen(Benutzer benutzer)  throws BenutzerExits {
    dbLesen();
    if(benutzerOk(benutzer))  {
      throw new BenutzerExits("Benutzer bereits Vorhanden");
    }  else  {
      users.add(benutzer);
      dbSchreiben();
    }
  }

  public boolean benutzerOk(Benutzer benutzer)  {
    dbLesen();
    return users.contains(benutzer);
  }

  /*
   * Das Parameterobjekt wird aus der Datenhaltung entfernt
   * @param benutzer Wird aus der Datenhaltung entferntF
   * @throws BenutzerNotInList
   */
  public void benutzerLoeschen(Benutzer benutzer) throws BenutzerNotInList {
    dbLesen();
    if(!benutzerOk(benutzer))  {
      throw new BenutzerNotInList("Zu entfernenden Benutzer gibt es nicht");
    }  else  {
      users.remove(benutzer);
      dbSchreiben();
    }
  }

  /*
   * legt leeres Objekt in Datenstruktur
   *an und serialisiert es
   */
  public void dbInitialisieren()  {
    users = new ArrayList<>();
    dbSchreiben();
  }

  /**
   * schreibt daten in die Datenbank
   */
  private void dbSchreiben()  {
    try  {
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("db"));
      out.writeObject(users);
      out.close();
    }  catch (Exception e) {
      System.out.println(e);
    }
  }

  /**
   * Lädt daten aus der datenbank oder erstellt eine neue, wenn kein passendes objekt in dieser gefunden wurde
   */

  private void dbLesen()  {
    try {
      try  {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("db"));
        users = (ArrayList<Benutzer>)in.readObject();
        in.close();
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (ClassNotFoundException e) {
      dbSchreiben();
    }
  }

  public void deleteAll()  {
    users.clear();
    dbSchreiben();
  }

  public String toString() {
    String rückgabe ="";
    for (Benutzer benutzer: users) {
      rückgabe +=benutzer.toString();

    }
    return rückgabe;
  }
}
