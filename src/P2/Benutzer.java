package P2;
/**
 * <p>Überschrift: Struktur von Benutzern </p>
 * <p>Beschreibung: Diese Klasse definiert die grundlegende Struktur von
 * Benutzern.
 * Die Struktur eines Benutzers setzt sich zusammen aus:
 * - der UserId und
 * - dem Passwort
 * Da es nur um eine Struktur geht, werden lediglich die
 * beiden Standardmethoden equals und toString
 * implementiert.</p>
 *
 * <p>Copyright: Constantin Kalversberg Copyright (c) 2019</p>
 * <p>Organisation: FH Aachen, FB05 </p>
 * @author Constantin Kalversberg
 * @version 1.0
 */

public class Benutzer {
  public String userId;
  public char[] passWort;

  /**
   *Default Konstruktor erstelle ein Objekt mit namen "" und einem char Array mit 15 Plätzen
   */
  public Benutzer()  {
    this.userId = "";
    this.passWort = new char[15];
  }

  /**
   * konstruktor erstelle ein Objekt und setzte die Attribute
   * @param userId ist die UserID
   * @param passWort ist das Passwort
   */
  public Benutzer(String userId, char[] passWort) {
    this.userId = userId;
    this.passWort = passWort;
  }

  /**
   * Überprüfe ob obj ein Benutzer Objekt ist wenn ja dann prüfe ob die daten gleich sind
   * @param obj Objekt, dass auf gleichheit geprüft wird
   */
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Benutzer)  {
      Benutzer copyBenutzer = (Benutzer) obj;
      return this.userId.equals(copyBenutzer.userId) && String.copyValueOf(this.passWort).equals(String.copyValueOf(copyBenutzer.passWort));
    }  else  {
      return false;
    }
  }

  /**
   * Erstelle einen String als Rückgabe der die Attribute ausgibt
   */
  public String toString()  {
    return "UserID " + this.userId + " \nPasswort: " + String.copyValueOf(this.passWort);
  }
}
