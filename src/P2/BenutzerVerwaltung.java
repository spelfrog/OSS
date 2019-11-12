package P2;
/**
 * <p>Überschrift: Interface für Klassen, die Nutzer dses Systems darstellen</p>
 * <p>Definieren das Interface BenutzerVerwaltung, das die beiden Methoden
 * - void benutzerEintragen(Benutzer benutzer) und
 * - boolean benutzerOk(Benutzer benutzer)
 * die allen Nutzern des Systems, insbesondere auch den späteren Clients, zur
 * Verfügung stehen, deklariert. </p>
 *
 * <p>Copyright: Constantin Kalversberg Copyright (c) 2019</p>
 * <p>Organisation: FH Aachen, FB05 </p>
 * @author Constantin Kalversberg
 * @version 1.0
 */
public interface BenutzerVerwaltung {
  /**
   * Das Parameterobjekt wird in eine Datenhaltung eingetragen.
   * @param benutzer Benutzer, der eingetragen werden soll
   * @throws BenutzerExits
   */
  void benutzerEintragen(Benutzer benutzer) throws BenutzerExits;

  /**
   * Liefert true, falls das Parameterobjekt in der Datenhaltung vorhanden ist,
   * sonst false.
   * @param benutzer Benutzer der überprüft werden soll
   */
  boolean benutzerOk(Benutzer benutzer);
}
