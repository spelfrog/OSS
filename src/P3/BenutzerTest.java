package P3;

import P2.Benutzer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BenutzerTest {

    Benutzer user1, user2;

    /**
     * Initialisieren
     */
    @Before
    public void setUp() {
        String pass1="hallo";
        String pass2="Hallo";
        user1 = new Benutzer("User", pass1.toCharArray());
        user2 = new Benutzer("User", pass2.toCharArray());
    }


    /**
     * Test of equals method, of class Benutzer.
     */
    @Test
    public void testEquals() {
        assertTrue(user1.equals(user1));
        assertFalse(user1.equals(user2));
    }

    /**
     * Test of toString method, of class Benutzer.
     */
    @Test
    public void testToString() {
        assertEquals("UserID: User Passwort: hallo\n", user1.toString());
    }
}