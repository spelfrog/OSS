package P2;

public class Benutzer {
  public String userId;
  public char[] passWort;

  public Benutzer()  {
    this.userId = "";
    this.passWort = new char[15];
  }

  public Benutzer(String userId, char[] passWort) {
    this.userId = userId;
    this.passWort = passWort;
  }

  //Überprüfe ob obj ein Benutzer Objekt ist wenn ja dann prüfe ob die daten gleich sind
  @Override
  public boolean equals(Object obj) {
    if(obj instanceof Benutzer)  {
      Benutzer copyBenutzer = (Benutzer) obj;
      return this.userId.equals(copyBenutzer.userId) && String.copyValueOf(this.passWort).equals(String.copyValueOf(copyBenutzer.passWort));
    }  else  {
      return false;
    }
  }

  public String toString()  {
    return "UserID " + this.userId + " \nPasswort: " + String.copyValueOf(this.passWort);
  }
}
