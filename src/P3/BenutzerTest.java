package P3;

import P2.Benutzer;
import org.junit.Test;
import static org.junit.Assert.*;

public class BenutzerTest {

    /**
     * Test of equals method, of class Benutzer.
     */
    @Test
    public void testEquals() {
        String pass1="hallo";
        String pass2="Hallo";
        Benutzer user1= new Benutzer("User", pass1.toCharArray());
        Benutzer user2= new Benutzer("User", pass2.toCharArray());

        assertTrue(user1.equals(user1));
        assertFalse(user1.equals(user2));
    }

    /**
     * Test of toString method, of class Benutzer.
     */
    @Test
    public void testToString() {
        String pass= "Hallo";
        Benutzer user= new Benutzer("User", pass.toCharArray());
        assertEquals("UserID: User\nPasswort: Hallo", user.toString());
    }
}