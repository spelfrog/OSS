package P5.prak4gemklassen;
/**
 * <p>Überschrift: Exception für das unerwartete Existieren eines Nutzters</p>
 *
 * <p>Copyright: Constantin Kalversberg Copyright (c) 2019</p>
 * <p>Organisation: FH Aachen, FB05 </p>
 * @author Constantin Kalversberg
 * @version 1.0
 */
public class BenutzerExits extends Exception {
    /**
     * Constructs an instance of <code>BenutzerExits</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public BenutzerExits(String msg) {
        super(msg);
    }
}



