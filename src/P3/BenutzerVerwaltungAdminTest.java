package P3;

import P2.Benutzer;
import P2.BenutzerExits;
import P2.BenutzerVerwaltungAdmin;
import org.junit.Test;
import static org.junit.Assert.*;

public class BenutzerVerwaltungAdminTest {

    /**
     * Check ob der Benutzer richtig eingetragen wird. Hierzu Trage die nutzer zweimal ein die Methode fail() beendet den Test ohne Meldung dazu habe ich e.getMessage()
     * @throws Exception
     */
    @Test
    public void benutzerEintragen() {
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();

        Benutzer user = new Benutzer("devran", "dev".toCharArray());
        Benutzer user2= new Benutzer("Andrei", "Warum".toCharArray());
        try {
            admin.benutzerEintragen(user);
        } catch (BenutzerExits e) {
            e.getMessage();

            fail();
        }
        try {
            admin.benutzerEintragen(user2);
        } catch (BenutzerExits e) {
            e.getMessage();
            fail();
        }
        try {
            admin.benutzerEintragen(user);
            fail();
        } catch (BenutzerExits e) {
            e.getMessage();

        }
        try {
            admin.benutzerEintragen(user2);
            fail();
        } catch (BenutzerExits e) {
            e.getMessage();

        }

    }

    @Test
    public void benutzerOk() {
    }

    @Test
    public void benutzerLoeschen() {
    }
}