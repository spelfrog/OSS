package P5.prak4client;

import P5.prak4gemklassen.*;
import P5.prak4client.BenutzerVerwaltungAdmin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BenutzerVerwaltungAdminTest {
    BenutzerVerwaltungAdmin admin;
    Benutzer user, user2;
    @Before
    public void setUp() {
        admin = new BenutzerVerwaltungAdmin();
        admin.dbInitialisieren();

        user = new Benutzer("peter", "123".toCharArray());
        user2= new Benutzer("peter1", "123".toCharArray());
    }


    /**
     * Check ob der Benutzer richtig eingetragen wird. Hierzu Trage die nutzer zweimal ein die Methode fail() beendet den Test ohne Meldung dazu habe ich e.getMessage()
     */
    @Test
    public void benutzerEintragen() {
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
        assertFalse(admin.benutzerOk(user));
        try {
            admin.benutzerEintragen(user);
        } catch (BenutzerExits benutzerExits) {
            benutzerExits.printStackTrace();
            fail();
        }
        assertTrue(admin.benutzerOk(user));
        assertFalse(admin.benutzerOk(user2));
    }


    /**
     * Prüft ob Benutzer richtig gelöscht werden
     */
    @Test
    public void benutzerLoeschen()  {
        try {
            admin.benutzerLoeschen(user);
            fail("Muss BenutzerNotInList werfen");
        } catch (BenutzerNotInList e) {
            e.printStackTrace();
        }
        try {
            admin.benutzerEintragen(user);
        } catch (BenutzerExits benutzerExits) {
            benutzerExits.printStackTrace();
        }
        try {
            admin.benutzerLoeschen(user);
        } catch (BenutzerNotInList benutzerNotInList) {
            benutzerNotInList.printStackTrace();
            fail();
        }
    }

    @Test
    public void serialisieren()  {
        try {
            admin.benutzerEintragen(user);
            admin.benutzerEintragen(user2);
        } catch (BenutzerExits benutzerExits) {
            benutzerExits.printStackTrace();
            fail();
        }
        BenutzerVerwaltungAdmin admin2 = new BenutzerVerwaltungAdmin();
        assertTrue(admin2.benutzerOk(user));
        assertTrue(admin2.benutzerOk(user2));
    }
}