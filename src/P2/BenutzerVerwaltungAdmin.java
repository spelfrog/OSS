package P2;

import java.util.ArrayList;

public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung {

  private ArrayList<Benutzer> users = new ArrayList<>();

  public void benutzerEintragen(Benutzer benutzer)  {
    users.add(benutzer);

  }

  public boolean benutzerOk(Benutzer benutzer)  {
    return users.contains(benutzer);
  }

  void benutzerLöschen(Benutzer benutzer)  {
    users.remove(benutzer);
  }
}
