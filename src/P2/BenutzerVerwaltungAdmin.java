package P2;

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

  private ArrayList<Benutzer> users = new ArrayList<>();

  public void benutzerEintragen(Benutzer benutzer)  throws BenutzerExits  {
    if(!benutzerOk(benutzer)) {
      users.add(benutzer);
    }  else {
      throw new BenutzerExits("Benutzer bereits Vorhanden");
      }
  }

  public boolean benutzerOk(Benutzer benutzer)  {
    return users.contains(benutzer);
  }

  /**
   * Das Parameterobjekt wird aus der Datenhaltung entfernt
   * @param benutzer Wird aus der Datenhaltung entfernt
   * @throws BenutzerNotInList
   */
  public void benutzerLoeschen(Benutzer benutzer) throws BenutzerNotInList  {
    if(benutzerOk(benutzer))  {
      users.remove(benutzer);
    } else  {
      throw new BenutzerNotInList("Zu entfernenden Benutzer gibt es nicht");
    }
  }
}
