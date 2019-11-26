package P3;

import P2.Benutzer;
import P2.BenutzerExits;
import P2.BenutzerNotInList;
import P2.BenutzerVerwaltungAdmin;
import org.junit.Test;
import static org.junit.Assert.*;

public class BenutzerVerwaltungAdminTest {

    /**
     * Check ob der Benutzer richtig eingetragen wird. Hierzu Trage die nutzer zweimal ein die Methode fail() beendet den Test ohne Meldung dazu habe ich e.getMessage()
     */
    @Test
    public void benutzerEintragen() {
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
        admin.dbInitialisieren();
        Benutzer user = new Benutzer("peter", "123".toCharArray());
        Benutzer user2= new Benutzer("peter1", "123".toCharArray());
        try {
            admin.benutzerEintragen(user);
        } catch (BenutzerExits e) {
            e.printStackTrace();
            fail();
        }
        try {
            admin.benutzerEintragen(user2);
        } catch (BenutzerExits e) {
            e.printStackTrace();
            fail();
        }
        try {
            admin.benutzerEintragen(user);
            fail();
        } catch (BenutzerExits e) {
            e.printStackTrace();
        }
        try {
            admin.benutzerEintragen(user2);
            fail();
        } catch (BenutzerExits e) {
            e.printStackTrace();
        }
    }


    /**
     * Prüft ob der Benutzer in der Liste bereits vorhanden ist.
     */
    @Test
    public void benutzerOk() {
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
        admin.dbInitialisieren();
        admin.deleteAll();
        assertFalse(admin.benutzerOk(new Benutzer("peter","123".toCharArray())));
        try {
            admin.benutzerEintragen(new Benutzer("peter","123".toCharArray()));
        } catch (BenutzerExits benutzerExits) {
            benutzerExits.printStackTrace();
            fail();
        }
        assertTrue(admin.benutzerOk(new Benutzer("peter","123".toCharArray())));
        assertFalse(admin.benutzerOk(new Benutzer("peter1","123".toCharArray())));
    }


    /**
     * Prüft ob Benutzer richtig gelöscht werden
     */
    @Test
    public void benutzerLoeschen()  {
        BenutzerVerwaltungAdmin admin = new BenutzerVerwaltungAdmin();
        admin.dbInitialisieren();
        admin.deleteAll();
        Benutzer peter = new Benutzer("peter", "123".toCharArray());
        try {
            admin.benutzerLoeschen(peter);
            fail("Muss BenutzerNotInList werfen");
        } catch (BenutzerNotInList e) {
            e.printStackTrace();
        }
        try {
            admin.benutzerEintragen(peter);
        } catch (BenutzerExits benutzerExits) {
            benutzerExits.printStackTrace();
        }
        try {
            admin.benutzerLoeschen(peter);
        } catch (BenutzerNotInList benutzerNotInList) {
            benutzerNotInList.printStackTrace();
        }
    }
}